package com.grupo9.db.controller;

import com.grupo9.db.dto.Product.SaveProductDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Product;
import com.grupo9.db.service.ProductService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>, Object>> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Product, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product, Object>> save(@Valid @RequestBody SaveProductDto product) throws ResourceNotFoundException {
        return service.save(product);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Product, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SaveProductDto product) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, product);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
