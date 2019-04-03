package com.mall.product.service.service;


import com.mall.product.service.VO.DecreaseStockInput;
import com.mall.product.service.VO.ProductInfoOutPut;
import com.mall.product.service.entity.ProductInfo;

import java.util.List;

public interface ProductService {
		/**
		 * 查询所有在架商品列表
		 */
		List<ProductInfo> findUpAll();
		/**
		 * 根据productIds查询商品列表
		 */
		List<ProductInfoOutPut> findProductListById(List<String> productIdList);

		/**
		 * 扣库存
		 */
		void decreaseStock(List<DecreaseStockInput> cartDtoList);

}
