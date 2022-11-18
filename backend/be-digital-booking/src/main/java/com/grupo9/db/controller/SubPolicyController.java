package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.service.SubPolicyService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subPolicies")
public class SubPolicyController {
    @Autowired
    private SubPolicyService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubPolicy>, Object>> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<SubPolicy, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        return service.findById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<SubPolicy, Object>> save(@Valid @RequestBody SubPolicy subPolicy){
        return service.save(subPolicy);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<SubPolicy, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SubPolicy subPolicy) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, subPolicy);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
