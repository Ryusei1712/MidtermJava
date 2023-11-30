package com.example.midtermjava.service;

import com.example.midtermjava.model.CartItem;
import com.example.midtermjava.model.Order;
import com.example.midtermjava.model.Product;
import com.example.midtermjava.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Product> getProductsByUsername(String username) {
        List<CartItem> cartItems = cartService.getCartItemsByUsername(username);


        List<Product> products = new ArrayList<>();
        for (CartItem cartItem : cartItems) {
            Product product = cartItem.getProduct();
            product.setCartQuantity(cartItem.getQuantity());
            products.add(product);
        }
        return products;
    }

}
