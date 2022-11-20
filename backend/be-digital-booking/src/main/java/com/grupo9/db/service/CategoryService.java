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

    public List<Category> findAll(){
        List<Category> categories = iCategoryRepository.findAll();
        return categories;
    }

    public Category findById(Long id) throws ResourceNotFoundException {
        Optional<Category> category = iCategoryRepository.findById(id);
        if(category.isEmpty()){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }
        return category.get();
    }

    public Category save(Category category){
        return iCategoryRepository.save(category);
    }

    public Category update(Long id, Category category) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = iCategoryRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }

        category.setId(id);
        return iCategoryRepository.save(category);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = iCategoryRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Category with id " + id + " not found");
        }

        iCategoryRepository.deleteById(id);
    }

}
