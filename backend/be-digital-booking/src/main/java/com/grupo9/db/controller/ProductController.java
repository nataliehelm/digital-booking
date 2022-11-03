package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Image;
import com.grupo9.db.model.Product;
import com.grupo9.db.service.ImageService;
import com.grupo9.db.service.ProductService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<ApiResponse> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> findById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> save(@Valid @RequestBody Product product){
        return service.save(product);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id,@Valid @RequestBody Product product) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, product);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
