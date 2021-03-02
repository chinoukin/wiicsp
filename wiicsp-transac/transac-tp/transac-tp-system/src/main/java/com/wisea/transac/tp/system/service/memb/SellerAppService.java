package com.wisea.transac.tp.system.service.memb;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.RedisKeyConstants;
import com.wisea.transac.common.dao.EntpAuthMapper;
import com.wisea.transac.common.dao.EntpBankInfoMapper;
import com.wisea.transac.common.dao.ExamRecdMapper;
import com.wisea.transac.common.dao.MerchantMembMageMapper;
import com.wisea.transac.common.po.memb.CheckEntpNamePo;
import com.wisea.transac.common.po.memb.EntpAuthInfoSavePo;
import com.wisea.transac.common.po.memb.EntpAuthUpInfoPo;
import com.wisea.transac.common.po.seller.MerchantMembMagePo;
import com.wisea.transac.common.po.seller.SellerMembMageAddPo;
import com.wisea.transac.common.po.seller.SellerMembManagerPagePo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.EntpAuthInfoInitVo;
import com.wisea.transac.common.vo.memb.EntpAuthUpdInitVo;
import com.wisea.transac.common.vo.memb.SellerAppEntpAuthInfoVo;
import com.wisea.transac.common.vo.seller.SellerMembMageAddVo;
import com.wisea.transac.common.vo.seller.SellerMembMagePageListVo;
import com.wisea.transac.tp.system.utils.TpSystemMembUtils;
import com.wisea.transac.common.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

/**
 * 商户app专用接口
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月12日
 * @version 1.0
 */
@Service
public class SellerAppService extends BaseService{

