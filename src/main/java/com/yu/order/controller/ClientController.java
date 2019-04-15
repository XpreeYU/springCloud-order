package com.yu.order.controller;

import com.yu.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName ClientController
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/14 19:04
 **/
@RestController
@Slf4j
public class ClientController {

    //@Autowired
    //private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){

        //1、第一种方式 （直接使用restTemple,url写死）
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        //2、第二种方式（利用LoadBalancerClient，通过应用名获取url和端口，然后再使用RestTemplate）
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
//        String response = restTemplate.getForObject(url, String.class);

        //第三种方式(利用LoadBalanced，可在RestTemplate里使用应用的名字)
     //   String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
     //   log.info("response={}", response);
     //----------------------------------------------------------------------------------------FFeign-------
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }
}
