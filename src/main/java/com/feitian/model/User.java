package com.feitian.model;

import java.io.Serializable;

/**
 * @Author: feitian
 * @Date: 2018-04-26  11:18
 * @description:
 */
public class User implements Serializable {
    private int id;
    private String userName;
    private String passWord;
    private String realName;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}