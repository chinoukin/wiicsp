package com.wisea.cultivar.bigdata.utils;

import com.wisea.cloud.common.util.ConverterUtil;

import java.util.LinkedList;
import java.util.List;

/**
 * 上下浮动随机数生成（类似微信随机红包）
 * @author yangtao
 *
 */
public class RedPacketUtil {

    /**
     * 小于最小值
     */
    private static final int LESS = -1;
    /**
     * 大于最大值
     */
    private static final int MORE = -2;
    /**
     * 正常值
     */
    private static final int OK = 1;
    /**
     * @param money 总金额
     * @param count 总份数
     * @param MINM 单个最小金额
     * @param MAXM 单个最大金额
     * @param TIMES 最大金额是平均数的几倍（null或0则用默认值2.1）
     * @return
     */
    public static List<Double> splitRedPacket(double money, int count, double MINM, double MAXM, Double TIMES) {

        List<Double> moneys = new LinkedList<>();
        //计算出最大红包
        if (!(TIMES != null && TIMES > 0)) {
            TIMES = 2.1;
        }
        double max = ConverterUtil.div(ConverterUtil.mul(money, TIMES), count, 2);
        max = max > MAXM ? MAXM : max;
        for (int i = 0; i < count; i++) {
            //随机获取红包
            double redPacket = randomRedPacket(money, MINM, max, MAXM, count - i);
            moneys.add(redPacket);
            //总金额每次减少
            money = ConverterUtil.sub(money, redPacket);
        }
        return moneys;
    }

    /**
     *
     * @param totalMoney
     * @param MINM
     * @param maxMoney
     * @param MAXM
     * @param count
     * @return
     */
    private static double randomRedPacket(double totalMoney, double MINM, double maxMoney, double MAXM, int count) {
        //只有一个红包直接返回
        if (count == 1) {
            return totalMoney;
        }
        //固定金额直接返回
        if (MINM == maxMoney) {
            return MINM;
        }
        //如果最大金额大于了剩余金额 则用剩余金额 因为这个 money 每分配一次都会减小
        maxMoney = maxMoney > totalMoney ? totalMoney : maxMoney;
        //在 minMoney到maxMoney 生成一个随机红包
        double redPacket = ConverterUtil.getRoundValue(Math.random() * (maxMoney - MINM) + MINM, 2);
        //计算剩余金额
        double lastMoney = ConverterUtil.sub(totalMoney, redPacket);
        //校验剩余金额是否合法
        int status = checkMoney(lastMoney, count - 1, MINM, MAXM);
        //正常金额
        if (OK == status) {
            return redPacket;
        }
        //如果生成的金额不合法 则递归重新生成
        if (LESS == status) {
            return randomRedPacket(totalMoney, MINM, redPacket, MAXM, count);
        }
        if (MORE == status) {
            return randomRedPacket(totalMoney, redPacket, maxMoney, MAXM, count);
        }
        return redPacket;
    }

    /**
     * 校验剩余的金额的平均值是否在 最小值和最大值这个范围内
     *
     * @param lastMoney
     * @param count
     * @return
     */
    private static int checkMoney(double lastMoney, int count, double MINM, double MAXM) {
        double avg = ConverterUtil.div(lastMoney, count, 2);
        if (avg < MINM) {
            return LESS;
        }
        if (avg > MAXM) {
            return MORE;
        }
        return OK;
    }
}
