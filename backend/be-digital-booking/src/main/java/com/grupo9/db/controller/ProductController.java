package com.grupo9.db.controller;

import com.grupo9.db.dto.Product.SaveProductDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Product;
import com.grupo9.db.service.ProductService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>, Object>> findAll(@RequestHeader(value="Authorization", required = false) String token){
        List<Product> products = service.findAll(token);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List Random successfully",products, null);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Product, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        Product product = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product successfully", product, null);
    }

    @GetMapping(path = "/{id}/bookings")
    public ResponseEntity<ApiResponse<Product, Object>> findByIdWithBookings(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        return service.findByIdWithBookings(id);
    }

    @GetMapping(path = "/filters")
    public ResponseEntity<ApiResponse<List<Product>, Object>> findByParams(@RequestParam Map<String, String> params ) throws BadRequestException, ResourceNotFoundException {
        return service.findByParams(params);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Product, Object>> save(@Valid @RequestBody SaveProductDto product) throws ResourceNotFoundException {
        Product response =  service.save(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product created successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Product, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody SaveProductDto product) throws ResourceNotFoundException, BadRequestException {
        Product response = service.update(id, product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product updated successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Product deleted successfully", null, null);

    }

}
