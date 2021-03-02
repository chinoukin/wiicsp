package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

public class SubEntpPicture extends DataLongEntity<SubEntpPicture> {

	/**
	 * 分公司id
	 */
	@ApiModelProperty(value = "分公司id")
	private Long subEntpId;

	/**
	 * 介绍图片
	 */
	@ApiModelProperty(value = "介绍图片")
	private String jsUrl;

	/**
	 * 排序
	 */
	@ApiModelProperty(value = "排序")
	private Integer sort;

	public Long getSubEntpId() {
		return subEntpId;
	}

	public void setSubEntpId(Long subEntpId) {
		this.subEntpId = subEntpId;
	}

	public String getJsUrl() {
		return jsUrl;
	}

	public void setJsUrl(String jsUrl) {
		this.jsUrl = jsUrl;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
