package com.grupo9.db.service;

import com.grupo9.db.dto.Product.SaveProductDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final IProductRepository repository;
    private final ICategoryRepository categoryRepository;
    private final ILocationRepository locationRepository;
    private final IFeatureRepository featureRepository;
    private final IPolicyRepository policyRepository;
    private ResponsesBuilder responsesBuilder;

    public ProductService(IProductRepository repository, ICategoryRepository categoryRepository, ILocationRepository locationRepository, IFeatureRepository featureRepository, IPolicyRepository policyRepository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.featureRepository = featureRepository;
        this.policyRepository = policyRepository;
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

    public ResponseEntity<ApiResponse<Product, Object>> save(SaveProductDto productDto) throws ResourceNotFoundException {

        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if(category.isEmpty()){
            throw new ResourceNotFoundException("Category with id " + productDto.getCategoryId() + " not found");
        }
        Optional<Location> location = locationRepository.findById(productDto.getLocationId());
        if(location.isEmpty()){
            throw new ResourceNotFoundException("Location with id " + productDto.getLocationId() + " not found");
        }

        List<Feature> features = new ArrayList<>();
        for(Long id:productDto.getFeatureIds()){
            Optional<Feature> feature = featureRepository.findById(id);
            if(feature.isEmpty()){
                throw new ResourceNotFoundException("Feature with id " + id + " not found");
            }
            features.add(feature.get());
        }

        List<Policy> policies = new ArrayList<>();
        for(Long id:productDto.getPoliciyIds()){
            Optional<Policy> policy = policyRepository.findById(id);
            if(policy.isEmpty()){
                throw new ResourceNotFoundException("Policy with id " + id + " not found");
            }
            policies.add(policy.get());
        }

        Product product = new Product(productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), category.get(), location.get(), features, policies);
        Product response = repository.save(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Product, Object>> update(Long id, SaveProductDto productDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        Optional<Category> category = categoryRepository.findById(productDto.getCategoryId());
        if(category.isEmpty()){
            throw new ResourceNotFoundException("Category with id " + productDto.getCategoryId() + " not found");
        }
        Optional<Location> location = locationRepository.findById(productDto.getLocationId());
        if(location.isEmpty()){
            throw new ResourceNotFoundException("Location with id " + productDto.getLocationId() + " not found");
        }

        List<Feature> features = new ArrayList<>();
        for(Long featureId:productDto.getFeatureIds()){
            Optional<Feature> feature = featureRepository.findById(featureId);
            if(feature.isEmpty()){
                throw new ResourceNotFoundException("Feature with id " + featureId + " not found");
            }
            features.add(feature.get());
        }

        List<Policy> policies = new ArrayList<>();
        for(Long policyId:productDto.getPoliciyIds()){
            Optional<Policy> policy = policyRepository.findById(policyId);
            if(policy.isEmpty()){
                throw new ResourceNotFoundException("Policy with id " + policyId + " not found");
            }
            policies.add(policy.get());
        }

        Product product = new Product(id, productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), category.get(), location.get(), features, policies);
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
