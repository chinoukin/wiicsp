package com.wisea.cultivar.common.utils.tp;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.redisson.RedissLockUtil;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cultivar.common.constants.tp.RedisKeyConstants;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 订单和产品编号工具类
 *
 * @author yangtao
 */
public class CodeUtils {

    private final static int REFUND_LTA_CODE_SIZE = 14;
    private final static int REFUND_CODE_SIZE = 12;
    private final static int SETTLE_BILL_NUM_SIZE = 10;
    private final static int COMM_PUB_INFO_SIZE = 8;
    private final static int LTA_COMM_PUB_INFO_SIZE = 12;
    private static JedisDao jedisdao = SpringBootContext.getBean(JedisDao.class);


    /**
     * 生成发布商品编号，默认由Redis判重
     * 8位随机数
     *
     * @return
     */
    public static String generateCommPubInfoCode() {
        return generateRandomCode(true, COMM_PUB_INFO_SIZE, RedisKeyConstants.COMM_PUB_INFO_LOCK, RedisKeyConstants.COMM_PUB_INFO_FIX);
    }

    /**
     * 生成长协发布商品编号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateLtaCommPubInfoCode() {
        return generateRandomCode(true, LTA_COMM_PUB_INFO_SIZE, RedisKeyConstants.LTA_COMM_PUB_INFO_LOCK, RedisKeyConstants.LTA_COMM_PUB_INFO_FIX);
    }

    /**
     * 生成结算单编号，默认由Redis判重
     * 10位随机数
     *
     * @return
     */
    public static String generateSettleBillCode() {
        return generateRandomCode(true, SETTLE_BILL_NUM_SIZE, RedisKeyConstants.SETTLE_BILL_CODE_LOCK, RedisKeyConstants.SETTLE_BILL_CODE_FIX);
    }

    /**
     * 生成退货、退款编号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateRefundCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.REFUND_CODE_LOCK, RedisKeyConstants.REFUND_CODE_FIX);
    }

    /**
     * 生成长协退货、退款编号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateLtaRefundCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.REFUND_CODE_LOCK, RedisKeyConstants.REFUND_CODE_FIX);
    }

    /**
     * 生成订单编号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateOrderCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.ORDER_CODE_LOCK, RedisKeyConstants.ORDER_CODE_FIX);
    }

    /**
     * 生成长协订单编号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateLtaOrderCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.LTA_ORDER_CODE_LOCK, RedisKeyConstants.LTA_ORDER_CODE_FIX);
    }

    /**
     * 生成申请开票申请单号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateInvoApplCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.ORDER_INVO_APPL_LOCK, RedisKeyConstants.ORDER_INVO_APPL_FIX);
    }

    /**
     * 长协生成申请开票申请单号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateLtaInvoApplCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.LTA_ORDER_INVO_APPL_LOCK, RedisKeyConstants.LTA_ORDER_INVO_APPL_FIX);
    }

    /**
     * 生成账期结算单申请开票申请单号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateSettleInvoApplCode() {
        return generateRandomCode(true, REFUND_CODE_SIZE, RedisKeyConstants.SETTLE_ORDER_INVO_APPL_FIX, RedisKeyConstants.SETTLE_ORDER_INVO_APPL_FIX);
    }

    /**
     * 长协合同编号
     * 14位随机数
     *
     * @author wangh(wisea)
     * @date 2019年5月7日
     * @version 1.0
     */
    public static String generateLtaContNumbCode() {
        return generateRandomCode(true, REFUND_LTA_CODE_SIZE, RedisKeyConstants.LTA_CONT_NUM_LOCK, RedisKeyConstants.LTA_CONT_NUM_CODE);
    }

    /**
     * 生成账期结算单申请开票申请单号，默认由Redis判重
     * 12位随机数
     *
     * @return
     */
    public static String generateZtNum() {
        return generateRandomCode(true, SETTLE_BILL_NUM_SIZE, RedisKeyConstants.ZT_NUM_LIST_FIX, RedisKeyConstants.ZT_NUM_LOCK);
    }

