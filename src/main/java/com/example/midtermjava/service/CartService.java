package com.example.midtermjava.service;

import com.example.midtermjava.model.CartItem;
import com.example.midtermjava.model.Product;
import com.example.midtermjava.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public void addToCart(String username, Product product, int quantity) {
        CartItem cartItem = cartRepository.findByUsernameAndProduct(username, product);
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItem.getProduct().setCartQuantity(cartItem.getQuantity());
        } else {
            cartItem = new CartItem( product, quantity, username);
            cartItem.getProduct().setCartQuantity(cartItem.getQuantity());
        }
        cartRepository.save(cartItem);
    }

    public List<CartItem> getCartItemsByUsername(String username) {
        return cartRepository.findByUsername(username);
    }

    public void removeFromCart(String username, Long cartItemId) {
        cartRepository.deleteByIdAndUsername(cartItemId, username);
    }

    public void clearCart(String username) {
        cartRepository.deleteByUsername(username);
    }
}
