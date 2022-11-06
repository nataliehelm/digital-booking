package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Feature;
import com.grupo9.db.repository.IFeatureRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureService {
    private final IFeatureRepository repository;
    private ResponsesBuilder responsesBuilder;

    public FeatureService(IFeatureRepository repository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<Feature>, Object>> findAll(){
        List<Feature> features = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Feature List successfully",features, null);
    }

    public ResponseEntity<ApiResponse<Feature, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<Feature> feature = repository.findById(id);
        if(feature.isEmpty()){
            throw new ResourceNotFoundException("Feature with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Feature successfully", feature.get(), null);
    }

    public ResponseEntity<ApiResponse<Feature, Object>> save(Feature feature){
        Feature response = repository.save(feature);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Feature created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Feature, Object>> update(Long id, Feature feature) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Feature with id " + id + " not found");
        }

        feature.setId(id);
        Feature response = repository.save(feature);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Feature updated successfully", response, null);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Feature with id " + id + " not found");
        }

        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Feature deleted successfully", null, null);
    }

}
