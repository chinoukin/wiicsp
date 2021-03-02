package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.MonthlyDistrTrendService;
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
 * MonthlyDistrTrendController
 * 月配送单量趋势 Controller
 * 2020/09/02 15:33:51
 */
@Api(tags = "月配送单量趋势相关接口")
@RequestMapping(value = "/w/MonthlyDistrTrend")
@RestController
public class MonthlyDistrTrendController {
    @Autowired
    protected MonthlyDistrTrendService monthlyDistrTrendService;

    @ApiOperation(value = "获取月配送单量趋势列表")
    @RequestMapping(value = "list", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<MonthlyDistrTrendListVo>> findAllList() {
        return monthlyDistrTrendService.findAllList();
    }


    @ApiOperation(value = "修改月配送单量趋势")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Object> update(@RequestBody MonthlyDistrUpdatePo po) {
        return monthlyDistrTrendService.update(po);
    }

}
