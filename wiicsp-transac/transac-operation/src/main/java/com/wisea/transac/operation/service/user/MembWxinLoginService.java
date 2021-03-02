package com.wisea.transac.operation.service.user;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wisea.transac.operation.entity.MembReleBaseInfo;
import com.wisea.transac.operation.entity.MembRelevanceInfo;
import com.wisea.transac.operation.mapper.MembRelevanceInfoMapper;
import com.wisea.transac.operation.properties.WeChatMiniProProperties;
import com.wisea.transac.operation.user.po.WeChatUserPo;
import com.wisea.transac.operation.user.po.WechatBdPo;
import com.wisea.transac.operation.user.po.WechatVilLoginPo;
import com.wisea.transac.operation.user.vo.WachatBdInfoVo;
import com.wisea.transac.operation.user.vo.WeChatDateByCodeVo;
import com.wisea.transac.operation.utils.AesCbcUtil;
import com.wisea.transac.operation.utils.WeChatLoginUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.JsonMapper;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.constants.RedisKeyConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.entity.MembBaseInfo;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.po.StringPo;
import com.wisea.transac.common.po.memb.MembCheckMobilePo;
import com.wisea.transac.common.po.memb.MobileValiLoginPo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.utils.MembUtils;
import com.wisea.transac.common.vo.memb.AuthInfoVo;

import io.seata.spring.annotation.GlobalTransactional;
import net.sf.json.JSONObject;

/**
 * 微信登录相关的处理
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月8日
 * @version 1.0
 */
@Service
@EnableConfigurationProperties({ WeChatMiniProProperties.class })
public class MembWxinLoginService extends BaseService{

	private static final Logger log = LoggerFactory.getLogger(MembWxinLoginService.class);
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private  UserMembMssService userMembMssService;
	@Autowired
	private JedisDao jedisDao;
	@Autowired
	private WeChatMiniProProperties weChatMiniProProperties;
	@Autowired
	private MembRelevanceInfoMapper membRelevanceInfoMapper;
	@Autowired
	private UserLoginExtendsService userLoginExtendsService;

