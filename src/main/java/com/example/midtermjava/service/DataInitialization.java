package com.example.midtermjava.service;


import com.example.midtermjava.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitialization {

    @Autowired
    private ProductService productService;
    @PostConstruct
    public void initializeData() {
        productService.addProduct(new Product(1L, "Thermaltake DistroCase 350P Tempered Glass", 13990000, "thermaltake", "black", 2, "500W", "LED Strip"));
        productService.addProduct(new Product(2L, "ASUS ROG Hyperion EVA-02 Edition", 13990000, "asusrog", "red", 1, "650W", "VGA Bracket"));
        productService.addProduct(new Product(3L, "ASUS ROG Hyperion GR701", 10990000, "asusrog", "black", 2, "750W", "Thermal Paste"));
        productService.addProduct(new Product(4L, "ASUS ROG Hyperion GR701 White", 11390000, "asusrog", "white", 2, "850W", "LED Strip"));
        productService.addProduct(new Product(5L, "Cougar Gemini X", 19900000, "cougar", "black", 3, "500W", "VGA Bracket"));
        productService.addProduct(new Product(6L, "Cooler Master Cosmos C700M", 11990000, "coolermaster", "black", 4, "800W", "Thermal Paste"));
        productService.addProduct(new Product(7L, "Cooler Master Cosmos C700M - 30th Anniversary", 26500000, "coolermaster", "black", 2, "700W", "LED Strip"));
        productService.addProduct(new Product(8L, "Cooler Master Cosmos C700M White", 11990000, "coolermaster", "black", 2, "900W", "VGA Bracket"));
        productService.addProduct(new Product(9L, "Cooler Master HAF 700 EVO", 10990000, "coolermaster", "black", 2, "550W", "Thermal Paste"));
        productService.addProduct(new Product(10L, "Cooler Master Sneaker X", 29990000, "coolermaster", "red", 3, "750W", "LED Strip"));
        productService.addProduct(new Product(11L, "Corsair Obsidian 1000D kính cường lực (CC-9011148-WW)", 12990000, "coolermaster", "black", 1, "850W", "VGA Bracket"));
        productService.addProduct(new Product(12L, "Cougar Cratus", 12490000, "cougar", "black", 2, "600W", "Thermal Paste"));
        productService.addProduct(new Product(13L, "InWin 925 ( Full Tower )", 10490000, "inwin", "black", 2, "700W", "LED Strip"));
        productService.addProduct(new Product(14L, "InWin D-Frame 2.0 Black Green", 29990000, "inwin", "green", 3, "800W", "VGA Bracket"));
        productService.addProduct(new Product(15L, "InWin D-Frame 2.0 BlackGold Platinum", 29990000, "inwin", "black", 4, "900W", "Thermal Paste"));
        productService.addProduct(new Product(16L, "InWin D-Frame 2.0 White Blue", 29990000, "inwin", "blue", 4, "550W", "LED Strip"));
        productService.addProduct(new Product(17L, "InWin H-Frame 2.0 Black Amber LED Light", 39990000, "inwin", "black", 2, "750W", "VGA Bracket"));
        productService.addProduct(new Product(18L, "InWin H-Frame 2.0 Black Green LED Light", 39990000, "inwin", "greeb", 1, "650W", "Thermal Paste"));
        productService.addProduct(new Product(19L, "InWin H-Frame 2.0 White Blue LED Light", 39990000, "inwin", "blue", 3, "700W", "LED Strip"));
        productService.addProduct(new Product(20L, "INWIN Z-Tower Ultra Rare Limited Edition", 99990000, "inwin", "white", 1, "800W", "VGA Bracket"));
        productService.addProduct(new Product(21L, "Lian Li V3000 PLUS Black - V3000PX", 11290000, "lianli", "black", 2, "900W", "Thermal Paste"));
        productService.addProduct(new Product(22L, "Lian Li V3000 PLUS White GGF Edition - V3000PW", 12290900, "lianli", "white", 3, "600W", "LED Strip"));
    }
}