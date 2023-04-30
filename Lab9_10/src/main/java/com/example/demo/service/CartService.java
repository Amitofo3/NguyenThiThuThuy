package com.example.demo.service;

import com.example.demo.models.Cart;

public interface CartService {
    public boolean isEmpty();
    public Cart addProductToCart(Long productId, int quantity);
    Cart updateProductFromCart(Long productId, int quantity);
    Cart deleteProductFromCart(Long productId);
}
