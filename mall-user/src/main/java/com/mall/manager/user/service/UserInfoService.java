package com.mall.manager.user.service;


import com.mall.manager.user.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByOpenid(String openid);
}
