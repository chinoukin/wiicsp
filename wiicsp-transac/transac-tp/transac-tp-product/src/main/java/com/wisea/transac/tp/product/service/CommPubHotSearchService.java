package com.wisea.transac.tp.product.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.dao.MeasUnitMageMapper;
import com.wisea.transac.common.dao.StallsMageMapper;
import com.wisea.transac.common.po.product.CommPubInfoPagePo;
import com.wisea.transac.common.po.seller.StallsMagePageListPo;
import com.wisea.transac.common.utils.AssemblyPriceUtil;
import com.wisea.transac.common.vo.MeasUnitMageInfoVo;
import com.wisea.transac.common.vo.product.AssembyPriceVo;
import com.wisea.transac.common.vo.product.CommPubInfoListVo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品的推荐信息
 */
@Service
public class CommPubHotSearchService {

    @Autowired
    CommPubInfoMapper commPubInfoMapper;
    @Autowired
    private StallsMageMapper stallsMageMapper;
    @Autowired
    MeasUnitMageMapper measUnitMageMapper;

    /**
     * 根据市场id 查询近30日内销量排序的商品
     *
     * @return
     */
    public ResultPoJo<List<CommPubInfoListVo>> hotSellList(LongIdPo longIdPo) {

        ResultPoJo<List<CommPubInfoListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        StallsMagePageListPo stallsMagePageListPo = new StallsMagePageListPo();
        stallsMagePageListPo.setWholeSaleMarketId(longIdPo.getId());
        // 查询所有的档口信息
        List<StallsMagePageListVo> pageList = stallsMageMapper.findPageList(stallsMagePageListPo);
        if (ConverterUtil.isNotEmpty(pageList)) {
            // 组装档口id
            List<Long> stallsIds = pageList.stream().map(StallsMagePageListVo::getId).collect(Collectors.toList());
            // 查询近30日内销量统计排序
            CommPubInfoPagePo commPubInfo = new CommPubInfoPagePo();
            OffsetDateTime date = OffsetDateTime.now();
            OffsetDateTime ageDate = date.plus(-1, ChronoUnit.MONTHS);
            commPubInfo.setNearlyMonth(ageDate);
            commPubInfo.setStallsMageIds(stallsIds);
            // 查询所有档口下的商品
            List<CommPubInfoListVo> infoListVo;
            infoListVo = commPubInfoMapper.findCommPubList(commPubInfo);
            if (infoListVo.size() < 10) {
                commPubInfo.setNearlyMonth(null);
                infoListVo = commPubInfoMapper.findCommPubList(commPubInfo);
            }
            if (ConverterUtil.isNotEmpty(infoListVo)) {
                infoListVo.forEach(e -> {
                    AssembyPriceVo productPrice = AssemblyPriceUtil.getProductPrice(e.getId());
                    LongIdPo longId = new LongIdPo();
                    longId.setId(productPrice.getMeasUnitIds().get(0));
                    MeasUnitMageInfoVo info = measUnitMageMapper.findInfo(longId);
                    String priceRang = productPrice.getPriceRang();
                    String[] split = priceRang.split("~");
                    e.setPriceRang(priceRang);
                    e.setMinPrice(split[0]);
                    e.setSalesVolumeTotal(productPrice.getSalesVolumeTotal());
                    e.setMeasUnitName(info.getMeasUnitName());
                });
            }
            Collections.sort(infoListVo, Comparator.comparing(CommPubInfoListVo::getSalesVolumeTotal, Comparator.reverseOrder()));
            result.setResult(infoListVo);
        } else {
            result.setCode(ConstantCodeMsg.ERR_347);
            result.setMsg(ConstantCodeMsg.MSG_347);
        }
        return result;

    }
}
