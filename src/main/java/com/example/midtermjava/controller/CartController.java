package com.example.midtermjava.controller;

import com.example.midtermjava.model.CartItem;
import com.example.midtermjava.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart/")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartItem cartItem) {
        try {
            cartService.addToCart(cartItem.getUsername(), cartItem.getProduct(), cartItem.getQuantity());
            return new ResponseEntity<>("Added to cart successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add to cart", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/view-cart")
    public ResponseEntity<List<CartItem>> viewCart(@RequestParam String username) {
        List<CartItem> cartItems = cartService.getCartItemsByUsername(username);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }
}
