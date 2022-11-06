package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Image;
import com.grupo9.db.model.Policy;
import com.grupo9.db.model.Product;
import com.grupo9.db.repository.IImageRepository;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.IProductRepository;

public class PoliciesLoader {

    IPolicyRepository iPolicyRepository;

    public PoliciesLoader(IPolicyRepository iPolicyRepository) {
        this.iPolicyRepository = iPolicyRepository;
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
