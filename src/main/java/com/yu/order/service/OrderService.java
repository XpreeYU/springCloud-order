package com.yu.order.service;

import com.yu.order.dto.OrderDTO;

/**
 *
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
