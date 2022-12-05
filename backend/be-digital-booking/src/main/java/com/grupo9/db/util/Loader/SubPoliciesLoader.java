package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Policy;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.SubPolicy;
import com.grupo9.db.repository.IPolicyRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.repository.ISubPolicyRepository;

public class SubPoliciesLoader {

    ISubPolicyRepository iSubPolicyRepository;
    IPolicyRepository iPolicyRepository;
    IProductRepository iProductRepository;

    public SubPoliciesLoader(ISubPolicyRepository iSubPolicyRepository, IPolicyRepository iPolicyRepository, IProductRepository iProductRepository) {
        this.iSubPolicyRepository = iSubPolicyRepository;
        this.iPolicyRepository = iPolicyRepository;
        this.iProductRepository = iProductRepository;
    }

    public void Loader (){

        Policy policy1 = iPolicyRepository.findById(1L).get();
        Policy policy2 = iPolicyRepository.findById(2L).get();
        Policy policy3 = iPolicyRepository.findById(3L).get();

        Product product1 = iProductRepository.findById(1L).get();
        Product product2 = iProductRepository.findById(2L).get();
        Product product3 = iProductRepository.findById(3L).get();
        Product product4 = iProductRepository.findById(4L).get();
        Product product5 = iProductRepository.findById(5L).get();
        Product product6 = iProductRepository.findById(6L).get();
        Product product7 = iProductRepository.findById(7L).get();
        Product product8 = iProductRepository.findById(8L).get();
        Product product9 = iProductRepository.findById(9L).get();
        Product product10 = iProductRepository.findById(10L).get();
        Product product11= iProductRepository.findById(11L).get();
        Product product12 = iProductRepository.findById(12L).get();

        SubPolicy subPolicy1 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product1, policy1);
        SubPolicy subPolicy2 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product2, policy1);
        SubPolicy subPolicy3 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product3, policy1);
        SubPolicy subPolicy4 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product4, policy1);
        SubPolicy subPolicy5 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product5, policy1);
        SubPolicy subPolicy6 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product6, policy1);
        SubPolicy subPolicy7 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product7, policy1);
        SubPolicy subPolicy8 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product8, policy1);
        SubPolicy subPolicy9 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product9, policy1);
        SubPolicy subPolicy10 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product10, policy1);
        SubPolicy subPolicy11 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product11, policy1);
        SubPolicy subPolicy12 = new SubPolicy("- Check-out: 10:00 \n- No se permiten fiestas \n- No fumar", product12, policy1);
        SubPolicy subPolicy13 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product1, policy2);
        SubPolicy subPolicy14 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product2, policy2);
        SubPolicy subPolicy15 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product3, policy2);
        SubPolicy subPolicy16 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product4, policy2);
        SubPolicy subPolicy17 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product5, policy2);
        SubPolicy subPolicy18 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product6, policy2);
        SubPolicy subPolicy19 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product7, policy2);
        SubPolicy subPolicy20 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product8, policy2);
        SubPolicy subPolicy21 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product9, policy2);
        SubPolicy subPolicy22 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product10, policy2);
        SubPolicy subPolicy23 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product11, policy2);
        SubPolicy subPolicy24 = new SubPolicy("- Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus \n- Detector de humo \n- Depósito de seguridad", product12, policy2);
        SubPolicy subPolicy25 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product1, policy3);
        SubPolicy subPolicy26 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product2, policy3);
        SubPolicy subPolicy27 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product3, policy3);
        SubPolicy subPolicy28 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product4, policy3);
        SubPolicy subPolicy29 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product5, policy3);
        SubPolicy subPolicy30 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product6, policy3);
        SubPolicy subPolicy31 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product7, policy3);
        SubPolicy subPolicy32 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product8, policy3);
        SubPolicy subPolicy33 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product9, policy3);
        SubPolicy subPolicy34 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product10, policy3);
        SubPolicy subPolicy35 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product11, policy3);
        SubPolicy subPolicy36 = new SubPolicy("Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.", product12, policy3);

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
        iSubPolicyRepository.save(subPolicy11);
        iSubPolicyRepository.save(subPolicy12);
        iSubPolicyRepository.save(subPolicy13);
        iSubPolicyRepository.save(subPolicy14);
        iSubPolicyRepository.save(subPolicy15);
        iSubPolicyRepository.save(subPolicy15);
        iSubPolicyRepository.save(subPolicy16);
        iSubPolicyRepository.save(subPolicy17);
        iSubPolicyRepository.save(subPolicy18);
        iSubPolicyRepository.save(subPolicy19);
        iSubPolicyRepository.save(subPolicy20);
        iSubPolicyRepository.save(subPolicy21);
        iSubPolicyRepository.save(subPolicy22);
        iSubPolicyRepository.save(subPolicy23);
        iSubPolicyRepository.save(subPolicy24);
        iSubPolicyRepository.save(subPolicy25);
        iSubPolicyRepository.save(subPolicy26);
        iSubPolicyRepository.save(subPolicy27);
        iSubPolicyRepository.save(subPolicy28);
        iSubPolicyRepository.save(subPolicy29);
        iSubPolicyRepository.save(subPolicy30);
        iSubPolicyRepository.save(subPolicy31);
        iSubPolicyRepository.save(subPolicy32);
        iSubPolicyRepository.save(subPolicy33);
        iSubPolicyRepository.save(subPolicy34);
        iSubPolicyRepository.save(subPolicy35);
        iSubPolicyRepository.save(subPolicy36);
    }
}
