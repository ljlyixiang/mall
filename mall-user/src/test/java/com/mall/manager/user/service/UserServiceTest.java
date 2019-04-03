package com.mall.manager.user.service;

import com.mall.manager.user.UserApplicationTests;
import com.mall.manager.user.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends UserApplicationTests {
    @Autowired
    UserService userService;
    @Test
    public void findUserInfoById(){
        UserInfo userInfo = userService.findUserInfoById("1111");
        System.err.println(userInfo);
        Assert.assertTrue(userInfo!=null);
    }
}