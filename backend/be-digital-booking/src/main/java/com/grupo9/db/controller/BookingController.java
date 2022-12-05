package com.grupo9.db.controller;

import com.grupo9.db.dto.Bookings.SaveBookingAndUpdateUserDto;
import com.grupo9.db.dto.Bookings.SaveBookingDto;
import com.grupo9.db.dto.Product.GetBookedDatesDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.model.Product;
import com.grupo9.db.service.BookingService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ObjectMapperUtils;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Booking>, Object>> findAll(){
        List<Booking> bookings = bookingService.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Booking List successfully",bookings, null);
    }
    @GetMapping(path = "/filters")
    public ResponseEntity<ApiResponse<List<Booking>, Object>> findByParams(@RequestParam Map<String, String> params) throws BadRequestException {
        List<Booking> bookings = bookingService.findByParams(params);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Booking List by Product Id successfully",bookings, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Booking, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Booking booking = bookingService.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Booking List successfully", booking, null);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Booking, Object>> save(@Valid @RequestBody SaveBookingDto saveBookingDto) throws ResourceNotFoundException {
        Booking response = bookingService.save(saveBookingDto);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Booking created successfully", response, null);
    }

    @PostMapping(path = "/create-with-user-update")
    public ResponseEntity<ApiResponse<Booking, Object>> saveBookingAndUpdateUser(@Valid @RequestBody SaveBookingAndUpdateUserDto dto) throws ResourceNotFoundException {
        Booking response = bookingService.saveBookingAndUpdateUser(dto);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Booking created successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Booking, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SaveBookingDto bookingDto) throws ResourceNotFoundException, BadRequestException {
        Booking response = bookingService.update(id, bookingDto);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Booking updated successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        bookingService.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Booking deleted successfully", null, null);
    }
}
