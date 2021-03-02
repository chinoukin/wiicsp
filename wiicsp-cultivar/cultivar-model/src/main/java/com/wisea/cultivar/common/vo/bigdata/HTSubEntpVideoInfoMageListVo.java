package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class HTSubEntpVideoInfoMageListVo {

    /**
     * 分公司名称
     */
    @ApiModelProperty(value = "分公司名称")
    private String subEntpName;

    @ApiModelProperty(value = "视频列表")
	private List<SubEntpVideoInfoMageListVo> subEntpVideoInfoMageListVo;

	public String getSubEntpName() {
		return subEntpName;
	}

	public void setSubEntpName(String subEntpName) {
		this.subEntpName = subEntpName;
	}

	public List<SubEntpVideoInfoMageListVo> getSubEntpVideoInfoMageListVo() {
		return subEntpVideoInfoMageListVo;
	}

	public void setSubEntpVideoInfoMageListVo(List<SubEntpVideoInfoMageListVo> subEntpVideoInfoMageListVo) {
		this.subEntpVideoInfoMageListVo = subEntpVideoInfoMageListVo;
	}


}
