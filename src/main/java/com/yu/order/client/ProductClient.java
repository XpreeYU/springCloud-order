package com.yu.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
