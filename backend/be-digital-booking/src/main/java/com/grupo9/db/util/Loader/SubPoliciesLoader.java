package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Image;
import com.grupo9.db.model.Policy;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.repository.IImageRepository;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.repository.ISubPolicyRepository;

public class SubPoliciesLoader {

    IPolicyRepository iPolicyRepository;
    ISubPolicyRepository iSubPolicyRepository;

    public SubPoliciesLoader(IPolicyRepository iPolicyRepository, ISubPolicyRepository iSubPolicyRepository) {
        this.iPolicyRepository = iPolicyRepository;
        this.iSubPolicyRepository = iSubPolicyRepository;
    }

    public void Loader (){

        Policy policy1 = iPolicyRepository.findById(1L).get();
        Policy policy2 = iPolicyRepository.findById(2L).get();
        Policy policy3 = iPolicyRepository.findById(3L).get();

        SubPolicy subPolicy1 = new SubPolicy("Check-out: 10:00", policy1);
        SubPolicy subPolicy2 = new SubPolicy("No se permiten fiestas", policy1);
        SubPolicy subPolicy3 = new SubPolicy("No fumar", policy1);
        SubPolicy subPolicy4 = new SubPolicy("Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus", policy2);
        SubPolicy subPolicy5 = new SubPolicy("Detector de humo", policy2);
        SubPolicy subPolicy6 = new SubPolicy("Depósito de seguridad", policy2);
        SubPolicy subPolicy7 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", policy3);

        iSubPolicyRepository.save(subPolicy1);
        iSubPolicyRepository.save(subPolicy2);
        iSubPolicyRepository.save(subPolicy3);
        iSubPolicyRepository.save(subPolicy4);
        iSubPolicyRepository.save(subPolicy5);
        iSubPolicyRepository.save(subPolicy6);
        iSubPolicyRepository.save(subPolicy7);
    }
}
