package com.wisea.cultivar.plant.po.oritrapla;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.MassifMageInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("地块管理列表查询po")
public class MassifMageInfoListPo extends PagePo<MassifMageInfoVo> {

	/**
	 *
	 */
	private static final long serialVersionUID = 6728767946040418604L;
	@ApiModelProperty("查询条件地块名称")
	private String massifName;//地块名称

	@ApiModelProperty(value="会员Id",hidden=true)
	private List<String> membId = Lists.newArrayList();
	public String getMassifName() {
		return massifName;
	}

	public void setMassifName(String massifName) {
		this.massifName = massifName;
	}

	public List<String> getMembId() {
		return membId;
	}

	public void setMembId(List<String> membId) {
		this.membId = membId;
	}

}
