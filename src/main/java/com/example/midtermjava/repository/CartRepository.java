package com.example.midtermjava.repository;


import com.example.midtermjava.model.CartItem;
import com.example.midtermjava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUsername(String username);

    void deleteByIdAndUsername(Long id, String username);

    void deleteByUsername(String username);
    @Query("SELECT c FROM CartItem c WHERE c.username = :username AND c.product = :product")
    CartItem findByUsernameAndProduct(@Param("username") String username, @Param("product") Product product);
}
