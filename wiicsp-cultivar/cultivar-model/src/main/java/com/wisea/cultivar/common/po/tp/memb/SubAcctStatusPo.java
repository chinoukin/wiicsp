package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * SubAcctInfoGetPo
 * 2018/10/11 10:36:38
 */
public class SubAcctStatusPo {

	@ApiModelProperty("ID")
	@Check(test = {"required"})
	private Long id;
	@ApiModelProperty("状态(0:启用 、1 :停用)")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "状态只能为0或1")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
