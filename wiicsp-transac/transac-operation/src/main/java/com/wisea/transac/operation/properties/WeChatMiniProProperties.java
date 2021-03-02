package com.wisea.transac.operation.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 * 微信小程序配置的常量
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月8日
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wbfc.weixin")
public class WeChatMiniProProperties {

	// 小程序Id
	private String appId;
	// 小程序密钥
	private String appSecret;
	// 服务端地址
	private String HttpStr = "https://api.weixin.qq.com/sns/jscode2session";

	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getHttpStr() {
		return HttpStr;
	}
	public void setHttpStr(String httpStr) {
		HttpStr = httpStr;
	}
}
