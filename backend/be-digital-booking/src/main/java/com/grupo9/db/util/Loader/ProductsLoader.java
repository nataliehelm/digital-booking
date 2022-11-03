package com.grupo9.db.util.Loader;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;
import com.grupo9.db.service.CategoryService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.*;

public class ProductsLoader {

    IProductRepository repository;

    ICategoryRepository categoryRepository;
    ILocationRepository locationRepository;
    IFeatureRepository featureRepository;

    public ProductsLoader(IProductRepository repository, ICategoryRepository categoryRepository, ILocationRepository locationRepository, IFeatureRepository featureRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.featureRepository = featureRepository;
    }

    public void Loader () {

        Category category = categoryRepository.findById(Long.valueOf(1)).get();
        Location location = locationRepository.findById(Long.valueOf(1)).get();
        Feature feature = featureRepository.findById(Long.valueOf(1)).get();

        List<String> cords = new ArrayList<>();

        cords.add("-10");
        cords.add("-10");

        Product product1 = new Product("Hermitage Hotel", category, location, "Buenos Aires, Ciudad Autónoma de Buenos Aires, Argentina", (ArrayList<String>) cords, '4');

        System.out.println(product1);
//        Product product1 = new Product("Hermitage Hotel", category.get(), location.get(), (Set) feature.get(), "Buenos Aires, Ciudad Autónoma de Buenos Aires, Argentina", (ArrayList<String>) cords, (char) 4);

        repository.save(product1);
    }
}
