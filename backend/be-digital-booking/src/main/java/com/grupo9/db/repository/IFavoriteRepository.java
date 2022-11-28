package com.grupo9.db.repository;

import com.grupo9.db.model.Favorite;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {

    @Query("SELECT f.product FROM Favorite f WHERE f.user.id = ?1")
    List<Product> findProductByUserId(Long id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Favorite f WHERE f.product.id = ?1 AND f.user.id = ?2")
    void deleteByProductIdAndUserId(Long productId, Long userId);

}
