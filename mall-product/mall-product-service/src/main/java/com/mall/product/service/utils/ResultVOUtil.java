package com.mall.product.service.utils;


import com.mall.product.service.VO.ResultVO;

public class ResultVOUtil {
		public static ResultVO success(Object data){
				ResultVO resultVO = new ResultVO();
				resultVO.setData(data);
				resultVO.setCode(0);
				resultVO.setMsg("成功");
				return resultVO;
		}
}
