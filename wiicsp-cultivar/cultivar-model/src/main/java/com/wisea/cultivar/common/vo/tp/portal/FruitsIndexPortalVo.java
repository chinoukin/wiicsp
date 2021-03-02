package com.wisea.cultivar.common.vo.tp.portal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页显示水果指数图标VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("首页显示水果指数图标VO")
public class FruitsIndexPortalVo implements Serializable{

	private static final long serialVersionUID = 1058845224228520500L;

	@ApiModelProperty("水果名称列表")
	private List<String> fruitsNames;

	@ApiModelProperty("时间列表")
	private List<String> timeList;

	@ApiModelProperty("数据列表")
	private Map<String,Object> dataList;

	public List<String> getFruitsNames() {
		return fruitsNames;
	}

	public void setFruitsNames(List<String> fruitsNames) {
		this.fruitsNames = fruitsNames;
	}

	public Map<String, Object> getDataList() {
		return dataList;
	}

	public void setDataList(Map<String, Object> dataList) {
		this.dataList = dataList;
	}

	public List<String> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<String> timeList) {
		this.timeList = timeList;
	}
}
