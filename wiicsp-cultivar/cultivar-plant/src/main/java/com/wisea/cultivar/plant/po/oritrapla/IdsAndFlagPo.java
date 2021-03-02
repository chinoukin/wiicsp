package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auth： yangtao
 * remark:   数据IDs Po
 */
@ApiModel("数据ID和标识 Po")
public class IdsAndFlagPo {

    @ApiModelProperty("数据IDs")
    @Check(test = "required")
    private String ids;
    @ApiModelProperty("请求标识，0禁用，1启用，2恢复")
    @Check(test = "required")
    private String flag;
    private String mineArchStatus;//我的档案状态
    private String delFlag;//删除标记

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getMineArchStatus() {
		return mineArchStatus;
	}

	public void setMineArchStatus(String mineArchStatus) {
		this.mineArchStatus = mineArchStatus;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
