package com.yu.order.config.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * ClassName Person
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/6/8 14:04
 **/
@Data
public class Person {

    private Integer year;

    private String angNo;

    private BigDecimal selfRate;

    private BigDecimal spouseRate;
}
