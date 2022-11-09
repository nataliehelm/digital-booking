package com.grupo9.db.repository;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List <Product> findTop8ByOrderByIdAsc();

    List<Product> findTop8ByCategoryIn(List<Category> categories);

    List<Product> findByLocation(Location location);

    @Query(value="SELECT * FROM product ORDER BY rand() LIMIT 8", nativeQuery=true)
    List<Product> findAllRandom();
}
