package com.grupo9.db.controller;

import javax.validation.Valid;

import com.grupo9.db.dto.Auth.LoginDto;
import com.grupo9.db.dto.Auth.SignupDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.service.AuthService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/activate/{id}")
    public ResponseEntity<ApiResponse<?, Object>>  activateEmail(@PathVariable("id") String id) throws ResourceNotFoundException {
        return authService.activateEmail(id);
    }
}