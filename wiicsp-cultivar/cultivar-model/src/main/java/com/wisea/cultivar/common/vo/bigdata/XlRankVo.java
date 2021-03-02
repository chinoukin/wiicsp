package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

public class XlRankVo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "公司id")
	private Long subEntpId;

	@ApiModelProperty(value = "分公司名称")
	private String subEntpName;
	/*
	 * @ApiModelProperty(value = "累计销售额") private Double ysJe;
	 */
	@ApiModelProperty(value = "排名升降（0：上升 ，1:下降 ，2:--）")
	private String rank;

	@ApiModelProperty(value = "目标完成度or累计销售额")
	private Double val;

	/**
	 * 当前进度
	 */
	@ApiModelProperty(value = "当前进度")
	private Double ysJe;

	/**
	 * 销售目标
	 */
	@ApiModelProperty(value = "销售目标")
	private Double nMbsj;

	/**
	 * 完成进度
	 */
	@ApiModelProperty(value = "完成进度")
	private Double wcd;

	@ApiModelProperty(value = "经度")
	private Double lng;


	@ApiModelProperty(value = "纬度")
	private Double lat;

	public Long getSubEntpId() {
		return subEntpId;
	}

	public void setSubEntpId(Long subEntpId) {
		this.subEntpId = subEntpId;
	}

	public String getSubEntpName() {
		return subEntpName;
	}

	public void setSubEntpName(String subEntpName) {
		this.subEntpName = subEntpName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Double getVal() {
		return val;
	}

	public void setVal(Double val) {
		this.val = val;
	}

	public Double getYsJe() {
		return ysJe;
	}

	public void setYsJe(Double ysJe) {
		this.ysJe = ysJe;
	}

	public Double getnMbsj() {
		return nMbsj;
	}

	public void setnMbsj(Double nMbsj) {
		this.nMbsj = nMbsj;
	}

	public Double getWcd() {
		return wcd;
	}

	public void setWcd(Double wcd) {
		this.wcd = wcd;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

}