    /**
     * 获取追溯批次编号
     * @return yyMMdd + 5位自增数
     */
    public static String generateTraceBatchNumCode() {
        return generateAutoincrementCode(RedisKeyConstants.TRACE_BATCH_CACHE_KEY, RedisKeyConstants.TRACE_BATCH_LOCK, OffsetDateTimeUtils.formatDateTime(OffsetDateTime.now(), "yyMMdd"), 5);
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
                        case RedisKeyConstants.REFUND_CODE_LOCK:
                            list = FindMaxNumUtils.findRefundMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.LTA_REFUND_CODE_LOCK:
                            list = FindMaxNumUtils.findLtaRefundMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.ORDER_CODE_LOCK:
                            list = FindMaxNumUtils.findOrderMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.LTA_ORDER_CODE_LOCK:
                            list = FindMaxNumUtils.findLtaOrderMaxNum(key.substring(0, 3));
                            break;
                        //查询编码前三位的编号
                        case RedisKeyConstants.SETTLE_BILL_CODE_LOCK:
                            list = FindMaxNumUtils.findSettleBillMaxNum(key.substring(0, 3));
                            break;
                        //查询编码前三位的编号
                        case RedisKeyConstants.COMM_PUB_INFO_LOCK:
                            list = FindMaxNumUtils.findCommPubInfoMaxNum(key.substring(0, 3));
                            break;
                        //查询编码前三位的编号
                        case RedisKeyConstants.ORDER_INVO_APPL_LOCK:
                            list = FindMaxNumUtils.findInvoApplMaxNum(key.substring(0, 3));
                            break;
                        case RedisKeyConstants.LTA_ORDER_INVO_APPL_LOCK:
                            list = FindMaxNumUtils.findLtaInvoApplMaxNum(key.substring(0, 3));
                            break;
                        //查询编码前三位的编号
                        case RedisKeyConstants.SETTLE_ORDER_INVO_APPL_LOCK:
                            list = FindMaxNumUtils.findInvoApplMaxNum(key.substring(0, 3));
                            break;
                        // 查询长协商品编码前三位的编号
                        case RedisKeyConstants.LTA_COMM_PUB_INFO_LOCK:
                            list = FindMaxNumUtils.findLtaCommRelaMaxNum(key.substring(0, 3));
                            break;
                        //查询编码前三位的编号
                        case RedisKeyConstants.ZT_NUM_LOCK:
                            list = FindMaxNumUtils.findOrdZtNum(key.substring(0, 3));
                            break;
                        //查询长协合同编码前三位的编号
                        case RedisKeyConstants.LTA_CONT_NUM_LOCK:
                            list = FindMaxNumUtils.findLtaContNum(key.substring(0, 3));
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

    /**
     * @Author jirg
     * @Date 2019/12/18 16:27
     * @Description 生成自增编号（前端补零）
     * @param   cacheKey    缓存Key
     * @param   lockKey 分布式锁Key
     * @param   prefix  编号前缀
     * @param   digit   自增位数 - 不足时前端补零
     * @return
     **/
    public static String generateAutoincrementCode(String cacheKey, String lockKey, String prefix, Integer digit) {
        //判断缓存中是否有相应的key
        if (!jedisdao.exists(cacheKey)) {
            try {
                //缓存中不存在key, 获取锁
                RedissLockUtil.lock(lockKey);
                //二次判断缓存中是否有相应的key
                if (!jedisdao.exists(cacheKey)) {
                    List<String> list = Lists.newArrayList();
                    switch (cacheKey) {
                        case RedisKeyConstants.TRACE_BATCH_CACHE_KEY:
                            list = FindMaxNumUtils.findTraceBatchNumCode(prefix);
                            break;
                    }
                    Integer maxNum = null;
                    if(ConverterUtil.isNotEmpty(list) && list.size() > 0){
                        String maxNumCode = list.get(0);
                        maxNum = Integer.parseInt(maxNumCode.substring(maxNumCode.length() - digit));
                    }
                    //判断查询结果
                    if (ConverterUtil.isNotEmpty(maxNum) && maxNum > 0) {
                        jedisdao.setStrExpire(cacheKey, maxNum.toString(), OffsetDateTimeUtils.getExpiration());
                    }
                    return getNumber(cacheKey, prefix, digit);
                }
                return getNumber(cacheKey, prefix, digit);
            } finally {
                //手动释放锁
                RedissLockUtil.unlock(lockKey);
            }
        }
        return getNumber(cacheKey, prefix, digit);
    }

    /**
     * 获取编号，默认五位自增
     * @param key  缓存key
     * @param prefix  编号前缀
     * @return
     */
    public static String getNumber(String key, String prefix, Integer digit) {
        Long index = jedisdao.incr(key);
        //设置key过期时间
        jedisdao.setExpire(key, OffsetDateTimeUtils.getExpiration());
        return prefix.concat(String.format("%0"+ digit +"d", index));
    }
}
