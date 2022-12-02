package com.grupo9.db.service;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.ISubPolicyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PolicyBySubPolicyService {

    @Autowired
    private ISubPolicyRepository subPolicyRepository;
    @Autowired
    private IPolicyRepository policyRepository;

}
