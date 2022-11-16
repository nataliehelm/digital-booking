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
        public ResponseEntity<ApiResponse<SubPolicy, Object>> create(){
        SubPolicy subPolicy = new SubPolicy("SubPolicy");
        return subPoliciesService.save(subPolicy);
    };

        @Test
        @Order(1)
        void save() throws ResourceNotFoundException {
            ResponseEntity<ApiResponse<SubPolicy, Object>> createSubPolicy = create();
            subPolicies.add(createSubPolicy.getBody().getData().getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            ResponseEntity<ApiResponse<Policy, Object>> savePolicyDto = policyService.save(savePolicyDto1);
            Assert.assertEquals(201, savePolicyDto.getStatusCodeValue());
            Assert.assertEquals("TitlePolicy", savePolicyDto.getBody().getData().getTitle());
        }

        @Test
        @Order(2)
        void findAll() {
            ResponseEntity<ApiResponse<List<Policy>, Object>> listPolicy = policyService.findAll();
            Assert.assertEquals(200, listPolicy.getStatusCodeValue());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(3)
        void findById() throws ResourceNotFoundException {
            ResponseEntity<ApiResponse<SubPolicy, Object>> createSubPolicy = create();
            subPolicies.add(createSubPolicy.getBody().getData().getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            ResponseEntity<ApiResponse<Policy, Object>> savePolicyDto = policyService.save(savePolicyDto1);
            Long createId = savePolicyDto.getBody().getData().getId();
            ResponseEntity<ApiResponse<Policy, Object>> findByIdPolicy = policyService.findById(createId);
            Assert.assertEquals(200, findByIdPolicy.getStatusCodeValue());
            Assert.assertEquals("TitlePolicy", findByIdPolicy.getBody().getData().getTitle());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(4)
        void update() throws ResourceNotFoundException, BadRequestException {
            ResponseEntity<ApiResponse<SubPolicy, Object>> createSubPolicy = create();
            subPolicies.add(createSubPolicy.getBody().getData().getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            ResponseEntity<ApiResponse<Policy, Object>> savePolicyDto = policyService.save(savePolicyDto1);
            Long createId = savePolicyDto.getBody().getData().getId();
            ResponseEntity<ApiResponse<Policy, Object>> findByIdPolicy = policyService.findById(createId);
            Assert.assertEquals("TitlePolicy", findByIdPolicy.getBody().getData().getTitle());
            Policy updatePolicy = findByIdPolicy.getBody().getData();
            updatePolicy.setTitle("TitlePolicy2");
            ResponseEntity<ApiResponse<Policy, Object>> update = policyService.update(createId, savePolicyDto1);
            Assert.assertEquals("TitlePolicy2", update.getBody().getData().getTitle());
        }

        @Test
        @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
        @Order(5)
        void deleteById() throws ResourceNotFoundException, BadRequestException {
            ResponseEntity<ApiResponse<SubPolicy, Object>> createSubPolicy = create();
            subPolicies.add(createSubPolicy.getBody().getData().getId());
            SavePolicyDto savePolicyDto1 = new SavePolicyDto("TitlePolicy", subPolicies);
            ResponseEntity<ApiResponse<Policy, Object>> savePolicyDto = policyService.save(savePolicyDto1);
            Long createId = savePolicyDto.getBody().getData().getId();
            ResponseEntity<ApiResponse<Policy, Object>> findByIdPolicy = policyService.findById(createId);
            Assert.assertEquals("TitlePolicy", findByIdPolicy.getBody().getData().getTitle());
            policyService.deleteById(createId);
            Throwable exception = Assert.assertThrows(ResourceNotFoundException.class, ()->policyService.deleteById(createId));
            Assert.assertEquals("Policy with id " +  createId + " not found", exception.getMessage());
        }
    }