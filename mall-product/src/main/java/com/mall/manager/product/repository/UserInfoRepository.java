package com.mall.manager.order.repository;

import com.mall.manager.order.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
    UserInfo findUserInfoById(String id);
}
