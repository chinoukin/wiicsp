package com.wisea.equipment.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jirg
 * @version 1.0
 * @className XaircraftConfig
 * @date 2020/7/8 10:00
 * @Description 极飞物联配置文件（基于极飞接口v5版本）
 */
@Component
@ConfigurationProperties(prefix = "equipment.xaircraft")
public class XaircraftConfig {
    private String account; //开放平台账户
    private String password; //开放平台密码
    private String clientID; //client_id
    private String secret; //secret
    private String baseUrl; //请求基本地址
    private String deviceInfoUrl; //查询设备详细信息地址
    private String lastPointUrl; //获取设备最近一条数据点
    private String loginUrl; //登录地址

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getDeviceInfoUrl() {
        return deviceInfoUrl;
    }

    public void setDeviceInfoUrl(String deviceInfoUrl) {
        this.deviceInfoUrl = deviceInfoUrl;
    }

    public String getLastPointUrl() {
        return lastPointUrl;
    }

    public void setLastPointUrl(String lastPointUrl) {
        this.lastPointUrl = lastPointUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
