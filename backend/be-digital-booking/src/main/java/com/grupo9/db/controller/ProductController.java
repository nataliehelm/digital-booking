package com.grupo9.db.controller;

import com.grupo9.db.dto.Auth.JwtDto;
import com.grupo9.db.dto.Product.GetProductWithBookingsDto;
import com.grupo9.db.dto.Product.SaveFullProductDto;
import com.grupo9.db.dto.Product.SaveProductDto;
import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Product;
import com.grupo9.db.security.jwt.JwtUtils;
import com.grupo9.db.service.ProductService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<ApiResponse<Page<Product>, Object>> findAll(@RequestHeader(value="Authorization", required = false  ) String token, @PageableDefault(size = 8) Pageable pageable){
        Page<Product> products = service.findAll(token, pageable);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List Random successfully",products, null);
    }

    @GetMapping(path = "/page")
    public ResponseEntity<ApiResponse<Page<Product>, Object>> findAllPage(@PageableDefault(size = 8) Pageable pageable){
        Page<Product> products = service.findAllPage(pageable);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Product, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        Product product = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product successfully", product, null);
    }

    @GetMapping(path = "/{id}/bookings")
    public ResponseEntity<ApiResponse<Product, Object>> findByIdWithBookings(@PathVariable("id") Long id) throws ResourceNotFoundException  {
        GetProductWithBookingsDto response = service.findByIdWithBookings(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product successfully", response, null);
    }

    @GetMapping(path = "/filters")
    public ResponseEntity<ApiResponse<Page<Product>, Object>> findByParams(@RequestParam Map<String, String> params, @PageableDefault(size = 8) Pageable pageable ) throws BadRequestException, ResourceNotFoundException {
        Page<Product> products = service.findByParams(params, pageable);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/admin")
    public ResponseEntity<ApiResponse<Page<Product>, Object>> findByUser(@RequestHeader(value="Authorization" ) String token, @PageableDefault(size = 8) Pageable pageable) throws BadRequestException, ResourceNotFoundException {
        Page<Product> products = service.findByUser(token, pageable);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Product List successfully",products, null);
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/basic")
    public ResponseEntity<ApiResponse<Product, Object>> saveBasic(@Valid @RequestBody SaveProductDto product) throws ResourceNotFoundException {
        Product response =  service.saveBasic(product);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Product created successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Product, Object>> save(@Valid @RequestBody SaveFullProductDto product) throws ResourceNotFoundException {
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
