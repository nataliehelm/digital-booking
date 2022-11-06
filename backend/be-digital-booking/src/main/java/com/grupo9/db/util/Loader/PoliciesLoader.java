package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Image;
import com.grupo9.db.model.Policy;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.repository.IImageRepository;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.repository.ISubPolicyRepository;

import java.util.ArrayList;
import java.util.List;

public class PoliciesLoader {

    IPolicyRepository iPolicyRepository;
    ISubPolicyRepository iSubPolicyRepository;

    public PoliciesLoader(IPolicyRepository iPolicyRepository, ISubPolicyRepository iSubPolicyRepository) {
        this.iPolicyRepository = iPolicyRepository;
        this.iSubPolicyRepository = iSubPolicyRepository;
    }

    public void Loader (){

        SubPolicy subPolicy1 = iSubPolicyRepository.findById(1L).get();
        SubPolicy subPolicy2 = iSubPolicyRepository.findById(2L).get();
        SubPolicy subPolicy3 = iSubPolicyRepository.findById(3L).get();
        SubPolicy subPolicy4 = iSubPolicyRepository.findById(4L).get();
        SubPolicy subPolicy5 = iSubPolicyRepository.findById(5L).get();
        SubPolicy subPolicy6 = iSubPolicyRepository.findById(6L).get();
        SubPolicy subPolicy7 = iSubPolicyRepository.findById(7L).get();

        List<SubPolicy> subPolicies1 = new ArrayList<>();
        List<SubPolicy> subPolicies2 = new ArrayList<>();
        List<SubPolicy> subPolicies3 = new ArrayList<>();

        subPolicies1.add(subPolicy1);
        subPolicies1.add(subPolicy2);
        subPolicies1.add(subPolicy3);
        subPolicies2.add(subPolicy4);
        subPolicies2.add(subPolicy5);
        subPolicies2.add(subPolicy6);
        subPolicies3.add(subPolicy7);

        Policy policy1 = new Policy("Normas de la casa", subPolicies1);
        Policy policy2 = new Policy("Salud y seguridad", subPolicies2);
        Policy policy3 = new Policy("Política de cancelación", subPolicies3);

        iPolicyRepository.save(policy1);
        iPolicyRepository.save(policy2);
        iPolicyRepository.save(policy3);
    }
}
