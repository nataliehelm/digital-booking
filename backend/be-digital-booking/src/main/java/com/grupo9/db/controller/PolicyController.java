package com.grupo9.db.controller;

import com.grupo9.db.dto.Policy.SavePolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.service.PolicyService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Policy>, Object>> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Policy, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Policy, Object>> save(@Valid @RequestBody SavePolicyDto policy) throws ResourceNotFoundException {
        return service.save(policy);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Policy, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SavePolicyDto policy) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, policy);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
