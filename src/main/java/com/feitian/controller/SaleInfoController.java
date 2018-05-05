package com.feitian.controller;

import com.feitian.model.PageInfo;
import com.feitian.model.SaleInfo;
import com.feitian.model.Sort;
import com.feitian.service.SaleService;
import com.feitian.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: feitian
 * @Date: 2018-05-03  18:20
 * @description:
 */
@Controller
@Transactional
public class SaleInfoController {

    @Autowired
    SaleService saleService;

    @RequestMapping(value = "saleInfo",method = RequestMethod.POST)
    public void show(@RequestParam(value = "order",defaultValue = "saleDate",required = false)String order, Sort sort,
                     @RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage, Model model,
                     HttpSession httpSession){
        currentPage = 1 ;
        showQuantity(order, sort, currentPage, model, httpSession);
    }

    @RequestMapping(value = "saleInfo",method = RequestMethod.GET)
    public String showQuantity(@RequestParam(value = "order",defaultValue = "saleDate",required = false)String order, Sort sort,
                               @RequestParam(value = "currentPage",defaultValue = "1",required = false)int currentPage, Model model,
                               HttpSession httpSession){
        int everyPage = 5 ;//每页5条记录
        int count = saleService.getCount();
        List<SaleInfo> list = null;
        String px = sort.getLabel();
        PageInfo pf = PageUtil.createPage(everyPage,count,currentPage);
        if (px != null){
            httpSession.setAttribute("sort",px);
            list = saleService.findByPage(pf,px);
        }else if (order.equals("saleDate")){
            list = saleService.findByPage(pf,"saleDate");
        }else {
            list = saleService.findByPage(pf,"totalPrice");
        }
        model.addAttribute("list",list);
        model.addAttribute("pageInfo",pf);
        return "saleInfo";
    }
}