package com.grupo9.db.controller;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Role;
import com.grupo9.db.service.RoleService;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @Autowired
    private ResponsesBuilder responsesBuilder;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Role>, Object>> findAll(){
        List<Role> roles = service.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Role List successfully",roles, null);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Role, Object>> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Role role = service.findById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Role successfully", role, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<Role, Object>> save(@Valid @RequestBody Role role){
        Role response = service.save(role);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Role created successfully", response, null);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(path = "/{id}")
    public ResponseEntity<ApiResponse<Role, Object>> update(@PathVariable("id") Long id, @Valid @RequestBody Role role) throws ResourceNotFoundException, BadRequestException {
        Role response = service.update(id, role);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Role updated successfully", response, null);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ApiResponse> deleteById(@PathVariable("id") Long id) throws ResourceNotFoundException, BadRequestException {
        service.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Role deleted successfully", null, null);
    }

}
