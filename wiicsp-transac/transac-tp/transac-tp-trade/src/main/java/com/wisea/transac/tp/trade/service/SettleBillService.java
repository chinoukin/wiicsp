package com.wisea.transac.tp.trade.service;

import ch.qos.logback.classic.Logger;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.po.SettleBillPageListPo;
import com.wisea.transac.common.po.trade.*;
import com.wisea.transac.common.utils.CodeUtils;
import com.wisea.transac.common.utils.DeadLineUtils;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import com.wisea.transac.common.vo.SettleBillPageListVo;
import com.wisea.transac.tp.trade.constants.SettleBillOperateEnum;
import com.wisea.transac.tp.trade.utils.SettleBillLogger;
import com.wisea.transac.tp.trade.utils.YsPayUtils;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.transac.common.vo.trade.*;
import com.wisea.yspay.request.QueryPayRecordRequest;
import com.wisea.yspay.service.PayApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.time.MonthDay;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SettleBillService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class SettleBillService extends BaseService {
    @Autowired
	private SettleBillMapper mapper;
	@Autowired
	private ApPayMageMapper apPayMageMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private RefundApplMapper refundApplMapper;
	@Autowired
	private SettleOrdRelaMapper settleOrdRelaMapper;
	@Autowired
	private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;
	@Autowired
	private SettleBillOpreateInfoService opreateInfoService;
	@Autowired
    private InvoInfoMapper invoInfoMapper;
	@Autowired
    private SettleBillInvoMapper settleBillInvoMapper;
	@Autowired
    private SettleBillPayRecordMapper settleBillPayRecordMapper;
	@Autowired
    private DivideEventMapper divideEventMapper;
	@Autowired
    private PayApiService payApiService;
	@Autowired
	private TimSendService timSendService;
	@Autowired
    private JedisDao jedisDao;

	public static String SETTLE_BILL_REMIND_PAY_KEY = "SETTLE_BILL_REMIND_PAY_";


    /**
     * @Author jirg
     * @Date 2020/5/14 10:39
     * @Description 分页查询结算单列表
     **/
    public ResultPoJo<PageStateCountResultVo<SettleBillPageListVo>> findPageList(SettleBillPageListPo po) {
		LoggerUtil.infoWithContext("【findPageList】分页查询结算单列表：", po);
		ResultPoJo<PageStateCountResultVo<SettleBillPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		PageStateCountResultVo vo = new PageStateCountResultVo();
		po.setLastPayStartDate(OffsetDateTimeUtils.getDayMinTime(po.getLastPayStartDate()));
		po.setLastPayEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getLastPayEndDate()));

		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		//判断当前登录用户
		List<Long> sellerIds = Lists.newArrayList();
		if(membInfo.getUserSourceType().equals("0") || membInfo.getUserSourceType().equals("1")){
			if(membInfo.getUserSourceType().equals("0")){
				//市场Id不能为空
				Assert.notNull(po.getMarketId(), "批发市场不能为空！");
			}else{
				//获取批发市场ID
				po.setMarketId(membInfo.getMarketId());
			}
			po.setQueryUserFlag("0");
			//查询出市场的所有商家
			List<MembInfo> sellers = wholeSaleMarketMageMapper.findMembIdByMarketId(po.getMarketId());
			sellerIds = sellers.stream().map(MembInfo::getId).collect(Collectors.toList());
		}else{
			po.setQueryUserFlag("1");
			sellerIds.add(membInfo.getMembId());
		}
		po.setSellerIds(sellerIds);

		Page<SettleBillPageListVo> page = po.getPage();
		if(po.getQueryUserFlag().equals("1")){
			//卖家查询订单列表
			LoggerUtil.infoWithContext("商家查询订单列表：", "");
			//查询各个订单状态下的数量
			po.setPage(null);
			SettleBillCountVo countVo = mapper.findCountByState(po);
			//封装数据
			Map<String, Integer> stateCountMap = Maps.newHashMap();
			if(ConverterUtil.isNotEmpty(countVo)){
				stateCountMap.put("0", countVo.getRecoCount());
				stateCountMap.put("1", countVo.getInvoicCount());
				stateCountMap.put("2", countVo.getSettledCount());
				stateCountMap.put("3", countVo.getOverdue());
			}else{
				stateCountMap.put("0", 0);
				stateCountMap.put("1", 0);
				stateCountMap.put("2", 0);
				stateCountMap.put("3", 0);
			}
			vo.setStateCountMap(stateCountMap);
			po.setPage(page);
		}
		List<SettleBillPageListVo> list = mapper.findPageList(po);

		/******以下代码为前端不好判断，所以才由后端判断好之后进行返回*****/
		if(ConverterUtil.isEmpty(po.getQueryFlag()) || po.getQueryFlag().equals("4")){
			list.forEach(e->{
				if(e.getSettleBillStatueType().equals(DictConstants.SETTLE_BILL_STATUE_TYPE_0)){
					//待对账
					e.setQueryFlag("0");
				}else if(e.getSettleBillStatueType().equals(DictConstants.SETTLE_BILL_STATUE_TYPE_1)){
					//待结算
					e.setQueryFlag("2");
					if(ConverterUtil.isNotEmpty(e.getSettleBillInvoState()) && e.getSettleBillInvoState().equals(DictConstants.INVO_STATE_0)){
						//待开票
						e.setQueryFlag("1");
					}else if(ConverterUtil.isNotEmpty(e.getSfYqFlag()) && e.getSfYqFlag().equals(DictConstants.SF_YQ_FLAG_0)){
						//逾期
						e.setQueryFlag("3");
					}
				}
			});
		}
		/******以上代码为前端不好判断，所以才由后端判断好之后进行返回*****/

		page.setList(list);
		vo.setPage(page);
		resultPoJo.setResult(vo);
		return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/14 16:03
     * @Description 查询结算单详细信息
     **/
    public ResultPoJo<SettleBillInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<SettleBillInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBillInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			vo.setDeadLineDay(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_5));
			vo.setTotalAllMoney(ConverterUtil.add(vo.getTotalMoney(), vo.getLateFee() != null? vo.getLateFee():0D));
			if (!DictConstants.SF_YQ_FLAG_0.equals(vo.getSfYqFlag()) &&
					DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(vo.getSettleBillStatueType()) && vo.getLastPayDate() != null) {

				vo.setJyYuqiDay(OffsetDateTimeUtils.getDifferenceDayes(vo.getNowDate(), vo.getLastPayDate())+1);
			}
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * @Author jirg
	 * @Date 2020/5/15 14:48
	 * @Description 取消结算单
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> cancelSettleBill(LongIdPo po) {
		LoggerUtil.infoWithContext("【cancelSettleBill】取消结算单：", po);
		ResultPoJo<SettleBillInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(settleBill)){
			//判断结算单状态
			if(settleBill.getSettleBillStatueType().equals(DictConstants.SETTLE_BILL_STATUE_TYPE_0) &&
					settleBill.getSettleBillPrdutType().equals(DictConstants.SETTLE_BILL_PRDUT_TYPE_1)){
				OffsetDateTime nowDate = OffsetDateTime.now(); //当前时间
				OffsetDateTime createDate = OffsetDateTimeUtils.getDayMinTime(settleBill.getCreateDate()); //结算单创建时间
				String settleCycleType = settleBill.getSettleCycleType();
				String billDateType = settleBill.getBillDateType();
				//本周或本月对账日
				OffsetDateTime recoDate = null;
				if (settleCycleType.equals(DictConstants.SETTLE_CYCLE_TYPE_0)){
					//周结 获取当前周对账日
					recoDate = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()).with(WeekFields.ISO.dayOfWeek(), Integer.valueOf(billDateType) - 28);

				}else{
					//月结 获取当前月对账日
					recoDate = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()).withMonth(MonthDay.now().getMonth().getValue()).withDayOfMonth(Integer.valueOf(billDateType));
				}
				//结算单生成日 < 本周（本月）对账日  &&  当前日期 > 本周（本月）对账日  不可取消
				if(createDate.compareTo(recoDate) < 0 && nowDate.compareTo(recoDate) > 0){
					resultPoJo.setCode(ConstantCodeMsg.ERR_415);
					resultPoJo.setMsg(ConstantCodeMsg.MSG_415);
					return resultPoJo;
				}
				settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_3);
				settleBill.preUpdate();
				mapper.updateByPrimaryKey(settleBill);
				//查询结算单订单列表
				List<Long> ordIdList = settleOrdRelaMapper.selectOrdIdsBySettleId(settleBill.getId());
				SettleBillGenerateTypePo updatePo = new SettleBillGenerateTypePo();
				updatePo.setOrdIds(ordIdList);
				updatePo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_1);
				//更新订单结算单生成状态为未生成
				orderInfoMapper.updateSettleBillGenerateType(updatePo);
				//删除结算单-订单中间表数据
				//settleOrdRelaMapper.delBySettleId(settleBill.getId());
				Logger settleBillLogger = SettleBillLogger.getLogger(settleBill.getId());
				settleBillLogger.info("卖家取消提前生成的结算单，结算单下订单的结算单生成状态已置为【未生成】。订单为[{}]", ordIdList);
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/15 15:45
	 * @Description 卖家确认对账
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> sellerReco(LongIdPo po) {
		LoggerUtil.infoWithContext("【sellerReco】卖家确认对账：", po);
		ResultPoJo<SettleBillInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(settleBill)){
			//判断结算单状态
			if(settleBill.getSettleBillStatueType().equals(DictConstants.SETTLE_BILL_STATUE_TYPE_0) && (
					settleBill.getReconStateType().equals(DictConstants.RECON_STATE_TYPE_0) ||
					settleBill.getReconStateType().equals(DictConstants.RECON_STATE_TYPE_2))){
				if(settleBill.getReconStateType().equals(DictConstants.RECON_STATE_TYPE_0)){
					//修结算单对账状态为待买家对账
					settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_1);
				}else{
					//修结算单对账状态为已完成
					settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_4);
					//修改结算单状态为待结算
					settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_1);
					//计算付款截止日
					settleBill.setLastPayDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).plusDays(settleBill.getPayDeadDate()));

					//事物提交之后发送消息
					Map<String, Object> param = Maps.newHashMap();
					param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_TO_BUYER);
					param.put("id", settleBill.getId());
					param.put("userId", settleBill.getBuyerId());
					param.put("ordNum", settleBill.getSettleBillNumb());
					param.put("lastPayDate", settleBill.getLastPayDate().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")));
					param.put("totalMoney", settleBill.getTotalMoney());
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							//向买家发送消息
							timSendService.sendTim(param);
							//判断是否申请开票
							if(ConverterUtil.isNotEmpty(settleBill.getOpenBillDeadline())){
								//发送卖家开票信息
								MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(settleBill.getBuyerId());
								param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_TO_BE_INVOICED);
								param.put("userId", settleBill.getSellerId());
								param.put("buyerName", membInfo.getAuthName());
								timSendService.sendTim(param);
							}
						}
					});
				}
				settleBill.preUpdate();
				mapper.updateByPrimaryKey(settleBill);
				//插入结算单操作记录
				opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.SELLER_RECON, null);
				Logger settleBillLogger = SettleBillLogger.getLogger(settleBill.getId());
				settleBillLogger.info("卖家确认对账，结算单信息修改为：{}", settleBill);
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @author jirg
	 * @date 2020/8/25 15:20
	 * @Description 提醒买家支付
	 */
	public ResultPoJo<?> remindPay(LongIdPo po) {
		LoggerUtil.infoWithContext("【remindPay】提醒买家支付：", po);
		ResultPoJo<SettleBillInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(settleBill)){
			//判断结算单状态
			if(settleBill.getSettleBillStatueType().equals(DictConstants.SETTLE_BILL_STATUE_TYPE_1)){
				//判断最晚付款日
				OffsetDateTime lastPayDate = settleBill.getLastPayDate();
				if(lastPayDate.plusDays(-3).isBefore(OffsetDateTime.now())){
					//判断上次提醒是否超过12小时
					SettleBill serialize = jedisDao.getSerialize(SETTLE_BILL_REMIND_PAY_KEY.concat(String.valueOf(settleBill.getId())), SettleBill.class);
					if (ConverterUtil.isEmpty(serialize)){
						jedisDao.setSerializeExpire(SETTLE_BILL_REMIND_PAY_KEY.concat(String.valueOf(settleBill.getId())), settleBill, 12 * 60 * 60);

						//插入结算单操作记录
						opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.REMIND_PAYMENT, null);

						Long differenceDayes = OffsetDateTimeUtils.getDifferenceDayes(OffsetDateTime.now(), settleBill.getLastPayDate());

						//提醒买家支付，缓存提醒时间
						Map<String, Object> timMap = Maps.newHashMap();
						timMap.put("ordNum", settleBill.getSettleBillNumb());
						timMap.put("id", settleBill.getId());
						timMap.put("userId", settleBill.getBuyerId());
						//判断结算单是否逾期
						if(DictConstants.SF_YQ_FLAG_0.equals(settleBill.getSfYqFlag())){
							//已逾期
							timMap.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_OVERDUE_PAY_REMINDER);
							timMap.put("daysRemaining", differenceDayes + 1);
							timMap.put("lastPayDate", settleBill.getLastPayDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
							timMap.put("totalMoney", settleBill.getTotalMoney());
						}else{
							//未逾期
							timMap.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_PAY_REMINDER);
							timMap.put("daysOverdue", Math.abs(differenceDayes));
							timMap.put("lateFee", settleBill.getLateFee());
						}
						timSendService.sendTim(timMap);
					}else{
						resultPoJo.setCode(ConstantCodeMsg.ERR_450);
						resultPoJo.setMsg(ConstantCodeMsg.MSG_450);
					}
				}
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}



	/**
	 * @Author jirg
	 * @Date 2020/5/18 14:39
	 * @Description 查询对账异议列表
	 **/
	public ResultPoJo<Page<SettleBillPageListVo>> findReconcList(ReconcListPo po) {
		LoggerUtil.infoWithContext("【findReconcList】查询对账异议列表：", po);
		ResultPoJo<Page<SettleBillPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		po.setLastPayStartDate(OffsetDateTimeUtils.getDayMinTime(po.getLastPayStartDate()));
		po.setLastPayEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getLastPayEndDate()));

		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		//判断当前登录用户
		List<Long> sellerIds = Lists.newArrayList();
		if(membInfo.getUserSourceType().equals("0") || membInfo.getUserSourceType().equals("1")){
			if(membInfo.getUserSourceType().equals("0")){
				//市场Id不能为空
				Assert.notNull(po.getMarketId(), "批发市场不能为空！");
			}else{
				//获取批发市场ID
				po.setMarketId(membInfo.getMarketId());
			}
			//查询出市场的所有商家
			List<MembInfo> sellers = wholeSaleMarketMageMapper.findMembIdByMarketId(po.getMarketId());
			sellerIds = sellers.stream().map(MembInfo::getId).collect(Collectors.toList());
			po.setSellerIds(sellerIds);

			Page<SettleBillPageListVo> page = po.getPage();
			List<SettleBillPageListVo> list = mapper.findReconcList(po);
			page.setList(list);
			resultPoJo.setResult(page);
		}else{
			//用户类型不正确
			resultPoJo.setCode(ConstantCodeMsg.ERR_401);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_401);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/18 15:03
	 * @Description 查询未出账订单列表
	 **/
	public ResultPoJo<List<SettleOrdRelaInfoVo>> findUnsettlementList(LongIdPo po) {
		LoggerUtil.infoWithContext("【findReconcList】查询对账异议列表：", po);
		ResultPoJo<List<SettleOrdRelaInfoVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(settleBill)){
			//根据买卖方ID查询未出账订单列表
			List<SettleOrdRelaInfoVo> list = orderInfoMapper.findUnsettlementList(settleBill.getSellerId(), settleBill.getBuyerId());
			resultPoJo.setResult(list);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/18 15:22
	 * @Description 处理对账异议
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> handleSissent(HandleSissentPo po) {
		LoggerUtil.infoWithContext("【handleSissent】处理对账异议：", po);
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(settleBill)){
			//查询结算单订单ID列表
			List<Long> oldOrdIds = settleOrdRelaMapper.selectOrdIdsBySettleId(settleBill.getId());
			List<Long> newOrdIds = po.getOrdIds();
			SettleBillGenerateTypePo typePo = new SettleBillGenerateTypePo();
			typePo.setOrdIds(oldOrdIds);
			typePo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_1);
			//将旧的订单全部置为未生成
			orderInfoMapper.updateSettleBillGenerateType(typePo);
			typePo.setOrdIds(newOrdIds);
			typePo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_0);
			//将新的订单全部置为已生成
			orderInfoMapper.updateSettleBillGenerateType(typePo);
			//删除结算单-订单中间表数据
			settleOrdRelaMapper.delBySettleId(settleBill.getId());


			//重新计算结算单信息
			List<OrderInfo> newOrders = orderInfoMapper.findOrderByIds(String.join(",", newOrdIds.stream().map(String::valueOf).collect(Collectors.toList())));
			//结算单订单数量
			settleBill.setOrdCount(newOrders.size());
			//结算单对账对账状态改为待双方对账
			settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_0);
			//重新计算对账截止日
			Integer reconcDeadlineDays = DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_5);
			OffsetDateTime reconDeadline = OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(reconcDeadlineDays));
			settleBill.setReconDeadline(reconDeadline);
			final Double[] ordAmountPayableCount = {0.0}; //订单总金额
			final Double[] shouldRefundAmountCount = {0.0}; //退款总金额
			final Double[] ordZqSerCostCount = {0.0}; //订单账期服务费总金额
			final Double[] refunZqSerCostCount = {0.0}; //应退账期服务费总金额
			final Double[] ordPlatfCostCount = {0.0}; //订单平台服务费总金额
			final Double[] refunPlatfCostCount = {0.0}; //应退平台服务费总金额

			//查询订单退款申请列表
			List<RefundAppl> refundCommAppls = refundApplMapper.findListByOrdIds(newOrdIds);

			Map<Long, Double> refundAmountMap = refundCommAppls.stream().collect(Collectors.toMap(RefundAppl::getOrdId, RefundAppl::getRefundAmount));

			//累加订单总金额
			newOrders.forEach(o->{
				ordAmountPayableCount[0] = ConverterUtil.add(ordAmountPayableCount[0], o.getPayableAmount());
				ordZqSerCostCount[0] = ConverterUtil.add(ordZqSerCostCount[0], o.getZqSerCost());
				ordPlatfCostCount[0] = ConverterUtil.add(ordPlatfCostCount[0], o.getPlatfCost());
			});
			//累加订单退款总金额
			refundCommAppls.forEach(r->{
				shouldRefundAmountCount[0] = ConverterUtil.add(shouldRefundAmountCount[0], r.getRefundAmount());
				refunZqSerCostCount[0] = ConverterUtil.add(refunZqSerCostCount[0], r.getRefundZqSerCost());
				refunPlatfCostCount[0] = ConverterUtil.add(refunPlatfCostCount[0], r.getRefundSerFee());
			});

			//设置应结金额 = 订单总金额 - 退款总金额
			settleBill.setTotalMoney(ConverterUtil.sub(ordAmountPayableCount[0], shouldRefundAmountCount[0]));
			settleBill.setPaymentSettleAmount(0D); //已支付金额
			settleBill.setPaymentLateFeeAmount(0D); //已支付滞纳金金额
			settleBill.setPaymentAmount(0D); //已支付总金额
			settleBill.setZqSerCost(ConverterUtil.sub(ordZqSerCostCount[0], refunZqSerCostCount[0])); //账期服务费 = 订单账期服务费总金额 - 应退账期服务费总金额
			settleBill.setCommAmount(ConverterUtil.sub(settleBill.getTotalMoney(), settleBill.getZqSerCost())); //结算单商品金额 = 应结金额 - 账期服务费
			settleBill.setPlatfCost(ConverterUtil.sub(ordPlatfCostCount[0], refunPlatfCostCount[0])); //平台服务费 = 订单平台服务费总金额 - 应退平台服务费总金额

			//批量插入结算单-订单关联表
			List<SettleOrdRela> settleOrdRelas = Lists.newArrayList();
			newOrders.forEach(e->{
				SettleOrdRela settleOrdRela = new SettleOrdRela();
				settleOrdRela.setSettleId(settleBill.getId());
				settleOrdRela.setOrdId(e.getId());
				settleOrdRela.setOrdNum(e.getOrdNum());
				settleOrdRela.setOrdAmount(e.getPayableAmount());
				settleOrdRela.setRefundAmount(ConverterUtil.isNotEmpty(refundAmountMap.get(e.getId())) ? refundAmountMap.get(e.getId()) : 0D);
				settleOrdRela.setAmount(ConverterUtil.sub(settleOrdRela.getOrdAmount(), settleOrdRela.getRefundAmount()));
				settleOrdRela.preInsert();
				settleOrdRelas.add(settleOrdRela);
			});
			if(settleOrdRelas.size() > 0){
				//批量插入结算单-订单关联表
				settleOrdRelaMapper.batchInsert(settleOrdRelas);
			}
			settleBill.preUpdate();
			//更新结算单信息
			mapper.updateByPrimaryKey(settleBill);
			Logger settleBillLogger = SettleBillLogger.getLogger(settleBill.getId());
			settleBillLogger.info("后台处理结算单对账异议，处理前订单列表为：{}，处理后订单列表为：{}，结算单信息为：{}", oldOrdIds, newOrdIds, settleBill);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

    /**
     * @Author jirg
     * @Date 2020/5/13 16:02
     * @Description 生成结算单定时任务
     **/
	@Transactional(readOnly = false)
	public ResultPoJo<List<SettleBill>> settleBillTask() {
		ResultPoJo<List<SettleBill>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		List<SettleBill> settleBills = Lists.newArrayList();
		OffsetDateTime nowDateTime = OffsetDateTime.now();
		Integer dayOfWeek = nowDateTime.getDayOfWeek().getValue();
		Integer dayOfMonth = nowDateTime.getDayOfMonth();
		//获取有效的账期支付设置列表
		List<ApPayMage> apPayMages = apPayMageMapper.findList(new ApPayMage());
		apPayMages.forEach(apPayMage -> {
			SettleBill settleBill = new SettleBill();
			settleBill.setBuyerId(apPayMage.getMembId());
			settleBill.setSellerId(apPayMage.getSellerId());
			settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_0);
			settleBill.setSettleCycleType(apPayMage.getSettleCycleType());
			settleBill.setBillDateType(apPayMage.getBillDateType());
			settleBill.setSettleBillPrdutType(DictConstants.SETTLE_BILL_PRDUT_TYPE_0);
			//滞纳金比例
			settleBill.setLateFeeBl(apPayMage.getOverdueLateFeeProp());
			//最晚付款期限（对账完成后）
			settleBill.setPayDeadDate(apPayMage.getPayDeadDate());

			if(apPayMage.getSettleCycleType().equals(DictConstants.SETTLE_CYCLE_TYPE_0) &&
					(Integer.valueOf(apPayMage.getBillDateType()) - 28) == dayOfWeek){
				//周结
                //获取上一周周日时间
                OffsetDateTime lastDayOfWeek = nowDateTime.plusWeeks(-1).with(WeekFields.ISO.dayOfWeek(), 7);
				settleBill.setSettleCycleEndDate(OffsetDateTimeUtils.getDayMaxTime(lastDayOfWeek));
				generateSettleBill(settleBill);
				settleBills.add(settleBill);
			}else if(apPayMage.getSettleCycleType().equals(DictConstants.SETTLE_CYCLE_TYPE_1) &&
					(Integer.valueOf(apPayMage.getBillDateType())) == dayOfMonth){
				//月结
				//获取上个月最后一天时间
				OffsetDateTime lastDayOfMonth = nowDateTime.plusMonths(-1).with(TemporalAdjusters.lastDayOfMonth());
				settleBill.setSettleCycleEndDate(OffsetDateTimeUtils.getDayMaxTime(lastDayOfMonth));
				generateSettleBill(settleBill);
				settleBills.add(settleBill);
			}else if(apPayMage.getSettleCycleType().equals("5")){
				//日结 - 测试使用
				settleBill.setSettleCycleEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));
				generateSettleBill(settleBill);
				settleBills.add(settleBill);
			}
		});
		//事物提交之后发送消息
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
			sendMessage(settleBills);
			}
		});
		resultPoJo.setResult(settleBills);
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/10/20 10:31
	 * @Description 发送消息
	 **/
	private void sendMessage(List<SettleBill> settleBills) {
		//事物提交之后发送消息
		Map<String, Object> param = Maps.newHashMap();
		settleBills.forEach(e->{
			param.put("timType", TIMNoticeConstants.TPL_KEY_RECON_TO_SALLER);
			param.put("id", e.getId());
			param.put("ordNum", e.getSettleBillNumb());
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					//发送给卖家
					param.put("userId", e.getSellerId());
					param.put("userType", "2");
					timSendService.sendTim(param);
					//发送给买家
					param.put("userId", e.getBuyerId());
					param.put("userType", "1");
					timSendService.sendTim(param);
				}
			});
		});
	}

	/**
	 * @Author jirg
	 * @Date 2019/4/23 18:36
	 * @Description 生成结算单
	 **/
	@Transactional(readOnly = false)
	public void generateSettleBill(SettleBill settleBill){
		//查询结算单周期内未结算的订单列表
		Map<String, Object> parameter = Maps.newHashMap();
		parameter.put("sellerId", settleBill.getSellerId());
		parameter.put("buyerId", settleBill.getBuyerId());
		parameter.put("endDate", settleBill.getSettleCycleEndDate());

		//查询普通订单列表
		List<OrderInfo> orderInfos = orderInfoMapper.findNotSettledOrds(parameter);

		if((ConverterUtil.isNotEmpty(orderInfos) && orderInfos.size() > 0)){
			//结算单订单数量
			settleBill.setOrdCount(orderInfos.size());
			//设置对账日
			settleBill.setRecoDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()));
			//对账状态 待双方对账
			settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_0);
			//设置对账截止日期限
			Integer reconcDeadlineDays = DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_5);
			OffsetDateTime reconDeadline = OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(reconcDeadlineDays));
			settleBill.setReconDeadline(reconDeadline);

			final Double[] ordAmountPayableCount = {0.0}; //订单总金额
			final Double[] shouldRefundAmountCount = {0.0}; //退款总金额
			final Double[] ordZqSerCostCount = {0.0}; //订单账期服务费总金额
			final Double[] refunZqSerCostCount = {0.0}; //应退账期服务费总金额
			final Double[] ordPlatfCostCount = {0.0}; //订单平台服务费总金额
			final Double[] refunPlatfCostCount = {0.0}; //应退平台服务费总金额

			List<Long> ordIdList = orderInfos.stream().map(e -> e.getId()).collect(Collectors.toList());

			//查询订单退款申请列表
			List<RefundAppl> refundCommAppls = refundApplMapper.findListByOrdIds(ordIdList);

			Map<Long, Double> refundAmountMap = refundCommAppls.stream().collect(Collectors.toMap(RefundAppl::getOrdId, RefundAppl::getRefundAmount));

			//累加订单总金额
			orderInfos.forEach(o->{
				ordAmountPayableCount[0] = ConverterUtil.add(ordAmountPayableCount[0], o.getPayableAmount());
				ordZqSerCostCount[0] = ConverterUtil.add(ordZqSerCostCount[0], o.getZqSerCost());
				ordPlatfCostCount[0] = ConverterUtil.add(ordPlatfCostCount[0], o.getPlatfCost());
			});
			//累加订单退款总金额
			refundCommAppls.forEach(r->{
				shouldRefundAmountCount[0] = ConverterUtil.add(shouldRefundAmountCount[0], r.getRefundAmount());
				refunZqSerCostCount[0] = ConverterUtil.add(refunZqSerCostCount[0], r.getRefundZqSerCost());
				refunPlatfCostCount[0] = ConverterUtil.add(refunPlatfCostCount[0], r.getRefundSerFee());
			});

			//设置应结金额 = 订单总金额 - 退款总金额
			settleBill.setTotalMoney(ConverterUtil.sub(ordAmountPayableCount[0], shouldRefundAmountCount[0]));
			settleBill.setPaymentSettleAmount(0D); //已支付金额
			settleBill.setPaymentLateFeeAmount(0D); //已支付滞纳金金额
			settleBill.setPaymentAmount(0D); //已支付总金额
			settleBill.setZqSerCost(ConverterUtil.sub(ordZqSerCostCount[0], refunZqSerCostCount[0])); //账期服务费 = 订单账期服务费总金额 - 应退账期服务费总金额
			settleBill.setCommAmount(ConverterUtil.sub(settleBill.getTotalMoney(), settleBill.getZqSerCost())); //结算单商品金额 = 应结金额 - 账期服务费
			settleBill.setPlatfCost(ConverterUtil.sub(ordPlatfCostCount[0], refunPlatfCostCount[0])); //平台服务费 = 订单平台服务费总金额 - 应退平台服务费总金额

			settleBill.setSettleBillNumb(CodeUtils.generateSettleBillCode());
			settleBill.preInsert();
			logger.info("生成结算单，结算单信息：{}", settleBill);
			mapper.insert(settleBill);
			//批量插入结算单-订单关联表
			List<SettleOrdRela> settleOrdRelas = Lists.newArrayList();
			orderInfos.forEach(e->{
				SettleOrdRela settleOrdRela = new SettleOrdRela();
				settleOrdRela.setSettleId(settleBill.getId());
				settleOrdRela.setOrdId(e.getId());
				settleOrdRela.setOrdNum(e.getOrdNum());
				settleOrdRela.setOrdAmount(e.getPayableAmount());
				settleOrdRela.setRefundAmount(ConverterUtil.isNotEmpty(refundAmountMap.get(e.getId())) ? refundAmountMap.get(e.getId()) : 0D);
				settleOrdRela.setAmount(ConverterUtil.sub(settleOrdRela.getOrdAmount(), settleOrdRela.getRefundAmount()));
				settleOrdRela.preInsert();
				settleOrdRelas.add(settleOrdRela);
			});
			if(settleOrdRelas.size() > 0){
				//批量插入结算单-订单关联表
				settleOrdRelaMapper.batchInsert(settleOrdRelas);
			}
			//更新订单结算单生成状态
			SettleBillGenerateTypePo updatePo = new SettleBillGenerateTypePo();
			updatePo.setOrdIds(ordIdList);
			updatePo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_0);
			orderInfoMapper.updateSettleBillGenerateType(updatePo);
			//插入结算单操作记录
			opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.SYSTEM_GENERATE, null);
			Logger logger = SettleBillLogger.getLogger(settleBill.getId());
			logger.info("系统生成结算单：{}", settleBill);
		}
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/20 15:01
	 * @Description 逾期结算单定时任务
	 */
	@Transactional(readOnly = false)
    public ResultPoJo<List<SettleBill>> overdueSettleBillTask() {
		ResultPoJo<List<SettleBill>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		//查询逾期的结算单列表
		OffsetDateTime deadline = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now());
		List<SettleBill> list = mapper.findOverdueSettleBill(deadline);
		list.forEach(e -> {
			//设置为逾期
			e.setSfYqFlag(DictConstants.SF_YQ_FLAG_0);
			//计算逾期滞纳金
			if (ConverterUtil.isNotEmpty(e.getLateFeeBl()) && e.getLateFeeBl() > 0) {
				//逾期的天数
				long overdueDays = e.getLastPayDate().until(deadline, ChronoUnit.DAYS) + 1;
				//计算滞纳金  滞纳金 = 剩余结算单金额 * 滞纳金比例 * 逾期天数
				//剩余结算单金额
				double remainSettleAmount = ConverterUtil.sub(e.getTotalMoney(), e.getPaymentSettleAmount());
				if(remainSettleAmount > 0){
					double lateFee = ConverterUtil.getRoundValue(ConverterUtil.mul(ConverterUtil.mul(remainSettleAmount, ConverterUtil.div(e.getLateFeeBl(), 100, 4)), overdueDays), 2);
					logger.info("结算单编号为【{}】已逾期【{}】天，产生的滞纳金为：{}", e.getSettleBillNumb(), overdueDays, lateFee);
					e.setLateFee(lateFee);
					Logger settleBillLogger = SettleBillLogger.getLogger(e.getId());
					settleBillLogger.info("结算单已逾期【{}】天，产生的滞纳金为：{}", overdueDays, lateFee);

					//事物提交之后发送消息
					Map<String, Object> param = Maps.newHashMap();
					param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_BUYER);
					param.put("id", e.getId());
					param.put("userId", e.getBuyerId());
					param.put("ordNum", e.getSettleBillNumb());
					param.put("lateFee", lateFee);
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							//向买家发送消息
							timSendService.sendTim(param);
							//向卖家发送消息
							MembBaseInfo membInfoByUserId = MembUtils.getMembInfoByUserId(e.getBuyerId());
							param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_OVERDUE_REMINDER_TO_SALLER);
							param.put("userId", e.getSellerId());
							param.put("buyerName", membInfoByUserId.getAuthName());
							timSendService.sendTim(param);
						}
					});
				}else{
					e.setSfYqFlag(DictConstants.SF_YQ_FLAG_1);
				}
			} else {
				e.setLateFee(0D);
			}
			mapper.batchUpdate(list);
		});
		resultPoJo.setResult(list);
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/20 15:01
	 * @Description 取消结算单定时任务
	 * 				取消结算单有两种条件：
	 * 					1. 当前时间超过开票截止日 并且 （发票状态为待开票 或 （发票状态为待验票 并且 验票异议状态为有异议））
	 * 					2. 结算单第一次支付时间超过29天 并且 结算单状态为待结算
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<List<SettleBill>> cancelSettleBillTask() {
		ResultPoJo<List<SettleBill>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		//查询需取消结算单列表
		OffsetDateTime deadline = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now());
		List<SettleBill> list = mapper.findTimeOutInvoicingSettleBill(deadline);
		list.forEach(e->{
			//设置结算单状态为已取消
			e.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_3);
			e.preUpdate();
			mapper.updateByPrimaryKey(e);

			//查询结算单订单ID列表
			List<Long> ordIds = settleOrdRelaMapper.selectOrdIdsBySettleId(e.getId());
			SettleBillGenerateTypePo typePo = new SettleBillGenerateTypePo();
			typePo.setOrdIds(ordIds);
			typePo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_1);
			//将订单结算单生成状态 全部置为未生成
			orderInfoMapper.updateSettleBillGenerateType(typePo);

			//原路返还已支付的金额
			YsPayUtils.settleRefund(e);
			Logger settleBillLogger = SettleBillLogger.getLogger(e.getId());
			settleBillLogger.info("结算单已取消，结算单下订单的结算单生成状态已置为【未生成】。订单为[{}]", ordIds);
		});
		resultPoJo.setResult(list);
		return resultPoJo;
	}

	/**************************************买家开始*******************************************************/
	/**
	 * 买家查询账期列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<BuyerSettleBillListVo>> buyerSettlList (BuyerSettleBillListPo po) {
	    ResultPoJo<Page<BuyerSettleBillListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
	    //查询不是逾期状态
	    if (DictConstants.SETTLE_BILL_STATUE_TYPE_0.equals(po.getSettleBillStatueType()) ||
				DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(po.getSettleBillStatueType())) {
	    	po.setSfYqChaxun("0");
		}
	    //设置用户
	    po.setBuyerId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
	    Page<BuyerSettleBillListVo> page = po.getPage();
	    List<BuyerSettleBillListVo> buyerSettleList = mapper.buyerSettleList(po);
	    //判断逾期多少天
        buyerSettleList.forEach(e -> {

            e.setDeadLineDay(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_5));
            if (DictConstants.SF_YQ_FLAG_0.equals(e.getSfYqFlag()) &&
					DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(e.getSettleBillStatueType())) {

				e.setYuqiDay(e.getLastPayDate().until(OffsetDateTime.now(),ChronoUnit.DAYS));
			}else if (!DictConstants.SF_YQ_FLAG_0.equals(e.getSfYqFlag()) &&
					DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(e.getSettleBillStatueType()) && e.getLastPayDate() != null) {

				e.setJyYuqiDay(OffsetDateTimeUtils.getDifferenceDayes(e.getNowData(), e.getLastPayDate())+1);
			}
            e.setTotalAllMoney(ConverterUtil.add(e.getTotalMoney(), e.getLateFee() != null? e.getLateFee():0D));
        });
	    page.setList(buyerSettleList);
	    resultPoJo.setResult(page);
	    return resultPoJo;
	}

	/**
	 * 买家查询结算单列表角标
	 * @param po
	 * @return
	 */
	public ResultPoJo<List<OrderListNumVo>> buyerSettleListNum (BuyerSettleBillListPo po) {
	    ResultPoJo<List<OrderListNumVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<OrderListNumVo> list = Lists.newArrayList();
		po.setBuyerId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        SettleBillCountVo buyerNum = mapper.buyerSettleListNum(po);
        //待对账
        OrderListNumVo orderListNumVo1 = new OrderListNumVo();
        orderListNumVo1.setKey("0");
        //待结算
        OrderListNumVo orderListNumVo2 = new OrderListNumVo();
        orderListNumVo2.setKey("1");
        //预期
        OrderListNumVo orderListNumVo3 = new OrderListNumVo();
        orderListNumVo3.setKey("2");
        if (buyerNum != null) {
			orderListNumVo1.setCount(buyerNum.getRecoCount().toString());
			orderListNumVo2.setCount(buyerNum.getSettledCount().toString());
			orderListNumVo3.setCount(buyerNum.getOverdue().toString());
		}

        list.add(orderListNumVo1);
        list.add(orderListNumVo2);
        list.add(orderListNumVo3);
        resultPoJo.setResult(list);
        return resultPoJo;
	}

	 /**
     * 授权账期列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<BuyerApPayMageListVo>> apPayMageSupplyList (BuyerApPayListPo po) {
        ResultPoJo<Page<BuyerApPayMageListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        po.setMembId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        Page<BuyerApPayMageListVo> page = po.getPage();
        List<BuyerApPayMageListVo> buyerApList = apPayMageMapper.buyerSelApPayList(po);
        page.setList(buyerApList);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 买家查询未出账单列表
     * @param po
     * @return
     */
    public ResultPoJo<List<BuyerNotSettleListVo>> buyerNotSettleList (BuyerNotSettleListPo po) {
        ResultPoJo<List<BuyerNotSettleListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //设置用户
        po.setBuyerId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        List<BuyerNotSettleListVo> buyerNotSettleList = orderInfoMapper.buyerNotSettleList(po);
        //设置总金额
        buyerNotSettleList.forEach(e -> {
            Double totalAmont = 0D;
            for (SettleOrdRelaInfoVo t : e.getSettleOrdList()) {

                totalAmont = ConverterUtil.add(t.getAmount(), totalAmont);
            }
            e.setTotalAmont(totalAmont);
        });
        resultPoJo.setResult(buyerNotSettleList);
        return resultPoJo;
    }

    /**
     * 买家对账
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> recoSettleBill (InvoApplPo po) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取账期详情
        SettleBill settleBill = mapper.selectByPrimaryKey(po.getOrdId());
        //校验是否主账户、管理员
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getMembId().equals(settleBill.getBuyerId()) &&
                !(membInfo.getMembId().equals(settleBill.getBuyerId()) && membInfo.getPurSfAdminFlag().equals("0"))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //校验账期状态
        if (!DictConstants.SETTLE_BILL_STATUE_TYPE_0.equals(settleBill.getSettleBillStatueType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
            return resultPoJo;
        }
        //校验账期对账状态
        //设置账期信息
        if (DictConstants.RECON_STATE_TYPE_0.equals(settleBill.getReconStateType())) {

            settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_2);
        }else if (DictConstants.RECON_STATE_TYPE_1.equals(settleBill.getReconStateType())) {

            settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_4);
            settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_1);
            settleBill.setLastPayDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).plusDays(settleBill.getPayDeadDate()));

			//事物提交之后发送消息
			Map<String, Object> param = Maps.newHashMap();
			param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_TO_BUYER);
			param.put("id", settleBill.getId());
			param.put("userId", settleBill.getBuyerId());
			param.put("ordNum", settleBill.getSettleBillNumb());
			param.put("lastPayDate", settleBill.getLastPayDate().format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss")));
			param.put("totalMoney", settleBill.getTotalMoney());
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					//向买家发送消息
					timSendService.sendTim(param);
					//判断是否申请开票
					if(ConverterUtil.isNotEmpty(po.getInvoId())){
						//发送卖家开票信息
						MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(settleBill.getBuyerId());
						param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_TO_BE_INVOICED);
						param.put("userId", settleBill.getSellerId());
						param.put("buyerName", membInfo.getAuthName());
						timSendService.sendTim(param);
					}
				}
			});
        } else {

            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
            return resultPoJo;
        }
        //判断是否有发票
        if (ConverterUtil.isNotEmpty(po.getInvoId())) {
            //设置开票截止日
            settleBill.setOpenBillDeadline(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).
                    plusDays(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_6)));
            //设置账期发票信息
            SettleBillInvo settleBillInvo = new SettleBillInvo();
            //查询发票信息
            InvoInfo invoInfo = invoInfoMapper.selectByPrimaryKey(po.getInvoId());
            ConverterUtil.copyProperties(invoInfo, settleBillInvo);
            settleBillInvo.setEntpId(settleBill.getSellerId());
            settleBillInvo.setSettleId(settleBill.getId());
            settleBillInvo.setReceName(po.getReceName());
            settleBillInvo.setAddressProv(po.getAddressProv());
            settleBillInvo.setAddressCity(po.getAddressCity());
            settleBillInvo.setAddressCou(po.getAddressCou());
            settleBillInvo.setAddressDetail(po.getAddressDetail());
            settleBillInvo.setApplDate(OffsetDateTime.now());
            settleBillInvo.setDrawAmount(settleBill.getCommAmount());
            settleBillInvo.setInvoState(DictConstants.INVO_STATE_0);
            settleBillInvo.setApplRemarks(po.getRemake());
            settleBillInvo.preInsert();
            settleBillInvoMapper.insertSelective(settleBillInvo);
        }
        settleBill.preUpdate();
        mapper.updateByPrimaryKeySelective(settleBill);
        opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.BUYER_RECON, null);
        return resultPoJo;
    }

	/**
	 * 买家对账校验
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> recoSettleBillCheck (InvoApplPo po) {
		ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		//获取账期详情
		SettleBill settleBill = mapper.selectByPrimaryKey(po.getOrdId());
		//校验是否主账户、管理员
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
		if (!membInfo.getMembId().equals(settleBill.getBuyerId()) &&
				!(membInfo.getMembId().equals(settleBill.getBuyerId()) && membInfo.getPurSfAdminFlag().equals("0"))) {

			resultPoJo.setCode(ConstantCodeMsg.ERR_455);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
			return resultPoJo;
		}
		//校验账期状态
		if (!DictConstants.SETTLE_BILL_STATUE_TYPE_0.equals(settleBill.getSettleBillStatueType())) {

			resultPoJo.setCode(ConstantCodeMsg.ERR_459);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
			return resultPoJo;
		}
		//校验账期对账状态
		if (!DictConstants.RECON_STATE_TYPE_0.equals(settleBill.getReconStateType()) &&
				!DictConstants.RECON_STATE_TYPE_1.equals(settleBill.getReconStateType())) {
			resultPoJo.setCode(ConstantCodeMsg.ERR_459);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
			return resultPoJo;
		}
		return resultPoJo;
	}

    /**
     * 对账异议
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> reconDissent (LongIdPo po) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取结算单详情
        SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
        //校验是否主账户、管理员
//        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
//        if (!membInfo.getMembId().equals(settleBill.getBuyerId()) &&
//                !(membInfo.getMembId().equals(settleBill.getBuyerId()) && membInfo.getPurSfAdminFlag().equals("0"))) {
//
//            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
//            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
//            return resultPoJo;
//        }
        //校验结算单状态
        if (DictConstants.SETTLE_BILL_STATUE_TYPE_0.equals(settleBill.getSettleBillStatueType())) {
			settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_3);
			settleBill.preUpdate();
			mapper.updateByPrimaryKeySelective(settleBill);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
		}
		return resultPoJo;
    }

    /**
     * 查询发票详情
     * @param po
     * @return
     */
    public ResultPoJo<SettleBillInvoInfoVo> settleInvoInfo (LongIdPo po) {
        ResultPoJo<SettleBillInvoInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        SettleBillInvoInfoVo findInfo = settleBillInvoMapper.findInfo(po);
        resultPoJo.setResult(findInfo);
        return resultPoJo;
    }

	/**
	 * 买家提前生成结算单校验
	 * @param po
	 * @return
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<Object> preSettleCheck (PreSettleApplPo po) {
		ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		//循环获取所有订单信息
		List<Long> ids = po.getIds();
		Long sellerId = null;
		Long buyerId = null;
		//构造订单列表，用于插入账期订单关联表
		List<BuyerOrdRefundInfoVo> orderInfos = Lists.newArrayList();
		for (Long ordId : ids) {
			//订单信息
			BuyerOrdRefundInfoVo orderInfo = orderInfoMapper.findOrdRefundInfo(ordId);
			//判断所选订单是否是同一个商家
			if (sellerId == null) {

				sellerId = orderInfo.getSellerId();
			}
			if (buyerId == null) {

				buyerId = orderInfo.getBuyerId();
			}
			if (sellerId != null && !orderInfo.getSellerId().equals(sellerId)) {

				resultPoJo.setCode(ConstantCodeMsg.ERR_458);
				resultPoJo.setMsg("所选订单不属于同一个商家！");
				return resultPoJo;
			}
			if (buyerId != null && !orderInfo.getBuyerId().equals(buyerId)) {

				resultPoJo.setCode(ConstantCodeMsg.ERR_458);
				resultPoJo.setMsg("所选订单不属于同一个买家！");
				return resultPoJo;
			}
			//判断订单状态是否已完成
			if (!DictConstants.ORDER_STATE_TYPE_4.equals(orderInfo.getOrderStateType())) {

				resultPoJo.setCode(ConstantCodeMsg.ERR_458);
				resultPoJo.setMsg("存在未完成的订单！");
				return resultPoJo;
			}
			//判断订单是否已经结算
			if (DictConstants.SETTLE_BILL_GENERATE_TYPE_0.equals(orderInfo.getSettleBillGenerateType())) {

				resultPoJo.setCode(ConstantCodeMsg.ERR_458);
				resultPoJo.setMsg("存在已经生成结算单的订单！");
				return resultPoJo;
			}
			orderInfos.add(orderInfo);
		}
		//校验是否主账户、管理员
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
		if (!membInfo.getMembId().equals(buyerId) &&
				!(membInfo.getMembId().equals(buyerId) && membInfo.getPurSfAdminFlag().equals("0"))) {

			resultPoJo.setCode(ConstantCodeMsg.ERR_455);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
			return resultPoJo;
		}
		return resultPoJo;
	}

    /**
     * 买家提前生成结算单
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> preSettle (PreSettleApplPo po) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //循环获取所有订单信息
        List<Long> ids = po.getIds();
        Long sellerId = null;
        Long buyerId = null;
        Double payableAmount = 0D; //订单总金额
        Double shouldRefundAmount = 0D; //退款总金额
        Double ordZqSerCost = 0D; //订单账期服务费总金额
        Double refunZqSerCost = 0D; //应退账期服务费总金额
        Double ordPlatfCost = 0D; //订单平台服务费总金额
        Double refunPlatfCost = 0D;//应退平台服务费总金额
        //构造订单列表，用于插入账期订单关联表
        List<BuyerOrdRefundInfoVo> orderInfos = Lists.newArrayList();
        for (Long ordId : ids) {
            //订单信息
            BuyerOrdRefundInfoVo orderInfo = orderInfoMapper.findOrdRefundInfo(ordId);
            //判断所选订单是否是同一个商家
            if (sellerId == null) {

                sellerId = orderInfo.getSellerId();
            }
            if (buyerId == null) {

                buyerId = orderInfo.getBuyerId();
            }
            if (sellerId != null && !orderInfo.getSellerId().equals(sellerId)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("所选订单不属于同一个商家！");
                return resultPoJo;
            }
            if (buyerId != null && !orderInfo.getBuyerId().equals(buyerId)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("所选订单不属于同一个买家！");
                return resultPoJo;
            }
            //判断订单状态是否已完成
            if (!DictConstants.ORDER_STATE_TYPE_4.equals(orderInfo.getOrderStateType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("存在未完成的订单！");
                return resultPoJo;
            }
            //判断订单是否已经结算
            if (DictConstants.SETTLE_BILL_GENERATE_TYPE_0.equals(orderInfo.getSettleBillGenerateType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("存在已经生成结算单的订单！");
                return resultPoJo;
            }
            orderInfos.add(orderInfo);
            //设置金额
            payableAmount = ConverterUtil.add(payableAmount, orderInfo.getPayableAmount());
            shouldRefundAmount = ConverterUtil.add(shouldRefundAmount, orderInfo.getRefundAmount());
            ordZqSerCost = ConverterUtil.add(ordZqSerCost, orderInfo.getZqSerCost());
            refunZqSerCost = ConverterUtil.add(refunZqSerCost, orderInfo.getRefundZqSerCost());
            ordPlatfCost = ConverterUtil.add(ordPlatfCost, orderInfo.getPlatfCost());
            refunPlatfCost = ConverterUtil.add(refunPlatfCost, orderInfo.getRefundSerFee());
        }
        //校验是否主账户、管理员
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getMembId().equals(buyerId) &&
                !(membInfo.getMembId().equals(buyerId) && membInfo.getPurSfAdminFlag().equals("0"))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //获取结算单设置
        ApPayMage apPayMage = apPayMageMapper.findByIds(sellerId, buyerId);
        //设置结算单信息
        SettleBill settleBill = new SettleBill();
        settleBill.setBuyerId(apPayMage.getMembId());
        settleBill.setSellerId(apPayMage.getSellerId());
        settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_0);
        settleBill.setSettleCycleType(apPayMage.getSettleCycleType());
        settleBill.setBillDateType(apPayMage.getBillDateType());
        settleBill.setSettleBillPrdutType(DictConstants.SETTLE_BILL_PRDUT_TYPE_1);
        //滞纳金比例
        settleBill.setLateFeeBl(apPayMage.getOverdueLateFeeProp());
        //最晚付款期限（对账完成后）
        settleBill.setPayDeadDate(apPayMage.getPayDeadDate());
        //获取日期
        OffsetDateTime nowDateTime = OffsetDateTime.now();
        Integer dayOfWeek = nowDateTime.getDayOfWeek().getValue();
        Integer dayOfMonth = nowDateTime.getDayOfMonth();
        if(apPayMage.getSettleCycleType().equals(DictConstants.SETTLE_CYCLE_TYPE_0) &&
                (Integer.valueOf(apPayMage.getBillDateType()) - 28) == dayOfWeek){
            //周结
            //获取上一周周日时间
            OffsetDateTime lastDayOfWeek = nowDateTime.plusWeeks(-1).with(WeekFields.ISO.dayOfWeek(), 7);
            settleBill.setSettleCycleEndDate(OffsetDateTimeUtils.getDayMaxTime(lastDayOfWeek));
        }else if(apPayMage.getSettleCycleType().equals(DictConstants.SETTLE_CYCLE_TYPE_1) &&
                (Integer.valueOf(apPayMage.getBillDateType())) == dayOfMonth){
            //月结
            //获取上个月最后一天时间
            OffsetDateTime lastDayOfMonth = nowDateTime.plusMonths(-1).with(TemporalAdjusters.lastDayOfMonth());
            settleBill.setSettleCycleEndDate(OffsetDateTimeUtils.getDayMaxTime(lastDayOfMonth));
        }else{
            //日结 - 测试使用
            settleBill.setSettleCycleEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));
        }
        //结算单订单数量
        settleBill.setOrdCount(ids.size());
        //设置对账日
        settleBill.setRecoDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now()));
        //对账状态 待卖家
        settleBill.setReconStateType(DictConstants.RECON_STATE_TYPE_2);
        //设置对账截止日期限
        Integer reconcDeadlineDays = DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_5);
        OffsetDateTime reconDeadline = OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(reconcDeadlineDays));
        settleBill.setReconDeadline(reconDeadline);
        //设置应结金额 = 订单总金额 - 退款总金额
        settleBill.setTotalMoney(ConverterUtil.sub(payableAmount, shouldRefundAmount));
        settleBill.setPaymentSettleAmount(0D); //已支付金额
        settleBill.setPaymentLateFeeAmount(0D); //已支付滞纳金金额
        settleBill.setPaymentAmount(0D); //已支付总金额
        //账期服务费 = 订单账期服务费总金额 - 应退账期服务费总金额
        settleBill.setZqSerCost(ConverterUtil.sub(ordZqSerCost, refunZqSerCost));
        //结算单商品金额 = 应结金额 - 账期服务费
        settleBill.setCommAmount(ConverterUtil.sub(settleBill.getTotalMoney(), settleBill.getZqSerCost()));
        //平台服务费 = 订单平台服务费总金额 - 应退平台服务费总金额
        settleBill.setPlatfCost(ConverterUtil.sub(ordPlatfCost, refunPlatfCost));
        settleBill.setSettleBillNumb(CodeUtils.generateSettleBillCode());
        settleBill.preInsert();
        //设置账期发票
        if (ConverterUtil.isNotEmpty(po.getInvoId())) {
            //设置开票截止日
            settleBill.setOpenBillDeadline(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).
                    plusDays(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_6)));
            //设置账期发票信息
            SettleBillInvo settleBillInvo = new SettleBillInvo();
            //查询发票信息
            InvoInfo invoInfo = invoInfoMapper.selectByPrimaryKey(po.getInvoId());
            ConverterUtil.copyProperties(invoInfo, settleBillInvo);
            settleBillInvo.setEntpId(settleBill.getSellerId());
            settleBillInvo.setSettleId(settleBill.getId());
			settleBillInvo.setApplNum(CodeUtils.generateSettleInvoCode());
            settleBillInvo.setReceName(po.getReceName());
            settleBillInvo.setAddressProv(po.getAddressProv());
            settleBillInvo.setAddressCity(po.getAddressCity());
            settleBillInvo.setAddressCou(po.getAddressCou());
            settleBillInvo.setAddressDetail(po.getAddressDetail());
            settleBillInvo.setApplDate(OffsetDateTime.now());
            settleBillInvo.setDrawAmount(settleBill.getCommAmount());
            settleBillInvo.setInvoState(DictConstants.INVO_STATE_0);
            settleBillInvo.setApplRemarks(po.getRemake());
            settleBillInvo.preInsert();
            settleBillInvoMapper.insertSelective(settleBillInvo);
        }

        //保存结算单
        mapper.insertSelective(settleBill);

        //批量插入结算单-订单关联表
        List<SettleOrdRela> settleOrdRelas = Lists.newArrayList();
        orderInfos.forEach(e->{
            SettleOrdRela settleOrdRela = new SettleOrdRela();
            settleOrdRela.setSettleId(settleBill.getId());
            settleOrdRela.setOrdId(e.getId());
            settleOrdRela.setOrdNum(e.getOrdNum());
            settleOrdRela.setOrdAmount(e.getPayableAmount());
            settleOrdRela.setRefundAmount(e.getRefundAmount());
            settleOrdRela.setAmount(ConverterUtil.sub(settleOrdRela.getOrdAmount(), settleOrdRela.getRefundAmount()));
            settleOrdRela.preInsert();
            settleOrdRelas.add(settleOrdRela);
        });
        if(settleOrdRelas.size() > 0){
            //批量插入结算单-订单关联表
            settleOrdRelaMapper.batchInsert(settleOrdRelas);
        }
        //更新订单结算单生成状态
        SettleBillGenerateTypePo updatePo = new SettleBillGenerateTypePo();
        updatePo.setOrdIds(ids);
        updatePo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_0);
        orderInfoMapper.updateSettleBillGenerateType(updatePo);
        //插入结算单操作记录
        opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.BUYER_GENERATE, null);
        opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.BUYER_RECON, null);
        return resultPoJo;
    }

    /**
     * 账期去支付详情页
     * @param po
     * @return
     */
    public ResultPoJo<ToPaySettleInfoVo> settlePayInfo (LongIdPo po) {
        ResultPoJo<ToPaySettleInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //查询账期信息
        SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
        //判断账期状态
        if (!DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(settleBill.getSettleBillStatueType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
            return resultPoJo;
        }
        //构造返回值
        ToPaySettleInfoVo vo = new ToPaySettleInfoVo();
        //剩余结算金额
        Double nowPayAmount = 0D;
        //剩余滞纳金金额
        Double lateFeAmount = 0D;
        //本次最小支付金额
        Double smartAmount = 0D;
        //较上次逾期天数
        long lateDay = 0;
        //判断是否逾期
        if (DictConstants.SF_YQ_FLAG_0.equals(settleBill.getSfYqFlag()) && ConverterUtil.isNotEmpty(settleBill.getLateFee())) {

            nowPayAmount = settleBill.getLateFee();
            lateFeAmount = settleBill.getLateFee();
            smartAmount = settleBill.getLateFee();
            //逾期天数=当前日期-最晚付款日期
            lateDay = OffsetDateTimeUtils.getDifferenceDayes(OffsetDateTimeUtils.getDayMaxTime(settleBill.getLastPayDate()),
                    OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));
        }
        //判断是否支付过
        if (settleBill.getPaymentAmount() != null && settleBill.getPaymentAmount() > 0) {
            //支付过，则剩余应付金额=总金额-已付总金额+滞纳金
            nowPayAmount = ConverterUtil.add(ConverterUtil.sub(settleBill.getTotalMoney(), settleBill.getPaymentAmount()), nowPayAmount);
            //剩余滞纳金=滞纳金-支付过滞纳金
            if (ConverterUtil.isNotEmpty(settleBill.getPaymentLateFeeAmount())) {
                //有可能是当前逾期，上次支付时不逾期，所以判断是否支付过滞纳金
                lateFeAmount =  ConverterUtil.sub(lateFeAmount, settleBill.getPaymentLateFeeAmount());
                //逾期天数=当前日期-上次支付日期
                lateDay = OffsetDateTimeUtils.getDifferenceDayes(OffsetDateTimeUtils.getDayMaxTime(settleBill.getPrevPayDate()),
                        OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));
            }
            //最小结算金额=剩余滞纳金
            smartAmount = lateFeAmount;
        }else {
            //未支付过
            nowPayAmount = ConverterUtil.add(settleBill.getTotalMoney(), nowPayAmount);
            //最小结算金额=账期服务费+平台服务费+逾期滞纳金
            smartAmount = ConverterUtil.add(ConverterUtil.add(settleBill.getZqSerCost(), settleBill.getPlatfCost()), smartAmount);
        }
        //校验剩余应结金额
        if (nowPayAmount <= 0) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg("剩余支付金额小于或等于0");
            return resultPoJo;
        }
        ConverterUtil.copyProperties(settleBill, vo);
        //查询商家名称
		MembBaseInfo sellerMem = MembUtils.getMembInfoByUserId(settleBill.getSellerId());
        vo.setNowPayAmount(nowPayAmount);
		vo.setEntpName(sellerMem.getAuthName());
        vo.setLateFeAmount(lateFeAmount);
        vo.setSmartAmount(smartAmount);
        vo.setLateDay(ConverterUtil.toInteger(lateDay));
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 验票
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> examSettleInvo (LongIdPo po) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取结算单详情
        SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
        //校验是否主账户、管理员
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getMembId().equals(settleBill.getBuyerId()) &&
                !(membInfo.getMembId().equals(settleBill.getBuyerId()) && membInfo.getPurSfAdminFlag().equals("0"))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //查询发票详情
		LongIdPo longPo = new LongIdPo();
		longPo.setId(po.getId());
        SettleBillInvoInfoVo invo = settleBillInvoMapper.findInfoBySettId(longPo);
        //校验发票状态
        if (!DictConstants.INVO_STATE_1.equals(invo.getInvoState())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
            return resultPoJo;
        }
		if (!DictConstants.EXAM_INVO_DISS_TYPE_0.equals(invo.getExamInvoDissType())) {

			resultPoJo.setCode(ConstantCodeMsg.ERR_459);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
			return resultPoJo;
		}
        SettleBillInvo settleBillInvo = new SettleBillInvo();
        //将发票信息设置为已验票
        settleBillInvo.setInvoState(DictConstants.INVO_STATE_2);
        settleBillInvo.setId(invo.getId());
        settleBillInvo.preUpdate();
        settleBillInvoMapper.updateByPrimaryKeySelective(settleBillInvo);
		Double totalAmount = ConverterUtil.add(settleBill.getTotalMoney(), settleBill.getLateFee() != null? settleBill.getLateFee():0D);
        //如果待结算状态，并且支付完成，则成为已结算
		if (DictConstants.SETTLE_BILL_STATUE_TYPE_1.equals(settleBill.getSettleBillStatueType()) && totalAmount.equals(settleBill.getPaymentAmount())) {
			settleBill.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_2);
			settleBill.preUpdate();
			mapper.updateByPrimaryKeySelective(settleBill);
		}
        //插入结算单操作记录
        opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.INVO_PASS, null);
        //判断结算单是否支付过
        List<SettleBillPayRecord> settleRecordList = settleBillPayRecordMapper.findBySettleBillId(po.getId());
        if (settleRecordList != null && settleRecordList.size() > 0) {
            //将原来未分账的支付记录进行分账
            for (SettleBillPayRecord e : settleRecordList) {
                if (DictConstants.SUB_LED_FLAG_1.equals(e.getSubLedFlag())) {

                    divitInto(po.getId(), e.getSubLedInfo());
                    e.setSubLedFlag(DictConstants.SUB_LED_FLAG_0);
                    e.preUpdate();
                    settleBillPayRecordMapper.updateByPrimaryKeySelective(e);
                }
            }
        }
        return resultPoJo;
    }

    /**
     * 记录分账事件
     * @param
     */
    public void divitInto(Long settleId, String dividInfo) {
        //设置分账事件
        DivideEvent divideEvent = new DivideEvent();
        divideEvent.setOrdId(settleId.toString());
        divideEvent.setDivStartTime(OffsetDateTime.now());
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
     * 验票异议
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> settleDissent (ExamInvoDissPo po) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取结算单详情
        SettleBill settleBill = mapper.selectByPrimaryKey(po.getId());
        //校验是否主账户、管理员
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getMembId().equals(settleBill.getBuyerId()) &&
                !(membInfo.getMembId().equals(settleBill.getBuyerId()) && membInfo.getPurSfAdminFlag().equals("0"))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //查询发票详情
        LongIdPo longPo = new LongIdPo();
        longPo.setId(po.getId());
        SettleBillInvoInfoVo invo = settleBillInvoMapper.findInfoBySettId(longPo);
        //校验发票状态
        if (!DictConstants.INVO_STATE_1.equals(invo.getInvoState())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_459);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
            return resultPoJo;
        }
		if (!DictConstants.EXAM_INVO_DISS_TYPE_0.equals(invo.getExamInvoDissType())) {

			resultPoJo.setCode(ConstantCodeMsg.ERR_459);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_459);
			return resultPoJo;
		}
        SettleBillInvo settleBillInvo = new SettleBillInvo();
        //将发票信息设置为验票异议
        settleBillInvo.setId(invo.getId());
        settleBillInvo.setExamInvoDissType(DictConstants.EXAM_INVO_DISS_TYPE_1);
        settleBillInvo.setExamInvoDissRemarks(po.getExamInvoDissRemarks());
        settleBillInvo.preUpdate();
        settleBillInvoMapper.updateByPrimaryKeySelective(settleBillInvo);
        //插入结算单操作记录
        opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.INVO_DISSENT, po.getExamInvoDissRemarks());
        return resultPoJo;
    }

    /*************************************************结算单定时任务******************************************************/

    /**
     * 超时未对账定时任务
     * @return
     */
    public ResultPoJo<Object> findOutReconSettle () {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<SettleBill> settleList = mapper.findOutReconSettle();
        settleList.forEach(e -> {
            e.preUpdate();
            e.setSettleBillStatueType(DictConstants.SETTLE_BILL_STATUE_TYPE_1);
            e.setReconStateType(DictConstants.RECON_STATE_TYPE_4);
			e.setLastPayDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).plusDays(e.getPayDeadDate()));
            mapper.updateByPrimaryKeySelective(e);
            //插入结算单操作记录
            opreateInfoService.saveSettleBillOperate(e.getId(), SettleBillOperateEnum.OUTTIME_RECON, "超时自动对账");
        });
        return resultPoJo;
    }

    /**
     * 超时未验票定时任务
     * @return
     */
    public ResultPoJo<Object> findExamInvoSettle () {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<SettleBill> settleList = mapper.findExamInvoSettle();
        settleList.forEach(e -> {
            //查询发票详情
            LongIdPo longPo = new LongIdPo();
            longPo.setId(e.getId());
            SettleBillInvoInfoVo invo = settleBillInvoMapper.findInfo(longPo);
            //修改发票状态
            SettleBillInvo settleBillInvo = new SettleBillInvo();
            settleBillInvo.setId(invo.getId());
            settleBillInvo.setInvoState(DictConstants.INVO_STATE_2);
            settleBillInvo.preUpdate();
            settleBillInvoMapper.updateByPrimaryKeySelective(settleBillInvo);
            //判断结算单是否支付过
            List<SettleBillPayRecord> settleRecordList = settleBillPayRecordMapper.findBySettleBillId(e.getId());
            if (settleRecordList != null && settleRecordList.size() > 0) {
                //将原来未分账的支付记录进行分账
                for (SettleBillPayRecord t : settleRecordList) {
                    if (DictConstants.SUB_LED_FLAG_1.equals(t.getSubLedFlag())) {

                        divitInto(e.getId(), t.getSubLedInfo());
                        t.setSubLedFlag(DictConstants.SUB_LED_FLAG_0);
                        t.preUpdate();
                        settleBillPayRecordMapper.updateByPrimaryKeySelective(t);
                    }
                }
            }
            //插入结算单操作记录
            opreateInfoService.saveSettleBillOperate(e.getId(), SettleBillOperateEnum.OUTTIME_INVO_DISSENT, "超时自动验票");
        });
        return resultPoJo;
    }
}
