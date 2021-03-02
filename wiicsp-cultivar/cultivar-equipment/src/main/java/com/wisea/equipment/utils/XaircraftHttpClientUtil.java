package com.wisea.equipment.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.boot.SpringBootContext;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.JsonMapper;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.equipment.config.XaircraftConfig;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Map;
import java.util.UUID;

/**
 * HttpClient工具包
 * 
 * @author XuDL(Wisea)
 *
 *         2018年5月29日 下午5:13:54
 */
public class XaircraftHttpClientUtil {

    public static final Logger logger = LoggerFactory.getLogger(XaircraftHttpClientUtil.class);
    private static JsonMapper jsonMapper = JsonMapper.getInstance();
    public static XaircraftConfig config = SpringBootContext.getBean(XaircraftConfig.class);
    public static JedisDao jedisDao = SpringBootContext.getBean(JedisDao.class);

    public static String XAIRCRAFT_SESSION_KEY = "XAIRCRAFT_SESSION";

    /**
     * 发送post
     * 
     * @param url
     *            接口相对地址
     * @param paramObj
     *            参数
     * @return
     */
    public static String post(String url, Object paramObj) {
        return post(url, paramObj, String.class);
    }

    /**
     * 发送Get请求
     * 
     * @param url
     * @return
     */
    public static String get(String url, Map<String, String> paramMap) {
        // 使用httpclient发送请求
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String signatureUrl = getSignatureUrl(url);
            StringBuffer urlSb = new StringBuffer(signatureUrl);
            if(ConverterUtil.isNotEmpty(paramMap)){
                paramMap.forEach((k, v)->{
                    urlSb.append("&");
                    urlSb.append(k);
                    urlSb.append("=");
                    urlSb.append(v);
                });
            }

            HttpGet httpget = new HttpGet(urlSb.toString());
            httpget.setHeader("Content-Type", "application/json;charset=utf-8");
            httpget.setHeader("session", getSession());
            // 访问极飞物联Get方法
            HttpResponse response = httpclient.execute(httpget);
            LoggerUtil.info("请求地址：{}, 头部参数：{}", urlSb.toString(), httpget.getAllHeaders());
            HttpEntity entity = response.getEntity();
            if (200 == response.getStatusLine().getStatusCode()) {
                // 显示结果
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                String line = null;
                StringBuffer sf = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    sf.append(line);
                }
                LoggerUtil.info("返回值：{}", sf.toString());
                return sf.toString();
            }else if(401 == response.getStatusLine().getStatusCode() || 411 == response.getStatusLine().getStatusCode()){
                //没有权限，重新登录
                LoggerUtil.error("没有权限或seeeion过期，重新登录");
                clearSession();
                getSession();
                return get(url, paramMap);
            }else {
                LoggerUtil.error("Error in XaircraftHttpClientUtil.get status = {}, reason = {}", response.getStatusLine().getStatusCode(), response.getStatusLine().getReasonPhrase());
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
                String line = null;
                StringBuffer sf = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    sf.append(line);
                }
                LoggerUtil.info("返回值：{}", sf.toString());
                return "exception";
            }
        } catch (Exception e) {
            LoggerUtil.error("Error in XaircraftHttpClientUtil.get", e);
            return "exception";
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                LoggerUtil.error("Error in XaircraftHttpClientUtil.get", e);
                return "exception";
            }
        }
    }



    /**
     * 发送post请求到登录中心
     *
     * @param <T>
     *
     * @param url
     *            接口相对地址
     * @param paramObj
     *            参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T post(String url, Object paramObj, Class<?>... returnClassArray) {
        // 转json
        String param = JsonMapper.toJsonString(paramObj);

        // 使用httpclient发送请求
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(getSignatureUrl(url));
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setHeader("session", getSession());
        // 设置参数
        StringEntity paramEntity = new StringEntity(param, "utf-8");
        paramEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(paramEntity);

        try {
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            // 显示结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
            String line = null;
            StringBuffer sf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sf.append(line);
            }
            httpclient.close();

            String resultString = sf.toString();
            LoggerUtil.error("请求地址：", getSignatureUrl(url));
            LoggerUtil.error("返回值：", sf.toString());
            if (null != returnClassArray) {
                if (returnClassArray.length > 1) {
                    JavaType dataType = jsonMapper.createCollectionType(returnClassArray[0], ArrayUtils.subarray(returnClassArray, 1, returnClassArray.length));
                    return jsonMapper.fromJson(resultString, dataType);
                } else {
                    if (returnClassArray[0].equals(String.class)) {
                        return (T) resultString;
                    } else {
                        return (T) jsonMapper.fromJson(resultString, returnClassArray[0]);
                    }
                }
            }

        } catch (Exception e) {
            LoggerUtil.error("exception in postToLoginCenter", e);
        }
        return null;
    }

    /**
     * 登录极飞物联，返回session
     *
     * @param url
     *            接口相对地址
     * @param account
     *            用户名
     * @param password
     *            密码
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getSession(String url, String account, String password) {
        Map<String, String> paramObj = Maps.newHashMap();
        paramObj.put("account", account);
        paramObj.put("password", XaircraftAesCbcUtil.encrypt(password, config.getSecret(), config.getClientID()));

        // 转json
        String param = JsonMapper.toJsonString(paramObj);
        LoggerUtil.info(MessageFormat.format("极飞物联登录：url: {0}, 参数：{1}", url, param));
        // 使用httpclient发送请求
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");

        // 设置参数
        StringEntity paramEntity = new StringEntity(param, "utf-8");
        paramEntity.setContentEncoding("UTF-8");
        httpPost.setEntity(paramEntity);

        try {
            HttpResponse response = httpclient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            // 显示结果
            BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
            String line = null;
            StringBuffer sf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sf.append(line);
            }
            httpclient.close();

            String resultString = sf.toString();
            LoggerUtil.info(MessageFormat.format("极飞物联登录返回值：{0}", resultString));
            Map map = JsonMapper.getInstance().readValue(resultString, Map.class);
            return (String) map.get("session");
        } catch (Exception e) {
            LoggerUtil.error("exception in postToLoginCenter", e);
        }
        return null;
    }

    public static String getSignatureUrl(String url){
        String timestamp = getNowTimeStamp();
        String nonce = UUID.randomUUID().toString().replaceAll("-", "");
        String signature = HmacUtils.hmacSha1Hex(config.getSecret(), timestamp + nonce);
        StringBuffer sb = new StringBuffer();
        sb.append(url);
        sb.append("?");
        sb.append("timestamp=");
        sb.append(timestamp);
        sb.append("&");
        sb.append("client_id=");
        sb.append(config.getClientID());
        sb.append("&");
        sb.append("nonce=");
        sb.append(nonce);
        sb.append("&");
        sb.append("signature=");
        sb.append(signature);
        String newUrl = sb.toString();
        return newUrl;
    }

    public static String getNowTimeStamp() {
        long time = System.currentTimeMillis();
        String nowTimeStamp = String.valueOf(time / 1000);
        return nowTimeStamp;
    }

    /**
     * @Author jirg
     * @Date 2019/2/22 16:56
     * @Description 获取登陆session
     **/
    public static String getSession(){
        String session = jedisDao.getStr(XAIRCRAFT_SESSION_KEY);
        if(ConverterUtil.isEmpty(session)){
            synchronized (XAIRCRAFT_SESSION_KEY){
                session = jedisDao.getStr(XAIRCRAFT_SESSION_KEY);
                if(ConverterUtil.isEmpty(session)){
                    session = XaircraftHttpClientUtil.getSession(getSignatureUrl(config.getBaseUrl().concat(config.getLoginUrl())), config.getAccount(), config.getPassword());
                    if(ConverterUtil.isNotEmpty(session)){
                        jedisDao.setStrExpire(XAIRCRAFT_SESSION_KEY, session, 36000); //缓存session过期时间为10小时，极飞session是12小时过期
                    }
                }
            }
        }
        return session;
    }

    /**
     * @author jirg
     * @date 2020/7/8 13:41
     * @Description 删除session缓存
     */
    public static void clearSession() {
        jedisDao.delStr(XAIRCRAFT_SESSION_KEY);
    }

}
