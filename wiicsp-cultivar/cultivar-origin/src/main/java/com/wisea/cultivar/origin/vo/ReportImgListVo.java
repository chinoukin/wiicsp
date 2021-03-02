package com.wisea.cultivar.origin.vo;

import java.util.List;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 报告图片
 * @author wzx
 *
 */
@ApiModel("报告图片VO")
public class ReportImgListVo {
	@ApiModelProperty(value="报告图片")
	private List<ImgListVo> reportImg = Lists.newArrayList(); //报告图片

	public List<ImgListVo> getReportImg() {
		return reportImg;
	}

	public void setReportImg(List<ImgListVo> reportImg) {
		this.reportImg = reportImg;
	}

}
