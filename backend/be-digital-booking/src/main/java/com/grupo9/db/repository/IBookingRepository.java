package com.grupo9.db.repository;

import com.grupo9.db.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IBookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "SELECT bookings.* " +
            "FROM digital_booking_g9.product products " +
            "LEFT JOIN digital_booking_g9.booking bookings " +
            "ON bookings.product_id = products.id " +
            "WHERE products.id = :locationId ", nativeQuery = true)
    List <Booking> findBookedDatesByProductId(@Param("locationId") Long locationId);



}
