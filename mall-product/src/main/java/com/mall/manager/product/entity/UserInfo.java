package com.mall.manager.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String id;
    @Column(name = "username",nullable = false,length = 32)
    private String username;
    @Column(name = "password",nullable = false,length = 32)
    private String password;
    @Column(name = "openid",length = 64)
    private String openid;
    @Column(name = "create_time",nullable = false)
    private Date createTime;
    @Column(name = "update_time",nullable = false)
    private Date updateTime;
    @Column(name = "role")
    private Integer roleId;
}
