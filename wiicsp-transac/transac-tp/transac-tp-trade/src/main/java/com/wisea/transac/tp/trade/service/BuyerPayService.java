package com.wisea.transac.tp.trade.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.po.trade.BuyerPayRequestPo;
import com.wisea.transac.common.utils.CodeUtils;
import com.wisea.transac.common.utils.DeadLineUtils;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import com.wisea.transac.tp.trade.utils.OrderLogger;
import com.wisea.transac.tp.trade.utils.SettleBillLogger;
import com.wisea.tpb.common.pay.entity.PayRecord;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.yspay.config.YspayPayConfig;
import com.wisea.yspay.notify.handler.PayApiNotificationHandler;
import com.wisea.yspay.request.PayApiRequest;
import com.wisea.yspay.request.QueryPayRecordRequest;
import com.wisea.yspay.service.PayApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * 订单支付相关Service
 */
@Service
public class BuyerPayService extends PayApiNotificationHandler {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private SettleBillMapper settleBillMapper;
	@Autowired
	private ApPayMageMapper apPayMageMapper;
	@Autowired
    private DivideEventMapper divideEventMapper;
	@Autowired
    private PayApiService payApiService;
	@Autowired
	private com.wisea.transac.common.dao.OrdOpreateInfoMapper OrdOpreateInfoMapper;
	@Autowired
    private SettleBillPayRecordMapper settleBillPayRecord;
	@Autowired
    private SettleBillInvoMapper settleBillInvoMapper;
	@Autowired
    private YspayPayConfig config;
	@Autowired
    private TimSendService timSendService;

