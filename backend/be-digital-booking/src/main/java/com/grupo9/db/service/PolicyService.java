package com.grupo9.db.service;

import com.grupo9.db.dto.Policy.SavePolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.util.ResponsesBuilder;
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

        if(id != null){
            return new Policy(id, policyDto.getTitle());
        }

        return new Policy(id, policyDto.getTitle());
    }

}
