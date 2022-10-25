package com.grupo9.db.util;

import com.grupo9.db.model.Category;
import com.grupo9.db.repository.ICategoryRepository;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.util.Loader.CategoriesLoader;
import com.grupo9.db.util.Loader.LocationsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private ICategoryRepository iCategoryRepository;
    @Autowired
    private ILocationRepository iLocationRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        CategoriesLoader categoriesLoader = new CategoriesLoader(iCategoryRepository);
        categoriesLoader.Loader();
        LocationsLoader locationsLoader = new LocationsLoader(iLocationRepository);
        locationsLoader.Loader();

    }
}