	/**
	 * 支付回调
	 */
	@Override
	@Transactional(readOnly=false)
	protected void handle(PayRecord payRecord) {
		//账期是多笔支付，为ID-日期串。需要分隔
		String[] spl = payRecord.getOrdId().split("-");
		Long sellId = ConverterUtil.toLong(spl[0]);
		//发货
		QueryPayRecordRequest request = new QueryPayRecordRequest();
		request.setOrderId(payRecord.getOrdId());
		ResultPoJo<Object> delivered = payApiService.delivered(request);
		if (!"20000".equals(delivered.getCode())) {
			throw new BusinessException(delivered.getCode(), delivered.getMsg());
		}
		if ("1".equals(payRecord.getRemarks())) {
			Logger logger = SettleBillLogger.getLogger(sellId);
			logger.info("【买家】发货结算单完成：{}", delivered);
		}else {
			Logger logger = OrderLogger.getLogger(sellId);
			logger.info("【买家】发货订单完成：{}", delivered);
		}
		//账期支付回调
		if ("1".equals(payRecord.getRemarks())) {
			//获取账单信息
			SettleBill settleBill = settleBillMapper.selectByPrimaryKey(sellId);

			if (DictConstants.PAY_STATE_1.equals(payRecord.getPayState())) {
			    Double payAmount = ConverterUtil.toDouble(payRecord.getPayAmount());
			    //剩余应支付的滞纳金
	            Double havaPayFee = 0D;
			    Double lateFee = 0D;
			    //平台分账金额
                Double platformDivideAmount = 0D;
                //卖家分账金额
                Double sellerDivideAmount = 0D;
			    //判断是否逾期
			    if (DictConstants.SF_YQ_FLAG_0.equals(settleBill.getSfYqFlag()) && ConverterUtil.isNotEmpty(settleBill.getLateFee())) {
	                //逾期的话，当前支付金额肯定是等于滞纳金（优先支付滞纳金）
			        lateFee = settleBill.getLateFee();
			        havaPayFee = ConverterUtil.sub(lateFee,
			                settleBill.getPaymentLateFeeAmount()==null?0:settleBill.getPaymentLateFeeAmount());
			        settleBill.setPaymentLateFeeAmount(settleBill.getLateFee());
	            }
			    //判断是否支付过
			    if (settleBill.getPaymentAmount() != null && settleBill.getPaymentAmount() > 0) {

			        sellerDivideAmount = payAmount;
			    }else {

			        platformDivideAmount = settleBill.getPlatfCost();
			        sellerDivideAmount = ConverterUtil.sub(payAmount, platformDivideAmount);
			    }
			    //已支付总金额
                Double paymentAmount = ConverterUtil.add(payAmount, settleBill.getPaymentAmount()==null?0:settleBill.getPaymentAmount());
                settleBill.setPaymentAmount(paymentAmount);
			    //已支付账期金额
			    settleBill.setPaymentSettleAmount(ConverterUtil.sub(settleBill.getPaymentAmount(),
			            settleBill.getPaymentLateFeeAmount()==null?0:settleBill.getPaymentLateFeeAmount()));

				//修改授权账期余额
				ApPayMage apPayMage = apPayMageMapper.findByIds(settleBill.getSellerId(), settleBill.getBuyerId());
				apPayMage.setAvailableCredit(ConverterUtil.add(apPayMage.getAvailableCredit(), payAmount));
				apPayMageMapper.updateByPrimaryKeySelective(apPayMage);
				//结算单支付记录表插入数据
                SettleBillPayRecord billPay = new SettleBillPayRecord();
                billPay.setSettleId(sellId);
                billPay.setPayDate(OffsetDateTime.now());
                billPay.setPaymentAmount(paymentAmount);
                billPay.setPaymentLateFeeAmount(havaPayFee);
                billPay.setPaymentSettleAmount(ConverterUtil.sub(paymentAmount, havaPayFee));
                billPay.setSubLedFlag(DictConstants.SUB_LED_FLAG_1);
                billPay.setPayId(payRecord.getOrdId());
                //设置分账信息
                String sellerMerchantNo = MembUtils.getMembInfoByUserId(settleBill.getSellerId()).getMerchantNo();//卖家商编
                String partnerId = config.getPartnerId(); //平台商户商编
                //拼接分账信息
                String[] staAttr = new String[]{"01", "02"};
                String format = "%s^%.2f^%s;%s^%.2f^%s";
                String divideDetai = String.format(format, partnerId, platformDivideAmount, staAttr[0], sellerMerchantNo, sellerDivideAmount, staAttr[1]);
                billPay.setSubLedInfo(divideDetai);
                //判断是否需要分账
                //查询发票详情
                LongIdPo longPo = new LongIdPo();
                SettleBillInvoInfoVo invo = settleBillInvoMapper.findInfo(longPo);
                //不需要发票和已验票
                if (invo == null || (invo != null && DictConstants.INVO_STATE_2.equals(invo.getInvoState()))) {
                    //分过账的记录
                    billPay.setSubLedFlag(DictConstants.SUB_LED_FLAG_0);
                    divitInto(sellId, divideDetai, payRecord.getOrdId());
					//如果支付金额=应付金额，判断是否有待验票
					if (payAmount.equals(ConverterUtil.add(settleBill.getTotalMoney(),lateFee))) {

						settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_2);
					}
				}else {//如果有并且是待结算则还保持待结算，如果是逾期则转为待结算

                	if (DictConstants.SF_YQ_FLAG_0.equals(settleBill.getSfYqFlag())) {
						settleBill.setSfYqFlag(DictConstants.SF_YQ_FLAG_1);
					}
				}
				settleBill.setPrevPayDate(OffsetDateTime.now());
				settleBill.preUpdate();
				settleBillMapper.updateByPrimaryKeySelective(settleBill);
                billPay.preInsert();
                settleBillPayRecord.insertSelective(billPay);
			}
		}else {
			if (DictConstants.PAY_STATE_1.equals(payRecord.getPayState())) {
				//获取全部订单
				OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(sellId);
				orderInfo.setPayOrdDate(OffsetDateTime.now());
				orderInfo.setPayMethodType(DictConstants.PAY_METHOD_TYPE_0);
				if (DictConstants.SEND_ZT_TYPE_1.equals(orderInfo.getSendZtType())) {
					orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_2);
				}else {
					orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_6);
				}
				orderInfo.setZtClosingDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).plusDays(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_2)));
				//设置10位随机数
	            orderInfo.setZtNum(CodeUtils.generateZtNum());
				/*orderInfo.setPayChannel(payRecord.getPayChannel());
				orderInfo.setPlatformType(payRecord.getPlatformType());*/
				orderInfo.preUpdate();
				orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
				//订单操作表里插入数据
				OrdOpreateInfo ordOpreateInfo = new OrdOpreateInfo();
				ordOpreateInfo.setOrdId(sellId);
				ordOpreateInfo.setOpreatDate(OffsetDateTime.now());
				ordOpreateInfo.setOperator("买家");
				ordOpreateInfo.setOpreatContent("买家支付订单");
				ordOpreateInfo.preInsert();
				OrdOpreateInfoMapper.insertSelective(ordOpreateInfo);
			}
		}
	}

	/**
     * 记录分账事件
     * @param
     */
    public void divitInto(Long settleId, String dividInfo, String ordDateId) {
        //设置分账事件
        DivideEvent divideEvent = new DivideEvent();
        divideEvent.setOrdId(settleId.toString());
        divideEvent.setDivStartTime(OffsetDateTime.now());
        divideEvent.setOrdDateId(ordDateId);
        divideEvent.setExeState("0");
        //分账信息
        divideEvent.setDivideDetail(dividInfo);
        //remark记录是长协订单还是普通订单0是普通订单，1是结算单
        divideEvent.setRemarks("1");
        divideEvent.preInsert();
        divideEventMapper.insertSelective(divideEvent);
        //调用第三方支付-订单确认收货接口
        ResultPoJo<Object> refundResult;
        try {
            QueryPayRecordRequest request = new QueryPayRecordRequest();
            request.setOrderId(settleId.toString());
            refundResult = payApiService.confirm(request);
        } catch (Exception ex) {
            throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, "第三方支付异常，请联系管理员"));
        }
        if(!refundResult.getCode().equals("20000")){
            throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, refundResult.getMsg()));
        }
    }

	/**
	 * 订单支付
	 * @param po
	 * @return
	 * @throws Exception
	 */
    @Transactional(readOnly=false)
	public ResultPoJo<Object> buyerPay (BuyerPayRequestPo po) throws Exception {

		ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		PayApiRequest payRequest = new PayApiRequest();
		//商户号
		String ledgerNo = null;
		//获取用户openId信息
		String openId =  null;
		//判断是结算单还是订单
		if ("0".equals(po.getIfSettlePay())) {
		  //校验订单状态
	        //获取全部订单
	        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(po.getOrderId());
	        //获取商户商户号
	        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(orderInfo.getSellerId());
	        ledgerNo = membInfo.getMerchantNo();
	        openId = membInfo.getWechatOpenId();
	        if (!DictConstants.ORDER_STATE_TYPE_1.equals(orderInfo.getOrderStateType())) {

	            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
	            resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，状态错误");
	            return resultPoJo;
	        }
	        //校验付款截止日期
	        if (OffsetDateTime.now().isAfter(orderInfo.getBuyPayClosingDate())) {

	            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
	            resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，付款日期超时");
	            return resultPoJo;
	        }
	        //校验支付方式
	        if (DictConstants.PAY_METHOD_TYPE_1.equals(orderInfo.getPayMethodType())) {

	            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
	            resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，支付方式错误");
	            return resultPoJo;
	        }
	        //设置支付参数
	        payRequest.setAmount(ConverterUtil.toString(orderInfo.getPayableAmount()));
	        payRequest.setOrdNum(orderInfo.getOrdNum());
	        payRequest.setSellerUserCode(ledgerNo);
	        payRequest.setOrderId(po.getOrderId().toString());
            //事物提交之后发送消息
            Map<String, Object> param = Maps.newHashMap();
            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_SALLER);
            param.put("id", orderInfo.getId());
            param.put("staffId", orderInfo.getStallsId());
            param.put("userId", orderInfo.getSellerId());
            param.put("transType", DictConstants.TRANS_TYPE_0);
            param.put("ordNum", orderInfo.getOrdNum());
            //发送给买家
            Map<String, Object> param2 = Maps.newHashMap();
            param2.put("timType", TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_BUYER);
            param2.put("id", orderInfo.getId());
            param2.put("userId", orderInfo.getPurchaseId());
            param.put("transType", DictConstants.TRANS_TYPE_0);
            param2.put("ordNum", orderInfo.getOrdNum());
            if (DictConstants.ZT_ADDRESS_TYPE_0.equals(orderInfo.getZtAddressType())) {
                param2.put("ztAddr", orderInfo.getZtAddressProv()+orderInfo.getZtAddressCity()+orderInfo.getZtAddressCou()+orderInfo.getStallsAddress());
            }else {
                param2.put("ztAddr", orderInfo.getZtAddress());
            }
            param2.put("ztNum", orderInfo.getZtNum());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
					timSendService.sendTim(param);
					timSendService.sendTim(param2);
                }
            });
		}else {
		    //获取账单信息
		    Long settlId = ConverterUtil.toLong(po.getOrderId());
            SettleBill settleBill = settleBillMapper.selectByPrimaryKey(settlId);
            //校验账单
            if (!DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(settleBill.getSettleBillStatueType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("账期结算单："+settleBill.getSettleBillNumb()+"的结算单，状态错误");
                return resultPoJo;
            }
            //剩余结算金额
            Double nowPayAmount = 0D;
            //剩余滞纳金金额
            Double lateFeAmount = 0D;
            //本次最小支付金额
            Double smartAmount = 0D;
            //判断是否逾期
            if (DictConstants.SF_YQ_FLAG_0.equals(settleBill.getSfYqFlag()) && ConverterUtil.isNotEmpty(settleBill.getLateFee())) {

                nowPayAmount = settleBill.getLateFee();
                lateFeAmount = settleBill.getLateFee();
                smartAmount = settleBill.getLateFee();
            }
            //判断是否支付过
            if (settleBill.getPaymentAmount() != null && settleBill.getPaymentAmount() > 0) {
                //支付过，则剩余应付金额=总金额-已付总金额+滞纳金
                nowPayAmount = ConverterUtil.add(ConverterUtil.sub(settleBill.getTotalMoney(), settleBill.getPaymentAmount()), nowPayAmount);
                //剩余滞纳金=滞纳金-支付过滞纳金
                if (ConverterUtil.isNotEmpty(settleBill.getPaymentLateFeeAmount())) {
                    //有可能是当前逾期，上次支付时不逾期，所以判断是否支付过滞纳金
                    lateFeAmount =  ConverterUtil.sub(lateFeAmount, settleBill.getPaymentLateFeeAmount());
                }
                //最小结算金额=剩余滞纳金
                smartAmount = lateFeAmount;
            }else {
                //未支付过
                nowPayAmount = ConverterUtil.add(settleBill.getTotalMoney(), nowPayAmount);
                //最小结算金额=账期服务费+平台服务费+逾期滞纳金
                smartAmount = ConverterUtil.add(ConverterUtil.add(settleBill.getZqSerCost(), settleBill.getPlatfCost()), smartAmount);
            }
            //校验金额是否属于正常范围
            if ((po.getPayAmount() < nowPayAmount) && (po.getPayAmount() < smartAmount)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("账期结算单："+settleBill.getSettleBillNumb()+"的结算单，金额错误");
                return resultPoJo;
            }
            //获取商户商户号
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(settleBill.getSellerId());
            ledgerNo = membInfo.getMerchantNo();
            openId = membInfo.getWechatOpenId();
            //设置支付参数
            payRequest.setAmount(ConverterUtil.toString(po.getPayAmount()));
            payRequest.setOrdNum(settleBill.getSettleBillNumb());
            payRequest.setOrderId(po.getOrderId()+"-"+OffsetDateTimeUtils.getLong());
		}
		logger.debug("订单id：", po.getOrderId());
        logger.debug("订单amount：", payRequest.getAmount());
        logger.debug("订单TranType：", po.getTranType());
        if ("6".equals(po.getTranType())) {

            payRequest.setOpenid(openId);
        }
        payRequest.setSellerUserCode(ledgerNo);
		payRequest.setExtendOptions(po.getIfSettlePay());
		payRequest.setTranType(po.getTranType());
		return payApiService.createOrderPay(payRequest);
	}
}