	@Autowired
	private JedisDao jedisDao;
	@Autowired
	private EntpAuthMapper entpAuthMapper;
	@Autowired
	private EntpBankInfoMapper entpBankInfoMapper;
	@Autowired
	private ExamRecdMapper examRecdMapper;
	@Autowired
	private MerchantMembMageMapper merchantMembMageMapper;
	/**
	 * 获取当前登录用户的企业认证状态
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	public ResultPoJo<SellerAppEntpAuthInfoVo> entpAuthType(){
		// 返回值初期化处理
		ResultPoJo<SellerAppEntpAuthInfoVo> result = new ResultPoJo<SellerAppEntpAuthInfoVo>(ConstantError.NOMAL);
		SellerAppEntpAuthInfoVo vo = new SellerAppEntpAuthInfoVo();
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(membBaseInfo != null && ConverterUtil.isNotEmpty(membBaseInfo.getMembId())){
			// 查询最新的企业认证信息 -- 查询条件处理
			EntpAuthUpInfoPo entpAuthUpInfoPo = new EntpAuthUpInfoPo();
			vo.setFreshenLoginFlag("0");
			entpAuthUpInfoPo.setMembId(membBaseInfo.getMembId());
			String roleCode = "ROLE_seller_app";
			// 产地以外的情况
			if(DictConstants.LOCALITY_MEMB_TYPE_0.equals(membBaseInfo.getLocalityMembType())){
				entpAuthUpInfoPo.setFlag("3");// 产地(基地)商户最新的认证
				roleCode = "ROLE_local_app";
			}else{
				entpAuthUpInfoPo.setFlag("2");// 同城商户最新的认证
				roleCode = "ROLE_seller_app";
			}

			// 判断权限的处理
			if(membBaseInfo.getId().equals(membBaseInfo.getMembId())
					&& SystemUtils.hasAllAuthor(membBaseInfo.getMembId(),roleCode)
					&& !SystemUtils.hasAllAuthor(roleCode)){
				vo.setFreshenLoginFlag("1");
			}
			vo.setMembId(membBaseInfo.getMembId());
			vo.setBaseId(membBaseInfo.getBaseId());
			vo.setMarketId(membBaseInfo.getMarketId());
			vo.setApFlag(membBaseInfo.getApFlag());
			// 如果已经认证过 则提示为已认证
			if(membBaseInfo.getAgentFlag() != null
					&& DictConstants.AGENT_FLAG_0.equals(membBaseInfo.getAgentFlag())){
				vo.setAuthStateType(DictConstants.AUTH_STATE_TYPE_3);
			}else{

				EntpAuthInfoInitVo entpAuthInfoInitVo = entpAuthMapper.getUpEntpInfoByMembId(entpAuthUpInfoPo);
				if(entpAuthInfoInitVo != null){
					vo.setId(entpAuthInfoInitVo.getId());
					vo.setAuthStateType(entpAuthInfoInitVo.getAuthStateType());
					vo.setExamFailReason(entpAuthInfoInitVo.getExamFailReason());

				}
			}
			result.setResult(vo);
		}
 		return result;
	}
	/**
	 * 验证企业名称不能重复的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkEntpName(CheckEntpNamePo po){
		// 返回值初期化处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}

		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(ConverterUtil.isEmpty(po.getMembId())){
			po.setMembId(membBaseInfo.getMembId());
		}
		// 查询处理
		int count = entpAuthMapper.checkEntpNameExist(po);
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_529);
			result.setMsg(ConstantCodeMsg.MSG_529);
			return result;
		}
		return result;
	}
	/**
	 * 企业信息的暂存处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	public ResultPoJo<String> temporarySaveEntpInfo(EntpAuthInfoSavePo po){
		// 返回值初期话处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		EntpAuthUpdInitVo entpInfo = new EntpAuthUpdInitVo();
		// 企业信息的处理
		ConverterUtil.copyProperties(po, entpInfo);
		jedisDao.setSerialize(RedisKeyConstants.ENTP_AUTH_INFO_KEY + membBaseInfo.getMembId(), entpInfo);
		return result;
	}
	/**
	 * 获取当前登录用户的企业信息(最新的信息)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	public ResultPoJo<EntpAuthUpdInitVo> entpAuthInit(){
		// 返回值初期话处理
		ResultPoJo<EntpAuthUpdInitVo> result = new ResultPoJo<EntpAuthUpdInitVo>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		// 从缓存中获取
		EntpAuthUpdInitVo entpAuthUpdInitVo = jedisDao.getSerialize(RedisKeyConstants.ENTP_AUTH_INFO_KEY + membBaseInfo.getMembId(), EntpAuthUpdInitVo.class);
		// 缓存中不存在的情况
		if(entpAuthUpdInitVo == null){
			entpAuthUpdInitVo = new EntpAuthUpdInitVo();
			// 获取企业信息
			EntpAuthUpInfoPo entpAuthUpInfoPo = new EntpAuthUpInfoPo();
			entpAuthUpInfoPo.setMembId(membBaseInfo.getMembId());
			entpAuthUpInfoPo.setFlag("0");// 全部中最新的
			EntpAuthInfoInitVo entpAuthInfoInitVo = entpAuthMapper.getUpEntpInfoByMembId(entpAuthUpInfoPo);
			if(entpAuthInfoInitVo != null){
				ConverterUtil.copyProperties(entpAuthInfoInitVo, entpAuthUpdInitVo);
				if(entpAuthInfoInitVo.getBankInfoVo() != null){
					entpAuthUpdInitVo.setBankAcctType(entpAuthInfoInitVo.getBankInfoVo().getBankAcctType());
					entpAuthUpdInitVo.setOpenBank(entpAuthInfoInitVo.getBankInfoVo().getOpenBank());
					entpAuthUpdInitVo.setEntpBankNum(entpAuthInfoInitVo.getBankInfoVo().getEntpBankNum());
					entpAuthUpdInitVo.setBankReservedTel(entpAuthInfoInitVo.getBankInfoVo().getBankReservedTel());
					entpAuthUpdInitVo.setKhName(entpAuthInfoInitVo.getBankInfoVo().getKhName());
					entpAuthUpdInitVo.setKhProv(entpAuthInfoInitVo.getBankInfoVo().getKhProv());
					entpAuthUpdInitVo.setKhCity(entpAuthInfoInitVo.getBankInfoVo().getKhCity());
					entpAuthUpdInitVo.setAcctOpenSubBank(entpAuthInfoInitVo.getBankInfoVo().getAcctOpenSubBank());
					entpAuthUpdInitVo.setBankCardZmUrl(entpAuthInfoInitVo.getBankInfoVo().getBankCardZmUrl());
					entpAuthUpdInitVo.setBankCardFmUrl(entpAuthInfoInitVo.getBankInfoVo().getBankCardFmUrl());
					entpAuthUpdInitVo.setKhxkzUrl(entpAuthInfoInitVo.getBankInfoVo().getKhxkzUrl());
					entpAuthUpdInitVo.setRemarks(entpAuthInfoInitVo.getRemarks());
					entpAuthUpdInitVo.setRegistAgreementFile(entpAuthInfoInitVo.getBankInfoVo().getRegistAgreementFile());
				}
			}
		}
		result.setResult(entpAuthUpdInitVo);
		return result;
	}
	/**
	 * 企业信息和企业银行卡信息的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月12日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> entpSave(EntpAuthInfoSavePo po){
		// 返回值初期话处理
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(ConverterUtil.isEmpty(membBaseInfo,membBaseInfo.getMembId())){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		if(!Constants.NO.equals(membBaseInfo.getLocalityMembType())){
			if(po.getWholeSaleMarketId() == null){
				result.setCode(ConstantCodeMsg.ERR_001);
				result.setMsg("同城的时候市场ID不能为空");
				return result;
			}
		}else{
			po.setWholeSaleMarketId(null);
		}
		// 查询处理
		CheckEntpNamePo checkEntpNamePo = new CheckEntpNamePo();
		checkEntpNamePo.setEntpName(po.getEntpName());
		checkEntpNamePo.setMembId(membBaseInfo.getMembId());
		int count = entpAuthMapper.checkEntpNameExist(checkEntpNamePo);
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_529);
			result.setMsg(ConstantCodeMsg.MSG_529);
			return result;
		}
		// 获取当前用户最新的商户认证的企业信息
		EntpAuthUpInfoPo entpAuthUpInfoPo = new EntpAuthUpInfoPo();
		if(Constants.NO.equals(membBaseInfo.getLocalityMembType())){
			entpAuthUpInfoPo.setFlag("3");
		}else{
			entpAuthUpInfoPo.setFlag("2");
		}
		entpAuthUpInfoPo.setMembId(membBaseInfo.getMembId());
		EntpAuth oldEntpInfo = entpAuthMapper.selUpdEntpInfoByMembId(entpAuthUpInfoPo);
		// 需要保存的企业信息
		EntpAuth newEntp = new EntpAuth();
		ConverterUtil.copyProperties(po, newEntp);
		newEntp.preInsert();
		newEntp.setMembId(membBaseInfo.getMembId());
		EntpBankInfo newEntpBankInfo = new EntpBankInfo();
		ConverterUtil.copyProperties(po, newEntpBankInfo);
		newEntpBankInfo.preInsert();
		newEntpBankInfo.setMerchantAuthId(newEntp.getId());
		// 如果存在旧数据 删除操作
		if(oldEntpInfo != null){
			// 0贷平台审核、1待银盛开户、2实名认证中的情况不能够修改
			if(DictConstants.AUTH_STATE_TYPE_0.equals(oldEntpInfo.getAuthStateType())
					|| DictConstants.AUTH_STATE_TYPE_1.equals(oldEntpInfo.getAuthStateType())
					|| DictConstants.AUTH_STATE_TYPE_2.equals(oldEntpInfo.getAuthStateType())){
				result.setCode(ConstantCodeMsg.ERR_852);
				result.setMsg(ConstantCodeMsg.MSG_852);
				return result;
			}
			// 如果是审核通过以外的情况修改
			if(!DictConstants.AUTH_STATE_TYPE_0.equals(oldEntpInfo.getAuthStateType())){
				// 删除企业信息
				oldEntpInfo.preUpdate();
				entpAuthMapper.updDelById(oldEntpInfo);
				// 删除企业银行卡信息
				entpBankInfoMapper.updDelByEntpId(oldEntpInfo);
				// 新增人和新增时间的复制
				newEntp.setCreateBy(oldEntpInfo.getCreateBy());
				newEntp.setCreateDate(oldEntpInfo.getCreateDate());
				newEntp.setAuthDate(oldEntpInfo.getAuthDate());
			}else{
				newEntp.setAuthDate(OffsetDateTime.now());
			}
			newEntp.setAuthStateType(DictConstants.AUTH_STATE_TYPE_0);
			newEntp.setEntpAuthStateType(oldEntpInfo.getEntpAuthStateType());
			newEntp.setExamFailReason(null);
			newEntpBankInfo.setCreateBy(oldEntpInfo.getCreateBy());
			newEntpBankInfo.setCreateDate(oldEntpInfo.getCreateDate());
		}else{
			newEntp.setAuthStateType(DictConstants.AUTH_STATE_TYPE_0);// 第一次信息的时候状态是提交到平台审批
		}
		// 保存企业信息
		newEntp.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_1);
		newEntp.setAuthDate(OffsetDateTime.now());
		entpAuthMapper.insert(newEntp);
		// 保存银行卡信息
		entpBankInfoMapper.insert(newEntpBankInfo);
		// 审核记录表的处理
		ExamRecd examRecd = new ExamRecd();
		examRecd.preInsert();
		examRecd.setMembId(newEntp.getMembId());
		examRecd.setOperatDate(OffsetDateTime.now());
		examRecd.setOperator(user.getLoginName());
		examRecd.setOperatorContent("提交认证");
		examRecd.setRemarks(TpSystemMembUtils.SUPPLIER_AUTH_FLAG);
		examRecdMapper.insert(examRecd);
		// 清空缓存的处理
		jedisDao.delSerialize(RedisKeyConstants.ENTP_AUTH_INFO_KEY + membBaseInfo.getMembId());
		MembUtils.delMembUser(user.getId());
		return result;
	}
	/**
	 * 会员管理列表(商户APP)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月2日
	 * @version 1.0
	 */
	public ResultPoJo<Page<SellerMembMagePageListVo>> findMembManagerList(SellerMembManagerPagePo po){
		// 返回值初期化处理
		ResultPoJo<Page<SellerMembMagePageListVo>> result = new ResultPoJo<Page<SellerMembMagePageListVo>>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(ConverterUtil.isEmpty(po.getId()) &&ConverterUtil.isNotEmpty(membBaseInfo,membBaseInfo.getMembId())){
			po.setId(membBaseInfo.getMembId());
		}
		// "是否产地会员类型(0:是产地会员1:同城会员)
		po.setLocalityMembType(membBaseInfo.getLocalityMembType());
		// 分页查询的处理
		Page<SellerMembMagePageListVo> page = po.getPage();
		page.setList(merchantMembMageMapper.findMerchantMembMageList(po));
		result.setResult(page);
		return result;
	}
	/**
	 * 添加会员管理初期化查询处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	public ResultPoJo<SellerMembMageAddVo> getSellerMembCheck(SellerMembMageAddPo po){
		// 返回值初期化处理
		ResultPoJo<SellerMembMageAddVo> result = new ResultPoJo<SellerMembMageAddVo>(ConstantCodeMsg.NOMAL);
		// 验证登录用户的信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(ConverterUtil.isEmpty(po.getMerchantId()) &&ConverterUtil.isNotEmpty(membBaseInfo,membBaseInfo.getMembId())){
			po.setMerchantId(membBaseInfo.getMembId());
		}
		//查詢處理
		SellerMembMageAddVo vo = merchantMembMageMapper.getSellerMembCheck(po);
		if(vo == null){
			result.setCode(ConstantCodeMsg.ERR_513);
			result.setMsg(ConstantCodeMsg.MSG_513);
			return result;
		}
		if(ConverterUtil.isNotEmpty(vo.getMerMembId())){
			result.setCode(ConstantCodeMsg.ERR_853);
			result.setMsg(ConstantCodeMsg.MSG_853);
			return result;
		}
		if(ConverterUtil.isNotEmpty(vo.getPurId())){
			result.setCode(ConstantCodeMsg.ERR_854);
			result.setMsg(ConstantCodeMsg.MSG_854);
			return result;
		}
		result.setResult(vo);
		return result;
	}
	/**
	 * 商戶APP添加会员的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	public ResultPoJo<String> addMerchantMembMage(MerchantMembMagePo po){
		// 初期化返回值
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		// 获取会员信息
		MembBaseInfo membBaseInfo = MembUtils.getMembInfoByUserId(user.getId());
		if(ConverterUtil.isEmpty(po.getMerchantId()) && ConverterUtil.isNotEmpty(membBaseInfo,membBaseInfo.getMembId())){
			po.setMerchantId(membBaseInfo.getMembId());
		}
		// 保存处理
		MerchantMembMage entity = new MerchantMembMage();
		entity.preInsert();
		entity.setMerchantId(po.getMerchantId());
		entity.setMembId(po.getMembId());
		merchantMembMageMapper.insert(entity);
		return result;
	}
	/**
	 * 删除会员管理信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月3日
	 * @version 1.0
	 */
	public ResultPoJo<String> del(LongIdPo po){
		// 初期化返回值
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantCodeMsg.NOMAL);
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user)){
			result.setCode(ConstantCodeMsg.ERR_912);
			result.setMsg(ConstantCodeMsg.MSG_912);
			return result;
		}
		MerchantMembMage entity = new MerchantMembMage();
		entity.preUpdate();
		entity.setId(po.getId());
		entity.setDelFlag(DictConstants.DEL_FLAG_1);
		merchantMembMageMapper.updateByPrimaryKeySelective(entity);
		// 清空缓存的处理
		MembUtils.delMembUser(user.getId());
		return result;
	}

}
