package com.mall.product.service.service;

import com.mall.product.service.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
		List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryTypeList);
}
