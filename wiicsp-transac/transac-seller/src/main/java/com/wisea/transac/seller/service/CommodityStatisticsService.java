package com.wisea.transac.seller.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.dao.OrdCommRelaMapper;
import com.wisea.transac.common.dao.StallsMageMapper;
import com.wisea.transac.common.po.product.CommStatisPo;
import com.wisea.transac.common.po.product.CommodityStatisticsPo;
import com.wisea.transac.common.po.seller.StallsMagePageListPo;
import com.wisea.transac.common.utils.SellerMembUtils;
import com.wisea.transac.common.vo.product.CommStaticsVo;
import com.wisea.transac.common.vo.product.CommdityCategoriesVo;
import com.wisea.transac.common.vo.product.CommodityCurrentVo;
import com.wisea.transac.common.vo.product.CommodityStatisticsVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Description: 商品统计信息
 * @author: wangs
 * @date :2020/5/25
 */
@Service
public class CommodityStatisticsService {

    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    OrdCommRelaMapper ordCommRelaMapper;
    @Autowired
    StallsMageMapper stallsMageMapper;

    /**
     * 商家APP  商品统计信息
     *
     * @param commodityStatisticsPo
     * @return
     */
    public ResultPoJo<List<CommodityStatisticsVo>> list(CommodityStatisticsPo commodityStatisticsPo) {

        ResultPoJo<List<CommodityStatisticsVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        commodityStatisticsPo.setStartTime(OffsetDateTimeUtils.getDayMinTime(commodityStatisticsPo.getStartTime()));
        commodityStatisticsPo.setEndTime(OffsetDateTimeUtils.getDayMaxTime(commodityStatisticsPo.getEndTime()));
        if (ConverterUtil.isEmpty(commodityStatisticsPo.getStallsMageIds())) {
            //设置当前登录用户所属档口
            User user = SystemUtils.getUser();
            commodityStatisticsPo.setStallsMageIds(SellerMembUtils.getStallsIds(user.getId()));
        }
        if (ConverterUtil.isNotEmpty(commodityStatisticsPo.getStallsMageIds()) && commodityStatisticsPo.getStallsMageIds().size() != 0) {

            List<CommodityStatisticsVo> commodityStatisticsVos = commPubInfoMapper.selCommodityStatisticsList(commodityStatisticsPo);
            result.setResult(commodityStatisticsVos);
        }
        return result;
    }

    /**
     * 运营后台  商品销售情况统计信息
     *
     * @param commStatisPo
     * @return
     */
    public ResultPoJo<Page<CommStaticsVo>> commSaleStatics(CommStatisPo commStatisPo) {

        ResultPoJo<Page<CommStaticsVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        Page<CommStaticsVo> page = commStatisPo.getPage();
        if (ConverterUtil.isNotEmpty(commStatisPo.getTimeStart())) {
            commStatisPo.setTimeEnd(OffsetDateTimeUtils.getDayMaxTime(commStatisPo.getTimeEnd()));
            commStatisPo.setTimeStart(OffsetDateTimeUtils.getDayMaxTime(commStatisPo.getTimeStart()));
        }
        StallsMagePageListPo stallsMagePageListPo = new StallsMagePageListPo();
        stallsMagePageListPo.setWholeSaleMarketId(commStatisPo.getMarketId());
        // 根据市场id 查询所以档口
        List<StallsMagePageListVo> pageList = stallsMageMapper.findPageList(stallsMagePageListPo);
        if (ConverterUtil.isNotEmpty(pageList)) {
            List<Long> ids = Lists.newArrayList();
            pageList.forEach(e -> {
                ids.add(e.getId());
            });
            commStatisPo.setStallsMageIds(ids);
            List<CommStaticsVo> statisCommList = ordCommRelaMapper.commSaleStatics(commStatisPo);
            page.setList(statisCommList);
        }
        result.setResult(page);
        return result;
    }

    /**
     * 运营后台统计   热卖商品统计信息
     *
     * @param commStatisPo
     * @return
     */
    public ResultPoJo<List<CommStaticsVo>> statisCommHot(CommStatisPo commStatisPo) {

        ResultPoJo<List<CommStaticsVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (ConverterUtil.isNotEmpty(commStatisPo.getTimeStart())) {
            commStatisPo.setTimeEnd(OffsetDateTimeUtils.getDayMaxTime(commStatisPo.getTimeEnd()));
            commStatisPo.setTimeStart(OffsetDateTimeUtils.getDayMaxTime(commStatisPo.getTimeStart()));
        }
        StallsMagePageListPo stallsMagePageListPo = new StallsMagePageListPo();
        stallsMagePageListPo.setWholeSaleMarketId(commStatisPo.getMarketId());
        // 根据市场id 查询所以档口
        List<StallsMagePageListVo> pageList = stallsMageMapper.findPageList(stallsMagePageListPo);
        if (ConverterUtil.isNotEmpty(pageList)) {
            List<Long> ids = Lists.newArrayList();
            pageList.forEach(e -> {
                ids.add(e.getId());
            });
            commStatisPo.setStallsMageIds(ids);
            List<CommStaticsVo> statisCommHot = ordCommRelaMapper.statisCommHot(commStatisPo);
            result.setResult(statisCommHot);
        }
        return result;
    }

    /**
     * 运营后台统计 商品类目销售top10
     *
     * @param commStatisPo
     * @return
     */
    public ResultPoJo<List<CommdityCategoriesVo>> commSetSaleScale(CommStatisPo commStatisPo) {

        ResultPoJo<List<CommdityCategoriesVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (ConverterUtil.isNotEmpty(commStatisPo.getTimeStart())) {
            commStatisPo.setTimeEnd(OffsetDateTimeUtils.getDayMaxTime(commStatisPo.getTimeEnd()));
            commStatisPo.setTimeStart(OffsetDateTimeUtils.getDayMaxTime(commStatisPo.getTimeStart()));
        }
        StallsMagePageListPo stallsMagePageListPo = new StallsMagePageListPo();
        stallsMagePageListPo.setWholeSaleMarketId(commStatisPo.getMarketId());
        // 根据市场id 查询所以档口
        List<StallsMagePageListVo> pageList = stallsMageMapper.findPageList(stallsMagePageListPo);
        if (ConverterUtil.isNotEmpty(pageList)) {
            List<Long> ids = Lists.newArrayList();
            pageList.forEach(e -> {
                ids.add(e.getId());
            });
            commStatisPo.setStallsMageIds(ids);
        }
        List<CommdityCategoriesVo> commodityStatisticsVos = commPubInfoMapper.commSetSaleScale(commStatisPo);
        result.setResult(commodityStatisticsVos);
        return result;
    }

    /**
     * 获取当前服务器时间
     *
     * @return
     */
    public CommodityCurrentVo getCrrentServerTime() {

        CommodityCurrentVo commodityCurrentVo = new CommodityCurrentVo();
        commodityCurrentVo.setCurrentServerTime(OffsetDateTime.now());
        return commodityCurrentVo;
    }
}
