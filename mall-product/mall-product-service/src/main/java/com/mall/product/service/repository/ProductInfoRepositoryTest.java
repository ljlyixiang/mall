package com.mall.product.service.repository;

import com.mall.manager.product.ProductApplicationTests;
import com.mall.product.service.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findALLByCategoryType(){
        List<ProductInfo> categoryType = productInfoRepository.findAllByCategoryTypeIn(Arrays.asList(2,3));
        ProductInfo productInfo = null;
        if(!CollectionUtils.isEmpty(categoryType)){
            productInfo = categoryType.get(0);
            System.out.println(productInfo.toString());
        }
        System.err.println(categoryType.toString());
        Assert.assertTrue(productInfo != null);
    }
}