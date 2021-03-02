package com.wisea.transac.tp.system.service.memb;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.EntpBankInfoMapper;
import com.wisea.transac.common.dao.ExamRecdMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.PurchaseStaffMageMapper;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.entity.ExamRecd;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.memb.EntpDataInfoExamPo;
import com.wisea.transac.common.po.memb.MembBuyerAuthExportPo;
import com.wisea.transac.common.po.memb.MembBuyerExportPo;
import com.wisea.transac.common.po.memb.MembForBuyerAuthPageListPo;
import com.wisea.transac.common.po.memb.MembForBuyerPageListPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.EntpAuthInfoInitVo;
import com.wisea.transac.common.vo.memb.MembForBuyerAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerListVo;
import com.wisea.transac.common.vo.memb.MembInfoExportListExcelVo;

/**
 * 采购商管理相关的接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月26日
 * @version 1.0
 */
@Service
public class MembBuyerManagerService {


	@Autowired
	private EntpAuthMapper entpAuthMapper;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private ExamRecdMapper examRecdMapper;
	@Autowired
    private TIMNoticeService timNoticeService;
	@Autowired
	private PurchaseStaffMageMapper purchaseStaffMageMapper;
	@Autowired
	private EntpBankInfoMapper entpBankInfoMapper;
	/**
	 * 采购商管理- 采购商会员管理查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月20日
	 * @version 1.0
	 */
	public ResultPoJo<MembForManagerInfoVo> findBuyerMembList(MembForBuyerPageListPo po){
		// 返回追初期化处理
		ResultPoJo<MembForManagerInfoVo> result = new ResultPoJo<MembForManagerInfoVo>(ConstantCodeMsg.NOMAL);
		MembForManagerInfoVo vo = new MembForManagerInfoVo();
		// 查询头部统计信息
		vo = entpAuthMapper.membForSellerStatistical();
		// 分页查询列表信息
		Page<MembForManagerListVo> page = po.getPage();
		po.setRegistStartDate(OffsetDateTimeUtils.getDayMinTime(po.getRegistStartDate()));// 注册开始时间
		po.setRegistEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getRegistEndDate()));// 注册结束时间
	    page.setList(entpAuthMapper.findSellerMembList(po));
	    vo.setPageList(page);
	    result.setResult(vo);
		return result;
	}
	/**
	 * 采购商管理- 采购商认证管理查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月21日
	 * @version 1.0
	 */
	public ResultPoJo<MembForBuyerAuthInfoVo> findBuyerAuthList(MembForBuyerAuthPageListPo po){
		// 返回追初期化处理
		ResultPoJo<MembForBuyerAuthInfoVo> result = new ResultPoJo<MembForBuyerAuthInfoVo>(ConstantCodeMsg.NOMAL);
		MembForBuyerAuthInfoVo vo = new MembForBuyerAuthInfoVo();
		// 查询头部统计信息
		vo = entpAuthMapper.findSellerAuthStatistical();
		// 分页查询列表信息
		Page<MembForManagerListVo> page = po.getPage();
		po.setAuthStartDate(OffsetDateTimeUtils.getDayMinTime(po.getAuthStartDate()));// 审核开始使劲啊
		po.setAuthEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getAuthEndDate()));// 审核结束时间
	    page.setList(entpAuthMapper.findSellerAuthList(po));
	    vo.setPageList(page);
		result.setResult(vo);
		return result;
	}
	/**
	 * 导出供应商会员管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public List<MembInfoExportListExcelVo> membBuyerInfoListExport(MembBuyerExportPo po){
		return entpAuthMapper.findSellerMembListImport(po);
	}
	/**
	 * 导出采购商认证管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public List<MembInfoExportListExcelVo> membBuyerAuthInfoListExport(MembBuyerAuthExportPo po){
		return entpAuthMapper.findSellerAuthListImport(po);
	}
	/**
	 * 采购商认证审核处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月29日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> sellerMembAuth(EntpDataInfoExamPo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证id是否正确
		EntpAuthInfoInitVo oldEntity = entpAuthMapper.getEntpDetailById(po.getId());
		if(ConverterUtil.isEmpty(oldEntity) || ConverterUtil.isEmpty(oldEntity.getMembId())){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		// 保存审核信息
		ExamRecd examRecd = new ExamRecd();
		examRecd.preInsert();
		examRecd.setMembId(oldEntity.getMembId());
		examRecd.setOperator(user.getLoginName());
		examRecd.setOperatDate(examRecd.getCreateDate());
		String operatorContent = po.getOperatorContent();
		examRecd.setRemarks(TpSystemMembUtils.SELLER_AUTH_FLAG);
		// 设置商家审核状态
		EntpAuth newEntpAuth = new EntpAuth();
		newEntpAuth.setId(po.getId());
		// 发送系统消息的处理
		Map<String, Object> dataModel = Maps.newHashMap();
		String tplKey = null;
		List<String> msgPList = Lists.newArrayList();
		// 审核通过的情况
		if(DictConstants.AUTH_STATE_TYPE_1.equals(po.getAuthExamState())){
			// 会员需要处理的内容
			MembInfo  newMembInfo = new MembInfo();
			newMembInfo.setId(oldEntity.getMembId());
			if(ConverterUtil.isEmpty(operatorContent)){
				operatorContent = "平台审核实名认证通过;";
			}
			MembInfo oldMemb = membInfoMapper.selectByPrimaryKey(oldEntity.getMembId());
			if(ConverterUtil.isEmpty(oldMemb.getAgentFlag()) || DictConstants.AGENT_FLAG_1.equals(oldMemb.getAgentFlag())){
				newMembInfo.setAgentFlag(DictConstants.AGENT_FLAG_1);// 设置成非商家
				newMembInfo.setMembType(oldEntity.getCustType());// 会员类型 0：企业1：个体户
				newMembInfo.setEntpName(oldEntity.getEntpName());// 已经认证企业名称
				newMembInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
			}
			// 如果会员名称是空的情况如果是个体户则将经营者姓名设置成名称 如果是企业则将法人设置成名称
			if(ConverterUtil.isEmpty(oldMemb.getContName())){
				newMembInfo.setContName(oldEntity.getLegalPersonName());
			}
			// 设置企业信息
			newEntpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);// 设置成已经认证
			if(DictConstants.CUST_TYPE_0.equals(oldEntity.getCustType())){
				tplKey = TIMNoticeConstants.TPL_KEY_ENP_AUTH_SUC;
				msgPList = purchaseStaffMageMapper.findPurMageAdminList(oldEntity.getMembId());
			}else{
				tplKey = TIMNoticeConstants.TPL_KEY_PRI_AUTH_SUC;
			}
			// 审核通过之前数据的处理
			EntpAuth oldEntp = entpAuthMapper.getEntpRzPassByMembId(oldEntity.getMembId());
			if(oldEntp != null){
				// 删除企业信息
				EntpAuth oldEntpInfo = new EntpAuth();
				oldEntpInfo.setId(oldEntp.getId());
				oldEntpInfo.preUpdate();
				entpAuthMapper.updDelById(oldEntpInfo);
				// 删除企业银行卡信息
				entpBankInfoMapper.updDelByEntpId(oldEntpInfo);
			}
			// 保存会员信息
			membInfoMapper.updateByPrimaryKeySelective(newMembInfo);
		// 驳回的情况
		}else if(DictConstants.AUTH_STATE_TYPE_4.equals(po.getAuthExamState())){
			newEntpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_3);
			newEntpAuth.setExamFailReason(po.getOperatorContent());
			dataModel.put("backReson", po.getOperatorContent());
			if(DictConstants.CUST_TYPE_0.equals(oldEntity.getCustType())){
				tplKey = TIMNoticeConstants.TPL_KEY_ENP_AUTH_FAL;
			}else{
				tplKey = TIMNoticeConstants.TPL_KEY_PRI_AUTH_FAL;
			}
		// 其他的情况
		}else{
			result.setCode(ConstantCodeMsg.ERR_001);
			result.setMsg(ConstantCodeMsg.MSG_001);
			return result;
		}
		// 审核历史记录的处理
		examRecd.setOperatorContent(operatorContent);
		examRecdMapper.insert(examRecd);
		// 保存企业审核表中的信息
		newEntpAuth.setAuthDate(OffsetDateTime.now());// 审核时间
		newEntpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
		newEntpAuth.setLegalPersonValidityEnd(oldEntity.getLegalPersonValidityEnd());
		entpAuthMapper.updateByPrimaryKeySelective(newEntpAuth);
		// 清空缓存的处理
		MembUtils.delMembUser(oldEntity.getMembId());
		// 发送消息的处理
		// TIMNoticeConstants为模板消息常量类 默认按照dataModel下发穿透数据
		msgPList.add(ConverterUtil.toString(oldEntity.getMembId()));
		timNoticeService.sendTpl(tplKey, dataModel, msgPList);
		return result;
	}
}
