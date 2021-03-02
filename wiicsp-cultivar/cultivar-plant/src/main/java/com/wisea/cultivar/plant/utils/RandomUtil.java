package com.wisea.cultivar.plant.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
import java.util.UUID;

/**
 * Auth： itudou
 * CreateDate:  2017/12/12
 * projectName:  wtp
 * remark:  生成随机数工具类
 */
public class RandomUtil {
    public static Random random = new Random();

    /**
     * 生成一个Long类型的ID
     * @return
     */
    public static Long generateLongId(){
        return Math.abs(random.nextLong());
    }

    /**
     * 生成一个UUID
     * @return
     */
    public static String generateUUId(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取随机码
     * @param lenth
     * @return
     */
    public static String getRandomNum(byte lenth) {
        return Md5Utils.md5(String.valueOf(System.currentTimeMillis())).substring(0, lenth);
    }

    /**
     * 生成指定范围的随机数
     * @param min
     * @param max
     * @return
     */
    public static Integer getRandomNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * 返回长度为【strLength】的随机数，数字
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        Long pross = Math.abs(rm.nextLong());
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(0, strLength);
    }

    /**
     * 奇偶校验
     * @param binaryStr
     * @return true 1的个数为奇数 ，false 1的个数为偶数
     */
    public static Boolean parityCheck(String binaryStr){
        Boolean result = false;
        String[] split = binaryStr.split("");
        for (int i = 0; i < split.length; i++){
            if(split[i].equals("1")){
                result = !result;
            }
        }
        return result;
    }

    public static String getIPAddress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
