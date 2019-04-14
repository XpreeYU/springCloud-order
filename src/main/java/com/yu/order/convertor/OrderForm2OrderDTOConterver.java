package com.yu.order.convertor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yu.order.dataobject.OrderDetail;
import com.yu.order.dto.OrderDTO;
import com.yu.order.enums.ResultEnum;
import com.yu.order.exception.OrderException;
import com.yu.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName OrderForm2OrderDTO
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 20:49
 **/
@Slf4j
public class OrderForm2OrderDTOConterver {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        Gson gson = new Gson();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            log.error("[json转换]出错， string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PAEAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
