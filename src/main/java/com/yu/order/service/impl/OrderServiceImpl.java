package com.yu.order.service.impl;

import com.yu.order.dataobject.OrderMaster;
import com.yu.order.dto.OrderDTO;
import com.yu.order.enums.OrderStatusEnum;
import com.yu.order.enums.PayStatusEnum;
import com.yu.order.repository.OrderDetailRepository;
import com.yu.order.repository.OrderMasterRepository;
import com.yu.order.service.OrderService;
import com.yu.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * ClassName OrderServiceImpl
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 20:14
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    /**
     *  查询商品信息（调用商品服务）TODO
     *  3、计算总价  TODO
     *  4、扣库存（调用商品服务） TODO
     *  5、订单入库
     */
    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
