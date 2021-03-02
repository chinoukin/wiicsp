package com.wisea.transac.common.po.memb;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 报备状态修改PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
@ApiModel("报备状态修改PO")
public class RpStateUpdPo {

	@ApiModelProperty(value="ID列表")
	@Check(test = "required")
	private List<Long> ids;
	@ApiModelProperty("报备状态(rp_state_type 1:报备中2:已报备)")
	  @Check(test = {"required","liveable"}, liveable = {"1", "2"}, liveableMsg = "报备状态只能为1,2")
	private String rpStateType;

	public List<Long> getIds() {
		return ids;
	}
	public void setIds(List<Long> ids) {
		this.ids = ids;
	}
	public String getRpStateType() {
		return rpStateType;
	}
	public void setRpStateType(String rpStateType) {
		this.rpStateType = rpStateType;
	}
}
