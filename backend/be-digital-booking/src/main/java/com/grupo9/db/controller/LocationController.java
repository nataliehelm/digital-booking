package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.service.LocationService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Location>, Object>> findAll(){
        List<Location> locations = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Location List successfully",locations, null);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Location, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Location location = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Location successfully", location, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Location, Object>> save(@RequestBody @Valid Location location){
        Location response = service.save(location);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Location created successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Location, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody Location location) throws ResourceNotFoundException, BadRequestException {
        Location response = service.update(id, location);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Location updated successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.NO_CONTENT.value(),"Location deleted successfully", null, null);

    }

}
