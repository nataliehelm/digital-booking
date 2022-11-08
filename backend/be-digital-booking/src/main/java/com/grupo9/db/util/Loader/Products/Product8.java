package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product8 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public Product8(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader(){
        Location location4 = iLocationRepository.findById(Long.valueOf(4)).get();
        Category category4 = iCategoryRepository.findById(Long.valueOf(4)).get();
        Feature feature1 = iFeatureRepository.findById(Long.valueOf(1)).get();
        Feature feature2 = iFeatureRepository.findById(Long.valueOf(2)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);
        features.add(feature3);
        features.add(feature4);

        List coordinates = new ArrayList<>();

        coordinates.add(-32.48499756942883);
        coordinates.add(-58.22413741141344);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product3 = new Product("Parivar Host", "Cerca al centro de Concepcion", 4.2, 8F,"Alójate en el corazón de Buenos Aires","Está situado a solo unas calles de la avenida Alvear, de la avenida Quintana, del parque San Martín y del distrito de Recoleta. En las inmediaciones también hay varios lugares de interés, como la calle Florida, el centro comercial Galerías Pacífico, la zona de Puerto Madero, la plaza de Mayo y el palacio Municipal.\n\n Nuestros clientes dicen que esta parte de Buenos Aires es su favorita, según los comentarios independientes.\n\n El Hotel es un hotel sofisticado de 4 estrellas que goza de una ubicación tranquila, a poca distancia de prestigiosas galerías de arte, teatros, museos y zonas comerciales. Además, hay WiFi gratuita.\n El establecimiento sirve un desayuno variado de 07:00 a 10:30.", coordinates,category4, location4, features, policies);

        iProductRepository.save(product3);
    }

}
