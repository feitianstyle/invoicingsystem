package com.feitian.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: feitian
 * @Date: 2018-04-26  11:21
 * @description:
 */
public class Sale implements Serializable {
    private int id;
    private double price;
    private int quantity;
    private double totalPrice;
    private Date saleDate;
    private int userId;
    private int productId;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public  double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}