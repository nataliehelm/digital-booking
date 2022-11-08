package com.grupo9.db.util.Loader;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

import java.util.ArrayList;
import java.util.List;

public class ProductsLoader {

    IProductRepository iProductRepository;
    ILocationRepository iLocationRepository;
    ICategoryRepository iCategoryRepository;
    IFeatureRepository iFeatureRepository;
    IPolicyRepository iPolicyRepository;

    public ProductsLoader(IProductRepository iProductRepository, ILocationRepository iLocationRepository, ICategoryRepository iCategoryRepository, IFeatureRepository iFeatureRepository, IPolicyRepository iPolicyRepository) {
        this.iProductRepository = iProductRepository;
        this.iLocationRepository = iLocationRepository;
        this.iCategoryRepository = iCategoryRepository;
        this.iFeatureRepository = iFeatureRepository;
        this.iPolicyRepository = iPolicyRepository;
    }

    public void Loader (){

        Location location1 = iLocationRepository.findById(Long.valueOf(1)).get();
        Location location2 = iLocationRepository.findById(Long.valueOf(17)).get();
        Location location5 = iLocationRepository.findById(Long.valueOf(5)).get();
        Location location6 = iLocationRepository.findById(Long.valueOf(6)).get();
        Category category1 = iCategoryRepository.findById(Long.valueOf(1)).get();
        Category category2 = iCategoryRepository.findById(Long.valueOf(2)).get();
        Category category3 = iCategoryRepository.findById(Long.valueOf(3)).get();
        Category category4 = iCategoryRepository.findById(Long.valueOf(4)).get();
        Feature feature1 = iFeatureRepository.findById(Long.valueOf(1)).get();
        Feature feature2 = iFeatureRepository.findById(Long.valueOf(2)).get();
        Feature feature3 = iFeatureRepository.findById(Long.valueOf(3)).get();
        Feature feature4 = iFeatureRepository.findById(Long.valueOf(4)).get();
        Feature feature7 = iFeatureRepository.findById(Long.valueOf(7)).get();
        Feature feature8 = iFeatureRepository.findById(Long.valueOf(8)).get();
        Feature feature9 = iFeatureRepository.findById(Long.valueOf(9)).get();
        Feature feature10 = iFeatureRepository.findById(Long.valueOf(10)).get();
        Feature feature11 = iFeatureRepository.findById(Long.valueOf(11)).get();
        Policy policy1 = iPolicyRepository.findById(Long.valueOf(1)).get();
        Policy policy2 = iPolicyRepository.findById(Long.valueOf(2)).get();
        Policy policy3 = iPolicyRepository.findById(Long.valueOf(3)).get();

        List features = new ArrayList<>();

        features.add(feature1);
        features.add(feature2);

        List features1 = new ArrayList<>();

        features1.add(feature7);
        features1.add(feature3);
        features1.add(feature4);
        features1.add(feature8);
        features1.add(feature9);

        List features2 = new ArrayList<>();

        features2.add(feature4);
        features2.add(feature10);
        features2.add(feature11);

        List features3 = new ArrayList<>();

        features3.add(feature7);
        features3.add(feature10);
        features3.add(feature3);
        features3.add(feature4);

        List features4 = new ArrayList<>();

        features4.add(feature10);
        features4.add(feature3);
        features4.add(feature4);
        features4.add(feature8);


        List coordinates = new ArrayList<>();

        coordinates.add(-34.5828949);
        coordinates.add(-58.4240502);

        List coordinates1 = new ArrayList<>();

        coordinates1.add(-38.957918522737856);
        coordinates1.add(-68.11447964631512);

        List coordinates2 = new ArrayList<>();

        coordinates2.add(-50.33664055279568);
        coordinates2.add(-72.2629555017608);

        List coordinates3 = new ArrayList<>();

        coordinates3.add(-41.16813961310178);
        coordinates3.add(-71.43951430203818);

        List coordinates4 = new ArrayList<>();

        coordinates4.add(-33.21144477804261);
        coordinates4.add(-66.22836017303051);

        List policies = new ArrayList<>();

        policies.add(policy1);
        policies.add(policy2);
        policies.add(policy3);

        Product product1 = new Product("Hermitage Hotel", "A 940 m del centro", 4.0F, 8.0F, "Alójate en el corazón de Buenos Aires" ,"Está situado a solo unas calles de la avenida Alvear, de la avenida Quintana, del parque San Martín y del distrito de Recoleta. En las inmediaciones también hay varios lugares de interés, como la calle Florida, el centro comercial Galerías Pacífico, la zona de Puerto Madero, la plaza de Mayo y el palacio Municipal.\n\n Nuestros clientes dicen que esta parte de Buenos Aires es su favorita, según los comentarios independientes.\n \n El Hotel es un hotel sofisticado de 4 estrellas que goza de una ubicación tranquila, a poca distancia de prestigiosas galerías de arte, teatros, museos y zonas comerciales. Además, hay WiFi gratuita.\n El establecimiento sirve un desayuno variado de 07:00 a 10:30.",coordinates,category1, location1, features, policies);
        Product product2 = new Product("Hotel Casino Magic", "A 4,8 km del centro", 5.0F, 9.0F, "Descubre cómo se sienten las estrellas con el mejor servicio en el Hotel Casino Magic", "El Hotel Casino Magic de Neuquén cuenta con una elegante entrada con arcos y un patio interior con pilares en torno a una piscina al aire libre alargada, y también dispone de spa, casino y conexión Wi-Fi gratuita. El Museo Nacional de Bellas Artes está a 4 km.", coordinates1, category1, location2 , features1, policies );
        Product product3 = new Product("Hostel Danny", "A  200 m del centro", 0.0F, 0.0F,"Puedes cancelar más tarde. Aprovecha y consigue un buen precio hoy.", "El Hostel Danny ofrece alojamiento con WiFi gratuita en todas las instalaciones en El Calafate, a 5 km del lago Argentino y a 800 metros del Museo Regional. El establecimiento está a 1,6 km de la estación de autobuses de El Calafate, a 2,2 km de la laguna de Nimez y a 8,8 km de la isla Solitaria. Hay servicio de conserjería, mostrador de información turística y servicio de cambio de divisa.", coordinates2, category2 , location5, features2, policies );
        Product product4 = new Product("Heaven Catedral", "A  11,5 km del centro", 4.0F, 8.5F, "Apartamento de 1 dormitorio", "El HEAVEN CATEDRAL se encuentra en San Carlos de Bariloche, a 18 km del centro cívico, y ofrece vistas a la piscina, WiFi gratuita y aparcamiento privado gratuito. El alojamiento cuenta con bañera de hidromasaje.\n\n Todos los alojamientos cuentan con zona de estar, sofá, TV de pantalla plana vía satélite y cocina totalmente equipada con zona de comedor. Hay microondas, nevera, horno, hervidor de agua y cafetera.\n\n Todas las mañanas se sirve un desayuno continental y a la carta.", coordinates3, category3, location6, features3, policies);
        Product product5 = new Product("La Paula bed & breakfast", "A  14,2 km del centro", 4.0F, 8.0F, "Habitación Doble con vistas - 2 camas", "La Paula bed & breakfast se encuentra en San Luis, a 1,9 km del circuito internacional de Potrero de los Funes, y ofrece vistas a la montaña, WiFi gratuita y aparcamiento privado gratuito.\n\n El baño privado está totalmente equipado con ducha y artículos de aseo gratuitos.\n\n El hipódromo Rosendo Hernández se encuentra a 32 km del bed and breakfast, mientras que Potrero de los Funes está a 1 km. El aeropuerto Brigadier Mayor Cesar R. Ojeda es el más cercano y está a 21 km de La Paula bed & breakfast.", coordinates4, category4, location2, features4, policies );

        iProductRepository.save(product1);
        iProductRepository.save(product2);
        iProductRepository.save(product3);
        iProductRepository.save(product4);
        iProductRepository.save(product5);
    }
}
