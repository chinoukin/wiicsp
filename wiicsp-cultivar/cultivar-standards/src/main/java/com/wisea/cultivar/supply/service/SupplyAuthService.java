package com.wisea.cultivar.supply.service;

import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.CacheKey;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.constants.Constants;
import com.wisea.cloud.common.entity.AuthInfo;
import com.wisea.cloud.common.exception.VerifyException;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BusEventsService;
import com.wisea.cloud.common.sms.SmsService;
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.PasswordUtil;
import com.wisea.cloud.common.util.WbfcJwtOauthUtil;
import com.wisea.cloud.rabbit.events.info.UserLoginEventInfo;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.constants.QdcyStandardsError;
import com.wisea.cultivar.supply.mapper.CuMageMapper;
import com.wisea.cultivar.supply.po.PwdBackPo;
import com.wisea.cultivar.supply.po.ValCodeLoginPo;
import com.wisea.cultivar.supply.util.CustomUtils;
import com.wisea.cultivar.supply.util.JwtCreateUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 认证相关
 * @author chengq
 * @date 2020/8/27 14:54
 */
@Service
public class SupplyAuthService {
    @Resource
    private CuMageMapper cuMageMapper;
    @Resource
    private SmsService smsService;
    @Resource
    private JedisDao jedisDao;
    @Resource
    private BusEventsService busEventsService;
    @Resource
    private JwtCreateUtils jwtCreateUtils;

    /**
     * 有效期
     */
    public static int EXPIRE = 12 * 60 * 60;

    /**
     * 手机验证码登录
     */
    public ResultPoJo<AuthInfo> valCodeLogin(ValCodeLoginPo valCodeLoginPo, HttpServletRequest request) {
        //判断手机号是否存在
        String mobile = valCodeLoginPo.getMobile();
        //验证验证码
        checkSMSCode(mobile, valCodeLoginPo.getValCode());
        //检查用户
        User user = checkUser(mobile);
        //用户登录
        String paramStr = ConverterUtil.gson.toJson(valCodeLoginPo);
        String ip = SystemUtils.getIpAddr(request);
        return login(user, ip, paramStr);
    }

    /**
     * 找回用户密码
     */
    public ResultPoJo<Object> pwdBackConfirm(PwdBackPo pwdBackPo) {
        String mobile = pwdBackPo.getMobile();
        //验证验证码
        checkSMSCode(mobile, pwdBackPo.getValCode());
        //检查并获取用户
        User user = checkUser(mobile);
        //设置新密码
        user.setPassword(PasswordUtil.entryptPassword(pwdBackPo.getNewPassword()));
        user.preUpdate();
        cuMageMapper.updatePwd(user);
        //清除用户缓存
        clearUserLoginCache(user);
        return CustomUtils.result();
    }

    /**
     * 通过手机号检查用户
     * @param mobile 手机号
     */
    public User checkUser(String mobile) {
        //查询用户
        List<User> users = cuMageMapper.getByMobile(mobile);
        //用户为空需要进行注册
        if (ConverterUtil.isEmpty(users)) {
            throw ConstantError.VER_907;
        }
        if (ConverterUtil.isNotEmpty(users) && users.size() > 1) {
            //用户存在多个，不允许用验证码登录
            throw new VerifyException(QdcyStandardsError.ERR_10017, QdcyStandardsError.MSG_10017);
        }
        User user = users.get(0);
        //判断用户是否可以登录
        if(Objects.equals(user.getLoginFlag(), Constants.NO)) {
            throw new VerifyException(ConstantError.ERR_908, ConstantError.MSG_908);
        }
        return users.get(0);
    }

    /**
     * 登录
     * @param user 用户
     * @param ip ip
     * @param paramStr 请求参数
     */
    private ResultPoJo<AuthInfo> login(User user, String ip, String paramStr){
        // 返回参数初期化
        ResultPoJo<AuthInfo> result = new ResultPoJo<>();
        try{
            AuthInfo info;
            // 获取 author
            String[] author = jwtCreateUtils.getAuthor(user);
            String jwtKey = CacheKey.getJwtTokenKey(user.getLoginName());
            String tokenStr = jedisDao.getStr(jwtKey);
            if (ConverterUtil.isEmpty(tokenStr)) {
                Map<String, Object> headerMap = Maps.newLinkedHashMap();
                headerMap.put("typ", "JWT");
                tokenStr = Jwts.builder().setSubject(user.getLoginName()).claim("user_name",user.getLoginName()).claim("openId", user.getOpenId()).claim("authorities", author)
                        .claim("userId", user.getId()).setExpiration(new Date(System.currentTimeMillis() + EXPIRE * 1000)).setHeader(headerMap)
                        .signWith(SignatureAlgorithm.RS256, WbfcJwtOauthUtil.getPrivateKey()).compact();
                // 设置自动过期的token到redis
                jedisDao.setStrExpire(jwtKey, tokenStr, EXPIRE);
            }
            info = new AuthInfo("bearer", tokenStr, "", user);
            // 发送登录消息，若没有配置busevents则不会发送
            UserLoginEventInfo eventInfo = new UserLoginEventInfo();
            eventInfo.setUser(user);
            eventInfo.setIp(ip);
            eventInfo.setLoginDate(OffsetDateTime.now());
            eventInfo.setParam(paramStr);
            busEventsService.sendUserLoginEvent(eventInfo);
            result.setResult(info);
        }catch(Exception e){
            e.printStackTrace();
            result.setCode(ConstantError.ERR_999);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 校验验证码
     * @param mobile 手机号
     * @param valCode 验证码
     */
    private void checkSMSCode(String mobile, String valCode) {
        Boolean checkSMSCode = smsService.checkSMSCode(mobile, valCode);
        if (!checkSMSCode) {
            //验证码不正确
            throw ConstantError.VER_904;
        }
    }

    /**
     * 清除用户缓存
     */
    public void clearUserLoginCache(User user) {
        String id = CacheKey.getUserId(user.getId());
        String openId = CacheKey.getUserOpenId(user.getOpenId());
        String loginName = CacheKey.getUserLoginName(user.getLoginName());
        jedisDao.delSerialize(id, openId, loginName);
    }

    /**
     * 验证手机号和用户名是否已经存在
     */
    public void checkMobile(String mobile) {
        List<User> users = cuMageMapper.getByMobile(mobile);
        if (ConverterUtil.isNotEmpty(users)) {
            throw new VerifyException(ConstantCodeMsg.ERR_501, ConstantCodeMsg.MSG_501);
        }
    }

    /**
     * 验证用户名否已经存在
     */
    public void checkLoginName(String loginName) {
        User user = cuMageMapper.getByLoginName(loginName);
        if (Objects.nonNull(user)) {
            throw ConstantError.VER_905;
        }
    }
}
