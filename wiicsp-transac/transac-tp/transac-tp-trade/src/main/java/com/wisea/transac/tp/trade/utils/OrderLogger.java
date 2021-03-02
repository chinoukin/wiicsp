package com.wisea.transac.tp.trade.utils;

import com.wisea.cloud.common.logger.InOneFileLogger;
import com.wisea.cloud.common.util.ConverterUtil;

import ch.qos.logback.classic.Logger;

/**
 * 订单日志
 *
 * @author XuDL(Wisea)
 *
 *         2020年2月26日 下午4:49:42
 */
public class OrderLogger {
    public static final String LOGGER_PREFIX = "order_";

    /**
     * 获取订单日志对象(一个订单一个日志对象)
     *
     * @param orderId
     * @return
     */
    public static Logger getLogger(Long orderId) {
        String loggerName = LOGGER_PREFIX + ConverterUtil.toString(orderId);
        return InOneFileLogger.getLogger(loggerName);
    }
}
