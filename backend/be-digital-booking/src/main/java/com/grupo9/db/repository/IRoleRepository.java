package com.grupo9.db.repository;

import com.grupo9.db.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository <Role, Long>{
}
