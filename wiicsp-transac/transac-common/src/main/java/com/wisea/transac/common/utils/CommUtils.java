package com.wisea.transac.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.dao.CommMageMapper;
import com.wisea.transac.common.entity.CommMage;
import com.wisea.transac.common.po.product.CommMageTreePo;
import com.wisea.transac.common.vo.product.CommMageTreeVo;

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

    public static List<Long> getCommMageNamesId(Long commMageId){
        //查询商品列表
        List<CommMage> commMages = commMageMapper.findListMage(new CommMage());
        Map<Long, CommMage> commMageMap = Maps.newHashMap();
        commMages.forEach(e -> {
            commMageMap.put(e.getId(), e);
        });
        List<Long> mageNames = Lists.newArrayList();
        List<Long> list = diGuiCommMageName(commMageMap, commMageId, mageNames);
        Collections.reverse(mageNames);
        list.add(commMageId);
        return list;
        // listToString(mageNames, ",")
    }

    public static List<Long> diGuiCommMageName(Map<Long, CommMage> commMageMap, Long commMageId, List<Long> mageNames){
        CommMage commMage = commMageMap.get(commMageId);
        if(ConverterUtil.isNotEmpty(commMage)){
            mageNames.add(commMage.getPid());
            diGuiCommMageName(commMageMap, commMage.getPid(), mageNames);
        }
        return mageNames;
    }

}
