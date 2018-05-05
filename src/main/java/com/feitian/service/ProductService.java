package com.feitian.service;

import com.feitian.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-04-26  13:36
 * @description:
 */
@Service("productService")
public interface ProductService {
    int countById();
    List<Product> getProductList();
    int getQuantityById(int id);
    void updateQuantity(int quantity,int id);
}