package com.grupo9.db.controller;

import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.model.User;
import com.grupo9.db.service.SubPolicyService;
import com.grupo9.db.service.UserService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>, Object>> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<User, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return service.findById(id);
    }
}