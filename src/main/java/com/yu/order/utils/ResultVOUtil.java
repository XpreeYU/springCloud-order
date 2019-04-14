package com.yu.order.utils;

import com.yu.order.VO.ResultVO;

/**
 * ClassName ResultVOUtil
 * Description TODO
 *
 * @Author hadoop
 * Date 2019/4/13 21:20
 **/
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMeg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
