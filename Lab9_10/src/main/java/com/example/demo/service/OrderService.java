package com.example.demo.service;

import com.example.demo.models.Order;

public interface OrderService {
    void insertOrder(Object order);
    Order checkout(Order order);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

    Order updateOrderStatus(Long orderId, String status);

    Order getOrder(Long orderId);
}
