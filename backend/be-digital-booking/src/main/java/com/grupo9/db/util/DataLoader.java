package com.grupo9.db.util;

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
    @Autowired
    private IRoleRepository iRoleRepository;
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private  IBookingRepository iBookingRepository;

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
        RolesLoader rolesLoader = new RolesLoader(iRoleRepository);
        rolesLoader.Loader();
        UsersLoader usersLoader = new UsersLoader(iUserRepository, iRoleRepository, iLocationRepository);
        usersLoader.Loader();
        FeaturesLoader featuresLoader = new FeaturesLoader(iFeatureRepository);
        featuresLoader.Loader();
        ProductsLoader productsLoader = new ProductsLoader(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        productsLoader.Loader();
        ImagesLoader imagesLoader = new ImagesLoader(iImageRepository, iProductRepository);
        imagesLoader.Loader();
        BookingsLoader bookingsLoader = new BookingsLoader(iBookingRepository, iProductRepository, iUserRepository);
        bookingsLoader.Loader();
    }
}
