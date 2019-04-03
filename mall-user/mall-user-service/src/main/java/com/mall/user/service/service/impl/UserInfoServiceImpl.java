package com.mall.user.service.service.impl;

import com.mall.user.service.entity.UserInfo;
import com.mall.user.service.repository.UserInfoRepository;
import com.mall.user.service.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
