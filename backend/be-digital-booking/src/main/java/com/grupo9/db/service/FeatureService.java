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
    private final IFeatureRepository iFeatureRepository;
    private ResponsesBuilder responsesBuilder;

    public FeatureService(IFeatureRepository iFeatureRepository, ResponsesBuilder responsesBuilder) {
        this.iFeatureRepository = iFeatureRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse> findAll(){
        List<Feature> features = iFeatureRepository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Feature List successfully",features);
    }

    public ResponseEntity<ApiResponse> findById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Optional<Feature> feature = iFeatureRepository.findById(id);
        if(feature.isEmpty()){
            throw new ResourceNotFoundException("Feature with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Feature successfully", feature.get());
    }

    public ResponseEntity<ApiResponse> save(Feature feature){
        Feature response = iFeatureRepository.save(feature);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Feature created successfully", response);
    }

    public ResponseEntity<ApiResponse> update(Long id, Feature feature) throws ResourceNotFoundException, BadRequestException {
        feature.setId(id);
        this.findById(feature.getId());
        Feature response = iFeatureRepository.save(feature);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Feature updated successfully", response);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        this.findById(id);
        iFeatureRepository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.NO_CONTENT.value(),"Feature deleted successfully", "");
    }

}
