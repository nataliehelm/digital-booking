package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.repository.ICategoryRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final ICategoryRepository iCategoryRepository;
    private ResponsesBuilder responsesBuilder;

    public CategoryService(ICategoryRepository iCategoryRepository, ResponsesBuilder responsesBuilder) {
        this.iCategoryRepository = iCategoryRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse> findAll(){
        List<Category> categories = iCategoryRepository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Category List successfully",categories);
    }

    public ResponseEntity<ApiResponse> findById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Optional<Category> category = iCategoryRepository.findById(id);
        if(category.isEmpty()){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Category successfully", category.get());
    }

    public ResponseEntity<ApiResponse> save(Category category){
        Category response = iCategoryRepository.save(category);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Category created successfully", category);
    }

    public ResponseEntity<ApiResponse> update(Long id, Category category) throws ResourceNotFoundException, BadRequestException {
        category.setId(id);
        this.findById(category.getId());
        Category response = iCategoryRepository.save(category);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Category updated successfully", category);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        this.findById(id);
        iCategoryRepository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.NO_CONTENT.value(),"Category deleted successfully", "");
    }

}
