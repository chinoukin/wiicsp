package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台检索框查询企业列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年12月5日
 * @version 1.0
 */
@ApiModel("后台检索框查询企业列表PO")
public class EntpInfoForAllListPo {

	@ApiModelProperty(value = "企业名称(商家名称/买家)")
    private String compName;
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "需要排除的ID")
	private Long otherId;

	public Long getOtherId() {
		return otherId;
	}

	public void setOtherId(Long otherId) {
		this.otherId = otherId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}
