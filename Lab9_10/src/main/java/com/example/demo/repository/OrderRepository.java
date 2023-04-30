package com.example.demo.repository;

import com.example.demo.models.Order;

import com.example.demo.models.OrderProductPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
