package com.grupo9.db.repository;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    List<Product> findByLocation(Location location);
}
