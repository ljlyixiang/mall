package com.mall.manager.user.service.impl;

import com.mall.manager.user.entity.UserInfo;
import com.mall.manager.user.repository.UserInfoRepository;
import com.mall.manager.user.service.UserInfoService;
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
