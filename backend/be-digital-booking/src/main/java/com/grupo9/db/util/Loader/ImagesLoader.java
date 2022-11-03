package com.grupo9.db.util.Loader;

import com.grupo9.db.model.Feature;
import com.grupo9.db.model.Image;
import com.grupo9.db.repository.IFeatureRepository;
import com.grupo9.db.repository.IImageRepository;

public class ImagesLoader {

    IImageRepository repository;

    public ImagesLoader(IImageRepository repository) {
        this.repository = repository;
    }

    public void Loader (){

        Image image1 = new Image("Hotel 1", "https://images.unsplash.com/photo-1631049307264-da0ec9d70304?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80");
        Image image2 = new Image("Hotel 2", "https://images.unsplash.com/photo-1621293954908-907159247fc8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80");
        Image image3 = new Image("Hotel 3", "https://images.unsplash.com/photo-1611048267451-e6ed903d4a38?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1472&q=80");
        Image image4 = new Image("Hotel 4", "https://images.unsplash.com/photo-1590073242678-70ee3fc28e8e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1121&q=80");
        Image image5 = new Image("Hotel 5", "https://images.unsplash.com/photo-1618773928121-c32242e63f39?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1470&q=80Ï");

        repository.save(image1);
        repository.save(image2);
        repository.save(image3);
        repository.save(image4);
        repository.save(image5);
    }
}
