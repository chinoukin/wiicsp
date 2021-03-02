package com.wisea.cultivar.plant.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sms.SmsService;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.excel.ExportExcel;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.dao.ZhfwExamRecdMapper;
import com.wisea.cultivar.common.entity.ZhfwExamRecd;
import com.wisea.cultivar.common.mss.RemoteTIMAccountMss;
import com.wisea.cultivar.common.po.tim.RemotePortraitSetPo;
import com.wisea.cultivar.plant.entity.*;
import com.wisea.cultivar.plant.mapper.*;
import com.wisea.cultivar.plant.po.*;
import com.wisea.cultivar.plant.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wbf-code-generator
 * @version 1.0
 * @className ZhfwMembInfoService
 * @date 2020/08/06 18:28:39
 * @Description
 */
@Service
public class ZhfwMembInfoService extends BaseService {
    @Autowired
    private ZhfwMembInfoMapper mapper;
    @Autowired
	private EntpAuthMapper entpAuthMapper;
    @Autowired
	private RealPersonAuthMapper realPersonAuthMapper;
    @Autowired
	private ZhfwExamRecdMapper zhfwExamRecdMapper;
	@Autowired
	private MembMomentsLimitsMageMapper membMomentsLimitsMageMapper;
	@Autowired
	private ShopInfoMapper shopInfoMapper;
	@Autowired
	private RemoteTIMAccountMss timAccountMss;

	@Autowired
	private SmsService smsService;
	/**
	 * 检查手机号是否已经存在
	 * @param phoneNum
	 * @return
	 */
	public boolean checkMobile(String phoneNum){
		if(mapper.findByMobile(phoneNum).size()>0){
			return false;
		}
		return  true;
	}

