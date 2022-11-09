package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.dto.Image.SaveImageDto;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Image;
import com.grupo9.db.model.Product;
import com.grupo9.db.repository.IImageRepository;
import com.grupo9.db.repository.IProductRepository;
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
    private final IProductRepository productRepository;
    private ResponsesBuilder responsesBuilder;

    public ImageService(IImageRepository repository, IProductRepository productRepository, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.productRepository = productRepository;
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

    public ResponseEntity<ApiResponse<Image, Object>> save(SaveImageDto imageDto) throws ResourceNotFoundException, BadRequestException {
        Image image = checkRelations(imageDto, null);
        Image response = repository.save(image);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Image created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Image, Object>> update(Long id, SaveImageDto imageDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }

        Image image = checkRelations(imageDto, id);
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

    private Image checkRelations (SaveImageDto imageDto, Long id) throws ResourceNotFoundException {

        Optional<Product> product = productRepository.findById(imageDto.getProduct_id());

        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + imageDto.getProduct_id() + " not found");
        }

        if(id != null){
            return new Image(id, imageDto.getTitle(), imageDto.getUrl(), product.get());
        }

        return new Image(imageDto.getTitle(), imageDto.getUrl(), product.get());
    }

}
