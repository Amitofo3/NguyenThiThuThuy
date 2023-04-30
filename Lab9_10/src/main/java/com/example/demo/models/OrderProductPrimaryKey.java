package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.*;

@Embeddable
public class OrderProductPrimaryKey implements Serializable {
    @JsonBackReference
    @ManyToOne
    //@MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder(){
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Long getOrderId(){
        return order != null ? order.getId() : null;
    }
    public void setOrderId(Long orderId){
        if(orderId == null){
            order = new Order();
        }
        order.setId(orderId);
    }
    public Long getProductId(){
        return product != null ? product.getId() : null;
    }
    public void setProductId(Long productId){
        if(product == null){
            product = new Product();
        }
        product.setId(productId);
    }
}
