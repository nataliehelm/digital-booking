package com.grupo9.db.service;

import com.grupo9.db.dto.Auth.JwtResponse;
import com.grupo9.db.dto.Auth.LoginDto;
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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private AuthenticationManager authenticationManager;
    private ResponsesBuilder responsesBuilder;
    private JwtUtils jwtUtils;
    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private PasswordEncoder encoder;

    public AuthService(AuthenticationManager authenticationManager, ResponsesBuilder responsesBuilder, JwtUtils jwtUtils, IUserRepository userRepository, IRoleRepository roleRepository, PasswordEncoder encoder) {
        this.authenticationManager = authenticationManager;
        this.responsesBuilder = responsesBuilder;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    public ResponseEntity<ApiResponse<?, Object>>  login(LoginDto loginRequest){
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

    public ResponseEntity<ApiResponse<?, Object>>  signup(SignupDto signUpRequest) throws BadRequestException {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("El correo ya se encuentra registrado");
        }

        User user = new User(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();

        user.setRoles(role);
        userRepository.save(user);

        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"User registered successfully", "User registered successfully", null);
    }
}
