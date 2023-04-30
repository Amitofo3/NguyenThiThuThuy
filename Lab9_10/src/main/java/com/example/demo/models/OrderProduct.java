package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "order_product")
@NoArgsConstructor @Getter @Setter
public class OrderProduct implements Serializable {
    @EmbeddedId
    @JsonIgnore
    private OrderProductPrimaryKey orderProductPrimaryKey;

    @Transient
    private Product product;

    @Column(name = "quantity",nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private double price;

    public OrderProduct(Order order, Product product, int quantity) {
        orderProductPrimaryKey = new OrderProductPrimaryKey();
        orderProductPrimaryKey.setOrder(order);
        orderProductPrimaryKey.setProduct(product);
        this.quantity = quantity;
        this.price = orderProductPrimaryKey.getProduct().getPrice() * quantity;
    }
    public Product getProduct(){
        return orderProductPrimaryKey.getProduct();
    }
    public void setProduct(Product product){
        orderProductPrimaryKey.setProduct(product);
        this.price = product.getPrice()*quantity;
    }
}
