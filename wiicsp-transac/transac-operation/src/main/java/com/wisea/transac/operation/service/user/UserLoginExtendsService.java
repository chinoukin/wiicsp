package com.wisea.transac.operation.service.user;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wisea.transac.operation.utils.JwtCreateUtils;
import com.wisea.transac.operation.utils.LoginUserCheckUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.CacheKey;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.properties.LoginOauthProperties;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.service.BusEventsService;
import com.wisea.cloud.common.service.ValidateCodeService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.IdGen;
import com.wisea.cloud.common.util.WbfcJwtOauthUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.rabbit.events.info.UserLoginEventInfo;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.constants.DictConstants;
import com.wisea.transac.common.dao.MembInfoMapper;
import com.wisea.transac.common.entity.MembInfo;
import com.wisea.transac.common.entity.MembLoginCityOrLocInfo;
import com.wisea.transac.common.po.memb.LoginNameOrMobilePo;
import com.wisea.transac.common.po.memb.MobileValiLoginPo;
import com.wisea.transac.common.po.memb.RegisterUserMembPo;
import com.wisea.transac.common.utils.MembUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 登录相关的Service
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月11日
 * @version 1.0
 */
@Service
@EnableConfigurationProperties(LoginOauthProperties.class)
public class UserLoginExtendsService extends BaseService{

	@Autowired
	private JedisDao jedisDao;
	@Autowired
	private LoginOauthProperties loginOauthProperties;
	@Autowired
	private BusEventsService busEventsService;
	@Autowired
	private ValidateCodeService validateCodeService;
	@Autowired
	private MembInfoMapper membInfoMapper;
	@Autowired
	private UserMembMssService userMembMssService;

