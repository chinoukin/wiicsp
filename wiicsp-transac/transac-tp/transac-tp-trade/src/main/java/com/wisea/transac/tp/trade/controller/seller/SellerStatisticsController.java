package com.wisea.transac.tp.trade.controller.seller;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisea.cloud.common.annotation.DataCheck;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.po.trade.IncomeListPo;
import com.wisea.transac.common.po.trade.StaticOrderPo;
import com.wisea.transac.common.vo.trade.BuyerGetSystemTimeVo;
import com.wisea.transac.common.vo.trade.CgsOrderVo;
import com.wisea.transac.common.vo.trade.ChartVo;
import com.wisea.transac.common.vo.trade.IncomeListVo;
import com.wisea.transac.common.vo.trade.OrderListNumVo;
import com.wisea.transac.common.vo.trade.OrderStatisticsVo;
import com.wisea.transac.common.vo.trade.SellerIncomeListVo;
import com.wisea.transac.common.vo.trade.StatisMembOrdVo;
import com.wisea.transac.common.vo.trade.StatisOrderVo;
import com.wisea.transac.common.vo.trade.StatisTradeVo;
import com.wisea.transac.common.vo.trade.YesterdayStatisticsVo;
import com.wisea.transac.tp.trade.service.OrderInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author jirg
 * @version 1.0
 * @className SellerStatisticsController
 * @date 2020/5/25 14:12
 * @Description 统计Controller
 */
@Api(tags = "卖家统计")
@RestController
@RequestMapping("/w/seller/statistics")
public class SellerStatisticsController {
    @Autowired
    private OrderInfoService service;

