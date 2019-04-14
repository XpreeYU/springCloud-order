package com.yu.order.enums;

import lombok.Getter;

/**
 * ClassName ResultEnum
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 20:42
 **/
@Getter
public enum  ResultEnum {
    PAEAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
