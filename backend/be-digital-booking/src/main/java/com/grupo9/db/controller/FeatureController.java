package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Feature;
import com.grupo9.db.service.FeatureService;
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
@RequestMapping("/features")
public class FeatureController {
    @Autowired
    private FeatureService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Feature>, Object>> findAll(){
        List<Feature> features = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Feature List successfully",features, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Feature, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        Feature feature = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Feature successfully", feature, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Feature, Object>> save(@Valid @RequestBody Feature feature){
        Feature response = service.save(feature);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Feature created successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Feature, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody Feature feature) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, feature);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
