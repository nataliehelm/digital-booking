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

    public ResponseEntity<ApiResponse> findAll(){
        List<Image> images = repository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Image List successfully",images);
    }

    public ResponseEntity<ApiResponse> findById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Optional<Image> image = repository.findById(id);
        if(image.isEmpty()){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Image successfully", image.get());
    }

    public ResponseEntity<ApiResponse> save(Image image){
        Image response = repository.save(image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image created successfully", response);
    }

    public ResponseEntity<ApiResponse> update(Long id, Image image) throws ResourceNotFoundException, BadRequestException {
        image.setId(id);
        this.findById(image.getId());
        Image response = repository.save(image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image updated successfully", response);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        this.findById(id);
        repository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.NO_CONTENT.value(),"Image deleted successfully", "");
    }

}
