package com.wisea.cultivar.common.utils.tp;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.redisson.RedissLockUtil;
import com.wisea.cloud.common.util.ConverterUtil;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Auth： itudous
 * CreateDate:  2017/12/21
 * projectName:  wtp
 * remark:  单号生成工具类
 */
public class GenerateNumUtils {
    /******************编号前缀******************/
    private static final String LIST_FIX = "GP"; //挂牌编号前缀
    private static final String ORDER_FIX = "DD"; //订单编号前缀
    private static final String CONT_FIX = "HT"; //合同编号前缀
    private static final String CONT_TERMI_FIX = "HTJC"; //合同解除申请编号前缀
    private static final String CONT_DEL_FIX = "JSD"; //交收单编号前缀
    private static final String EXAM_COMM_DIS_FIX = "YH"; //验货异议编号前缀
    private static final String TAKE_COMM_BILL_FIX = "TD"; //提单编号前缀
    private static final String EXAM_INVO_DIS_FIX = "YP"; //验票异议编号前缀
    private static final String WTB_FIX = "QG"; //求购编号前缀

    /********************缓存key**********************/
    private static final String LIST_NUM_KEY = "LIST_NUM_KEY"; //最大挂牌编号缓存key
    private static final String ORDER_NUM_KEY = "ORDER_NUM_KEY"; //最大订单编号缓存key
    private static final String CONT_NUM_KEY = "CONT_NUM_KEY"; //最大合同编号缓存key
    private static final String CONT_TERMI_NUM_KEY = "CONT_TERMI_NUM_KEY"; //最大合同解除申请编号缓存key
    private static final String CONT_DEL_NUM_KEY = "CONT_DEL_NUM_KEY"; //最大交收单编号缓存key
    private static final String EXAM_COMM_DIS_NUM_KEY = "EXAM_COMM_DIS_NUM_KEY"; //最大验货异议编号缓存key
    private static final String TAKE_COMM_BILL_NUM_KEY = "TAKE_COMM_BILL_NUM_KEY"; //最大提单编号缓存key
    private static final String EXAM_INVO_DIS_NUM_KEY = "EXAM_INVO_DIS_NUM_KEY"; //最大验票异议编号缓存key
    private static final String WTB_NUM_KEY = "WTB_KEY"; //最大求购编号缓存key

