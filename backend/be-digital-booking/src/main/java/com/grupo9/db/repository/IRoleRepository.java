package com.grupo9.db.repository;

import com.grupo9.db.model.ERole;
import com.grupo9.db.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository <Role, Long>{
    Optional<Role> findByName(ERole name);
    Boolean existsByName(ERole name);
}
