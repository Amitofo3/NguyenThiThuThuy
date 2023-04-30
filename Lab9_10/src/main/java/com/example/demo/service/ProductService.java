package com.example.demo.service;

import com.example.demo.models.Product;

import java.util.List;
//import java.util.Optional;

public interface ProductService {
    public List<Product> getProduct();
    public Product addProduct(Product product);
    public void deleteProduct(Long id);
    public Product updateProduct(Long id, Product product);

    Product getProduct(Long productId);
}
