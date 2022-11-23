package com.grupo9.db.repository;

import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page <Product> findByOrderByIdAsc(Pageable pageable);

    Page<Product> findByCategoryIn(List<Category> categories, Pageable pageable);

    Page<Product> findByLocation(Location location, Pageable pageable);
    
    Page<Product> findByLocationAndCategoryIn(Location location, List<Category> categories, Pageable pageable);

    @Query(value="SELECT * FROM product ORDER BY rand()", nativeQuery=true)
    Page<Product> findAllRandom(Pageable pageable);

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
    Page<Product> findAllByStartingDateAndEndingDate(@Param("startingDate") String startingDate, @Param("endingDate") String endingDate, Pageable pageable);

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
    Page <Product> findAllByStartingDateAndEndingDateAndLocation(@Param("locationId") String locationId, @Param("startingDate") String startingDate, @Param("endingDate") String endingDate, Pageable pageable);

}
