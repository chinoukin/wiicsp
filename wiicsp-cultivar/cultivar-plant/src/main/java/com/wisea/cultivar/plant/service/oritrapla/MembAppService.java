package com.wisea.cultivar.plant.service.oritrapla;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.mss.RemoteUserMss;
import com.wisea.cloud.common.po.LoginBatUpdatePo;
import com.wisea.cloud.common.po.SubUserInsertPo;
import com.wisea.cloud.common.po.UpdateLoginNamePo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.plant.constants.ConstantCodeMsg;
import com.wisea.cultivar.plant.constants.DictConstants;
import com.wisea.cultivar.plant.entity.ZhfwMembInfo;
import com.wisea.cultivar.plant.entity.oritrapla.BrandInfo;
import com.wisea.cultivar.plant.entity.oritrapla.BrandPicture;
import com.wisea.cultivar.plant.entity.oritrapla.MembPictureInfo;
import com.wisea.cultivar.plant.entity.oritrapla.OpinRetroaMage;
import com.wisea.cultivar.plant.mapper.ZhfwMembInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.BrandInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.BrandPictureMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.MembPictureInfoMapper;
import com.wisea.cultivar.plant.mapper.oritrapla.OpinRetroaMageMapper;
import com.wisea.cultivar.plant.po.oritrapla.*;
import com.wisea.cultivar.plant.utils.MembUtils;
import com.wisea.cultivar.plant.vo.oritrapla.LoginBaseInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembLatLngInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.MembMainInfoVo;
import com.wisea.cultivar.plant.vo.oritrapla.SubMembInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * App端会员相关的Service
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@Service
public class MembAppService extends BaseService {

	@Autowired
	private ZhfwMembInfoMapper membInfoMapper;
	@Autowired
	private BrandInfoMapper brandInfoMapper;
	@Autowired
	private MembPictureInfoMapper membPictureInfoMapper;
	@Autowired
	private BrandPictureMapper brandPictureMapper;
	@Autowired
	private OpinRetroaMageMapper opinRetroaMageMapper;
	/** 远程调用接口 **/
	@Autowired(required = false)
	private RemoteUserMss remoteUserMss;
	/** 密码初期话 **/
	@Value("${oritrapla.initPassword:a123456}")
    private String initPassword;

