package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 登录后判断是运营平台或者市场的PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月28日
 * @version 1.0
 */
@ApiModel("登录后判断是运营平台或者市场的PO")
public class PlatOrMarketLoginInfoVo {

	@ApiModelProperty(value="市场ID(如果是平台人员登录是空)")
	private Long marketId;

	@ApiModelProperty(value="市场名称")
	private String marketName;

	@ApiModelProperty(value="标识(0:运营平台用户1:市场用户)")
	private String flag;

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
}
