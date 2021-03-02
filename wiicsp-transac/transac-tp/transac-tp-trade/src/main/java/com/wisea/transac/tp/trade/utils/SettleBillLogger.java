package com.wisea.transac.tp.trade.utils;

import ch.qos.logback.classic.Logger;
import com.wisea.cloud.common.logger.InOneFileLogger;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * @Author jirg
 * @Date 2020/6/5 15:31
 * @Description 结算单日志
 */
public class SettleBillLogger {
    public static final String LOGGER_PREFIX = "settleBill_";

    /**
     * 获取结算单日志对象(一个结算单一个日志对象)
     *
     * @param orderId
     * @return
     */
    public static Logger getLogger(Long orderId) {
        String loggerName = LOGGER_PREFIX + ConverterUtil.toString(orderId);
        return InOneFileLogger.getLogger(loggerName);
    }
}
