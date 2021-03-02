package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证广告位名称不能重复添加PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月31日
 * @version 1.0
 */
@ApiModel("验证广告位名称不能重复添加PO")
public class AdverSpaceMageCheckNamePo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增不填写/修改为必填项)")
	private Long id;

	@Check(test = {"required","maxLength"}, mixLength = 200)
    @ApiModelProperty(value = "广告位名称(首页轮播图)")
    private String adverSpaceName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdverSpaceName() {
		return adverSpaceName;
	}

	public void setAdverSpaceName(String adverSpaceName) {
		this.adverSpaceName = adverSpaceName;
	}

}
