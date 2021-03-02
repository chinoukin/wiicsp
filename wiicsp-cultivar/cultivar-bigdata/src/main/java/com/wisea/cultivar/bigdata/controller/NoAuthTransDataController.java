package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.bigdata.service.TransDataService;
import com.wisea.cultivar.common.vo.bigdata.*;
import com.wisea.cultivar.common.vo.tp.OrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import com.wisea.cultivar.common.vo.tp.statistics.TransactionDataChartVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * TransDataController
 *  交易大数据Controller
 * @author yangtao
 */
@Api(tags = "[无权限]交易大数据相关接口")
@RequestMapping(value = "/n/trans/")
@RestController
public class NoAuthTransDataController {

    @Autowired
    protected TransDataService service;

    @ApiOperation(value = "近12个月、近30天交易趋势大数据。返回值map，其中key值0是30天数据，1是12月数据")
    @RequestMapping(value = "ordTransData", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Map<String, List<TransactionDataChartVo>>> ordTransData() {
        return service.ordTransData();
    }

    @ApiOperation(value = "全球销量、全球销售总金额、热卖品种")
    @RequestMapping(value = "HeadNumAndSearch", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HeadNumAndSearchVo> headNumAndSearch() {
        return service.headNumAndSearch();
    }


    @DataCheck
    @PostMapping("/mapData")
    @ApiOperation("地图数据")
    public ResultPoJo<List<TransMapVo>> findMapData() {
        return service.findMapData();
    }

    @DataCheck
    @PostMapping("/modeSettlement")
    @ApiOperation("交收方式分析")
    public ResultPoJo<List<OrderSettlement>> modeSettlement() {
        return service.modeSettlement();
    }
}
