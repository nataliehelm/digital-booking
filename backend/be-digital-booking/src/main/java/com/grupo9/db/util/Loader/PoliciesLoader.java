package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Policy;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.ISubPolicyRepository;


public class PoliciesLoader {

    IPolicyRepository iPolicyRepository;
    ISubPolicyRepository iSubPolicyRepository;

    public PoliciesLoader(IPolicyRepository iPolicyRepository, ISubPolicyRepository iSubPolicyRepository) {
        this.iPolicyRepository = iPolicyRepository;
        this.iSubPolicyRepository = iSubPolicyRepository;
    }

    public void Loader (){


        Policy policy1 = new Policy("Normas de la casa");
        Policy policy2 = new Policy("Salud y seguridad");
        Policy policy3 = new Policy("Política de cancelación");

        iPolicyRepository.save(policy1);
        iPolicyRepository.save(policy2);
        iPolicyRepository.save(policy3);
    }
}
