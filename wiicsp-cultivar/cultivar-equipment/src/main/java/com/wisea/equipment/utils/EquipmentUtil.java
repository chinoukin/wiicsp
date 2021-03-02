package com.wisea.equipment.utils;

import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.equipment.config.XaircraftConfig;
import com.wisea.equipment.constants.DictConstants;
import com.wisea.equipment.dao.EquMeteorologyMapper;
import org.apache.commons.codec.digest.HmacUtils;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * @author jirg
 * @version 1.0
 * @className XaircraftUtils
 * @date 2019/2/22 13:54
 * @Description
 */
public class EquipmentUtil {

    public static JedisDao jedisDao = SpringBootContext.getBean(JedisDao.class);
    public static EquMeteorologyMapper dataPointMapper = SpringBootContext.getBean(EquMeteorologyMapper.class);

    public static String METEOROLOGY_LAST_DATAPOINT_CACHE_KEY = "METEOROLOGY_LAST_DATAPOINT_";

    /**
     * @Author jirg
     * @Date 2019/2/25 16:09
     * @Description 校验设备数据点时间和最大值相同
     **/
    public static Boolean checkDataPoint(Long equInfoId, OffsetDateTime checkDate, String type){
        Map<Long, OffsetDateTime> lastDatapointMap = jedisDao.getSerialize(getSerializeKey(type), Map.class);
        if (ConverterUtil.isEmpty(lastDatapointMap) || !lastDatapointMap.containsKey(equInfoId)){
            OffsetDateTime maxCreateDate = dataPointMapper.selectMaxDateByEquId(equInfoId, type);
            if(ConverterUtil.isNotEmpty(maxCreateDate)){
                return checkDate.isAfter(maxCreateDate);
            }else{
                return true;
            }
        }else{
            OffsetDateTime maxCreateDate = lastDatapointMap.get(equInfoId);
            return checkDate.isAfter(maxCreateDate);
        }
    }

    /**
     * @Author jirg
     * @Date 2019/2/25 16:09
     * @Description 缓存最新数据点时间
     **/
    public static void cacheDataPointMaxDate(Long equInfoId, OffsetDateTime checkDate, String type){
        Map<Long, OffsetDateTime> lastDatapointMap = jedisDao.getSerialize(getSerializeKey(type), Map.class);
        if(ConverterUtil.isEmpty(lastDatapointMap)){
            lastDatapointMap = Maps.newHashMap();
        }
        lastDatapointMap.put(equInfoId, checkDate);
        jedisDao.setSerialize(getSerializeKey(type), lastDatapointMap);
    }

    /**
     * @author jirg
     * @date 2020/7/8 11:36
     * @Description 获取缓存Key
     */
    public static String getSerializeKey(String type){
        if(ConverterUtil.isNotEmpty(type)){
            return METEOROLOGY_LAST_DATAPOINT_CACHE_KEY.concat(type);
        }
        return null;
    }

    /**
     * @author jirg
     * @date 2020/7/8 13:25
     * @Description 获取数据点类型
     */
    public static String getEquDateType(Integer type){
        if(type == 1){
            return DictConstants.EQU_DATE_TYPE_1;
        }else if(type == 2){
            return DictConstants.EQU_DATE_TYPE_2;
        }else if(type == 3){
            return DictConstants.EQU_DATE_TYPE_3;
        }else if(type == 14){
            return DictConstants.EQU_DATE_TYPE_14;
        }else if(type == 15){
            return DictConstants.EQU_DATE_TYPE_15;
        }else if(type == 30){
            return DictConstants.EQU_DATE_TYPE_30;
        }
        return null;
    }

    /**
     * @author jirg
     * @date 2020/7/8 13:41
     * @Description 校验是否是json格式
     */
    public static boolean validateJson(String jsonStr) {
        JsonElement jsonElement;
        try {
            jsonElement = new JsonParser().parse(jsonStr);
        } catch (Exception e) {
            return false;
        }
        if (jsonElement == null) {
            return false;
        }
        if (!jsonElement.isJsonObject()) {
            return false;
        }
        return true;
    }

    /**
     * @author jirg
     * @date 2020/12/01 16:25
     * @Description 风向转换
     */
    public static String windDirection(Double direction){
        if(ConverterUtil.isEmpty(direction)){
            return null;
        }
        Double d = ConverterUtil.div(direction, 22.5, 0);
        int i = d.intValue();
        String[] arr = new String[]{"N","NNE","NE","ENE","E","ESE", "SE", "SSE","S","SSW","SW","WSW","W","WNW","NW","NNW"};
        return arr[(i % 16)];
    }
}
