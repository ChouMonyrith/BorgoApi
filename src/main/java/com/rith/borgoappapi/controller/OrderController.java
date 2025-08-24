package com.rith.borgoappapi.controller;

import com.rith.borgoappapi.model.Order;
import com.rith.borgoappapi.model.User;
import com.rith.borgoappapi.repository.OrderRepository;
import com.rith.borgoappapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<Order> getAllOrders(@AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        return orderRepository.findByUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        return orderRepository.findById(id)
                .filter(order -> order.getUser().equals(user)) // Ensure the order belongs to the user
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        return orderRepository.findById(id)
                .filter(order -> order.getUser().equals(user)) // Ensure the order belongs to the user
                .map(order -> {
                    order.setOrderDate(orderDetails.getOrderDate());
                    order.setTotalAmount(orderDetails.getTotalAmount());
                    order.setStatus(orderDetails.getStatus());
                    order.setPaymentStatus(orderDetails.getPaymentStatus());
                    order.setPickupTime(orderDetails.getPickupTime());
                    order.setOrderNotes(orderDetails.getOrderNotes());
                    // You might want to handle orderItems updates separately or more carefully
                    return ResponseEntity.ok(orderRepository.save(order));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        User user = userRepository.findByEmail(userDetails.getUsername()).get();
        return orderRepository.findById(id)
                .filter(order -> order.getUser().equals(user)) // Ensure the order belongs to the user
                .map(order -> {
                    orderRepository.delete(order);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
