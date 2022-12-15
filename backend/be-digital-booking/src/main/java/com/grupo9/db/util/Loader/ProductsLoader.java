package com.grupo9.db.util.Loader;

import com.grupo9.db.repository.*;
import com.grupo9.db.util.Loader.Products.*;


public class ProductsLoader {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public ProductsLoader(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader (){
        Product1 product1 = new Product1(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product1.Loader();
        Product2 product2 = new Product2(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product2.Loader();
        Product3 product3 = new Product3(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product3.Loader();
        Product4 product4 = new Product4(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product4.Loader();
        Product5 product5 = new Product5(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product5.Loader();
        Product6 product6 = new Product6(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product6.Loader();
        Product7 product7 = new Product7(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product7.Loader();
        Product8 product8 = new Product8(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product8.Loader();
        Product9 product9 = new Product9(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product9.Loader();
        Product10 product10 = new Product10(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product10.Loader();
        Product11 product11 = new Product11(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product11.Loader();
        Product12 product12 = new Product12(iProductRepository, iLocationRepository, iCategoryRepository, iFeatureRepository, iPolicyRepository, iUserRepository);
        product12.Loader();
    }
}
