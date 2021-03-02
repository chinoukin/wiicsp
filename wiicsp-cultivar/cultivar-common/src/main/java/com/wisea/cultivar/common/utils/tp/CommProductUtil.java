package com.wisea.cultivar.common.utils.tp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cultivar.common.dao.tp.CommMageMapper;
import com.wisea.cultivar.common.entity.tp.CommMage;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 获取三级品类id
 */
public class CommProductUtil {
    @Autowired
    private static CommMageMapper commMageMapper = SpringBootContext.getBean(CommMageMapper.class);

    public static List<Long> getCommMageNames(Long commMageId){
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

    public static String listToString(List<Long> list, String str){
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
}
