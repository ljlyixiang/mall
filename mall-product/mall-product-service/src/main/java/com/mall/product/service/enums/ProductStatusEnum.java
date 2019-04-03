package com.mall.product.service.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(1,"在架"),
    DOWN(2,"下架");
    private Integer code;
    private String message;
    ProductStatusEnum(Integer code,String messsage){
        this.code = code;
        this.message = messsage;
    }
}
