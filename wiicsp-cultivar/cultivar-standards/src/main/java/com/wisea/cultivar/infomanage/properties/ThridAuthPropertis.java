package com.wisea.cultivar.infomanage.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 模拟第三方审核配置文件
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月25日
 * @version 1.0
 */
@ConfigurationProperties(prefix = "wbfc.thridauth")
public class ThridAuthPropertis {

	// 是否模拟第三方审核 true 是 false 否
	private boolean enabled = false;
	// 商编
	private String merchantNo;

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

}