	/**
	 * 根据code获取OpenID
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年12月26日
	 * @version 1.0
	 */
	public ResultPoJo<AuthInfoVo> getSessionKeyOropenid(WechatVilLoginPo po, HttpServletRequest request){
		// 返回值初期化处理
		ResultPoJo<AuthInfoVo> result = new ResultPoJo<AuthInfoVo>(ConstantError.NOMAL);
		AuthInfoVo authInfoVo = new AuthInfoVo();
		// 调用微信返回值处理
		WeChatDateByCodeVo weChatDateByCodeVo = getInfoByCode(po.getCode(),po.getWechatType());
		// 调用成功的情况 并且获取到openId的情况
		if(weChatDateByCodeVo.getErrcode() == null && ConverterUtil.isNotEmpty(weChatDateByCodeVo.getOpenid())){
			// openId设置到返回值中
			authInfoVo.setWechatOpenid(weChatDateByCodeVo.getOpenid());
			// 将sessionkey放入缓存中
			jedisDao.setSerialize(RedisKeyConstants.WACHAT_SESSION_KEY + weChatDateByCodeVo.getOpenid() + po.getWechatType(), weChatDateByCodeVo.getSessionkey());
			// 根据openid验证是否已经绑定账户
			MembRelevanceInfo membReleVanceInfo = new MembRelevanceInfo();
			membReleVanceInfo.setOpenId(weChatDateByCodeVo.getOpenid());
			membReleVanceInfo.setOpenType(ConverterUtil.toString(po.getWechatType()));
			MembReleBaseInfo membReleBaseInfo = membRelevanceInfoMapper.getMembReleInfoByOpenid(membReleVanceInfo);
			// 已经绑定的情况模拟登录并且返回auto信息
			if(ConverterUtil.isNotEmpty(membReleBaseInfo) && ConverterUtil.isNotEmpty(membReleBaseInfo.getId())){
				// 验证是否能够登录到小程序端的验证
				String loginId = membInfoMapper.findCanLoginWechat(membReleBaseInfo.getRegistTel());
				if(loginId == null){
					result.setCode(ConstantCodeMsg.ERR_811);
					result.setMsg(ConstantCodeMsg.MSG_811);
					return result;
				}
				// 模拟登录的处理
				ResultPoJo<AuthInfo> successRes = userLoginExtendsService.mobileLogin(request, new MobileValiLoginPo(),
						membReleBaseInfo.getMembId(),false);
				if(!successRes.getCode().equals(ConstantError.NOMAL)){
					result.setCode(successRes.getCode());
					result.setMsg(successRes.getMsg());
					return result;
				}
				authInfoVo.setAccessToken(successRes.getResult().getAccessToken());
				authInfoVo.setRefreshToken(successRes.getResult().getRefreshToken());
				authInfoVo.setTokenType(successRes.getResult().getTokenType());
				authInfoVo.setUser(successRes.getResult().getUser());
				authInfoVo.setUnionId(membReleBaseInfo.getUnionid());
				// 会员基本信息的处理
			}else if(ConverterUtil.isEmpty(weChatDateByCodeVo.getUnionid())){// 没有登录的情况并且没有授权用户信息的情况（获取不到unionid）
				result.setCode(ConstantCodeMsg.ERR_9821);
				result.setMsg(ConstantCodeMsg.MSG_9821);
			}else{// 没有登录的情况返回
				result.setCode(ConstantCodeMsg.ERR_517);
				result.setMsg(ConstantCodeMsg.MSG_517);
				authInfoVo.setUnionId(weChatDateByCodeVo.getUnionid());
			}
		}else if(ConstantCodeMsg.ERR_40163.equals(weChatDateByCodeVo.getErrcode())){
			result.setCode(ConstantCodeMsg.ERR_40163);
			result.setMsg(ConstantCodeMsg.MSG_40163);
		}else{
			result.setCode(weChatDateByCodeVo.getErrcode());
			result.setMsg(weChatDateByCodeVo.getErrmsg());
		}
		result.setResult(authInfoVo);
		return result;
	}
	/**
	 * 通过临时登录code获取登录信息
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年2月27日
	 * @version 1.0
	 */
	public WeChatDateByCodeVo getInfoByCode(String code,int type){
		WeChatDateByCodeVo vo = new WeChatDateByCodeVo();
		// 小程序 appId
		log.debug("AppId=" + weChatMiniProProperties.getAppId());
		log.debug("AppSecret=" + weChatMiniProProperties.getAppSecret());
		String appIds= weChatMiniProProperties.getAppId();
		String[] appIdsArray = appIds.split(",");
		String appId = appIdsArray[type];
		// 小程序 appSecret
		String appSecrets = weChatMiniProProperties.getAppSecret();
		String[] appSecretsArray = appSecrets.split(",");
		String appSecret = appSecretsArray[type];
		String urlParams = "appid=" + appId + "&secret=" + appSecret
						   + "&js_code=" + code + "&grant_type=authorization_code"; // 发送请求
		// 调用微信后台服务接口返回OPENID
		String sr = WeChatLoginUtils.sendGet(weChatMiniProProperties.getHttpStr(), urlParams);
		// 调用微信返回值处理
		JSONObject  jsonObject = (JSONObject) JsonMapper.fromJsonString(sr,JSONObject.class);
		vo.setErrcode(ConverterUtil.toString(jsonObject.get("errcode")));// 错误码
		vo.setErrmsg(ConverterUtil.toString(jsonObject.get("errmsg")));// 错误信息
		vo.setOpenid(ConverterUtil.toString(jsonObject.get("openid")));// openID
		vo.setSessionkey(ConverterUtil.toString(jsonObject.get("session_key")));// sessionKey
		vo.setUnionid(ConverterUtil.toString(jsonObject.get("unionid")));// unionid
		// 调用微信返回值处理
		return vo;
	}
	/**
	 * 微信授权第一次的用户信息完善
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月12日
	 * @version 1.0
	 */
	//@TxTransaction(type = Transactions.LCN, propagation = DTXPropagation.REQUIRED)
	@GlobalTransactional
	@Transactional(readOnly = false)
	public ResultPoJo<AuthInfoVo> wechatUserPerfect(HttpServletRequest request, HttpServletResponse response, WeChatUserPo po){
		// 返回值初期化
		ResultPoJo<AuthInfoVo> result = new ResultPoJo<AuthInfoVo>(ConstantError.NOMAL);
		AuthInfoVo authInfoVo = new AuthInfoVo();
		// 验证输入的参数
		if(ConverterUtil.isEmpty(po.getMobile())){
			// 获取sessionkey
			String session = RedisKeyConstants.WACHAT_SESSION_KEY + po.getOpenid() + po.getWechatType();
			String sessionkey = jedisDao.getSerialize(session, String.class);
			if(ConverterUtil.isEmpty(sessionkey)){
				result.setCode(ConstantCodeMsg.ERR_809);
				result.setMsg(ConstantCodeMsg.MSG_809);
				return result;
			}
			// 通过data iv sessionkey解析获取手机号
			JSONObject mobileStr = AesCbcUtil.decryptionUserInfo(po.getEncryptedData(), sessionkey, po.getIv());
			if(ConverterUtil.isNotEmpty(mobileStr) && ConverterUtil.isNotEmpty(mobileStr.get("purePhoneNumber"))){
				po.setMobile(ConverterUtil.toString(mobileStr.get("purePhoneNumber")));
			}else{
				result.setCode(ConstantCodeMsg.ERR_809);
				result.setMsg(ConstantCodeMsg.MSG_809);
				return result;
			}
		}
		// 根据openid查询用户是否存在// 根据手机号判断该手机号的注册用户是否已经绑定其他微信
		MembRelevanceInfo membReleVanceInfo = new MembRelevanceInfo();
		membReleVanceInfo.setOpenId(po.getOpenid());
		membReleVanceInfo.setOpenType(ConverterUtil.toString(po.getWechatType()));
		membReleVanceInfo.setRegistTel(po.getMobile());// 手机号
		MembReleBaseInfo openIdInfo = membRelevanceInfoMapper.getMembReleInfoByOpenid(membReleVanceInfo);
		if(ConverterUtil.isNotEmpty(openIdInfo) && ConverterUtil.isNotEmpty(openIdInfo.getId())){
			result.setCode(ConstantCodeMsg.ERR_518);
			result.setMsg(ConstantCodeMsg.MSG_518);
			return result;
		}
		// 微信绑定的手机号码已经存在的情况
		MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
		membCheckMobilePo.setMobile(po.getMobile());
		MembBaseInfo oldMembInfo = membInfoMapper.getMembInfoByMobile(po.getMobile());
		// 数据库中该手机号没有注册的情况 注册新用户
		Long userid = null;
		String pwd = IdGen.randomBase62(32);
		if(oldMembInfo == null){
			String userName = MembUtils.getRandomUserName();
			// 本地数据库会员表的插入
			MembInfo membInfo = new MembInfo();
			membInfo.preInsert();
			userid = membInfo.getId();
			membInfo.setLogoUrl(null);// 头像的保存
			membInfo.setLoginName(userName);
			membInfo.setRegistTel(po.getMobile());
			// 新增的时候设置默认值
			membInfo.setRegistDate(OffsetDateTime.now());
			membInfo.setAgentFlag(DictConstants.AGENT_FLAG_1);//普通用户
			membInfo.setAcctState(DictConstants.ACCT_STATE_0);//账户状态0：正常
			membInfo.setPetName("用户" + MembUtils.getFixLenthString(10));//昵称
			membInfo.setMembType(DictConstants.MEMB_TYPE_2);// 会员类型0:企业1：个体户2：个人(未认证前是空如果认证了 填写对应的认证标识)
			membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_1);//未认证
			membInfo.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_1);// 未设置密码
			membInfo.setLoginNameSetFlag(DictConstants.LOGIN_NAME_SET_FLAG_1);// 未设置用户名
			membInfo.setLocalityMembType("1");// 标识成不是产地会员
			membInfoMapper.insertSelective(membInfo);
			// 验证用户名是否已经存在 注册用户
			RegisterUserMembPo registerUserMembPo = new RegisterUserMembPo();
			registerUserMembPo.setId(userid);
			registerUserMembPo.setLoginName(userName);// 用户名
			registerUserMembPo.setPassword(pwd);//  随机密码
			registerUserMembPo.setMobile(po.getMobile());// 手机号
			List<String> roleList = new ArrayList<String>();
			roleList.add("ROLE_person");
			registerUserMembPo.setRoleCodes(roleList);// 个人的情况
			registerUserMembPo.setUserType(Constants.USER_TYPE_USER);//"0:管理员 1:用户帐户 2:用户子账户"
			ResultPoJo<User> userResult = userMembMssService.registerMemb(registerUserMembPo);
			if(!userResult.getCode().equals(ConstantError.NOMAL)
					|| ConverterUtil.isEmpty(userResult.getResult().getId())){
				checkRemoteResult(userResult);
			}
		}else{
			// 对于已经存在的用户
			userid = oldMembInfo.getId();
			// 验证该手机号的用户是否已经绑定其他微信
			MembRelevanceInfo membRelevanceInfo = new MembRelevanceInfo();
			membRelevanceInfo.setReleId(userid);
			membReleVanceInfo.setOpenType(ConverterUtil.toString(po.getWechatType()));
			MembRelevanceInfo checkUser = membRelevanceInfoMapper.getMembReleInfo(membRelevanceInfo);
			if(ConverterUtil.isNotEmpty(checkUser)){
				result.setCode(ConstantCodeMsg.ERR_518);
				result.setMsg(ConstantCodeMsg.MSG_518);
				return result;
			}
			// 根据注册手机号判断用户是否能够登录小程序的处理
			String loginId = membInfoMapper.findCanLoginWechat(po.getMobile());
			if(loginId == null){
				result.setCode(ConstantCodeMsg.ERR_811);
				result.setMsg(ConstantCodeMsg.MSG_811);
				return result;
			}
		}
		// 第三方登录关联表信息
		MembRelevanceInfo membReleVance = new MembRelevanceInfo();
		membReleVance.preInsert();
		membReleVance.setType("0");//表示微信第三方登录
		membReleVance.setReleId(userid);
		membReleVance.setOpenId(po.getOpenid());
		membReleVance.setOpenType(ConverterUtil.toString(po.getWechatType()));
		membReleVance.setUnionId(po.getUnionId());
		membReleVance.setRemarks(po.getNickname());
		membRelevanceInfoMapper.insertSelective(membReleVance);
		//模拟用户登录
		ResultPoJo<AuthInfo> successRes = userLoginExtendsService.mobileLogin(request, new MobileValiLoginPo(),
				userid,false);
		if(!successRes.getCode().equals(ConstantError.NOMAL)){
			checkRemoteResult(successRes);
		}
		authInfoVo.setAccessToken(successRes.getResult().getAccessToken());
		authInfoVo.setRefreshToken(successRes.getResult().getRefreshToken());
		authInfoVo.setTokenType(successRes.getResult().getTokenType());
		authInfoVo.setUser(successRes.getResult().getUser());
		authInfoVo.setUnionId(membReleVance.getUnionId());
		// 会员基本信息的处理
		result.setResult(authInfoVo);
		// 清空会员相关的缓存信息
		MembUtils.delMembSelfUser(userid);
		return result;
	}

	/**
	 * 获取unionid
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年2月25日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<WachatBdInfoVo> getWachatUnionId(WechatBdPo wechatBdPo){
		// 返回值初期化处理
		ResultPoJo<WachatBdInfoVo> result = new ResultPoJo<WachatBdInfoVo>(ConstantCodeMsg.NOMAL);
		WachatBdInfoVo vo = new WachatBdInfoVo();
		vo.setOpenId(wechatBdPo.getOpenid());
		String sessionkey = null;
		String redisSessionKey = RedisKeyConstants.WACHAT_SESSION_KEY + wechatBdPo.getOpenid() + wechatBdPo.getWechatType();
		// 需要重新获取sessionkey的情况
		if(ConverterUtil.isNotEmpty(wechatBdPo.getCode())){
			WeChatDateByCodeVo jsonObject = getInfoByCode(wechatBdPo.getCode(),wechatBdPo.getWechatType());
			sessionkey = jsonObject.getSessionkey();
			jedisDao.setSerialize(redisSessionKey,sessionkey);
		}else{
			sessionkey = jedisDao.getSerialize(redisSessionKey, String.class);
		}
		JSONObject userInfo = AesCbcUtil.decryptDataS5(wechatBdPo.getEncryptedData(), sessionkey, wechatBdPo.getIv());
		String unionId = ConverterUtil.toString(userInfo.get("unionId"));
		if(ConverterUtil.isEmpty(unionId)){
			result.setCode(ConstantCodeMsg.ERR_809);
			result.setMsg(ConstantCodeMsg.MSG_809);
			return result;
		}
		vo.setUnionId(unionId);
		result.setResult(vo);
		return result;
	}
	/**
	 * 校验手机号是否已经存在
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2018年11月8日
	 * @version 1.0
	 */
	public ResultPoJo<String> checkByMobile(StringPo po){
		// 返回值初期化
		ResultPoJo<String> result = new ResultPoJo<String>(ConstantError.NOMAL);
		MembCheckMobilePo membCheckMobilePo = new MembCheckMobilePo();
		membCheckMobilePo.setMobile(po.getKeyStr());
		int mobileCount = membInfoMapper.checkMobileExist(membCheckMobilePo);
		// 手机号已经存在的情况
		if(mobileCount > 0){
			result.setCode(ConstantCodeMsg.ERR_501);
			result.setMsg(ConstantCodeMsg.MSG_501);
			return result;
		}
		return result;
	}
}
