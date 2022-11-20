package com.grupo9.db.repository;

import com.grupo9.db.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface IBookingRepository extends JpaRepository<Booking, Long> {

//    List<Booking> findByDateInOut(String starting_date, String ending_date);
}
