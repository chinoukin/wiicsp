package com.wisea.cultivar.origin.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "fklm.web")
public class FklmSampInfoPropertis {

	// 样品同步到风控联盟的地址
	private String sampadd;
	// 风控联盟检测后同步到样品信息表的地址
	private String sampfreshen;
	// 样品的数据来源
	private String dataSourceType;

	public String getSampadd() {
		return sampadd;
	}
	public void setSampadd(String sampadd) {
		this.sampadd = sampadd;
	}
	public String getSampfreshen() {
		return sampfreshen;
	}
	public void setSampfreshen(String sampfreshen) {
		this.sampfreshen = sampfreshen;
	}
	public String getDataSourceType() {
		return dataSourceType;
	}
	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}

}
