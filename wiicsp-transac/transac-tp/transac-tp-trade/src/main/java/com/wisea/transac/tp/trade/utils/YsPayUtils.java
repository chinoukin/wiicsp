package com.wisea.transac.tp.trade.utils;

import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.pay.request.RefundRequest;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.DivideEventMapper;
import com.wisea.transac.common.dao.OrderInfoMapper;
import com.wisea.transac.common.dao.SettleBillPayRecordMapper;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.tpb.common.utils.StringUtil;
import com.wisea.transac.common.entity.*;
import com.wisea.yspay.config.YspayPayConfig;
import com.wisea.yspay.request.QueryPayRecordRequest;
import com.wisea.yspay.service.PayApiService;
import com.wisea.yspay.service.RefundApiService;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className YsPayUtils
 * @date 2020/5/8 15:59
 * @Description 银盛支付工具类
 */
public class YsPayUtils {
    private static OrderInfoMapper orderInfoMapper = SpringBootContext.getBean(OrderInfoMapper.class);
    private static YspayPayConfig config = SpringBootContext.getBean(YspayPayConfig.class);
    private static RefundApiService refundApiService = SpringBootContext.getBean(RefundApiService.class);
    private static PayApiService payApiService = SpringBootContext.getBean(PayApiService.class);
    private static DivideEventMapper divideEventMapper = SpringBootContext.getBean(DivideEventMapper.class);
    private static SettleBillPayRecordMapper payRecordMapper = SpringBootContext.getBean(SettleBillPayRecordMapper.class);

    /**
     * @Author jirg
     * @Date 2020/5/8 16:36
     * @Description 订单分账退款
     **/
    public static ResultPoJo<Object> ysPayRefund(RefundAppl refundAppl){
        RefundRequest request = new RefundRequest();
        request.setOrderId(refundAppl.getOrdId().toString());
        request.setAmount(refundAppl.getRefundAmount().toString());
        request.setOutRequestNo(refundAppl.getOutRequestNo());
        //获取订单原始分账信息
        String divideDetai = getDivideDetai(refundAppl.getOrdId());
        request.setDivideDetail(divideDetai);
        //获取分账退款明细
        String refundSplitInfo = getRefundSplitInfo(refundAppl);
        request.setRefundSplitInfo(refundSplitInfo);
        request.setRefundType(1);
        ResultPoJo<Object> refund = refundApiService.refund(request);
        return refund;
    }

    /**
     * 记录分账事件
     * @param orderId
     */
    public static void divitInto(Long orderId) {
        //设置分账事件
        DivideEvent divideEvent = new DivideEvent();
        divideEvent.setOrdId(orderId.toString());
        divideEvent.setDivStartTime(OffsetDateTime.now());
        divideEvent.setExeState("0");
        //分账信息
        divideEvent.setDivideDetail(getDivideDetai(orderId));
        //remark记录是长协订单还是普通订单0是普通订单，1是结算单
        divideEvent.setRemarks("0");
        divideEvent.preInsert();
        divideEventMapper.insertSelective(divideEvent);
        //调用第三方支付-订单确认收货接口
        ResultPoJo<Object> refundResult;
        try {
            QueryPayRecordRequest request = new QueryPayRecordRequest();
            request.setOrderId(orderId.toString());
            refundResult = payApiService.confirm(request);
        } catch (Exception ex) {
            throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, "第三方支付异常，请联系管理员"));
        }
        if(!refundResult.getCode().equals("20000")){
            throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, refundResult.getMsg()));
        }
    }

    /**
     * @Author jirg
     * @Date 2020/5/8 16:35
     * @Description 获取订单分账退款信息
     **/
    private static String getRefundSplitInfo(RefundAppl refundAppl){
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(refundAppl.getOrdId());

        String sellerMerchantNo = getMembMerchantNo(orderInfo.getSellerId());//卖家商编
        String partnerId = config.getPartnerId(); //平台商户商编

        //卖家退款金额 = 退款金额 - 平台应退服务费金额
        Double sellerRefundAmount = ConverterUtil.sub(refundAppl.getRefundAmount(), refundAppl.getRefundSerFee());
        //平台分账金额
        Double platformRefundAmount = refundAppl.getRefundSerFee();
        //拼接分账退款信息
        String format = "%s^%.2f;%s^%.2f";
        String refundSplitInfo = String.format(format, partnerId, platformRefundAmount, sellerMerchantNo, sellerRefundAmount);
        return refundSplitInfo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/8 16:35
     * @Description 获取订单原始分账信息
     **/
    private static String getDivideDetai(Long ordId){
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(ordId);

        String sellerMerchantNo = getMembMerchantNo(orderInfo.getSellerId());//卖家商编
        String partnerId = config.getPartnerId(); //平台商户商编

        //卖家分账金额
        Double sellerDivideAmount = ConverterUtil.sub(orderInfo.getPayableAmount(), orderInfo.getPlatfCost());
        //平台分账金额
        Double platformDivideAmount = orderInfo.getPlatfCost();
        //拼接分账信息
        String[] staAttr = new String[]{"01", "02"};
        String format = "%s^%.2f^%s;%s^%.2f^%s";
        String divideDetai = String.format(format, partnerId, platformDivideAmount, staAttr[0], sellerMerchantNo, sellerDivideAmount, staAttr[1]);
        return divideDetai;
    }

    /**
     * @Author jirg
     * @Date 2020/5/9 10:27
     * @Description 获取子商户商编
     **/
    private static String getMembMerchantNo(Long sellerId){
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(sellerId);
        String membMerchantNo = membInfo.getMerchantNo();//卖家商编
        return membMerchantNo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/20 16:56
     * @Description 结算单退款
     */
    public static void settleRefund(SettleBill settleBill) {
        List<SettleBillPayRecord> payRecords = payRecordMapper.findBySettleBillId(settleBill.getId());
        payRecords.forEach(p->{
            String subLedInfo = p.getSubLedInfo();
            String[] attr1 = subLedInfo.split(";");
            //拼接分账退款信息
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<attr1.length; i++){
                sb.append(attr1[i].split("^")[0]);
                sb.append("^");
                sb.append(attr1[i].split("^")[1]);
                sb.append(";");
            }
            sb.substring(0, sb.length() - 1);
            String refundSplitInfo = sb.toString();

            RefundRequest request = new RefundRequest();
            request.setOrderId(p.getId().toString());
            request.setAmount(p.getPaymentAmount().toString());
            request.setOutRequestNo(StringUtil.genNumbers(8));
            request.setDivideDetail(p.getSubLedInfo());
            //获取分账退款明细
            request.setRefundSplitInfo(refundSplitInfo);
            request.setRefundType(1);
            ResultPoJo<Object> refundResult;
            try {
                refundResult = refundApiService.refund(request);
            } catch (Exception ex) {
                throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, "第三方支付异常，请联系管理员"));
            }
            if(!refundResult.getCode().equals("20000")){
                throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, refundResult.getMsg()));
            }
        });
    }
}
