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

    public List<Policy> findAll(){
        List<Policy> policies = repository.findAll();
        return policies;
    }

    public Policy findById(Long id) throws ResourceNotFoundException {
        Optional<Policy> policy = repository.findById(id);
        if(policy.isEmpty()){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }
        return policy.get();
    }

    public Policy save(SavePolicyDto policyDto) throws ResourceNotFoundException {
        Policy policy = policyBuilding(policyDto, null);
        return repository.save(policy);
    }

    public Policy update(Long id, SavePolicyDto policyDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }

        Policy policy = policyBuilding(policyDto, id);
        return repository.save(policy);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }
        repository.deleteById(id);
    }

    private Policy policyBuilding (SavePolicyDto policyDto, Long id) throws ResourceNotFoundException {

        List<SubPolicy> subPolicies = new ArrayList<>();
        for(Long subPolicyId:policyDto.getSubPolicyIds()){
            Optional<SubPolicy> subPolicy = subPolicyRepository.findById(subPolicyId);
            if(subPolicy.isEmpty()){
                throw new ResourceNotFoundException("Subpolicy with id " + subPolicyId + " not found");
            }
            subPolicies.add(subPolicy.get());
        }

        if(id != null){
            return new Policy(id, policyDto.getTitle(), subPolicies);
        }

        return new Policy(policyDto.getTitle(), subPolicies);
    }

}
