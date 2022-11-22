package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product12 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public Product12(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader(){
        Location location2 = iLocationRepository.findById(Long.valueOf(2)).get();
        Category category4= iCategoryRepository.findById(Long.valueOf(4)).get();
        Feature feature8 = iFeatureRepository.findById(Long.valueOf(8)).get();
        Feature feature10 = iFeatureRepository.findById(Long.valueOf(10)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();

        List features4 = new ArrayList<>();

        features4.add(feature10);
        features4.add(feature3);
        features4.add(feature4);
        features4.add(feature8);

        List coordinates4 = new ArrayList<>();

        coordinates4.add(-33.21144477804261);
        coordinates4.add(-66.22836017303051);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product12 = new Product("La Paula bed & breakfast", "A  14,2 km del centro", 4.0F, 8.0F, "Habitación Doble con vistas - 2 camas", "La Paula bed & breakfast se encuentra en San Luis, a 1,9 km del circuito internacional de Potrero de los Funes, y ofrece vistas a la montaña, WiFi gratuita y aparcamiento privado gratuito.\n\n El baño privado está totalmente equipado con ducha y artículos de aseo gratuitos.\n\n El hipódromo Rosendo Hernández se encuentra a 32 km del bed and breakfast, mientras que Potrero de los Funes está a 1 km. El aeropuerto Brigadier Mayor Cesar R. Ojeda es el más cercano y está a 21 km de La Paula bed & breakfast.", coordinates4, category4, location2, "Las Acacias", features4, policies );

        iProductRepository.save(product12);
    }

}
