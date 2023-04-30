package com.example.demo.service;

import com.example.demo.models.Order;
import com.example.demo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.context.annotation.ConfigurationClassUtils.getOrder;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    @Override
    @Transactional
    public void insertOrder(Object order) {
        OrderRepository orderRepository1 = null;
        orderRepository1.save((Order) order);

    }

    @Override
    public Order checkout(Order order) {
        order.setStatus("Processed");
        return order;
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Order existingOrder = getOrder(id);
        existingOrder.setId(order.getId());
        existingOrder.setTotalAmount(order.getTotalAmount());
        return  orderRepository.save(existingOrder);
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        orderRepository.delete(order);

    }

    @Override
    @Transactional
    public Order updateOrderStatus(Long orderId, String status) {
        Order order = getOrder(orderId);
        order.setStatus(status);
        return order;
    }


}
