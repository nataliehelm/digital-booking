package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Category;
import com.grupo9.db.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>, Object>> findAll(){
        List <Category> categories = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Category List successfully",categories, null);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Category, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        Category category = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Category successfully", category, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Category, Object>> save(@Valid @RequestBody Category category){
        Category response = service.save(category);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Category created successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Category, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody Category category) throws ResourceNotFoundException, BadRequestException {
        Category response = service.update(id, category);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Category updated successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Category deleted successfully", null, null);

    }

}
