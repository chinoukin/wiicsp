package com.wisea.cultivar.common.utils.tp;

import com.google.common.collect.Lists;
import com.wisea.cultivar.common.dao.tp.CommMageMapper;
import com.wisea.cultivar.common.dao.tp.CommPubInfoMapper;
import com.wisea.cultivar.common.dao.tp.LevelSpecQuoteMapper;
import com.wisea.cultivar.common.entity.tp.CommPubInfo;
import com.wisea.cultivar.common.entity.tp.LevelSpecQuote;
import com.wisea.cultivar.common.po.tp.CommMageTreePo;
import com.wisea.cultivar.common.vo.tp.CommMageTreeVo;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: 判断工具类
 * @author: wangs
 * @date :2017/12/26
 */
public class CommUtils {

    private static CommMageMapper commMageMapper = SpringBootContext.getBean(CommMageMapper.class);
    private static CommPubInfoMapper commPubInfoMapper = SpringBootContext.getBean(CommPubInfoMapper.class);
    private static LevelSpecQuoteMapper levelSpecQuoteMapper = SpringBootContext.getBean(LevelSpecQuoteMapper.class);

    /**
     * 获取商品名称
     *
     * @param commMageId
     * @return
     */
    public static String getCommMageNames(Long commMageId) {
        //查询品类列表
        List<CommMageTreeVo> commMages = commMageMapper.findList(new CommMageTreePo());
        Map<Long, CommMageTreeVo> commMageMap = commMages.stream().collect(Collectors.toMap(CommMageTreeVo::getId, Function.identity()));
        List<String> mageNames = Lists.newArrayList();
        List<String> mageids = Lists.newArrayList();
        diGuiCommMageName(commMageMap, commMageId, mageNames, mageids);
        Collections.reverse(mageNames);
        Collections.reverse(mageids);
        return listToString(mageNames, " ").concat("-").concat(listIdToString(mageids, " "));
    }

    /**
     * 修改商品的可供货量
     *
     * @return
     */
    public static ResultPoJo<String> updateCommPubAvaiSupplyCount(LevelSpecQuote levelSpecQuote) {

        // 返回结果初期化
        ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
        // 根据商品发布id 查询对应的等级报价信息
        List<LevelSpecQuote> levelSpecQuotes = levelSpecQuoteMapper.commPubLevelPrice(levelSpecQuote);
        if (ConverterUtil.isNotEmpty(levelSpecQuotes)) {
            CommPubInfo commPubInfo = new CommPubInfo();
            double avaiSupply = 0;
            for (LevelSpecQuote commLevelPo : levelSpecQuotes) {
                avaiSupply += ConverterUtil.div(ConverterUtil.mul(commLevelPo.getAvaiSupplyCount(), commLevelPo.getSpec()), 1000, 4);
            }
            commPubInfo.setAvaiSupplyCount(avaiSupply);
            commPubInfoMapper.updateByPrimaryKeySelective(commPubInfo);
        }
        return result;
    }

    /**
     * 获取品类Id列表
     *
     * @param commMageId
     * @return
     */
    public static List<Long> getCommMageIds(Long commMageId) {
        //查询品类列表
        List<CommMageTreeVo> commMages = commMageMapper.findList(new CommMageTreePo());
        Map<Long, CommMageTreeVo> commMageMap = commMages.stream().collect(Collectors.toMap(CommMageTreeVo::getId, Function.identity()));
        List<String> mageNames = Lists.newArrayList();
        List<String> mageids = Lists.newArrayList();
        diGuiCommMageName(commMageMap, commMageId, mageNames, mageids);
        return mageids.stream().map(e -> {
            return Long.valueOf(e);
        }).collect(Collectors.toList());
    }


    public static List<String> diGuiCommMageName(Map<Long, CommMageTreeVo> commMageMap, Long commMageId, List<String> mageNames, List<String> mageids) {
        CommMageTreeVo commMage = commMageMap.get(commMageId);
        if (ConverterUtil.isNotEmpty(commMage)) {
            mageNames.add(commMage.getCommCatgName());
            mageids.add(commMage.getId().toString());
            diGuiCommMageName(commMageMap, commMage.getPid(), mageNames, mageids);
        }
        return mageNames;
    }

    public static String listToString(List<String> list, String str) {
        StringBuffer sb = new StringBuffer();
        list.forEach(e -> {
            sb.append(e);
            sb.append(str);
        });
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - str.length());
        } else {
            return sb.toString();
        }
    }

    public static String listIdToString(List<String> mageids, String str) {
        StringBuffer sb = new StringBuffer();
        mageids.forEach(e -> {
            sb.append(e);
            sb.append(str);
        });
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - str.length());
        } else {
            return sb.toString();
        }
    }

    /**
     * /// 判断所有实现Collection是否为空
     *
     * @param list
     * @return
     */
    public static boolean isEmpty(Collection<?> list) {

        return list == null || list.size() == 0;
    }

    /**
     * 判断值传入的方式
     *
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Long ChangeToLong(Object obj) {
        // 返回参数
        if (obj instanceof Long) {
            return ConverterUtil.toLong(obj);
        } else if (obj instanceof Integer) {
            return ConverterUtil.toLong(obj);
        } else if (obj instanceof String) {
            return ConverterUtil.toLong(obj);
        } else {
            LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
            return ConverterUtil.toLong(map.get("id"));
        }
    }
}
