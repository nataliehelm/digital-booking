package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
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

    public List<Location> findAll(){
        List<Location> locations = iLocationRepository.findAll();
        return locations;
        }

    public Location findById(Long id) throws ResourceNotFoundException {
        Optional<Location> location = iLocationRepository.findById(id);
        if(location.isEmpty()){
            throw new ResourceNotFoundException("Location with id " + id + " not found");
        }
        return location.get();
    }

    public Location save(Location location){
        return iLocationRepository.save(location);
    }

    public Location update(Long id, Location location) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = iLocationRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Location with id " + id + " not found");
        }

        location.setId(id);
        return iLocationRepository.save(location);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = iLocationRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Location with id " + id + " not found");
        }
        iLocationRepository.deleteById(id);
    }

}
