package com.mall.manager.product.service;


import com.mall.manager.product.VO.DecreaseStockInput;
import com.mall.manager.product.VO.ProductInfoOutPut;
import com.mall.manager.product.entity.ProductInfo;

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
