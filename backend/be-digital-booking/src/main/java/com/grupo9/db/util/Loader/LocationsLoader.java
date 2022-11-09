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

        Location location1 = new Location("Provincia de Misiones", "Posadas", "Argentina");
        Location location2 = new Location("Provincia de San Luis", "San Luis", "Argentina");
        Location location3 = new Location("Provincia de San Juan", "San Juan", "Argentina");
        Location location4 = new Location("Provincia de Entre Ríos", "Paraná", "Argentina");
        Location location5 = new Location("Provincia de Santa Cruz", "Río Gallegos", "Argentina");
        Location location6 = new Location("Provincia de Río Negro", "Viedma", "Argentina");
        Location location7 = new Location("Provincia del Chubut", "Rawson", "Argentina");
        Location location8 = new Location("Provincia de Córdoba", "Córdoba", "Argentina");
        Location location9 = new Location("Provincia de Mendoza", "Mendoza", "Argentina");
        Location location10 = new Location("Provincia de La Rioja", "La Rioja", "Argentina");
        Location location11 = new Location("Provincia de Catamarca", "San Fernando del Valle de Catamarca", "Argentina");
        Location location12 = new Location("Provincia de La Pampa", "Santa Rosa", "Argentina");
        Location location13 = new Location("Provincia de Santiago del Estero",  "Santiago del Estero", "Argentina");
        Location location14 = new Location("Provincia de Corrientes", "Corrientes", "Argentina");
        Location location15 = new Location("Provincia de Santa Fe", "Santa Fe", "Argentina");
        Location location16 = new Location("Provincia de Tucumán", "San Miguel de Tucumán", "Argentina");
        Location location17 = new Location("Provincia del Neuquén", "Neuquén", "Argentina");
        Location location18 = new Location("Provincia de Salta", "Salta", "Argentina");
        Location location19 = new Location("Provincia del Chaco", "Resistencia", "Argentina");
        Location location20 = new Location("Provincia de Formosa", "Formosa", "Argentina");
        Location location21 = new Location("Provincia de Jujuy", "San Salvador de Jujuy", "Argentina");
        Location location22 = new Location("Ciudad Autónoma de Buenos Aires", "Ciudad Autónoma de Buenos Aires", "Argentina");
        Location location23 = new Location("Provincia de Buenos Aires", "La Plata", "Argentina");
        Location location24 = new Location("Provincia de Tierra del Fuego", "Ushuaia", "Argentina");

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
