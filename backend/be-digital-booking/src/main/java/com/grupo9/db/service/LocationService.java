package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Location;
import com.grupo9.db.repository.ILocationRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    private final ILocationRepository iLocationRepository;
    private ResponsesBuilder responsesBuilder;

    public LocationService(ILocationRepository iLocationRepository, ResponsesBuilder responsesBuilder) {
        this.iLocationRepository = iLocationRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse> findAll(){
        List<Location> locations = iLocationRepository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Location List successfully",locations);
    }

    public ResponseEntity<ApiResponse> findById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Optional<Location> location = iLocationRepository.findById(id);
        if(location.isEmpty()){
            throw new ResourceNotFoundException("Location with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Location successfully", location.get());
    }

    public ResponseEntity<ApiResponse> save(Location location){
        Location response = iLocationRepository.save(location);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Location created successfully", location);
    }

    public ResponseEntity<ApiResponse> update(Long id, Location location) throws ResourceNotFoundException, BadRequestException {
        location.setId(id);
        this.findById(location.getId());
        Location response = iLocationRepository.save(location);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Location updated successfully", location);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        this.findById(id);
        iLocationRepository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Location deleted successfully", "");
    }

}
