package com.mall.manager.product.service;

import com.mall.manager.product.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
		List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryTypeList);
}
