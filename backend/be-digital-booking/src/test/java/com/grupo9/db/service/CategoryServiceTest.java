package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.model.Feature;
import com.grupo9.db.model.Image;
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
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    @Order(1)
    void save() {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        ResponseEntity<ApiResponse<Category, Object>> saveCategory = categoryService.save(category);
        Assert.assertEquals(201, saveCategory.getStatusCodeValue());
        Assert.assertEquals("Category1", saveCategory.getBody().getData().getName());
        Assert.assertEquals("CategoryDescription", saveCategory.getBody().getData().getDescription());
        Assert.assertEquals("CategoryImg", saveCategory.getBody().getData().getImage_url());
    }

    @Test
    @Order(2)
    void findAll() {
        ResponseEntity<ApiResponse<List<Category>, Object>> listCagegory = categoryService.findAll();
        Assert.assertEquals(200, listCagegory.getStatusCodeValue());
        Assert.assertTrue(listCagegory.getBody().getData().size()>=1);
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(3)
    void findById() throws ResourceNotFoundException {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        ResponseEntity<ApiResponse<Category, Object>> saveCategory = categoryService.save(category);
        Long createId = saveCategory.getBody().getData().getId();
        ResponseEntity<ApiResponse<Category, Object>> findByIdCategory = categoryService.findById(createId);
        Assert.assertEquals(200, findByIdCategory.getStatusCodeValue());
        Assert.assertEquals("Category1", findByIdCategory.getBody().getData().getName());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(4)
    void update() throws ResourceNotFoundException, BadRequestException {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        ResponseEntity<ApiResponse<Category, Object>> saveCategory = categoryService.save(category);
        Long createId = saveCategory.getBody().getData().getId();
        ResponseEntity<ApiResponse<Category, Object>> findByIdCategory = categoryService.findById(createId);
        Assert.assertEquals("Category1", findByIdCategory.getBody().getData().getName());
        Category updateCategory = findByIdCategory.getBody().getData();
        updateCategory.setName("Category2");
        ResponseEntity<ApiResponse<Category, Object>> update = categoryService.update(createId, updateCategory);
        Assert.assertEquals("Category2", update.getBody().getData().getName());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(5)
    void deleteById() throws ResourceNotFoundException, BadRequestException {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        ResponseEntity<ApiResponse<Category, Object>> saveCategory = categoryService.save(category);
        Long createId = saveCategory.getBody().getData().getId();
        ResponseEntity<ApiResponse<Category, Object>> findByIdCategory = categoryService.findById(createId);
        Assert.assertEquals("Category1", findByIdCategory.getBody().getData().getName());
        categoryService.deleteById(createId);
        Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->categoryService.deleteById(createId));
        Assert.assertEquals("Category with id " +  createId + " not found", exception.getMessage());
    }
}