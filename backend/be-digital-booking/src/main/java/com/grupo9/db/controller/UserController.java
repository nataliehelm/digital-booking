package com.grupo9.db.controller;

import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.User;
import com.grupo9.db.service.UserService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>, Object>> findAll() {
        List<User> users = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(), "Get Users List successfully", users, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<User, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        User user = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get User successfully", user, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Object, Object>> findAllProductsByUserId(@PathVariable("id") Long id) throws ResourceNotFoundException {
        List<Product> products = service.findAllProductsByUserId(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get User List successfully", products, null);
    }
}