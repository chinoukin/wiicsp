package com.wisea.transac.tp.system.service.memb;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.wisea.transac.tp.system.properties.ThridAuthPropertis;
import com.wisea.transac.tp.system.properties.YsPayEntpRegProProperties;
import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.exception.BusinessException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.model.Page;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.TIMNoticeConstants;
import com.wisea.transac.common.dao.BaseInfoMapper;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.EntpBankInfoMapper;
import com.wisea.transac.common.dao.ExamRecdMapper;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.dao.ShopInfoMapper;
import com.wisea.transac.common.dao.StallsMageMapper;
import com.wisea.transac.common.dao.TradAreaMageMapper;
import com.wisea.transac.common.dao.WholeSaleMarketMageMapper;
import com.wisea.transac.common.entity.BaseInfo;
import com.wisea.transac.common.entity.EntpAuth;
import com.wisea.transac.common.entity.ExamRecd;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.ShopInfo;
import com.wisea.transac.common.entity.StallsMage;
import com.wisea.transac.common.entity.WholeSaleMarketMage;
import com.wisea.transac.common.mss.RemoteCustomerMss;
import com.wisea.transac.common.mss.UserMembInfoMss;
import com.wisea.transac.common.po.customer.CustomerConfigUserInsertPo;
import com.wisea.transac.common.po.customer.SysImCustomerConfigInsertPo;
import com.wisea.transac.common.po.memb.AddRoleByUserIdPo;
import com.wisea.transac.common.po.memb.EntpDataInfoExamPo;
import com.wisea.transac.common.po.memb.MembForMangerPageListPo;
import com.wisea.transac.common.po.memb.MembForSellerPageListPo;
import com.wisea.transac.common.po.memb.MembSellerAuthExportPo;
import com.wisea.transac.common.po.memb.MembSellerExportPo;
import com.wisea.transac.common.po.memb.RpStateUpdPo;
import com.wisea.transac.common.po.system.TradAreaMageListPo;
import com.wisea.transac.common.service.TIMNoticeService;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.EntpAuthInfoInitVo;
import com.wisea.transac.common.vo.memb.MembEntpRpExportVo;
import com.wisea.transac.common.vo.memb.MembForManagerAuthInfoVo;
import com.wisea.transac.common.vo.memb.MembForManagerListVo;
import com.wisea.transac.common.vo.memb.MembForSellerInfoVo;
import com.wisea.transac.common.vo.memb.MembInfoExportListExcelVo;
import com.wisea.transac.common.vo.seller.BaseInfoVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.system.TradAreaMageListVo;
import com.wisea.yspay.request.EntpAuthenticateRequest;
import com.wisea.yspay.service.EnterpriseApiService;

import io.seata.spring.annotation.GlobalTransactional;

