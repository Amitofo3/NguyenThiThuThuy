package com.example.demo.controller;

import com.example.demo.models.Order;
import com.example.demo.service.CartService;
import com.example.demo.service.OrderService;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@Transactional
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Object> createOrder(@RequestBody Order order){
        orderService.insertOrder(order);
        return new ResponseEntity<>("Order is created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id")Long id,@RequestBody Order order){
        orderService.updateOrder(id,order);
        return new ResponseEntity<>("Order is update successfully",HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Order is deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/{orderId}/{status}")
    public ResponseEntity<Object> updateOrderStatus(@PathVariable("orderId") Long orderId,@PathVariable("status") String status){
        orderService.updateOrderStatus(orderId,status);
        return new ResponseEntity<>("Order status is updated successfully",HttpStatus.OK);

    }
    @PostMapping("/{id}/checkout")
    public ResponseEntity<Object> checkout(@PathVariable("id") Long id){
        Order order = orderService.getOrder(id);
        orderService.checkout(order);
        orderService.updateOrder(id,order);
        return new ResponseEntity<>("Order is checked out successfully", HttpStatus.OK);
    }
}
