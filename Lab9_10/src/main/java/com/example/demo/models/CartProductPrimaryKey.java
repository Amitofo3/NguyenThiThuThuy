package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.io.Serializable;

public class CartProductPrimaryKey implements Serializable {
    @JsonBackReference
    @OneToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
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
