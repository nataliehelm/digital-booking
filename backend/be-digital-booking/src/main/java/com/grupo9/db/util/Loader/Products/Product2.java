package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product2 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public Product2(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
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
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        List features = new ArrayList<>();

        features.add(feature4);
        features.add(feature3);

        List coordinates = new ArrayList<>();

        coordinates.add(-49.330412);
        coordinates.add(-72.888143);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product2 = new Product("Chalten Suites Hostel", "A 100 m de la plaza principal", 4.0F, 9.0F,"Este hotel se encuentra en la mejor zona de El Chaltén y tiene un puntaje excelente por la ubicación.","Este alojamiento se encuentra en El Chalten, a 100 metros de la plaza principal. Ofrece habitaciones acogedoras y elegantes y conexión wifi gratis. El Chalten Suites tiene una zona de desayunos amplia, con muchas ventanas y vistas al jardín y las montañas de los alrededores.\n\nEl Chalten Suites Hotel dispone de habitaciones con TV y minibar. El baño privado incluye ducha y secador de pelo. Todas tienen escritorio.\n\nEl Chalten Suite cuenta con mostrador de información turística y consigna de equipaje.\n\nEl alojamiento cuenta con estacionamiento gratuito. Está a 200 metros del río Fitz Roy y a 210 km del aeropuerto de El Calafate.\n\nNuestros clientes dicen que esta parte de El Chaltén es su favorita, según los comentarios independientes.\n\nA las parejas les gusta la ubicación. Le pusieron un puntaje de 9,6 para un viaje de a dos.", coordinates,category2, location5, "Chalten Suites Hostel", features, policies, user);

        iProductRepository.save(product2);
    }

}
