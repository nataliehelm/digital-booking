package com.grupo9.db.controller;

import com.grupo9.db.dto.Bookings.SaveBookingDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.service.BookingService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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