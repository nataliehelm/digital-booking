package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.service.CategoryService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>, Object>> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Category, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category, Object>> save(@Valid @RequestBody Category category){
        return service.save(category);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Category, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody Category category) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, category);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
