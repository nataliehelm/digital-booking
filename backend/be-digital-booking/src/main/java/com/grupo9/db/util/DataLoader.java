package com.grupo9.db.util;

import com.grupo9.db.model.Category;
import com.grupo9.db.repository.ICategoryRepository;
import com.grupo9.db.repository.IFeatureRepository;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.util.Loader.CategoriesLoader;
import com.grupo9.db.util.Loader.FeaturesLoader;
import com.grupo9.db.util.Loader.LocationsLoader;
import com.grupo9.db.util.Loader.ProductsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private ILocationRepository iLocationRepository;
    @Autowired
    private IFeatureRepository iFeatureRepository;
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        CategoriesLoader categoriesLoader = new CategoriesLoader(iCategoryRepository);
        categoriesLoader.Loader();
        LocationsLoader locationsLoader = new LocationsLoader(iLocationRepository);
        locationsLoader.Loader();
        FeaturesLoader featuresLoader = new FeaturesLoader(iFeatureRepository);
        featuresLoader.Loader();
        ProductsLoader productsLoader = new ProductsLoader(iProductRepository, iCategoryRepository, iLocationRepository, iFeatureRepository);
        productsLoader.Loader();

    }
}
