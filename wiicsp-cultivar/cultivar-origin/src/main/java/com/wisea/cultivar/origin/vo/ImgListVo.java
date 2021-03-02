package com.wisea.cultivar.origin.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片
 * @author wzx
 *
 */
@ApiModel("图片VO")
public class ImgListVo {

	@ApiModelProperty("图片")
	private String url; // 图片
	@ApiModelProperty(value="排序",hidden=true)
	private Integer sort;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
