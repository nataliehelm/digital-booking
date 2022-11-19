package com.grupo9.db.repository;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List <Product> findTop8ByOrderByIdAsc();

    List<Product> findTop8ByCategoryIn(List<Category> categories);

    List<Product> findTop8ByLocation(Location location);
    
    List<Product> findTop8ByLocationAndCategoryIn(Location location, List<Category> categories);

    @Query(value="SELECT * FROM product ORDER BY rand() LIMIT 8", nativeQuery=true)
    List<Product> findAllRandom();

    List <Product> findbyBookingDate();
    List <Product> findbyBookingDateAndLocationId(Optional<Location> location, String starting_date, String ending_date);
}
