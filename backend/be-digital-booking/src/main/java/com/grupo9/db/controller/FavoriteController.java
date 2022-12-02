package com.grupo9.db.controller;

import com.grupo9.db.dto.Favorite.SaveFavoriteDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Favorite;
import com.grupo9.db.model.Product;
import com.grupo9.db.service.FavoriteService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @Autowired
    ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Favorite>, Object>> findAll(){
        List<Favorite> favorites = favoriteService.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Favorite List successfully", favorites, null);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Favorite, Object>> addFavorite(@RequestBody SaveFavoriteDto saveFavoriteDto) throws ResourceNotFoundException {
        Favorite favorites = favoriteService.addFavorite(saveFavoriteDto);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product added to favorites successfully", favorites, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        favoriteService.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Product deleted to favorites successfully", null, null);
    }
}