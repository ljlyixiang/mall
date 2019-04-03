package com.mall.product.service.exception;


import com.mall.product.service.enums.ResultEnum;

public class ProductException extends RuntimeException {
		private Integer code;
		public ProductException(Integer code, String message){
				super(message);
				this.code = code;
		}
		public ProductException(ResultEnum resultEnum){
				super(ResultEnum.PRODUCT_NOT_EXIST.getMsg());
				this.code = resultEnum.getCode();
		}
}
