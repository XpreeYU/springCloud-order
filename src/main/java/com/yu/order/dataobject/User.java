package com.yu.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * ClassName User
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/6/8 15:14
 **/
@Data
@Entity
public class User {

    @Id
    private Integer id;

    private String name;

    private BigDecimal selfRate = new BigDecimal(0.00);

    private  BigDecimal spouseRate;

}
