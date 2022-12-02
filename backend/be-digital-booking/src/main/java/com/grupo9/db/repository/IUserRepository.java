package com.grupo9.db.repository;

import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

    @Query(value = "SELECT product.* " +
            "FROM digital_booking_g9.user users " +
            "LEFT JOIN digital_booking_g9.product products " +
            "ON users.product_id = products.id " +
            "WHERE products.id = :user_id ", nativeQuery = true)
    List<Product> findProductsByUserId(@Param("userId") Long userId);
}
