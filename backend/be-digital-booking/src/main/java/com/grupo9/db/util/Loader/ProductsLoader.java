package com.grupo9.db.util.Loader;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class ProductsLoader {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public ProductsLoader(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader (){

        Location location1 = iLocationRepository.findById(Long.valueOf(1)).get();
        Category category1 = iCategoryRepository.findById(Long.valueOf(1)).get();
        Feature feature1 = iFeatureRepository.findById(Long.valueOf(1)).get();
        Feature feature2 = iFeatureRepository.findById(Long.valueOf(2)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);

        List coordinates = new ArrayList<>();

        coordinates.add(-34.5828949);
        coordinates.add(-58.4240502);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product1 = new Product("Hermitage Hotel", "A 940 m del centro", 4.0F, 8.0F, "Alójate en el corazón de Buenos Aires" ,"Está situado a solo unas calles de la avenida Alvear, de la avenida Quintana, del parque San Martín y del distrito de Recoleta. En las inmediaciones también hay varios lugares de interés, como la calle Florida, el centro comercial Galerías Pacífico, la zona de Puerto Madero, la plaza de Mayo y el palacio Municipal.\n\n Nuestros clientes dicen que esta parte de Buenos Aires es su favorita, según los comentarios independientes.\n \n El Hotel es un hotel sofisticado de 4 estrellas que goza de una ubicación tranquila, a poca distancia de prestigiosas galerías de arte, teatros, museos y zonas comerciales. Además, hay WiFi gratuita.\n El establecimiento sirve un desayuno variado de 07:00 a 10:30.",coordinates,category1, location1, features, policies);

        iProductRepository.save(product1);
    }
}
