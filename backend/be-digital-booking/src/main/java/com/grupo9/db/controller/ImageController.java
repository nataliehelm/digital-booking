package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.dto.Image.SaveImageDto;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Image;
import com.grupo9.db.service.ImageService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    private ImageService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Image>, Object>> findAll(){
        List<Image> images = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Image List successfully",images, null);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Image, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        Image image = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Image successfully", image, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Image, Object>> save(@Valid @RequestBody SaveImageDto image) throws ResourceNotFoundException, BadRequestException {
        Image response = service.save(image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image created successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Image, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SaveImageDto image) throws ResourceNotFoundException, BadRequestException {
        Image response = service.update(id, image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image updated successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Image deleted successfully", null, null);

    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/")
    public ResponseEntity<ApiResponse> deleteByUrl(@RequestParam Map<String, String> params) throws ResourceNotFoundException, BadRequestException {
        service.deleteByUrl(params);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Image deleted successfully", null, null);
    }

}
