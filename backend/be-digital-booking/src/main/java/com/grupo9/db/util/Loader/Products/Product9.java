package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product9 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public Product9(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader(){
        Location location2 = iLocationRepository.findById(Long.valueOf(2)).get();
        Category category1 = iCategoryRepository.findById(Long.valueOf(1)).get();
        Feature feature7 = iFeatureRepository.findById(Long.valueOf(7)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Feature feature8 = iFeatureRepository.findById(Long.valueOf(8)).get();
        Feature feature9 = iFeatureRepository.findById(Long.valueOf(9)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        List features1 = new ArrayList<>();

        features1.add(feature7);
        features1.add(feature3);
        features1.add(feature4);
        features1.add(feature8);
        features1.add(feature9);

        List coordinates1 = new ArrayList<>();

        coordinates1.add(-38.957918522737856);
        coordinates1.add(-68.11447964631512);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product9 = new Product("Hotel Casino Magic", "A 4,8 km del centro", 5.0F, 9.0F, "Descubre cómo se sienten las estrellas con el mejor servicio en el Hotel Casino Magic", "El Hotel Casino Magic de Neuquén cuenta con una elegante entrada con arcos y un patio interior con pilares en torno a una piscina al aire libre alargada, y también dispone de spa, casino y conexión Wi-Fi gratuita. El Museo Nacional de Bellas Artes está a 4 km.", coordinates1, category1, location2 , "Planas 4005",features1, policies, user );

        iProductRepository.save(product9);
    }

}
