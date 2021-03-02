package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员统计vo
 * @author user
 *
 */
@ApiModel("会员统计vo")
public class RegistStaticsVo {

	@ApiModelProperty(value = "会员数量")
	private String registNum;
	@ApiModelProperty(value = "日期")
	private String registDate;

	public String getRegistNum() {
		return registNum;
	}
	public void setRegistNum(String registNum) {
		this.registNum = registNum;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
}
