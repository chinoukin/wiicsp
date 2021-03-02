package com.wisea.cultivar.common.vo.bigdata;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 大数据统计样品相关VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年11月7日
 * @version 1.0
 */
@ApiModel("大数据统计样品相关VO")
public class BigDataSampCountVo implements Serializable{

	private static final long serialVersionUID = -3188181502460640840L;

	@ApiModelProperty("采样总数")
	private int gross ;

	@ApiModelProperty("合格数")
	private int passCount;

	@ApiModelProperty("不合格数")
	private int failedCount;

	@ApiModelProperty("合格率")
	private Double passPercent;

	@ApiModelProperty("不合格率")
	private Double failedPercent;

	@ApiModelProperty("按样品地区统计列表")
	private List<SampJcCountVo> sampJcCountList = Lists.newArrayList();

	public List<SampJcCountVo> getSampJcCountList() {
		return sampJcCountList;
	}

	public void setSampJcCountList(List<SampJcCountVo> sampJcCountList) {
		this.sampJcCountList = sampJcCountList;
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

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public Double getPassPercent() {
		return passPercent;
	}

	public void setPassPercent(Double passPercent) {
		this.passPercent = passPercent;
	}

	public Double getFailedPercent() {
		return failedPercent;
	}

	public void setFailedPercent(Double failedPercent) {
		this.failedPercent = failedPercent;
	}
}
