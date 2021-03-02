package com.wisea.transac.common.utils;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.redisson.RedissLockUtil;
import com.wisea.transac.common.constants.RedisKeyConstants;

/**
 * 订单和产品编号工具类
 *
 * @author yangtao
 */
public class CodeUtils {

    private final static int LINE_SIZE_8 = 8;
    private final static int LINE_SIZE_12 = 12;
    private final static int ZT_NUM_SIZE = 10;
    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);


    /**
     * 生成发布商品编号，默认由Redis判重
     * 8位随机数
     *
     * @return
     */
    public static String generateCommPubInfoCode() {
        return generateRandomCode(true, LINE_SIZE_8, RedisKeyConstants.COMM_PUB_INFO_LOCK, RedisKeyConstants.COMM_PUB_INFO_FIX);
    }

    /**
     * 生成订单编号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateOrderCode() {
        return generateRandomCode(true, LINE_SIZE_12, RedisKeyConstants.ORDER_CODE_LOCK, RedisKeyConstants.ORDER_CODE_FIX);
    }

    /**
     * 生成退款申请编号
     * 8位随机数
     * @return
     */
    public static String generateRefundNum() {
        return generateRandomCode(true, LINE_SIZE_8, RedisKeyConstants.REFUND_CODE_LOCK, RedisKeyConstants.REFUND_CODE_FIX);
    }

    /**
     * 生成自提码，默认由Redis判重
     * 10位随机数
     *
     * @return
     */
    public static String generateZtNum() {
        return generateRandomCode(true, ZT_NUM_SIZE, RedisKeyConstants.ZT_NUM_LIST_FIX, RedisKeyConstants.ZT_NUM_LOCK);
    }

    /**
     * 生成申请开票申请单号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateInvoApplCode() {
        return generateRandomCode(true, LINE_SIZE_12, RedisKeyConstants.ORDER_INVO_APPL_LOCK, RedisKeyConstants.ORDER_INVO_APPL_FIX);
    }

    /**
     * 生成结算单编号，默认由Redis判重
     *
     * @return
     */
    public static String generateSettleBillCode() {
        return generateRandomCode(true, LINE_SIZE_12, RedisKeyConstants.SETTLE_BILL_CODE_LOCK, RedisKeyConstants.SETTLE_BILL_CODE_FIX);
    }

    /**
     * 生成结算单发票申请编号，默认由Redis判重
     *
     * @return
     */
    public static String generateSettleInvoCode() {
        return generateRandomCode(true, LINE_SIZE_12, RedisKeyConstants.SETTLE_ORDER_INVO_APPL_LOCK, RedisKeyConstants.SETTLE_ORDER_INVO_APPL_FIX);
    }


    /**
     * 生成随机数字编号
     *
     * @param needCheck 是否需要redis判重
     * @param size      随机码位数
     * @return
     */
    public static String generateRandomCode(boolean needCheck, int size, String lockKey, String fix) {
        try {
            RedissLockUtil.lock(lockKey);
            //生成指定位随机数字串，由redis判重
            String key = RandomStringUtils.randomNumeric(size);
            //key值格式为XXX(前缀):xxx(生成随机数的前三位):xxxxxxxx(生成的随机数)
            String redisSearchKey = fix.concat(":").concat(key.substring(0, 3)).concat("*");
            String redisKey = fix.concat(":").concat(key.substring(0, 3)).concat(":").concat(key);
            if (needCheck) {
                //判断前缀：随机数：存在不存在，不存在则从数据库读取，防止缓存清空
                if (jedisdao.exists(redisSearchKey)) {
                    if (!jedisdao.exists(redisKey)) {
                        jedisdao.setStr(redisKey, key);
                        return key;
                    }
                } else {
                    List<String> list = Lists.newArrayList();
                    switch (lockKey) {
                        //查询编码前三位的编号
                        case RedisKeyConstants.COMM_PUB_INFO_LOCK:
                            list = FindMaxNumUtils.findCommPubInfoMaxNum(key.substring(0, 3));
                            break;
                        //查询编码前三位的编号
                        case RedisKeyConstants.REFUND_CODE_LOCK:
                            list = FindMaxNumUtils.findRefundMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.ORDER_CODE_LOCK:
                            list = FindMaxNumUtils.findOrderMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.ORDER_INVO_APPL_LOCK:
                            list = FindMaxNumUtils.findInvoApplMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.SETTLE_BILL_CODE_LOCK:
                            list = FindMaxNumUtils.findSettleBillNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.SETTLE_ORDER_INVO_APPL_LOCK:
                            list = FindMaxNumUtils.findSettleInvoApplMaxNum(key.substring(0, 3));
                            break;
                          //查询编码前三位的编号
                        case RedisKeyConstants.ZT_NUM_LOCK:
                            list = FindMaxNumUtils.findOrdZtNum(key.substring(0, 3));
                            break;
                    }
                    int count = 0;
                    //插入redis缓存
                    for (String num : list) {
                        String myKey = fix.concat(":").concat(num.substring(0, 3)).concat(":").concat(num);
                        jedisdao.setStr(myKey, num);
                        if (key.equals(num)) {
                            count++;
                        }
                    }
                    //判断是否重复（防止初始化程序一直执行）
                    if (count > 0) {
                        return generateRandomCode(needCheck, size, lockKey, fix);
                    } else {
                        jedisdao.setStr(redisKey, key);
                        return key;
                    }
                }
                return generateRandomCode(needCheck, size, lockKey, fix);
            } else {
                return key;
            }
        } finally {
            //手动释放锁
            RedissLockUtil.unlock(lockKey);
        }
    }

}
