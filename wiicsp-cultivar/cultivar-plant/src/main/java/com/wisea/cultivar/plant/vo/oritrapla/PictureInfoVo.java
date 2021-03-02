package com.wisea.cultivar.plant.vo.oritrapla;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员照片的显示VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("照片的显示VO")
public class PictureInfoVo {
	@ApiModelProperty("照片地址")
	private String url;
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
