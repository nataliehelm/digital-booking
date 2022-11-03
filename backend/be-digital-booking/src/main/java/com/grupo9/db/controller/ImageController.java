package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Image;
import com.grupo9.db.service.ImageService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService service;

    @GetMapping
    public ResponseEntity<ApiResponse> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody Image image){
        return service.save(image);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id,@Valid @RequestBody Image image) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, image);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
