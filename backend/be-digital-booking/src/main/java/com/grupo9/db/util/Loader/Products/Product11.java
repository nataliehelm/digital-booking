package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product11 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public Product11(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader(){
        Location location6 = iLocationRepository.findById(Long.valueOf(6)).get();
        Category category3 = iCategoryRepository.findById(Long.valueOf(3)).get();
        Feature feature7 = iFeatureRepository.findById(Long.valueOf(7)).get();
        Feature feature10 = iFeatureRepository.findById(Long.valueOf(10)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();

        List features3 = new ArrayList<>();

        features3.add(feature7);
        features3.add(feature10);
        features3.add(feature3);
        features3.add(feature4);

        List coordinates3 = new ArrayList<>();

        coordinates3.add(-41.16813961310178);
        coordinates3.add(-71.43951430203818);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product11 = new Product("Heaven Catedral", "A  11,5 km del centro", 4.0F, 8.5F, "Apartamento de 1 dormitorio", "El HEAVEN CATEDRAL se encuentra en San Carlos de Bariloche, a 18 km del centro cívico, y ofrece vistas a la piscina, WiFi gratuita y aparcamiento privado gratuito. El alojamiento cuenta con bañera de hidromasaje.\n\n Todos los alojamientos cuentan con zona de estar, sofá, TV de pantalla plana vía satélite y cocina totalmente equipada con zona de comedor. Hay microondas, nevera, horno, hervidor de agua y cafetera.\n\n Todas las mañanas se sirve un desayuno continental y a la carta.", coordinates3, category3, location6, "Punta Nevada 652", features3, policies);

        iProductRepository.save(product11);
    }

}
