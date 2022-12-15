package com.grupo9.db.util.Loader;

import com.grupo9.db.model.*;
import com.grupo9.db.repository.*;

public class ImagesLoader {

    IImageRepository iImageRepository;
    IProductRepository iProductRepository;

    public ImagesLoader(IImageRepository iImageRepository, IProductRepository iProductRepository) {
        this.iImageRepository = iImageRepository;
        this.iProductRepository = iProductRepository;
    }

    public void Loader (){

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
        Product product11 = iProductRepository.findById(11L).get();
        Product product12 = iProductRepository.findById(12L).get();

        Image image1 = new Image("Hermitage Hotel 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hermitage+Hotel/photo-1590073242678-70ee3fc28e8e.jpg", product1);
        Image image2 = new Image("Hermitage Hotel 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hermitage+Hotel/photo-1611048267451-e6ed903d4a38.jpg", product1);
        Image image3 = new Image("Hermitage Hotel 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hermitage+Hotel/photo-1618773928121-c32242e63f39.jpg", product1);
        Image image4 = new Image("Hermitage Hotel 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hermitage+Hotel/photo-1621293954908-907159247fc8.jpg", product1);
        Image image5 = new Image("Hermitage Hotel 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hermitage+Hotel/photo-1631049307264-da0ec9d70304.jpg", product1);
        
        Image product2Image1 = new Image("Chalten Suites Hostel 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Chalten+Suites+Hostel/107494839.jpg", product2);
        Image product2Image2 = new Image("Chalten Suites Hostel 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Chalten+Suites+Hostel/259289089.jpg", product2);
        Image product2Image3 = new Image("Chalten Suites Hostel 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Chalten+Suites+Hostel/259289102.jpg", product2);
        Image product2Image4 = new Image("Chalten Suites Hostel 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Chalten+Suites+Hostel/303515810.jpg", product2);
        Image product2Image5 = new Image("Chalten Suites Hostel 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Chalten+Suites+Hostel/43136331.jpg", product2);

        Image product3Image1 = new Image("El Cerquero, Casa de Huéspedes 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/El+Cerquero%2C+Casa+de+Hu%C3%A9spedes/298707909.jpg", product3);
        Image product3Image2 = new Image("El Cerquero, Casa de Huéspedes 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/El+Cerquero%2C+Casa+de+Hu%C3%A9spedes/298707952.jpg", product3);
        Image product3Image3 = new Image("El Cerquero, Casa de Huéspedes 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/El+Cerquero%2C+Casa+de+Hu%C3%A9spedes/298707986.jpg", product3);
        Image product3Image4 = new Image("El Cerquero, Casa de Huéspedes 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/El+Cerquero%2C+Casa+de+Hu%C3%A9spedes/298707990.jpg", product3);
        Image product3Image5 = new Image("El Cerquero, Casa de Huéspedes 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/El+Cerquero%2C+Casa+de+Hu%C3%A9spedes/298707992.jpg", product3);

        Image product4Image1 = new Image("Uriburu B&B 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Uriburu+B%26B/373150652.jpg", product4);
        Image product4Image2 = new Image("Uriburu B&B 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Uriburu+B%26B/373150712.jpg", product4);
        Image product4Image3 = new Image("Uriburu B&B 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Uriburu+B%26B/373150715.jpg", product4);
        Image product4Image4 = new Image("Uriburu B&B 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Uriburu+B%26B/375637837.jpg", product4);
        Image product4Image5 = new Image("Uriburu B&B 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Uriburu+B%26B/375637839.jpg", product4);

        Image product5Image1 = new Image("Tpyn Hotel 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Tpyn+Hotel/photo-1556438758-8d49568ce18e.jpg", product5);
        Image product5Image2 = new Image("Tpyn Hotel 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Tpyn+Hotel/photo-1568495248636-6432b97bd949.jpg", product5);
        Image product5Image3 = new Image("Tpyn Hotel 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Tpyn+Hotel/photo-1590490360182-c33d57733427.jpg", product5);
        Image product5Image4 = new Image("Tpyn Hotel 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Tpyn+Hotel/photo-1605346434674-a440ca4dc4c0.jpg", product5);
        Image product5Image5 = new Image("Tpyn Hotel 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Tpyn+Hotel/photo-1631049552057-403cdb8f0658.jpg", product5);

        Image product6Image1 = new Image("Wyndham Hotel 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Wyndham+Hotel/photo-1566665797739-1674de7a421a.jpg", product6);
        Image product6Image2 = new Image("Wyndham Hotel 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Wyndham+Hotel/photo-1586105251261-72a756497a11.jpg", product6);
        Image product6Image3 = new Image("Wyndham Hotel 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Wyndham+Hotel/photo-1595576508898-0ad5c879a061.jpg", product6);
        Image product6Image4 = new Image("Wyndham Hotel 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Wyndham+Hotel/photo-1629140727571-9b5c6f6267b4.jpg", product6);
        Image product6Image5 = new Image("Wyndham Hotel 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Wyndham+Hotel/photo-1630660664869-c9d3cc676880.jpg", product6);

        Image product7Image1 = new Image("Corrientes Plaza Hostel 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Corrientes+Plaza+Hostel/photo-1562438668-bcf0ca6578f0.jpg", product7);
        Image product7Image2 = new Image("Corrientes Plaza Hostel 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Corrientes+Plaza+Hostel/photo-1578898886225-c7c894047899.jpg", product7);
        Image product7Image3 = new Image("Corrientes Plaza Hostel 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Corrientes+Plaza+Hostel/photo-1609766857041-ed402ea8069a.jpg", product7);
        Image product7Image4 = new Image("Corrientes Plaza Hostel 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Corrientes+Plaza+Hostel/photo-1610392734074-02f696fd30a8.jpg", product7);
        Image product7Image5 = new Image("Corrientes Plaza Hostel 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Corrientes+Plaza+Hostel/photo-1631049421450-348ccd7f8949.jpg", product7);

        Image product8Image1 = new Image("Parivaar Hotel 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Parivaar+Hotel/photo-1587985064135-0366536eab42.jpg", product8);
        Image product8Image2 = new Image("Parivaar Hotel 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Parivaar+Hotel/photo-1616046229478-9901c5536a45.jpg", product8);
        Image product8Image3 = new Image("Parivaar Hotel 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Parivaar+Hotel/photo-1618221118493-9cfa1a1c00da.jpg", product8);
        Image product8Image4 = new Image("Parivaar Hotel 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Parivaar+Hotel/photo-1621293954908-907159247fc8.jpg", product8);
        Image product8Image5 = new Image("Parivaar Hotel 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Parivaar+Hotel/photo-1631049552240-59c37f38802b.jpg", product8);

        Image product9Image1 = new Image("Hotel Casino Magic 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Casino+Magic/1036_hotel-magic.jpg", product9);
        Image product9Image2 = new Image("Hotel Casino Magic 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Casino+Magic/1060_hotel-magic.jpg", product9);
        Image product9Image3 = new Image("Hotel Casino Magic 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Casino+Magic/25406927.jpg", product9);
        Image product9Image4 = new Image("Hotel Casino Magic 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Casino+Magic/Institucional_0424.jpg", product9);
        Image product9Image5 = new Image("Hotel Casino Magic 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Casino+Magic/JCR6784.jpg", product9);

        Image product10Image1 = new Image("Hostel Danny 1","https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Danny/399464424.jpg", product10);
        Image product10Image2 = new Image("Hostel Danny 2","https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Danny/kwunkr44mtjdrqrzz3s7.jpg" , product10);
        Image product10Image3 = new Image("Hostel Danny 3","https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Danny/photo-1555854877-bab0e564b8d5.jpg" , product10);
        Image product10Image4 = new Image("Hostel Danny 4","https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Danny/photo-1623625434462-e5e42318ae49.jpg", product10);
        Image product10Image5 = new Image("Hostel Danny 5","https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Hotel+Danny/photo-1626265774643-f1943311a86b.jpg" , product10);

        Image product11Image1 = new Image("Heaven Catedral 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Heaven+Catedral/236658489.jpg", product11);
        Image product11Image2 = new Image("Heaven Catedral 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Heaven+Catedral/237183718.jpg", product11);
        Image product11Image3 = new Image("Heaven Catedral 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Heaven+Catedral/4ae319e43ccf884ad991b4ea2a3a995b.jpg", product11);
        Image product11Image4 = new Image("Heaven Catedral 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Heaven+Catedral/7-6.jpg", product11);
        Image product11Image5 = new Image("Heaven Catedral 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/Heaven+Catedral/photo-1517404656827-b10222b9ec59.jpg", product11);
        
        Image product12Image1 = new Image("La Paula bed & breakfast 1", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/La+Paula+bed+%26+breackfast/photo-1431905673613-8b0122cb1196.jpg", product12);
        Image product12Image2 = new Image("La Paula bed & breakfast 2", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/La+Paula+bed+%26+breackfast/photo-1462530260150-162092dbf011.jpg", product12);
        Image product12Image3 = new Image("La Paula bed & breakfast 3", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/La+Paula+bed+%26+breackfast/photo-1576095910326-9de5a8b207e4.jpg", product12);
        Image product12Image4 = new Image("La Paula bed & breakfast 4", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/La+Paula+bed+%26+breackfast/photo-1623114112821-08b8c8d4e42d.jpg", product12);
        Image product12Image5 = new Image("La Paula bed & breakfast 5", "https://0521ptc6n2-grupo9-src.s3.us-east-2.amazonaws.com/La+Paula+bed+%26+breackfast/photo-1664361238207-164532d1934e.jpg", product12);

        iImageRepository.save(image1);
        iImageRepository.save(image2);
        iImageRepository.save(image3);
        iImageRepository.save(image4);
        iImageRepository.save(image5);

        iImageRepository.save(product2Image1);
        iImageRepository.save(product2Image2);
        iImageRepository.save(product2Image3);
        iImageRepository.save(product2Image4);
        iImageRepository.save(product2Image5);

        iImageRepository.save(product3Image1);
        iImageRepository.save(product3Image2);
        iImageRepository.save(product3Image3);
        iImageRepository.save(product3Image4);
        iImageRepository.save(product3Image5);

        iImageRepository.save(product4Image1);
        iImageRepository.save(product4Image2);
        iImageRepository.save(product4Image3);
        iImageRepository.save(product4Image4);
        iImageRepository.save(product4Image5);

        iImageRepository.save(product5Image1);
        iImageRepository.save(product5Image2);
        iImageRepository.save(product5Image3);
        iImageRepository.save(product5Image4);
        iImageRepository.save(product5Image5);

        iImageRepository.save(product6Image1);
        iImageRepository.save(product6Image2);
        iImageRepository.save(product6Image3);
        iImageRepository.save(product6Image4);
        iImageRepository.save(product6Image5);

        iImageRepository.save(product7Image1);
        iImageRepository.save(product7Image2);
        iImageRepository.save(product7Image3);
        iImageRepository.save(product7Image4);
        iImageRepository.save(product7Image5);

        iImageRepository.save(product8Image1);
        iImageRepository.save(product8Image2);
        iImageRepository.save(product8Image3);
        iImageRepository.save(product8Image4);
        iImageRepository.save(product8Image5);

        iImageRepository.save(product9Image1);
        iImageRepository.save(product9Image2);
        iImageRepository.save(product9Image3);
        iImageRepository.save(product9Image4);
        iImageRepository.save(product9Image5);

        iImageRepository.save(product10Image1);
        iImageRepository.save(product10Image2);
        iImageRepository.save(product10Image3);
        iImageRepository.save(product10Image4);
        iImageRepository.save(product10Image5);

        iImageRepository.save(product11Image1);
        iImageRepository.save(product11Image2);
        iImageRepository.save(product11Image3);
        iImageRepository.save(product11Image4);
        iImageRepository.save(product11Image5);

        iImageRepository.save(product12Image1);
        iImageRepository.save(product12Image2);
        iImageRepository.save(product12Image3);
        iImageRepository.save(product12Image4);
        iImageRepository.save(product12Image5);

    }
}
