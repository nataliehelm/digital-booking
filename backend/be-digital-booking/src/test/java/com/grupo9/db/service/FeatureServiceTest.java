package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Feature;
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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class FeatureServiceTest {

    @Autowired
    private FeatureService featureService;

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(1)
    void save() {
        Feature feature = new Feature("Feature1", "Icon1");
        ResponseEntity<ApiResponse<Feature, Object>> saveFeature = featureService.save(feature);
        Assert.assertEquals(201, saveFeature.getStatusCodeValue());
        Assert.assertEquals("Feature1", saveFeature.getBody().getData().getName());
        Assert.assertEquals("Icon1", saveFeature.getBody().getData().getIcon());
    }

    @Test
    @Order(2)
    void findAll() {
        ResponseEntity<ApiResponse<List<Feature>, Object>> listFeature = featureService.findAll();
        Assert.assertEquals(200, listFeature.getStatusCodeValue());
        Assert.assertTrue(listFeature.getBody().getData().size()>=1);
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(3)
    void findById() throws ResourceNotFoundException {
        Feature feature = new Feature("Feature1", "Icon1");
        ResponseEntity<ApiResponse<Feature, Object>> saveFeature = featureService.save(feature);
        Long createId = saveFeature.getBody().getData().getId();
        ResponseEntity<ApiResponse<Feature, Object>> findByIdFeature = featureService.findById(createId);
        Assert.assertEquals(200, findByIdFeature.getStatusCodeValue());
        Assert.assertEquals("Feature1", findByIdFeature.getBody().getData().getName());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(4)
    void update() throws ResourceNotFoundException, BadRequestException {
        Feature feature = new Feature("Feature1", "Icon1");
        ResponseEntity<ApiResponse<Feature, Object>> saveFeature = featureService.save(feature);
        Long createId = saveFeature.getBody().getData().getId();
        ResponseEntity<ApiResponse<Feature, Object>> findByIdFeature = featureService.findById(createId);
        Assert.assertEquals("Feature1", findByIdFeature.getBody().getData().getName());
        Feature updateFeature = findByIdFeature.getBody().getData();
        updateFeature.setName("Feature2");
        ResponseEntity<ApiResponse<Feature, Object>> update = featureService.update(createId, updateFeature);
        Assert.assertEquals("Feature2", update.getBody().getData().getName());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(5)
    void deleteById() throws ResourceNotFoundException, BadRequestException {
        Feature feature = new Feature("Feature1", "Icon1");
        ResponseEntity<ApiResponse<Feature, Object>> saveFeature = featureService.save(feature);
        Long createId = saveFeature.getBody().getData().getId();
        ResponseEntity<ApiResponse<Feature, Object>> findByIdFeature = featureService.findById(createId);
        Assert.assertEquals("Feature1", findByIdFeature.getBody().getData().getName());
        featureService.deleteById(createId);
        Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->featureService.deleteById(createId));
        Assert.assertEquals("Feature with id " +  createId + " not found", exception.getMessage());
    }
}

