package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商户注册的时候验证是否是买家Vo
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月22日
 * @version 1.0
 */
@ApiModel("商户注册的时候验证是否是买家Vo")
public class ChcekMobileIsEntpVo {

	@ApiModelProperty("会员ID")
	private Long membId;
	@ApiModelProperty("登录用户名")
	private String loginName;
	@ApiModelProperty("采购员ID")
	private Long purId;
	@ApiModelProperty("销售员ID")
	private Long saleId;
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Long getPurId() {
		return purId;
	}
	public void setPurId(Long purId) {
		this.purId = purId;
	}
	public Long getSaleId() {
		return saleId;
	}
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
}
