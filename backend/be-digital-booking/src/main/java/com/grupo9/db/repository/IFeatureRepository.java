package com.grupo9.db.repository;

import com.grupo9.db.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFeatureRepository extends JpaRepository<Feature, Long> {
}
