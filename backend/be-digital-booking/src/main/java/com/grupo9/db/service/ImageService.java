package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.dto.Image.SaveImageDto;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Image;
import com.grupo9.db.model.Product;
import com.grupo9.db.repository.IImageRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageService {
    private final IImageRepository repository;
    private final IProductRepository productRepository;
    private AmazonClient amazonClient;
    private ResponsesBuilder responsesBuilder;

    public ImageService(IImageRepository repository, IProductRepository productRepository, AmazonClient amazonClient, ResponsesBuilder responsesBuilder) {
        this.repository = repository;
        this.productRepository = productRepository;
        this.amazonClient = amazonClient;
        this.responsesBuilder = responsesBuilder;
    }

    public List<Image> findAll(){
        List<Image> images = repository.findAll();
        return images;
    }

    public Image findById(Long id) throws ResourceNotFoundException {
        Optional<Image> image = repository.findById(id);
        if(image.isEmpty()){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }

        return image.get();
    }

    public Image save(SaveImageDto imageDto) throws ResourceNotFoundException, BadRequestException {
        Image image = imageBuilder(imageDto, null);
        return repository.save(image);
    }

    public Image update(Long id, SaveImageDto imageDto) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }

        Image image = imageBuilder(imageDto, id);
        return repository.save(image);
        }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = repository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Image with id " + id + " not found");
        }
        repository.deleteById(id);
        }


    public void deleteByUrl(Map<String, String> params) throws ResourceNotFoundException, BadRequestException {
        if(params.get("url") != null) {
            Optional<Image> image = repository.findByUrl(params.get("url"));
            if (image.isEmpty()) {
                throw new ResourceNotFoundException("Image with url " + params.get("url")  + " not found in DB");
            }
            repository.deleteById(image.get().getId());
            amazonClient.deleteFileFromS3Bucket(params.get("url") );
            return;
        }
        throw new BadRequestException("Invalid URL");
    }

    private Image imageBuilder (SaveImageDto imageDto, Long id) throws ResourceNotFoundException {

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
