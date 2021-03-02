package com.wisea.transac.common.utils;

import java.util.List;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.transac.common.dao.*;

/**
 * Auth： yangtao
 * remark:
 */
public class FindMaxNumUtils {

    private static CommPubInfoMapper commPubInfoMapper = SpringBootContext.getBean(CommPubInfoMapper.class);
    private static RefundApplMapper refundApplMapper = SpringBootContext.getBean(RefundApplMapper.class);
    private static OrderInfoMapper orderInfoMapper = SpringBootContext.getBean(OrderInfoMapper.class);
    private static OrdInvoMapper ordInvoMapper = SpringBootContext.getBean(OrdInvoMapper.class);
    private static SettleBillMapper settleBillMapper = SpringBootContext.getBean(SettleBillMapper.class);
    private static SettleBillInvoMapper settleBillInvoMapper = SpringBootContext.getBean(SettleBillInvoMapper.class);

    /**
     * 查询商品最大编号
     *
     * @param parameter
     * @return
     */
    public static List<String> findCommPubInfoMaxNum(String parameter) {

        List<String> list = commPubInfoMapper.findCommPubInfoMaxNum(parameter);

        return list;
    }

    /**
     * @Author jirg
     * @Date 2020/5/9 10:45
     * @Description 查询退款申请最大编号
     **/
    public static List<String> findRefundMaxNum(String parameter) {
        List<String> list = refundApplMapper.findRefundMaxNum(parameter);
        return list;
    }

    /**
     * 查询订单最大编号
     * @param parameter
     * @return
     */
    public static List<String> findOrderMaxNum(String parameter){

        List<String> list = orderInfoMapper.findOrderNum(parameter);

        return list;
    }

    /**
     * @Author jirg
     * @Date 2019/5/7 17:24
     * @Description 查询自提码列表
     **/
    public static List<String> findOrdZtNum(String parameter) {
        List<String> ordZtNum = orderInfoMapper.findOrdZtNum(parameter);
        return ordZtNum;
    }

    /**
     * 查询申请开票最大编号
     * @param parameter
     * @return
     */
    public static List<String> findInvoApplMaxNum(String parameter){

        List<String> list = ordInvoMapper.findApplNumMaxNum(parameter);

        return list;
    }

    /**
     * 查询结算单申请开票最大编号
     * @param parameter
     * @return
     */
    public static List<String> findSettleInvoApplMaxNum(String parameter){

        List<String> list = settleBillInvoMapper.findApplNumMaxNum(parameter);

        return list;
    }

    /**
     * @Author jirg
     * @Date 2020/5/14 9:57
     * @Description 查询结算单最大编号
     **/
    public static List<String> findSettleBillNum(String parameter) {
        List<String> list = settleBillMapper.findMaxNum(parameter);
        return list;
    }
}
