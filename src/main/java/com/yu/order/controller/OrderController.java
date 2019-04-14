package com.yu.order.controller;

import com.yu.order.VO.ResultVO;
import com.yu.order.convertor.OrderForm2OrderDTOConterver;
import com.yu.order.dto.OrderDTO;
import com.yu.order.enums.ResultEnum;
import com.yu.order.exception.OrderException;
import com.yu.order.form.OrderForm;
import com.yu.order.service.OrderService;
import com.yu.order.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName OrderController
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 20:03
 **/
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1、参数校验
     * 2、查询商品信息（调用商品服务）
     * 3、计算总价
     * 4、扣库存（调用商品服务）
     * 5、订单入库
     */
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确, orderFrom={}", orderForm);
            throw  new OrderException(ResultEnum.PAEAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderForm2OrderDTOConterver.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);
    }
}
