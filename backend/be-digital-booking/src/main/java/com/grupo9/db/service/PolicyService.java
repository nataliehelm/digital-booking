package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.ISubPolicyRepository;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.stereotype.Service;

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

    public Policy save(Policy policy) throws ResourceNotFoundException {
         return repository.save(policy);
    }

    public Policy update(Long id, Policy policy) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Policy with id " + id + " not found");
        }
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

  }
