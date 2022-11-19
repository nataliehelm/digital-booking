package com.grupo9.db.repository;

import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findbyDateInOut(String starting_date, String ending_date);
    List<Booking> findByProductId(Product id);
}
