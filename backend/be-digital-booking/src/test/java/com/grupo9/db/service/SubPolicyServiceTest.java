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
        public SubPolicy create(){
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            return subPolicies.save(subPolicy);
        };

    @Test
        @Order(1)
        void save() throws ResourceNotFoundException {
            SubPolicy subPolicy1 = create();
            Assert.assertEquals("SubPolicy", subPolicy1.getDescription());
        }

        @Test
        @Order(2)
        void findAll() {
            List<SubPolicy> listSubPolicy = subPolicies.findAll();
            Assert.assertTrue(listSubPolicy.size()>=1);
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(3)
        void findById() throws ResourceNotFoundException {
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            SubPolicy subPolicy1 = subPolicies.save(subPolicy);
            Long createId = subPolicy1.getId();
            SubPolicy findByIdSubPolicy = subPolicies.findById(createId);
            Assert.assertEquals("SubPolicy", findByIdSubPolicy.getDescription());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(4)
        void update() throws ResourceNotFoundException, BadRequestException {
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            SubPolicy subPolicy1 = subPolicies.save(subPolicy);
            Long createId = subPolicy1.getId();
            SubPolicy findByIdSubPolicy = subPolicies.findById(createId);
            Assert.assertEquals("SubPolicy", findByIdSubPolicy.getDescription());
            findByIdSubPolicy.setDescription("SubPolicy2");
            SubPolicy update = subPolicies.update(createId, findByIdSubPolicy);
            Assert.assertEquals("SubPolicy2", update.getDescription());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(5)
        void deleteById() throws ResourceNotFoundException, BadRequestException {
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            SubPolicy subPolicy1 = subPolicies.save(subPolicy);
            Long createId = subPolicy1.getId();
            SubPolicy findByIdSubPolicy = subPolicies.findById(createId);
            Assert.assertEquals("SubPolicy", findByIdSubPolicy.getDescription());
            subPolicies.deleteById(createId);
            Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->subPolicies.deleteById(createId));
            Assert.assertEquals("SubPolicy with id " +  createId + " not found", exception.getMessage());
        }
    }