	/**
	 *  手机号登录处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	public  ResultPoJo<AuthInfo> mobileLogin(HttpServletRequest request,MobileValiLoginPo po,Long userId,boolean isVliMobile){
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		AuthInfo info = null;
		User user = UserUtils.getById(userId);
		// 用户是否存在的验证
		if(ConverterUtil.isEmpty(user) || ConverterUtil.isEmpty(user.getId())){
			result.setCode(ConstantError.ERR_907);
			result.setMsg(ConstantError.MSG_907);
			return result;
		}
		// 校验不通过
        if (isVliMobile && !validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), false)) {
            // 验证码错误或已过期
            result.setCode(ConstantError.ERR_904);
			result.setMsg(ConstantError.MSG_904);
			return result;
        }
//        // 校验登录类型
//        if (!UserUtils.checkLoginType("web", user.getUserType())) {
//            // 登录类型不正确也按未找到用户处理
//        	result.setCode(ConstantError.ERR_907);
//			result.setMsg(ConstantError.MSG_907);
//			return result;
//        }
		// 校验登录flag
        if (!Constants.YES.equals(user.getLoginFlag())) {
            // 不允许登录
            result.setCode(ConstantError.ERR_908);
			result.setMsg(ConstantError.MSG_908);
			return result;
        }
        // 校验有效期是否過期
        if (ConverterUtil.isNotEmpty(user.getAvailableDate()) && user.getAvailableDate().compareTo(OffsetDateTime.now()) <= 0) {
            // 用户已过期
            result.setCode(ConstantError.ERR_909);
			result.setMsg(ConstantError.MSG_909);
			return result;
        }
        // 从redis获取token
        String jwtKey = CacheKey.getJwtTokenKey(user.getLoginName());
        String tokenStr = jedisDao.getStr(jwtKey);
        if (ConverterUtil.isEmpty(tokenStr)) {
        	// 获取 author
        	String[] author = JwtCreateUtils.getAuthor(user);
        	Map<String, Object> headerMap = Maps.newLinkedHashMap();
            headerMap.put("typ", "JWT");
        	tokenStr = Jwts.builder().setSubject(user.getLoginName()).claim("user_name",user.getLoginName()).claim("openId", user.getOpenId())
                    .claim("userId", user.getId()).claim("authorities", author).setExpiration(new Date(System.currentTimeMillis() + loginOauthProperties.getExpire() * 1000)).setHeader(headerMap)
                    .signWith(SignatureAlgorithm.RS256, WbfcJwtOauthUtil.getPrivateKey()).compact();
            // 设置自动过期的token到redis
            jedisDao.setStrExpire(jwtKey, tokenStr, loginOauthProperties.getExpire());
        }

        info = new AuthInfo("bearer", tokenStr, "", user);
        // 发送登录消息，若没有配置busevents则不会发送
        UserLoginEventInfo eventInfo = new UserLoginEventInfo();
        String ip = SystemUtils.getIpAddr(request);
        eventInfo.setUser(user);
        eventInfo.setIp(ip);
        eventInfo.setLoginDate(OffsetDateTime.now());
        eventInfo.setParam(ConverterUtil.toString(po));
        busEventsService.sendUserLoginEvent(eventInfo);
        result.setResult(info);
        // 手机验证码清空
        if(isVliMobile){
        	validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), true);
        }
        return result;
	}
	/**
	 * 登录初期化设置refreshToken
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月11日
	 * @version 1.0
	 */
	public void loginInitRefreshToken(UserLoginEventInfo eventInfo){
		User user = eventInfo.getUser();
		if(user != null){
			// 设置自动到期的refresh_token到Redis -- 过期时间是30天
	        String refreshKey = MembUtils.mobileLoginRefreshKey(ConverterUtil.toString(user.getId()));
	        String refreshToken = jedisDao.getStr(refreshKey);
	        if(ConverterUtil.isEmpty(refreshToken)){
	        	// 获取 author
	            String[] author = JwtCreateUtils.getAuthor(user);
	            Map<String, Object> headerMap = Maps.newLinkedHashMap();
	            headerMap.put("typ", "JWT");
	            refreshToken = Jwts.builder().setSubject(user.getLoginName()).claim("user_name",user.getLoginName()).claim("openId", user.getOpenId())
	                    .claim("userId", user.getId()).claim("authorities", author).setHeader(headerMap)
	                    .signWith(SignatureAlgorithm.RS256, WbfcJwtOauthUtil.getPrivateKey()).compact();
	        	jedisDao.setStrExpire(refreshKey, refreshToken, 2592000);
	        }
		}
	}
	/**
	 * 手机号验证码登录的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月11日
	 * @version 1.0
	 */
	public ResultPoJo<AuthInfo> mobileValiCodeLogin(HttpServletRequest request,MobileValiLoginPo po){
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		// 获取登录类型
        String loginType = ConverterUtil.toString(request.getParameter("ltype"), "city_bus");
		// 用户名密码的验证
		if(ConverterUtil.isNotEmpty(po.getMobile(), po.getValCode())){
			// 验证处理
			ResultPoJo<String> checkResult = LoginUserCheckUtils.checkLocOrCityLogin(loginType, null,po.getMobile());
			if(checkResult != null && ConstantCodeMsg.NOMAL.equals(checkResult.getCode())
					&& ConverterUtil.isNotEmpty(checkResult.getResult())){
				// 登录处理
	            result = this.mobileLogin(request, po, ConverterUtil.toLong(checkResult.getResult()),true);
			}else{
				result.setCode(ConstantError.ERR_907);
				result.setMsg(ConstantError.MSG_907);
				return result;
			}
        }else{
            // 手机号和验证码不能为空
            result.setCode(ConstantCodeMsg.ERR_005);
			result.setMsg("手机号或者验证码不能为空");
			return result;
        }
		return result;
	}
	/**
	 * 手机号验证码登录处理(如果手机号不存在则注册新的账户后登录处理)
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月18日
	 * @version 1.0
	 */
	@Transactional(readOnly = false)
	public ResultPoJo<AuthInfo> mobileLoginOrReg(HttpServletRequest request,MobileValiLoginPo po){
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		// 手机号和验证码不能为空
		if(ConverterUtil.isNotEmpty(po.getMobile(), po.getValCode())){
			Long userId = null;
			// 通过注册手机号查询用户信息
    		MembInfo existInfo = MembUtils.getMembInfoByRegTel(po.getMobile());
			// 如果为空的情况需要注册处理
			if(existInfo == null || ConverterUtil.isEmpty(existInfo.getId())){
				// 校验不通过
		        if (!validateCodeService.checkSMSCode(po.getMobile(), po.getValCode(), false)) {
		            // 验证码错误或已过期
		            result.setCode(ConstantError.ERR_904);
					result.setMsg(ConstantError.MSG_904);
					return result;
		        }
				// 数据库中该手机号没有注册的情况 注册新用户
				String pwd = IdGen.randomBase62(32);
				String userName = MembUtils.getRandomUserName();
				// 本地数据库会员表的插入
				MembInfo membInfo = new MembInfo();
				membInfo.preInsert();
				userId = membInfo.getId();
				membInfo.setLoginName(userName);
				membInfo.setRegistTel(po.getMobile());
				// 新增的时候设置默认值
				membInfo.setRegistDate(OffsetDateTime.now());
				membInfo.setAgentFlag(DictConstants.AGENT_FLAG_1);//普通用户
				membInfo.setAcctState(DictConstants.ACCT_STATE_0);//账户状态0：正常
				membInfo.setPetName(MembUtils.getRandomUserName());//昵称
				membInfo.setMembType(DictConstants.MEMB_TYPE_2);// 会员类型0:企业1：个体户2：个人(未认证前是空如果认证了 填写对应的认证标识)
				membInfo.setEntpAuthStateType(DictConstants.ENTP_AUTH_STATE_TYPE_1);//未认证
				membInfo.setPasswordSetFlag(DictConstants.PASSWORD_SET_FLAG_1);// 未设置密码
				membInfo.setLoginNameSetFlag(DictConstants.LOGIN_NAME_SET_FLAG_1);// 未设置用户名
				membInfoMapper.insertSelective(membInfo);
				// 验证用户名是否已经存在 注册用户
				RegisterUserMembPo registerUserMembPo = new RegisterUserMembPo();
				registerUserMembPo.setId(userId);
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
				userId = existInfo.getId();
				// 判断是否允许登录
				LoginNameOrMobilePo loginNameOrMobilePo = new LoginNameOrMobilePo();
				loginNameOrMobilePo.setMobile(po.getMobile());
				MembLoginCityOrLocInfo membInfo = MembUtils.sellerAppLoginCheck(loginNameOrMobilePo);
				if(membInfo != null && "2".equals(membInfo.getMembClass())){
					result.setCode(ConstantCodeMsg.ERR_954);
					result.setMsg(ConstantCodeMsg.MSG_954);
					return result;
				}
			}
			// 登录处理
            result = this.mobileLogin(request, po, userId,true);
		}else{
			// 手机号和验证码不能为空
            result.setCode(ConstantCodeMsg.ERR_005);
			result.setMsg("手机号或者验证码不能为空");
			return result;
		}
		return result;
	}
	/**
	 * 刷新登录的处理
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年8月11日
	 * @version 1.0
	 */
	public ResultPoJo<AuthInfo> reFreshTokenForMobile(HttpServletRequest request,LongIdPo po){
		// 返回参数初期化
		ResultPoJo<AuthInfo> result = new ResultPoJo<>();
		User user = UserUtils.getById(po.getId());
		if(user != null){
			// 获取刷新的TOKEN
			String refreshKey = MembUtils.mobileLoginRefreshKey(ConverterUtil.toString(user.getId()));
	        String refreshToken = jedisDao.getStr(refreshKey);
	        if(ConverterUtil.isEmpty(refreshToken)){
	        	result.setCode(ConstantCodeMsg.ERR_952);
				result.setMsg(ConstantCodeMsg.MSG_952);
				return result;
	        }
			// 获取 author
	        String[] author = JwtCreateUtils.getAuthor(user);
	        Map<String, Object> headerMap = Maps.newLinkedHashMap();
            headerMap.put("typ", "JWT");
            // 设置自动到期的refresh_token到Redis -- 过期时间是30天
            String checkToken = Jwts.builder().setSubject(user.getLoginName()).claim("user_name",user.getLoginName()).claim("openId", user.getOpenId())
                    .claim("userId", user.getId()).claim("authorities", author).setHeader(headerMap)
                    .signWith(SignatureAlgorithm.RS256, WbfcJwtOauthUtil.getPrivateKey()).compact();
            // 如果token相同证明是相同的用户并且用户信息没有修改 生成新的token返回给客户端
            if(refreshToken.equals(checkToken)){
            	// 校验登录flag
                if (!Constants.YES.equals(user.getLoginFlag())) {
                    // 不允许登录
                    result.setCode(ConstantError.ERR_908);
        			result.setMsg(ConstantError.MSG_908);
        			return result;
                }
                // 校验有效期是否過期
                if (ConverterUtil.isNotEmpty(user.getAvailableDate()) && user.getAvailableDate().compareTo(OffsetDateTime.now()) <= 0) {
                    // 用户已过期
                    result.setCode(ConstantError.ERR_909);
        			result.setMsg(ConstantError.MSG_909);
        			return result;
                }
        		// 获取 author
                String jwtKey = CacheKey.getJwtTokenKey(user.getLoginName());
                String tokenStr = Jwts.builder().setSubject(user.getLoginName()).claim("user_name",user.getLoginName()).claim("openId", user.getOpenId())
                        .claim("userId", user.getId()).claim("authorities", author).setExpiration(new Date(System.currentTimeMillis() + loginOauthProperties.getExpire() * 1000)).setHeader(headerMap)
                        .signWith(SignatureAlgorithm.RS256, WbfcJwtOauthUtil.getPrivateKey()).compact();
                // 设置自动过期的token到redis
                jedisDao.setStrExpire(jwtKey, tokenStr, loginOauthProperties.getExpire());
                AuthInfo info = new AuthInfo("bearer", tokenStr, "", user);
                // 发送登录消息，若没有配置busevents则不会发送
                UserLoginEventInfo eventInfo = new UserLoginEventInfo();
                String ip = SystemUtils.getIpAddr(request);
                eventInfo.setUser(user);
                eventInfo.setIp(ip);
                eventInfo.setLoginDate(OffsetDateTime.now());
                eventInfo.setParam(null);
                busEventsService.sendUserLoginEvent(eventInfo);
                result.setResult(info);
            }else{
            	// 删除刷新的TOKEN
            	jedisDao.delStr(refreshKey);
            	result.setCode(ConstantCodeMsg.ERR_953);
				result.setMsg(ConstantCodeMsg.MSG_953);
				return result;
            }
		}else{
			result.setCode(ConstantError.ERR_001);
			result.setMsg(ConstantError.MSG_001);
		}
		return result;
	}
}
