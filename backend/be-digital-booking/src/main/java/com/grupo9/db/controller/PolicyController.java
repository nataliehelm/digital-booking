package com.grupo9.db.controller;

import com.grupo9.db.dto.Policy.SavePolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.service.PolicyService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {
    @Autowired
    private PolicyService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Policy>, Object>> findAll(){
        List<Policy> policies = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Policy List successfully",policies, null);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Policy, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        Policy policy = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Policy successfully", policy,  null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Policy, Object>> save(@Valid @RequestBody SavePolicyDto policy) throws ResourceNotFoundException {
        Policy response = service.save(policy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Policy created successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Policy, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SavePolicyDto policy) throws ResourceNotFoundException, BadRequestException {
        Policy response = service.update(id, policy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Policy updated successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Policy deleted successfully", null, null);

    }

}
