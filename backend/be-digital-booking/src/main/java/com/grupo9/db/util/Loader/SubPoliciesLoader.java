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

    ISubPolicyRepository iSubPolicyRepository;

    public SubPoliciesLoader(ISubPolicyRepository iSubPolicyRepository) {
        this.iSubPolicyRepository = iSubPolicyRepository;
    }

    public void Loader (){

        SubPolicy subPolicy1 = new SubPolicy("Check-out: 10:00");
        SubPolicy subPolicy2 = new SubPolicy("No se permiten fiestas");
        SubPolicy subPolicy3 = new SubPolicy("No fumar");
        SubPolicy subPolicy4 = new SubPolicy("Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus");
        SubPolicy subPolicy5 = new SubPolicy("Detector de humo");
        SubPolicy subPolicy6 = new SubPolicy("Depósito de seguridad");
        SubPolicy subPolicy7 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.");
        SubPolicy subPolicy8 = new SubPolicy("No se aceptan niños.");
        SubPolicy subPolicy9 = new SubPolicy("No se pueden agregar cunas en este alojamiento.");
        SubPolicy subPolicy10 = new SubPolicy("No se pueden agregar camas adicionales en este alojamiento.");

        iSubPolicyRepository.save(subPolicy1);
        iSubPolicyRepository.save(subPolicy2);
        iSubPolicyRepository.save(subPolicy3);
        iSubPolicyRepository.save(subPolicy4);
        iSubPolicyRepository.save(subPolicy5);
        iSubPolicyRepository.save(subPolicy6);
        iSubPolicyRepository.save(subPolicy7);
        iSubPolicyRepository.save(subPolicy8);
        iSubPolicyRepository.save(subPolicy9);
        iSubPolicyRepository.save(subPolicy10);
    }
}
