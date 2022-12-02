package com.grupo9.db.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.db.dto.Favorite.SaveFavoriteDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Favorite;
import com.grupo9.db.repository.IFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    @Autowired
    IFavoriteRepository favoriteRepository;

    @Autowired
    ObjectMapper mapper;

    public List<Favorite> findAll(){
        List<Favorite> favorites = favoriteRepository.findAll();
        return favorites;
    }

    public Favorite addFavorite(SaveFavoriteDto saveFavoriteDto) {
        favoriteRepository.save(mapper.convertValue(saveFavoriteDto, Favorite.class));
        return null;
    }
    public void deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = favoriteRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Booking with id " + id + " not found");
        }
        favoriteRepository.deleteById(id);
    }
}
