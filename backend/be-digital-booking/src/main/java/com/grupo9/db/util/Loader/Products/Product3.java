package com.grupo9.db.util.Loader.Products;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class Product3 {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;
    IUserRepository iUserRepository;

    public Product3(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository, IUserRepository iUserRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iUserRepository = iUserRepository;
    }

    public void Loader(){
        Location location21 = iLocationRepository.findById(Long.valueOf(21)).get();
        Category category3 = iCategoryRepository.findById(Long.valueOf(3)).get();
        Feature feature7 = iFeatureRepository.findById(Long.valueOf(7)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Feature feature6 = iFeatureRepository.findById(Long.valueOf(6)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();
        User user = iUserRepository.findById(Long.valueOf(3)).get();

        List features = new ArrayList<>();

        features.add(feature7);
        features.add(feature4);
        features.add(feature6);

        List coordinates = new ArrayList<>();

        coordinates.add(-24.164624);
        coordinates.add(-65.3236347);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product3 = new Product("El Cerquero, Casa de Huéspedes", "A 3 km del centro", 3.0F, 8.9,"¡Ideal para estadías de 4 noches!","El Cerquero se encuentra en San Salvador de Jujuy y ofrece alojamiento con conexión wifi gratis y jardín con pileta al aire libre y vistas al jardín.\n\nLos alojamientos disponen de patio, aire acondicionado, TV de pantalla plana y baño privado con bidet y artículos de aseo gratuitos.\n\nTodos los días se sirve un desayuno continental en el aparthotel.\n\nPurmamarca se encuentra a 50 km de El Cerquero, mientras que Termas de Reyes está a 17 km. El aeropuerto más cercano es el aeropuerto Gobernador Horacio Guzmán, ubicado a 34 km. El alojamiento ofrece servicio de link con el aeropuerto por un adicional.\n\nA las parejas les gusta la ubicación. Le pusieron un puntaje de 8,5 para un viaje de a dos.", coordinates,category3, location21, "El picaflor 509", features, policies, user);

        iProductRepository.save(product3);
    }

}
