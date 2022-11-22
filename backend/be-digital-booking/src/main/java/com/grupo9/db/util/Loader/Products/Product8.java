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

        Product product3 = new Product("Paarivar Host", "A menos de 1 km de Concepción del Uruguay", 4.2, 8F,"Cerca al centro de Concepcion","El Parivaar Host se encuentra en Concepción del Uruguay, a 35 km del Palacio San José, y ofrece alojamiento con piscina exterior de temporada, aparcamiento privado, bar y jardín. Ofrece habitaciones familiares y parque infantil. Ofrece conexión WiFi gratuita y cocina compartida.\n\n Algunos alojamientos tienen vistas a la piscina. Las habitaciones cuentan con baño compartido y armario. Todas las habitaciones incluyen ropa de cama.\n\n El Parivaar Host se encuentra a 45 km de la estación de autobuses de Colón y a menos de 1 km de Concepción del Uruguay.  ", coordinates,category4, location4, "Virrey Vértiz 128", features, policies);

        iProductRepository.save(product3);
    }

}
