package com.mall.order.service.exception;

import com.mall.order.service.enums.ResultEnum;

public class OrderException extends RuntimeException{

		private Integer code;

		public OrderException(Integer code, String message) {
				super(message);
				this.code = code;
		}
		public OrderException(ResultEnum resultEnum){
				super(resultEnum.getMsg());
				this.code=resultEnum.getCode();
		}
}
