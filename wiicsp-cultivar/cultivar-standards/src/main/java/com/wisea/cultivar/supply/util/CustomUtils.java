package com.wisea.cultivar.supply.util;

import com.wisea.cloud.common.pojo.ResultPoJo;

import java.util.Objects;

/**
 * 自定义验证类
 * @author chengq
 * @date 2020/8/12 13:14
 */
public class CustomUtils {

    /**
     * 封装返回
     */
    public static ResultPoJo<Object> result() {
        return new ResultPoJo<>();
    }

    /**
     * 封装返回
     */
    public static <T> ResultPoJo<T> result(T t) {
        if (Objects.isNull(t)) {
            return new ResultPoJo<>();
        }
        ResultPoJo<T> result = new ResultPoJo<>();
        result.setResult(t);
        return result;
    }

}
