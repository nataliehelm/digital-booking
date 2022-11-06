package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Product;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final IProductRepository repository;
    private ResponsesBuilder responsesBuilder;

    public ProductService(IProductRepository repository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<Product>, Object>> findAll(){
        List<Product> products = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
    }

    public ResponseEntity<ApiResponse<Product, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product successfully", product.get(), null);
    }

    public ResponseEntity<ApiResponse<Product, Object>> save(Product product){
        Product response = repository.save(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Product, Object>> update(Long id, Product product) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        product.setId(id);
        Product response = repository.save(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product updated successfully", response, null);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Product deleted successfully", null, null);
    }

}
