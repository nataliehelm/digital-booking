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
    IUserRepository iUserRepository;

    public Product8(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
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
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);
        features.add(feature3);
        features.add(feature4);

        List coordinates = new ArrayList<>();

        coordinates.add(-32.48499756942883);
        coordinates.add(-58.22413741141344);


        Product product3 = new Product("Paarivar Host", "A menos de 1 km de Concepci??n del Uruguay", 4.2, 8F,"Cerca al centro de Concepcion","El Parivaar Host se encuentra en Concepci??n del Uruguay, a 35 km del Palacio San Jos??, y ofrece alojamiento con piscina exterior de temporada, aparcamiento privado, bar y jard??n. Ofrece habitaciones familiares y parque infantil. Ofrece conexi??n WiFi gratuita y cocina compartida.\n\n Algunos alojamientos tienen vistas a la piscina. Las habitaciones cuentan con ba??o compartido y armario. Todas las habitaciones incluyen ropa de cama.\n\n El Parivaar Host se encuentra a 45 km de la estaci??n de autobuses de Col??n y a menos de 1 km de Concepci??n del Uruguay.  ", coordinates,category4, location4, "Virrey V??rtiz 128", features, user);

        iProductRepository.save(product3);
    }

}
