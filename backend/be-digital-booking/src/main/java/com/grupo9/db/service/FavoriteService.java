package com.grupo9.db.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.db.dto.Favorite.SaveFavoriteDto;
import com.grupo9.db.dto.Product.SaveProductDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.*;
import com.grupo9.db.repository.IFavoriteRepository;
import com.grupo9.db.repository.IProductRepository;
import com.grupo9.db.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    IFavoriteRepository favoriteRepository;
    @Autowired
    IProductRepository productRepository;
    @Autowired
    IUserRepository userRepository;

    @Autowired
    ObjectMapper mapper;

    public List<Favorite> findAll(){
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites;
    }

    public List<Favorite> findAllFavoritesByUserId(Long userId) {
        List<Favorite> favorites = favoriteRepository.findFavoritesByUserId(userId);
        return favorites;
    }

    public Favorite save(SaveFavoriteDto saveFavoriteDto) throws ResourceNotFoundException {
        Favorite favorite = favoriteBuilder(saveFavoriteDto);
        return favoriteRepository.save(favorite);
    }

    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = favoriteRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        favoriteRepository.deleteById(id);
    }

    private Favorite favoriteBuilder (SaveFavoriteDto favoriteDto) throws ResourceNotFoundException {
        Optional<Product> product = productRepository.findById(favoriteDto.getProduct_id());
        if(product.isEmpty()){
            throw new ResourceNotFoundException("Product with id " + favoriteDto.getProduct_id() + " not found");
        }
        Optional<User> user = userRepository.findById(favoriteDto.getUser_id());
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User with id " + favoriteDto.getUser_id() + " not found");
        }

        return new Favorite(product.get(), user.get());
    }

}
