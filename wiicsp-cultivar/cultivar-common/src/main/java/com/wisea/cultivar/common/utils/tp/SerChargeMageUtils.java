package com.wisea.cultivar.common.utils.tp;

import com.wisea.cultivar.common.dao.tp.MrSerChargeMageMapper;
import com.wisea.cultivar.common.dao.tp.YhSerChargeMageMapper;
import com.wisea.cultivar.common.entity.tp.MrSerChargeMage;
import com.wisea.cultivar.common.entity.tp.YhSerChargeMage;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className SerChargeMageUtils
 * @date 2019/5/16 15:02
 * @Description 服务费工具类
 */
public class SerChargeMageUtils {
    public static YhSerChargeMageMapper yhSerChargeMageMapper = SpringBootContext.getBean(YhSerChargeMageMapper.class);
    public static MrSerChargeMageMapper mrSerChargeMageMapper = SpringBootContext.getBean(MrSerChargeMageMapper.class);


    /**
     * @Author jirg
     * @Date 2019/5/16 15:04
     * @Description 获取优惠服务费
     **/
    public static YhSerChargeMage getYhSerChargeMage(Long commMageId, String commPubType, Long sellerId){
        return getSerChargeMage(commMageId, commPubType, sellerId);
    }

    /**
     * @Author jirg
     * @Date 2019/5/16 15:04
     * @Description 获取优惠服务费
     **/
    public static MrSerChargeMage getMrSerChargeMage(Long commMageId, String commPubType){
        return getSerChargeMage(commMageId, commPubType, null);
    }

    public static <T> T getSerChargeMage(Long commMageId, String commPubType, Long sellerId){
        // 获取商品分类及父级分类Id列表
        List<Long> commMageIds = CommUtils.getCommMageIds(commMageId);
        if(ConverterUtil.isNotEmpty(sellerId)){
            // 查询所有优惠服务费管理列表
            YhSerChargeMage yhSerChargeMage = new YhSerChargeMage();
            yhSerChargeMage.setTransModeType(commPubType);
            yhSerChargeMage.setAppointMembId(sellerId.toString());
            List<YhSerChargeMage> yhSerChargeMages = yhSerChargeMageMapper.findList(yhSerChargeMage);
            // 当前卖家并且交易模式为指定模式的优惠服务费管Map，key=商品ID，value=优惠服务费管理
            Map<Long, YhSerChargeMage> commMageYhSerChargeMageMap = yhSerChargeMages.stream().collect(Collectors.toMap(YhSerChargeMage::getCommId, Function.identity()));
            AtomicReference<YhSerChargeMage> yhSerChargeMageAtomic = new AtomicReference<YhSerChargeMage>();
            //循环商品分类列表，找出第一个优惠服务费管理
            for (Long e : commMageIds){
                if(commMageYhSerChargeMageMap.containsKey(e)){
                    return (T)commMageYhSerChargeMageMap.get(e);
                }
            }
            return null;
        }else{
            // 查询所有默认服务费管理列表
            MrSerChargeMage mrSerChargeMage = new MrSerChargeMage();
            mrSerChargeMage.setTransModeType(commPubType);
            List<MrSerChargeMage> mrSerChargeMages = mrSerChargeMageMapper.findList(mrSerChargeMage);
            Map<Long, MrSerChargeMage> commMageMrSerChargeMageMap = mrSerChargeMages.stream().collect(Collectors.toMap(MrSerChargeMage::getCommId, Function.identity()));
            AtomicReference<MrSerChargeMage> mrSerChargeMageAtomic =  new AtomicReference<MrSerChargeMage>();
            //循环商品分类列表，找出第一个优惠服务费管理
            for (Long e : commMageIds){
                if(commMageMrSerChargeMageMap.containsKey(e)){
                    return (T)commMageMrSerChargeMageMap.get(e);
                }
            }
            return null;
        }
    }
}
