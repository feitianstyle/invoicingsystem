package com.feitian.service.serviceImpl;

import com.feitian.dao.UserMapper;
import com.feitian.model.User;
import com.feitian.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: feitian
 * @Date: 2018-04-28  13:40
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void getUserByName() {
        String name = "胡杰文";
        User user = userService.getUserByName(name);
        System.out.println(user.getUserName()+" " + user.getRealName());
    }

    @Test
    public void countById() {
        User user = userService.getUserById(1);
        System.out.println(user.getUserName()+" " + user.getRealName());


    }
}