    /************************分布式锁***********************/
    private static final String LIST_NUM_LOCK = "LIST_NUM_LOCK"; //挂牌锁key
    private static final String ORDER_NUM_LOCK = "ORDER_NUM_LOCK"; //订单锁key
    private static final String CONT_NUM_LOCK = "CONT_NUM_LOCK"; //合同锁key
    private static final String CONT_TERMI_NUM_LOCK = "CONT_TERMI_NUM_LOCK"; //合同解除申请锁key
    private static final String CONT_DEL_NUM_LOCK = "CONT_DEL_NUM_LOCK"; //交收单锁key
    private static final String EXAM_COMM_DIS_NUM_LOCK = "EXAM_COMM_DIS_NUM_LOCK"; //验货异议锁key
    private static final String TAKE_COMM_BILL_NUM_LOCK = "TAKE_COMM_BILL_NUM_LOCK"; //提单锁key
    private static final String EXAM_INVO_DIS_NUM_LOCK = "EXAM_INVO_DIS_NUM_LOCK"; //验票异议锁key
    private static final String WTB_NUM_LOCK = "WTB_NUM_LOCK"; //求购锁key

    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);

    /**
     * 生成挂牌单号
     * @return
     */
    public static String generateListNum(){
        return generateNum(LIST_NUM_KEY, LIST_NUM_LOCK, LIST_FIX);
    }

    /**
     * 生成订单编号
     *
     * @return
     */
    public static String generateOrderNum(){
        return generateNum(ORDER_NUM_KEY, ORDER_NUM_LOCK, ORDER_FIX);
    }

    /**
     * 生成合同编号
     * @return
     */
    public static String generateContNum(){
        return generateNum(CONT_NUM_KEY, CONT_NUM_LOCK, CONT_FIX);
    }

    /**
     * 生成合同解除申请编号
     * @return
     */
    public static String generateContTermiNum(){
        return generateNum(CONT_TERMI_NUM_KEY, CONT_TERMI_NUM_LOCK, CONT_TERMI_FIX);
    }

    /**
     * 生成交收单号
     * @return
     */
    public static String generateDelivNum(){
        return generateNum(CONT_DEL_NUM_KEY, CONT_DEL_NUM_LOCK, CONT_DEL_FIX);
    }

    /**
     * 生成验货异议单号
     * @return
     */
    public static String generateECommDisNum(){
        return generateNum(EXAM_COMM_DIS_NUM_KEY, EXAM_COMM_DIS_NUM_LOCK, EXAM_COMM_DIS_FIX);
    }

    /**
     * 生成提单编号
     * @return
     */
    public static String generateTakeCommBillNum(){
        return generateNum(TAKE_COMM_BILL_NUM_KEY, TAKE_COMM_BILL_NUM_LOCK, TAKE_COMM_BILL_FIX);
    }

    /**
     * 生成验票异议单号
     * @return
     */
    public static String generateEInvoDisNum(){
        return generateNum(EXAM_INVO_DIS_NUM_KEY, EXAM_INVO_DIS_NUM_LOCK, EXAM_INVO_DIS_FIX);
    }

    /**
     * 生成求购单号
     * @return
     */
    public static String generateWTBNum(){
        return generateNum(WTB_NUM_KEY, WTB_NUM_LOCK, WTB_FIX);
    }

    /**
     * 生成单号
     * @param cacheKey 缓存key
     * @param lockKey 锁key
     * @param fix 单号前缀
     * @return
     */
    public static String generateNum(String cacheKey, String lockKey, String fix){
        //判断缓存中是否有相应的key
        if(!jedisdao.exists(cacheKey)){
            try {
                //缓存中不存在key, 获取锁
                RedissLockUtil.lock(lockKey);
                //二次判断缓存中是否有相应的key
                if(!jedisdao.exists(cacheKey)){
                    Integer maxNum = null;
                    switch (cacheKey){
                        /*case LIST_NUM_KEY:
                            //获取挂牌最大编号
                            maxNum = FindMaxNumUtils.findListMaxNum(fix.concat(getYmd()));
                            break;
                        case ORDER_NUM_KEY:
                            //获取订单最大编号
                            maxNum = FindMaxNumUtils.findOrderMaxNum(fix.concat(getYmd()));
                            break;
                        case CONT_NUM_KEY:
                            //获取合同最大编号
                            maxNum = FindMaxNumUtils.findContMaxNum(fix.concat(getYmd()));
                            break;
                        case CONT_TERMI_NUM_KEY:
                            //获取合同解除申请最大编号
                            maxNum = FindMaxNumUtils.findContTermiMaxNum(fix.concat(getYmd()));
                            break;
                        case CONT_DEL_NUM_KEY:
                            //获取交收单最大编号
                            maxNum = FindMaxNumUtils.findDelivMaxNum(fix.concat(getYmd()));
                            break;
                        case EXAM_COMM_DIS_NUM_KEY:
                            //获取验货异议最大编号
                            maxNum = FindMaxNumUtils.findECommDisMaxNum(fix.concat(getYmd()));
                            break;
                        case TAKE_COMM_BILL_NUM_KEY:
                            //获取提单最大编号
                            maxNum = FindMaxNumUtils.findTakeCommBillMaxNum(fix.concat(getYmd()));
                            break;
                        case EXAM_INVO_DIS_NUM_KEY:
                            //获取验票异议最大编号
                            maxNum = FindMaxNumUtils.findEInvoDisMaxNum(fix.concat(getYmd()));
                            break;
                        case WTB_NUM_KEY:
                            //获取求购最大编号
                            maxNum = FindMaxNumUtils.findWTBMaxNum(fix.concat(getYmd()));
                            break;*/
                    }
                    // 判断查询结果
                    if (ConverterUtil.isNotEmpty(maxNum) && maxNum > 0) {
                        jedisdao.setStrExpire(cacheKey, maxNum.toString(), OffsetDateTimeUtils.getExpiration());
                    }
                    return CommGenerateNumUtils.getNumber(cacheKey, fix, getYmd());
                }
                return CommGenerateNumUtils.getNumber(cacheKey, fix, getYmd());
            } finally {
                //手动释放锁
                RedissLockUtil.unlock(lockKey);
            }
        }
        return CommGenerateNumUtils.getNumber(cacheKey, fix, getYmd());
    }

    public static String getYmd(){
        OffsetDateTime nowDate = OffsetDateTime.now();
        return nowDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

}
