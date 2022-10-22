package com.grupo9.db.util;

import com.grupo9.db.model.Category;
import com.grupo9.db.repository.ICategoryRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private ICategoryRepository iCategoryRepository;

    public DataLoader(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Category category1 = new Category("Hoteles", "807.105 hoteles", "https://images.unsplash.com/photo-1566073771259-6a8506099945?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80");
        Category category2 = new Category("Hostels", "807.105 hoteles", "https://images.unsplash.com/photo-1582719508461-905c673771fd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1925&q=80");
        Category category3 = new Category("Departamentos", "807.105 hoteles", "https://images.unsplash.com/photo-1502672260266-1c1ef2d93688?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1980&q=80");
        Category category4 = new Category("Bed and breakfast", "807.105 hoteles", "https://images.unsplash.com/photo-1584132905271-512c958d674a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070&q=80");

        iCategoryRepository.save(category1);
        iCategoryRepository.save(category2);
        iCategoryRepository.save(category3);
        iCategoryRepository.save(category4);
    }
}
