package com.mall.manager.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table
@Entity
@Data
public class ProductInfo {
    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name",nullable = false,length = 32)
    private String productName;
    @Column(name = "product_price",nullable = false,length = 32)
    private BigDecimal productPrice;
    @Column(name = "product_stock",length = 64)
    private Integer productStock;
    @Column(name = "product_description")
    private String productDescription;
    @Column(name = "product_icon")
    private String productIcon;
    @Column(name = "product_status")
    private Integer productStatus;
    @Column(name = "category_type")
    private Integer categoryType;
    @Column(name = "create_time",nullable = false)
    private Date createTime;
    @Column(name = "update_time",nullable = false)
    private Date updateTime;
}
