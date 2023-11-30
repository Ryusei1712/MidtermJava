package com.example.midtermjava.repository;

import com.example.midtermjava.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByBrand();
    List<Product> findAllByOrderByPrice();
    List<Product> findAllByOrderByColor();
    List<Product> findAllByOrderByFan();
    List<Product> findAllByOrderByPower();
    List<Product> findAllByOrderByAccessory();
    List<Product> findByBrandIgnoreCase(String brand);
    List<Product> findByPriceBetween(int minPrice, int maxPrice);
    List<Product> findByColorIgnoreCase(String color);
    List<Product> findByFan(int fan);
    List<Product> findByPowerIgnoreCase(String power);
    List<Product> findByAccessoryIgnoreCase(String accessory);
}
