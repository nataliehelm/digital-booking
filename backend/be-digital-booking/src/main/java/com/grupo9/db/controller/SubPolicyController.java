package com.grupo9.db.controller;

import com.grupo9.db.dto.SubPolicy.SaveSubPolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.service.SubPolicyService;
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
@RequestMapping("/subPolicies")
public class SubPolicyController {
    @Autowired
    private SubPolicyService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubPolicy>, Object>> findAll(){
        List<SubPolicy> subPolicies = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get SubPolicy List successfully",subPolicies, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<SubPolicy, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        SubPolicy subPolicy = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get SubPolicy successfully", subPolicy, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<SubPolicy, Object>> save(@Valid @RequestBody SaveSubPolicyDto subPolicy) throws ResourceNotFoundException {
        SubPolicy response = service.save(subPolicy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"SubPolicy created successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<SubPolicy, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SaveSubPolicyDto subPolicy) throws ResourceNotFoundException, BadRequestException {
        SubPolicy response = service.update(id, subPolicy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"SubPolicy updated successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"SubPolicy deleted successfully", null, null);
    }

}
