package com.wisea.transac.tp.trade.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.dao.ApPayMageMapper;
import com.wisea.transac.common.dao.LateFeePropMageMapper;
import com.wisea.transac.common.entity.ApPayMage;
import com.wisea.transac.common.entity.LateFeePropMage;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.po.EnableDisablePo;
import com.wisea.transac.common.po.trade.ApPayMagePageListPo;
import com.wisea.transac.common.po.trade.ApPayMagePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.PageStateCountResultVo;
import com.wisea.transac.common.vo.trade.ApPayMageCountVo;
import com.wisea.transac.common.vo.trade.ApPayMageInfoVo;
import com.wisea.transac.common.vo.trade.ApPayMagePageListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ApPayMageService
 * @date 2020/04/27 17:01:29
 * @Description
 */
@Service
public class ApPayMageService extends BaseService {
    @Autowired
    private ApPayMageMapper mapper;
	@Autowired
	LateFeePropMageMapper lateFeePropMageMapper;
	@Autowired
	private TimSendService timSendService;

	/**
	 * @Author jirg
	 * @Date 2020/5/12 9:41
	 * @Description 开通账期支付
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo<?> openApPay() {
		User user = SystemUtils.getUser();
		LoggerUtil.infoWithContext("【openApPay】卖家开通账期支付服务：", user.getLoginName());
		ResultPoJo<?> resultPoJo = MembUtils.openApPay(user.getId());
		//产品：开通帐期不用发消息
//		if(resultPoJo.getCode().equals(ConstantCodeMsg.NOMAL)){
//			//事物提交之后发送消息
//			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
//				@Override
//				public void afterCommit() {
//					//开通成功 - 发送消息给当前登录用户
//					MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
//					Map<String, Object> dataModel = Maps.newHashMap();
//					timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_OPEN_AP_PAY_SUC, dataModel, Lists.newArrayList(ConverterUtil.toString(membBaseInfo.getMembId())));
//				}
//			});
//		}
		return resultPoJo;
	}

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询ApPayMage
     */
    public ResultPoJo<PageStateCountResultVo<ApPayMagePageListVo>> findPageList(ApPayMagePageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<PageStateCountResultVo<ApPayMagePageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		PageStateCountResultVo<ApPayMagePageListVo> vo = new PageStateCountResultVo();

		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		po.setSellerId(membInfo.getMembId());
		Page<ApPayMagePageListVo> page = po.getPage();
		//分页查询账期设置列表
		List<ApPayMagePageListVo> list = mapper.findPageList(po);
		//查询角标数量
		ApPayMageCountVo countVo = mapper.findApPayMageCount(po);
		//封装数据
		Map<String, Integer> stateCountMap = Maps.newHashMap();
		if(ConverterUtil.isNotEmpty(countVo)){
			stateCountMap.put("0", ConverterUtil.isEmpty(countVo.getHasBeenSetCount()) ? 0 : countVo.getHasBeenSetCount());
			stateCountMap.put("1", ConverterUtil.isEmpty(countVo.getFreezeCount()) ? 0 : countVo.getFreezeCount());
			stateCountMap.put("2", ConverterUtil.isEmpty(countVo.getNotSetCount()) ? 0 : countVo.getNotSetCount());
		}else{
			stateCountMap.put("0", 0);
			stateCountMap.put("1", 0);
			stateCountMap.put("2", 0);
		}

		page.setList(list);
		vo.setPage(page);
		vo.setStateCountMap(stateCountMap);
		resultPoJo.setResult(vo);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息ApPayMage
     */
    public ResultPoJo<ApPayMageInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询详细信息：", po);
		ResultPoJo<ApPayMageInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ApPayMageInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * @Author jirg
	 * @Date 2020/5/12 15:32
	 * @Description 新增或修改账期设置
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo saveOrUpdate(ApPayMagePo po) {
		LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改账期设置：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		//判断是否设置了滞纳金比例
		if(ConverterUtil.isNotEmpty(po.getOverdueLateFeeProp())){
			//判断是否大于后台设置的滞纳金比例上限
			LateFeePropMage lateFeeMage = lateFeePropMageMapper.getLateFeeMage();
			if(ConverterUtil.isNotEmpty(lateFeeMage) && po.getOverdueLateFeeProp() > lateFeeMage.getOverdueLateFeeProp()){
				resultPoJo.setCode(ConstantCodeMsg.ERR_418);
				resultPoJo.setMsg(MessageFormat.format(ConstantCodeMsg.MSG_418, lateFeeMage.getOverdueLateFeeProp()));
				return resultPoJo;
			}
		}else{
			po.setOverdueLateFeeProp(0D);
		}

		User user = SystemUtils.getUser();
		MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ApPayMage entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				Double acctCreditLine = entity.getAcctCreditLine();
				BeanUtils.copyProperties(po, entity);
				//重新计算可用额度 =（新授信额度 - 旧授信额度 + 可用额度）  可以为负
				Double availableCredit = ConverterUtil.add(ConverterUtil.sub(entity.getAcctCreditLine(), acctCreditLine), entity.getAvailableCredit());
				entity.setAvailableCredit(availableCredit);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			//校验当前卖家是否已经对买家设置过账期支付
			ApPayMage apPayMage = mapper.findByIds(membInfo.getMembId(), po.getMembId());
			if(ConverterUtil.isNotEmpty(apPayMage)){
				resultPoJo.setCode(ConstantCodeMsg.ERR_419);
				resultPoJo.setMsg(ConstantCodeMsg.MSG_419);
				return resultPoJo;
			}
			apPayMage = new ApPayMage();
			BeanUtils.copyProperties(po, apPayMage);
			apPayMage.setAvailableCredit(apPayMage.getAcctCreditLine()); //新增可用额度等于授信额度
			apPayMage.setSellerId(membInfo.getMembId());
			apPayMage.preInsert();
			mapper.insert(apPayMage);
			//事物提交之后发送消息
			Map<String, Object> param = Maps.newHashMap();
			param.put("timType", TIMNoticeConstants.TPL_KEY_CREDIT_INFO_SUC);
			param.put("id", apPayMage.getId());
			param.put("userId", apPayMage.getMembId());
			param.put("entpName", membInfo.getAuthName());
			param.put("acctCreditLine", apPayMage.getAcctCreditLine());
			ApPayMage finalApPayMage = apPayMage;
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					//向买家发送消息
					timSendService.sendTim(param);
				}
			});
		}
		return resultPoJo;
	}

	/**
	 * @Author jirg
	 * @Date 2020/5/12 16:00
	 * @Description 启用/停用账期设置
	 **/
	@Transactional(readOnly = false)
	public ResultPoJo enableDisable(EnableDisablePo po) {
		LoggerUtil.infoWithContext("【enableDisable】启用/停用账期设置：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ApPayMage entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setCreditType(po.getEnableDisableType());
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);

			if(po.getEnableDisableType().equals(DictConstants.CREDIT_TYPE_1)){
				//事物提交之后发送消息
				User user = SystemUtils.getUser();
				MembBaseInfo membInfo = MembUtils.getMembInfoByUserId(user.getId());

				Map<String, Object> param = Maps.newHashMap();
				param.put("timType", TIMNoticeConstants.TPL_KEY_CREDIT_REMIND_SUC);
				param.put("id", entity.getId());
				param.put("userId", entity.getMembId());
				param.put("entpName", membInfo.getAuthName());
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {
						//向买家发送消息
						timSendService.sendTim(param);
					}
				});
			}
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
	}
}
