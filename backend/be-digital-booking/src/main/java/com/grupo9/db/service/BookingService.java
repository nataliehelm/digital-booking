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
    public ResponseEntity<ApiResponse<List<Booking>, Object>> findAll(){
        List<Booking> booking = iBookingRepository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Booking List successfully",booking, null);
    }

    //buscar por id
    public ResponseEntity<ApiResponse<Booking, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<Booking> booking = iBookingRepository.findById(id);
        if(booking.isEmpty()){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Booking successfully", booking.get(), null);
    }

    //guardar
    public ResponseEntity<ApiResponse<Booking, Object>> save(SaveBookingDto bookingDto) throws ResourceNotFoundException {
        Booking booking = checkRelations(bookingDto, null);
        Booking response = iBookingRepository.save(booking);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Booking created successfully", response, null);
    }

    //actualizar
    public ResponseEntity<ApiResponse<Booking, Object>> update(Long id, SaveBookingDto bookingDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = iBookingRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }

        Booking booking = checkRelations(bookingDto, id);
        Booking response = iBookingRepository.save(booking);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Booking updated successfully", response, null);
    }

    //eliminar
    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = iBookingRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }

        iBookingRepository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Booking deleted successfully", null, null);
    }


    private Booking checkRelations (SaveBookingDto bookingDto, Long id) throws ResourceNotFoundException {


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
