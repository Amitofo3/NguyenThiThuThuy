package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Entity
@Table(name = "carts")
@NoArgsConstructor @Getter @Setter
public class Cart {
    @EmbeddedId
    @JsonIgnore
    private CartProductPrimaryKey productPrimaryKey;

    @Transient
    private Product product;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    @Column(name = "total_product",nullable = false)
    private Long totalProduct;
    @Column(name = "total_price",nullable = false)
    private double totalPrice;

    public Cart(CartProductPrimaryKey productPrimaryKey, int quantity, Long totalProduct, double totalPrice) {
        this.productPrimaryKey = productPrimaryKey;
        this.quantity = quantity;
        this.totalProduct = totalProduct;
        this.totalPrice = totalPrice;
    }

    public Product getProduct(){
        return productPrimaryKey.getProduct();
    }

    public void setProduct(Product product){
        productPrimaryKey.setProduct(product);
        this.totalPrice = product.getPrice() * quantity;

    }

    public void removeProduct(long id) {
        if(product != null && product.getId() == id){
            product = null;
            quantity = 0;
            totalProduct = 0L;
            totalPrice = 0.0;
        }
    }

    public boolean isEmpty() {
        return product == null;
    }

    public void addProduct(Product product) {
        if(this.product == null || this.product.getId() == product.getId()){
            this.product = product;
            quantity++;
            totalProduct += 1L ;
            totalPrice += product.getPrice();

        }
    }

    public void updateProduct(Product product) {
        if(this.product != null && this.product.getId() == product.getId()){
            totalPrice -= this.product.getPrice();
            totalPrice +=product.getPrice();
            this.product = product;
        }
    }
}
