package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * 定向推送PO
 * @author yangtao
 *
 */
@ApiModel("定向推送PO")
public class PushArchPo {

	@ApiModelProperty("我的档案id")
	@Check(test = "required")
	private Long mineArchId;
	@ApiModelProperty("会员id")
	@Check(test = "required")
	private Long membId;

	public Long getMineArchId() {
		return mineArchId;
	}
	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
}