    /**
     * @Author jirg
     * @Date 2020/5/25 14:13
     * @Description 首页昨日交易统计
     */
    @DataCheck
    @RequestMapping(value = "/yesterdayStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "首页昨日交易统计", value = "首页昨日交易统计", notes = "首页昨日交易统计", httpMethod = "POST")
    public ResultPoJo<YesterdayStatisticsVo> yesterdayStatistics() {
        return service.yesterdayStatistics();
    }

    /**
     * @Author jirg
     * @Date 2020/5/25 14:13
     * @Description 交易首页-订单状态数量
     */
    @DataCheck
    @RequestMapping(value = "/orderStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "交易首页-订单状态数量", value = "交易首页-订单状态数量", notes = "交易首页-订单状态数量", httpMethod = "POST")
    public ResultPoJo<OrderStatisticsVo> orderStatistics() {
        return service.orderStatistics();
    }

    /**
     * @Author jirg
     * @Date 2020/5/25 14:13
     * @Description 首页昨日交易统计
     */
    /*
    @DataCheck
    @RequestMapping(value = "/serviceFeeStatistics", method = RequestMethod.POST)
    @ApiOperation(nickname = "首页昨日交易统计", value = "首页昨日交易统计", notes = "首页昨日交易统计", httpMethod = "POST")
    public ResultPoJo<ServiceFeeStatisticsVo> serviceFeeStatistics(@RequestBody ServiceFeeStatisticsPo po) {
        return service.serviceFeeStatistics(po);
    }
    */

    /**
     * 财务首页
     * @param po
     * @return
     */
    @ApiOperation(nickname="【财务】财务首页", value="【财务】财务首页（0是订单发票，1是账期发票）", notes="财务首页（0是订单发票，1是账期发票）", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/financeStatInfo",method=RequestMethod.POST)
    public ResultPoJo<List<OrderListNumVo>> financeStatInfo () {
        return service.financeStatInfo();
    }

    /**
     * 订单统计
     * @param po
     * @return
     */
    @ApiOperation(nickname="【财务】订单统计", value="【财务】订单统计", notes="订单统计", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/statisOrder",method=RequestMethod.POST)
    public ResultPoJo<StatisOrderVo> statisOrder (@RequestBody StaticOrderPo po) {
        return service.statisOrder(po);
    }

    /**
     * 会员统计
     * @param po
     * @return
     */
    @ApiOperation(nickname="【财务】会员统计", value="【财务】会员统计", notes="会员统计", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/staticMembOrd",method=RequestMethod.POST)
    public ResultPoJo<StatisMembOrdVo> staticMembOrd () {
        return service.staticMembOrd();
    }

    /**
     * 采购商排名统计
     * @param po
     * @return
     */
    @ApiOperation(nickname="采购商排名统计", value="采购商排名统计", notes="采购商排名统计", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/cgsOrdStatic",method=RequestMethod.POST)
    public ResultPoJo<Page<CgsOrderVo>> cgsOrdStatic (@RequestBody StaticOrderPo po) {
        return service.cgsOrdStatic(po);
    }

    /**
     * 供应商排名统计
     * @param po
     * @return
     */
    @ApiOperation(nickname="供应商排名统计", value="供应商排名统计", notes="供应商排名统计", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/gysOrdStatic",method=RequestMethod.POST)
    public ResultPoJo<Page<CgsOrderVo>> gysOrdStatic (@RequestBody StaticOrderPo po) {
        return service.gysOrdStatic(po);
    }

    /**
     *  交易数据统计
     * @param po
     * @return
     */
    @ApiOperation(nickname="交易数据统计", value="交易数据统计", notes="交易数据统计", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/statisTrade",method=RequestMethod.POST)
    public ResultPoJo<StatisTradeVo> statisTrade (@RequestBody StaticOrderPo po) {
        return service.statisTrade(po);
    }

    /**
     *  订单金额分布
     * @param po
     * @return
     */
    @ApiOperation(nickname="订单金额分布", value="订单金额分布", notes="订单金额分布", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/ordAmountStatis",method=RequestMethod.POST)
    public ResultPoJo<List<ChartVo>> ordAmountStatis (@RequestBody StaticOrderPo po) {
        return service.ordAmountStatis(po);
    }

    /**
     *  档口成交金额
     * @param po
     * @return
     */
    @ApiOperation(nickname="档口成交金额", value="档口成交金额", notes="档口成交金额", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/stallAmountStatis",method=RequestMethod.POST)
    public ResultPoJo<List<ChartVo>> stallAmountStatis (@RequestBody StaticOrderPo po) {
        return service.stallAmountStatis(po);
    }

    /**
     *  采购商消费金额分布
     * @param po
     * @return
     */
    @ApiOperation(nickname="采购商消费金额分布", value="采购商消费金额分布", notes="采购商消费金额分布", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/cgsPayCountStatics",method=RequestMethod.POST)
    public ResultPoJo<List<ChartVo>> cgsPayCountStatics (@RequestBody StaticOrderPo po) {
        return service.cgsPayCountStatics(po);
    }

    /**
     *  采购商消费金额分布
     * @param po
     * @return
     */
    @ApiOperation(nickname="收支明细列表(商家)", value="收支明细列表(商家)", notes="收支明细列表(商家)", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/incomeList",method=RequestMethod.POST)
    public ResultPoJo<SellerIncomeListVo> incomeList (@RequestBody IncomeListPo po) {
        return service.incomeList(po);
    }

    /**
     * 后台收支明细列表(后台)
     * @param po
     * @return
     */
    @ApiOperation(nickname="后台收支明细列表(后台)", value="后台收支明细列表(后台)", notes="后台收支明细列表(后台)", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/platIncomeList",method=RequestMethod.POST)
    public ResultPoJo<Page<IncomeListVo>> platIncomeList (@RequestBody IncomeListPo po) {
        return service.platIncomeList(po);
    }

    /**
     * 导出后台收支明细列表(后台)
     * @param po
     * @return
     */
    @ApiOperation(nickname="导出后台收支明细列表(后台)", value="导出后台收支明细列表(后台)", notes="导出后台收支明细列表(后台)", httpMethod = "POST")
    @DataCheck
    @RequestMapping(value="/platIncomeListExp",method=RequestMethod.POST)
    public ResultPoJo<Page<IncomeListVo>> platIncomeListExp (@RequestBody IncomeListPo po, HttpServletResponse response) throws IOException {
        return service.platIncomeListExp(po, response);
    }

    /**
     *获取系统时间
     * @param
     * @return
     */
    @ApiOperation(value="获取系统时间", notes="获取系统时间")
    @RequestMapping(value="/getSystemTime",method=RequestMethod.POST)
    @DataCheck
    public ResultPoJo<BuyerGetSystemTimeVo> getSystemTime() {
        ResultPoJo<BuyerGetSystemTimeVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        BuyerGetSystemTimeVo vo = new BuyerGetSystemTimeVo();
        vo.setNowDate(OffsetDateTime.now());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }
}
