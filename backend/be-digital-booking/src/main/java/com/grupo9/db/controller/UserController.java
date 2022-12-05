package com.grupo9.db.controller;

import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.model.User;
import com.grupo9.db.service.SubPolicyService;
import com.grupo9.db.service.UserService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>, Object>> findAll() {
        List<User> users = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(), "Get Users List successfully", users, null);
    }

    @GetMapping(path = "/bookings/{id}")
    public ResponseEntity<ApiResponse<User, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        User user = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get User successfully", user, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Object, Object>> findAllBookingsByUserId(@PathVariable("id") Long id, @PageableDefault(size = 8) Pageable pageable) throws ResourceNotFoundException {
        Page<Booking> bookings = service.findAllBookingsByUserId(id, pageable);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get User List successfully", bookings, null);
    }

}