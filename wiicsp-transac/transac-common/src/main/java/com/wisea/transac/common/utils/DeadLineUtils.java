package com.wisea.transac.common.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.dao.DeadLineMageMapper;
import com.wisea.transac.common.entity.DeadLineMage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className DeadLineUtils
 * @date 2020/4/30 15:44
 * @Description 期限设置工具类
 */
public class DeadLineUtils {
    private static DeadLineMageMapper deadLineMageMapper = SpringBootContext.getBean(DeadLineMageMapper.class);
    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);
    private static String DEAD_LINE_CACHE_KEY = "DEAD_LINE";
    /**
     * @Author jirg
     * @Date 2020/4/30 15:45
     * @Description 获取所有期限设置
     **/
    public static List<DeadLineMage> getAllDeadLine(){
        List<DeadLineMage> deadLines = jedisdao.getSerialize(DEAD_LINE_CACHE_KEY, List.class);
        if(ConverterUtil.isEmpty(deadLines)){
            deadLines = deadLineMageMapper.findAll();
            jedisdao.setSerialize(DEAD_LINE_CACHE_KEY, deadLines);
        }
        return deadLines;
    }

    /**
     * @Author jirg
     * @Date 2020/4/30 15:59
     * @Description 根据类型查询期限值
     **/
    public static Integer getLimitDaysByType(String deadLineType){
        if (ConverterUtil.isEmpty(deadLineType)){
            return null;
        }
        List<DeadLineMage> deadLines = getAllDeadLine();
        if(ConverterUtil.isEmpty(deadLines)){
            return null;
        }
        Map<String, Integer> deadLineMap = deadLines.stream().collect(Collectors.toMap(DeadLineMage::getDeadLineType, DeadLineMage::getLimitDays));
        return deadLineMap.get(deadLineType);
    }

    /**
     * @Author jirg
     * @Date 2020/4/30 16:08
     * @Description 清除期限缓存
     **/
    public static void clearCache(){
        jedisdao.delSerialize(DEAD_LINE_CACHE_KEY);
    }
}
