package com.feitian.model;

import java.util.Date;

/**
 * @Author: feitian
 * @Date: 2018-05-03  17:52
 * @description:
 */
public class SaleInfo {
    private int id ;
    private String productName;
    private double price;
    private int quantity;
    private double totalPrice;
    private String saleDate;
    private String saleName;

    public SaleInfo() { }

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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }
}