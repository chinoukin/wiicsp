package com.wisea.cultivar.bigdata.utils;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.bigdata.JyOrdMageMapper;
import com.wisea.cultivar.common.dao.bigdata.JydzMageMapper;
import com.wisea.cultivar.common.po.bigdata.JydzMageListPo;
import com.wisea.cultivar.common.vo.bigdata.JydzMageListVo;
import com.wisea.cultivar.common.vo.bigdata.TotalOrderSalesVo;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className CacheUtil
 * @date 2019/12/9 14:58
 * @Description 缓存操作工具类
 */
public class CacheUtil {

    //交易订单
    private static JyOrdMageMapper jyOrdMageMapper = SpringBootContext.getBean(JyOrdMageMapper.class);
    //交易递增管理
    private static JydzMageMapper jydzMageMapper = SpringBootContext.getBean(JydzMageMapper.class);
    //JedisDao
    private static JedisDao jedisDao = SpringBootContext.getBean(JedisDao.class);

    /** 国内交易递增-已递增金额 */
    public final static String DOMESTIC_TRANSACTIONS_INCREASING_TOTAL = "DOMESTIC_TRANSACTIONS_INCREASING_TOTAL";
    /** 国外交易递增-已递增金额 */
    public final static String FOREIGN_TRANSACTIONS_INCREASING_TOTAL = "FOREIGN_TRANSACTIONS_INCREASING_TOTAL";

    /** 国 内/外 订单销售总额 */
    public final static String DOMESTIC_FOREIGN_TOTAL_ORDER_SALES = "DOMESTIC_FOREIGN_TOTAL_ORDER_SALES";


    /**
     * @Author jirg
     * @Date 2019/12/9 15:44
     * @Description 获取国内/外订单销售总额
     **/
    public static TotalOrderSalesVo getTotalOrderSales(String year){
        Map<String, TotalOrderSalesVo> totalOrderSalesMap = jedisDao.getSerialize(DOMESTIC_FOREIGN_TOTAL_ORDER_SALES, Map.class);
        if(ConverterUtil.isEmpty(totalOrderSalesMap)){
            cacheTotalOrderSales();
            totalOrderSalesMap = jedisDao.getSerialize(DOMESTIC_FOREIGN_TOTAL_ORDER_SALES, Map.class);
            return totalOrderSalesMap.get(year);
        }else{
            return totalOrderSalesMap.get(year);
        }
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 15:44
     * @Description 获取国外订单销售总额
     **/
    /*public static Double getForeignTotalOrderSales(){
        Double foreignTotalOrderSales = jedisDao.getSerialize(FOREIGN_TOTAL_ORDER_SALES, Double.class);
        if(ConverterUtil.isEmpty(foreignTotalOrderSales)){
            cacheTotalOrderSales();
            return jedisDao.getSerialize(FOREIGN_TOTAL_ORDER_SALES, Double.class);
        }else{
            return foreignTotalOrderSales;
        }
    }*/

    /**
     * @Author jirg
     * @Date 2019/12/9 16:16
     * @Description 清除国内外订单交易总额缓存
     **/
    public static void clearTotalOrderSalesCache(){
        jedisDao.delSerialize(DOMESTIC_FOREIGN_TOTAL_ORDER_SALES);
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 15:27
     * @Description 获取国内交易已递增金额
     **/
    public static Double getDomesticTransactionsIncreasingTotal(){
        Double domesticTransactionsIncreasingTotal = jedisDao.getSerialize(DOMESTIC_TRANSACTIONS_INCREASING_TOTAL, Double.class);
        if(ConverterUtil.isEmpty(domesticTransactionsIncreasingTotal)){
            cacheYdiJe();
            return jedisDao.getSerialize(DOMESTIC_TRANSACTIONS_INCREASING_TOTAL, Double.class);
        }else{
            return domesticTransactionsIncreasingTotal;
        }
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 15:38
     * @Description 获取国外交易已递增金额
     **/
    public static Double getForeignTransactionsIncreasingTotal(){
        Double foreignTransactionsIncreasingTotal = jedisDao.getSerialize(FOREIGN_TRANSACTIONS_INCREASING_TOTAL, Double.class);
        if(ConverterUtil.isEmpty(foreignTransactionsIncreasingTotal)){
            cacheYdiJe();
            return jedisDao.getSerialize(FOREIGN_TRANSACTIONS_INCREASING_TOTAL, Double.class);
        }else{
            return foreignTransactionsIncreasingTotal;
        }
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 16:18
     * @Description 清除国内外已递增交易金额缓存
     **/
    public static void clearYdiJe(){
        jedisDao.delSerialize(DOMESTIC_TRANSACTIONS_INCREASING_TOTAL);
        jedisDao.delSerialize(FOREIGN_TRANSACTIONS_INCREASING_TOTAL);
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 15:32
     * @Description 缓存国内外已递增交易金额
     **/
    private static void cacheYdiJe(){
        List<JydzMageListVo> list = jydzMageMapper.findList(new JydzMageListPo());
        if(ConverterUtil.isNotEmpty(list) && list.size() > 0){
            JydzMageListVo vo = list.get(0);
            jedisDao.setSerialize(DOMESTIC_TRANSACTIONS_INCREASING_TOTAL, vo.getYdiJe());
            jedisDao.setSerialize(FOREIGN_TRANSACTIONS_INCREASING_TOTAL, vo.getGwYdiJe());
        }
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 16:06
     * @Description 缓存国内外订单交易总额 - 按年份
     **/
    private static void cacheTotalOrderSales() {
        List<TotalOrderSalesVo> vo = jyOrdMageMapper.getTotalOrderSales();
        Map<String, TotalOrderSalesVo> voMap = Maps.newHashMap();
        if(ConverterUtil.isNotEmpty(vo)){
            voMap = vo.stream().collect(Collectors.toMap(TotalOrderSalesVo::getYear, Function.identity()));
        }
        jedisDao.setSerialize(DOMESTIC_FOREIGN_TOTAL_ORDER_SALES, voMap);
    }
}
