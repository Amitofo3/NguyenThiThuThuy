package com.example.demo.repository;

import com.example.demo.models.Cart;

import com.example.demo.models.CartProductPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, CartProductPrimaryKey> {

}
