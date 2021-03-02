package com.wisea.cultivar.infomanage.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.memb.*;
import com.wisea.cultivar.common.vo.memb.*;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.constants.DictConstants;
import com.wisea.cultivar.common.dao.EntpAuthMapper;
import com.wisea.cultivar.common.dao.MembInfoMapper;
import com.wisea.cultivar.common.dao.ZhfwExamRecdMapper;
import com.wisea.cultivar.common.entity.EntpAuth;
import com.wisea.cultivar.common.entity.ZhfwExamRecd;
import com.wisea.cultivar.common.entity.MembInfo;
import com.wisea.cultivar.common.utils.TpSystemMembUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 批发市场运营平台会员管理相关接
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@Service
public class MembSupplierManagerService extends BaseService{

	@Autowired
	private EntpAuthMapper entpAuthMapper;
	@Autowired
	private ZhfwExamRecdMapper zhfwExamRecdMapper;
    @Autowired
    private MembInfoMapper membInfoMapper;
	/**
	 * 供应商管理-会员管理列表查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月20日
	 * @version 1.0
	 */
	public ResultPoJo<Page<MembForManagerListVo>> findSupplierMmebList(MembForSellerPageListPo po){
		// 返回追初期化处理
        ResultPoJo<Page<MembForManagerListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		// 分页查询列表信息
		Page<MembForManagerListVo> page = po.getPage();
	    page.setList(entpAuthMapper.findSupplierMembList(po));
        result.setResult(page);
		return result;
	}
	/**
	 * 供应商管理-认证管理列表查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月21日
	 * @version 1.0
	 */
	public ResultPoJo<Page<MembForServiceListVo>> findSupplierAuthList(MembForMangerPageListPo po){
		// 返回追初期化处理
		ResultPoJo<Page<MembForServiceListVo>> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		// 分页查询列表信息
        Page<MembForServiceListVo> page = po.getPage();
        page.setList(entpAuthMapper.findSupplierAuthList(po));
		result.setResult(page);
		return result;
	}
	/**
	 * 供应商会员的审核处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> authEntpDataInfo(EntpDataInfoExamPo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}

        //企业
        if(po.getAuthType().equals(DictConstants.CUST_TYPE_0)) {
            // 验证id是否正确
            EntpAuthInfoInitVo oldEntity = entpAuthMapper.getEntpDetailById(po.getId());
            if (ConverterUtil.isEmpty(oldEntity) || ConverterUtil.isEmpty(oldEntity.getMembId())) {
                result.setCode(ConstantCodeMsg.ERR_711);
                result.setMsg(ConstantCodeMsg.MSG_711);
                return result;
            }
            // 保存审核信息
            ZhfwExamRecd zhfwExamRecd = new ZhfwExamRecd();
            zhfwExamRecd.setMembId(oldEntity.getMembId());
            zhfwExamRecd.setOperator(user.getLoginName());
            zhfwExamRecd.setOperatDate(OffsetDateTime.now());
            String operatorContent = po.getOperatorContent();
            zhfwExamRecd.setRemarks(TpSystemMembUtils.SUPPLIER_AUTH_FLAG);
            // 设置商家审核状态
            EntpAuth newEntpAuth = new EntpAuth();
            newEntpAuth.setId(po.getId());
            newEntpAuth.setExamFailReason(po.getOperatorContent());
            //审核状态“待审核”可以进行“审核”操作。
            if (oldEntity.getAuthStateType().equals(DictConstants.AUTH_STATE_TYPE_2)) {
                if (po.getAuthExamState().equals(DictConstants.AUTH_STATE_TYPE_1)) { //审核未通过
                    // 保存企业审核表中的信息
                    newEntpAuth.setAuthStateType(po.getAuthExamState());
                    newEntpAuth.setExamFailReason(operatorContent);
                    newEntpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
                    newEntpAuth.setLegalPersonValidity(oldEntity.getLegalPersonValidity());
                    entpAuthMapper.updateByPrimaryKeySelective(newEntpAuth);
                    // 审核历史记录的处理
                    zhfwExamRecd.setOperatorContent(operatorContent);
                    zhfwExamRecd.setAuthStateType(po.getAuthExamState());   //记录表中存入审核未通过状态
                    zhfwExamRecd.preInsert();
                    zhfwExamRecdMapper.insert(zhfwExamRecd);
                    return result;
                } else if (po.getAuthExamState().equals(DictConstants.AUTH_STATE_TYPE_0)) { //审核通过
                    // 保存企业审核表中的信息
                    newEntpAuth.setExamFailReason(operatorContent);
                    newEntpAuth.setAuthStateType(po.getAuthExamState());    //审核状态
                    newEntpAuth.setAuthDate(OffsetDateTime.now());
                    newEntpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
                    newEntpAuth.setLegalPersonValidity(oldEntity.getLegalPersonValidity());
                    newEntpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0); //认证状态
                    entpAuthMapper.updateByPrimaryKeySelective(newEntpAuth);
                    //会员认证设置
                    MembInfo membInfo = new MembInfo();
                    membInfo.setId(oldEntity.getMembId());
                    membInfo.setOrgName(oldEntity.getEntpName());
                    membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
                    membInfoMapper.updateByPrimaryKeySelective(membInfo);
                    // 审核历史记录的处理
                    zhfwExamRecd.setOperatorContent(operatorContent);
                    zhfwExamRecd.setAuthStateType(po.getAuthExamState());   //记录表中存入审核通过状态
                    zhfwExamRecd.preInsert();
                    zhfwExamRecdMapper.insert(zhfwExamRecd);
                    return result;
                }
            } else {
                result.setCode(ConstantCodeMsg.ERR_001);
                result.setMsg(ConstantCodeMsg.MSG_001);
                return result;
            }
        }else if(po.getAuthType().equals(DictConstants.CUST_TYPE_1)) {  //个人
                // 验证id是否正确
                EntpAuthInfoInitVo oldEntity = entpAuthMapper.getRealPersonDetailById(po.getId());
                if (ConverterUtil.isEmpty(oldEntity) || ConverterUtil.isEmpty(oldEntity.getMembId())) {
                    result.setCode(ConstantCodeMsg.ERR_711);
                    result.setMsg(ConstantCodeMsg.MSG_711);
                    return result;
                }
                // 保存审核信息
                ZhfwExamRecd zhfwExamRecd = new ZhfwExamRecd();
                zhfwExamRecd.setMembId(oldEntity.getMembId());
                zhfwExamRecd.setOperator(user.getLoginName());
                zhfwExamRecd.setOperatDate(OffsetDateTime.now());
                String operatorContent = po.getOperatorContent();
                zhfwExamRecd.setRemarks(TpSystemMembUtils.SUPPLIER_AUTH_FLAG);
                // 设置商家审核状态
                EntpAuth newEntpAuth = new EntpAuth();
                newEntpAuth.setId(po.getId());
                newEntpAuth.setExamFailReason(po.getOperatorContent());
                //审核状态“待审核”可以进行“审核”操作。
                if (oldEntity.getAuthStateType().equals(DictConstants.AUTH_STATE_TYPE_2)) {
                    if (po.getAuthExamState().equals(DictConstants.AUTH_STATE_TYPE_1)) { //审核未通过
                        // 保存企业审核表中的信息
                        newEntpAuth.setExamFailReason(operatorContent);
                        newEntpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
                        newEntpAuth.setLegalPersonValidity(oldEntity.getLegalPersonValidity());
                        newEntpAuth.setAuthStateType(po.getAuthExamState());
                        entpAuthMapper.updateByRealPerson(newEntpAuth);
                        // 审核历史记录的处理
                        zhfwExamRecd.setOperatorContent(operatorContent);
                        zhfwExamRecd.setAuthStateType(po.getAuthExamState());   //记录表中存入审核未通过状态
                        zhfwExamRecd.preInsert();
                        zhfwExamRecdMapper.insert(zhfwExamRecd);
                        return result;
                    } else if (po.getAuthExamState().equals(DictConstants.AUTH_STATE_TYPE_0)) { //审核通过
                        // 保存企业审核表中的信息
                        newEntpAuth.setExamFailReason(operatorContent);
                        newEntpAuth.setAuthStateType(po.getAuthExamState());    //审核状态
                        newEntpAuth.setAuthDate(OffsetDateTime.now());
                        newEntpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
                        newEntpAuth.setLegalPersonValidity(oldEntity.getLegalPersonValidity());
                        newEntpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0); //认证状态
                        entpAuthMapper.updateByRealPerson(newEntpAuth);
                        //会员认证设置
                        MembInfo membInfo = new MembInfo();
                        membInfo.setId(oldEntity.getMembId());
                        membInfo.setOrgName(oldEntity.getRealName());
                        membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
                        membInfoMapper.updateByPrimaryKeySelective(membInfo);
                        // 审核历史记录的处理
                        zhfwExamRecd.setOperatorContent(operatorContent);
                        zhfwExamRecd.setAuthStateType(po.getAuthExamState());   //记录表中存入审核通过状态
                        zhfwExamRecd.preInsert();
                        zhfwExamRecdMapper.insert(zhfwExamRecd);
                        return result;
                    }
                } else {
                    result.setCode(ConstantCodeMsg.ERR_001);
                    result.setMsg(ConstantCodeMsg.MSG_001);
                    return result;
                }
            }
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
	public List<MembInfoExportListExcelVo> membSellerInfoListExport(MembSellerExportPo po){
		return entpAuthMapper.findSupplierMembListImport(po);
	}
	/**
	 * 导出供应商认证管理列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public List<MembForServiceExcelVo> membSellerAuthInfoListExport(MembSellerAuthExportPo po){
		return entpAuthMapper.findSupplierAuthListImport(po);
	}

}
