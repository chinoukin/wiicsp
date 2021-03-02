package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 档案接收Po
 *
 * @author
 *
 */
@ApiModel("档案接收Po")
public class ReceiveArchPo {

	@ApiModelProperty(value="我的档案id")
    @Check(test = "required")
    private Long mineArchId;
    @ApiModelProperty(value="档案类型（扫码，推送，自建）")
    @Check(test = "required")
    private String archType;

	public Long getMineArchId() {
		return mineArchId;
	}
	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}
	public String getArchType() {
		return archType;
	}
	public void setArchType(String archType) {
		this.archType = archType;
	}
}
