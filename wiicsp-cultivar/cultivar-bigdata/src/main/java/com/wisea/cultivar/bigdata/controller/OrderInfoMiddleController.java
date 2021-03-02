package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.OrderInfoMiddleService;
import com.wisea.cultivar.common.entity.tp.OrderInfoMiddle;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrUpdatePo;
import com.wisea.cultivar.common.vo.bigdata.MonthlyDistrTrendListVo;
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
 * @Date 2020/12/18 11:05
 * @Description
 **/

@Api(tags = "交易中间表操作Controller")
@RequestMapping(value = "/w/orderInfoMiddle")
@RestController
public class OrderInfoMiddleController {

    @Autowired
    protected OrderInfoMiddleService orderInfoMiddleService;


    @ApiOperation(value = "同步订单")
    @RequestMapping(value = "/orderSync", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<?> orderSync(@RequestBody List<OrderInfoMiddle> po) {
        return orderInfoMiddleService.orderSync(po);
    }

}
