package com.example.demo.controller;

import com.example.demo.models.Cart;
import com.example.demo.service.CartService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Transactional
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/{productId}")
    public Cart addProductToCart(@PathVariable Long productId, @RequestBody int quantity) {
        return cartService.addProductToCart(productId, quantity);
    }


    @DeleteMapping("/{productId}")
    public Cart deleteProductFromCart(@PathVariable Long productId) {
        return cartService.deleteProductFromCart(productId);
    }

    @PutMapping("/{productId}")
    public Cart updateProductFromCart(@PathVariable Long productId, @RequestBody int quantity) {
        return cartService.updateProductFromCart(productId, quantity);
    }
}
