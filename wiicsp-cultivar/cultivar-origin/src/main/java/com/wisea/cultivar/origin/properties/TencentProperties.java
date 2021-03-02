package com.wisea.cultivar.origin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 百度地图相关properties
 *
 * @author wangh(wisea)
 *
 * @date 2019年10月17日
 * @version 1.0
 */
@ConfigurationProperties(prefix = "tencent.mapapp")
public class TencentProperties {

	// 百度地图地址
	private String mapurl;
	// 百度地图密钥
	private String mapkey;
	public String getMapurl() {
		return mapurl;
	}
	public void setMapurl(String mapurl) {
		this.mapurl = mapurl;
	}
	public String getMapkey() {
		return mapkey;
	}
	public void setMapkey(String mapkey) {
		this.mapkey = mapkey;
	}

}
