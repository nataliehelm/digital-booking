package com.grupo9.db.util;

import com.grupo9.db.model.Category;
import com.grupo9.db.repository.*;
import com.grupo9.db.util.Loader.*;
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
    private IProductRepository iProductRepository;
    @Autowired
    private IFeatureRepository iFeatureRepository;
    @Autowired
    private IImageRepository iImageRepository;
    @Autowired
    private IPolicyRepository iPolicyRepository;
    @Autowired
    private ISubPolicyRepository iSubPolicyRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        SubPoliciesLoader subPoliciesLoader = new SubPoliciesLoader(iSubPolicyRepository);
        subPoliciesLoader.Loader();
        PoliciesLoader policiesLoader = new PoliciesLoader(iPolicyRepository, iSubPolicyRepository);
        policiesLoader.Loader();
        CategoriesLoader categoriesLoader = new CategoriesLoader(iCategoryRepository);
        categoriesLoader.Loader();
        LocationsLoader locationsLoader = new LocationsLoader(iLocationRepository);
        locationsLoader.Loader();
        FeaturesLoader featuresLoader = new FeaturesLoader(iFeatureRepository);
        featuresLoader.Loader();
        ProductsLoader productsLoader = new ProductsLoader(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository);
        productsLoader.Loader();
        ImagesLoader imagesLoader = new ImagesLoader(iImageRepository, iProductRepository);
        imagesLoader.Loader();
    }
}
