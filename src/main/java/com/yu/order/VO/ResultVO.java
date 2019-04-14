package com.yu.order.VO;

import lombok.Data;

/**
 * ClassName ResultVO
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 21:18
 **/
@Data
public class ResultVO<T> {

    private Integer code;

    private String meg;

    private T data;
}