/**
 * 批发市场运营平台会员管理相关接
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@Service
@EnableConfigurationProperties({YsPayEntpRegProProperties.class, ThridAuthPropertis.class })
public class MembSupplierManagerService extends BaseService{

	@Autowired
	private EntpAuthMapper entpAuthMapper;
	@Autowired
	private ExamRecdMapper examRecdMapper;
	@Autowired
	private EnterpriseApiService enterpriseApiService;
	@Autowired
	private YsPayEntpRegProProperties ysPayEntpRegProProperties;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private UserMembInfoMss userMembInfoMss;
	@Autowired
	private TIMNoticeService timNoticeService;
	@Autowired
	private BaseInfoMapper baseInfoMapper;
	@Autowired
	private ShopInfoMapper shopInfoMapper;
	@Autowired
	private EntpBankInfoMapper entpBankInfoMapper;
	@Autowired
	private RemoteCustomerMss remoteCustomerMss;
	@Autowired
	private ThridAuthPropertis thridAuthPropertis;
	@Autowired
	private StallsMageMapper stallsMageMapper;
	@Autowired
	private WholeSaleMarketMageMapper wholeSaleMarketMageMapper;
	@Autowired
	private TradAreaMageMapper tradAreaMageMapper;

	/**
	 * 供应商管理-会员管理列表查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月20日
	 * @version 1.0
	 */
	public ResultPoJo<MembForSellerInfoVo> findSupplierMmebList(MembForSellerPageListPo po){
		// 返回追初期化处理
		ResultPoJo<MembForSellerInfoVo> result = new ResultPoJo<MembForSellerInfoVo>(ConstantCodeMsg.NOMAL);
		MembForSellerInfoVo vo = new MembForSellerInfoVo();
		// 查询头部统计信息
		vo = entpAuthMapper.membSupperlierStatistical(po);
		// 分页查询列表信息
		Page<MembForManagerListVo> page = po.getPage();
		po.setRegistStartDate(OffsetDateTimeUtils.getDayMinTime(po.getRegistStartDate()));// 注册开始时间
		po.setRegistEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getRegistEndDate()));// 注册结束时间
	    page.setList(entpAuthMapper.findSupplierMembList(po));
	    vo.setPageList(page);
	    result.setResult(vo);
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
	public ResultPoJo<MembForManagerAuthInfoVo> findSupplierAuthList(MembForMangerPageListPo po){
		// 返回追初期化处理
		ResultPoJo<MembForManagerAuthInfoVo> result = new ResultPoJo<MembForManagerAuthInfoVo>(ConstantCodeMsg.NOMAL);
		MembForManagerAuthInfoVo vo = new MembForManagerAuthInfoVo();
		// 查询头部统计信息
		vo = entpAuthMapper.membAuthSupperlierStatistical(po);
		// 分页查询列表信息
		Page<MembForManagerListVo> page = po.getPage();
		po.setAuthStartDate(OffsetDateTimeUtils.getDayMinTime(po.getAuthStartDate()));// 审核开始使劲啊
		po.setAuthEndDate(OffsetDateTimeUtils.getDayMaxTime(po.getAuthEndDate()));// 审核结束时间
	    page.setList(entpAuthMapper.findSupplierAuthList(po));
	    vo.setPageList(page);
		result.setResult(vo);
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
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<String> authEntpDataInfo(EntpDataInfoExamPo po){
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
		examRecd.setRemarks(TpSystemMembUtils.SUPPLIER_AUTH_FLAG);
		// 设置商家审核状态
		EntpAuth newEntpAuth = new EntpAuth();
		newEntpAuth.setId(po.getId());
		newEntpAuth.setAuthDate(OffsetDateTime.now());
		// 待平台审核审核通过的情况
		if(DictConstants.AUTH_STATE_TYPE_1.equals(po.getAuthExamState())){
			// 判断是否是产地用户
			MembInfo oldMemb = membInfoMapper.selectByPrimaryKey(oldEntity.getMembId());
			if(Constants.NO.equals(oldMemb.getLocalityMembType())){
				if(ConverterUtil.isEmpty(operatorContent)){
					operatorContent = "平台审核通过;";
				}
				// 会员信息的处理
				MembInfo membInfo = new MembInfo();
				membInfo.setId(oldEntity.getMembId());
				membInfo.setAgentFlag(DictConstants.AGENT_FLAG_0);// 设置成商家
				membInfo.setMembType(oldEntity.getCustType());// 会员类型 0：企业1：个体户
				membInfo.setEntpName(oldEntity.getEntpName());// 已经认证企业名称
				membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
				// 如果会员名称是空的情况将企业法人姓名设置成名称 20200814 产品确定
				if(ConverterUtil.isEmpty(oldMemb.getContName())){
					membInfo.setContName(oldEntity.getLegalPersonName());
				}
				membInfoMapper.updateByPrimaryKeySelective(membInfo);
				// 如果之前没有认证过商家则需要添加商家权限--通过后添加商家权限
				if(!SystemUtils.hasAllAuthor(oldEntity.getMembId(),"ROLE_local_app")){
					// 查询旧Role
					AddRoleByUserIdPo addRoleByUserIdPo = new AddRoleByUserIdPo();
					addRoleByUserIdPo.setUserId(oldMemb.getId());
					List<String> codeList = Lists.newArrayList();
					codeList.add("ROLE_local_app");
					addRoleByUserIdPo.setRoleCodeList(codeList);
					ResultPoJo<String> roleList = userMembInfoMss.addRoleById(addRoleByUserIdPo);
					if(!roleList.getCode().equals(ConstantError.NOMAL)){
						throw new BusinessException(roleList.getCode(), roleList.getMsg());
					}
				}
				// 发送系统消息的处理
				Map<String, Object> dataModel = Maps.newHashMap();
				// TIMNoticeConstants为模板消息常量类 默认按照dataModel下发穿透数据
				timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_SALLER_AUTH_SUC, dataModel, Lists.newArrayList(ConverterUtil.toString(oldEntity.getMembId())));
				// 企业信息的保存
				newEntpAuth.setAuthStateType(DictConstants.AUTH_STATE_TYPE_3);
				newEntpAuth.setRpStateType(DictConstants.RP_STATE_TYPE_0);
				newEntpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
				newEntpAuth.setExamFailReason(null);
				BaseInfoVo oldBase = baseInfoMapper.findByMembId(oldEntity.getMembId());
				// 基地信息的保存处理
				if(oldBase == null || ConverterUtil.isEmpty(oldBase.getId())){
					BaseInfo baseInfo = new BaseInfo();
					baseInfo.preInsert();
					baseInfo.setMembId(oldEntity.getMembId());
					baseInfo.setBaseName(oldEntity.getEntpName());
					baseInfo.setRemarks(oldEntity.getEntpName());
					baseInfoMapper.insert(baseInfo);
					SysImCustomerConfigInsertPo customer = new SysImCustomerConfigInsertPo();
					customer.setGroupId(ConverterUtil.toString(baseInfo.getId()));
					customer.setType("0");
					customer.setUserList(new ArrayList<CustomerConfigUserInsertPo>());
					ResultPoJo<Object> cusResult = remoteCustomerMss.customerConfigInsert(customer);
					if(!cusResult.getCode().equals(ConstantError.NOMAL)){
						checkRemoteResult(cusResult);
					}
				}
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
			// 商家APP会员的情况
			}else{
				// 配置文件中是否需要模拟审核的处理
				if(thridAuthPropertis.isEnabled()){
					if(ConverterUtil.isEmpty(operatorContent)){
						operatorContent = "平台审核通过;";
					}
					// 会员信息的处理
					MembInfo membInfo = new MembInfo();
					membInfo.setId(oldEntity.getMembId());
					membInfo.setMerchantNo(thridAuthPropertis.getMerchantNo());
					membInfo.setAgentFlag(DictConstants.AGENT_FLAG_0);// 设置成商家
					membInfo.setMembType(oldEntity.getCustType());// 会员类型 0：企业1：个体户
					membInfo.setEntpName(oldEntity.getEntpName());// 已经认证企业名称
					membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
					// 如果会员名称是空的情况将企业法人姓名设置成名称  20200814 产品确定
					if(ConverterUtil.isEmpty(oldMemb.getContName())){
						membInfo.setContName(oldEntity.getLegalPersonName());
					}
					membInfoMapper.updateByPrimaryKeySelective(membInfo);
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
					// 发送系统消息的处理
					Map<String, Object> dataModel = Maps.newHashMap();
					// TIMNoticeConstants为模板消息常量类 默认按照dataModel下发穿透数据
					timNoticeService.sendTpl(TIMNoticeConstants.TPL_KEY_SALLER_AUTH_SUC, dataModel, Lists.newArrayList(ConverterUtil.toString(oldEntity.getMembId())));
					// 企业信息的保存
					newEntpAuth.setAuthStateType(DictConstants.AUTH_STATE_TYPE_3);
					newEntpAuth.setRpStateType(DictConstants.RP_STATE_TYPE_0);
					newEntpAuth.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_0);
					newEntpAuth.setExamFailReason(null);
					// 店铺的处理
					addShopInfoInit(oldEntity.getMembId(), oldEntity.getEntpName(), oldEntity.getWholeSaleMarketId());
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
				}else{
					// 待第三方审核处理
					newEntpAuth.setAuthStateType(DictConstants.AUTH_STATE_TYPE_1);
					if(ConverterUtil.isEmpty(operatorContent)){
						operatorContent = "平台审核通过,银行审核中;";
					}
					// 提交到盛京银行
					try {
						ResultPoJo<Object> authResult = enterpriseApiService.entpAuthenticate(sjPayEntpparameter(oldEntity));
						// 审核未通过的情况
						if(!authResult.getCode().equals(ConstantCodeMsg.NOMAL)){
							checkRemoteResult(authResult);
						}
					} catch (Exception e) {
						LoggerUtil.error("第三方审核操作异常：", e);
						if(e instanceof BusinessException){
							throw (BusinessException)e;
						}else{
							result.setCode(ConstantCodeMsg.ERR_523);
							result.setMsg(ConstantCodeMsg.MSG_523);
							checkRemoteResult(result);
						}
					}
				}
			}
		// 审核驳回的情况
		}else if(DictConstants.AUTH_STATE_TYPE_4.equals(po.getAuthExamState())){
			newEntpAuth.setAuthStateType(DictConstants.AUTH_STATE_TYPE_4);
			newEntpAuth.setExamFailReason(po.getOperatorContent());
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
		newEntpAuth.setYyzzValidityEnd(oldEntity.getYyzzValidityEnd());
		newEntpAuth.setLegalPersonValidityEnd(oldEntity.getLegalPersonValidityEnd());
		entpAuthMapper.updateByPrimaryKeySelective(newEntpAuth);
		// 清空缓存的处理
		MembUtils.delMembUser(oldEntity.getMembId());
		return result;
	}
	/**
	 * 审核通过的情况 店铺以及档口的初期化处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年7月27日
	 * @version 1.0
	 */
	public void addShopInfoInit(Long membId,String entpName,Long marketId){
		// 市场下交易区验证 --必须存在交易区
		TradAreaMageListPo po = new TradAreaMageListPo();
		po.setWholeSaleMarketId(marketId);
		List<TradAreaMageListVo> findList = tradAreaMageMapper.findList(po);
		if(findList == null || findList.size() == 0){
			throw new BusinessException(ConstantCodeMsg.ERR_856, ConstantCodeMsg.MSG_856);
		}
		// 店铺初期化
		ShopInfoInfoVo oldshopInfo = shopInfoMapper.findInfoByMerchantId(membId);
		if(oldshopInfo == null || ConverterUtil.isEmpty(oldshopInfo.getId())){
			ShopInfo shopInfo = new ShopInfo();
			shopInfo.preInsert();
			shopInfo.setMerchantId(membId);
			shopInfo.setShopName(entpName);
			shopInfoMapper.insert(shopInfo);
			// 添加店铺客服分组信息
			SysImCustomerConfigInsertPo customer = new SysImCustomerConfigInsertPo();
			customer.setGroupId(ConverterUtil.toString(shopInfo.getId()));
			customer.setType("0");
			customer.setUserList(new ArrayList<CustomerConfigUserInsertPo>());
			ResultPoJo<Object> cusResult = remoteCustomerMss.customerConfigInsert(customer);
			if(!cusResult.getCode().equals(ConstantError.NOMAL)){
				 throw new BusinessException(cusResult.getCode(), cusResult.getMsg());
			}
			// 查询市场信息
			WholeSaleMarketMage wholeSaleMarketMage = wholeSaleMarketMageMapper.selectByPrimaryKey(marketId);
			//新增档口初期化处理
	        StallsMage stallsMage = new StallsMage();
	        stallsMage.preInsert();
	        stallsMage.setShopId(shopInfo.getId());// 店铺ID
	        stallsMage.setStallsName(entpName);// 档口名称
	        stallsMage.setWholeSaleMarketId(wholeSaleMarketMage.getId());//市场ID
	        stallsMage.setAreaProv(wholeSaleMarketMage.getAreaProv());
	        stallsMage.setAreaCity(wholeSaleMarketMage.getAreaCity());
	        stallsMage.setAreaCou(wholeSaleMarketMage.getAreaCou());
	        stallsMage.setAddress(wholeSaleMarketMage.getAddress());
	        stallsMage.setEffeInvalState(DictConstants.EFFE_INVAL_STATE_0);
	        stallsMage.setTradAreaId(findList.get(0).getId());// 市场下的交易区(默认第一个交易区)
	        stallsMageMapper.insert(stallsMage);
	        // 添加档口客服分组信息
	        SysImCustomerConfigInsertPo configInsertPo = new SysImCustomerConfigInsertPo();
	        configInsertPo.setGroupId(stallsMage.getId().toString());
	        configInsertPo.setType("0");
	        configInsertPo.setUserList(new ArrayList<>());
	        ResultPoJo<Object> poJo = remoteCustomerMss.customerConfigInsert(configInsertPo);
	        if (!poJo.getCode().equals(ConstantError.NOMAL)) {
	            throw new BusinessException(poJo.getCode(), poJo.getMsg());
	        }
		}
	}
	/**
	 * 企业报备的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> rpStateUpd(RpStateUpdPo po){
		// 返回初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>();
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 验证处理
		List<EntpAuth> list = entpAuthMapper.batchSelRpstateType(po.getIds());
		if(list != null && list.size() > 0){
			String flag = null;
			String msg = null;
			// 报备中
			if(DictConstants.RP_STATE_TYPE_1.equals(po.getRpStateType())){
				flag = "0";
				msg = "  不是待报备状态,请查看后提交;";
			// 已报备
			}else if(DictConstants.RP_STATE_TYPE_2.equals(po.getRpStateType())){
				flag = "1";
				msg = "  不是报备中状态,请查看后提交;";
			}else{
				result.setCode(ConstantCodeMsg.ERR_001);
				result.setMsg(ConstantCodeMsg.MSG_001);
				return result;
			}
			List<String> entpList = Lists.newArrayList();
			List<Long> ids = Lists.newArrayList();
			for(EntpAuth entity : list){
				if(ConverterUtil.isEmpty(entity.getRpStateType()) || !flag.equals(entity.getRpStateType())){
					entpList.add(entity.getEntpName());
				}
				ids.add(entity.getId());
				// 清楚缓存处理
				MembUtils.delMembUser(entity.getMembId());
			}
			if(entpList != null && entpList.size() > 0){
				result.setCode(ConstantCodeMsg.ERR_001);
				result.setMsg(String.join(",",entpList) + msg);
				return result;
			}
			po.setIds(ids);
		}else{
			result.setCode(ConstantCodeMsg.ERR_001);
			result.setMsg(ConstantCodeMsg.MSG_001);
			return result;
		}
		// 批量修改的处理
		entpAuthMapper.batchUpdRpStateType(po);
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
	public List<MembInfoExportListExcelVo> membSellerAuthInfoListExport(MembSellerAuthExportPo po){
		return entpAuthMapper.findSupplierAuthListImport(po);
	}
	/**
	 * 导出 供应商认证报备信息列表
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月19日
	 * @version 1.0
	 */
	public List<MembEntpRpExportVo> membAuthRpListExport(MembSellerAuthExportPo po){
		return entpAuthMapper.membAuthRpListExport(po);
	}
	/**
	 * 银行入网参数的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月25日
	 * @version 1.0
	 */
	private EntpAuthenticateRequest sjPayEntpparameter(EntpAuthInfoInitVo entpAuth){
		EntpAuthenticateRequest entity = new EntpAuthenticateRequest();
		/**  企业信息           **/
		entity.setMerchantNo(TpSystemMembUtils.getMerchantNo(entpAuth.getId()));
		entity.setCustType(TpSystemMembUtils.changeCustType(entpAuth.getCustType()));//客户类型O：小微；B：企业；C:个体
		entity.setAnotherName(entpAuth.getEntpShortName());//商户简称
		entity.setCustName(entpAuth.getEntpName());//公司名称或者客户名称，客户类型是小微商户时客户名称需和身份证号码、法人手机号码匹配
		String areaName = MembUtils.getAreaNameByCode(entpAuth.getAreaProv());
		entity.setProvince(areaName);//省
		if(areaName != null && MembUtils.government.contains(areaName)){
			entity.setCity(areaName);//市
		}else{
			entity.setCity(MembUtils.getAreaNameByCode(entpAuth.getAreaCity()));//市
		}
		entity.setArea(MembUtils.getAreaNameByCode(entpAuth.getAreaCou()));// 县
		entity.setCompanyAddr(entpAuth.getAddress());//详细地址
		entity.setLegalName(entpAuth.getLegalPersonName());//企业法人名字，需和身份证号码、法人手机号码匹配，当客户类型为小微商户是，企业法人可以为空，
		entity.setLegalTel(entpAuth.getLegalPersonTel());//企业法人手机号码
		entity.setMail(entpAuth.getEmail());//登陆邮箱，请按照正确邮箱格式填写
		entity.setContactMan(entpAuth.getConter());//联系人
		entity.setContactPhone(entpAuth.getContTel());//联系人手机号码
		entity.setLegalCertType(ysPayEntpRegProProperties.getLegalCertType());//企业法人证件类型
		entity.setLegalCertNo(entpAuth.getLegalPersonNum());//企业法人证件号,请加密传输 注：使用DES加密，密钥Src用户号前8位，不足8位前补
		entity.setLegalCertExpire(OffsetDateTimeUtils.formatDateTimeToYmd(entpAuth.getLegalPersonValidityEnd()));//企业法人证件有效期,格式为yyyyMMdd。为空时默认长期有效
		entity.setBusLicense(entpAuth.getCtscc());//营业执照，客户类型为个体商户、企业户时为必填，为保证商户信息准确，请填写有效营业执照号
		entity.setBusLincenceBegin(OffsetDateTimeUtils.formatDateTimeToYmd(entpAuth.getYyzzValidityStart()));//营业执照有效开始期，客户类型为个体商户、企业商户时为必填，格式为yyyyMMdd
		entity.setBusLicenseExpire(OffsetDateTimeUtils.formatDateTimeToYmd(entpAuth.getYyzzValidityEnd()));//营业执照有效期，客户类型为个体商户、企业商户时为必填，格式为yyyyMMdd
		entity.setNotifyType(ysPayEntpRegProProperties.getNotifyType()); //通知方式，此通知为商户号审核通知，通知内容包含帐号信息，为空的情况下将不发送通知，支持通知方式1、邮箱，2手机短信，3、邮箱+手机短信
	    entity.setBankAccountNo(entpAuth.getBankInfoVo().getEntpBankNum());//银行帐号，注：当bank_account_type为对公账户时，该属性字段长度可以为String(1,32)
	    entity.setBankAccountName(entpAuth.getLegalPersonName());//开户人，银行卡账户名，需和法人姓名或客户姓名一致
	    entity.setCertNo(entpAuth.getLegalPersonNum());//开户人证件号码，请加密传输
	    entity.setBankAccountType(TpSystemMembUtils.changeBankAcctType(entpAuth.getBankInfoVo().getBankAcctType()));//银行账户类型，此处必填 corporate :对公账户;personal:对私账户
		entity.setBankCardType(ysPayEntpRegProProperties.getBankCardType());//银行卡类型，可填debit|credit|unit  debit借记卡，credit贷记卡，unit单位结算卡
		entity.setBankName(entpAuth.getBankInfoVo().getAcctOpenSubBank());//开户行名称，为交易能顺利进行，请尽可能填写到街道
		entity.setBankType(entpAuth.getBankInfoVo().getKhName());//银行行别
		entity.setBankProvince(entpAuth.getBankInfoVo().getKhProv());//开户行所在的省份
		entity.setBankCity(entpAuth.getBankInfoVo().getKhCity());//开户行所在城市
		entity.setCertType(ysPayEntpRegProProperties.getCertType());//开户人证件类型，目前只支持00,00为身份证
		entity.setBankTelephoneNo(entpAuth.getBankInfoVo().getBankReservedTel());//银行预留手机号
		// 证件信息
		entity.setLegalIdCardPositive(entpAuth.getSfzZmUrl());//法人身份证正面
		entity.setLegalIdCardReverse(entpAuth.getSfzFmUrl());//法人身份证反面
		entity.setHoldingIdCard(entpAuth.getHoldSfzZmUrl());//法人手持身份证
		entity.setIdValidDateBegin(OffsetDateTimeUtils.formatDateTimeToYmd(entpAuth.getLegalPersonValidityStart()));// 法人身份证开始时间
		// 法人身份证有效期
		if(entpAuth.getLegalPersonValidityEnd() != null){
			entity.setLegalCertExpire(OffsetDateTimeUtils.formatDateTimeToYmd(entpAuth.getLegalPersonValidityEnd()));
		}
		entity.setPhysicalStore(entpAuth.getMtzUrl());//门头照（实体店门面照）
		entity.setBusinessLicense(entpAuth.getYyzzUrl());//营业执照（个体、企业必填）
		entity.setSettleBankCardPositive(entpAuth.getBankInfoVo().getBankCardZmUrl());//结算银行卡正面（小微、个体必填）
		entity.setSettleBankCardReverse(entpAuth.getBankInfoVo().getBankCardFmUrl());//结算银行卡反面（小微、个体必填）
		if(ConverterUtil.isNotEmpty(entpAuth.getBankInfoVo().getRegistAgreementFile())){
			entity.setCustomerAgreement(Arrays.asList(entpAuth.getBankInfoVo().getRegistAgreementFile().split(",")));//客户协议书
		}
		entity.setOpBankCode(entpAuth.getBankInfoVo().getKhxkzUrl());//开户许可证（企业必填）
		entity.setMerFlag(ysPayEntpRegProProperties.getMerFlag()); //普通商户
		entity.setIndustry(ysPayEntpRegProProperties.getIndustry()); //行业类别(58:批发零售业)
		entity.setSettleType(ysPayEntpRegProProperties.getSettleType()); //结算方式：银行卡结算，分账时直接分账到商户银行卡
		entity.setOrgNo(ysPayEntpRegProProperties.getOrgNo()); //平台商户机构号
		entity.setBusinessPremises1(entpAuth.getJycsUrlOne());
		entity.setBusinessPremises2(entpAuth.getJycsUrlTwo());
		return entity;
	}

}
