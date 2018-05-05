package com.feitian.model;

import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-26  11:20
 * @description:
 */
public class Product implements Serializable {
    private int id;
    private String productName;
    private int quantity;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}