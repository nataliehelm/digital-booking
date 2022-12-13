package com.grupo9.db.repository;

import com.grupo9.db.model.ERole;
import com.grupo9.db.model.Image;
import com.grupo9.db.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IImageRepository extends JpaRepository<Image, Long> {
    Boolean existsByUrl(String url);
    Optional<Image> findByUrl(String url);
    void deleteByUrl(String url);
}
