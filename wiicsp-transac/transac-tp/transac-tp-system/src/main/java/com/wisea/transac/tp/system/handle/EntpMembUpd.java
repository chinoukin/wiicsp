package com.wisea.transac.tp.system.handle;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.EntpBankInfoMapper;
import com.wisea.transac.common.dao.ExamRecdMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.entity.ExamRecd;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.memb.AddRoleByUserIdPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.tp.system.service.memb.MembSupplierManagerService;
import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import com.wisea.yspay.entity.YspayEntpRecord;
import com.wisea.yspay.notify.handler.EntpAuthenticateNotificationHandler;

/**
 * 企业入网回调
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
public class EntpMembUpd extends EntpAuthenticateNotificationHandler{


	@Autowired
	private EntpAuthMapper entpAuthMapper;
	@Autowired
	private ExamRecdMapper examRecdMapper;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private UserMembInfoMss userMembInfoMss;
	@Autowired
	private TIMNoticeService timNoticeService;
	@Autowired
	private EntpBankInfoMapper entpBankInfoMapper;
	@Autowired
	private MembSupplierManagerService membSupplierManagerService;
	/**
	 * 企业入网回调
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@Override
	protected void handle(YspayEntpRecord record) {
		// 解析唯一的标识
		String entpId = TpSystemMembUtils.parseMemb(record.getMerchantNo());
		// 查询企业信息
		EntpAuth oldEntity = entpAuthMapper.selectByPrimaryKey(ConverterUtil.toLong(entpId));
		// 保存审核信息
		ExamRecd examRecd = new ExamRecd();
		examRecd.preInsert();
		examRecd.setRemarks(TpSystemMembUtils.SUPPLIER_AUTH_FLAG);
		examRecd.setMembId(oldEntity.getMembId());
		examRecd.setOperatDate(OffsetDateTime.now());
		examRecd.setOperator("第三方认证机构");
		// 企业认证信息
		EntpAuth entpAuth = new EntpAuth();
		entpAuth.setId(oldEntity.getId());
		entpAuth.setAuthDate(OffsetDateTime.now());
		// 审核成功的情况
		if(record.getApprovalStatus()){
			// 查询会员接口
			MembInfo oldMemb = membInfoMapper.selectByPrimaryKey(oldEntity.getMembId());
			MembInfo membInfo = new MembInfo();
			membInfo.setId(oldEntity.getMembId());
			membInfo.setMerchantNo(record.getUsercode());
			membInfo.setAgentFlag(DictConstants.AGENT_FLAG_0);// 设置成商家
			membInfo.setMembType(oldEntity.getCustType());// 会员类型 0：企业1：个体户
			membInfo.setEntpName(oldEntity.getEntpName());// 已经认证企业名称
			// 如果会员名称是空的情况将企业法人姓名设置成名称  20200814 产品确定
			if(ConverterUtil.isEmpty(oldMemb.getContName())){
				membInfo.setContName(oldEntity.getConter());
			}
			membInfoMapper.updateByPrimaryKeySelective(membInfo);
			// 企业表中的信息
			entpAuth.setAuthStateType(DictConstants.AUTH_STATE_TYPE_3);
			entpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
			entpAuth.setRpStateType(DictConstants.RP_STATE_TYPE_0);
			entpAuth.setExamFailReason(null);
			// 如果之前没有认证过商家则需要添加商家权限--通过后添加商家权限
			if(!SystemUtils.hasAllAuthor(oldEntity.getMembId(),"ROLE_seller_app")){
				// 查询旧Role
				AddRoleByUserIdPo addRoleByUserIdPo = new AddRoleByUserIdPo();
				addRoleByUserIdPo.setUserId(oldMemb.getId());
				List<String> codeList = Lists.newArrayList();
				codeList.add("ROLE_seller_app");
				addRoleByUserIdPo.setRoleCodeList(codeList);
				ResultPoJo<String> roleList = userMembInfoMss.addRoleById(addRoleByUserIdPo);
				if(!roleList.getCode().equals(ConstantError.NOMAL)){
					throw new BusinessException(roleList.getCode(), roleList.getMsg());
				}
			}
			examRecd.setOperatorContent(record.getApprovalMsg() + "(商家编号：" + record.getUsercode() + "+");
			// 店铺的处理
			membSupplierManagerService.addShopInfoInit(oldEntity.getMembId(), oldEntity.getEntpName(), oldEntity.getWholeSaleMarketId());
			// 清空缓存的处理
			MembUtils.delMembUser(oldMemb.getId());
			// 发送系统消息的处理
			Map<String, Object> dataModel = Maps.newHashMap();
			// TIMNoticeConstants为模板消息常量类 默认按照dataModel下发穿透数据
			timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_SALLER_AUTH_SUC, dataModel, Lists.newArrayList(ConverterUtil.toString(oldEntity.getMembId())));
			// 审核通过旧数据的处理
			// 查询旧的已经审核通过的数据
			EntpAuth oldEntp = entpAuthMapper.getEntpAuthPassByMembId(oldEntity.getMembId());
			if(oldEntp != null){
				// 删除企业信息
				EntpAuth oldEntpInfo = new EntpAuth();
				oldEntpInfo.setId(oldEntp.getId());
				oldEntpInfo.preUpdate();
				entpAuthMapper.updDelById(oldEntpInfo);
				// 删除企业银行卡信息
				entpBankInfoMapper.updDelByEntpId(oldEntpInfo);
			}
			// 审核失败的情况
		}else{
			examRecd.setOperatorContent(record.getApprovalMsg());
			entpAuth.setExamFailReason(record.getApprovalMsg());
			entpAuth.setAuthStateType(DictConstants.AUTH_STATE_TYPE_4);
		}
		// 保存审核信息
		examRecdMapper.insert(examRecd);
		// 保存企业信息
		entpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
		entpAuth.setLegalPersonValidityEnd(oldEntity.getLegalPersonValidityEnd());
		entpAuthMapper.updateByPrimaryKeySelective(entpAuth);
	}
}
