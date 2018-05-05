package com.feitian.controller;

import com.feitian.model.User;
import com.feitian.service.ProductService;
import com.feitian.service.UserService;
import com.feitian.utils.CheckAnnotation;
import com.feitian.utils.Constraint;
import com.feitian.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: feitian
 * @Date: 2018-04-26  15:26
 * @description:
 */
@Controller
@CheckAnnotation
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    ProductService productService;


    @GetMapping("login")
    public String login(User user){
        return "login";
    }

    @PostMapping("login")
    public String login(User user, Model model){

        User currUser = userService.getUserByName(user.getUserName());
        if (ObjectUtils.isEmpty(currUser)){
            model.addAttribute(Constraint.MSG," 登录失败！用户名或密码错误！");
        }else if (!user.getPassWord().equals(currUser.getPassWord())){
            model.addAttribute(Constraint.MSG," 登录失败！用户名或密码错误！");
        }else {
            Tools.setSession(Constraint.USER,currUser);
            Tools.setSession("products",productService.getProductList());
            return "redirect:home";
        }
        return "login";
    }
}