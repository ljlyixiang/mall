package com.mall.product.service.service.impl;

import com.mall.product.service.entity.ProductCategory;
import com.mall.product.service.repository.ProductCategoryRepository;
import com.mall.product.service.service.ProductCategoryService;
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
