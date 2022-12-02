package com.grupo9.db.repository;

import com.grupo9.db.model.Booking;
import com.grupo9.db.model.Favorite;
import com.grupo9.db.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IFavoriteRepository extends JpaRepository<Favorite, Long> {

    @Query(value = "SELECT favorites.* " +
            "FROM digital_booking_g9.product products " +
            "LEFT JOIN digital_booking_g9.favorite favorites " +
            "ON bookings.product_id = products.id " +
            "WHERE products.id = :userId ", nativeQuery = true)
    List <Favorite> findFavoritesByProductId(@Param("userId") Long userId);
    List <Favorite> findAll();

    @Modifying
    @Query("DELETE FROM Favorite favorites " +
            "WHERE favorites.product.id = ?1 AND favorites.user.id = ?1")
    void deleteByProductIdAndUserId(Long productId, Long userId);

}
