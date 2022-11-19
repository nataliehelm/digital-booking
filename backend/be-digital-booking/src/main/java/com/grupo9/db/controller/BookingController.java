package com.grupo9.db.controller;

import com.grupo9.db.dto.Bookings.SaveBookingDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.service.BookingService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Booking>, Object>> findAll(){
        return bookingService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Booking, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return bookingService.findById(id);
    }

    @GetMapping(path = "/{date}")
    public ResponseEntity<ApiResponse<Booking, Object>> findByDate(@PathVariable("date") String starting_date, String ending_date) throws ResourceNotFoundException, ParseException {
        return bookingService.findByDate(starting_date, ending_date);
    }

  //  @GetMapping(path = "/{date}")
  //  public ResponseEntity<ApiResponse<Booking, Object>> findByDate(¿@RequestParam("date_from") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateFrom, @RequestParam("date_to") @DateTimeFormat(pattern = "dd-MM-yyyy") Date dateTo) throws ResourceNotFoundException {
  //      return bookingService.findByDate(dateFrom, dateTo);
  //  }


    @PostMapping
    public ResponseEntity<ApiResponse<Booking, Object>> save(@Valid @RequestBody SaveBookingDto saveBookingDto) throws ResourceNotFoundException {
        return bookingService.save(saveBookingDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Booking, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SaveBookingDto bookingDto) throws ResourceNotFoundException, BadRequestException {
        return bookingService.update(id, bookingDto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return bookingService.deleteById(id);
    }
}
