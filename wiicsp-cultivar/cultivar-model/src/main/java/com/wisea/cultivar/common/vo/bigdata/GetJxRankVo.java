package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

public class GetJxRankVo {

	@ApiModelProperty(value = "公司id")
	private Long subEntpId;

	@ApiModelProperty(value = "物料分类")
	private String categoryName;

	@ApiModelProperty(value = "销量")
	private Double ysJe;

	@ApiModelProperty(value = "排名")
	private String rank;

	public Long getSubEntpId() {
		return subEntpId;
	}

	public void setSubEntpId(Long subEntpId) {
		this.subEntpId = subEntpId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getYsJe() {
		return ysJe;
	}

	public void setYsJe(Double ysJe) {
		this.ysJe = ysJe;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}
