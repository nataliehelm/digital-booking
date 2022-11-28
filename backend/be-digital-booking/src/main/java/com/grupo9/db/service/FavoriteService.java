package com.grupo9.db.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo9.db.dto.Favorite.SaveFavoriteDto;
import com.grupo9.db.model.Favorite;
import com.grupo9.db.repository.IFavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    IFavoriteRepository favoriteRepository;

    @Autowired
    ObjectMapper mapper;

    public Favorite addFavorite(SaveFavoriteDto saveFavoriteDto) {
        favoriteRepository.save(mapper.convertValue(saveFavoriteDto, Favorite.class));
        return null;
    }

    public void deleteFavorite(SaveFavoriteDto saveFavoriteDto) {
        favoriteRepository.deleteByProductIdAndUserId(saveFavoriteDto.getProduct(), saveFavoriteDto.getUser());
    }
}
