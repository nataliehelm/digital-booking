package com.grupo9.db.service;

import com.grupo9.db.dto.Policy.SavePolicyDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Policy;
import com.grupo9.db.model.SubPolicy;
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
class SubPolicyServiceTest {

        @Autowired
        private SubPolicyService subPolicies;
        public ResponseEntity<ApiResponse<SubPolicy, Object>> create(){
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            return subPolicies.save(subPolicy);
        };

    @Test
        @Order(1)
        void save() throws ResourceNotFoundException {
            ResponseEntity<ApiResponse<SubPolicy, Object>> subPolicy1 = create();
            Assert.assertEquals(201, subPolicy1.getStatusCodeValue());
            Assert.assertEquals("SubPolicy", subPolicy1.getBody().getData().getDescription());
        }

        @Test
        @Order(2)
        void findAll() {
            ResponseEntity<ApiResponse<List<SubPolicy>, Object>> listSubPolicy = subPolicies.findAll();
            Assert.assertEquals(200, listSubPolicy.getStatusCodeValue());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(3)
        void findById() throws ResourceNotFoundException {
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            ResponseEntity<ApiResponse<SubPolicy, Object>> subPolicy1 = subPolicies.save(subPolicy);
            Long createId = subPolicy1.getBody().getData().getId();
            ResponseEntity<ApiResponse<SubPolicy, Object>> findByIdSubPolicy = subPolicies.findById(createId);
            Assert.assertEquals(200, findByIdSubPolicy.getStatusCodeValue());
            Assert.assertEquals("SubPolicy", findByIdSubPolicy.getBody().getData().getDescription());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(4)
        void update() throws ResourceNotFoundException, BadRequestException {
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            ResponseEntity<ApiResponse<SubPolicy, Object>> subPolicy1 = subPolicies.save(subPolicy);
            Long createId = subPolicy1.getBody().getData().getId();
            ResponseEntity<ApiResponse<SubPolicy, Object>> findByIdSubPolicy = subPolicies.findById(createId);
            Assert.assertEquals("SubPolicy", findByIdSubPolicy.getBody().getData().getDescription());
            SubPolicy updateSubPolicy = findByIdSubPolicy.getBody().getData();
            updateSubPolicy.setDescription("SubPolicy2");
            ResponseEntity<ApiResponse<SubPolicy, Object>> update = subPolicies.update(createId, updateSubPolicy);
            Assert.assertEquals("SubPolicy2", update.getBody().getData().getDescription());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(5)
        void deleteById() throws ResourceNotFoundException, BadRequestException {
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            ResponseEntity<ApiResponse<SubPolicy, Object>> subPolicy1 = subPolicies.save(subPolicy);
            Long createId = subPolicy1.getBody().getData().getId();
            ResponseEntity<ApiResponse<SubPolicy, Object>> findByIdSubPolicy = subPolicies.findById(createId);
            Assert.assertEquals("SubPolicy", findByIdSubPolicy.getBody().getData().getDescription());
            subPolicies.deleteById(createId);
            Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->subPolicies.deleteById(createId));
            Assert.assertEquals("SubPolicy with id " +  createId + " not found", exception.getMessage());
        }
    }
