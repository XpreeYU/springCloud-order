package com.yu.order.client;

import com.yu.order.dataobject.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName ProductClient
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/15 23:05
 **/
@FeignClient(name = "product")
public interface ProductClient {

    @RequestMapping("/msg")
    String productMsg();

    /**
     * 获取商品列表（给订单服务使用的)
     * @param productIdList
     * @return
     */
    @PostMapping("/product/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList);
}
