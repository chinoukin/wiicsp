package com.wisea.cultivar.origin.po;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 检测报告PO
 * @author wzx
 *
 */
@ApiModel("检测报告PO")
public class ImgListPo {

    @ApiModelProperty("样品ID")
    @Check(test = "required")
    private Long sampId;
	@ApiModelProperty(value="检测报告")
	private List<ImgPo> imgList = Lists.newArrayList(); //检测报告

	public Long getSampId() {
		return sampId;
	}

	public void setSampId(Long sampId) {
		this.sampId = sampId;
	}

	public List<ImgPo> getImgList() {
		return imgList;
	}

	public void setImgList(List<ImgPo> imgList) {
		this.imgList = imgList;
	}
}
