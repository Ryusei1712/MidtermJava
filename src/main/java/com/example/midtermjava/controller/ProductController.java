package com.example.midtermjava.controller;

import com.example.midtermjava.model.Product;
import com.example.midtermjava.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> productOptional = Optional.ofNullable(productService.getProductById(id));
        return productOptional
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/sortedByBrand")
    public ResponseEntity<List<Product>> getAllProductsSortedByBrand() {
        List<Product> sortedProducts = productService.getAllProductsSortedByBrand();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    @GetMapping("/sortedByPrice")
    public ResponseEntity<List<Product>> getAllProductsSortedByPrice() {
        List<Product> sortedProducts = productService.getAllProductsSortedByPrice();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    @GetMapping("/sortedByColor")
    public ResponseEntity<List<Product>> getAllProductsSortedByColor() {
        List<Product> sortedProducts = productService.getAllProductsSortedByColor();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    @GetMapping("/sortedByFan")
    public ResponseEntity<List<Product>> getAllProductsSortedByFan() {
        List<Product> sortedProducts = productService.getAllProductsSortedByFan();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    @GetMapping("/sortedByPower")
    public ResponseEntity<List<Product>> getAllProductsSortedByPower() {
        List<Product> sortedProducts = productService.getAllProductsSortedByPower();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    @GetMapping("/sortedByAccessory")
    public ResponseEntity<List<Product>> getAllProductsSortedByAccessory() {
        List<Product> sortedProducts = productService.getAllProductsSortedByAccessory();
        return new ResponseEntity<>(sortedProducts, HttpStatus.OK);
    }

    @GetMapping("/searchByBrand")
    public ResponseEntity<List<Product>> searchProductsByBrand(@RequestParam String brand) {
        List<Product> searchResults = productService.searchProductsByBrand(brand);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/searchByPriceRange")
    public ResponseEntity<List<Product>> searchProductsByPriceRange(
            @RequestParam int minPrice, @RequestParam int maxPrice) {
        List<Product> searchResults = productService.searchProductsByPriceRange(minPrice, maxPrice);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/searchByColor")
    public ResponseEntity<List<Product>> searchProductsByColor(@RequestParam String color) {
        List<Product> searchResults = productService.searchProductsByColor(color);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/searchByFan")
    public ResponseEntity<List<Product>> searchProductsByFan(@RequestParam int fan) {
        List<Product> searchResults = productService.searchProductsByFan(fan);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }

    @GetMapping("/searchByPower")
    public ResponseEntity<List<Product>> searchProductsByPower(@RequestParam String power) {
        List<Product> searchResults = productService.searchProductsByPower(power);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }
    @GetMapping("/searchByAccessory")
    public ResponseEntity<List<Product>> searchProductsByAccessory(@RequestParam String accessory) {
        List<Product> searchResults = productService.searchProductsByAccessory(accessory);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }


}