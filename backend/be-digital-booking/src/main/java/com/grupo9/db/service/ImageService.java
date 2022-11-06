package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Image;
import com.grupo9.db.repository.IImageRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    private final IImageRepository repository;
    private ResponsesBuilder responsesBuilder;

    public ImageService(IImageRepository repository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<Image>, Object>> findAll(){
        List<Image> images = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Image List successfully",images, null);
    }

    public ResponseEntity<ApiResponse<Image, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<Image> image = repository.findById(id);
        if(image.isEmpty()){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Image successfully", image.get(), null);
    }

    public ResponseEntity<ApiResponse<Image, Object>> save(Image image){
        Image response = repository.save(image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Image, Object>> update(Long id, Image image) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }

        image.setId(id);
        Image response = repository.save(image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image updated successfully", response, null);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }

        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Image deleted successfully", null, null);
    }

}
