package com.wisea.cultivar.operation.service;

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
import com.wisea.cloud.common.sys.entity.User;
import com.wisea.cloud.common.sys.util.SystemUtils;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.WbfcJwtOauthUtil;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cloud.rabbit.events.info.UserLoginEventInfo;
import com.wisea.cloud.security.utils.UserUtils;
import com.wisea.cultivar.common.constants.ConstantCodeMsg;
import com.wisea.cultivar.common.utils.MembUtils;
import com.wisea.cultivar.operation.utils.JwtCreateUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.Map;

@Service
@EnableConfigurationProperties(LoginOauthProperties.class)
public class LoginExtendsService extends BaseService {

    @Autowired
    private JedisDao jedisDao;
    @Autowired
    private LoginOauthProperties loginOauthProperties;
    @Autowired
    private BusEventsService busEventsService;

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
     * 刷新登录的处理
     *
     * @author wangh(wisea)
     *
     * @date 2020年8月11日
     * @version 1.0
     */
    public ResultPoJo<AuthInfo> reFreshTokenForMobile(HttpServletRequest request, LongIdPo po){
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
