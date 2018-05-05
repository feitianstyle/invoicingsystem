package com.feitian.service.serviceImpl;

import com.feitian.dao.UserMapper;
import com.feitian.model.User;
import com.feitian.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: feitian
 * @Date: 2018-04-26  14:04
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public int countById() {
        return userMapper.countById();
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public  Map<String,Object> getUserByAll(String name, String passWord, HttpServletRequest request) {
        User user = userMapper.getUserByAll(name,passWord);
        Map<String,Object> map = new HashMap<String, Object>();
        if (user==null){
            map.put("status","ok");
        }else if (user!=null&&"".equals(user.getId())){
            map.put("status", "ok");
            map.put("user", user);
            request.getSession().setAttribute("user", user);
        }
        return map;
    }

}