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

        Image image1 = new Image("Hermitage Hotel 1", "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product1);
        Image image2 = new Image("Hermitage Hotel 2", "https://images.unsplash.com/photo-1621293954908-907159247fc8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80", product1);
        Image image3 = new Image("Hermitage Hotel 3", "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1472&q=80", product1);
        Image image4 = new Image("Hermitage Hotel 4", "https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1121&q=80", product1);
        Image image5 = new Image("Hermitage Hotel 5", "https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80", product1);
        
        Image product2Image1 = new Image("Chalten Suites Hostel 1", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/107494839.jpg?k=00c7582dbb6ff7c9c21367043cd5929022abbb48d36f7dd693c9159e0fe244f3&o=&hp=1", product2);
        Image product2Image2 = new Image("Chalten Suites Hostel 2", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/259289089.jpg?k=66211940d4a8c90348e5b569a4815d83caaa17b78381db140604f71bee65eb06&o=&hp=1", product2);
        Image product2Image3 = new Image("Chalten Suites Hostel 3", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/43136331.jpg?k=e5264cb958491ef42fbbcf3bf7a1f6a29332ad17146ff41d625592fff40b1a25&o=&hp=1", product2);
        Image product2Image4 = new Image("Chalten Suites Hostel 4", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/259289102.jpg?k=8f748269397a1b2bb04e9460fc22566e1b9afb9bdce41d07b6c3fdfe63b9fa73&o=&hp=1", product2);
        Image product2Image5 = new Image("Chalten Suites Hostel 5", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/43136270.jpg?k=f2c93717f2980644620aa1b04c6f2ba4984e3f79b4df2eedf7a93fbc5d693a47&o=&hp=1", product2);
        Image product2Image6 = new Image("Chalten Suites Hostel 6", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/303515810.jpg?k=c346561d54084cd36730668283307b17b13f3f28d6b1f5de8a31a4fde0bd26a6&o=&hp=1", product2);

        Image product3Image1 = new Image("El Cerquero, Casa de Huéspedes 1", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707961.jpg?k=2cd771db9a09ed409f284f94b4e1fe0fab003faae01a6aee4343a71885a2f6ed&o=&hp=1", product3);
        Image product3Image2 = new Image("El Cerquero, Casa de Huéspedes 2", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707909.jpg?k=c9a002636dbe9d6067ca76aef09c3e3f234fca375d360a03827c21f1d57b7e9c&o=&hp=1", product3);
        Image product3Image3 = new Image("El Cerquero, Casa de Huéspedes 3", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707952.jpg?k=406cd760f7b4e73c6413ed3cbef6393d57fbeb006600fd4b4d53c170dd20d33d&o=&hp=1", product3);
        Image product3Image4 = new Image("El Cerquero, Casa de Huéspedes 4", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707990.jpg?k=e0637dc1963fad06889858f9d3b76e2a34f03a766284ddf2cf85924994172922&o=&hp=1", product3);
        Image product3Image5 = new Image("El Cerquero, Casa de Huéspedes 5", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707986.jpg?k=4c4434f564b1a0ad96753f7329fe7426969c92a0256f2ec4a5ee4418ee28fb5a&o=&hp=1", product3);
        Image product3Image6 = new Image("El Cerquero, Casa de Huéspedes 6", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/298707992.jpg?k=7c45fadbde078afa9fc4802aef9dcf79963cd87352fa3137c4639c9eb5acf140&o=&hp=1", product3);

        Image product4Image1 = new Image("Uriburu B&B 1", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/373150652.jpg?k=0bd705969ba3b6168c3c2fd7bea4e1bf09bfa955c19cd78b43a2566b14ba8903&o=&hp=1", product4);
        Image product4Image2 = new Image("Uriburu B&B 2", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/373150715.jpg?k=3783f81df95c414cb0f7dc37144a007ceca728203a6d5e561b372651c46b56cc&o=&hp=1", product4);
        Image product4Image3 = new Image("Uriburu B&B 3", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/375637837.jpg?k=323cf39616aee674fe3982d09045f314f2791f8e534e568988b5ddbacfbf3460&o=&hp=1", product4);
        Image product4Image4 = new Image("Uriburu B&B 4", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/375637838.jpg?k=2e58ba02ee5636f9d7e963d1c9c542d9c40d3afcf005a9a2e484a85ec0803cc2&o=&hp=1", product4);
        Image product4Image5 = new Image("Uriburu B&B 5", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/375637839.jpg?k=9c526fb72b5cb7bcf614ab22b32d726b5766a5ecfb0ed5ce406f5a4635f496cc&o=&hp=1", product4);
        Image product4Image6 = new Image("Uriburu B&B 6", "https://t-cf.bstatic.com/xdata/images/hotel/max1280x900/373150712.jpg?k=e5be67fd24d248da46c65a5a1f3c91bfcf46cff15545c97c17abb86715d3dadb&o=&hp=1", product4);

        Image product5Image1 = new Image("Tpyn Hotel 1", "https://images.unsplash.com/flagged/photo-1556438758-8d49568ce18e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=874&q=80", product5);
        Image product5Image2 = new Image("Tpyn Hotel 2", "https://images.unsplash.com/photo-1568495248636-6432b97bd949?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", product5);
        Image product5Image3 = new Image("Tpyn Hotel 3", "https://images.unsplash.com/photo-1590490360182-c33d57733427?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", product5);
        Image product5Image4 = new Image("Tpyn Hotel 4", "https://images.unsplash.com/photo-1605346434674-a440ca4dc4c0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", product5);
        Image product5Image5 = new Image("Tpyn Hotel 5", "https://images.unsplash.com/photo-1631049552057-403cdb8f0658?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", product5);

        Image product6Image1 = new Image("Wyndham Hotel 1", "https://images.unsplash.com/photo-1629140727571-9b5c6f6267b4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80", product6);
        Image product6Image2 = new Image("Wyndham Hotel 2", "https://images.unsplash.com/photo-1566665797739-1674de7a421a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", product6);
        Image product6Image3 = new Image("Wyndham Hotel 3", "https://images.unsplash.com/photo-1630660664869-c9d3cc676880?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", product6);
        Image product6Image4 = new Image("Wyndham Hotel 4", "https://images.unsplash.com/photo-1586105251261-72a756497a11?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=958&q=80", product6);
        Image product6Image5 = new Image("Wyndham Hotel 5", "https://images.unsplash.com/photo-1595576508898-0ad5c879a061?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=774&q=80", product6);

        Image product7Image1 = new Image("Corrientes Plaza Hostel 1", "https://images.unsplash.com/photo-1631049421450-348ccd7f8949?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", product7);
        Image product7Image2 = new Image("Corrientes Plaza Hostel 2", "https://images.unsplash.com/photo-1610392734074-02f696fd30a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", product7);
        Image product7Image3 = new Image("Corrientes Plaza Hostel 3", "https://images.unsplash.com/photo-1609766857041-ed402ea8069a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80", product7);
        Image product7Image4 = new Image("Corrientes Plaza Hostel 4", "https://images.unsplash.com/photo-1562438668-bcf0ca6578f0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1160&q=80", product7);
        Image product7Image5 = new Image("Corrientes Plaza Hostel 5", "https://images.unsplash.com/photo-1578898886225-c7c894047899?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80", product7);

        Image product8Image1 = new Image("Parivaar Hotel 1", "https://images.unsplash.com/photo-1587985064135-0366536eab42?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product8);
        Image product8Image2 = new Image("Parivaar Hotel 2", "https://images.unsplash.com/photo-1621293954908-907159247fc8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product8);
        Image product8Image3 = new Image("Parivaar Hotel 3", "https://images.unsplash.com/photo-1631049552240-59c37f38802b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product8);
        Image product8Image4 = new Image("Parivaar Hotel 4", "https://images.unsplash.com/photo-1618221118493-9cfa1a1c00da?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1632&q=80", product8);
        Image product8Image5 = new Image("Parivaar Hotel 5", "https://images.unsplash.com/photo-1616046229478-9901c5536a45?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80", product8);

        Image product9Image1 = new Image("Hotel Casino Magic 1", "https://cf.bstatic.com/xdata/images/hotel/max1280x900/25406927.jpg?k=1fa63f199fdcfd819f85625a911f073be33ba86c02b8a2ea9887a591b52feb6d&o=&hp=1", product9);
        Image product9Image2 = new Image("Hotel Casino Magic 2", "https://casinomagic.com.ar/wp-content/uploads/2014/01/1036_hotel-magic.jpg", product9);
        Image product9Image3 = new Image("Hotel Casino Magic 3", "https://casinomagic.com.ar/wp-content/uploads/2014/01/JCR6784.jpg", product9);
        Image product9Image4 = new Image("Hotel Casino Magic 4", "https://casinomagic.com.ar/wp-content/uploads/2014/01/Institucional_0424.jpg", product9);
        Image product9Image5 = new Image("Hotel Casino Magic 5", "https://casinomagic.com.ar/wp-content/uploads/2014/01/1060_hotel-magic.jpg", product9);

        Image product10Image1 = new Image("Hostel Danny 1", "https://images.unsplash.com/photo-1623625434462-e5e42318ae49?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80", product10);
        Image product10Image2 = new Image("Hostel Danny 2","https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80" , product10);
        Image product10Image3 = new Image("Hostel Danny 3", "https://images.unsplash.com/photo-1626265774643-f1943311a86b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80" , product10);
        Image product10Image4 = new Image("Hostel Danny 4"," https://cf.bstatic.com/xdata/images/hotel/max1024x768/399464424.jpg?k=dc3bf1c11aea33a3146025556de6a0ca97d4ad95ecd2ddf8150eaa87ba730ff2&o=&hp=1", product10);
        Image product10Image5 = new Image("Hostel Danny 5", "http://res.cloudinary.com/hostelling-internation/image/upload/f_auto,q_auto/v1565973406/kwunkr44mtjdrqrzz3s7.jpg" , product10);

        Image product11Image1 = new Image("Heaven Catedral 1", "https://pix10.agoda.net/hotelImages/14090026/0/4ae319e43ccf884ad991b4ea2a3a995b.jpg?ca=14&ce=1&s=1024x768", product11);
        Image product11Image2 = new Image("Heaven Catedral 2", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/236658489.jpg?k=a3ee99d083c0fed1b6817ef446b20d655e825f3371153e6dbc19d7b1857e7a4f&o=&hp=1", product11);
        Image product11Image3 = new Image("Heaven Catedral 3", "https://cf.bstatic.com/xdata/images/hotel/max1280x900/237183718.jpg?k=22559619e681a686125474403ed5142dd8f607c5223f955eb87af79a6aa96915&o=&hp=1", product11);
        Image product11Image4 = new Image("Heaven Catedral 4", "https://www.michaycatedral.com.ar/nueva/wp-content/uploads/2020/02/7-6.jpg", product11);
        Image product11Image5 = new Image("Heaven Catedral 5", "https://images.unsplash.com/photo-1517404656827-b10222b9ec59?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80", product11);
        
        Image product12Image1 = new Image("La Paula bed & breakfast 1", "https://images.unsplash.com/photo-1664361238207-164532d1934e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80", product12);
        Image product12Image2 = new Image("La Paula bed & breakfast 2", "https://images.unsplash.com/photo-1431905673613-8b0122cb1196?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product12);
        Image product12Image3 = new Image("La Paula bed & breakfast 3", "https://images.unsplash.com/photo-1462530260150-162092dbf011?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1086&q=80", product12);
        Image product12Image4 = new Image("La Paula bed & breakfast 4", "https://images.unsplash.com/photo-1576095910326-9de5a8b207e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1331&q=80", product12);
        Image product12Image5 = new Image("La Paula bed & breakfast 5", "https://images.unsplash.com/photo-1623114112821-08b8c8d4e42d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product12);

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
        iImageRepository.save(product2Image6);

        iImageRepository.save(product3Image1);
        iImageRepository.save(product3Image2);
        iImageRepository.save(product3Image3);
        iImageRepository.save(product3Image4);
        iImageRepository.save(product3Image5);
        iImageRepository.save(product3Image6);

        iImageRepository.save(product4Image1);
        iImageRepository.save(product4Image2);
        iImageRepository.save(product4Image3);
        iImageRepository.save(product4Image4);
        iImageRepository.save(product4Image5);
        iImageRepository.save(product4Image6);

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
