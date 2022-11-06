package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Feature;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import com.grupo9.db.repository.ICategoryRepository;
import com.grupo9.db.repository.IFeatureRepository;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.repository.IProductRepository;

public class FeaturesLoader {

    IFeatureRepository iFeatureRepository;

    public FeaturesLoader(IFeatureRepository iFeatureRepository) {
        this.iFeatureRepository = iFeatureRepository;
    }

    public void Loader (){

        Feature feature1 = new Feature("Cocina", "fa-solid fa-kitchen-set");
        Feature feature2 = new Feature("Aire acondicionado", "fa-regular fa-snowflake");
        Feature feature3 = new Feature("Estacionamiento gratuito", "fa-solid fa-car");
        Feature feature4 = new Feature("Wifi", "fa-solid fa-wifi");
        Feature feature5 = new Feature("Televisor", "fa-solid fa-tv");
        Feature feature6 = new Feature("Apto mascotas", "fa-solid fa-paw");
        Feature feature7 = new Feature("Pileta", "fa-solid fa-person-swimming");

        iFeatureRepository.save(feature1);
        iFeatureRepository.save(feature2);
        iFeatureRepository.save(feature3);
        iFeatureRepository.save(feature4);
        iFeatureRepository.save(feature5);
        iFeatureRepository.save(feature6);
        iFeatureRepository.save(feature7);

    }
}
