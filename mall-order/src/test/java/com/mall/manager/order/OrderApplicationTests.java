package com.mall.manager.order;

import com.mall.manager.order.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

    @Test
    public void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        List<ProductInfo> productInfoList = (List<ProductInfo>)restTemplate.postForObject("http://localhost:1001/product/queryByType", Arrays.asList(2,3), List.class);
        System.out.println(productInfoList);
        Assert.assertTrue(productInfoList!=null);
    }

}
