package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product10 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public Product10(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader(){
        Location location5 = iLocationRepository.findById(Long.valueOf(5)).get();
        Category category2 = iCategoryRepository.findById(Long.valueOf(2)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Feature feature10 = iFeatureRepository.findById(Long.valueOf(10)).get();
        Feature feature11 = iFeatureRepository.findById(Long.valueOf(11)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        List features2 = new ArrayList<>();

        features2.add(feature4);
        features2.add(feature10);
        features2.add(feature11);

        List coordinates2 = new ArrayList<>();

        coordinates2.add(-50.33664055279568);
        coordinates2.add(-72.2629555017608);


        Product product10 = new Product("Hostel Danny", "A  200 m del centro", 0.0F, 0.0F,"Puedes cancelar más tarde. Aprovecha y consigue un buen precio hoy.", "El Hostel Danny ofrece alojamiento con WiFi gratuita en todas las instalaciones en El Calafate, a 5 km del lago Argentino y a 800 metros del Museo Regional. El establecimiento está a 1,6 km de la estación de autobuses de El Calafate, a 2,2 km de la laguna de Nimez y a 8,8 km de la isla Solitaria. Hay servicio de conserjería, mostrador de información turística y servicio de cambio de divisa.", coordinates2, category2 , location5, "Gobernador Gregores 989", features2, user );

        iProductRepository.save(product10);
    }

}
