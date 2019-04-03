package com.mall.user.service.service;


import com.mall.user.service.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByOpenid(String openid);
}
