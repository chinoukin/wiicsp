package com.wisea.transac.tp.trade.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.transac.tp.trade.utils.OrderLogger;

import ch.qos.logback.classic.Logger;

@RestController
public class TestLogger {

    @DataCheck
    @RequestMapping(value = "/ordLoggertest", method = RequestMethod.POST)
    public ResultPoJo<Object> ordLoggertest() {
        Logger logger = OrderLogger.getLogger(123456l);
        logger.debug("订单日志测试");
        return new ResultPoJo<Object>();
    }
}
