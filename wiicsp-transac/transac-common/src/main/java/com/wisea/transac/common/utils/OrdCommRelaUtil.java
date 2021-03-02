package com.wisea.transac.common.utils;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.CommPubInfoMapper;
import com.wisea.transac.common.dao.SellerSpeSerCostMageMapper;
import com.wisea.transac.common.entity.MrSerChargeMage;
import com.wisea.transac.common.entity.OrdCommRela;
import com.wisea.transac.common.entity.OrdCommRelaPlatfCost;
import com.wisea.transac.common.entity.YhSerChargeMage;
import com.wisea.transac.common.vo.system.SellerSpeSerCostMageGetVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className OrdCommRelaUtil
 * @date 2019/1/16 11:20
 * @Description 订单商品工具类
 */
public class OrdCommRelaUtil {
    public static Logger logger = LoggerFactory.getLogger(OrdCommRelaUtil.class);
    public static CommPubInfoMapper commPubInfoMapper = SpringBootContext.getBean(CommPubInfoMapper.class);
    public static SellerSpeSerCostMageMapper sellerSpeSerCostMageMapper = SpringBootContext.getBean(SellerSpeSerCostMageMapper.class);

    /**
     * @Author jirg
     * @Date 2019/1/16 11:23
     * @Description 计算普通订单商品服务费
     **/
    public static List<OrdCommRela> ordPlatfCost(List<OrdCommRela> ordCommPubInfos, Long sellerId, Long buyerId) {
        List<Long> commPubIds = ordCommPubInfos.stream().map(e -> {
            return e.getCommPubId();
        }).collect(Collectors.toList());
        // 根据发布商品ID查询对应品类ID   key: 发布商品ID，value：品类ID
        Map<Long, Long> commIdMap = commPubInfoMapper.getCommIdMap(commPubIds);

        // 封装公共参数
        List<OrdCommRelaPlatfCost> ordCommRelaPlatfCosts = Lists.newArrayList();
        ordCommPubInfos.forEach(e->{
            OrdCommRelaPlatfCost ordCommRelaPlatfCost = new OrdCommRelaPlatfCost();
            ordCommRelaPlatfCost.setOrdCommRelaId(e.getId());
            ordCommRelaPlatfCost.setCommPubId(e.getCommPubId());
            ordCommRelaPlatfCost.setPrice(e.getPrice());
            ordCommRelaPlatfCost.setCount(e.getCount());
            ordCommRelaPlatfCost.setCommId(commIdMap.get(e.getCommPubId()));
            ordCommRelaPlatfCosts.add(ordCommRelaPlatfCost);
        });

        // 调用计算服务费方法
        calculatePlatfCost(ordCommRelaPlatfCosts, sellerId, buyerId);

        Map<Long, Double> platfCostMap = ordCommRelaPlatfCosts.stream().collect(Collectors.toMap(OrdCommRelaPlatfCost::getOrdCommRelaId, OrdCommRelaPlatfCost::getPlatfCost));

        // 封装返回参数
        ordCommPubInfos.forEach(e->{
            e.setPlatfCost(platfCostMap.get(e.getId()));
        });
        return ordCommPubInfos;
    }

    /**
     * @Author yangtao
     * @Date 2019/1/16 11:23
     * @Description 计算订单单个商品服务费
     **/
    public static OrdCommRela commPlatfCost(OrdCommRela ordCommPubInfo, Long sellerId, Long buyerId) {
        List<OrdCommRela> ordCommPubInfos = Lists.newArrayList();
        ordCommPubInfos.add(ordCommPubInfo);
        ordPlatfCost(ordCommPubInfos, sellerId, buyerId);
        return ordCommPubInfos.get(0);
    }

    /**
     * @Author jirg
     * @Date 2019/1/16 11:23
     * @Description 计算订单商品服务费
     **/
    public static List<OrdCommRelaPlatfCost> calculatePlatfCost(List<OrdCommRelaPlatfCost> ordCommRelaPlatfCosts, Long sellerId, Long buyerId) {
        // 判断买卖家是否设置了特殊交易服务费
        SellerSpeSerCostMageGetVo sellerSpeSerCostMage = sellerSpeSerCostMageMapper.findBySellerIdAndBuyerId(sellerId, buyerId);
        logger.info("【特殊交易】服务费:{}", sellerSpeSerCostMage);
        if(ConverterUtil.isEmpty(sellerSpeSerCostMage)){
            // 判断该买家是否有特殊手续费
            ordCommRelaPlatfCosts.forEach(e->{
                // 商品总金额
                Double totalAmount = ConverterUtil.mul(e.getPrice(), e.getCount());
                logger.info("商品总金额:{}", totalAmount);
                Double platfCost = 0.0;

                // 判断商家该商品是否有优惠服务费
                YhSerChargeMage yhSerChargeMage = SerChargeMageUtils.getYhSerChargeMage(e.getCommId(), sellerId);
                logger.info("【优惠】服务费:{}", yhSerChargeMage);
                if(ConverterUtil.isEmpty(yhSerChargeMage) || yhSerChargeMage.getDiscountType().equals(DictConstants.DISCOUNT_TYPE_0)){
                    // 商家没有优惠服务费或者优惠服务费类型为总体折扣，查询默认服务费
                    MrSerChargeMage mrSerChargeMage = SerChargeMageUtils.getMrSerChargeMage(e.getCommId());
                    logger.info("【默认】服务费:{}", yhSerChargeMage);
                    if(ConverterUtil.isNotEmpty(mrSerChargeMage)){
                        // 计算商品服务费
                        platfCost = ConverterUtil.mul(totalAmount, ConverterUtil.div(mrSerChargeMage.getSqVal(), 100, 2));
                        if(platfCost.compareTo(mrSerChargeMage.getOneceMin()) < 0){
                            // 小于单笔最小值 服务费 = 单笔最小值
                            platfCost = mrSerChargeMage.getOneceMin();
                        }
                        if(platfCost.compareTo(mrSerChargeMage.getOneceMax()) > 0){
                            // 大于单笔最大值 服务费 = 单笔最大值
                            platfCost = mrSerChargeMage.getOneceMax();
                        }

                        // 判断是否是总体折扣
                        if(ConverterUtil.isNotEmpty(yhSerChargeMage)){
                            // 总体折扣
                            platfCost = ConverterUtil.mul(platfCost, ConverterUtil.div(yhSerChargeMage.getSqVal(), 100, 2));
                        }
                    }
                }else{
                    // 重新指定商家服务费，根据订单商品总金额计算该商品服务费
                    platfCost = ConverterUtil.mul(totalAmount, ConverterUtil.div(yhSerChargeMage.getSqVal(), 100, 2));
                    if(platfCost.compareTo(yhSerChargeMage.getOneceMin()) < 0){
                        // 小于单笔最小值 服务费 = 单笔最小值
                        platfCost = yhSerChargeMage.getOneceMin();
                    }
                    if(platfCost.compareTo(yhSerChargeMage.getOneceMax()) > 0){
                        // 大于单笔最大值 服务费 = 单笔最大值
                        platfCost = yhSerChargeMage.getOneceMax();
                    }
                }
                logger.info("商品服务费:{}", platfCost);
                // 设置商品服务费
                e.setPlatfCost(ConverterUtil.getRoundValue(platfCost, 2));
            });
        }else{
            // 直接设置单个商品服务费为 0
            ordCommRelaPlatfCosts.forEach(e->{
                e.setPlatfCost(0D);
            });
        }
        return ordCommRelaPlatfCosts;
    }

}
