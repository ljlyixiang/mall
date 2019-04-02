package com.mall.manager.order.repository;

import com.mall.manager.order.OrderApplicationTests;
import com.mall.manager.order.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoRepositoryTest extends OrderApplicationTests {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Test
    public void findUserInfoById(){
        UserInfo userInfoById = userInfoRepository.findUserInfoById("1111");
        System.err.println(userInfoById.toString());
        Assert.assertTrue(userInfoById!=null);
    }
}