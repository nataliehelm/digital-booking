package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.model.Feature;
import com.grupo9.db.service.CategoryService;
import com.grupo9.db.service.FeatureService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/features")
public class FeatureController {
    @Autowired
    private FeatureService service;

    @GetMapping
    public ResponseEntity<ApiResponse> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody Feature feature){
        return service.save(feature);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id,@Valid @RequestBody Feature feature) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, feature);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
