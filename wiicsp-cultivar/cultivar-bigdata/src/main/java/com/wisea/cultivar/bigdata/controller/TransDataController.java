package com.wisea.cultivar.bigdata.controller;

import java.util.List;
import java.util.Map;

import com.wisea.cultivar.bigdata.mss.MemberMss;
import com.wisea.cultivar.bigdata.service.TransDataService;
import com.wisea.cultivar.common.vo.bigdata.*;
import com.wisea.cultivar.common.vo.tp.OrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import com.wisea.cultivar.common.vo.tp.statistics.TransactionDataChartVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * TransDataController
 *  交易大数据Controller
 * @author yangtao
 */
@Api(tags = "交易大数据相关接口")
@RequestMapping(value = "/w/trans/")
@RestController
public class TransDataController {

    @Autowired
    protected MemberMss memberMss;

    @Autowired
    protected TransDataService service;

    @ApiOperation(value = "近12个月、近30天交易趋势大数据和全国果品销售类别分析。返回值map，其中key值0是30天数据，1是12月数据，2是销售类别")
    @RequestMapping(value = "ordTransData", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Map<String, List<TransactionDataChartVo>>> ordTransData() {
        return service.ordTransData();
    }

    @ApiOperation(value = "销售类别分析")
    @RequestMapping(value = "salePlant", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Map<String,List<ChartVo>>> salePlant() {
        return service.salePlant();
    }

    @ApiOperation(value = "热销品类榜单、品牌、价格占比和供应商排名。返回值map，其中key值 1热销品类榜单，2是品牌，3是价格，4是供应商排名")
    @RequestMapping(value = "transBingData", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<Map<String,List<ChartVo>>> transLevelData() {
        return service.transLevelData();
    }

    @ApiOperation(value = "全球销量、全球销售总金额、热卖品种")
    @RequestMapping(value = "HeadNumAndSearch", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HeadNumAndSearchVo> headNumAndSearch() {
        return service.headNumAndSearch();
    }



    @ApiOperation(value = "全国热销城市占比分析")
    @RequestMapping(value = "transRxCityData", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<ChartVo>> transRxCityData() {
        return service.transRxCityData();
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

    @DataCheck
    @PostMapping("/findUser")
    @ApiOperation("查找用户数量")
    public ResultPoJo<List<ChartVo>> findUser() {
        return memberMss.findUser();
    }
}
