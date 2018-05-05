package com.feitian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: feitian
 * @Date: 2018-04-26  16:13
 * @description:
 */
@Controller
public class HomeController {

    @GetMapping("home")
    public String home(){
        return "home";
    }

}