	/**
	 * 服务商认证(入驻)
	 * @param po
	 * @return
	 */
	public ResultPoJo addInfo(ZhfwMembInfoPo po) {
		LoggerUtil.infoWithContext("【addInfo】服务商认证(入驻)：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		// check
		StringBuffer errMsg = new StringBuffer();
		checkData(po, errMsg);
		if (errMsg.length() > 0) {
			resultPoJo.setCode("70031");
			resultPoJo.setMsg(errMsg.toString());
			return resultPoJo;
		}

		//保存认证信息
		saveAuthInfo(po);

		//用户id
		Long membId = SystemUtils.getUserOnlyId().getId();

		// 审核
		ZhfwExamRecd zhfwExamRecd = new ZhfwExamRecd();
		zhfwExamRecd.setMembId(membId);
		zhfwExamRecd.setOperatDate(OffsetDateTime.now());
		zhfwExamRecd.setOperatorContent("提交认证");
		zhfwExamRecd.setOperator(SystemUtils.getUser().getLoginName());
		zhfwExamRecd.setAuthStateType("2");
		zhfwExamRecd.preInsert();
		zhfwExamRecdMapper.insert(zhfwExamRecd);

		// 店铺
		ShopInfo shopInfo = new ShopInfo();
		shopInfo.setMembId(membId);
		shopInfo.preInsert();
		shopInfoMapper.insert(shopInfo);

		// 圈子权限
		int[][] dictList = new int[][]{{0, 0}, {1, 1}, {2, 1}, {3, 1}};
		for (int x = 0; x < dictList.length; x++) {
			MembMomentsLimitsMage membMomentsLimitsMage = new MembMomentsLimitsMage();
			membMomentsLimitsMage.setMembId(membId);
			membMomentsLimitsMage.setMembMomentsLimitsType(String.valueOf(dictList[x][0]));
			membMomentsLimitsMage.setIfShow(String.valueOf(dictList[x][1]));
			membMomentsLimitsMage.preInsert();
			membMomentsLimitsMageMapper.insert(membMomentsLimitsMage);
		}

		return resultPoJo;
	}

	/**
	 * 修改服务商信息
	 * @param po
	 * @return
	 */
	public ResultPoJo updateInfo(ZhfwMembInfoPo po) {
		LoggerUtil.infoWithContext("【updateInfo】修改服务商信息：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		// check
		StringBuffer errMsg = new StringBuffer();
		if (ConverterUtil.isEmpty(po.getId())) {
			errMsg.append("id不能为空;");
		}

		checkData(po, errMsg);
		if (errMsg.length() > 0) {
			resultPoJo.setCode("70031");
			resultPoJo.setMsg(errMsg.toString());
			return resultPoJo;
		}

		saveAuthInfo(po);

		return resultPoJo;
	}

	/**
	 * 保存认证信息
	 */
	private void saveAuthInfo(ZhfwMembInfoPo po) {
		//修改用户信息
		updateMembInfo(po);

		//用户id
		Long membId = SystemUtils.getUserOnlyId().getId();

		if ("0".equals(po.getAuthType())) {//企业认证
			EntpAuth entpAuth = new EntpAuth();
			entpAuth.setMembId(membId);
			List<EntpAuth> auths = entpAuthMapper.findInfoByConditions(entpAuth);
			if (ConverterUtil.isEmpty(auths)) {
				//没有数据新增
				insertEntpAuth(po.getEntpAuth());
				//删除个人认证信息
				realPersonAuthMapper.deleteLogicByMembId(membId);
			}else {
				//有数据修改
				EntpAuth newAuth = po.getEntpAuth();
				newAuth.setId(auths.get(0).getId());
				newAuth.setMembId(membId);
				newAuth.setAuthType("0");
				newAuth.setAuthStateType("2");//审核状态:待审核
				newAuth.preUpdate();
				entpAuthMapper.updateByPrimaryKeySelective(newAuth);
			}
		} else {//个人认证
			RealPersonAuth realPersonAuth = new RealPersonAuth();
			realPersonAuth.setMembId(membId);
			List<RealPersonAuth> auths = realPersonAuthMapper.findInfoByConditions(realPersonAuth);
			if (ConverterUtil.isEmpty(auths)) {
				insertRealPersonAuth(po.getRealPersonAuth());
				//删除企业认证信息
				entpAuthMapper.deleteLogicByMembId(membId);
			}else {
				RealPersonAuth newRealPersonAuth = po.getRealPersonAuth();
				newRealPersonAuth.setId(auths.get(0).getId());
				newRealPersonAuth.setMembId(membId);
				newRealPersonAuth.setAuthType("1");
				newRealPersonAuth.setAuthStateType("2");//审核状态:待审核
				newRealPersonAuth.preUpdate();
				realPersonAuthMapper.updateByPrimaryKeySelective(newRealPersonAuth);
			}
		}
	}

	/**
	 * 新增个人认证表数据
	 */
	private void insertRealPersonAuth(RealPersonAuth realPersonAuth) {
		realPersonAuth.setMembId(SystemUtils.getUserOnlyId().getId());
		realPersonAuth.setAuthType("1");
		realPersonAuth.setAuthStateType("2");//审核状态:待审核
		realPersonAuth.preInsert();
		realPersonAuthMapper.insert(realPersonAuth);
	}

	/**
	 * 新增企业认证表数据
	 */
	private void insertEntpAuth(EntpAuth entpAuth) {
		entpAuth.setMembId(SystemUtils.getUserOnlyId().getId());
		entpAuth.setAuthType("0");
		entpAuth.setAuthStateType("2");//审核状态:待审核
		entpAuth.preInsert();
		entpAuthMapper.insert(entpAuth);
	}

	/**
	 * 认证修改会员表信息
	 */
	private void updateMembInfo(ZhfwMembInfoPo po) {
		//修改
		ZhfwMembInfo entity = new ZhfwMembInfo();
		//用户id
		entity.setId(SystemUtils.getUserOnlyId().getId());
		//认证状态 1-未认证
		entity.setEntpAuthStateType("1");
		//认证类型 0-企业 1-个人
		entity.setAuthType(po.getAuthType());
		if ("0".equals(po.getAuthType())) {// 企业认证
			EntpAuth entpAuth = po.getEntpAuth();
			entity.setEntpName(entpAuth.getEntpName());// 企业名称冗余保存
			entity.setOrgName(entpAuth.getEntpName());// 企业名称冗余保存
			//姓名
			entity.setContName(entpAuth.getConter());
		}else {
			//个人认证姓名
			entity.setContName(po.getRealPersonAuth().getRealName());
			//个人认证企业为名称用户名
			entity.setEntpName(po.getRealPersonAuth().getRealName());
			entity.setOrgName(po.getRealPersonAuth().getRealName());
		}
		entity.preUpdate();
		mapper.updateByPrimaryKeySelective(entity);
	}

	private void checkData(ZhfwMembInfoPo po, StringBuffer errMsg) {
		if (ConverterUtil.isEmpty(po.getAuthType())) {
			errMsg.append("认证类型[authType]不能为空;");
			if ("0".equals(po.getAuthType())) {// 企业认证
				if (po.getEntpAuth() == null) {
					po.setEntpAuth(new EntpAuth());
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getEntpName())) {
					errMsg.append("企业名称[entpAuth.entpName]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getCtscc())) {
					errMsg.append("统一社会信用代码[entpAuth.ctscc]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getAreaCou())) {
					errMsg.append("注册地区[entpAuth.areaProv/areaCity/areaCou]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getAddress())) {
					errMsg.append("统一社会信用代码[entpAuth.address]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getConter())) {
					errMsg.append("联系人[entpAuth.conter]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getContTel())) {
					errMsg.append("联系电话[entpAuth.contTel]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getYyzzUrl())) {
					errMsg.append("营业执照[entpAuth.yyzzUrl]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getLegalPersonName())) {
					errMsg.append("法人姓名[entpAuth.legalPersonName]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getLegalPersonNum())) {
					errMsg.append("身份证号[entpAuth.legalPersonNum]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getEntpAuth().getSfzZmUrl()) || ConverterUtil.isEmpty(po.getEntpAuth().getSfzFmUrl())) {
					errMsg.append("法人身份证照片[entpAuth.sfzZmUrl/sfzFmUrl]不能为空;");
				}
			} else if ("1".equals(po.getAuthType())){// 个人认证
				if (po.getRealPersonAuth() == null) {
					po.setRealPersonAuth(new RealPersonAuth());
				}
				if (ConverterUtil.isEmpty(po.getRealPersonAuth().getRealName())) {
					errMsg.append("姓名[realPersonAuth.realName]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getRealPersonAuth().getContTel())) {
					errMsg.append("联系电话[realPersonAuth.contTel]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getRealPersonAuth().getIdCardNum())) {
					errMsg.append("身份证号[realPersonAuth.idCardNum]不能为空;");
				}
				if (ConverterUtil.isEmpty(po.getRealPersonAuth().getSfzZmUrl()) || ConverterUtil.isEmpty(po.getRealPersonAuth().getSfzFmUrl())) {
					errMsg.append("法人身份证照片[realPersonAuth.sfzZmUrl/sfzFmUrl]不能为空;");
				}
			} else {
				errMsg.append("认证类型[authType]不存在;");
			}
		}
	}

	/**
	 * 种植会员管理列表/服务商列表
	 * @param po
	 * @return
	 */
	public ResultPoJo<Page<ZhfwMembInfoFindListVo>> findZhfwMembList(ZhfwMembInfoFindListPo po){
		LoggerUtil.infoWithContext("【findZhfwMembList】种植会员管理列表/服务商列表：", po);
		ResultPoJo<Page<ZhfwMembInfoFindListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ZhfwMembInfoFindListVo> page = po.getPage();
		List<ZhfwMembInfoFindListVo> list = null;
		String queryType = po.getQueryType();
		if ("0".equals(queryType)) {// 会员列表
			list = mapper.findZhfwMembList(po);
		} else {// 服务商列表
			list = mapper.findZhfwMembFwsList(po);
		}
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
	}

	/**
	 * 服务商信息审核
	 * @param po
	 * @return
	 */
	public ResultPoJo exam(ZhfwExamRecdOprePo po){
		LoggerUtil.infoWithContext("【exam】服务商信息审核：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

		// 审核结果
		ZhfwMembInfo entity = mapper.selectByPrimaryKey(po.getMembId());
		if ("0".equals(po.getAuthStateType())) {//审核通过
			entity.setEntpAuthStateType("0");//认证状态:已认证
			entity.preUpdate();
			mapper.updateByPrimaryKeySelective(entity);
		}

		if ("0".equals(entity.getAuthType())) {
			EntpAuth entpAuth = new EntpAuth();
			entpAuth.setMembId(po.getMembId());
			entpAuth = entpAuthMapper.findInfoByConditions(entpAuth).get(0);
			entpAuth.setAuthStateType(po.getAuthStateType()); // 审核状态:通过/不通过
			entpAuth.setExamFailReason(po.getExamFailReason()); // 审核意见
			entpAuth.preUpdate();
			entpAuthMapper.updateByPrimaryKeySelective(entpAuth);
		} else {
			RealPersonAuth realPersonAuth = new RealPersonAuth();
			realPersonAuth.setMembId(po.getMembId());
			realPersonAuth = realPersonAuthMapper.findInfoByConditions(realPersonAuth).get(0);
			realPersonAuth.setAuthStateType(po.getAuthStateType()); // 审核状态:通过/不通过
			realPersonAuth.setExamFailReason(po.getExamFailReason());// 审核意见
			realPersonAuth.preUpdate();
			realPersonAuthMapper.updateByPrimaryKeySelective(realPersonAuth);
		}

		// 审核记录
		ZhfwExamRecd zhfwExamRecd = new ZhfwExamRecd();
		zhfwExamRecd.setMembId(po.getMembId());
		zhfwExamRecd.setOperatDate(OffsetDateTime.now());
		zhfwExamRecd.setOperatorContent(po.getExamFailReason());
		zhfwExamRecd.setOperator(SystemUtils.getUser().getLoginName());
		zhfwExamRecd.preInsert();
		zhfwExamRecdMapper.insert(zhfwExamRecd);

		return resultPoJo;
	}

	/**
	 * 导出种植会员列表/服务商列表
	 * @param po
	 * @param response
	 */
	public void exportMembInfoList(ZhfwMembInfoFindListPo po, HttpServletResponse response) {
		LoggerUtil.infoWithContext("【exportMembInfoList】导出种植会员列表/服务商列表：", po);
		List<ZhfwMembInfoFindListVo> list = null;
		String queryType = po.getQueryType();
		po.setPage(null); //设置不分页
		if ("0".equals(queryType)) {// 会员列表
			list = mapper.findZhfwMembList(po);
			List<ZhfwMembInfoExportVo> exportDataList = Lists.newArrayList();
			BeanUtils.copyProperties(list, exportDataList);
			String fileName = "会员列表信息.xlsx";
			try {
				new ExportExcel("项目管理信息", ZhfwMembInfoExportVo.class)
						.setDataList(exportDataList)
						.writeWithAjaxHeader(response, fileName).dispose();
			} catch (IOException e) {
				throw new IllegalStateException("导出过程中出现异常", e);
			}

		} else {// 服务商列表
			list = mapper.findZhfwMembFwsList(po);
			List<ZhfwMembInfoFwsExportVo> exportDataList = Lists.newArrayList();
			BeanUtils.copyProperties(list, exportDataList);
			String fileName = "服务商列表信息.xlsx";
			try {
				new ExportExcel("项目管理信息", ZhfwMembInfoFwsExportVo.class)
						.setDataList(exportDataList)
						.writeWithAjaxHeader(response, fileName).dispose();
			} catch (IOException e) {
				throw new IllegalStateException("导出过程中出现异常", e);
			}
		}
	}

	/**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询ZhfwMembInfo
     */
    public ResultPoJo<Page<ZhfwMembInfoPageListVo>> findPageList(ZhfwMembInfoPageListPo po) {
        LoggerUtil.infoWithContext("【findPageList】分页查询列表：", po);
		ResultPoJo<Page<ZhfwMembInfoPageListVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		Page<ZhfwMembInfoPageListVo> page = po.getPage();
		List<ZhfwMembInfoPageListVo> list = mapper.findPageList(po);
		page.setList(list);
		resultPoJo.setResult(page);
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 逻辑删除ZhfwMembInfo
     */
    public ResultPoJo logicDel(LongIdPo po) {
        LoggerUtil.infoWithContext("【logicDel】逻辑删除：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ZhfwMembInfo entity = mapper.selectByPrimaryKey(po.getId());
		if(ConverterUtil.isNotEmpty(entity)){
			entity.setDelFlag(ZhfwMembInfo.DEL_FLAG_DELETE);
			entity.preUpdate();
			mapper.updateByPrimaryKey(entity);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 新增或修改ZhfwMembInfo
     */
    public ResultPoJo saveOrUpdate(ZhfwMembInfoPo po) {
        LoggerUtil.infoWithContext("【saveOrUpdate】新增或修改：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		if(ConverterUtil.isNotEmpty(po.getId())){
			//修改
			ZhfwMembInfo entity = mapper.selectByPrimaryKey(po.getId());
			if(ConverterUtil.isNotEmpty(entity)){
				BeanUtils.copyProperties(po, entity);
				entity.preUpdate();
				mapper.updateByPrimaryKeySelective(entity);
			}else{
				resultPoJo.setCode(ConstantError.ERR_004);
				resultPoJo.setMsg(ConstantError.MSG_004);
			}
		}else{
			//新增
			ZhfwMembInfo entity = new ZhfwMembInfo();
			BeanUtils.copyProperties(po, entity);
			entity.preInsert();
			mapper.insert(entity);
		}
		return resultPoJo;
    }

	/**
	 * 查询会员/服务商详情信息
	 * @param po
	 * @return
	 */
    public ResultPoJo<ZhfwMembInfoInfoVo> findInfo(LongIdPo po) {
        LoggerUtil.infoWithContext("【findInfo】查询会员/服务商详情信息：", po);
		ResultPoJo<ZhfwMembInfoInfoVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		ZhfwMembInfoInfoVo vo = mapper.findInfo(po);
		if(ConverterUtil.isNotEmpty(vo)){
			// 企业/个人
			if ("0".equals(vo.getAuthType())) {
				EntpAuth entpAuth = new EntpAuth();
				entpAuth.setMembId(po.getId());
				entpAuth = entpAuthMapper.findInfoByConditions(entpAuth).get(0);
				vo.setEntpAuth(entpAuth);
			} else if ("1".equals(vo.getAuthType())) {
				RealPersonAuth realPersonAuth = new RealPersonAuth();
				realPersonAuth.setMembId(po.getId());
				realPersonAuth = realPersonAuthMapper.findInfoByConditions(realPersonAuth).get(0);
				vo.setRealPersonAuth(realPersonAuth);
			}
			// 审核记录
			ZhfwExamRecd zhfwExamRecd = new ZhfwExamRecd();
			zhfwExamRecd.setMembId(po.getId());
			vo.setZhfwExamRecdList(zhfwExamRecdMapper.findByConditions(zhfwExamRecd));

			resultPoJo.setResult(vo);
		}else{
			resultPoJo.setCode(ConstantError.ERR_004);
			resultPoJo.setMsg(ConstantError.MSG_004);
		}
		return resultPoJo;
    }

	/**
	 * 用户登录后 获取我的信息
	 *
	 * @param
	 * @return
	 */
	public ResultPoJo<ZhfwMembInfoInfoVo> getInfo(LongIdPo po) {
		ResultPoJo<ZhfwMembInfoInfoVo> pojo = new ResultPoJo<>();
		//获取当前登录的用户信息
		//User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = mapper.selectByPrimaryKey(po.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			pojo.setCode(ConstantCodeMsg.ERR_505);
			pojo.setMsg(ConstantCodeMsg.MSG_505);
			return pojo;
		}
		ZhfwMembInfoInfoVo zhfwMembInfoInfoVo = new ZhfwMembInfoInfoVo();
		BeanUtils.copyProperties(zhfwMembInfo,zhfwMembInfoInfoVo);
		pojo.setCode(ConstantCodeMsg.ERR_000);
		pojo.setMsg(ConstantCodeMsg.MSG_000);
		pojo.setResult(zhfwMembInfoInfoVo);
		return pojo;
	}

	/**
	 * 修改用户信息 头像  姓名
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo updateInformation(ZhfwMembInfoPo po) {
		ResultPoJo pojo = new ResultPoJo();
		//获取当前登录的用户信息
		//User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(po.getId())){
			pojo.setCode("311");
			pojo.setMsg("会员id不能为空");
			return pojo;
		}
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = mapper.selectByPrimaryKey(po.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			pojo.setCode(ConstantCodeMsg.ERR_505);
			pojo.setMsg(ConstantCodeMsg.MSG_505);
			return pojo;
		}
		BeanUtils.copyProperties(po,zhfwMembInfo);
		zhfwMembInfo.preUpdate();
		mapper.updateByPrimaryKeySelective(zhfwMembInfo);

		//同步tim信息
		RemotePortraitSetPo remotePo = new RemotePortraitSetPo();
		List<RemotePortraitSetPo.RemoteProfileItem> profileItems = Lists.newArrayList();
		if(ConverterUtil.isNotEmpty(zhfwMembInfo.getContName())){
			RemotePortraitSetPo.RemoteProfileItem profileItem = new RemotePortraitSetPo.RemoteProfileItem();
			profileItem.setTag("Tag_Profile_IM_Nick"); //昵称 - 姓名
			profileItem.setValue(zhfwMembInfo.getContName());
			profileItems.add(profileItem);
		}
		if(ConverterUtil.isNotEmpty(zhfwMembInfo.getLogoUrl())){
			RemotePortraitSetPo.RemoteProfileItem profileItem2 = new RemotePortraitSetPo.RemoteProfileItem();
			profileItem2.setTag("Tag_Profile_IM_Image");
			profileItem2.setValue(zhfwMembInfo.getLogoUrl());
			profileItems.add(profileItem2);
		}
		if(ConverterUtil.isNotEmpty(profileItems)){
			remotePo.setFromAccount(zhfwMembInfo.getId().toString());
			remotePo.setProfileItem(profileItems);
			timAccountMss.userPortraitSet(remotePo);
		}
		pojo.setCode(ConstantCodeMsg.ERR_000);
		pojo.setMsg(ConstantCodeMsg.MSG_000);
		return pojo;
	}

	/**
	 * 更换手机号
	 * @param po
	 * @return
	 */
	public ResultPoJo changePhoneNumber(UpdPhoneNumebrPo po){
		ResultPoJo pojo = new ResultPoJo();
		// 验证手机号码是否被占用
		if (!this.checkMobile(po.getNewMobile())) {
			pojo.setCode(ConstantCodeMsg.ERR_501);
			pojo.setMsg(ConstantCodeMsg.MSG_501);
			return pojo;
		}
		//检查验证码是否正确
		if (!smsService.checkSMSCode(po.getOldMobile(), po.getValCode())) {
			pojo.setCode(ConstantCodeMsg.ERR_503);
			pojo.setMsg(ConstantCodeMsg.MSG_503);
			return pojo;
		}
		//User user = SystemUtils.getUser();
		//获取当前登录的用户会员信息
		ZhfwMembInfo zhfwMembInfo = mapper.selectByPrimaryKey(po.getId());
		if (ConverterUtil.isEmpty(zhfwMembInfo)) {//用户信息不存在
			pojo.setCode(ConstantCodeMsg.ERR_505);
			pojo.setMsg(ConstantCodeMsg.MSG_505);
			return pojo;
		}
		zhfwMembInfo.setContTel(po.getNewMobile());
		zhfwMembInfo.preUpdate();
		mapper.updateByPrimaryKeySelective(zhfwMembInfo);
		pojo.setCode(ConstantCodeMsg.ERR_000);
		pojo.setMsg(ConstantCodeMsg.MSG_000);
		return pojo;
	}

	/**
	 * 设置会员圈子背景图
	 * @param po
	 * @return
	 */
	public ResultPoJo setMomentsBjt(ZhfwMembInfoPo po) {
		LoggerUtil.infoWithContext("【setMomentsBjt】设置会员圈子背景图：", po);
		ResultPoJo resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
		// check
		StringBuffer errMsg = new StringBuffer();
		if (ConverterUtil.isEmpty(po.getId())) {
			errMsg.append("id不能为空;");
		}
		if (ConverterUtil.isEmpty(po.getMomentsBjtUrl())) {
			errMsg.append("圈子背景图[momentsBjtUrl]不能为空;");
		}
		if (errMsg.length() > 0) {
			resultPoJo.setCode("70034");
			resultPoJo.setMsg(errMsg.toString());
			return resultPoJo;
		}

		ZhfwMembInfo zhfwMembInfo = mapper.selectByPrimaryKey(po.getId());
		zhfwMembInfo.setMomentsBjtUrl(po.getMomentsBjtUrl());
		zhfwMembInfo.preUpdate();
		mapper.updateByPrimaryKeySelective(zhfwMembInfo);

		return resultPoJo;
	}
}
