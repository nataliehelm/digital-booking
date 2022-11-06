package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    private final IPolicyRepository repository;
    private ResponsesBuilder responsesBuilder;

    public PolicyService(IPolicyRepository repository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<Policy>, Object>> findAll(){
        List<Policy> policies = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Policy List successfully",policies, null);
    }

    public ResponseEntity<ApiResponse<Policy, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<Policy> policy = repository.findById(id);
        if(policy.isEmpty()){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Policy successfully", policy.get(), null);
    }

    public ResponseEntity<ApiResponse<Policy, Object>> save(Policy policy){
        Policy response = repository.save(policy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Policy created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Policy, Object>> update(Long id, Policy policy) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }

        policy.setId(id);
        Policy response = repository.save(policy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Policy updated successfully", response, null);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }

        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Policy deleted successfully", null, null);
    }

}
