package com.wisea.equipment.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * 精讯畅通工具类
 * @author chengq
 * @date 2020/11/13 15:37
 */
public class JxiotcityUtil {

    public static JedisDao jedisDao = SpringBootContext.getBean(JedisDao.class);

    /**
     * 上传时间间隔
     */
    private final static long INTERVAL_MINUTES = 0;

    /**
     * 数据相乘
     * @param multiplicand 被乘数
     * @param multiplier 乘数
     */
    public static double multiply(long multiplicand, double multiplier) {
        return BigDecimal.valueOf(multiplicand).multiply(BigDecimal.valueOf(multiplier)).doubleValue();
    }

    /**
     * 检查上传时间间隔
     * @param equInfoId 设备id
     * @param checkDate 当前检查时间
     * @param type 设备类型
     */
    @SuppressWarnings("unchecked")
    public static Boolean checkDataPoint(Long equInfoId, OffsetDateTime checkDate, String type){
        Map<Long, OffsetDateTime> lastDatapointMap = jedisDao.getSerialize(EquipmentUtil.getSerializeKey(type), Map.class);
        if (ConverterUtil.isEmpty(lastDatapointMap) || !lastDatapointMap.containsKey(equInfoId)){
            return true;
        }else{
            OffsetDateTime maxCreateDate = lastDatapointMap.get(equInfoId);
            return checkDate.isAfter(maxCreateDate.plusMinutes(INTERVAL_MINUTES));
        }
    }

    /**
     * 16进制字符串转成byte
     * @param hex 16进制字符串
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] chars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(chars[pos]) << 4 | toByte(chars[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }


    /**
     * CRC16 循环冗余校验算法。
     */
    public static String crc16Checkout(byte[] bytes) {
        int i,  j,crcReg,check;
        crcReg = 0xFFFF;
        for (i = 0; i < bytes.length; i++) {
            crcReg = (crcReg >> 8) ^ bytes[i];
            for (j = 0; j < 8; j++) {
                check = crcReg & 0x0001;
                crcReg >>= 1;
                if (check == 0x0001) {
                    crcReg ^= 0xA001;
                }
            }
        }
        return Integer.toHexString(crcReg).toUpperCase();
    }

    /**
     * 字符串转换为16进制字符串
     */
    public static String stringToHexString(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str.append(s4);
        }
        return str.toString();
    }


    public static void main(String[] args) {
        String order = "192.168.1.1:8080";
        System.out.println(stringToHexString(order));
    }


}
