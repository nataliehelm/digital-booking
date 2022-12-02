package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product6 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public Product6(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader(){
        Location location24 = iLocationRepository.findById(Long.valueOf(24)).get();
        Category category1 = iCategoryRepository.findById(Long.valueOf(1)).get();
        Feature feature1 = iFeatureRepository.findById(Long.valueOf(1)).get();
        Feature feature2 = iFeatureRepository.findById(Long.valueOf(2)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Feature feature5 = iFeatureRepository.findById(Long.valueOf(5)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);
        features.add(feature3);
        features.add(feature4);
        features.add(feature5);

        List coordinates = new ArrayList<>();

        coordinates.add(-54.804290710042714);
        coordinates.add(-68.35730507941658);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product3 = new Product("Wyndham Garden Ushuaia Hotel del Glaciar", "A 3 KM del centro de Ushuaia", 4F, 7.9,"Despiertate con el glaciar","Este hotel está ubicado a los pies del glaciar Martial, a solo 3 km del centro de Ushuaia, y ofrece habitaciones con vistas al glaciar o a la bahía, WiFi pública gratuita y aparcamiento privado gratuito.\n\n Cada habitación del Hotel Del Glaciar es amplia y cuenta con ventanales y detalles en madera. Todos los alojamientos están equipados con TV y baño privado.\n\n El restaurante del establecimiento Del Glacier sirve platos internacionales y regionales. Los huéspedes pueden tomar un cóctel junto a la chimenea del vestíbulo del hotel. La recepción está disponible las 24 horas.", coordinates,category1, location24, "Luis Fernando Del Martial 2355",features, policies);

        iProductRepository.save(product3);
    }

}
