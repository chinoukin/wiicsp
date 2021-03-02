package com.wisea.transac.tp.trade.service;

import ch.qos.logback.classic.Logger;
import com.alibaba.druid.util.Base64;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.mss.RemoteFilesMss;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.SystemCacheService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.*;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.common.vo.FileVo;
import com.wisea.cloud.common.vo.UploadVo;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.po.RefundApplPo;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.product.BatchUpdSearchPo;
import com.wisea.transac.tp.trade.constants.OrdOperateEnum;
import com.wisea.transac.tp.trade.constants.RefundOperateEnum;
import com.wisea.transac.tp.trade.mss.ProductMss;
import com.wisea.transac.tp.trade.utils.OrderLogger;
import com.wisea.transac.tp.trade.utils.YsPayUtils;
import com.wisea.tpb.common.pay.entity.RefundRecord;
import com.wisea.tpb.common.utils.StringUtil;
import com.wisea.transac.common.dao.*;
import com.wisea.transac.common.entity.*;
import com.wisea.transac.common.po.trade.*;
import com.wisea.transac.common.utils.*;
import com.wisea.transac.common.vo.*;
import com.wisea.transac.common.vo.trade.*;
import com.wisea.yspay.request.DivideApiRequest;
import com.wisea.yspay.request.QueryPayRecordRequest;
import com.wisea.yspay.service.DivideApiService;
import com.wisea.yspay.service.PayApiService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className OrderInfoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class OrderInfoService extends BaseService {
    @Autowired
    private OrderInfoMapper mapper;
    @Autowired
    private OrdCommRelaMapper ordCommRelaMapper;
    @Autowired
    private StallsMageMapper stallsMageMapper;
	@Autowired
    private OrdOpreateInfoService ordOpreateService;
	@Autowired
	private SystemCacheService cacheService;
	@Autowired
	private RefundApplMapper refundApplMapper;
	@Autowired
	private OrdCommRefundRelaMapper commRefundRelaMapper;
	@Autowired
	private RefundCommOperatorInfoService refundOperatorInfoService;
	@Autowired
	private OrdInvoMapper ordInvoMapper;
	@Autowired
    private EleInvoFileMapper invoFileMapper;
	@Autowired
    private LocalityOrdInvoMapper localityOrdInvoMapper;
    @Autowired
    private LocalityEleInvoFileMapper localityEleInvoFileMapper;
	@Autowired
    private InvoInfoMapper invoInfoMapper;
	@Autowired
    private OrdCancelReasonMageMapper ordCancelReasonMageMapper;
	@Autowired
    private LevelSpecQuoteMapper levelSpecQuoteMapper;
	@Autowired
    private ApPayMageMapper apPayMageMapper;
	@Autowired
    private RefundCommOperatorInfoMapper refundOperatorMapper;
	@Autowired
	private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;
	@Autowired
    private SettleBillInvoMapper settleBillInvoMapper;
	@Autowired
	private SettleBillMapper settleBillMapper;
	@Autowired
    private MerchantMembMageMapper merchantMembMageMapper;
	@Autowired
    private TimSendService timSendService;
	@Autowired
    private DivideEventMapper divideEventMapper;
	@Autowired
    private DivideApiService divideApiService;
	@Autowired
    private IncomeDetailMapper incomeDetailMapper;
	@Autowired
    private ProductMss productMss;
	@Autowired
	private RemoteFilesMss remoteFilesMss;
	@Autowired
    private LocalityOrderInfoMapper localMapper;
	@Autowired
    private LocalityOrdOpreateInfoService localityOrdOpreateInfoService;
	@Autowired
	private LogisticsCompMageMapper logisticsCompMageMapper;
	@Autowired
	private PayApiService payApiService;

    /**
     * @Author jirg
     * @Date 2020/4/29 14:32
     * @Description 商家/市场查询订单列表
     **/
    public ResultPoJo<PageStateCountResultVo<MerchantOrderInfoListVo>> findMerchantOrderList(MerchantOrderInfoListPo po) {
		LoggerUtil.infoWithContext("【findMerchantOrderList】商家/市场查询订单列表：", po);
		ResultPoJo<PageStateCountResultVo<MerchantOrderInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
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
				po.setMarketId(membInfo.getMarketId());
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

		Page<MerchantOrderInfoListVo> page = po.getPage();

		if(po.getQueryUserFlag().equals("1")){
			Map<String, Integer> stateCountMap = Maps.newHashMap();
			//卖家查询订单列表
			LoggerUtil.infoWithContext("商家查询订单列表：", "");
			//查询各个订单状态下的数量
			po.setPage(null);
			List<StateTypeVo> typeVos = mapper.findCountByState(po);
			stateCountMap = typeVos.stream().collect(Collectors.toMap(StateTypeVo::getStateType, StateTypeVo::getCount));
			vo.setStateCountMap(stateCountMap);
			po.setPage(page);
		}
		List<MerchantOrderInfoListVo> list = mapper.findMerchantOrderList(po);
		page.setList(list);
		vo.setPage(page);
		resultPoJo.setResult(vo);
		return resultPoJo;
    }

	/**
	 * 查询订单详细信息
	 * @param po
	 * @return
	 */
	public ResultPoJo<OrderInfoVo> findOrderInfo(OrderInfoPo po) {
		LoggerUtil.infoWithContext("【findOrderInfo】查询订单详细信息：", po);
		ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfoVo vo = mapper.findOrderInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			vo.setNowDateTime(OffsetDateTime.now());
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/6/9 16:52
	 * @Description 卖家/买家查询提货信息详情
	 */
	public ResultPoJo<DeliveryInfoVo> findDeliveryInfo(LongIdPo po) {
		LoggerUtil.infoWithContext("【findDeliveryInfo】卖家/买家查询提货信息详情：", po);
		ResultPoJo<DeliveryInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		DeliveryInfoVo vo = mapper.findDeliveryInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/6 15:20
	 * @Description 卖家/买家修改提货信息
	 **/
	@Transactional(readOnly = false)
    public ResultPoJo<?> updateDelivery(UpdateDeliveryPo po) {
		LoggerUtil.infoWithContext("【updateDelivery】修改提货信息：", po);
		ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(orderInfo)){
			/*if(!SellerMembUtils.checkStalls(orderInfo.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}*/
			if(orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)){
				if(orderInfo.getSendZtType().equals(po.getSendZtType())){
					//不能修改订单的配送类型
					BeanUtils.copyProperties(po, orderInfo);
					orderInfo.preUpdate();
					mapper.updateByPrimaryKey(orderInfo);
					logger.info("修改后订单信息：{}", orderInfo);
				}else{
					resultPoJo.setCode(ConstantCodeMsg.ERR_403);
					resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
				}
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/6 16:02
     * @Description 修改报价
     **/
    @Transactional(readOnly = false)
	public ResultPoJo<?> updateQuoted(UpdateQuotedPo po) {
		LoggerUtil.infoWithContext("【updateQuoted】修改报价：", po);
		ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(orderInfo)){
			if(!SellerMembUtils.checkStalls(orderInfo.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}
			if(orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)){
				Logger logger = OrderLogger.getLogger(orderInfo.getId());
				logger.info("【卖家】修改订单商品报价");
				//查询订单商品列表
				List<OrdCommRela> ordCommRelas = ordCommRelaMapper.findByOrdId(orderInfo.getId());
				Map<Long, OrdCommRela> ordCommRelasMap = ordCommRelas.stream().collect(Collectors.toMap(OrdCommRela::getId, Function.identity()));
				OrdCommRela ordCommRela = ordCommRelasMap.get(po.getOrdCommRelaId());
				logger.info("修改前订单商品信息：{}", ordCommRela);

				//计算需要返还的商品库存
				Double returnCommStockCount = ConverterUtil.sub(ordCommRela.getCommTotalWeight(), po.getCommTotalWeight());

				ordCommRela.setCommTotalWeight(po.getCommTotalWeight());
				ordCommRela.setUnitWeightPrice(po.getUnitWeightPrice());
				ordCommRela.preUpdate();
				ordCommRelaMapper.updateByPrimaryKey(ordCommRela);

				logger.info("修改后订单商品信息：{}", ordCommRela);

				//计算修改后的商品总金额、应付款金额
				final Double[] commTotalPrice = {0.0};
				ordCommRelas.forEach(e->{
					commTotalPrice[0] = ConverterUtil.add(commTotalPrice[0], ConverterUtil.mul(e.getCommTotalWeight(), e.getUnitWeightPrice()));
				});

				//重新计算订单服务费
				final Double[] platfCost = {0.0};
				List<OrdCommRela> ordCommRelas1 = OrdCommRelaUtil.ordPlatfCost(ordCommRelas, orderInfo.getSellerId(), orderInfo.getBuyerId());
				ordCommRelas1.forEach(e->{
					platfCost[0] = ConverterUtil.add(platfCost[0], e.getPlatfCost());
				});

				orderInfo.setPlatfCost(platfCost[0]);
				orderInfo.setCommTotalPrice(ConverterUtil.getRoundValue(commTotalPrice[0], 2));
				orderInfo.setPayableAmount(orderInfo.getCommTotalPrice()); //待确认状态下  应付款金额 = 商品总金额
				orderInfo.preUpdate();
				mapper.updateByPrimaryKey(orderInfo);
				logger.info("修改后订单信息：{}", orderInfo);

				//返还商品库存 2020-10-16 产品（赵艳）沟通后确定不退款库存
				//Map<Long, Double> returnCommCount = Maps.newHashMap();
				//returnCommCount.put(ordCommRela.getId(), returnCommStockCount);
				//returnCommStock(orderInfo.getId(), returnCommCount);
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/6 16:47
	 * @Description 确认订单
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> confirmOrd(LongIdPo po) {
		LoggerUtil.infoWithContext("【updateDelivery】修改提货信息：", po);
		ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(orderInfo)){
			if(!SellerMembUtils.checkStalls(orderInfo.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}
			if(orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_0)){
				orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_1);
				//计算付款截止日
				Integer reconcDeadlineDays = DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_1);
				orderInfo.setBuyPayClosingDate(OffsetDateTime.now().plusHours(reconcDeadlineDays));
				orderInfo.setSellerSureDate(OffsetDateTime.now());
				orderInfo.preUpdate();
				mapper.updateByPrimaryKey(orderInfo);
				Logger logger = OrderLogger.getLogger(orderInfo.getId());
				logger.info("【卖家】确认订单：{}", orderInfo);
				//插入订单操作记录
				ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.CONFIRMORD, null);
				//事物提交之后发送消息
				Map<String, Object> param = Maps.newHashMap();
	            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_UN_PAY_TO_BUYER);
	            param.put("id", orderInfo.getId());
	            param.put("userId", orderInfo.getBuyerId());
	            param.put("ordNum", orderInfo.getOrdNum());
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						//卖家确认订单后，向卖家发送消息
						timSendService.sendTim(param);
					}
				});
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/7 10:01
	 * @Description 生成提货单
	 **/
	public ResultPoJo<String> billOfLading(LongIdPo po){
		LoggerUtil.infoWithContext("【billOfLading】生成提货/发货单：", po);
		ResultPoJo<String> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		BillOfLadingVo vo = mapper.findBillOfLad(po);
		if (ConverterUtil.isNotEmpty(vo)) {
			if(!SellerMembUtils.checkStalls(vo.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}
			if (vo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_2) || vo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_6)) {
				MembBaseInfo sellerInfo = MembUtils.getMembInfoByUserId(vo.getSellerId());
				vo.setSellerName(sellerInfo.getAuthName());
				vo.setReferOrdDateStr((OffsetDateTimeUtils.formatDateTimeToYmdhms(vo.getReferOrdDate())));
				vo.setPayOrdDateStr(OffsetDateTimeUtils.formatDateTimeToYmdhms(vo.getReferOrdDate()));
				vo.setPayMethodTypeStr(cacheService.getDictLabel(vo.getPayMethodType(), DictConstants.PAY_METHOD_TYPE, ""));

				//判断是自提还是配送
				if(vo.getSendZtType().equals(DictConstants.SEND_ZT_TYPE_0)){
					vo.setThAddressInfo(vo.getZtAddress());
				}else{
					String thAddressFormat = "%s%s%s%s";
					vo.setThAddressInfo(String.format(thAddressFormat, vo.getZtAddressProv(), vo.getZtAddressCity(), vo.getZtAddressCou(), vo.getStallsAddress()));
				}

				Map<Object, Object> map = Maps.newHashMap();
				map.put("billOfLad", vo);

				String fileName = "订单编号【%s】提货/发货单";
				fileName = String.format(fileName, vo.getOrdNum());

				String filePath = "file_temp".concat(File.separator) + fileName + ".pdf";
				File file = new File(filePath);
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdirs();
				}
				FileOutputStream outputStream = null;
				try {
					outputStream = new FileOutputStream(file);
					PdfHelper.generateToStream("billOfLading.ftl", null, map, outputStream, null);
				} catch (Exception e) {
					resultPoJo.setCode(ConstantCodeMsg.ERR_410);
					resultPoJo.setMsg(ConstantCodeMsg.MSG_410);
					return resultPoJo;
				}
				//临时文件上传至文件服务器
				if (file.exists()) {
					// 将普通file转成MultipartFile
					MultipartFile mfile = MultipartFileUtils.fileToMulitipart(file);
					ResultPoJo<UploadVo> poJo = remoteFilesMss.uploadFile(mfile, false);
					// 修改申请信息，保存文件路径
					UploadVo uploadVo = poJo.getResult();
					Map<String, List<FileVo>> filesMap = uploadVo.getFilesMap();
					List<FileVo> fileVos = filesMap.get("file");
					FileVo fileVo = fileVos.get(0);
					String path = fileVo.getPath();
					file.delete();
					resultPoJo.setResult(path);
				}
			} else {
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		} else {
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/12/02 16:37
	 * @Description 订单发货
	 **/
	public ResultPoJo<?> orderDelive(OrderDelivePo po) {
		LoggerUtil.infoWithContext("【orderDelive】订单发货：", po);
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getOrdId());
		if(ConverterUtil.isNotEmpty(orderInfo)){
			if(orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_2)){
				//更改订单状态
				orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_3);
				orderInfo.setLogisticsCompId(po.getLogisticsCompId());
				orderInfo.setLogisticsNum(po.getLogisticsNum());
				mapper.updateByPrimaryKeySelective(orderInfo);
				if(orderInfo.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_0)){
					//支付方式为在线支付，调用第三方支付发货
					QueryPayRecordRequest request = new QueryPayRecordRequest();
					request.setOrderId(orderInfo.getId().toString());
					payApiService.delivered(request);
				}
				//保存订单操作记录
				LogisticsCompMage logisticsCompMage = logisticsCompMageMapper.selectByPrimaryKey(po.getLogisticsCompId());
				String remarks = "物流公司【%s】，物流单号【%s】";
				remarks = String.format(remarks, logisticsCompMage.getLogisticsCompName(), po.getLogisticsNum());
				ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.DELIVE, remarks);
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/12/10 10:44
	 * @Description 订单跟踪
	 **/
	public ResultPoJo<LogisticsInfoVo> orderTrack(LongIdPo po) {
		LoggerUtil.infoWithContext("【orderTrack】订单跟踪：", po);
		ResultPoJo<LogisticsInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(orderInfo)){
			if(orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_3)){
				LogisticsInfoVo vo = new LogisticsInfoVo();
				//查询物流公司信息
				LogisticsCompMage logisticsCompMage = logisticsCompMageMapper.selectByPrimaryKey(orderInfo.getLogisticsCompId());
				vo.setLogisticsCompName(logisticsCompMage.getLogisticsCompName());
				vo.setLogisticsCompCode(logisticsCompMage.getLogisticsCompCode());
				vo.setLogisticsNum(orderInfo.getLogisticsNum());
				resultPoJo.setResult(vo);
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/7 14:59
	 * @Description 根据自提码查询自提订单详情
	 **/
    public ResultPoJo<ZtOrderInfoVo> findByZtNum(StringPo po) {
		LoggerUtil.infoWithContext("【findOrderInfo】根据自提码查询自提订单详情：", po);
		ResultPoJo<ZtOrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		ZtOrderInfoVo vo = mapper.findByZtNum(po.getKeyStr());
		if(ConverterUtil.isNotEmpty(vo) && SellerMembUtils.checkStalls(vo.getStallsId())){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * @Author jirg
	 * @Date 2020/6/18 9:36
	 * @Description 提货金额明细
	 */
	public ResultPoJo<DeliveryAmountDetailsVo> deliveryAmountDetails(OrderDeliveryPo po) {
		LoggerUtil.infoWithContext("【deliveryAmountDetails】提货金额明细：", po);
		ResultPoJo<DeliveryAmountDetailsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo info = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(info)){
			if(!SellerMembUtils.checkStalls(info.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}
			if(info.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_6)){
				DeliveryAmountDetailsVo vo = new DeliveryAmountDetailsVo();
				ZtOrderInfoVo ztInfo = mapper.findByZtNum(info.getZtNum());
				vo.setPayMethodType(info.getPayMethodType());
				vo.setPayableAmount(info.getPayableAmount());
				vo.setZqSerCost(info.getZqSerCost());

				Map<Long, OrderDeliveryCommPo> orderDeliveryCommMap = po.getOrderComms().stream().collect(Collectors.toMap(OrderDeliveryCommPo::getId, Function.identity()));
				//商品退款列表，记录未全部提货的退货信息
				List<OrdCommRefundRela> commRefundRelas = Lists.newArrayList();

				ztInfo.getOrdCommRelas().forEach(e->{
					OrderDeliveryCommPo orderDeliveryCommPo = orderDeliveryCommMap.get(e.getId());
					if(ConverterUtil.isNotEmpty(orderDeliveryCommPo)){
						logger.info("订单商品【{}】下单重量：{}，提货重量{}", e.getCommName(), e.getCommTotalWeight(), orderDeliveryCommPo.getDeliveryTotalWeight());
						//判断提货总重量和下单总重量是否相等
						if(e.getCommTotalWeight() > orderDeliveryCommPo.getDeliveryTotalWeight()){
							//商品未全部提货，剩余商品走退货流程，退货申请表记录数据
							OrdCommRefundRela commRefundRela = new OrdCommRefundRela();
							commRefundRela.preInsert();
							commRefundRela.setOrdCommRelaId(e.getId());
							commRefundRela.setCommSpec(e.getCommSpec());
							commRefundRela.setPrice(e.getUnitWeightPrice());
							commRefundRela.setRefundWeight(ConverterUtil.sub(e.getCommTotalWeight(), orderDeliveryCommPo.getDeliveryTotalWeight()));
							commRefundRela.setMeasUnitName(e.getMeasUnitName());
							if(ConverterUtil.isNotEmpty(orderDeliveryCommPo.getDeliveryCount())){
								commRefundRela.setCount(e.getCount() - orderDeliveryCommPo.getDeliveryCount());
							}else{
								commRefundRela.setCount(0);
							}
							commRefundRelas.add(commRefundRela);
						}else if(e.getCommTotalWeight() < orderDeliveryCommPo.getDeliveryTotalWeight()){
							//商品提货重量大于下单重量
							throw new VerifyException(ConstantCodeMsg.ERR_426, ConstantCodeMsg.MSG_426);
						}
					}else{
						throw new VerifyException(ConstantCodeMsg.ERR_416, ConstantCodeMsg.MSG_416);
					}
				});

				if(commRefundRelas.size() > 0){
					//应退款金额
					final Double[] refundAmount = {0.0};
					commRefundRelas.forEach(e->{
						//累加应退款金额
						refundAmount[0] = ConverterUtil.add(refundAmount[0], ConverterUtil.mul(e.getPrice(), e.getRefundWeight()));
					});
					vo.setRefundAmount(refundAmount[0]);
					vo.setDeliveryAmount(ConverterUtil.sub(vo.getPayableAmount(), vo.getRefundAmount()));

					if(info.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_1)){
						//计算商家应退账期服务费  应退账期服务费 =  订单账期服务费 * (退货商品总额 / 订单商品总金额)
						Double refundZqSerCost = ConverterUtil.mul(info.getZqSerCost(), ConverterUtil.div(refundAmount[0], info.getCommTotalPrice(), 2));
						vo.setRefundZqSerCost(refundZqSerCost);
						vo.setRefundAmount(ConverterUtil.add(vo.getRefundAmount(), vo.getRefundZqSerCost()));
						//提货金额账期服务费 = 订单账期服务费 - 应退账期服务费
						vo.setDeliveryZqSerCost(ConverterUtil.sub(info.getZqSerCost(), refundZqSerCost));
						vo.setDeliveryAmount(ConverterUtil.sub(vo.getDeliveryAmount(), refundZqSerCost));
					}
				}else{
					//没有退货
					vo.setDeliveryAmount(info.getPayableAmount());
					vo.setDeliveryZqSerCost(info.getZqSerCost());
				}
				resultPoJo.setResult(vo);
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

    /**
     * @Author jirg
     * @Date 2020/5/8 14:07
     * @Description 订单提货
     **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> orderDelivery(OrderDeliveryPo po) {
		LoggerUtil.infoWithContext("【orderDelivery】订单提货：", po);
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		OrderInfo info = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(info)){
			if(!SellerMembUtils.checkStalls(info.getStallsId())){
				resultPoJo.setCode(ConstantCodeMsg.ERR_457);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_457);
				return resultPoJo;
			}
			if(info.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_6)){
				//根据订单ID查询是否有待处理的退款申请 2020-10-16 新增
				RefundAppl ifAppl = refundApplMapper.findByOrderId(info.getId());
				if (ConverterUtil.isNotEmpty(ifAppl)) {
					resultPoJo.setCode(ConstantCodeMsg.ERR_411);
					resultPoJo.setMsg(ConstantCodeMsg.MSG_411);
					return resultPoJo;
				}
				Logger logger = OrderLogger.getLogger(info.getId());
				logger.info("【卖家】订单提货：{}", info);
				ZtOrderInfoVo ztInfo = mapper.findByZtNum(info.getZtNum());
				Map<Long, OrderDeliveryCommPo> orderDeliveryCommMap = po.getOrderComms().stream().collect(Collectors.toMap(OrderDeliveryCommPo::getId, Function.identity()));

				//商品退款列表，记录未全部提货的退货信息
				List<OrdCommRefundRela> commRefundRelas = Lists.newArrayList();
				//退还订单指定商品库存Map
				Map<Long, Double> returnCommCount = Maps.newHashMap();
				ztInfo.getOrdCommRelas().forEach(e->{
					OrderDeliveryCommPo orderDeliveryCommPo = orderDeliveryCommMap.get(e.getId());
					if(ConverterUtil.isNotEmpty(orderDeliveryCommPo)){
						logger.info("订单商品【{}】下单重量：{}，提货重量{}", e.getCommName(), e.getCommTotalWeight(), orderDeliveryCommPo.getDeliveryTotalWeight());
						//判断提货总重量和下单总重量是否相等
						if(e.getCommTotalWeight() > orderDeliveryCommPo.getDeliveryTotalWeight()){
							//商品未全部提货，剩余商品走退货流程，退货申请表记录数据
							OrdCommRefundRela commRefundRela = new OrdCommRefundRela();
							commRefundRela.preInsert();
							commRefundRela.setOrdCommRelaId(e.getId());
							commRefundRela.setCommSpec(e.getCommSpec());
							commRefundRela.setPrice(e.getUnitWeightPrice());
							commRefundRela.setRefundWeight(ConverterUtil.sub(e.getCommTotalWeight(), orderDeliveryCommPo.getDeliveryTotalWeight()));
							commRefundRela.setMeasUnitName(e.getMeasUnitName());
							if(ConverterUtil.isNotEmpty(orderDeliveryCommPo.getDeliveryCount())){
								commRefundRela.setCount(e.getCount() - orderDeliveryCommPo.getDeliveryCount());
							}else{
								commRefundRela.setCount(0);
							}
							commRefundRelas.add(commRefundRela);
							returnCommCount.put(e.getId(), commRefundRela.getRefundWeight());
						}else if(e.getCommTotalWeight() < orderDeliveryCommPo.getDeliveryTotalWeight()){
							//商品提货重量大于下单重量
							throw new VerifyException(ConstantCodeMsg.ERR_426, ConstantCodeMsg.MSG_426);
						}
					}else{
						throw new VerifyException(ConstantCodeMsg.ERR_416, ConstantCodeMsg.MSG_416);
					}
				});

				//修改订单状态为已完成
				info.setOrderStateType(DictConstants.ORDER_STATE_TYPE_4);
				//自提完成时间
				info.setZtCompleteDate(OffsetDateTime.now());
				//修改订单信息
				mapper.updateByPrimaryKey(info);
				//插入操作记录
				ordOpreateService.saveOrdOperate(info.getId(), OrdOperateEnum.DELIVERY, null);

				if(commRefundRelas.size() > 0){
					//应退款金额
					final Double[] refundAmount = {0.0};
					//平台应退服务费
					Double refundSerFee = 0.0;

					//有退货
					RefundAppl refundAppl = new RefundAppl();
					refundAppl.preInsert();
					refundAppl.setOrdId(info.getId());
					refundAppl.setOrdNum(info.getOrdNum());
					refundAppl.setRefundNum(CodeUtils.generateRefundNum());
					refundAppl.setApplDate(OffsetDateTime.now());
					refundAppl.setOrdAmount(info.getPayableAmount());
					refundAppl.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_2);
					refundAppl.setHandleDate(OffsetDateTime.now());
					refundAppl.setRefundDesc("提货数量小于下单数量，产生退款");
					refundAppl.setOutRequestNo(StringUtil.genNumbers(8));

					commRefundRelas.forEach(e->{
						e.setRefundApplId(refundAppl.getId());
						//累加应退款金额
						refundAmount[0] = ConverterUtil.add(refundAmount[0], ConverterUtil.mul(e.getPrice(), e.getRefundWeight()));
					});
					refundAppl.setRefundAmount(refundAmount[0]);
					//计算平台应退服务费 = 订单商品服务费 *（退货商品金额/订单商品金额）
					refundSerFee = ConverterUtil.getRoundValue(ConverterUtil.mul(info.getPlatfCost(), ConverterUtil.div(refundAmount[0], info.getCommTotalPrice(), 2)), 2);
					refundAppl.setRefundSerFee(refundSerFee);
					if(info.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_0)){
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
						RefundRecord refundRecord = (RefundRecord)refundResult.getResult();
						//因为银盛分账退款后不需要调用分账接口，第二天自动分账，所以在该处需要插入收支明细
						IncomeDetail incomeDetail = new IncomeDetail();
						//判断是账期还是订单
						incomeDetail.setMembId(info.getSellerId());
						incomeDetail.setBuyerId(info.getBuyerId());
						incomeDetail.setOrdNum(info.getOrdNum());
						incomeDetail.setSettOrdId(info.getId());
						incomeDetail.setTradeNo(refundRecord.getOutTradeNo());
						//买家付款金额 = 订单金额 - 应退款金额
						incomeDetail.setCommTotalPrice(ConverterUtil.sub(refundAppl.getOrdAmount(), refundAppl.getRefundAmount()));
						incomeDetail.setFinishDate(OffsetDateTime.now());
						//运营服务费 = 订单服务费 - 应退服务费
						incomeDetail.setOperSerCharge(ConverterUtil.sub(info.getPlatfCost(), refundAppl.getRefundSerFee()));
						//分账收入 = 买家付款金额 - 运营服务费
						incomeDetail.setSplitIncome(ConverterUtil.sub(incomeDetail.getCommTotalPrice(), incomeDetail.getOperSerCharge()));

						incomeDetail.preInsert();
						incomeDetailMapper.insertSelective(incomeDetail);
					}else if(info.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_1)){
						//计算商家应退账期服务费  应退账期服务费 =  订单账期服务费 * (退货商品总额 / 订单商品总金额)
						Double refundZqSerCost = ConverterUtil.getRoundValue(ConverterUtil.mul(info.getZqSerCost(), ConverterUtil.div(refundAmount[0], info.getCommTotalPrice(), 2)), 2);
						refundAppl.setRefundZqSerCost(refundZqSerCost);
						refundAppl.setRefundAmount(ConverterUtil.add(refundAppl.getRefundAmount(), refundZqSerCost)); //账期支付，应退款金额 = 应退款商品总金额 + 应退账期服务费

						//返还账期支付可用额度
						ApPayMage apPayMage = apPayMageMapper.findByIds(info.getSellerId(), info.getBuyerId());
						apPayMage.setAvailableCredit(ConverterUtil.add(apPayMage.getAvailableCredit(), refundAppl.getRefundAmount()));
						apPayMageMapper.updateByPrimaryKey(apPayMage);
					}
					//插入退款信息
					refundApplMapper.insert(refundAppl);
					logger.info("订单由于未全部提货产生退款，退款金额为：{}，其中应退平台服务费为：{}", refundAppl.getRefundAmount(),refundAppl.getRefundSerFee());
					//保存退款操作记录
					refundOperatorInfoService.saveRefundOperate(refundAppl.getId(), RefundOperateEnum.DELIVERY, null);
					//批量插入订单商品退款关系表
					commRefundRelaMapper.batchInsert(commRefundRelas);

					//获取发票信息
					OrdInvo ordInvo = ordInvoMapper.findByOrdId(info.getId());
					if(ConverterUtil.isNotEmpty(ordInvo)){
						//发票金额 = 原发票金额 - 应退款金额
						ordInvo.setDrawAmount(ConverterUtil.sub(ordInvo.getDrawAmount(), refundAmount[0]));
						ordInvo.preUpdate();
						ordInvoMapper.updateByPrimaryKeySelective(ordInvo);
					}

					//退还商品库存 2020-10-16 产品（赵艳）沟通后确定不退库存
 					//returnCommStock(info.getId(), returnCommCount);

					//事物提交之后发送消息
					Map<String, Object> param = Maps.newHashMap();
					param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_REFUND_INFO_TO_BUYER);
					param.put("id", refundAppl.getId());
					param.put("userId", info.getBuyerId());
					param.put("ordNum", info.getOrdNum());
					param.put("refundNum", refundAppl.getRefundNum());
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							//买家提货完成后，发送消息给买家
							timSendService.sendTim(param);
						}
					});
				}else{
					//没有退货
					if(info.getPayMethodType().equals(DictConstants.PAY_METHOD_TYPE_0)){
						//下单即付的订单进入分账阶段
						//因为如果有退款的话，银盛走的是分账退款，分账信息在退款时就传入，退款后不需要掉用分账接口，钱会在退款后第二天进行分账
						YsPayUtils.divitInto(info.getId());
					}
				}

				//事物提交之后发送消息
				Map<String, Object> param = Maps.newHashMap();
	            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_PICKUP_TO_BUYER);
	            param.put("id", info.getId());
	            param.put("userId", info.getBuyerId());
	            param.put("ordNum", info.getOrdNum());
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						//买家提货完成后，发送消息给买家
						timSendService.sendTim(param);
					}
				});
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/19 14:38
	 * @Description 查询未出账单列表
	 */
	public ResultPoJo<List<OutstandingBillVo>> outstandingBill(OutstandingBillPo po) {
		LoggerUtil.infoWithContext("【outstandingBill】查询未出账单列表：", po);
		ResultPoJo<List<OutstandingBillVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		//判断当前登录用户
		List<Long> sellerIds = Lists.newArrayList();
		String queryUserFlag = "";

		//判断当前登录用户
		if(membInfo.getUserSourceType().equals("0") || membInfo.getUserSourceType().equals("1")){
			if(membInfo.getUserSourceType().equals("0")){
				//市场Id不能为空
				Assert.notNull(po.getMarketId(), "批发市场不能为空！");
			}else{
				//获取批发市场ID
				po.setMarketId(membInfo.getMarketId());
			}
			queryUserFlag = "0";
			//查询出市场的所有商家
			//查询出市场的所有商家
			List<MembInfo> sellers = wholeSaleMarketMageMapper.findMembIdByMarketId(po.getMarketId());
			sellerIds = sellers.stream().map(MembInfo::getId).collect(Collectors.toList());
			po.setSellerIds(sellerIds);
		}else{
			queryUserFlag = "1";
			sellerIds.add(membInfo.getMembId());
		}

		po.setSellerIds(sellerIds);
		po.setQueryUserFlag(queryUserFlag);

		List<OutstandingBillVo> list = mapper.outstandingBill(po);
		resultPoJo.setResult(list);
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/19 16:30
	 * @Description 查询未出账单详细信息
	 */
	public ResultPoJo<OutstandingBillInfoVo> outstandingBillInfo(OutstandingBillInfoPo po) {
		LoggerUtil.infoWithContext("【outstandingBillInfo】查询未出账单详细信息：", po);
		ResultPoJo<OutstandingBillInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		OutstandingBillInfoVo info = mapper.outstandingBillInfo(po);
		if (ConverterUtil.isNotEmpty(info)){
			List<SettleOrdRelaInfoVo> settleOrdRelaInfoVos = info.getSettleOrdRelaInfoVos();
			info.setOrdCount(settleOrdRelaInfoVos.size());
			final Double[] settleAmount = {0.0};
			settleOrdRelaInfoVos.stream().forEach(e->{
				settleAmount[0] = ConverterUtil.add(settleAmount[0], e.getAmount());
			});
			info.setSettleAmount(settleAmount[0]);
			resultPoJo.setResult(info);
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}


	/**
	 * @Author jirg
	 * @Date 2020/5/26 17:02
	 * @Description 市场处理争议订单
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<?> handleDisputes(OrderHandleDisputesPo po) {
		LoggerUtil.infoWithContext("【outstandingBillInfo】查询未出账单详细信息：", po);
		ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
		if (ConverterUtil.isNotEmpty(orderInfo)){
			if(orderInfo.getOrderStateType().equals(DictConstants.ORDER_STATE_TYPE_8)){
				orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_4);
				orderInfo.preUpdate();
				mapper.updateByPrimaryKey(orderInfo);
				//插入操作记录
				ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.DISPUTEHANDLE, po.getHandleRemarks());
			}else{
				resultPoJo.setCode(ConstantCodeMsg.ERR_403);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
			}
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_004);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/25 14:27
	 * @Description 昨日交易统计
	 */
	public ResultPoJo<YesterdayStatisticsVo> yesterdayStatistics() {
		LoggerUtil.infoWithContext("【yesterdayStatistics】昨日交易统计：", null);
		ResultPoJo<YesterdayStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		Map<String, Object> paramMap = Maps.newHashMap();

		MembBaseInfo baseInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUser().getId());

		paramMap.put("startDate", OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
		paramMap.put("endDate", OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
		paramMap.put("sellerId", baseInfo.getMembId());

		YesterdayStatisticsVo vo = mapper.yesterdayStatistics(paramMap);
		resultPoJo.setResult(vo);
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/26 9:42
	 * @Description 交易首页-订单状态数量
	 */
	public ResultPoJo<OrderStatisticsVo> orderStatistics() {
		LoggerUtil.infoWithContext("【yesterdayStatistics】昨日交易统计：", null);
		ResultPoJo<OrderStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		Map<String, Object> paramMap = Maps.newHashMap();

		MembBaseInfo baseInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUser().getId());
		paramMap.put("sellerId", baseInfo.getMembId());

		OrderStatisticsVo vo = mapper.orderStatistics(paramMap);
		resultPoJo.setResult(vo);
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/25 16:09
	 * @Description 服务费统计
	 */
	public ResultPoJo<ServiceFeeStatisticsVo> serviceFeeStatistics(ServiceFeeStatisticsPo po) {
		LoggerUtil.infoWithContext("【yesterdayStatistics】昨日交易统计：", null);
		ResultPoJo<ServiceFeeStatisticsVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

		//设置查询日期
		if(po.getQueryType().equals("0")){
			//按月统计
			String queryMonth = po.getQueryMonth();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
			OffsetDateTime date = OffsetDateTime.parse(queryMonth, dtf);
			Integer year = date.getYear();
			Integer month = date.getMonthValue();
			po.setStartDate(OffsetDateTimeUtils.getFirstDayOfMonth(year, month));
			po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTimeUtils.getLastDayOfMonth(year,month)));
		}else{
			//按年统计
			po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().withMonth(1).withDayOfMonth(1)));
			po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()));
		}

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

//			ServiceFeeStatisticsVo vo = mapper.serviceFeeStatistics(po);
//			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantCodeMsg.ERR_401);
			resultPoJo.setMsg(ConstantCodeMsg.MSG_401);
		}
		return resultPoJo;
	}

	/****************************************买家开始**************************************/

	/**
     * @Author yangtao
     * @Description 买家查询订单列表
     **/
    public ResultPoJo<Page<BuyerOrderInfoListVo>> findBuyerOrderList(BuyerOrderInfoListPo po) {
        ResultPoJo<Page<BuyerOrderInfoListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取当前用户
        Long puffId = SystemUtils.getUserOnlyId().getId();
        MembBaseInfo memb = MembUtils.getMembInfoByUserId(puffId);
        //判断是不是主账户
        po.setBuyerId(memb.getMembId());
        if (!puffId.equals(memb.getMembId()) && !"0".equals(memb.getPurSfAdminFlag())) {
            //如果不是主账户就查询他自己下面的
            po.setPurchaseId(puffId);
        }
        Page<BuyerOrderInfoListVo> page = po.getPage();
        if (DictConstants.TRANS_TYPE_1.equals(po.getTransType())) {
            //查询订单分页信息
            List<BuyerOrderInfoListVo> ordIdList = localMapper.findBuyerPage(po);
            //将list转化成string
            String orderIds = "";

            if (ordIdList != null && ordIdList.size() > 0) {

                //取出所有的id集合
                for (BuyerOrderInfoListVo order : ordIdList) {

                    orderIds = orderIds + "," + order.getId();
                }
                orderIds = StringUtils.substring(orderIds, 1);
            }else {
                //为空就返回空数据
                page.setList(ordIdList);
                resultPoJo.setResult(page);
                return resultPoJo;
            }
            //查询订单列表带商品信息
            BuyerOrderInfoListPo pagePo = new BuyerOrderInfoListPo();
            pagePo.setOrdIds(orderIds);
            List<BuyerOrderInfoListVo> findList = localMapper.findBuyerList(pagePo);
            page.setList(findList);
        }else {
            //查询订单分页信息
            List<BuyerOrderInfoListVo> ordIdList = mapper.findBuyerPage(po);
            //将list转化成string
            String orderIds = "";

            if (ordIdList != null && ordIdList.size() > 0) {

                //取出所有的id集合
                for (BuyerOrderInfoListVo order : ordIdList) {

                    orderIds = orderIds + "," + order.getId();
                }
                orderIds = StringUtils.substring(orderIds, 1);
            }else {
                //为空就返回空数据
                page.setList(ordIdList);
                resultPoJo.setResult(page);
                return resultPoJo;
            }
            //查询订单列表带商品信息
            BuyerOrderInfoListPo pagePo = new BuyerOrderInfoListPo();
            pagePo.setOrdIds(orderIds);
            List<BuyerOrderInfoListVo> findList = mapper.findBuyerList(pagePo);
            page.setList(findList);
        }
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 查询订单角标
     * @param po
     * @return
     */
    public ResultPoJo<List<OrderListNumVo>> buyerOrderListNum (BuyerOrderInfoListPo po) {
        ResultPoJo<List<OrderListNumVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取当前用户
        Long puffId = SystemUtils.getUserOnlyId().getId();
        MembBaseInfo memb = MembUtils.getMembInfoByUserId(puffId);
        //判断是不是主账户
        po.setBuyerId(memb.getMembId());
        if (!puffId.equals(memb.getMembId()) && !"0".equals(memb.getPurSfAdminFlag())) {
            //如果不是主账户就查询他自己下面的
            po.setPurchaseId(puffId);
        }
        List<StateTypeVo> orderNumb = Lists.newArrayList();
        if (DictConstants.TRANS_TYPE_1.equals(po.getTransType())) {

            orderNumb = localMapper.orderNumb(po);
        }else {

            orderNumb = mapper.orderNumb(po);
        }
        List<OrderListNumVo> list = Lists.newArrayList();

        OrderListNumVo orderListNumVo1 = new OrderListNumVo();
        orderListNumVo1.setKey("0");
        OrderListNumVo orderListNumVo2 = new OrderListNumVo();
        orderListNumVo2.setKey("1");
        OrderListNumVo orderListNumVo3 = new OrderListNumVo();
        orderListNumVo3.setKey("2");
        OrderListNumVo orderListNumVo4 = new OrderListNumVo();
        orderListNumVo4.setKey("3");
		Integer count = 0;
        for (StateTypeVo stateTypeVo : orderNumb) {

            if (DictConstants.ORDER_STATE_TYPE_0.equals(stateTypeVo.getStateType())) {

                orderListNumVo1.setCount(stateTypeVo.getCount().toString());

            }else if (DictConstants.ORDER_STATE_TYPE_1.equals(stateTypeVo.getStateType())) {

                orderListNumVo2.setCount(stateTypeVo.getCount().toString());

            }else if (DictConstants.ORDER_STATE_TYPE_2.equals(stateTypeVo.getStateType())) {

				count += stateTypeVo.getCount();

            }else if (DictConstants.ORDER_STATE_TYPE_3.equals(stateTypeVo.getStateType())) {

				count += stateTypeVo.getCount();

			}else if (DictConstants.ORDER_STATE_TYPE_6.equals(stateTypeVo.getStateType())) {

				count += stateTypeVo.getCount();

			}else if (DictConstants.ORDER_STATE_TYPE_8.equals(stateTypeVo.getStateType())) {//待评价

                orderListNumVo4.setCount(stateTypeVo.getCount().toString());

            }
        }
		orderListNumVo3.setCount(count.toString());
        list.add(orderListNumVo1);
        list.add(orderListNumVo2);
        list.add(orderListNumVo3);
        list.add(orderListNumVo4);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

	/**
	 * 我的首页订单角标
	 */
	public ResultPoJo<Map<String, List<OrderListNumVo>>> myOrderNum () {
		ResultPoJo<Map<String, List<OrderListNumVo>>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		BuyerOrderInfoListPo po = new BuyerOrderInfoListPo();
		BuyerRefundListPo refundPo = new BuyerRefundListPo();
		//获取当前用户
		Long puffId = SystemUtils.getUserOnlyId().getId();
		MembBaseInfo memb = MembUtils.getMembInfoByUserId(puffId);
		//判断是不是主账户
		po.setBuyerId(memb.getMembId());
		refundPo.setBuyerId(memb.getMembId());
		if (!puffId.equals(memb.getMembId()) && !"0".equals(memb.getPurSfAdminFlag())) {
			//如果不是主账户就查询他自己下面的
			po.setPurchaseId(puffId);
			refundPo.setPurchaseId(puffId);
		}
		//同城订单角标
		List<StateTypeVo> orderNumb1 = Lists.newArrayList();
		List<OrderListNumVo> list1 = Lists.newArrayList();
		orderNumb1 = localMapper.orderNumb(po);
		numListGz(orderNumb1, list1);
		//同城退款角标
		List<StateTypeVo> redundNumb = refundApplMapper.refundNumb(refundPo);
		OrderListNumVo orderListNumVo1 = new OrderListNumVo();
		orderListNumVo1.setKey("4");
		for (StateTypeVo stateTypeVo : redundNumb) {
			if (DictConstants.REFUND_APPL_STATE_TYPE_0.equals(stateTypeVo.getStateType())) {
				orderListNumVo1.setCount(stateTypeVo.getCount().toString());
			}
		}
		list1.add(orderListNumVo1);
		//产地订单角标
		List<StateTypeVo> orderNumb2 = Lists.newArrayList();
		List<OrderListNumVo> list2 = Lists.newArrayList();
		orderNumb2 = mapper.orderNumb(po);
		numListGz(orderNumb2, list2);
		Map<String, List<OrderListNumVo>> map = new HashMap<String, List<OrderListNumVo>>();
		map.put("TC", list2);
		map.put("CD", list1);
		resultPoJo.setResult(map);
		return resultPoJo;
	}

	public void numListGz (List<StateTypeVo> orderNumb, List<OrderListNumVo> list) {

		OrderListNumVo orderListNumVo1 = new OrderListNumVo();
		orderListNumVo1.setKey("0");
		OrderListNumVo orderListNumVo2 = new OrderListNumVo();
		orderListNumVo2.setKey("1");
		OrderListNumVo orderListNumVo3 = new OrderListNumVo();
		orderListNumVo3.setKey("2");
		OrderListNumVo orderListNumVo4 = new OrderListNumVo();
		orderListNumVo4.setKey("3");

		for (StateTypeVo stateTypeVo : orderNumb) {

			if (DictConstants.ORDER_STATE_TYPE_0.equals(stateTypeVo.getStateType())) {

				orderListNumVo1.setCount(stateTypeVo.getCount().toString());

			}else if (DictConstants.ORDER_STATE_TYPE_1.equals(stateTypeVo.getStateType())) {

				orderListNumVo2.setCount(stateTypeVo.getCount().toString());

			}else if (DictConstants.ORDER_STATE_TYPE_6.equals(stateTypeVo.getStateType())) {

				orderListNumVo3.setCount(stateTypeVo.getCount().toString());

			}else if (DictConstants.ORDER_STATE_TYPE_7.equals(stateTypeVo.getStateType())) {//待评价

				orderListNumVo4.setCount(stateTypeVo.getCount().toString());

			}
		}
		list.add(orderListNumVo1);
		list.add(orderListNumVo2);
		list.add(orderListNumVo3);
		list.add(orderListNumVo4);
	}

    /**
     * 买家端查看订单详情
     * @param po
     * @return
     */
    public ResultPoJo<OrderInfoVo> buyerOrderInfo (OrderInfoPo po) {
        ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfoVo vo = mapper.findOrderInfo(po);
        //添加发票文件
        if (ConverterUtil.isNotEmpty(vo.getOrdInvo())) {
            List<EleInvoFileInfoVo> ordInvoFiles = invoFileMapper.ordInvoFiles(vo.getOrdInvo().getId());
            vo.getOrdInvo().setInvoFiles(ordInvoFiles);
            //查询退款金额
            BuyerRefundListPo refundPo = new BuyerRefundListPo();
            refundPo.setOrderId(vo.getId());
            refundPo.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_2);
            List<BuyerRefundListVo> buyerRefundList = refundApplMapper.buyerRefundList(refundPo);
            if (buyerRefundList != null && buyerRefundList.size() > 0) {

                vo.setRefundAmount(buyerRefundList.get(0).getRefundAmount());
            }
        }
        vo.setZtDeadDay(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_2));
        vo.setNowDateTime(OffsetDateTime.now());
        if (vo != null && vo.getZtNum() != null) {
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            // 设置编码方式
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            hints.put(EncodeHintType.MARGIN, 0);
            hints.put(EncodeHintType.MAX_SIZE, 100);
            hints.put(EncodeHintType.MIN_SIZE, 100);
            BufferedImage image = ZxingHandler.getQR_CODEBufferedImage(vo.getZtNum(), 100, 100, hints);
            String imageBase64QRCode = null;
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                baos.flush();
                ImageIO.write(image, "png", baos);
                imageBase64QRCode = Base64.byteArrayToBase64(baos.toByteArray());
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            vo.setZtUrl(imageBase64QRCode);
        }
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 基地查询订单详细信息
     * @param po
     * @return
     */
    public ResultPoJo<OrderInfoVo> baseBuyerOrderInfo(OrderInfoPo po) {
        LoggerUtil.infoWithContext("【findOrderInfo】查询订单详细信息：", po);
        ResultPoJo<OrderInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfoVo vo = localMapper.findOrderInfo(po);
        if(ConverterUtil.isNotEmpty(vo)){
            vo.setNowDateTime(OffsetDateTime.now());
            resultPoJo.setResult(vo);
            //添加发票文件
            if (ConverterUtil.isNotEmpty(vo.getOrdInvo())) {
                //查询退款金额
                BuyerRefundListPo refundPo = new BuyerRefundListPo();
                refundPo.setOrderId(vo.getId());
                refundPo.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_2);
                List<BuyerRefundListVo> buyerRefundList = refundApplMapper.buyerRefundList(refundPo);
                if (buyerRefundList != null && buyerRefundList.size() > 0) {

                    vo.setRefundAmount(buyerRefundList.get(0).getRefundAmount());
                }
                List<EleInvoFileInfoVo> ordInvoFiles = invoFileMapper.ordInvoFiles(vo.getOrdInvo().getId());
                vo.getOrdInvo().setInvoFiles(ordInvoFiles);
            }
            vo.setZtDeadDay(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_2));
            vo.setNowDateTime(OffsetDateTime.now());
            if (vo != null && vo.getZtNum() != null) {
                Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
                // 设置QR二维码的纠错级别（H为最高级别）具体级别信息
                hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
                // 设置编码方式
                hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
                hints.put(EncodeHintType.MARGIN, 0);
                hints.put(EncodeHintType.MAX_SIZE, 100);
                hints.put(EncodeHintType.MIN_SIZE, 100);
                BufferedImage image = ZxingHandler.getQR_CODEBufferedImage(vo.getZtNum(), 100, 100, hints);
                String imageBase64QRCode = null;
                try {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    baos.flush();
                    ImageIO.write(image, "png", baos);
                    imageBase64QRCode = Base64.byteArrayToBase64(baos.toByteArray());
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                vo.setZtUrl(imageBase64QRCode);
            }
            //测试
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_004);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 基地查看、修改基地发票详情页
     * @param po
     * @return
     */
    public ResultPoJo<OrdInvoInfoVo> baseInvoApplInfo (LongIdPo po) {
        ResultPoJo<OrdInvoInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //查询订单发票信息
        OrdInvoInfoVo ordInvo = localityOrdInvoMapper.findInfo(po);
        List<EleInvoFileInfoVo> ordInvoFiles = localityEleInvoFileMapper.ordInvoFiles(ordInvo.getId());
        ordInvo.setInvoFiles(ordInvoFiles);
        //查询订单信息，判断订单类型和支付方式
        LocalityOrderInfo orderInfo = localMapper.selectByPrimaryKey(ordInvo.getOrdId());
        //校验
        if (orderInfo.getPayMethodType() != null && DictConstants.PAY_METHOD_TYPE_1.equals(orderInfo.getPayMethodType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_458);
            resultPoJo.setMsg("当前支付方式不显示发票！");
            return resultPoJo;
        }
        resultPoJo.setResult(ordInvo);
        return resultPoJo;
    }

    /**
     * 查看、修改发票详情页
     * @param po
     * @return
     */
    public ResultPoJo<OrdInvoInfoVo> invoApplInfo (LongIdPo po) {
        ResultPoJo<OrdInvoInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //查询订单发票信息
        OrdInvoInfoVo ordInvo = ordInvoMapper.findInfo(po);
        List<EleInvoFileInfoVo> ordInvoFiles = invoFileMapper.ordInvoFiles(ordInvo.getId());
        ordInvo.setInvoFiles(ordInvoFiles);
        //查询订单信息，判断订单类型和支付方式
        OrderInfo orderInfo = mapper.selectByPrimaryKey(ordInvo.getOrdId());
        //校验
        if (orderInfo.getPayMethodType() != null && DictConstants.PAY_METHOD_TYPE_1.equals(orderInfo.getPayMethodType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_458);
            resultPoJo.setMsg("当前支付方式不显示发票！");
            return resultPoJo;
        }
        resultPoJo.setResult(ordInvo);
        return resultPoJo;
    }

    /**
     * 修改、新增订单发票
     * @param po
     * @return
     */
    @Transactional(readOnly = false)
    public ResultPoJo<Object> invoApplUpd (InvoApplPo po) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if ("0".equals(po.getSettOrdFlag())) {
            //获取结算单详情
            SettleBill settleBill = settleBillMapper.selectByPrimaryKey(po.getOrdId());
            //校验是否主账户、管理员
            if (!membInfo.getMembId().equals(settleBill.getBuyerId()) &&
                    !(membInfo.getMembId().equals(settleBill.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag()))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_455);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
                return resultPoJo;
            }
            //查询发票详情
            LongIdPo longPo = new LongIdPo();
            longPo.setId(po.getOrdId());
            SettleBillInvoInfoVo invo = settleBillInvoMapper.findInfoBySettId(longPo);
            //校验是否可以修改发票
            if (ConverterUtil.isNotEmpty(invo) && !DictConstants.INVO_STATE_0.equals(invo.getInvoState())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_458);
                return resultPoJo;
            }
            //修改发票信息
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
            settleBillInvo.setDelFlag("0");
            //修改发票
            if (ConverterUtil.isEmpty(po.getInvoId())) {
                //不要发票
                settleBillInvo.setDelFlag(DictConstants.DEL_FLAG_1);
                settleBillInvo.preUpdate();
                settleBillInvoMapper.updateByPrimaryKeySelective(settleBillInvo);
            }else {
                if (ConverterUtil.isNotEmpty(invo)) {

                    settleBillInvo.setId(invo.getId());
                    settleBillInvo.preUpdate();
                    settleBillInvoMapper.updateByPrimaryKeySelective(settleBillInvo);
                }else {
                    settleBill.setOpenBillDeadline(OffsetDateTime.now().plusHours(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_6)));
                    settleBill.preUpdate();
                    settleBillMapper.updateByPrimaryKeySelective(settleBill);
					settleBillInvo.setApplNum(CodeUtils.generateSettleInvoCode());
                    settleBillInvo.preInsert();
                    settleBillInvoMapper.insertSelective(settleBillInvo);
                }
            }
        }else {
            //查询订单信息，判断订单类型和支付方式
            OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getOrdId());
            //校验是否订单用户或者主账户、管理员
            if (!membInfo.getId().equals(orderInfo.getBuyerId()) &&
                    !(membInfo.getMembId().equals(orderInfo.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag())) &&
                    !(membInfo.getMembId().equals(orderInfo.getBuyerId()) && membInfo.getId().equals(orderInfo.getPurchaseId()))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_455);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
                return resultPoJo;
            }
            //校验
            if (orderInfo.getPayMethodType() != null && DictConstants.PAY_METHOD_TYPE_1.equals(orderInfo.getPayMethodType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("当前支付方式不显示发票！");
                return resultPoJo;
            }
            //校验订单状态
            if (DictConstants.ORDER_STATE_TYPE_5.equals(orderInfo.getOrderStateType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("取消的订单不允许申请发票！");
                return resultPoJo;
            }
            //校验是否超过了开票日期
            if (DictConstants.ORDER_STATE_TYPE_4.equals(orderInfo.getOrderStateType()) &&
                    OffsetDateTime.now().isAfter(orderInfo.getZtCompleteDate().plusDays(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_3)))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("超过申请发票期限！");
                return resultPoJo;
            }
            //获取之前的订单发票，校验是否已经开过
            OrdInvo oldInvo = ordInvoMapper.findByOrdId(po.getOrdId());
            if (ConverterUtil.isNotEmpty(oldInvo) && !DictConstants.INVO_STATE_0.equals(oldInvo.getInvoState())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_458);
                resultPoJo.setMsg("当前发票状态不允许修改！");
                return resultPoJo;
            }
            //修改
            Logger logger = OrderLogger.getLogger(po.getOrdId());
            if (ConverterUtil.isNotEmpty(oldInvo)) {
                Long invoId = oldInvo.getId();
                oldInvo.setApplRemarks(po.getRemake());
                oldInvo.setReceName(po.getReceName());
                oldInvo.setConsigneeTel(po.getConsigneeTel());
                oldInvo.setAddressCity(po.getAddressCity());
                oldInvo.setAddressCou(po.getAddressCou());
                oldInvo.setAddressProv(po.getAddressProv());
                oldInvo.setAddressDetail(po.getAddressDetail());
                InvoInfo invo = invoInfoMapper.selectByPrimaryKey(po.getInvoId());
                oldInvo.preUpdate();
                ConverterUtil.copyProperties(invo, oldInvo);
                oldInvo.setId(invoId);
                ordInvoMapper.updateByPrimaryKeySelective(oldInvo);
                logger.info("【买家】修改发票后发票信息：{}", oldInvo);
            } else {//新增
                OrdInvo ordInvo = new OrdInvo();
                InvoInfo invoInfo = invoInfoMapper.selectByPrimaryKey(po.getInvoId());
                ConverterUtil.copyProperties(invoInfo, ordInvo);
                ordInvo.setApplDate(OffsetDateTime.now());
                ordInvo.setApplRemarks(po.getRemake());
                ordInvo.setReceName(po.getReceName());
                ordInvo.setConsigneeTel(po.getConsigneeTel());
                ordInvo.setAddressCity(po.getAddressCity());
                ordInvo.setAddressCou(po.getAddressCou());
                ordInvo.setAddressProv(po.getAddressProv());
                ordInvo.setAddressDetail(po.getAddressDetail());
                ordInvo.setOrdId(orderInfo.getId());
                ordInvo.setDrawAmount(orderInfo.getPayableAmount());
                ordInvo.setInvoState(DictConstants.INVO_STATE_0);
                ordInvo.setApplNum(CodeUtils.generateInvoApplCode());
                ordInvo.preInsert();
                ordInvoMapper.insertSelective(ordInvo);
                logger.info("【买家】新增发票信息：{}", ordInvo);
                //事物提交之后发送消息
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
						Map<String, Object> param = Maps.newHashMap();
						param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_UN_INVOICE_TO_SALLER);
						param.put("id", orderInfo.getId());
						param.put("staffId", orderInfo.getStallsId());
						param.put("buyerName", MembUtils.getMembInfoByUserId(orderInfo.getSellerId()).getAuthName());
						param.put("userId", orderInfo.getSellerId());
						param.put("ordNum", orderInfo.getOrdNum());
						timSendService.sendTim(param);
                    }
                });
            }
        }
        return resultPoJo;
    }

    /**
     * 取消订单校验
     *
     */
    public ResultPoJo<Object> cancelOrdChack (LongIdPo longIdPo) {

        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfoPo orderInfoPo = new OrderInfoPo();
        orderInfoPo.setId(longIdPo.getId());
        orderInfoPo.setQueryUserFlag("1");
        OrderInfoVo orderInfoVo = mapper.findOrderInfo(orderInfoPo);
        //校验是否订单用户或者主账户、管理员
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getId().equals(orderInfoVo.getBuyerId()) &&
                !(membInfo.getMembId().equals(orderInfoVo.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag())) &&
                !(membInfo.getMembId().equals(orderInfoVo.getBuyerId()) && membInfo.getId().equals(orderInfoVo.getPurchaseId()))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //校验订单信息(待自提之前都能取消)
        if (!DictConstants.ORDER_STATE_TYPE_0.equals(orderInfoVo.getOrderStateType()) &&
                !(DictConstants.ORDER_STATE_TYPE_1.equals(orderInfoVo.getOrderStateType()) &&
                        ConverterUtil.isEmpty(orderInfoVo.getPayOrdDate())) &&
                !DictConstants.ORDER_STATE_TYPE_6.equals(orderInfoVo.getOrderStateType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            return resultPoJo;
        }
        if (DictConstants.ORDER_STATE_TYPE_6.equals(orderInfoVo.getOrderStateType())) {//已付款，有退款流程

            //判断是否有正在处理的取消订单流程
            RefundAppl ifAppl = refundApplMapper.findByOrderId(orderInfoVo.getId());

            if (ConverterUtil.isNotEmpty(ifAppl)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
                return resultPoJo;
            }
        }
        return resultPoJo;
    }

    /**
     * 查询订单取消原因
     * @return
     */
    public ResultPoJo<List<OrdCancelReasonMageListVo>> findOrdCancelReason () {
        ResultPoJo<List<OrdCancelReasonMageListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<OrdCancelReasonMageListVo> findAllReason = ordCancelReasonMageMapper.findAllReason();
        resultPoJo.setResult(findAllReason);
        return resultPoJo;
    }

    /**
     * 取消订单
     *
     */
    @Transactional(readOnly=false)
    public ResultPoJo<Object> cancelOrd (RefundApplPo refundApplPo) {
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        OrderInfo orderInfoVo = mapper.selectByPrimaryKey(refundApplPo.getOrdId());
        //校验是否订单用户或者主账户、管理员
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getId().equals(orderInfoVo.getBuyerId()) &&
                !(membInfo.getMembId().equals(orderInfoVo.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag())) &&
                !(membInfo.getMembId().equals(orderInfoVo.getBuyerId()) && membInfo.getId().equals(orderInfoVo.getPurchaseId()))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //校验订单信息(未发货之前都能取消)
        if (!DictConstants.ORDER_STATE_TYPE_0.equals(orderInfoVo.getOrderStateType()) &&
                !DictConstants.ORDER_STATE_TYPE_1.equals(orderInfoVo.getOrderStateType()) &&
				!DictConstants.ORDER_STATE_TYPE_2.equals(orderInfoVo.getOrderStateType()) &&
                !DictConstants.ORDER_STATE_TYPE_6.equals(orderInfoVo.getOrderStateType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            return resultPoJo;
        }
        //查询取消原因
        OrdCancelReasonMage ordCancelReasonMage = ordCancelReasonMageMapper.selectByPrimaryKey(refundApplPo.getRefundReasonType());
        //判断是否已付款
        Logger logger = OrderLogger.getLogger(refundApplPo.getOrdId());
        if (DictConstants.ORDER_STATE_TYPE_0.equals(orderInfoVo.getOrderStateType()) ||
                DictConstants.ORDER_STATE_TYPE_1.equals(orderInfoVo.getOrderStateType())) {//未付款

            //直接取消订单，库存返回，订单商品信息返回进货单
            //订单状态改为已取消
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId(orderInfoVo.getId());
            orderInfo.setOrdCancelReasonId(refundApplPo.getRefundReasonType());
            orderInfo.setOrdCancelDate(OffsetDateTime.now());
            orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_5);
            orderInfo.preUpdate();

            mapper.updateByPrimaryKeySelective(orderInfo);
            logger.info("【买家】直接取消订单：{}", orderInfo);
            ordOpreateService.saveOrdOperate(orderInfoVo.getId(), OrdOperateEnum.CANCEL,
                    MessageFormat.format("{0}，操作备注：{1}", ordCancelReasonMage.getOrdCancelReason(), "无"));
            //返回库存
            returnOrdCommStock(orderInfoVo.getId());
            //发送消息
            //事物提交之后发送消息
            Map<String, Object> param = Maps.newHashMap();
            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_CANCEL_TO_SALLER);
            param.put("id", orderInfo.getId());
            param.put("staffId", orderInfoVo.getStallsId());
            param.put("userId", orderInfoVo.getSellerId());
            param.put("ordNum", orderInfoVo.getOrdNum());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
					timSendService.sendTim(param);
                }
            });
        }else if (DictConstants.ORDER_STATE_TYPE_6.equals(orderInfoVo.getOrderStateType())
			|| DictConstants.ORDER_STATE_TYPE_2.equals(orderInfoVo.getOrderStateType())) {//已付款，有退款流程
            //判断是否有正在处理的取消订单流程
            RefundAppl ifAppl = refundApplMapper.findByOrderId(orderInfoVo.getId());

            if (ConverterUtil.isNotEmpty(ifAppl)) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
                return resultPoJo;
            }
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId(orderInfoVo.getId());
            orderInfo.setOrdCancelReasonId(refundApplPo.getRefundReasonType());
            orderInfo.preUpdate();

            RefundAppl refundAppl = new RefundAppl();
            refundAppl.setOrdId(orderInfoVo.getId());
            refundAppl.setOrdNum(orderInfoVo.getOrdNum());
            refundAppl.setRefundAmount(orderInfoVo.getPayableAmount());
            refundAppl.setRefundReasonType(refundApplPo.getRefundReasonType());
            refundAppl.setRefundDesc(refundApplPo.getRefundDesc());
            refundAppl.setRefundNum(CodeUtils.generateRefundNum());
            refundAppl.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_0);
            refundAppl.setApplDate(OffsetDateTime.now());
            refundAppl.setOrdAmount(orderInfoVo.getPayableAmount());
            refundAppl.setOutRequestNo(StringUtil.genNumbers(8));
            refundAppl.setRefundSerFee(orderInfoVo.getPlatfCost());
            refundAppl.setRefundZqSerCost(orderInfoVo.getZqSerCost());
            refundAppl.setBuySellFlag(DictConstants.BUY_SELL_FLAG_0);
            refundAppl.preInsert();
            //商品退款列表，记录未全部提货的退货信息
            List<OrdCommRefundRela> commRefundRelas = Lists.newArrayList();
            //查询订单内的商品列表
            List<OrdCommRela> ordCommRelas = ordCommRelaMapper.findByOrdId(orderInfoVo.getId());
            ordCommRelas.forEach(e -> {

                OrdCommRefundRela commRefundRela = new OrdCommRefundRela();
                commRefundRela.preInsert();
                commRefundRela.setOrdCommRelaId(e.getId());
                commRefundRela.setRefundApplId(refundAppl.getId());
                commRefundRela.setCount(e.getCount());
                commRefundRela.setCommSpec(e.getCommSpec());
                commRefundRela.setPrice(e.getUnitWeightPrice());
                commRefundRela.setRefundWeight(e.getCommTotalWeight());
                commRefundRela.setMeasUnitName(e.getMeasUnitName());
                commRefundRelas.add(commRefundRela);
            });
            mapper.updateByPrimaryKeySelective(orderInfo);
            refundApplMapper.insertSelective(refundAppl);
            //保存退款操作记录
            refundOperatorInfoService.saveRefundOperate(refundAppl.getId(), RefundOperateEnum.SUBMIT, MessageFormat.format("{0}，操作备注：{1}", ordCancelReasonMage.getOrdCancelReason(), "无"));
            //批量插入订单商品退款关系表
            commRefundRelaMapper.batchInsert(commRefundRelas);
            logger.info("【买家】申请取消订单，退款信息：{}", refundAppl);
            ordOpreateService.saveOrdOperate(orderInfoVo.getId(), OrdOperateEnum.PROPOSECANCEL,
                    MessageFormat.format("{0}，操作备注：{1}", ordCancelReasonMage.getOrdCancelReason(), "无"));
            //事物提交之后发送消息
            Map<String, Object> param = Maps.newHashMap();
            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_REFUND_TO_SALLER);
            param.put("id", orderInfo.getId());
            param.put("staffId", orderInfoVo.getStallsId());
            param.put("userId", orderInfoVo.getSellerId());
            param.put("ordNum", orderInfoVo.getOrdNum());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
					timSendService.sendTim(param);
                }
            });
        }else {

            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            return resultPoJo;
        }
        return resultPoJo;
    }

    /**
     * 去支付页面详情页
     * @param po
     * @return
     */
    public ResultPoJo<TopayInfoVo> toPayInfo (LongIdPo po) {
        ResultPoJo<TopayInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        TopayInfoVo vo = new TopayInfoVo();
        //获取订单信息
        OrderInfo orderInfo = mapper.selectByPrimaryKey(po.getId());
        //校验状态
        if (!DictConstants.ORDER_STATE_TYPE_1.equals(orderInfo.getOrderStateType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            return resultPoJo;
        }
        //获取账期信息
        ApPayMage apPayMage = apPayMageMapper.findByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
        //判断账期支付是否满足
        double zqSerCost = 0D;
        if (apPayMage != null && DictConstants.CREDIT_TYPE_0.equals(apPayMage.getCreditType())) {
            //计算订单总应付金额（加上账期服务费）
            if (apPayMage.getSerCostBl() != null) {

                zqSerCost = ConverterUtil.div(ConverterUtil.mul(apPayMage.getSerCostBl(),orderInfo.getPayableAmount()), 100, 2);
            }
            orderInfo.setPayableAmount(ConverterUtil.add(orderInfo.getPayableAmount(), zqSerCost));
            //判断授信金额是否足够
            ApPayMageInfoVo apPayvo = new ApPayMageInfoVo();
            ConverterUtil.copyProperties(apPayMage, apPayvo);
            vo.setApPayMage(apPayvo);
            vo.setPayTypes(DictConstants.PAY_METHOD_TYPE_1);
            vo.setZqSerCost(zqSerCost);
            if (apPayMage.getAvailableCredit() >= orderInfo.getPayableAmount()) {
                vo.setPayTypes("2");
            }
        }
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(orderInfo.getSellerId());
        vo.setEntpName(membInfo.getAuthName());
        vo.setCommTotalPrice(orderInfo.getCommTotalPrice());
        vo.setPayableAmount(orderInfo.getPayableAmount());
        vo.setOrdId(orderInfo.getId());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 基地去支付页面详情页
     * @param po
     * @return
     */
    public ResultPoJo<TopayInfoVo> toPayLocalInfo (LongIdPo po) {
        ResultPoJo<TopayInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        TopayInfoVo vo = new TopayInfoVo();
        //获取订单信息
        LocalityOrderInfo orderInfo = localMapper.selectByPrimaryKey(po.getId());
        //校验状态
        if (!DictConstants.ORDER_STATE_TYPE_1.equals(orderInfo.getBaseOrderStateType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            return resultPoJo;
        }
        //获取账期信息
        ApPayMage apPayMage = apPayMageMapper.findByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
        //判断账期支付是否满足
        double zqSerCost = 0D;
        if (apPayMage != null && DictConstants.CREDIT_TYPE_0.equals(apPayMage.getCreditType())) {
            //计算订单总应付金额（加上账期服务费）
            if (apPayMage.getSerCostBl() != null) {

                zqSerCost = ConverterUtil.div(ConverterUtil.mul(apPayMage.getSerCostBl(),orderInfo.getPayableAmount()), 100, 2);
            }
            orderInfo.setPayableAmount(ConverterUtil.add(orderInfo.getPayableAmount(), zqSerCost));
            //判断授信金额是否足够
            ApPayMageInfoVo apPayvo = new ApPayMageInfoVo();
            ConverterUtil.copyProperties(apPayMage, apPayvo);
            vo.setApPayMage(apPayvo);
            vo.setPayTypes(DictConstants.PAY_METHOD_TYPE_1);
            vo.setZqSerCost(zqSerCost);
            if (apPayMage.getAvailableCredit() >= orderInfo.getPayableAmount()) {
                vo.setPayTypes("2");
            }
        }
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(orderInfo.getSellerId());
        vo.setEntpName(membInfo.getAuthName());
        vo.setCommTotalPrice(orderInfo.getCommTotalPrice());
        vo.setPayableAmount(orderInfo.getPayableAmount());
        vo.setOrdId(orderInfo.getId());
        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    /**
     * 账期支付
     * @param
     */
    @Transactional(readOnly=false)
    public ResultPoJo<Object> accountPay (String orderId) {

        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取全部订单
        List<OrderInfo> orders = mapper.findOrderByIds(orderId);

        for (OrderInfo orderInfo : orders) {
            Logger logger = OrderLogger.getLogger(orderInfo.getId());
            logger.info("【买家】账期支付订单");
            //校验数据是否是本人
           //校验是否主账户、管理员
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
            if (!(membInfo.getMembId().equals(orderInfo.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag())) &&
                    !(membInfo.getMembId().equals(orderInfo.getBuyerId()) && membInfo.getId().equals(orderInfo.getPurchaseId()))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_455);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
                return resultPoJo;
            }
            //校验订单状态
            if (!DictConstants.ORDER_STATE_TYPE_1.equals(orderInfo.getOrderStateType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，状态错误");
                return resultPoJo;
            }
            /*//校验支付方式
            if (!DictConstants.PAY_METHOD_TYPE_1.equals(orderInfo.getPayMethodType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，支付方式错误");
                return resultPoJo;
            }*/
            //校验付款截止日期
            if (OffsetDateTime.now().isAfter(orderInfo.getSellerSureDate().plusDays(ConverterUtil.toInteger(DictConstants.DEAD_LINE_TYPE_1)))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，付款日期超时");
                return resultPoJo;
            }
            //查询授信状态
            ApPayMage apPayMage = apPayMageMapper.findByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
            //判断是否授信
            if (!(apPayMage != null && DictConstants.CREDIT_TYPE_0.equals(apPayMage.getCreditType()))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_417);;
                resultPoJo.setMsg("没有授权账期支付或已失效");
                return resultPoJo;
            }
            //计算账期服务费
            Double zqFee = ConverterUtil.div(ConverterUtil.mul(orderInfo.getPayableAmount(), apPayMage.getSerCostBl()), 100, 2);
            orderInfo.setZqSerCost(zqFee);
            orderInfo.setPayableAmount(ConverterUtil.add(orderInfo.getPayableAmount(), zqFee));
            //判断授信金额是否足够
            if (apPayMage.getAvailableCredit() < orderInfo.getPayableAmount()) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_417);;
                resultPoJo.setMsg("账期金额不足");
                return resultPoJo;
            }
            //修改账期余额
            apPayMage.setAvailableCredit(ConverterUtil.sub(apPayMage.getAvailableCredit(), orderInfo.getPayableAmount()));
            apPayMage.preUpdate();
            apPayMageMapper.updateByPrimaryKeySelective(apPayMage);
            //修改订单状态
            orderInfo.setPayOrdDate(OffsetDateTime.now());
            if (DictConstants.SEND_ZT_TYPE_1.equals(orderInfo.getSendZtType())) {
				orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_2);
			}else {
				orderInfo.setOrderStateType(DictConstants.ORDER_STATE_TYPE_6);
			}
            orderInfo.setPayMethodType(DictConstants.PAY_METHOD_TYPE_1);
            orderInfo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_1);
            orderInfo.setZtClosingDate(OffsetDateTime.now().plusDays(DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_2)));
            //设置10位随机数
            orderInfo.setZtNum(CodeUtils.generateZtNum());
            orderInfo.preUpdate();
            mapper.updateByPrimaryKeySelective(orderInfo);
            logger.info("【买家】账期支付订单成功：{}", orderInfo);
            //订单操作表里插入数据
            ordOpreateService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.PAY, orderInfo.getRemarks());
        }
        for (OrderInfo e : orders) {
            //事物提交之后发送消息
            //发送给卖家
            Map<String, Object> param = Maps.newHashMap();
            param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_SALLER);
            param.put("id", e.getId());
            param.put("staffId", e.getStallsId());
            param.put("userId", e.getSellerId());
            param.put("transType", DictConstants.TRANS_TYPE_0);
            param.put("ordNum", e.getOrdNum());
            //发送给买家
            Map<String, Object> param2 = Maps.newHashMap();
            param2.put("timType", TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_BUYER);
            param2.put("id", e.getId());
            param2.put("userId", e.getPurchaseId());
            param2.put("transType", DictConstants.TRANS_TYPE_0);
            param2.put("ordNum", e.getOrdNum());
            if (DictConstants.ZT_ADDRESS_TYPE_0.equals(e.getZtAddressType())) {
                param2.put("ztAddr", e.getZtAddressProv()+e.getZtAddressCity()+e.getZtAddressCou()+e.getStallsAddress());
            }else {
                param2.put("ztAddr", e.getZtAddress());
            }
            param2.put("ztNum", e.getZtNum());
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
					timSendService.sendTim(param);
					timSendService.sendTim(param2);
                }
            });
        }
        return resultPoJo;
    }

    /**
     * 基地账期支付
     * @param
     */
    @Transactional(readOnly=false)
    public ResultPoJo<Object> localAccountPay (String orderId) {

        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取全部订单
        List<LocalityOrderInfo> orders = localMapper.findOrderByIds(orderId);

        for (LocalityOrderInfo orderInfo : orders) {
            Logger logger = OrderLogger.getLogger(orderInfo.getId());
            logger.info("【买家】账期支付订单");
            //校验数据是否是本人
           //校验是否主账户、管理员
            MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
            if (!(membInfo.getMembId().equals(orderInfo.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag())) &&
                    !(membInfo.getMembId().equals(orderInfo.getBuyerId()) && membInfo.getId().equals(orderInfo.getPurchaseId()))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_455);
                resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
                return resultPoJo;
            }
            //校验订单状态
            if (!DictConstants.ORDER_STATE_TYPE_1.equals(orderInfo.getBaseOrderStateType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，状态错误");
                return resultPoJo;
            }
            /*//校验支付方式
            if (!DictConstants.PAY_METHOD_TYPE_1.equals(orderInfo.getPayMethodType())) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，支付方式错误");
                return resultPoJo;
            }*/
            //校验付款截止日期
            if (OffsetDateTime.now().isAfter(orderInfo.getSellerSureDate().plusDays(ConverterUtil.toInteger(DictConstants.DEAD_LINE_TYPE_1)))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_403);
                resultPoJo.setMsg("订单号："+orderInfo.getOrdNum()+"的订单，付款日期超时");
                return resultPoJo;
            }
            //查询授信状态
            ApPayMage apPayMage = apPayMageMapper.findByIds(orderInfo.getSellerId(), orderInfo.getBuyerId());
            //判断是否授信
            if (!(apPayMage != null && DictConstants.CREDIT_TYPE_0.equals(apPayMage.getCreditType()))) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_417);;
                resultPoJo.setMsg("没有授权账期支付或已失效");
                return resultPoJo;
            }
            //计算账期服务费
            Double zqFee = ConverterUtil.div(ConverterUtil.mul(orderInfo.getPayableAmount(), apPayMage.getSerCostBl()), 100, 2);
            orderInfo.setZqSerCost(zqFee);
            orderInfo.setPayableAmount(ConverterUtil.add(orderInfo.getPayableAmount(), zqFee));
            //判断授信金额是否足够
            if (apPayMage.getAvailableCredit() < orderInfo.getPayableAmount()) {

                resultPoJo.setCode(ConstantCodeMsg.ERR_417);;
                resultPoJo.setMsg("账期金额不足");
                return resultPoJo;
            }
            //修改账期余额
            apPayMage.setAvailableCredit(ConverterUtil.sub(apPayMage.getAvailableCredit(), orderInfo.getPayableAmount()));
            apPayMage.preUpdate();
            apPayMageMapper.updateByPrimaryKeySelective(apPayMage);
            //修改订单状态
            orderInfo.setPayOrdDate(OffsetDateTime.now());
            orderInfo.setBaseOrderStateType(DictConstants.BASE_ORDER_STATE_TYPE_4);
            orderInfo.setPayMethodType(DictConstants.PAY_METHOD_TYPE_1);
            orderInfo.setSettleBillGenerateType(DictConstants.SETTLE_BILL_GENERATE_TYPE_1);
            //设置10位随机数
            orderInfo.setZtNum(CodeUtils.generateZtNum());
            orderInfo.preUpdate();
            localMapper.updateByPrimaryKeySelective(orderInfo);
            logger.info("【买家】账期支付订单成功：{}", orderInfo);
            //订单操作表里插入数据
            localityOrdOpreateInfoService.saveOrdOperate(orderInfo.getId(), OrdOperateEnum.PAY, orderInfo.getRemarks());
        }
        for (LocalityOrderInfo e : orders) {
            //事物提交之后发送消息
             Map<String, Object> param = Maps.newHashMap();
             param.put("timType", TIMNoticeConstants.TITLE_ORD_UN_PICKUP);
             param.put("id", e.getId());
             param.put("userId", e.getSellerId());
             param.put("transType", DictConstants.TRANS_TYPE_1);
             param.put("ordNum", e.getOrdNum());
             //发送给买家
             Map<String, Object> param2 = Maps.newHashMap();
             param2.put("timType", TIMNoticeConstants.TPL_KEY_ORD_PAY_TO_BUYER);
             param2.put("id", e.getId());
             param2.put("transType", DictConstants.TRANS_TYPE_1);
             param2.put("userId", e.getPurchaseId());
             param2.put("ordNum", e.getOrdNum());
             if (DictConstants.ZT_ADDRESS_TYPE_0.equals(e.getZtAddressType())) {
                 param2.put("ztAddr", e.getZtAddressProv()+e.getZtAddressCity()+e.getZtAddressCou()+e.getStallsAddress());
             }else {
                 param2.put("ztAddr", e.getZtAddress());
             }
             param2.put("ztNum", e.getZtNum());
             TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                 @Override
                 public void afterCommit() {
					 timSendService.sendTim(param);
					 timSendService.sendTim(param2);
                 }
             });
         }
        return resultPoJo;
    }


    /**
     * 退还订单内所有商品库存量
     * @param orderId
     */
    public void returnOrdCommStock(Long orderId){
        //查询订单内的商品列表
        List<OrdCommRela> ordCommRelas = ordCommRelaMapper.findByOrdId(orderId);
        List<Long> comList = Lists.newArrayList();
        for (OrdCommRela ordCommRela : ordCommRelas) {
            //查询当前商品等级信息
            LevelSpecQuote level = levelSpecQuoteMapper.selectByPrimaryKey(ordCommRela.getLevelSpecQuoteId());
            //退还库存
            level.setAvaiSupplyCount(level.getAvaiSupplyCount() + ordCommRela.getCount());
            //退回销量
            level.setSalesVolume(ConverterUtil.sub(level.getSalesVolume(), ordCommRela.getCommTotalWeight()));
            //计算商品总金额
            double mul = ConverterUtil.mul(ordCommRela.getCount(), ordCommRela.getPrice());
            level.setTransactionAmount(ConverterUtil.sub(level.getTransactionAmount(), mul));
            level.preUpdate();
            levelSpecQuoteMapper.updateByPrimaryKeySelective(level);
            if (!comList.contains(ordCommRela.getCommPubId())) {
                comList.add(ordCommRela.getCommPubId());
            }
        }
        // 调用远程更新索引
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                //事物提交之后执行修改发布商品索引
                logger.debug("更新索引：订单ID=", orderId);
                BatchUpdSearchPo msspo = new BatchUpdSearchPo();
                msspo.setListIdPo(comList);
                try {
                    productMss.updateBatchCommditySearch(msspo);
                } catch (Exception e1) {
                    logger.debug("更新索引发生错误");
                }
            }
        });
    }

	/**
	 * 退还订单内指定商品库存量
	 * @param orderId
	 */
	public void returnCommStock(Long orderId, Map<Long, Double> returnCommCount){
		//查询订单内的商品列表
		List<OrdCommRela> ordCommRelas = ordCommRelaMapper.findByOrdId(orderId);
		for (OrdCommRela ordCommRela : ordCommRelas) {
			if(returnCommCount.containsKey(ordCommRela.getId())){
				//查询当前商品等级信息
				LevelSpecQuote level = levelSpecQuoteMapper.selectByPrimaryKey(ordCommRela.getLevelSpecQuoteId());
				//退还库存，按重量/净重，

				level.setAvaiSupplyCount(ConverterUtil.add(level.getAvaiSupplyCount(), returnCommCount.get(ordCommRela.getId())));
				//退回销量
				level.setSalesVolume(ConverterUtil.sub(level.getSalesVolume(), returnCommCount.get(ordCommRela.getId())));
				//计算商品总金额
				double mul = ConverterUtil.mul(returnCommCount.get(ordCommRela.getId()), ordCommRela.getUnitWeightPrice());
				level.setTransactionAmount(ConverterUtil.sub(level.getTransactionAmount(), mul));
				level.preUpdate();
				levelSpecQuoteMapper.updateByPrimaryKeySelective(level);
				//TODO 调用远程更新索引
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
					    //事物提交之后执行修改发布商品索引
	                    logger.debug("更新索引：", level.getCommPubId());
	                   /* CommPubInfoGetPo msspo = new CommPubInfoGetPo();
	                    msspo.setId(level.getCommPubId());
	                    productMss.updateIndexSearch(msspo);*/
					}
				});
			}
		}
	}

    /**
     * 买家查询退款列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<BuyerRefundListVo>> buyerRefundList (BuyerRefundListPo po) {
        ResultPoJo<Page<BuyerRefundListVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取当前用户
        Long puffId = SystemUtils.getUserOnlyId().getId();
        MembBaseInfo memb = MembUtils.getMembInfoByUserId(puffId);
        //判断是不是主账户
        po.setBuyerId(memb.getMembId());
        if (!puffId.equals(memb.getMembId()) && !"0".equals(memb.getPurSfAdminFlag())) {
            //如果不是主账户或者管理员就查询他自己下面的
            po.setPurchaseId(puffId);
        }
        Page<BuyerRefundListVo> page = po.getPage();
        List<BuyerRefundListVo> buyerRefundList = refundApplMapper.buyerRefundList(po);
        page.setList(buyerRefundList);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 查询角标
     * @param po
     * @return
     */
    public ResultPoJo<List<OrderListNumVo>> buyerRefundListNum (BuyerRefundListPo po) {
        ResultPoJo<List<OrderListNumVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取当前用户
        Long puffId = SystemUtils.getUserOnlyId().getId();
        MembBaseInfo memb = MembUtils.getMembInfoByUserId(puffId);
        //判断是不是主账户
        po.setBuyerId(memb.getMembId());
        if (!puffId.equals(memb.getMembId()) && !"0".equals(memb.getPurSfAdminFlag())) {
            //如果不是主账户或者管理员就查询他自己下面的
            po.setPurchaseId(puffId);
        }
        List<StateTypeVo> orderNumb = refundApplMapper.refundNumb(po);
        List<OrderListNumVo> list = Lists.newArrayList();

        OrderListNumVo orderListNumVo1 = new OrderListNumVo();
        orderListNumVo1.setKey("0");
        OrderListNumVo orderListNumVo2 = new OrderListNumVo();
        orderListNumVo2.setKey("1");
        OrderListNumVo orderListNumVo3 = new OrderListNumVo();
        orderListNumVo3.setKey("2");
        OrderListNumVo orderListNumVo4 = new OrderListNumVo();
        orderListNumVo4.setKey("3");

        for (StateTypeVo stateTypeVo : orderNumb) {

            if (DictConstants.REFUND_APPL_STATE_TYPE_0.equals(stateTypeVo.getStateType())) {

                orderListNumVo1.setCount(stateTypeVo.getCount().toString());

            }else if (DictConstants.REFUND_APPL_STATE_TYPE_1.equals(stateTypeVo.getStateType())) {

                orderListNumVo2.setCount(stateTypeVo.getCount().toString());

            }else if (DictConstants.REFUND_APPL_STATE_TYPE_2.equals(stateTypeVo.getStateType())) {

                orderListNumVo3.setCount(stateTypeVo.getCount().toString());

            }else if (DictConstants.REFUND_APPL_STATE_TYPE_3.equals(stateTypeVo.getStateType())) {

                orderListNumVo4.setCount(stateTypeVo.getCount().toString());

            }
        }
        list.add(orderListNumVo1);
        list.add(orderListNumVo2);
        list.add(orderListNumVo3);
        list.add(orderListNumVo4);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * 买家查询退款详情
     * @param po
     * @return
     */
    public ResultPoJo<BuyerRefundInfoVo> buyerRefundInfo (LongIdPo po) {
        ResultPoJo<BuyerRefundInfoVo> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BuyerRefundInfoVo buyerRefundInfo = refundApplMapper.buyerRefundInfo(po);
        List<OpreateInfoVo> refundOpreateInfos = refundOperatorMapper.selectRefundOpreateInfos(po.getId());
        buyerRefundInfo.setRefundOpreateInfos(refundOpreateInfos);
        resultPoJo.setResult(buyerRefundInfo);
        return resultPoJo;
    }

    /**
     * 取消退款（id传退款申请id）
     * @param po
     * @return
     */
    @Transactional(readOnly=false)
    public ResultPoJo<Object> refundCommConcel (LongIdPo po) {

        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        BuyerRefundInfoVo buyerRefundInfo = refundApplMapper.buyerRefundInfo(po);
        //校验数据是否是本人
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (!membInfo.getId().equals(buyerRefundInfo.getBuyerId()) &&
                !(membInfo.getMembId().equals(buyerRefundInfo.getBuyerId()) && "0".equals(membInfo.getPurSfAdminFlag())) &&
                !(membInfo.getMembId().equals(buyerRefundInfo.getBuyerId()) && membInfo.getId().equals(buyerRefundInfo.getPurchaseId()))) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_455);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_455);
            return resultPoJo;
        }
        //校验是否可以申请取消
        if (!DictConstants.REFUND_APPL_STATE_TYPE_0.equals(buyerRefundInfo.getRefundApplStateType())) {

            resultPoJo.setCode(ConstantCodeMsg.ERR_403);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_403);
            return resultPoJo;
        }
        //修改数据
        RefundAppl findInfo = new RefundAppl();
        findInfo.setId(po.getId());
        findInfo.setRefundApplStateType(DictConstants.REFUND_APPL_STATE_TYPE_3);
        findInfo.preUpdate();
        refundApplMapper.updateByPrimaryKeySelective(findInfo);
        //保存退款操作记录
        refundOperatorInfoService.saveRefundOperate(po.getId(), RefundOperateEnum.CANCEL, null);
        Logger logger = OrderLogger.getLogger(buyerRefundInfo.getOrdId());
        logger.info("【买家】撤销取消订单");
        return resultPoJo;
    }

    /**
     * 查询订单发票列表
     * @param po
     * @return
     */
    public ResultPoJo<Page<OrdInvoPageVo>> ordInvoList (OrdInvoPagePo po) {
        ResultPoJo<Page<OrdInvoPageVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取卖家ID
        po.setSellerId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        Page<OrdInvoPageVo> page = po.getPage();
        List<OrdInvoPageVo> ordInvoList = ordInvoMapper.ordInvoList(po);
        page.setList(ordInvoList);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 查询订单发票角标
     * @param po
     * @return
     */
    public ResultPoJo<List<OrderListNumVo>> orderInvoListNum (OrdInvoPagePo po) {
        ResultPoJo<List<OrderListNumVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        //获取卖家ID
        po.setSellerId(MembUtils.getMembIdFromUser(SystemUtils.getUser()));
        List<StateTypeVo> orderNumb = ordInvoMapper.orderInvoNumb(po);
        List<OrderListNumVo> list = Lists.newArrayList();

        OrderListNumVo orderListNumVo1 = new OrderListNumVo();
        orderListNumVo1.setKey("0");
        OrderListNumVo orderListNumVo2 = new OrderListNumVo();
        orderListNumVo2.setKey("2");

        for (StateTypeVo stateTypeVo : orderNumb) {

            if (DictConstants.INVO_STATE_0.equals(stateTypeVo.getStateType())) {

                orderListNumVo1.setCount(stateTypeVo.getCount().toString());

            }else if (DictConstants.INVO_STATE_2.equals(stateTypeVo.getStateType())) {

                orderListNumVo2.setCount(stateTypeVo.getCount().toString());
            }
        }
        list.add(orderListNumVo1);
        list.add(orderListNumVo2);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * 开票、重新开票
     * @param po
     * @return
     */
    @Transactional(readOnly=false)
    public ResultPoJo<Object> ordInvoicing(InvoicingPo po) {
        LoggerUtil.infoWithContext("【invoicing】订单发票开票：", po);
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        OrdInvo ordInvo = ordInvoMapper.selectByPrimaryKey(po.getId());
        OrderInfo orderInfo = mapper.selectByPrimaryKey(ordInvo.getOrdId());
        if(ConverterUtil.isNotEmpty(ordInvo)){
            //插入结算单操作记录
            if(ordInvo.getInvoState().equals(DictConstants.INVO_STATE_0)){
                ordOpreateService.saveOrdOperate(ordInvo.getOrdId(), OrdOperateEnum.INVOICING, null);
                //事物提交之后发送消息
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
						Map<String, Object> param = Maps.newHashMap();
						param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_INVOICE_TO_BUYER);
						param.put("id", orderInfo.getId());
						param.put("userId", orderInfo.getBuyerId());
						param.put("ordNum", orderInfo.getOrdNum());
						timSendService.sendTim(param);
                    }
                });
            }else if(ordInvo.getInvoState().equals(DictConstants.INVO_STATE_2)){
                ordOpreateService.saveOrdOperate(ordInvo.getOrdId(), OrdOperateEnum.RENEWINVOICING, null);
                //事物提交之后发送消息
                TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                    @Override
                    public void afterCommit() {
						Map<String, Object> param = Maps.newHashMap();
						param.put("timType", TIMNoticeConstants.TPL_KEY_ORD_RE_INVOICE_TO_BUYER);
						param.put("id", orderInfo.getId());
						param.put("userId", orderInfo.getBuyerId());
						param.put("ordNum", orderInfo.getOrdNum());
						timSendService.sendTim(param);
                    }
                });
            }
            ordInvo.setEntryOpenInvoType(po.getEntryOpenInvoType());
            ordInvo.setLogisticsCompName(po.getLogisticsCompName());
            ordInvo.setLogisticsNum(po.getLogisticsNum());
            ordInvo.setOpenInvoRemarks(po.getOpenInvoRemarks());
            ordInvo.setDrawDate(OffsetDateTime.now());
            ordInvo.setInvoState(DictConstants.INVO_STATE_2);
            ordInvo.preUpdate();
            ordInvoMapper.updateByPrimaryKey(ordInvo);
            //删除旧的电子发票文件
            invoFileMapper.delByInvoId(po.getId());
            if(ConverterUtil.isNotEmpty(po.getInvoFiles())){
                List<EleInvoFile> invoFiles = Lists.newArrayList();
                po.getInvoFiles().forEach(e->{
                    EleInvoFile invoFile = new EleInvoFile();
                    invoFile.setEleInvoUrl(e.getFileUrl());
                    invoFile.setOrdInvoId(po.getId());
                    invoFile.setRemarks(e.getFileName());
                    invoFile.preInsert();
                    invoFiles.add(invoFile);
                });
                invoFileMapper.batchInsert(invoFiles);
            }
        }else{
            resultPoJo.setCode(ConstantError.ERR_004);
            resultPoJo.setMsg(ConstantError.MSG_004);
        }
        return resultPoJo;
    }

    /**
     * 财务首页
     * @return
     */
    public ResultPoJo<List<OrderListNumVo>> financeStatInfo () {
        ResultPoJo<List<OrderListNumVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //获取商家ID
        Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        String ordInvoCount = ordInvoMapper.notOpenInvoCount(sellerId);
        String settlCount = settleBillInvoMapper.notOpenInvoCount(sellerId);
        List<OrderListNumVo> list = Lists.newArrayList();

        OrderListNumVo orderListNumVo1 = new OrderListNumVo();
        orderListNumVo1.setKey("0");
        orderListNumVo1.setCount(ordInvoCount);
        OrderListNumVo orderListNumVo2 = new OrderListNumVo();
        orderListNumVo2.setKey("1");
        orderListNumVo2.setCount(settlCount);
        list.add(orderListNumVo1);
        list.add(orderListNumVo2);
        resultPoJo.setResult(list);
        return resultPoJo;
    }

    /**
     * 订单统计
     * @param po
     * @return
     */
    public ResultPoJo<StatisOrderVo> statisOrder (StaticOrderPo po) {
        ResultPoJo<StatisOrderVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }
        //获取当前用户
        Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        po.setSellerId(sellerId);
        //有效订单数
        Integer effCount = 0;
        Double effAmount = 0D;
        //无效订单
        Integer notCount = 0;
        Double notAmount = 0D;
        //已成交订单
        Integer overCount = 0;
        Double overAmount = 0D;
        List<StatisOrderVo> statisList = mapper.statisOrder(po);
        for (StatisOrderVo e : statisList) {
            //无效订单
            if (DictConstants.ORDER_STATE_TYPE_5.equals(e.getOrderStateType())) {

                notCount = e.getEffOrdCount();
                notAmount = e.getEffOrdAmount();
            }else if (DictConstants.ORDER_STATE_TYPE_4.equals(e.getOrderStateType())) {
                //已成交
                overCount = e.getEffOrdCount();
                overAmount = e.getEffOrdAmount();
                effCount = effCount + e.getEffOrdCount();
                effAmount = ConverterUtil.add(effAmount, e.getEffOrdAmount());
            }else {

                effCount = effCount + e.getEffOrdCount();
                effAmount = ConverterUtil.add(effAmount, e.getEffOrdAmount());
            }
        }
        //无效订单
        StatisOrderVo statisOrder = new StatisOrderVo();
        //已成交订单
        statisOrder.setEffOrdAmount(effAmount);
        statisOrder.setEffOrdCount(effCount);
        statisOrder.setNotEffOrdAmount(notAmount);
        statisOrder.setNotEffOrdCount(notCount);
        statisOrder.setOverOrdAmount(overAmount);
        statisOrder.setOverOrdCount(overCount);
        statisOrder.setTotalOrdAmount(ConverterUtil.add(statisOrder.getEffOrdAmount(), statisOrder.getNotEffOrdAmount()));
        resultPoJo.setResult(statisOrder);
        return resultPoJo;
    }

    /**
     * 会员统计
     * @return
     */
    public ResultPoJo<StatisMembOrdVo> staticMembOrd () {
        ResultPoJo<StatisMembOrdVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //获取当前用户
        Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        Integer selMembCount = merchantMembMageMapper.selMembCount(sellerId);
        Integer selOrdMembCount = merchantMembMageMapper.selOrdMembCount(sellerId);
        StatisMembOrdVo selOrdStatic = merchantMembMageMapper.selOrdStatic(sellerId);
        selOrdStatic.setMembCount(selMembCount);
        selOrdStatic.setMembOrdCount(selOrdMembCount);
		selOrdStatic.setOverOrdCount(0D);
		selOrdStatic.setOverOrdAmount(0D);
        if (selMembCount != null && selMembCount != 0) {

			selOrdStatic.setOverOrdCount(ConverterUtil.div((double)selOrdStatic.getOrdCount(), (double)selMembCount, 2));
			selOrdStatic.setOverOrdAmount(ConverterUtil.div(selOrdStatic.getOrdAmount(), (double)selMembCount, 2));
		}
        resultPoJo.setResult(selOrdStatic);
        return resultPoJo;
    }

    /**
     * 采购商排名统计
     * @param po
     * @return
     */
    public ResultPoJo<Page<CgsOrderVo>> cgsOrdStatic (StaticOrderPo po) {
        ResultPoJo<Page<CgsOrderVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //判断是后台还是商家
        if ("0".equals(po.getMembFlag())) {
            //获取当前用户
            Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
            po.setSellerId(sellerId);
        }
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }
        Page<CgsOrderVo> page = po.getPage();
        List<CgsOrderVo> cgsOrdStatic = merchantMembMageMapper.cgsOrdStatic(po);
        page.setList(cgsOrdStatic);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 供应商排名统计
     * @param po
     * @return
     */
    public ResultPoJo<Page<CgsOrderVo>> gysOrdStatic (StaticOrderPo po) {
        ResultPoJo<Page<CgsOrderVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //判断是后台还是商家
        if ("0".equals(po.getMembFlag())) {
            //获取当前用户
            Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
            po.setSellerId(sellerId);
        }
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        Page<CgsOrderVo> page = po.getPage();
        List<CgsOrderVo> cgsOrdStatic = merchantMembMageMapper.gysOrdStatic(po);
        page.setList(cgsOrdStatic);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 交易数据统计
     * @param po
     * @return
     */
    public ResultPoJo<StatisTradeVo> statisTrade (StaticOrderPo po) {
        ResultPoJo<StatisTradeVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        //判断是后台还是商家
        if ("0".equals(po.getMembFlag())) {
            //获取当前用户
            Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
            po.setSellerId(sellerId);
        }
        //全部订单数
        Integer ordCount = 0;
        Double ordAmount = 0D;
        Integer ordCommCount = 0;
        Integer ordMembCount = 0;
        //有效订单
        Integer effOrdCount = 0;
        Double effOrdAmount = 0D;
        List<StatisOrderVo> statisList = mapper.statisOrder(po);
        for (StatisOrderVo e : statisList) {
            //全部
            ordCount += e.getEffOrdCount();
            ordCommCount += e.getEffCommCount();
            ordMembCount +=e.getEffMembCount();
            ordAmount = ConverterUtil.add(ordAmount, e.getEffOrdAmount());
            //有效订单
            if (!DictConstants.ORDER_STATE_TYPE_5.equals(e.getOrderStateType())) {

                effOrdCount += e.getEffOrdCount();
                effOrdAmount = ConverterUtil.add(effOrdAmount, e.getEffOrdAmount());
            }
        }
        //查询付款订单信息
        StatisOrderVo statisPayOrd = mapper.statisPayOrd(po);
        //查询退款信息
        Double statisRefund = mapper.statisRefund(po);
        StatisTradeVo statisOrder = new StatisTradeVo();
        statisOrder.setEffOrdAmount(effOrdAmount);
        statisOrder.setEffOrdCount(effOrdCount);
        statisOrder.setOrdAmount(ordAmount);
        statisOrder.setOrdCommCount(ordCommCount);
        statisOrder.setOrdCount(ordCount);
        statisOrder.setOrdMembCount(ordMembCount);
        //付款订单信息
        statisOrder.setPayOrdAmount(statisPayOrd.getEffOrdAmount());
        statisOrder.setPayOrdCommCount(statisPayOrd.getEffCommCount());
        statisOrder.setPayOrdCount(statisPayOrd.getEffOrdCount());
        statisOrder.setPayOrdMembCount(statisPayOrd.getEffMembCount());
        statisOrder.setRefundOrdAmount(statisRefund);
        //客单价
        statisOrder.setOverPrice(0D);
        if (statisOrder.getPayOrdAmount() != null) {

            statisOrder.setOverPrice(ConverterUtil.div(statisOrder.getPayOrdAmount(), statisOrder.getPayOrdMembCount(), 2));
        }
        List<String> daysYmd = Lists.newArrayList();
        if(ConverterUtil.isNotEmpty(po.getStartDate()) && ConverterUtil.isNotEmpty(po.getEndDate())){
            daysYmd = OffsetDateTimeUtils.getStartAndEndYmd(po.getStartDate(), po.getEndDate());
        }
        //查询图表
        if ("1".equals(po.getMembFlag())) {
            List<TransactionDataChartVo> countvo = mapper.selectTransactionDataChartVo(po);
            Map<String, TransactionDataChartVo> resultMap = countvo.stream().collect(Collectors.toMap(TransactionDataChartVo::getxPoint, Function.identity()));
            List<TransactionDataChartVo> chartVos = Lists.newArrayList();
            daysYmd.forEach(e -> {
                if (resultMap.containsKey(e)){
                    chartVos.add(resultMap.get(e));
                }else{
                    TransactionDataChartVo chartVo = new TransactionDataChartVo();
                    chartVo.setxPoint(e);
                    chartVo.setPayBuyerCount(0);
                    chartVo.setPayOrdCommRelaCount(0);
                    chartVo.setTotalPayAmount(0D);
                    chartVo.setTotalRefund(0D);
                    chartVos.add(chartVo);
                }
            });
            statisOrder.setChartVos(chartVos);
        }
        resultPoJo.setResult(statisOrder);
        return resultPoJo;
    }

    /**
     * 订单金额分布
     * @param po
     * @return
     */
    public ResultPoJo<List<ChartVo>> ordAmountStatis (StaticOrderPo po) {
        ResultPoJo<List<ChartVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        //判断是后台还是商家
        if ("0".equals(po.getMembFlag())) {
            //获取当前用户
            Long sellerId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
            po.setSellerId(sellerId);
        }
        List<ChartVo> ordAmountStatics = mapper.ordAmountStatics(po);
        resultPoJo.setResult(ordAmountStatics);
        return resultPoJo;
    }

    /**
     * 档口成交金额
     * @param po
     * @return
     */
    public ResultPoJo<List<ChartVo>> stallAmountStatis (StaticOrderPo po) {
        ResultPoJo<List<ChartVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //校验数据是否是本人
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        if (membInfo.getId() != membInfo.getMembId() && !"0".equals(membInfo.getPurSfAdminFlag())) {

            return resultPoJo;
        }
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        po.setSellerId(membInfo.getMembId());
        List<ChartVo> stallAmountStatis = mapper.stallAmountStatis(po);
        resultPoJo.setResult(stallAmountStatis);
        return resultPoJo;
    }

    /**
     * 采购商消费金额分布
     * @param po
     * @return
     */
    public ResultPoJo<List<ChartVo>> cgsPayCountStatics (StaticOrderPo po) {
        ResultPoJo<List<ChartVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(SystemUtils.getUserOnlyId().getId());
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        po.setSellerId(membInfo.getMembId());
        List<ChartVo> stallAmountStatis = mapper.cgsPayCountStatics(po);
        resultPoJo.setResult(stallAmountStatis);
        return resultPoJo;
    }

    /**
     * 收支明细列表(商家)
     * @param po
     * @return
     */
    public ResultPoJo<SellerIncomeListVo> incomeList (IncomeListPo po) {
        ResultPoJo<SellerIncomeListVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Long membId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        po.setSellerId(membId);
        //获取列表
        List<IncomeListVo> findIncomeList = incomeDetailMapper.findIncomeList(po);
        Double income = 0D;
        Double platF = 0D;
        //计算总收入
        for (IncomeListVo e : findIncomeList) {

            income = ConverterUtil.add(income, e.getSplitIncome());
            platF = ConverterUtil.add(platF, e.getOperSerCharge());
        }
        SellerIncomeListVo sellerIncomeListVo = new SellerIncomeListVo();
        sellerIncomeListVo.setIncomeList(findIncomeList);
        sellerIncomeListVo.setPlatTotal(platF);
        sellerIncomeListVo.setSplitIncomeTotal(income);
        resultPoJo.setResult(sellerIncomeListVo);
        return resultPoJo;
    }

    /**
     * 后台收支明细列表(后台)
     * @param po
     * @return
     */
    public ResultPoJo<Page<IncomeListVo>> platIncomeList (IncomeListPo po) {
        ResultPoJo<Page<IncomeListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Long membId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        Page<IncomeListVo> page = po.getPage();
        //获取列表
        List<IncomeListVo> findIncomeList = incomeDetailMapper.findIncomeList(po);
        page.setList(findIncomeList);
        resultPoJo.setResult(page);
        return resultPoJo;
    }

    /**
     * 导出后台收支明细列表(后台)
     * @param po
     * @return
     */
    public ResultPoJo<Page<IncomeListVo>> platIncomeListExp (IncomeListPo po, HttpServletResponse response) throws IOException {
        ResultPoJo<Page<IncomeListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Long membId = MembUtils.getMembIdFromUser(SystemUtils.getUser());
        //处理日期
        if (po.getStartDate() != null) {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(po.getStartDate()));
        }else {

            po.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-1)));
        }
        if (po.getEndDate() != null) {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getEndDate()));
        }else {

            po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now().plusDays(-1)));
        }
        //获取列表
        List<IncomeListVo> findIncomeList = incomeDetailMapper.findIncomeList(po);

        String fileName = "收支明细.xlsx";
        ExportExcel exportExcel = new ExportExcel("收支明细", IncomeListExpAdminVo.class);
        exportExcel.setDataList(findIncomeList).writeWithAjaxHeader(response, fileName).dispose();
        return resultPoJo;
    }

	/**
	 * 确认收货
	 * @param id
	 * @return
	 */
	public ResultPoJo<Object> receCommit (Long id) {
		ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		//获取订单信息，校验订单状态
		OrderInfo info = mapper.selectByPrimaryKey(id);
		if (!DictConstants.ORDER_STATE_TYPE_3.equals(info.getOrderStateType())) {
			resultPoJo.setCode(ConstantCodeMsg.ERR_455);
			resultPoJo.setMsg("该状态下不允许本次操作");
			return resultPoJo;
		}
		info.setOrderStateType(DictConstants.ORDER_STATE_TYPE_4);
		info.preUpdate();
		mapper.updateByPrimaryKeySelective(info);
    	return resultPoJo;
	}

	/***********************************************订单定时任务******************************************************/
	/**
	 * @Author jirg
	 * @Date 2020/5/26 16:40
	 * @Description 订单超时提货定时任务
	 */
	public ResultPoJo<List<OrderInfo>> orderDeliveryTask() {
		ResultPoJo<List<OrderInfo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		//查询超时待自提的订单列表
		List<OrderInfo> orders = mapper.findDeliveryTimeoutOrders();
		orders.forEach(e->{
			e.preUpdate();
			e.setOrderStateType(DictConstants.ORDER_STATE_TYPE_8);
			mapper.updateByPrimaryKey(e);
			//插入订单操作记录
			ordOpreateService.saveOrdOperate(e.getId(), OrdOperateEnum.DELIVERY, null);
			Logger logger = OrderLogger.getLogger(e.getId());
			logger.info("订单提货超时，订单状态变为【争议订单】，订单信息：[{}]", e);
		});
		return resultPoJo;
	}

	/**
	 * 订单确认、付款超时
	 */
	@Transactional(readOnly=false)
	public ResultPoJo<Object> orderCancelTask () {
	    ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
	    List<OrderInfo> ordList = mapper.findPreOutTimeOrders();

	    Map<Long, String> orderStateTypeMap = Maps.newHashMap();
		Map<Long, OrderInfo> orderInfoMap = ordList.stream().collect(Collectors.toMap(OrderInfo::getId, Function.identity()));

		ordList.forEach(e->{
		    if (DictConstants.ORDER_STATE_TYPE_0.equals(e.getOrderStateType())) {
		        //插入订单操作记录
		        ordOpreateService.saveOrdOperate(e.getId(), OrdOperateEnum.TIMEOUTCONFIRM, "确认订单超时，自动取消订单");
		    }else if (DictConstants.ORDER_STATE_TYPE_1.equals(e.getOrderStateType())) {
		        //插入订单操作记录
		        ordOpreateService.saveOrdOperate(e.getId(), OrdOperateEnum.TIMEOUTPAY, "付款超时，自动取消订单");
		    }
			orderStateTypeMap.put(e.getId(), e.getOrderStateType());
            e.preUpdate();
            e.setOrdCancelDate(OffsetDateTime.now());
            e.setOrderStateType(DictConstants.ORDER_STATE_TYPE_5);
            mapper.updateByPrimaryKey(e);
        });

		//事物提交之后发送消息
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				orderStateTypeMap.forEach((k, v) ->{
				    Map<Object, Object> param = Maps.newHashMap();
					if(v.equals(DictConstants.ORDER_STATE_TYPE_0)){
						//超时未确认订单取消
					    Map<String, Object> timMap = Maps.newHashMap();
					    timMap.put("timType", TIMNoticeConstants.TPL_KEY_ORD_CANCEL_TIMEOUT_TO_SALLER);
					    timMap.put("id", k);
					    timMap.put("staffId", orderInfoMap.get(k).getStallsId());
					    timMap.put("userId", orderInfoMap.get(k).getSellerId());
					    timMap.put("ordNum", orderInfoMap.get(k).getOrdNum());
					    //发送给商家
						timSendService.sendTim(timMap);
						Map<String, Object> timMapb = Maps.newHashMap();
						timMapb.put("timType", TIMNoticeConstants.TPL_KEY_ORD_CANCEL_TIMEOUT_TO_BUYER);
						timMapb.put("id", k);
						timMapb.put("staffId", orderInfoMap.get(k).getStallsId());
						timMapb.put("userId", orderInfoMap.get(k).getBuyerId());
						timMapb.put("ordNum", orderInfoMap.get(k).getOrdNum());
						//发送给买家
						timSendService.sendTim(timMapb);
					}else if(v.equals(DictConstants.ORDER_STATE_TYPE_1)){
						//超时未付款订单取消
                        Map<String, Object> timMap = Maps.newHashMap();
                        timMap.put("timType", TIMNoticeConstants.TPL_KEY_ORD_UN_PAY_CANCEL_TO_SALLER);
                        timMap.put("id", k);
                        timMap.put("staffId", orderInfoMap.get(k).getStallsId());
                        timMap.put("userId", orderInfoMap.get(k).getSellerId());
                        timMap.put("ordNum", orderInfoMap.get(k).getOrdNum());
						//发送给商家
						timSendService.sendTim(timMap);
						Map<String, Object> timMapb = Maps.newHashMap();
						timMapb.put("timType", TIMNoticeConstants.TPL_KEY_ORD_UN_PAY_CANCEL_TO_BUYER);
						timMapb.put("id", k);
						timMapb.put("staffId", orderInfoMap.get(k).getStallsId());
						timMapb.put("userId", orderInfoMap.get(k).getSellerId());
						timMapb.put("ordNum", orderInfoMap.get(k).getOrdNum());
						//发送给买家
						timSendService.sendTim(timMapb);
					}
				});
			}
		});

	    return resultPoJo;
	}

	/**
     * 订单自动分账
     * @throws IOException
     */
    @Transactional(readOnly=false)
    public ResultPoJo<Object> orderDivideTask (){
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        List<DivideEvent> selOutOfDivide = divideEventMapper.selOutOfDivide();

        for (DivideEvent divideEvent : selOutOfDivide) {
            //0是普通订单，1是结算单
            String remarks = divideEvent.getRemarks();
            DivideApiRequest divideApiRequest = new DivideApiRequest();
            divideApiRequest.setOrderId(divideEvent.getOrdId());
            divideApiRequest.setDivideDetail(divideEvent.getDivideDetail());

            ResultPoJo<Object> divide = divideApiService.division(divideApiRequest);
            Map<String, String> result = (Map<String, String>) divide.getResult();

            if ("20000".equals(divide.getCode()) && result != null) {

                divideEvent.setExeState("1");
            }else {

                divideEvent.setExeState("2");
            }
            divideEvent.preUpdate();
            divideEventMapper.updateByPrimaryKeySelective(divideEvent);
            /*//收入明细表里插入数据
            if (result != null) {
                //解析分账信息
                String[] splt = divideEvent.getDivideDetail().split(";");
                //卖家收入信息
                String[] sellerParams = splt[0].split("\\^");
                Double divAmount = Double.valueOf(sellerParams[1]);
                //平台服务费信息
                String[] platParams = splt[1].split("\\^");
                Double platAmount = Double.valueOf(platParams[1]);
                //获取订单、结算单信息
                Long ordId = ConverterUtil.toLong(divideEvent.getOrdId());
                IncomeDetail incomeDetail = new IncomeDetail();
                //判断是账期还是订单
                if ("1".equals(remarks)) {
                    //账期
                    SettleBill settleBill = settleBillMapper.selectByPrimaryKey(ordId);
                    incomeDetail.setMembId(settleBill.getSellerId());
                    incomeDetail.setSettleBillNumb(settleBill.getSettleBillNumb());
                }else {
                    //普通订单
                    OrderInfo orderInfo = mapper.selectByPrimaryKey(ordId);
                    incomeDetail.setMembId(orderInfo.getSellerId());
                    incomeDetail.setOrdNum(orderInfo.getOrdNum());
                }
                incomeDetail.setSettOrdId(ordId);
                incomeDetail.setTradeNo(result.get("divideRequestId"));
                //买家付款金额=卖家收入+平台服务费
                incomeDetail.setCommTotalPrice(ConverterUtil.add(divAmount, platAmount));
                incomeDetail.setFinishDate(OffsetDateTime.now());
                //分账收入=卖家收入
                incomeDetail.setSplitIncome(divAmount);
                //运营服务费=平台收入
                incomeDetail.setOperSerCharge(platAmount);
                incomeDetail.preInsert();
                incomeDetailMapper.insertSelective(incomeDetail);
            }*/
        }
        return resultPoJo;
    }
}
