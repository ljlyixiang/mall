package com.mall.manager.order.utils;

import com.mall.manager.order.VO.ResultVO;

public class ResultVOUtil {
		public static ResultVO success(Object data){
				ResultVO resultVO = new ResultVO();
				resultVO.setCode(0);
				resultVO.setData(data);
				resultVO.setMsg("订单创建成功");
				return resultVO;
		}
}
