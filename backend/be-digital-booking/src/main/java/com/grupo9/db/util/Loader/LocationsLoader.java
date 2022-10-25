package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.repository.ICategoryRepository;
import com.grupo9.db.repository.ILocationRepository;

public class LocationsLoader {

    ILocationRepository iLocationRepository;

    public LocationsLoader(ILocationRepository iLocationRepository) {
        this.iLocationRepository = iLocationRepository;
    }

    public void Loader (){

        Location location1 = new Location("Provincia de Misiones", "AR-N", "Misiones", "Provincia", "Misiones");
        Location location2 = new Location("Provincia de San Luis", "AR-D", "San Luis", "Provincia", "San Luis");
        Location location3 = new Location("Provincia de San Juan", "AR-J", "San Juan", "Provincia", "San Juan");
        Location location4 = new Location("Provincia de Entre Ríos", "AR-E", "Entre Ríos", "Provincia", "Entre Ríos");
        Location location5 = new Location("Provincia de Santa Cruz", "AR-Z", "Santa Cruz", "Provincia", "Santa Cruz");
        Location location6 = new Location("Provincia de Río Negro", "AR-R", "Río Negro", "Provincia", "Río Negro");
        Location location7 = new Location("Provincia del Chubut", "AR-U", "Chubut", "Provincia", "Chubut");
        Location location8 = new Location("Provincia de Córdoba", "AR-X", "Córdoba", "Provincia", "Córdoba");
        Location location9 = new Location("Provincia de Mendoza", "AR-M", "Mendoza", "Provincia", "Mendoza");
        Location location10 = new Location("Provincia de La Rioja", "AR-F", "La Rioja", "Provincia", "La Rioja");
        Location location11 = new Location("Provincia de Catamarca", "AR-K", "Catamarca", "Provincia", "Catamarca");
        Location location12 = new Location("Provincia de La Pampa", "AR-L", "La Pampa", "Provincia", "La Pampa");
        Location location13 = new Location("Provincia de Santiago del Estero", "AR-G", "Santiago del Estero", "Provincia", "Santiago del Estero");
        Location location14 = new Location("Provincia de Corrientes", "AR-W", "Corrientes", "Provincia", "Corrientes");
        Location location15 = new Location("Provincia de Santa Fe", "AR-S", "Santa Fe", "Provincia", "Santa Fe");
        Location location16 = new Location("Provincia de Tucumán", "AR-T", "Tucumán", "Provincia", "Tucumán");
        Location location17 = new Location("Provincia del Neuquén", "AR-Q", "Neuquén", "Provincia", "Neuquén");
        Location location18 = new Location("Provincia de Salta", "AR-A", "Salta", "Provincia", "Salta");
        Location location19 = new Location("Provincia del Chaco", "AR-H", "Chaco", "Provincia", "Chaco");
        Location location20 = new Location("Provincia de Formosa", "AR-P", "Formosa", "Provincia", "Formosa");
        Location location21 = new Location("Provincia de Jujuy", "AR-Y", "Jujuy", "Provincia", "Jujuy");
        Location location22 = new Location("Ciudad Autónoma de Buenos Aires", "AR-C", "Ciudad Autónoma de Buenos Aires", "Ciudad Autónoma", "Ciudad Autónoma de Buenos Aires");
        Location location23 = new Location("Provincia de Buenos Aires", "AR-B", "Buenos Aires", "Provincia", "Buenos Aires");
        Location location24 = new Location("Provincia de Tierra del Fuego", "AR-V", "Tierra del Fuego", "Provincia", "Tierra del Fuego");

        iLocationRepository.save(location1);
        iLocationRepository.save(location2);
        iLocationRepository.save(location3);
        iLocationRepository.save(location4);
        iLocationRepository.save(location5);
        iLocationRepository.save(location6);
        iLocationRepository.save(location7);
        iLocationRepository.save(location8);
        iLocationRepository.save(location9);
        iLocationRepository.save(location10);
        iLocationRepository.save(location11);
        iLocationRepository.save(location12);
        iLocationRepository.save(location13);
        iLocationRepository.save(location14);
        iLocationRepository.save(location15);
        iLocationRepository.save(location16);
        iLocationRepository.save(location17);
        iLocationRepository.save(location18);
        iLocationRepository.save(location19);
        iLocationRepository.save(location20);
        iLocationRepository.save(location21);
        iLocationRepository.save(location22);
        iLocationRepository.save(location23);
        iLocationRepository.save(location24);
    }
}
