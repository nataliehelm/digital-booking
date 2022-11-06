package com.grupo9.db.repository;

import com.grupo9.db.model.Policy;
import com.grupo9.db.model.SubPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISubPolicyRepository extends JpaRepository<SubPolicy, Long> {
}
