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

    public ResponseEntity<ApiResponse> findAll(){
        List<Product> products = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products);
    }

    public ResponseEntity<ApiResponse> findById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product successfully", product.get());
    }

    public ResponseEntity<ApiResponse> save(Product product){
        Product response = repository.save(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product created successfully", response);
    }

    public ResponseEntity<ApiResponse> update(Long id, Product product) throws ResourceNotFoundException, BadRequestException {
        product.setId(id);
        this.findById(product.getId());
        Product response = repository.save(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product updated successfully", response);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        this.findById(id);
        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.NO_CONTENT.value(),"Product deleted successfully", "");
    }

}
