package com.grupo9.db.service;

import com.grupo9.db.dto.Bookings.SaveBookingAndUpdateUserDto;
import com.grupo9.db.dto.Bookings.SaveBookingDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.repository.IBookingRepository;
import com.grupo9.db.repository.IUserRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookingService {
    private IBookingRepository iBookingRepository;
    private IProductRepository iProductRepository;
    private IUserRepository iUserRepository;
    private ILocationRepository iLocationRepository;
    private ResponsesBuilder responsesBuilder;

    public BookingService(IBookingRepository iBookingRepository, IProductRepository iProductRepository, IUserRepository iUserRepository, ILocationRepository iLocationRepository, ResponsesBuilder responsesBuilder) {
        this.iBookingRepository = iBookingRepository;
        this.iProductRepository = iProductRepository;
        this.iUserRepository = iUserRepository;
        this.iLocationRepository = iLocationRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public List<Booking> findAll(){
        List<Booking> bookings = iBookingRepository.findAll();
        return bookings;
    }

    public List<Booking> findByParams(Map<String, String> params) throws BadRequestException {
        if(params.get("productId") != null){
            Long productId = Long.valueOf(params.get("productId"));
            return iBookingRepository.findBookedDatesByProductId(productId);
        }
        throw new BadRequestException("Invalid Params");
    }

    public List<Booking> findAllBookingsByProductId(Long productId) {
        List<Booking> bookings = iBookingRepository.findBookedDatesByProductId(productId);
        return bookings;
    }

    public Booking findById(Long id) throws ResourceNotFoundException {
        Optional<Booking> booking = iBookingRepository.findById(id);
        if(booking.isEmpty()){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        return booking.get();
    }

    public Booking save(SaveBookingDto bookingDto) throws ResourceNotFoundException {
        Booking booking = bookingBuilder(bookingDto, null);
        return iBookingRepository.save(booking);
    }

    public Booking saveBookingAndUpdateUser(SaveBookingAndUpdateUserDto dto) throws ResourceNotFoundException {
        Optional<Location> location = iLocationRepository.findById(dto.getLocationId());
        if(location.isEmpty()){
            throw new ResourceNotFoundException("Location with id " + dto.getLocationId() + " not found");
        }
        SaveBookingDto bookingToSave = new SaveBookingDto(dto.getStarting_time(), dto.getStarting_date(), dto.getEnding_date(), dto.getProductId(), dto.getUserId());
        Booking booking = bookingBuilder(bookingToSave, null);
        User currentUser = booking.getUser();
        currentUser.setLocation(location.get());
        booking.setUser(currentUser);
        return iBookingRepository.save(booking);
    }

    public Booking update(Long id, SaveBookingDto bookingDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = iBookingRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        Booking booking = bookingBuilder(bookingDto, id);
        return iBookingRepository.save(booking);
    }

     public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = iBookingRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        iBookingRepository.deleteById(id);
    }


    private Booking bookingBuilder (SaveBookingDto bookingDto, Long id) throws ResourceNotFoundException {


        Optional<Product> product = iProductRepository.findById(bookingDto.getProductId());
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + bookingDto.getProductId() + " not found");
        }

        Optional<User> user = iUserRepository.findById(bookingDto.getUserId());
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + bookingDto.getUserId() + " not found");
        }


        if(id != null){
            return new Booking(id, bookingDto.getStarting_time(), bookingDto.getStarting_date(), bookingDto.getEnding_date(), product.get(), user.get());
        }

        return new Booking(bookingDto.getStarting_time(), bookingDto.getStarting_date(), bookingDto.getEnding_date(), product.get(), user.get());
    }

}
