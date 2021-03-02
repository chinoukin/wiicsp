package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 广告位管理信息保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月31日
 * @version 1.0
 */
@ApiModel("广告位管理信息保存PO")
public class AdverSpaceMageUpdPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增不填写/修改为必填项)")
    private Long id;

    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "广告位名称(首页轮播图)")
    private String adverSpaceName;

    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "广告位类别(PC幻灯、WAP幻灯、PC图片)")
    private String adverSpaceType;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "宽度")
    private Integer weight;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "高度")
    private Integer height;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序")
    private Integer sort;

    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "状态（启用、停用）")
    private String enableFlag;

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

	public String getAdverSpaceType() {
		return adverSpaceType;
	}

	public void setAdverSpaceType(String adverSpaceType) {
		this.adverSpaceType = adverSpaceType;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

}
