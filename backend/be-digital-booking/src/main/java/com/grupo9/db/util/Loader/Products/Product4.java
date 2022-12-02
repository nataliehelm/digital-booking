package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product4 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public Product4(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader(){
        Location location19 = iLocationRepository.findById(Long.valueOf(19)).get();
        Category category4 = iCategoryRepository.findById(Long.valueOf(4)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Policy policy4 = iPolicyRepository.findById(Long.valueOf(4)).get();
        Policy policy5 = iPolicyRepository.findById(Long.valueOf(5)).get();

        List features = new ArrayList<>();

        features.add(feature3);
        features.add(feature4);

        List coordinates = new ArrayList<>();

        coordinates.add(-27.4403384);
        coordinates.add(-59.0068717);

        List policies = new ArrayList<>();

        policies.add(policy4);
        policies.add(policy5);

        Product product3 = new Product("Uriburu B&B", "A 2.2 km de Resistencia", 0F, 8.9,"Habitación completamente euipada con baño privado, ubicado a 6 minutos de la plaza central de Resistencia. Hermoso barrio, cercano a mercaos, clubes, zona comercial.","El Uriburu B&B se encuentra a 3,2 km de Resistencia y ofrece alojamiento con WiFi gratuita y aparcamiento privado gratuito.\n\nEste bed and breakfast sirve un desayuno buffet diario.\n\nEl Uriburu B&B está a 5,3 km de Fontana y a 6,7 km de Resistencia. El aeropuerto internacional de Resistencia es el más cercano y queda a 7 km.\n\nA las parejas les encanta la ubicación. Le pusieron un 8.8 para viajes de dos personas.", coordinates,category4, location19, "Uriburu 343", features, policies);

        iProductRepository.save(product3);
    }

}
