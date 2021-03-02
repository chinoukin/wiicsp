package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.OrderInfoTbService;
import com.wisea.cultivar.common.entity.tp.OrderInfoMiddle;
import com.wisea.cultivar.common.po.bigdata.OrderInfoTbPo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author jirg
 * @Date 2020/12/23 9:22
 * @Description
 **/
@Api(tags = "订单同步中间表Controller")
@RequestMapping(value = "/w/orderInfoTb")
@RestController
public class OrderInfoTbController {

    @Autowired
    private OrderInfoTbService orderInfoTbService;

    /**
     * 同步交易服务订单
     * @param po
     * @return
     */
    @ApiOperation(value = "同步交易服务订单")
    @RequestMapping(value = "/orderSync", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> orderSync(@RequestBody List<OrderInfoTbPo> po) {
        return orderInfoTbService.orderSync(po);
    }
}
