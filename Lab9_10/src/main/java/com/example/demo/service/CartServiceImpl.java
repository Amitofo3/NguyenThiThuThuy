package com.example.demo.service;

import com.example.demo.models.Cart;
import com.example.demo.models.CartProductPrimaryKey;
import com.example.demo.models.Product;
import com.example.demo.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;
    @Override
    public boolean isEmpty() {
       return cartRepository.count() ==0;
    }

    @Override
    public Cart addProductToCart(Long productId, int quantity) {
        Product product = productService.getProduct(productId);
        CartProductPrimaryKey pk = new CartProductPrimaryKey();
        pk.setProduct(product);
        Cart cart = new Cart(pk, quantity, (long) quantity, quantity*product.getPrice());
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart deleteProductFromCart(Long productId) {
        CartProductPrimaryKey pk = new CartProductPrimaryKey();
        pk.setProduct(productService.getProduct(productId));
        Cart cart = cartRepository.findById(pk).orElse(null);
        cartRepository.delete(cart);
        return cart;
    }

    @Override
    public Cart updateProductFromCart(Long productId, int quantity) {
       Product product = productService.getProduct(productId);
       CartProductPrimaryKey pk = new CartProductPrimaryKey();
       pk.setProduct(product);
       Cart cart = cartRepository.findById(pk).orElse(null);
       cart.updateProduct(product);
       cart.setQuantity(quantity);
       cart.setTotalProduct((long) quantity);
       cart.setTotalPrice(quantity*product.getPrice());
       cartRepository.save(cart);
       return cart;
    }
}
