package com.grupo9.db.repository;

import com.grupo9.db.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPolicyRepository extends JpaRepository<Policy, Long> {
}
