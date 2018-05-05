package com.feitian.service.serviceImpl;

import com.feitian.dao.ProductMapper;
import com.feitian.dao.UserMapper;
import com.feitian.model.Product;
import com.feitian.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-04-26  14:33
 * @description:
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public int countById() {
        return productMapper.countById();
    }

    @Override
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }

    @Override
    public int getQuantityById(int id) {
        return  productMapper.getQuantityById(id);
    }

    @Override
    public void updateQuantity(int quantity, int id) {
        productMapper.updateQuantity(quantity,id);
    }
}