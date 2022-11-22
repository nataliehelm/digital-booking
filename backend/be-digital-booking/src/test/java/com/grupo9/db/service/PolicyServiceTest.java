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

import java.util.ArrayList;
import java.util.List;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class PolicyServiceTest {

        @Autowired
        private PolicyService policyService;
        private List<Long> subPolicies = new ArrayList<>();
        @Autowired
        private SubPolicyService subPoliciesService;
        public SubPolicy create(){
            SubPolicy subPolicy = new SubPolicy("SubPolicy");
            return subPoliciesService.save(subPolicy);
        };

        @Test
        @Order(1)
        void save() throws ResourceNotFoundException {
            SubPolicy createSubPolicy = create();
            subPolicies.add(createSubPolicy.getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            Policy savePolicyDto = policyService.save(savePolicyDto1);
            Assert.assertEquals("TitlePolicy", savePolicyDto.getTitle());
        }

        @Test
        @Order(2)
        void findAll() {
            List<Policy> listPolicy = policyService.findAll();
            Assert.assertTrue(listPolicy.size()>=1);
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(3)
        void findById() throws ResourceNotFoundException {
            SubPolicy createSubPolicy = create();
            subPolicies.add(createSubPolicy.getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            Policy savePolicyDto = policyService.save(savePolicyDto1);
            Long createId = savePolicyDto.getId();
            Policy findByIdPolicy = policyService.findById(createId);
            Assert.assertEquals("TitlePolicy", findByIdPolicy.getTitle());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(4)
        void update() throws ResourceNotFoundException, BadRequestException {
            SubPolicy createSubPolicy = create();
            subPolicies.add(createSubPolicy.getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            Policy savePolicyDto = policyService.save(savePolicyDto1);
            Long createId = savePolicyDto.getId();
            Policy findByIdPolicy = policyService.findById(createId);
            Assert.assertEquals("TitlePolicy", findByIdPolicy.getTitle());
            findByIdPolicy.setTitle("TitlePolicy2");
            Policy update = policyService.update(createId, savePolicyDto1);
            Assert.assertEquals("TitlePolicy2", update.getTitle());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(5)
        void deleteById() throws ResourceNotFoundException, BadRequestException {
            SubPolicy createSubPolicy = create();
            subPolicies.add(createSubPolicy.getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            Policy savePolicyDto = policyService.save(savePolicyDto1);
            Long createId = savePolicyDto.getId();
            Policy findByIdPolicy = policyService.findById(createId);
            Assert.assertEquals("TitlePolicy", findByIdPolicy.getTitle());
            policyService.deleteById(createId);
            Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->policyService.deleteById(createId));
            Assert.assertEquals("Policy with id " +  createId + " not found", exception.getMessage());
        }
    }