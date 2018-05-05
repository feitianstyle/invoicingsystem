package com.feitian.controller;

import com.feitian.utils.CheckAnnotation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: feitian
 * @Date: 2018-04-26  15:34
 * @description:
 */
@Controller
public class LogoutController {
    @GetMapping("logout")
    @CheckAnnotation
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }
}