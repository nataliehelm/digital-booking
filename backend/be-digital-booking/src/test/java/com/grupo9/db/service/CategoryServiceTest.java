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
        Category saveCategory = categoryService.save(category);
        Assert.assertEquals("Category1", saveCategory.getName());
        Assert.assertEquals("CategoryDescription", saveCategory.getDescription());
        Assert.assertEquals("CategoryImg", saveCategory.getImage_url());
    }

    @Test
    @Order(2)
    void findAll() {
        List<Category> listCagegory = categoryService.findAll();
        Assert.assertTrue(listCagegory.size()>=1);
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(3)
    void findById() throws ResourceNotFoundException {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        Category saveCategory = categoryService.save(category);
        Long createId = saveCategory.getId();
        Category findByIdCategory = categoryService.findById(createId);
        Assert.assertEquals("Category1", findByIdCategory.getName());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(4)
    void update() throws ResourceNotFoundException, BadRequestException {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        Category saveCategory = categoryService.save(category);
        Long createId = saveCategory.getId();
        Category findByIdCategory = categoryService.findById(createId);
        Assert.assertEquals("Category1", findByIdCategory.getName());
        findByIdCategory.setName("Category2");
        Category update = categoryService.update(createId, findByIdCategory);
        Assert.assertEquals("Category2", update.getName());
    }

    @Test
    @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
    @Order(5)
    void deleteById() throws ResourceNotFoundException, BadRequestException {
        Category category = new Category("Category1", "CategoryDescription", "CategoryImg");
        Category saveCategory = categoryService.save(category);
        Long createId = saveCategory.getId();
        Category findByIdCategory = categoryService.findById(createId);
        Assert.assertEquals("Category1", findByIdCategory.getName());
        categoryService.deleteById(createId);
        Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->categoryService.deleteById(createId));
        Assert.assertEquals("Category with id " +  createId + " not found", exception.getMessage());
    }
}