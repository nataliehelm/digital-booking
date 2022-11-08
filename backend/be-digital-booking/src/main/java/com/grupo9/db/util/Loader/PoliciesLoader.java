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
        SubPolicy subPolicy8 = iSubPolicyRepository.findById(8L).get();
        SubPolicy subPolicy9 = iSubPolicyRepository.findById(9L).get();
        SubPolicy subPolicy10 = iSubPolicyRepository.findById(10L).get();

        List<SubPolicy> subPolicies1 = new ArrayList<>();
        List<SubPolicy> subPolicies2 = new ArrayList<>();
        List<SubPolicy> subPolicies3 = new ArrayList<>();
        List<SubPolicy> subPolicies4 = new ArrayList<>();
        List<SubPolicy> subPolicies5 = new ArrayList<>();

        subPolicies1.add(subPolicy1);
        subPolicies1.add(subPolicy2);
        subPolicies1.add(subPolicy3);
        subPolicies2.add(subPolicy4);
        subPolicies2.add(subPolicy5);
        subPolicies2.add(subPolicy6);
        subPolicies3.add(subPolicy7);
        subPolicies4.add(subPolicy8);
        subPolicies5.add(subPolicy9);
        subPolicies5.add(subPolicy10);

        Policy policy1 = new Policy("Normas de la casa", subPolicies1);
        Policy policy2 = new Policy("Salud y seguridad", subPolicies2);
        Policy policy3 = new Policy("Política de cancelación", subPolicies3);
        Policy policy4 = new Policy("Políticas de niños", subPolicies4);
        Policy policy5 = new Policy("Políticas de camas adicionales y cunas", subPolicies5);

        iPolicyRepository.save(policy1);
        iPolicyRepository.save(policy2);
        iPolicyRepository.save(policy3);
        iPolicyRepository.save(policy4);
        iPolicyRepository.save(policy5);
    }
}
