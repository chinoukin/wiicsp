package com.wisea.transac.tp.trade.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
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
import com.wisea.transac.common.dao.SettleBillEleInvoFileMapper;
import com.wisea.transac.common.dao.SettleBillInvoMapper;
import com.wisea.transac.common.dao.SettleBillMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.SettleBill;
import com.wisea.transac.common.entity.SettleBillEleInvoFile;
import com.wisea.transac.common.entity.SettleBillInvo;
import com.wisea.transac.common.po.SettleBillInvoPageListPo;
import com.wisea.transac.common.po.trade.InvoicingPo;
import com.wisea.transac.common.utils.DeadLineUtils;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.SettleBillInvoInfoVo;
import com.wisea.transac.common.vo.SettleBillInvoPageListVo;
import com.wisea.transac.tp.trade.constants.SettleBillOperateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className SettleBillInvoService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class SettleBillInvoService extends BaseService {
    @Autowired
    private SettleBillInvoMapper mapper;
	@Autowired
	private SettleBillMapper settleBillMapper;
    @Autowired
    private SettleBillEleInvoFileMapper invoFileMapper;
	@Autowired
	private SettleBillOpreateInfoService opreateInfoService;
	@Autowired
	private TimSendService timSendService;


    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询SettleBillInvo
     */
    public ResultPoJo<PageStateCountResultVo<SettleBillInvoPageListVo>> findPageList(SettleBillInvoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<PageStateCountResultVo<SettleBillInvoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		PageStateCountResultVo vo = new PageStateCountResultVo();

		//获取当前登录卖家ID
		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		po.setSellerId(membInfo.getMembId());

		//查询各个订单状态下的数量
		Page<SettleBillInvoPageListVo> page = po.getPage();
		po.setPage(null);
		Map<String, Integer> stateCountMap = mapper.findCountByState(po);
		vo.setStateCountMap(stateCountMap);

		//查询列表
		po.setPage(page);
		List<SettleBillInvoPageListVo> list = mapper.findPageList(po);
		OffsetDateTime now = OffsetDateTime.now();
		list.forEach(e->{
			e.setNowDate(now);
		});

		page.setList(list);
		vo.setPage(page);
		resultPoJo.setResult(vo);
		return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/19 17:19
     * @Description 查询结算单发票详细信息
     */
    public ResultPoJo<SettleBillInvoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询结算单发票详细信息：", po);
		ResultPoJo<SettleBillInvoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBillInvoInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			vo.setNowDate(OffsetDateTime.now());
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/5/18 9:50
     * @Description 结算单开票
     **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> invoicing(InvoicingPo po) {
		LoggerUtil.infoWithContext("【invoicing】结算单开票：", po);
		ResultPoJo<SettleBillInvoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		SettleBillInvo settleBillInvo = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(settleBillInvo)){
			//判断状态  （待开票） 或 （待验票并且有验票异议）
			String invoState = settleBillInvo.getInvoState();
			if(invoState.equals(DictConstants.INVO_STATE_0) ||
					(invoState.equals(DictConstants.INVO_STATE_1) &&
						settleBillInvo.getExamInvoDissType().equals(DictConstants.EXAM_INVO_DISS_TYPE_1))){
				settleBillInvo.setEntryOpenInvoType(po.getEntryOpenInvoType());
				settleBillInvo.setLogisticsCompName(po.getLogisticsCompName());
				settleBillInvo.setLogisticsNum(po.getLogisticsNum());
				settleBillInvo.setOpenInvoRemarks(po.getOpenInvoRemarks());
				settleBillInvo.setDrawDate(OffsetDateTime.now());
				settleBillInvo.setInvoState(DictConstants.INVO_STATE_1);
				settleBillInvo.setExamInvoDissType(DictConstants.EXAM_INVO_DISS_TYPE_0);
				settleBillInvo.preUpdate();
				mapper.updateByPrimaryKey(settleBillInvo);

				//设置结算单验票截止日
				SettleBill settleBill = settleBillMapper.selectByPrimaryKey(settleBillInvo.getSettleId());
				Integer examBillDeadline = DeadLineUtils.getLimitDaysByType(DictConstants.DEAD_LINE_TYPE_7);
				settleBill.setExamBillDeadline(OffsetDateTimeUtils.getDayMaxTime(OffsetDateTime.now()).plusDays(examBillDeadline));
				settleBillMapper.updateByPrimaryKey(settleBill);

				//删除旧的电子发票文件
				invoFileMapper.delByInvoId(po.getId());
				if(ConverterUtil.isNotEmpty(po.getInvoFiles())){
					List<SettleBillEleInvoFile> invoFiles = Lists.newArrayList();
					po.getInvoFiles().forEach(e->{
						SettleBillEleInvoFile invoFile = new SettleBillEleInvoFile();
						invoFile.setSettleBillInvoId(settleBillInvo.getId());
						invoFile.setEleInvoUrl(e.getFileUrl());
						invoFile.setRemarks(e.getFileName());
						invoFile.preInsert();
						invoFiles.add(invoFile);
					});
					invoFileMapper.batchInsert(invoFiles);
				}
				//插入结算单操作记录
				if(invoState.equals(DictConstants.INVO_STATE_0)){
					opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.INVOICING, null);
				}else if(invoState.equals(DictConstants.INVO_STATE_1)){
					opreateInfoService.saveSettleBillOperate(settleBill.getId(), SettleBillOperateEnum.RENEW_INVOICING, null);
				}

				//事物提交之后发送消息
				Map<String, Object> param = Maps.newHashMap();
				param.put("timType", TIMNoticeConstants.TPL_KEY_SETTLE_TICKET_REMINDER);
				param.put("id", settleBill.getId());
				param.put("userId", settleBill.getBuyerId());
				param.put("ordNum", settleBill.getSettleBillNumb());
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
					//向买家发送消息
					timSendService.sendTim(param);
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
