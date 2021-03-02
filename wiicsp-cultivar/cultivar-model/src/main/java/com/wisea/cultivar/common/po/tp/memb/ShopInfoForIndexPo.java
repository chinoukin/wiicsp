package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据会员ID查询店铺信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月6日
 * @version 1.0
 */
@ApiModel("根据会员ID查询店铺信息PO")
public class ShopInfoForIndexPo {

	@ApiModelProperty("会员ID")
    @Check(test = "required")
    private Long id;
	@ApiModelProperty("标识(0:只查询不添加1:如果没有店铺添加店铺)")
	private String flag = "0";
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
