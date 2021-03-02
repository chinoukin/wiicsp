package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 前台显示图片的查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月1日
 * @version 1.0
 */
@ApiModel("前台显示图片的查询PO")
public class AdverMageNotAuthPo {

	@Check(test = {"required","maxLength"}, mixLength = 200)
    @ApiModelProperty(value = "广告位名称(adver_space_name 0:首页轮播图)")
    private String adverSpaceName;

	public String getAdverSpaceName() {
		return adverSpaceName;
	}

	public void setAdverSpaceName(String adverSpaceName) {
		this.adverSpaceName = adverSpaceName;
	}
}
