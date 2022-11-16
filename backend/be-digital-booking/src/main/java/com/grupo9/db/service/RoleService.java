package com.grupo9.db.service;

import com.grupo9.db.exceptions.BadRequestException;
import com.grupo9.db.exceptions.ResourceNotFoundException;
import com.grupo9.db.model.Role;
import com.grupo9.db.repository.IRoleRepository;
import com.grupo9.db.util.ApiResponse;
import com.grupo9.db.util.ResponsesBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final IRoleRepository iRoleRepository;
    private ResponsesBuilder responsesBuilder;

    public RoleService(IRoleRepository iRoleRepository, ResponsesBuilder responsesBuilder) {
        this.iRoleRepository = iRoleRepository;
        this.responsesBuilder = responsesBuilder;
    }

    public ResponseEntity<ApiResponse<List<Role>, Object>> findAll(){
        List<Role> roles = iRoleRepository.findAll();
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Role List successfully",roles, null);
    }

    public ResponseEntity<ApiResponse<Role, Object>> findById(Long id) throws ResourceNotFoundException {
        Optional<Role> role = iRoleRepository.findById(id);
        if(role.isEmpty()){
            throw new ResourceNotFoundException("Role with id " + id + " not found");
        }
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Get Role successfully", role.get(), null);
    }

    public ResponseEntity<ApiResponse<Role, Object>> save(Role role){
        Role response = iRoleRepository.save(role);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Role created successfully", response, null);
    }

    public ResponseEntity<ApiResponse<Role, Object>> update(Long id, Role role) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");

        Boolean exists = iRoleRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Role with id " + id + " not found");
        }

        role.setId(id);
        Role response = iRoleRepository.save(role);
        return responsesBuilder.buildResponse(HttpStatus.CREATED.value(),"Role updated successfully", response, null);
    }

    public ResponseEntity<ApiResponse> deleteById(Long id) throws ResourceNotFoundException, BadRequestException {
        if(id == null) throw new BadRequestException("ID missing");
        Boolean exists = iRoleRepository.existsById(id);
        if(!exists){
            throw new ResourceNotFoundException("Role with id " + id + " not found");
        }

        iRoleRepository.deleteById(id);
        return responsesBuilder.buildResponse(HttpStatus.OK.value(),"Role deleted successfully", null, null);
    }
}
