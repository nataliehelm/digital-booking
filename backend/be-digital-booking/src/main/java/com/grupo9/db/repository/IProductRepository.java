package com.grupo9.db.repository;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, Long> {
    List <Product> findTop8ByOrderByIdAsc();

    List<Product> findTop8ByCategoryIn(List<Category> categories);

    List<Product> findTop8ByLocation(Location location);
    
    List<Product> findTop8ByLocationAndCategoryIn(Location location, List<Category> categories);

    @Query(value="SELECT * FROM product ORDER BY rand() LIMIT 8", nativeQuery=true)
    List<Product> findAllRandom();

    @Query(value="SELECT * " +
            "FROM digital_booking_g9.product " +
            "WHERE id NOT IN " +
            "(SELECT products.id " +
            "FROM digital_booking_g9.product products " +
            "LEFT JOIN digital_booking_g9.booking bookings " +
            "ON bookings.product_id = products.id " +
            "WHERE (bookings.starting_date BETWEEN :startingDate AND :endingDate OR bookings.ending_date BETWEEN :startingDate AND :endingDate) " +
            "OR (:startingDate BETWEEN bookings.starting_date AND bookings.ending_date OR :endingDate BETWEEN bookings.starting_date AND bookings.ending_date) " +
            "GROUP BY products.id);",
            nativeQuery=true)
    List<Product> findAllByStartingDateAndEndingDate(@Param("startingDate") String startingDate, @Param("endingDate") String endingDate);

    @Query(value="SELECT * " +
            "FROM digital_booking_g9.product " +
            "WHERE id NOT IN " +
            "(SELECT products.id " +
            "FROM digital_booking_g9.product products " +
            "LEFT JOIN digital_booking_g9.booking bookings " +
            "ON bookings.product_id = products.id " +
            "WHERE (bookings.starting_date BETWEEN :startingDate AND :endingDate OR bookings.ending_date BETWEEN :startingDate AND :endingDate) " +
            "OR (:startingDate BETWEEN bookings.starting_date AND bookings.ending_date OR :endingDate BETWEEN bookings.starting_date AND bookings.ending_date) " +
            "GROUP BY products.id) " +
            "AND location_id = :locationId;",
            nativeQuery=true)
    List <Product> findAllByStartingDateAndEndingDateAndLocation(@Param("locationId") String locationId, @Param("startingDate") String startingDate, @Param("endingDate") String endingDate);
}
