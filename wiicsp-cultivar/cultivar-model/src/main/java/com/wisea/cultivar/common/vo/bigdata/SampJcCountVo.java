package com.wisea.cultivar.common.vo.bigdata;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 按照检测地区统计样品Vo
 *
 * @author wangh(wisea)
 *
 * @date 2019年10月12日
 * @version 1.0
 */
@ApiModel("按照检测地区统计样品Vo")
public class SampJcCountVo implements Serializable{

	/**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -7770455460372453010L;
	@ApiModelProperty("县名称")
	private String sampCounty;
	@ApiModelProperty("样品地区编码")
	private String sampAreaCode;
	@ApiModelProperty("采样总数")
	private int gross ;
	@ApiModelProperty("合格数")
	private int passCount;
	@ApiModelProperty("合格率")
	private Double passPercent;


	public String getSampCounty() {
		return sampCounty;
	}
	public void setSampCounty(String sampCounty) {
		this.sampCounty = sampCounty;
	}
	public String getSampAreaCode() {
		return sampAreaCode;
	}
	public void setSampAreaCode(String sampAreaCode) {
		this.sampAreaCode = sampAreaCode;
	}
	public int getGross() {
		return gross;
	}
	public void setGross(int gross) {
		this.gross = gross;
	}
	public int getPassCount() {
		return passCount;
	}
	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}
	public Double getPassPercent() {
		return passPercent;
	}
	public void setPassPercent(Double passPercent) {
		this.passPercent = passPercent;
	}
}
