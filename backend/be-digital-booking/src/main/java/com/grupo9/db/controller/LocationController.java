package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Category;
import com.grupo9.db.model.Location;
import com.grupo9.db.service.LocationService;
import com.grupo9.db.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    private LocationService service;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Location>, Object>> findAll(){
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Location, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Location, Object>> save(@RequestBody Location location){
        return service.save(location);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Location, Object>> update(@PathVariable("id") Long id, @RequestBody Location location) throws ResourceNotFoundException, BadRequestException {
        return service.update(id, location);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        return service.deleteById(id);
    }

}
