package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product5 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public Product5(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader(){
        Location location23 = iLocationRepository.findById(Long.valueOf(23)).get();
        Category category3 = iCategoryRepository.findById(Long.valueOf(3)).get();
        Feature feature1 = iFeatureRepository.findById(Long.valueOf(1)).get();
        Feature feature2 = iFeatureRepository.findById(Long.valueOf(2)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();
        User user = iUserRepository.findById(Long.valueOf(1)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);

        List coordinates = new ArrayList<>();

        coordinates.add(-34.5963378822292);
        coordinates.add(-58.39185763220208);

        Product product3 = new Product("Tpyn Recoleta", "A 1,2 km del centro", 4.8, 8.5,"Desde el centro de Buenos Aires para el mundo","El TPYN RECOLETA ofrece alojamiento con WiFi gratuita y balcón en el centro de Buenos Aires, a 1,2 km del teatro Colón y a 1,8 km del Obelisco de Buenos Aires.\n\n El alojamiento está equipado con aire acondicionado, cocina totalmente equipada, TV de pantalla plana y baño privado con bidet, secador de pelo y artículos de aseo gratuitos. Hay microondas, nevera, horno, hervidor de agua y cafetera.\n\n El Museo Nacional de Bellas Artes se encuentra a 1,8 km del apartamento, mientras que la basílica del Santísimo Sacramento está a 2,9 km. El aeropuerto más cercano es el aeropuerto Jorge Newbery, ubicado a 7 km del TPYN RECOLETA.", coordinates,category3, location23, "Rodríguez Peña 1061", features, user);

        iProductRepository.save(product3);
    }

}
