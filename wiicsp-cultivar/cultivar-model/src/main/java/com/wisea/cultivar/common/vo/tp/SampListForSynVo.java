package com.wisea.cultivar.common.vo.tp;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModelProperty;

public class SampListForSynVo implements Serializable{

	private static final long serialVersionUID = -7250440028867564147L;

	@ApiModelProperty(value = "检测样品")
	private List<SampInfoListForSynVo> listVo = Lists.newArrayList(); // 样品信息

	@ApiModelProperty(value = "未检测变为已检测，检测报告")
	private List<SampInfoListForSynVo> yjcListVo = Lists.newArrayList(); // 样品信息

	public List<SampInfoListForSynVo> getListVo() {
		return listVo;
	}

	public void setListVo(List<SampInfoListForSynVo> listVo) {
		this.listVo = listVo;
	}

	public List<SampInfoListForSynVo> getYjcListVo() {
		return yjcListVo;
	}

	public void setYjcListVo(List<SampInfoListForSynVo> yjcListVo) {
		this.yjcListVo = yjcListVo;
	}

}
