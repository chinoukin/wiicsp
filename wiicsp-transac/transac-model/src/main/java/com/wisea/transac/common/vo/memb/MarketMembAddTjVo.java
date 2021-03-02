package com.wisea.transac.common.vo.memb;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 市场会员添加统计VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月29日
 * @version 1.0
 */
@ApiModel("市场会员添加统计VO")
public class MarketMembAddTjVo {

	@ApiModelProperty("X轴时间的列表")
	private List<String> timeAxis;

	@ApiModelProperty("显示数据列表")
	private List<Integer> dataList;

	public List<String> getTimeAxis() {
		return timeAxis;
	}

	public void setTimeAxis(List<String> timeAxis) {
		this.timeAxis = timeAxis;
	}

	public List<Integer> getDataList() {
		return dataList;
	}

	public void setDataList(List<Integer> dataList) {
		this.dataList = dataList;
	}
}
