package com.mall.manager.product.repository;


import com.mall.manager.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
	//根据type查询类目
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
	//做个测试
}
