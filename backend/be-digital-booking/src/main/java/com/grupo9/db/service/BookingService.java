package com.grupo9.db.service;

import com.grupo9.db.dto.Bookings.SaveBookingDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
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
import java.util.Optional;

@Service
public class BookingService {
    private IBookingRepository iBookingRepository;
    private IProductRepository iProductRepository;
    private IUserRepository iUserRepository;
    private ResponsesBuilder responsesBuilder;

    public BookingService(IBookingRepository iBookingRepository, IProductRepository iProductRepository, IUserRepository iUserRepository, ResponsesBuilder responsesBuilder) {
        this.iBookingRepository = iBookingRepository;
        this.iProductRepository = iProductRepository;
        this.iUserRepository = iUserRepository;
        this.responsesBuilder = responsesBuilder;
    }

    //listar todos
    public List<Booking> findAll(){
        List<Booking> bookings = iBookingRepository.findAll();
        return bookings;
    }

    //buscar por id
    public Booking findById(Long id) throws ResourceNotFoundException {
        Optional<Booking> booking = iBookingRepository.findById(id);
        if(booking.isEmpty()){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        return booking.get();
    }

    public ResponseEntity<ApiResponse<Booking, Object>> findByDate(String starting_date, String ending_date) throws ResourceNotFoundException, ParseException {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Date checkIn = formater.parse(starting_date);
        Date checkOut = formater.parse(ending_date);
        List<Booking> bookingDate = iBookingRepository.findbyDateInOut(starting_date, ending_date);
        if(bookingDate.isEmpty()){
            throw new ResourceNotFoundException("BookingDate with Date " + starting_date + ending_date + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Booking starting_date and ending_Date successfully", bookingDate, null);
    }

    //guardar
    public Booking save(SaveBookingDto bookingDto) throws ResourceNotFoundException {
        Booking booking = bookingBuilder(bookingDto, null);
        return iBookingRepository.save(booking);
    }

    //actualizar
    public Booking update(Long id, SaveBookingDto bookingDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = iBookingRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }

        Booking booking = bookingBuilder(bookingDto, id);
        return iBookingRepository.save(booking);
    }

    //eliminar
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
