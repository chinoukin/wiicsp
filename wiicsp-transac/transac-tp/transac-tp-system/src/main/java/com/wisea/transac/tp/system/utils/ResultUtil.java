package com.wisea.transac.tp.system.utils;

import com.wisea.cloud.common.exception.ErrorStatus;
import com.wisea.cloud.common.pojo.ResultPoJo;

import java.util.Objects;

/**
 * ResultPoJo构建构建
 *
 * @author wangjh
 * @version 1.0
 * @className ResultUtil
 * @since 2018/9/18 18:07
 */
public class ResultUtil {

    /**
     * 根据增删返回标记构建ResultPojo
     *
     * @param i          增删返回标记
     * @param statusCode 如果失败，返回的信息
     * @return ResultPoJo
     */
    public static ResultPoJo getResultByFlag(int i, StatusCode statusCode) {
        return i > 0 ? ok() : build(statusCode);
    }

    public static <T> ResultPoJo<T> build(ErrorStatus status, T t) {
        ResultPoJo<T> poJo = new ResultPoJo<>(status);
        if (!Objects.isNull(t)) {
            poJo.setResult(t);
        }
        return poJo;
    }

    public static <T> ResultPoJo<T> build(ErrorStatus status) {
        return build(status, null);
    }

    public static ResultPoJo ok() {
        return build(StatusCode.SUCCESS);
    }

    public static <T> ResultPoJo<T> ok(T t) {
        return build(StatusCode.SUCCESS, t);
    }
}
