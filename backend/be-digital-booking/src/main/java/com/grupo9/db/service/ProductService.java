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

import java.util.*;

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

    public List<Product> findAll(String token){
        if(token != null){
            List<Product> products = repository.findTop8ByOrderByIdAsc();
            return products;
        }
        List<Product> products = repository.findAllRandom();
            return products;
        }

    public Product findById(Long id) throws ResourceNotFoundException {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }
        return product.get();
    }

    public ResponseEntity<ApiResponse<List<Product>, Object>> findByParams(Map<String, String> params) throws ResourceNotFoundException, BadRequestException {
        if(params.get("locationId") != null && params.get("categoryId") != null){
            Long locationId = Long.valueOf(params.get("locationId"));
            Optional<Location> location = locationRepository.findById(locationId);
            if(location.isEmpty()){
                throw new ResourceNotFoundException("Location with id " + locationId + " not found");
            }
            String[] categoryIds = (params.get("categoryId")).split(",");
            List<Category> categories = new ArrayList<>();
            for (String id:categoryIds) {
                Optional<Category> category = categoryRepository.findById(Long.valueOf(id));
                if(category.isEmpty()){
                    throw new ResourceNotFoundException("Category with id " + id + " not found");
                }
                categories.add(category.get());
            }
            List<Product> products = repository.findTop8ByLocationAndCategoryIn(location.get(), categories);
            return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
        }
        if(params.get("categoryId") != null){
            String[] categoryIds = (params.get("categoryId")).split(",");
            List<Category> categories = new ArrayList<>();
            for (String id:categoryIds) {
                Optional<Category> category = categoryRepository.findById(Long.valueOf(id));
                if(category.isEmpty()){
                    throw new ResourceNotFoundException("Category with id " + id + " not found");
                }
                categories.add(category.get());
            }
            List<Product> products = repository.findTop8ByCategoryIn(categories);
            return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
        }
        if(params.get("locationId") != null){
            Long locationId = Long.valueOf(params.get("locationId"));
            Optional<Location> location = locationRepository.findById(locationId);
            if(location.isEmpty()){
                throw new ResourceNotFoundException("Location with id " + locationId + " not found");
            }
            List<Product> products = repository.findTop8ByLocation(location.get());
            return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
        }
        throw new BadRequestException("Invalid Params");
    }


    public Product save(SaveProductDto productDto) throws ResourceNotFoundException {
        Product product = productBuilder(productDto, null);
        return repository.save(product);
    }

    public Product update(Long id, SaveProductDto productDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        Product product = productBuilder(productDto, id);
        return repository.save(product);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        }

        repository.deleteById(id);
        }

    private Product productBuilder (SaveProductDto productDto, Long id) throws ResourceNotFoundException {


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

        if(id != null){
            return new Product(id, productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), category.get(), location.get(), features, policies);
        }

        return new Product(productDto.getName(), productDto.getDistance_to_nearest_tourist_site(), productDto.getRanking(), productDto.getScore(), productDto.getDescription_title(), productDto.getDescription(), productDto.getCoordinates(), category.get(), location.get(), features, policies);
    }

}
