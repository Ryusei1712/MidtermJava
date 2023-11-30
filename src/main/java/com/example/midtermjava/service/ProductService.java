package com.example.midtermjava.service;

import com.example.midtermjava.model.Product;
import com.example.midtermjava.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
    public List<Product> getAllProductsSortedByBrand() {
        return productRepository.findAllByOrderByBrand();
    }

    public List<Product> getAllProductsSortedByPrice() {
        return productRepository.findAllByOrderByPrice();
    }

    public List<Product> getAllProductsSortedByColor() {
        return productRepository.findAllByOrderByColor();
    }

    public List<Product> getAllProductsSortedByFan() {
        return productRepository.findAllByOrderByFan();
    }

    public List<Product> getAllProductsSortedByPower() {
        return productRepository.findAllByOrderByPower();
    }

    public List<Product> getAllProductsSortedByAccessory() {
        return productRepository.findAllByOrderByAccessory();
    }

    public List<Product> searchProductsByBrand(String brand) {
        return productRepository.findByBrandIgnoreCase(brand);
    }

    public List<Product> searchProductsByPriceRange(int minPrice, int maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> searchProductsByColor(String color) {
        return productRepository.findByColorIgnoreCase(color);
    }

    public List<Product> searchProductsByFan(int fan) {
        return productRepository.findByFan(fan);
    }

    public List<Product> searchProductsByPower(String power) {
        return productRepository.findByPowerIgnoreCase(power);
    }

    public List<Product> searchProductsByAccessory(String accessory) {
        return productRepository.findByAccessoryIgnoreCase(accessory);
    }


}
