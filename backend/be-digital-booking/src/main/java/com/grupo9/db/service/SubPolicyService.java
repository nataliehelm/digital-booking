package com.grupo9.db.service;

import com.grupo9.db.dto.SubPolicy.SaveSubPolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.IProductRepository;
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
public class SubPolicyService {
    private final ISubPolicyRepository repository;
    private final IProductRepository productRepository;
    private final IPolicyRepository policyRepository;
    private ResponsesBuilder responsesBuilder;

    public SubPolicyService(ISubPolicyRepository repository, IProductRepository productRepository, IPolicyRepository policyRepository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.policyRepository = policyRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public List<SubPolicy> findAll(){
        List<SubPolicy> subPolicies = repository.findAll();
        return subPolicies;
    }

    public SubPolicy findById(Long id) throws ResourceNotFoundException {
        Optional<SubPolicy> subPolicy = repository.findById(id);
        if(subPolicy.isEmpty()){
            throw new ResourceNotFoundException("SubPolicy with id " + id + " not found");
        }

        return subPolicy.get();
    }

    public SubPolicy save(SaveSubPolicyDto subPolicyDto) throws ResourceNotFoundException {
        SubPolicy subPolicy = subPolicyBuilder(subPolicyDto, null);
        return repository.save(subPolicy);
    }

    public SubPolicy update(Long id, SaveSubPolicyDto subPolicyDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("SubPolicy with id " + id + " not found");
        }

        SubPolicy subPolicy = subPolicyBuilder(subPolicyDto, id);
        return repository.save(subPolicy);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("SubPolicy with id " + id + " not found");
        }

        repository.deleteById(id);
    }

    private SubPolicy subPolicyBuilder (SaveSubPolicyDto subPolicyDto, Long id) throws ResourceNotFoundException {

        Optional<Product> product = productRepository.findById(subPolicyDto.getProduct_id());
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + subPolicyDto.getProduct_id() + " not found");
        }
        Optional<Policy> policy = policyRepository.findById(subPolicyDto.getPolicy_id());
        if(policy.isEmpty()){
            throw new ResourceNotFoundException("Policy with id " + subPolicyDto.getPolicy_id() + " not found");
        }

        if(id != null){
            return new SubPolicy(id, subPolicyDto.getDescription(), product.get(), policy.get());
        }

        return new SubPolicy(subPolicyDto.getDescription(), product.get(), policy.get());
    }

}
