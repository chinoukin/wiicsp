package com.wisea.cultivar.common.utils.tp;

import java.util.List;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cultivar.common.dao.tp.CommPubInfoMapper;
import com.wisea.cultivar.common.dao.tp.LtaCommRelaMapper;
import com.wisea.cultivar.common.dao.tp.LtaContInfoMapper;
import com.wisea.cultivar.common.dao.tp.LtaOrdInfoMapper;
import com.wisea.cultivar.common.dao.tp.LtaOrdInvoMapper;
import com.wisea.cultivar.common.dao.tp.LtaRefundApplMapper;
import com.wisea.cultivar.common.dao.tp.LtaRefundCommApplMapper;
import com.wisea.cultivar.common.dao.tp.OrdInvoMapper;
import com.wisea.cultivar.common.dao.tp.OrderInfoMapper;
import com.wisea.cultivar.common.dao.tp.RefundApplMapper;
import com.wisea.cultivar.common.dao.tp.RefundCommApplMapper;
import com.wisea.cultivar.common.dao.tp.RetrospPcMageMapper;
import com.wisea.cultivar.common.dao.tp.SettleBillInvoMapper;
import com.wisea.cultivar.common.dao.tp.SettleBillMapper;

/**
 * Auth： yangtao
 * remark:
 */
public class FindMaxNumUtils {

    private static RefundApplMapper refundApplMapper = SpringBootContext.getBean(RefundApplMapper.class);
    private static RefundCommApplMapper refundCommApplMapper = SpringBootContext.getBean(RefundCommApplMapper.class);
    private static OrderInfoMapper orderInfoMapper = SpringBootContext.getBean(OrderInfoMapper.class);
    private static SettleBillMapper settleBillMapper = SpringBootContext.getBean(SettleBillMapper.class);
    private static CommPubInfoMapper commPubInfoMapper = SpringBootContext.getBean(CommPubInfoMapper.class);
    private static LtaCommRelaMapper ltaCommRelaMapper = SpringBootContext.getBean(LtaCommRelaMapper.class);
    private static OrdInvoMapper ordInvoMapper = SpringBootContext.getBean(OrdInvoMapper.class);
    private static SettleBillInvoMapper settleBillInvoMapper = SpringBootContext.getBean(SettleBillInvoMapper.class);
    private static LtaOrdInfoMapper ltaOrdInfoMapper = SpringBootContext.getBean(LtaOrdInfoMapper.class);
    private static LtaContInfoMapper ltaContInfoMapper = SpringBootContext.getBean(LtaContInfoMapper.class);
    private static LtaOrdInvoMapper ltaOrdInvoMapper = SpringBootContext.getBean(LtaOrdInvoMapper.class);
    private static LtaRefundApplMapper ltaRefundApplMapper = SpringBootContext.getBean(LtaRefundApplMapper.class);
    private static LtaRefundCommApplMapper ltaRefundCommApplMapper = SpringBootContext.getBean(LtaRefundCommApplMapper.class);
    private static RetrospPcMageMapper retrospPcMageMapper = SpringBootContext.getBean(RetrospPcMageMapper.class);

    /**
     * 查询商品最大编号
     * @param parameter
     * @return
     */
    public static List<String> findCommPubInfoMaxNum(String parameter){

        List<String> list = commPubInfoMapper.findCommPubInfoMaxNum(parameter);

        return list;
    }

    /**
     * 查询长协商品最大编号
     * @param parameter
     * @return
     */
    public static List<String> findLtaCommRelaMaxNum(String parameter){

        List<String> list = ltaCommRelaMapper.findLtaCommRelaMaxNum(parameter);

        return list;
    }
    /**
     * 查询退货、退款最大编号
     * @param parameter
     * @return
     */
    public static List<String> findRefundMaxNum(String parameter){

        List<String> list = refundApplMapper.findRefundApplNum(parameter);
        List<String> refundApplCommNumList = refundCommApplMapper.findRefundCommApplNum(parameter);

        list.addAll(refundApplCommNumList);

        return list;
    }

    /**
     * 查询长协退货、退款最大编号
     * @param parameter
     * @return
     */
    public static List<String> findLtaRefundMaxNum(String parameter){

        List<String> list = ltaRefundApplMapper.findLtaRefundApplNum(parameter);
        List<String> refundApplCommNumList = ltaRefundCommApplMapper.findLtaRefundCommApplNum(parameter);

        list.addAll(refundApplCommNumList);

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
     * 查询长协订单最大编号
     * @param parameter
     * @return
     */
    public static List<String> findLtaOrderMaxNum(String parameter){

        List<String> list = ltaOrdInfoMapper.findOrderNum(parameter);

        return list;
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
     * 查询长协申请开票最大编号
     * @param parameter
     * @return
     */
    public static List<String> findLtaInvoApplMaxNum(String parameter){

        List<String> list = ltaOrdInvoMapper.findApplNumMaxNum(parameter);

        return list;
    }

    /**
     * 查询账期结算的申请开票最大编号
     * @param parameter
     * @return
     */
    public static List<String> findSettltInvoApplMaxNum(String parameter){

        List<String> list = settleBillInvoMapper.findApplNumMaxNum(parameter);

        return list;
    }

    public static List<String> findSettleBillMaxNum(String parameter){

        List<String> list = settleBillMapper.findSettleBillNum(parameter);

        return list;
    }

    /**
     * @Author jirg
     * @Date 2019/5/7 17:24
     * @Description 查询自提码列表
     **/
    public static List<String> findOrdZtNum(String parameter) {
        List<String> ordZtNum = orderInfoMapper.findOrdZtNum(parameter);
        List<String> ltaOrdZtNum = ltaOrdInfoMapper.findOrdZtNum(parameter);
        ordZtNum.addAll(ltaOrdZtNum);
        return ordZtNum;
    }
    /**
     * 长期协议合同编号
     *
     * @author wangh(wisea)
     *
     * @date 2019年5月9日
     * @version 1.0
     */
    public static List<String> findLtaContNum(String paremeter){
        List<String> numList = ltaContInfoMapper.checkLtaContNum(paremeter);
        return numList;
    }

    /**
     * @Author jirg
     * @Date 2019/12/21 10:10
     * @Description 查询批次编号列表
     **/
    public static List<String> findTraceBatchNumCode(String prefix) {
        List<String> traceBatchNumCodeList = retrospPcMageMapper.findTraceBatchNumCode(prefix);
        return traceBatchNumCodeList;
    }
}
