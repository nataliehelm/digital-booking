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

        Image image1 = new Image("Hermitage Hotel 1", "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80", product1);
        Image image2 = new Image("Hermitage Hotel 2", "https://images.unsplash.com/photo-1621293954908-907159247fc8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80", product1);
        Image image3 = new Image("Hermitage Hotel 3", "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1472&q=80", product1);
        Image image4 = new Image("Hermitage Hotel 4", "https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1121&q=80", product1);
        Image image5 = new Image("Hermitage Hotel 5", "https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80", product1);

        iImageRepository.save(image1);
        iImageRepository.save(image2);
        iImageRepository.save(image3);
        iImageRepository.save(image4);
        iImageRepository.save(image5);
    }
}
