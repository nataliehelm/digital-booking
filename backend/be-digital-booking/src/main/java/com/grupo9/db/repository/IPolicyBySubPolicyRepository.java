package com.grupo9.db.repository;

import com.grupo9.db.model.PolicyBySubPolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPolicyBySubPolicyRepository extends JpaRepository<PolicyBySubPolicy, Long> {
}
