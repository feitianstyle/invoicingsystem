package com.feitian.dao;

import com.feitian.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-04-26  13:33
 * @description:
 */
public interface ProductMapper {
    int countById();
    List<Product> getProductList();
    int getQuantityById(@Param("id") int id);
    void updateQuantity(@Param("quantity")int quantity,@Param("id") int id);
}