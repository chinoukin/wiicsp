package com.wisea.cultivar.bigdata.controller;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.po.bigdata.HeadquartersCategoryTransactionTrendsPo;
import com.wisea.cultivar.common.po.bigdata.HeadquartersSupplyPo;
import com.wisea.cultivar.common.po.bigdata.HeadquartersTransactionRankingPo;
import com.wisea.cultivar.common.po.bigdata.TotalSalesPo;
import com.wisea.cultivar.bigdata.service.HeadTradingDynamicService;
import com.wisea.cultivar.common.vo.bigdata.HeadquartersCategoryTransactionTrendsVo;
import com.wisea.cultivar.common.vo.bigdata.HeadquartersSupplyVo;
import com.wisea.cultivar.common.vo.bigdata.HeadquartersTransactionRankingVo;
import com.wisea.cultivar.common.vo.bigdata.TotalSalesVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersTransactionsController
 * @date 2019/12/5 16:34
 * @Description 总部交易动态展示
 */
@Api(tags = "总部交易动态展示相关接口（大数据前端展示接口集合）")
@RequestMapping(value = "/w/zbjydt")
@RestController
public class HeadTradingDynamicController {
    @Autowired
    private HeadTradingDynamicService service;

    @ApiOperation(value = "国内/国外货源各列表查询")
    @RequestMapping(value = "/findSupplyList", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<HeadquartersSupplyVo> findSupplyList(@RequestBody HeadquartersSupplyPo po) {
        return service.findSupplyList(po);
    }

    @ApiOperation(value = "国内/国外单品交易排行列表")
    @RequestMapping(value = "/transactionRanking", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<HeadquartersTransactionRankingVo>> transactionRanking(@RequestBody HeadquartersTransactionRankingPo po) {
        return service.transactionRanking(po);
    }

    @ApiOperation(value = "国内/国外品类交易走势分析")
    @RequestMapping(value = "/categoryTransactionTrends", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<HeadquartersCategoryTransactionTrendsVo>> categoryTransactionTrends(@RequestBody HeadquartersCategoryTransactionTrendsPo po) {
        return service.categoryTransactionTrends(po);
    }

    @ApiOperation(value = "国内/国外销售总额统计")
    @RequestMapping(value = "/totalSales", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<TotalSalesVo> totalSales(@RequestBody TotalSalesPo po) {
        return service.totalSales(po);
    }

    @ApiOperation(value = "获取订单年份列表")
    @RequestMapping(value = "/getOrdYears", method = RequestMethod.POST)
    @DataCheck
    public ResultPoJo<List<String>> getOrdYears(){
        return service.getOrdYears();
    }

}
