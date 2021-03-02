package com.wisea.cultivar.common.vo.tp.origin;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片vo
 *
 * @author wzx
 *
 */
@ApiModel("图片vo")
public class ImgVo {

	@ApiModelProperty(value = "图片路径")
	private String url;

	@ApiModelProperty(value = "排序")
	private String sort;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
