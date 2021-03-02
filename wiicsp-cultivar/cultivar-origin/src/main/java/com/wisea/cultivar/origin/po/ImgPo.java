package com.wisea.cultivar.origin.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片PO
 * @author wzx
 *
 */
@ApiModel("图片PO")
public class ImgPo {

	@ApiModelProperty(value="图片路径")
    private String url;//图片路径

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
