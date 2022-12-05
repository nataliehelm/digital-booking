package com.grupo9.db.repository;

import com.grupo9.db.model.Booking;
import com.grupo9.db.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

    @Query(value = "SELECT booking.* " +
            "FROM digital_booking_g9.user users " +
            "LEFT JOIN digital_booking_g9.booking bookings " +
            "ON users.product_id = bookings.id " +
            "WHERE bookings.id = :user_id ", nativeQuery = true)
    Page<Booking> findAllBookingsByUserId (@Param("userId") Long userId, Pageable pageable);
}
