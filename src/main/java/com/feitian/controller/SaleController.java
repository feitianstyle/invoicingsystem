package com.feitian.controller;


import com.feitian.model.Sale;
import com.feitian.model.User;
import com.feitian.service.ProductService;
import com.feitian.service.SaleService;
import com.feitian.utils.Constraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: feitian
 * @Date: 2018-05-03  9:48
 * @description:
 */
@Controller
@Transactional
public class SaleController {
    @Autowired
    SaleService saleService;
    @Autowired
    ProductService productService;

    @GetMapping("sale")
    public String sale(Sale sale){
        return "sale";
    }

    @PostMapping("sale")
    public String  sale(Sale sale, Model model,HttpSession httpSession) throws Exception {
        //封装对象
        Date saleDate = new Date();
        User currUser = (User) httpSession.getAttribute(Constraint.USER);
        int userId = currUser.getId();
        double totalPrice = sale.getPrice() * sale.getQuantity();
        sale.setSaleDate(saleDate);
        sale.setTotalPrice(totalPrice);
        sale.setUserId(userId);
        int currQuantity = productService.getQuantityById(sale.getProductId());
        System.out.println("quantity: " + currQuantity);
        //判读库存是否大于等于销售数量
        if(sale.getQuantity()>currQuantity){
            model.addAttribute(Constraint.MSG,"添加失败！(库存不足)");

        }else {
            try{
                //储存销售记录
                saleService.save(sale);
                System.out.println("sale userid :" + sale.getUserId());
                //更新库存
                int newQuantity = currQuantity - sale.getQuantity();
                productService.updateQuantity(newQuantity,sale.getProductId());
                model.addAttribute(Constraint.MSG,"添加成功！");
            }catch (Exception e){
                e.printStackTrace();
                throw new Exception();
            }
        }

        return "sale";
    }
}