package com.example.midtermjava.controller;

import com.example.midtermjava.model.Order;
import com.example.midtermjava.model.Product;
import com.example.midtermjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/place-order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        String email = order.getEmail();
        List<Product> products = orderService.getProductsByUsername(email);

        order.setProducts(products);

        Order addedOrder = orderService.addOrder(order);

        return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> orderOptional = orderService.getOrderById(id);
        return orderOptional.map(order -> new ResponseEntity<>(order, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
