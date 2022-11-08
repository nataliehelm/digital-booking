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

        Image image1 = new Image("Hermitage Hotel 1", "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product1);
        Image image2 = new Image("Hermitage Hotel 2", "https://images.unsplash.com/photo-1621293954908-907159247fc8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80", product1);
        Image image3 = new Image("Hermitage Hotel 3", "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1472&q=80", product1);
        Image image4 = new Image("Hermitage Hotel 4", "https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1121&q=80", product1);
        Image image5 = new Image("Hermitage Hotel 5", "https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80", product1);
        Image image6 = new Image("Hotel Casino Magic 1", "https://cf.bstatic.com/xdata/images/hotel/max1280x900/25406927.jpg?k=1fa63f199fdcfd819f85625a911f073be33ba86c02b8a2ea9887a591b52feb6d&o=&hp=1", product2);
        Image image7 = new Image("Hotel Casino Magic 2", "https://casinomagic.com.ar/wp-content/uploads/2014/01/1036_hotel-magic.jpg", product2);
        Image image8 = new Image("Hotel Casino Magic 3", "https://casinomagic.com.ar/wp-content/uploads/2014/01/JCR6784.jpg", product2);
        Image image9 = new Image("Hotel Casino Magic 4", "https://casinomagic.com.ar/wp-content/uploads/2014/01/Institucional_0424.jpg", product2);
        Image image10 = new Image("Hotel Casino Magic 5", "https://casinomagic.com.ar/wp-content/uploads/2014/01/1060_hotel-magic.jpg", product2);
        Image image11 = new Image("Hostel Danny 1", "https://images.unsplash.com/photo-1623625434462-e5e42318ae49?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80", product3);
        Image image12 = new Image("Hostel Danny 2","https://images.unsplash.com/photo-1555854877-bab0e564b8d5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80" , product3);
        Image image13 = new Image("Hostel Danny 3", "https://images.unsplash.com/photo-1626265774643-f1943311a86b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80" , product3);
        Image image14 = new Image("Hostel Danny 4"," https://cf.bstatic.com/xdata/images/hotel/max1024x768/399464424.jpg?k=dc3bf1c11aea33a3146025556de6a0ca97d4ad95ecd2ddf8150eaa87ba730ff2&o=&hp=1", product3);
        Image image15 = new Image("Hostel Danny 5", "http://res.cloudinary.com/hostelling-internation/image/upload/f_auto,q_auto/v1565973406/kwunkr44mtjdrqrzz3s7.jpg" , product3);
        Image image16 = new Image("Heaven Catedral 1", "https://pix10.agoda.net/hotelImages/14090026/0/4ae319e43ccf884ad991b4ea2a3a995b.jpg?ca=14&ce=1&s=1024x768", product4);
        Image image17 = new Image("Heaven Catedral 2", "https://cf.bstatic.com/xdata/images/hotel/max1024x768/236658489.jpg?k=a3ee99d083c0fed1b6817ef446b20d655e825f3371153e6dbc19d7b1857e7a4f&o=&hp=1", product4);
        Image image18 = new Image("Heaven Catedral 3", "https://cf.bstatic.com/xdata/images/hotel/max1280x900/237183718.jpg?k=22559619e681a686125474403ed5142dd8f607c5223f955eb87af79a6aa96915&o=&hp=1", product4);
        Image image19 = new Image("Heaven Catedral 4", "https://www.michaycatedral.com.ar/nueva/wp-content/uploads/2020/02/7-6.jpg", product4);
        Image image20 = new Image("Heaven Catedral 5", "https://images.unsplash.com/photo-1517404656827-b10222b9ec59?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1169&q=80", product4);
        Image image21 = new Image("La Paula bed & breakfast 1", "https://images.unsplash.com/photo-1664361238207-164532d1934e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1171&q=80", product5);
        Image image22 = new Image("La Paula bed & breakfast 2", "https://images.unsplash.com/photo-1431905673613-8b0122cb1196?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product5);
        Image image23 = new Image("La Paula bed & breakfast 3", "https://images.unsplash.com/photo-1462530260150-162092dbf011?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1086&q=80", product5);
        Image image24 = new Image("La Paula bed & breakfast 4", "https://images.unsplash.com/photo-1576095910326-9de5a8b207e4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1331&q=80", product5);
        Image image25 = new Image("La Paula bed & breakfast 5", "https://images.unsplash.com/photo-1623114112821-08b8c8d4e42d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product5);



        iImageRepository.save(image1);
        iImageRepository.save(image2);
        iImageRepository.save(image3);
        iImageRepository.save(image4);
        iImageRepository.save(image5);
        iImageRepository.save(image6);
        iImageRepository.save(image7);
        iImageRepository.save(image8);
        iImageRepository.save(image9);
        iImageRepository.save(image10);
        iImageRepository.save(image11);
        iImageRepository.save(image12);
        iImageRepository.save(image13);
        iImageRepository.save(image14);
        iImageRepository.save(image15);
        iImageRepository.save(image16);
        iImageRepository.save(image17);
        iImageRepository.save(image18);
        iImageRepository.save(image19);
        iImageRepository.save(image20);
        iImageRepository.save(image21);
        iImageRepository.save(image22);
        iImageRepository.save(image23);
        iImageRepository.save(image24);
        iImageRepository.save(image25);



    }
}
