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
import com.grupo9.db.service.AuthService;
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
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<?, Object>> login(@Valid @RequestBody LoginDto loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<?, Object>>  signup(@Valid @RequestBody SignupDto signUpRequest) throws BadRequestException {
        return authService.signup(signUpRequest);
    }
}