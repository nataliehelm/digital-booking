package com.grupo9.db.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.grupo9.db.dto.Auth.JwtResponse;
import com.grupo9.db.dto.Auth.LoginDto;
import com.grupo9.db.dto.Auth.MessageResponse;
import com.grupo9.db.dto.Auth.SignupDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.model.ERole;
import com.grupo9.db.model.Role;
import com.grupo9.db.model.User;
import com.grupo9.db.repository.IRoleRepository;
import com.grupo9.db.repository.IUserRepository;
import com.grupo9.db.security.jwt.JwtUtils;
import com.grupo9.db.security.services.UserDetailsImpl;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IRoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?, Object>> login(@Valid @RequestBody LoginDto loginRequest) {

        ResponsesBuilder responsesBuilder = new ResponsesBuilder();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"User login successfully", new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), roles), null);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<?, Object>>  signup(@Valid @RequestBody SignupDto signUpRequest) throws BadRequestException {
        ResponsesBuilder responsesBuilder = new ResponsesBuilder();

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Error: Email is already in use");
        }

        User user = new User(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();

        user.setRoles(role);
        userRepository.save(user);

        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"User registered successfully", null, null);
    }
}