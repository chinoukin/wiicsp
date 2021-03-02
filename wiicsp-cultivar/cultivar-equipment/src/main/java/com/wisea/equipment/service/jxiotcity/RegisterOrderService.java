package com.wisea.equipment.service.jxiotcity;

/**
 * 传输协议
 * @author chengq
 * @date 2020/11/24 10:51
 */
public abstract class RegisterOrderService {

    /**
     * redis key
     */
    public String JXIOTCITY_KEY = "JXIOTCITY:";

    /**
     * 执行命令
     */
    abstract void perform(String data);

    /**
     * 字节转字符
     */
    public int getLength(int length) {
        return length * 2;
    }

    /**
     * 拼接redis key
     */
    public String getRedisKey(String equId) {
        return JXIOTCITY_KEY + equId;
    }
}
