package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.util.ApiResponse;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class LocationServiceTest {

        @Autowired
        private LocationService locationService;

        @Test
        @Order(1)
        void save() {
            Location location = new Location("ProvinceName", "CityName", "CountryName");
            Location saveLocation = locationService.save(location);
            Assert.assertEquals("ProvinceName", saveLocation.getProvince_name());
            Assert.assertEquals("CityName", saveLocation.getCity_name());
            Assert.assertEquals("CountryName", saveLocation.getCountry_name());
        }

        @Test
        @Order(2)
        void findAll() {
            List<Location> listLocation = locationService.findAll();
            Assert.assertTrue(listLocation.size()>=1);
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(3)
        void findById() throws ResourceNotFoundException {
            Location location = new Location("ProvinceName", "CityName", "CountryName");
            Location saveLocation = locationService.save(location);
            Long createId = saveLocation.getId();
            Location findByIdLocation = locationService.findById(createId);
            Assert.assertEquals("ProvinceName", findByIdLocation.getProvince_name());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(4)
        void update() throws ResourceNotFoundException, BadRequestException {
            Location location = new Location("ProvinceName", "CityName", "CountryName");
            Location saveLocation = locationService.save(location);
            Long createId = saveLocation.getId();
            Location findByIdLocation = locationService.findById(createId);
            Assert.assertEquals("ProvinceName", findByIdLocation.getProvince_name());
            findByIdLocation.setProvince_name("ProvinceName2");
            Location update = locationService.update(createId, findByIdLocation);
            Assert.assertEquals("ProvinceName2", update.getProvince_name());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(5)
        void deleteById() throws ResourceNotFoundException, BadRequestException {
            Location location = new Location("ProvinceName", "CityName", "CountryName");
            Location saveLocation = locationService.save(location);
            Long createId = saveLocation.getId();
            Location findByIdLocation = locationService.findById(createId);
            Assert.assertEquals("ProvinceName", findByIdLocation.getProvince_name());
            locationService.deleteById(createId);
            Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->locationService.deleteById(createId));
            Assert.assertEquals("Location with id " +  createId + " not found", exception.getMessage());
        }
    }