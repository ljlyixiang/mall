package com.mall.manager.product.service.impl;

import com.mall.manager.product.entity.ProductCategory;
import com.mall.manager.product.repository.ProductCategoryRepository;
import com.mall.manager.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
		@Autowired
		private ProductCategoryRepository productCategoryRepository;
		@Override
		public List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryTypeList) {
				return productCategoryRepository.findByCategoryTypeIn(productCategoryTypeList);
		}
}
