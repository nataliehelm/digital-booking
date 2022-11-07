package com.grupo9.db.service;

import com.grupo9.db.dto.Policy.SavePolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.ISubPolicyRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    private final IPolicyRepository repository;
    private final ISubPolicyRepository subPolicyRepository;
    private ResponsesBuilder responsesBuilder;

    public PolicyService(IPolicyRepository repository, ISubPolicyRepository subPolicyRepository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.subPolicyRepository = subPolicyRepository;
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

    public ResponseEntity<ApiResponse<Policy, Object>> save(SavePolicyDto policyDto) throws ResourceNotFoundException {
        List<SubPolicy> subPolicies = new ArrayList<>();
        for(Long id:policyDto.getSubPolicyIds()){
            Optional<SubPolicy> subPolicy = subPolicyRepository.findById(id);
            if(subPolicy.isEmpty()){
                throw new ResourceNotFoundException("Subpolicy with id " + id + " not found");
            }
            subPolicies.add(subPolicy.get());
        }
        Policy policy = new Policy(policyDto.getTitle(), subPolicies);
        Policy response = repository.save(policy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Policy created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Policy, Object>> update(Long id, SavePolicyDto policyDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        List<SubPolicy> subPolicies = new ArrayList<>();
        for(Long subPolicyId:policyDto.getSubPolicyIds()){
            Optional<SubPolicy> subPolicy = subPolicyRepository.findById(subPolicyId);
            if(subPolicy.isEmpty()){
                throw new ResourceNotFoundException("Subpolicy with id " + subPolicyId + " not found");
            }
            subPolicies.add(subPolicy.get());
        }

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }

        Policy policy = new Policy(id, policyDto.getTitle(), subPolicies);
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
