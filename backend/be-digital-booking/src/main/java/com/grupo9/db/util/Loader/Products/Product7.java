package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product7 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public Product7(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader(){
        Location location14 = iLocationRepository.findById(Long.valueOf(14)).get();
        Category category2 = iCategoryRepository.findById(Long.valueOf(2)).get();
        Feature feature1 = iFeatureRepository.findById(Long.valueOf(1)).get();
        Feature feature2 = iFeatureRepository.findById(Long.valueOf(2)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);
        features.add(feature3);
        features.add(feature4);

        List coordinates = new ArrayList<>();

        coordinates.add(-27.4680280084071);
        coordinates.add(-58.83125194016978);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product3 = new Product("Corrientes Plaza Hostel", "A 450 metros del centro", 3.9, 7F,"Todo Corrientes cerca a ti","El Corrientes Plaza Hotel se encuentra en el centro de Corrientes y dispone de jardín con piscina, centro de fitness y habitaciones elegantes con WiFi gratuita. El desayuno está incluido en la tarifa. El establecimiento está a 2 km de un paseo que discurre junto al río.\n\n Las habitaciones del Corrientes Plaza están totalmente enmoquetadas y decoradas con colores suaves. Todas ellas cuentan con televisión por cable, aire acondicionado y calefacción. Algunas incluyen balcón privado con vistas al jardín.\n\n El Corrientes Plaza Hotel se encuentra a 5 km de la estación de autobuses y a 10 km del aeropuerto Piragine Niveyro.", coordinates,category2, location14, "Junin 1549",features, policies, user);

        iProductRepository.save(product3);
    }

}
