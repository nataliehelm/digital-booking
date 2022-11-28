package com.grupo9.db.controller;

import com.grupo9.db.dto.Favorite.SaveFavoriteDto;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Favorite;
import com.grupo9.db.service.FavoriteService;
import com.grupo9.db.util.ResponsesBuilder;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    ResponsesBuilder responsesBuilder;

    @PostMapping
    public ResponseEntity<String> addFavorite(@RequestBody SaveFavoriteDto saveFavoriteDto) throws ResourceNotFoundException {
        Favorite response = favoriteService.addFavorite(saveFavoriteDto);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product added to favorites successfully", response, null);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFavorite(@RequestBody SaveFavoriteDto saveFavoriteDto) throws ResourceNotFoundException {
        favoriteService.deleteFavorite(saveFavoriteDto);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Product deleted from favorites successfully", null, null);
    }
}
