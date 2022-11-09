package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.repository.ISubPolicyRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubPolicyService {
    private final ISubPolicyRepository repository;
    private ResponsesBuilder responsesBuilder;

    public SubPolicyService(ISubPolicyRepository repository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<SubPolicy>, Object>> findAll(){
        List<SubPolicy> subPolicies = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get SubPolicy List successfully",subPolicies, null);
    }

    public ResponseEntity<ApiResponse<SubPolicy, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<SubPolicy> subPolicy = repository.findById(id);
        if(subPolicy.isEmpty()){
            throw new ResourceNotFoundException("SubPolicy with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get SubPolicy successfully", subPolicy.get(), null);
    }

    public ResponseEntity<ApiResponse<SubPolicy, Object>> save(SubPolicy subPolicy){
        SubPolicy response = repository.save(subPolicy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"SubPolicy created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<SubPolicy, Object>> update(Long id, SubPolicy subPolicy) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("SubPolicy with id " + id + " not found");
        }

        subPolicy.setId(id);
        SubPolicy response = repository.save(subPolicy);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"SubPolicy updated successfully", response, null);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("SubPolicy with id " + id + " not found");
        }

        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"SubPolicy deleted successfully", null, null);
    }

}
