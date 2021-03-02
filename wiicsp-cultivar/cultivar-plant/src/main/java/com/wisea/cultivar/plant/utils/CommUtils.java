package com.wisea.cultivar.plant.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.CommMageMapper;
import com.wisea.cultivar.common.entity.CommMage;

import java.util.*;

/**
 * @Description: 判断工具类
 * @author: wangs
 * @date :2017/12/26
 */
public class CommUtils {

    private static CommMageMapper commMageMapper = SpringBootContext.getBean(CommMageMapper.class);

    /**
     * 获取商品名称
     * @param commMageId
     * @return
     */
    public static String getCommMageNames(Long commMageId){
        //查询品类列表
        List<CommMage> commMages = commMageMapper.findList(new CommMage());
        Map<Long, CommMage> commMageMap = Maps.newHashMap();
        commMages.forEach(e -> {
            commMageMap.put(e.getId(), e);
        });
        List<String> mageNames = Lists.newArrayList();
        diGuiCommMageName(commMageMap, commMageId, mageNames);
        Collections.reverse(mageNames);
        return listToString(mageNames, " ");
    }

    public static List<String> diGuiCommMageName(Map<Long, CommMage> commMageMap, Long commMageId, List<String> mageNames){
        CommMage commMage = commMageMap.get(commMageId);
        if(ConverterUtil.isNotEmpty(commMage)){
            mageNames.add(commMage.getCommCatgName());
            diGuiCommMageName(commMageMap, commMage.getPid(), mageNames);
        }
        return mageNames;
    }

    public static String listToString(List<String> list, String str){
        StringBuffer sb = new StringBuffer();
        list.forEach(e -> {
            sb.append(e);
            sb.append(str);
        });
        if(sb.length() > 0){
            return sb.substring(0, sb.length() - str.length());
        }else{
            return sb.toString();
        }
    }

    /**
     * /// 判断所有实现Collection是否为空
     * @param list
     * @return
     */
    public static boolean isEmpty (Collection<?> list) {

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
