package com.yu.order.utils;

import java.util.Random;

/**
 * ClassName KeyUtil
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 20:23
 **/
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     */
    public  static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 1000000;

        return  System.currentTimeMillis() + (String.valueOf(number));
    }
}