	/**
	 * oritrapla_008_【会员】基本信息的查询(登录成功后调用)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<LoginBaseInfoVo> getBaseInfoById(){
		// 返回参数初期化
		ResultPoJo<LoginBaseInfoVo> result = new ResultPoJo<LoginBaseInfoVo>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 通过登录中心查询登录用户的信息
		LoginBaseInfoVo loginBaseInfoVo = membInfoMapper.getBaseInfoById(user.getId());
		// 判断如果登录的用户在溯源数据库的user中不存在则添加用户信息
		if(loginBaseInfoVo == null || ConverterUtil.isEmpty(loginBaseInfoVo.getId())){
			// 插入会员信息内容
			ZhfwMembInfo membInfo = new ZhfwMembInfo();
			membInfo.preInsert();//
			membInfo.setId(user.getId());// 设置成调用注册返回的user的ID
			membInfo.setLoginName(user.getLoginName());// 登录用户名
			membInfo.setContTel(user.getMobile());// 联系人电话
			membInfo.setRegisterDate(user.getCreateDate()); //注册时间等于用户创建时间
			membInfo.setAcctType(DictConstants.ACCT_TYPE_0);
			membInfo.setAcctStatus(DictConstants.ACCT_STATUS_1);
			// 插入表操作
			membInfoMapper.insertSelective(membInfo);
		}
		// 根据当前登录的用户ID查询当前登录的会员信息
		result.setResult(membInfoMapper.getBaseInfoById(user.getId()));
		// 返回参数
		return result;
	}
	/**
	 * oritrapla_005_【会员】注册时保存主体信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveMainMembInfo(@RequestBody SaveMainMembInfoPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUserOnlyId();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 验证输入的主体名称是否存在
		int count =  membInfoMapper.checkUsername(po.getOrgName().trim());
		// 如果查询的结果大于0 表示主体名称已经存在
		if(count > 0){
			result.setCode(ConstantCodeMsg.ERR_704);
			result.setMsg(ConstantCodeMsg.MSG_704);
			return result;
		}
		// 验证手机号是否修改
		LoginBaseInfoVo loginBaseInfoVo = membInfoMapper.getBaseInfoById(user.getId());
		// 保存出体信息到会员表中
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		ConverterUtil.copyProperties(po, membInfo);// 将页面输入的内容映射到MembInfo
        membInfo.setContTel(loginBaseInfoVo.getContTel());
		membInfo.setId(user.getId());// 当前登录的用户id 为会员表的id
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		if(ConverterUtil.isNotEmpty(loginBaseInfoVo, po.getContTel()) && !loginBaseInfoVo.getContTel().equals(po.getContTel())){
			user.setMobile(po.getContTel());
			ResultPoJo<Object> userFlagResult = remoteUserMss.mobileUpdate(user);
			if(!userFlagResult.getCode().equals(ConstantError.NOMAL)){
				checkRemoteResult(userFlagResult);
				result.setCode(userFlagResult.getCode());
				result.setMsg(userFlagResult.getMsg());
				return result;
			}
		}
		// 返回结果
		return result;
	}
	/**
	 * 保存会员的基础信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月5日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> onlySaveMembInfo(ZhfwMembInfo membInfo){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUserOnlyId();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 修改会员信息操作
		membInfo.setId(user.getId());
		membInfo.preUpdate();
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		// 返回结果
		return result;
	}
	/**
	 * 主体信息的查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	public ResultPoJo<MembMainInfoVo> getMainMembInfo(){
		// 返回参数初期化
		ResultPoJo<MembMainInfoVo> result = new ResultPoJo<MembMainInfoVo>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 获取会员主体账户的ID
		Long membId = MembUtils.getMembIdFromUser(user);
		// 查询主体信息
		result.setResult(membInfoMapper.getMainMembInfo(membId));
		// 返回结果
		return result;
	}
	/**
	 * oritrapla_016_【会员】保存主体基本信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveMainInfo(MembMainInfoPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 查询是否是主体帐号，如果不是则没有修改的权限
		if(ConverterUtil.isNotEmpty(user.getParentId())){
			result.setCode(ConstantCodeMsg.ERR_708);
			result.setMsg(ConstantCodeMsg.MSG_708);
			return result;
		}
		// 最多只能上传6张图片
		if(po.getMembPicList() != null && po.getMembPicList().size() > 6){
			result.setCode(ConstantCodeMsg.ERR_709);
			result.setMsg(ConstantCodeMsg.MSG_709);
			return result;
		}
		//保存会员基本信息
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		ConverterUtil.copyProperties(po, membInfo);
		membInfo.setId(user.getId());// 设置id
		membInfo.preUpdate();// 设置更新时间
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		// 删除会员图片信息
		membPictureInfoMapper.delPicInfoByMembId(user.getId());
		// 保存会员图片信息
		List<MembPictureInfo> insList =  new ArrayList<MembPictureInfo>();
		for(String url : po.getMembPicList()){
			MembPictureInfo pic = new MembPictureInfo();
			pic.setUrl(url);// 图片地址
			pic.setMembId(user.getId());//  会员id
			pic.preInsert();
			insList.add(pic);
		}
		if(insList.size()>0){
			membPictureInfoMapper.batchInsert(insList);
		}
		// 返回结果
		return result;
	}
	/**
	 * oritrapla_017_【会员】主体信息中品牌信息的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveBrandInfo(BrandInfoPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 查询是否是主体帐号，如果不是则没有修改的权限
		if(ConverterUtil.isNotEmpty(user.getParentId())){
			result.setCode(ConstantCodeMsg.ERR_708);
			result.setMsg(ConstantCodeMsg.MSG_708);
			return result;
		}
		//图片不能为空
		if(po.getBrandPicList() == null || po.getBrandPicList().size() == 0){
			result.setCode(ConstantCodeMsg.ERR_710);
			result.setMsg(ConstantCodeMsg.MSG_710);
			return result;
		}
		// 最多只能上传6张图片
		if(po.getBrandPicList().size() > 6){
			result.setCode(ConstantCodeMsg.ERR_709);
			result.setMsg(ConstantCodeMsg.MSG_709);
			return result;
		}
		// 保存品牌信息
		BrandInfo brandInfo = new BrandInfo();
		ConverterUtil.copyProperties(po, brandInfo);
		// 新增的情况
		if(ConverterUtil.isEmpty(po.getId())){
			brandInfo.preInsert();
			brandInfo.setMembId(user.getId());// 设置会员ID
			brandInfoMapper.insertSelective(brandInfo);
		}else{// 更新的场合
			brandInfo.preUpdate();
			brandInfoMapper.updateByPrimaryKeySelective(brandInfo);
		}
		// 根据品牌id删除图片信息
		brandPictureMapper.delBrandPicByBrandId(brandInfo.getId());
		// 保存品牌图片信息
		List<BrandPicture> inlist = new ArrayList<BrandPicture>();
		for(String url : po.getBrandPicList()){
			BrandPicture brandPicture = new BrandPicture();
			brandPicture.preInsert();
			brandPicture.setBrandId(brandInfo.getId());
			brandPicture.setUrl(url);
			inlist.add(brandPicture);
		}
		brandPictureMapper.batchInsert(inlist);
		// 返回结果
		return result;
	}
	/**
	 * oritrapla_024_【会员】主体信息中品牌信息的删除
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> delBrandInfo(LongIdPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 查询是否是主体帐号，如果不是则没有修改的权限
		if(ConverterUtil.isNotEmpty(user.getParentId())){
			result.setCode(ConstantCodeMsg.ERR_708);
			result.setMsg(ConstantCodeMsg.MSG_708);
			return result;
		}
		brandPictureMapper.delBrandPicByBrandId(po.getId());
		// 通过id删除
		brandInfoMapper.deleteByPrimaryKey(po.getId());
		// 返回结果
		return result;
	}
	/**
	 * oritrapla_018_【会员】人员管理列表的查询
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月6日
	 * @version 1.0
	 */
	public ResultPoJo<Page<SubMembInfoVo>> findMembInfo(SelSubMembPo po){
		// 返回参数初期化
		ResultPoJo<Page<SubMembInfoVo>> result = new ResultPoJo<Page<SubMembInfoVo>>(ConstantError.NOMAL);
		// 查询操作
		Page<SubMembInfoVo> page = po.getPage();
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 查询是否是主体帐号，如果不是则没有修改的权限
		if(ConverterUtil.isNotEmpty(user.getParentId())){
			result.setCode(ConstantCodeMsg.ERR_711);
			result.setMsg(ConstantCodeMsg.MSG_711);
			return result;
		}
		// 查询人员管理列表
		po.setPid(user.getId());
		page.setList(membInfoMapper.findMembInfoList(po));
		result.setResult(page);
		// 返回结果
		return result;
	}
	/**
	 * oritrapla_019_【会员】人员管理中保存人员信息的 操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月7日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveMembInfo(SaveSubMembInfoPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 当前登录的用户信息
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 查询是否是主体帐号，如果不是则没有添加或者修改的权限
		if(ConverterUtil.isNotEmpty(user.getParentId())){
			result.setCode(ConstantCodeMsg.ERR_712);
			result.setMsg(ConstantCodeMsg.MSG_712);
			return result;
		}

		ResultPoJo<Object> userFlagResult = new ResultPoJo<Object>(ConstantError.NOMAL);
		//新增的情况
		if(ConverterUtil.isEmpty(po.getId())){
			// 用户名验证是否存在
			int count =  membInfoMapper.checkUsername(po.getLoginName().trim());
			// 如果查询的结果大于0 表示用户名已经存在
			if(count > 0){
				result.setCode(ConstantCodeMsg.ERR_701);
				result.setMsg(ConstantCodeMsg.MSG_701);
				return result;
			}
			// 保存用户信息
			SubUserInsertPo insertPo = new SubUserInsertPo();
			insertPo.setParentId(user.getId());//父用户id
			insertPo.setLoginName(po.getLoginName());// 用户名
			insertPo.setPassword(ConverterUtil.md5(initPassword));// 密码
			insertPo.setMobile(po.getContTel());// 手机号
			insertPo.setUserType(Constants.USER_TYPE_SUBUSER);//"0:管理员 1:用户帐户 2:用户子账户"
			insertPo.setAuthFlag("1");// 审核标识：0未审核1审核
			ResultPoJo<User> userResult = remoteUserMss.insert(insertPo);
			if(!userResult.getCode().equals(ConstantError.NOMAL)
					|| ConverterUtil.isEmpty(userResult.getResult().getId())){
				checkRemoteResult(userResult);
				result.setCode(userResult.getCode());
				result.setMsg(userResult.getMsg());
				return result;
			}
			// 如果账号状态为禁用的情况 ，修改保存后的用户状态为禁用
			if(po.getAcctStatus().equals(DictConstants.ACCT_STATUS_0)){
				// 修改用户登录状态
				LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
				loginBatUpdate.setLoginFlag(po.getAcctStatus());
				loginBatUpdate.setIds(ConverterUtil.toString(userResult.getResult().getId()));
				userFlagResult = remoteUserMss.loginBatUpdate(loginBatUpdate);
				if(!userFlagResult.getCode().equals(ConstantError.NOMAL)){
					checkRemoteResult(userFlagResult);
					result.setCode(userFlagResult.getCode());
					result.setMsg(userFlagResult.getMsg());
					return result;
				}
			}

			Long membId = MembUtils.getMembIdFromUser(user);
			// 查询主体信息
			MembMainInfoVo mainMembInfo = membInfoMapper.getMainMembInfo(membId);

			// 保存会员信息
			ZhfwMembInfo membInfo = new ZhfwMembInfo();
			ConverterUtil.copyProperties(po, membInfo);
			membInfo.setId(userResult.getResult().getId());
			membInfo.setPid(user.getId());
			membInfo.setAcctType(DictConstants.ACCT_TYPE_1);// 设置为子账户
			membInfo.setRegisterDate(OffsetDateTime.now());
			membInfo.setMembType(mainMembInfo.getMembType());// 设置会员类型
			membInfoMapper.insertSelective(membInfo);
		}else{
			//校验用户身份被删除
			ZhfwMembInfo info = membInfoMapper.selectByPrimaryKey(po.getId());
			if ("1".equals(info.getDelFlag())) {

				result.setCode(ConstantCodeMsg.ERR_802);
				result.setMsg(ConstantCodeMsg.MSG_802);
				return result;
			}
			// 修改用户信息
			User oldUser = SystemUtils.getById(po.getId());
			// 验证用户名是否存在
			User newUser = new User();
			newUser.setId(po.getId());
			// 修改登录帐号
			if(oldUser != null && !oldUser.getLoginName().equals(po.getLoginName())){
				// 用户名验证是否存在
				int count =  membInfoMapper.checkUsername(po.getLoginName().trim());
				// 如果查询的结果大于0 表示用户名已经存在
				if(count > 0){
					result.setCode(ConstantCodeMsg.ERR_701);
					result.setMsg(ConstantCodeMsg.MSG_701);
					return result;
				}
				UpdateLoginNamePo updateLoginNamePo = new UpdateLoginNamePo();
				updateLoginNamePo.setId(po.getId());
				updateLoginNamePo.setLoginName(po.getLoginName());
				userFlagResult = remoteUserMss.updateLoginName(updateLoginNamePo);
				if(!userFlagResult.getCode().equals(ConstantError.NOMAL)){
					checkRemoteResult(userFlagResult);
					result.setCode(userFlagResult.getCode());
					result.setMsg(userFlagResult.getMsg());
					return result;
				}
			}
			// 修改手机号码
			if(oldUser != null && !oldUser.getMobile().equals(po.getContTel())){
				newUser.setMobile(po.getContTel());
				userFlagResult = remoteUserMss.mobileUpdate(newUser);
				if(!userFlagResult.getCode().equals(ConstantError.NOMAL)){
					checkRemoteResult(userFlagResult);
					result.setCode(userFlagResult.getCode());
					result.setMsg(userFlagResult.getMsg());
					return result;
				}
			}
			// 修改帐号状态
			if(oldUser != null && !oldUser.getLoginFlag().equals(po.getAcctStatus())){
				// 修改用户登录状态
				LoginBatUpdatePo loginBatUpdate = new LoginBatUpdatePo();
				loginBatUpdate.setLoginFlag(po.getAcctStatus());
				loginBatUpdate.setIds(ConverterUtil.toString(po.getId()));
				userFlagResult = remoteUserMss.loginBatUpdate(loginBatUpdate);
				if(!userFlagResult.getCode().equals(ConstantError.NOMAL)){
					checkRemoteResult(userFlagResult);
					result.setCode(userFlagResult.getCode());
					result.setMsg(userFlagResult.getMsg());
					return result;
				}
			}
			// 修改会员信息
			ZhfwMembInfo membInfo = new ZhfwMembInfo();
			ConverterUtil.copyProperties(po, membInfo);
			membInfoMapper.updateByPrimaryKeySelective(membInfo);
		}
		//返回结果
		return result;
	}
	/**
	 * 人员管理中删除人员信息的 操作
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月7日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> delMembInfo(LongIdPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 删除用户信息
		ResultPoJo<Object> userResult = remoteUserMss.batDelete(ConverterUtil.toString(po.getId()));
		if(!userResult.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(userResult);
			result.setCode(userResult.getCode());
			result.setMsg(userResult.getMsg());
			return result;
		}
		//删除会员信息
		ZhfwMembInfo membInfo = new ZhfwMembInfo();
		membInfo.setId(po.getId());
		membInfo.setDelFlag(DictConstants.DEL_FLAG_1);
		membInfoMapper.updateByPrimaryKeySelective(membInfo);
		//返回结果
		return result;
	}
	/**
	 * oritrapla_022_【会员】设置中意见反馈的保存
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月11日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> saveFeedback(OpinRetroaPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		User user = SystemUtils.getUserOnlyId();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		// 保存反馈信息
		OpinRetroaMage opinRetroaMage = new OpinRetroaMage();
		opinRetroaMage.setRetroaCont(po.getRetroaCont());// 返回内容
		opinRetroaMage.setMembId(user.getId());
		opinRetroaMage.setHandleStatus(DictConstants.HANDLE_STATUS_1);// 设置处理状态为未处理
		opinRetroaMage.preInsert();
		// 将反馈信息保存到数据库
		opinRetroaMageMapper.insertSelective(opinRetroaMage);
		// 返回结果
		return result;
	}

	/**
	 * 保存经度纬度的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年6月28日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<String> setLatLng(MembLatLngSetPo po){
		// 返回参数初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		// 会员验证
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		membInfoMapper.updMembLatLng(po);
		return result;
	}
	/**
	 * 获取会员经纬度信息
	 *
	 * @param po
	 * @return
	 */
	public ResultPoJo<MembLatLngInfoVo> getMembLatLng(LongIdPo po){
		// 返回参数初期化
		ResultPoJo<MembLatLngInfoVo> result = new ResultPoJo<MembLatLngInfoVo>(ConstantError.NOMAL);
		// 会员验证
		User user = SystemUtils.getUser();
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantCodeMsg.ERR_702);
			result.setMsg(ConstantCodeMsg.MSG_702);
			return result;
		}
		MembLatLngInfoVo vo = membInfoMapper.getMembLatLng(po.getId());
		result.setResult(vo);
		return result;
	}

}
