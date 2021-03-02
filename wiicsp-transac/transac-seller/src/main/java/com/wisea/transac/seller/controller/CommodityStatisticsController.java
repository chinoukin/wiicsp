package com.wisea.transac.seller.controller;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.po.product.CommStatisPo;
import com.wisea.transac.common.po.product.CommodityStatisticsPo;
import com.wisea.transac.common.vo.product.CommStaticsVo;
import com.wisea.transac.common.vo.product.CommdityCategoriesVo;
import com.wisea.transac.common.vo.product.CommodityCurrentVo;
import com.wisea.transac.common.vo.product.CommodityStatisticsVo;
import com.wisea.transac.seller.service.CommodityStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 商品统计信息
 * @author: wangs
 * @date :2020/5/25
 */
@RestController
@RequestMapping("/w/commdityStatistics")
@Api(tags = "商品统计信息")
public class CommodityStatisticsController {

    @Autowired
    CommodityStatisticsService commodityStatisticsService;

    /**
     * 商家APP  商品统计信息
     *
     * @param commodityStatisticsPo
     * @return
     */
    @ApiOperation(value = "商家APP 商品统计信息", httpMethod = "POST")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResultPoJo<List<CommodityStatisticsVo>> list(@RequestBody CommodityStatisticsPo commodityStatisticsPo) {
        return commodityStatisticsService.list(commodityStatisticsPo);

    }

    /**
     * 运营后台统计 商品销售情况统计
     *
     * @return
     */
    @RequestMapping(value = "/motionList", method = RequestMethod.POST)
    @ApiOperation(nickname = "运营后台统计 ", value = "商品销售情况统计", notes = "运营后台统计 商品销售情况统计", httpMethod = "POST")
    public ResultPoJo<Page<CommStaticsVo>> commSaleStatics(@RequestBody CommStatisPo commStatisPo) {
        return commodityStatisticsService.commSaleStatics(commStatisPo);
    }

    /**
     * 运营后台统计   商品类目销售top10
     *
     * @param commStatisPo
     * @return
     */
    @RequestMapping(value = "/commSetSaleScale", method = RequestMethod.POST)
    @ApiOperation(nickname = "运营后台统计", value = "商品类目销售top10", notes = "运营后台统计  商品类目销售top10", httpMethod = "POST")
    public ResultPoJo<List<CommdityCategoriesVo>> commSetSaleScale(@RequestBody CommStatisPo commStatisPo) {
        return commodityStatisticsService.commSetSaleScale(commStatisPo);
    }

    /**
     * 运营后台统计   热卖商品统计信息
     *
     * @param commStatisPo
     * @return
     */
    @RequestMapping(value = "/statisCommHot", method = RequestMethod.POST)
    @ApiOperation(nickname = "运营后台统计", value = "热卖商品统计信息", notes = "运营后台统计  热卖商品统计信息", httpMethod = "POST")
    public ResultPoJo<List<CommStaticsVo>> statisCommHot(@RequestBody CommStatisPo commStatisPo) {
        return commodityStatisticsService.statisCommHot(commStatisPo);

    }

    /**
     * 获取当前服务器时间
     * @return
     */
    @RequestMapping(value = "/getCrrentServerTime", method = RequestMethod.POST)
    @ApiOperation(nickname = "获取当前服务器时间", value = "服务器时间", notes = "运营后台统计  热卖商品统计信息 当前服务器时间", httpMethod = "POST")
    public CommodityCurrentVo getCrrentServerTime () {
        return commodityStatisticsService.getCrrentServerTime();
    }
}
