package com.grupo9.db.service;

import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.User;
import com.grupo9.db.repository.IUserRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final IUserRepository repository;
    private ResponsesBuilder responsesBuilder;

    public UserService(IUserRepository repository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<User>, Object>> findAll() {
        List<User> users = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(), "Get Users List successfully", users, null);
    }

    public ResponseEntity<ApiResponse<User, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get User successfully", user.get(), null);
    }
}