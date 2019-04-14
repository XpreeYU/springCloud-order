package com.yu.order.exception;

import com.yu.order.enums.ResultEnum;

/**
 * ClassName OrderException
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 20:39
 **/
public class OrderException extends RuntimeException{

    private  Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
