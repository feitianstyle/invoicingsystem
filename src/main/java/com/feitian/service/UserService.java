package com.feitian.service;

import com.feitian.model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author: feitian
 * @Date: 2018-04-26  11:29
 * @description:
 */
public interface UserService {
    int countById();
    User getUserById(int id);
    User getUserByName(String name);
    Map<String,Object> getUserByAll(String name, String passWord, HttpServletRequest request);
}