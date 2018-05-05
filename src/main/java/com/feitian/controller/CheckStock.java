package com.feitian.controller;

import com.feitian.model.Product;
import com.feitian.service.ProductService;
import com.feitian.utils.Constraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: feitian
 * @Date: 2018-05-04  10:55
 * @description:
 */
@Controller
@Transactional
public class CheckStock {
    @Autowired
    private ProductService productService;
    @GetMapping("checkStock")
    public String showQuantity(Product product){
        return "checkStock";
    }
    @PostMapping("checkStock")
    public String showQuantity(Product product, Model model){

        int productId = product.getId();
        if (productId != 0){
            int quantity = productService.getQuantityById(productId);
            model.addAttribute(Constraint.MSG,quantity);
        }else {
            model.addAttribute(Constraint.MSG,"-1");
        }
        return "checkStock";
    }
}