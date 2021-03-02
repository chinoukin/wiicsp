package com.wisea.transac.tp.trade.service;

import ch.qos.logback.classic.Logger;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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
import com.wisea.transac.common.dao.ApPayMageMapper;
import com.wisea.transac.common.dao.OrderInfoMapper;
import com.wisea.transac.common.dao.RefundApplMapper;
import com.wisea.transac.common.dao.WholeSaleMarketMageMapper;
import com.wisea.transac.common.po.RefundApplPageListPo;
import com.wisea.transac.common.po.trade.RefundApplHandlePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.utils.SellerMembUtils;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.RefundApplInfoVo;
import com.wisea.transac.common.vo.RefundApplPageListVo;
import com.wisea.transac.common.vo.StateTypeVo;
import com.wisea.transac.common.vo.trade.RefundHandleInfoVo;
import com.wisea.transac.tp.trade.constants.OrdOperateEnum;
import com.wisea.transac.tp.trade.constants.RefundOperateEnum;
import com.wisea.transac.tp.trade.utils.OrderLogger;
import com.wisea.transac.tp.trade.utils.YsPayUtils;
import com.wisea.transac.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className RefundApplService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class RefundApplService extends BaseService {
    @Autowired
    private RefundApplMapper mapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private ApPayMageMapper apPayMageMapper;
    @Autowired
    private RefundCommOperatorInfoService operatorInfoService;
	@Autowired
	private OrdOpreateInfoService ordOpreateService;
	@Autowired
	private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private TimSendService timSendService;

    /**
     * @Author jirg
     * @Date 2020/5/9 14:53
     * @Description 商家/市场 分页查询退款列表
     **/
    public ResultPoJo<PageStateCountResultVo<RefundApplPageListVo>> findPageList(RefundApplPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】商家/市场 分页查询退款列表：", po);
		ResultPoJo<PageStateCountResultVo<RefundApplPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		PageStateCountResultVo vo = new PageStateCountResultVo();
		po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
		po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));

		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		List<Long> sellerIds = Lists.newArrayList();
		//判断当前登录用户
		if(membInfo.getUserSourceType().equals("0") || membInfo.getUserSourceType().equals("1")){
			if(membInfo.getUserSourceType().equals("0")){
				//市场Id不能为空
				Assert.notNull(po.getMarketId(), "批发市场不能为空！");
			}else{
				//获取批发市场ID
				po.setMarketId(membInfo.getMembId());
			}
			po.setQueryUserFlag("0");
			//查询出市场的所有商家
			List<MembInfo> sellers = wholeSaleMarketMageMapper.findMembIdByMarketId(po.getMarketId());
			sellerIds = sellers.stream().map(MembInfo::getId).collect(Collectors.toList());
		}else{
			po.setQueryUserFlag("1");
			sellerIds.add(membInfo.getMembId());
			//判断用户是否选择了档口
			if(ConverterUtil.isEmpty(po.getStallsIds())){
				//设置当前登录用户所属档口
				po.setStallsIds(SellerMembUtils.getStallsIds(user.getId()));
			}
		}
		po.setSellerIds(sellerIds);

		Page<RefundApplPageListVo> page = po.getPage();

		if(po.getQueryUserFlag().equals("1")){
			Map<String, Integer> stateCountMap = Maps.newHashMap();
			//卖家查询订单列表
			LoggerUtil.infoWithContext("商家查询退款列表：", "");
			//查询各个订单状态下的数量
			po.setPage(null);
			List<StateTypeVo> typeVos = mapper.findCountByState(po);
			stateCountMap = typeVos.stream().collect(Collectors.toMap(StateTypeVo::getStateType, StateTypeVo::getCount));
			vo.setStateCountMap(stateCountMap);
			po.setPage(page);
		}
		List<RefundApplPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		vo.setPage(page);
		resultPoJo.setResult(vo);
		return resultPoJo;
    }

	/**
	 * @Author jirg
	 * @Date 2020/5/9 16:38
	 * @Description 查询退款详细信息
	 **/
	public ResultPoJo<RefundApplInfoVo> findInfo(LongIdPo po) {
		LoggerUtil.infoWithContext("【findInfo】查询退款详细信息：", po);
		ResultPoJo<RefundApplInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		RefundApplInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
//			if(!SellerMembUtils.checkStalls(vo.getStallsId())){
//				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
//				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
//				return resultPoJo;
//			}
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/11 9:37
	 * @Description 查询处理信息
	 **/
    public ResultPoJo<RefundHandleInfoVo> findRefundHandleInfo(LongIdPo po) {
		LoggerUtil.infoWithContext("【findRefundHandleInfo】查询处理信息：", po);
		ResultPoJo<RefundHandleInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		RefundHandleInfoVo vo = mapper.findRefundHandleInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			if(!SellerMembUtils.checkStalls(vo.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
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
     * @Date 2020/5/11 9:47
     * @Description 卖家退款处理
     **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> refundApplHandle(RefundApplHandlePo po) {
		LoggerUtil.infoWithContext("【refundApplHandle】卖家退款处理：", po);
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		RefundAppl refundAppl = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(refundAppl)){
			OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(refundAppl.getOrdId());
			if(!SellerMembUtils.checkStalls(orderInfo.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}
			if(refundAppl.getRefundApplStateType().equals(DictConstants.REFUND_APPL_STATE_TYPE_0)){
				refundAppl.setSellerOperatType(po.getSellerOperatType());
				Logger logger = OrderLogger.getLogger(orderInfo.getId());
				if(po.getSellerOperatType().equals(DictConstants.SELLER_OPERAT_TYPE_1)){
					//拒绝退款申请
					refundAppl.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_1);
					refundAppl.setHandleDate(OffsetDateTime.now());
					refundAppl.setSellerHandleRemarks(po.getOperatRemarks());
					//记录退款操作日志
					operatorInfoService.saveRefundOperate(refundAppl.getId(), RefundOperateEnum.REJECT, po.getOperatRemarks());
					//记录订单操作日志
					ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.REJECTCANCEL, po.getOperatRemarks());
					logger.info("【卖家】拒绝取消申请".concat(ConverterUtil.isNotEmpty(po.getOperatRemarks())? "，备注：".concat(po.getOperatRemarks()) : ""));
				}else{
					//同意退款申请
					refundAppl.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_2);
					refundAppl.setHandleDate(OffsetDateTime.now());
					refundAppl.setSellerHandleRemarks(po.getOperatRemarks());
					operatorInfoService.saveRefundOperate(refundAppl.getId(), RefundOperateEnum.ASSENT, po.getOperatRemarks());
					//判断订单支付方式
					if(orderInfo.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_0)){
						//订单在线支付，原路退款退款金额
						//下单即付，退款原路返回。
						ResultPoJo<Object> refundResult;
						try {
							refundResult = YsPayUtils.ysPayRefund(refundAppl);
						} catch (Exception ex) {
							throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, "第三方支付异常，请联系管理员"));
						}
						if(!refundResult.getCode().equals("20000")){
							throw new VerifyException(ConstantCodeMsg.ERR_409, MessageFormat.format(ConstantCodeMsg.MSG_409, refundResult.getMsg()));
						}
					}else if(orderInfo.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_1)){
						//返还账期支付可用额度
						ApPayMage apPayMage = apPayMageMapper.findByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
						apPayMage.setAvailableCredit(ConverterUtil.add(apPayMage.getAvailableCredit(), refundAppl.getRefundAmount()));
						apPayMageMapper.updateByPrimaryKey(apPayMage);
					}
					orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_5); //订单状态改为已取消
					orderInfo.setOrdCancelDate(OffsetDateTime.now()); //订单取消时间
					orderInfo.preUpdate();
					orderInfoMapper.updateByPrimaryKey(orderInfo);
					//记录订单操作日志
					ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.ASSENTCANCEL, po.getOperatRemarks());
					logger.info("【卖家】同意取消申请，订单已取消。订单信息{}", orderInfo);
					//退款订单商品库存
					orderInfoService.returnOrdCommStock(orderInfo.getId());
				}
				mapper.updateByPrimaryKey(refundAppl);

				//事物提交之后发送消息
				Map<String, Object> timMap = Maps.newHashMap();
                timMap.put("timType", TIMNoticeConstants.TPL_KEY_ORD_REFUND_SUC_TO_BUYER);
                timMap.put("id", refundAppl.getId());
                timMap.put("userId", orderInfo.getBuyerId());
                timMap.put("ordNum", refundAppl.getRefundNum());
                Map<String, Object> timMapb = Maps.newHashMap();
                timMapb.put("timType", TIMNoticeConstants.TPL_KEY_ORD_REFUND_FAL_TO_BUYER);
                timMapb.put("id", refundAppl.getId());
                timMapb.put("userId", orderInfo.getBuyerId());
                timMapb.put("ordNum", refundAppl.getRefundNum());
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						if(po.getSellerOperatType().equals(DictConstants.SELLER_OPERAT_TYPE_0)){
							//同意退款，发送消息给买家
							timSendService.sendTim(timMap);
						}else{
							//拒绝退款，发送消息给买家
							timSendService.sendTim(timMapb);
						}
					}
				});
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
}
