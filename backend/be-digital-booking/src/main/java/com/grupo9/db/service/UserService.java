package com.grupo9.db.service;

import com.grupo9.db.dto.Bookings.SaveBookingDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
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

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) throws ResourceNotFoundException {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + id + " not found");
        }
        return user.get();
    }

    public List<Product> findAllProductsByUserId(Long userId) throws ResourceNotFoundException {
        List<Product> products = repository.findProductsByUserId(userId);
        return products;
    }
}
