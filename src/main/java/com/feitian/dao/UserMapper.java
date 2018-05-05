package com.feitian.dao;

import com.feitian.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: feitian
 * @Date: 2018-04-26  11:26
 * @description:
 */
@Repository
public interface UserMapper {
    int countById();
    User getUserById(@Param("id")int id);
    User getUserByName(@Param("userName") String name);
    User getUserByAll(@Param("userName") String name,@Param("passWord") String passWord);
}