package com.grupo9.db.controller;
import com.grupo9.db.dto.Favorite.SaveFavoriteDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Favorite;
import com.grupo9.db.model.Product;
import com.grupo9.db.model.User;
import com.grupo9.db.service.FavoriteService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Favorite List successfully",favorites, null);
    }

    @GetMapping(path = "/{user_id}")
    public ResponseEntity<ApiResponse<List<Favorite>, Object>> findFavoritesByUserId(@PathVariable("user_id") Long userId){
        List<Favorite> favorites = favoriteService.findAllFavoritesByUserId(userId);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Favorite List successfully",favorites, null);
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Favorite, Object>> save (@RequestBody SaveFavoriteDto saveFavoriteDto) throws ResourceNotFoundException {
        System.out.println(saveFavoriteDto);
        Favorite favoriteSaved = favoriteService.save(saveFavoriteDto);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product added to favorites successfully", favoriteSaved, null);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        favoriteService.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Product de to favorites successfully", null, null);
    }
}