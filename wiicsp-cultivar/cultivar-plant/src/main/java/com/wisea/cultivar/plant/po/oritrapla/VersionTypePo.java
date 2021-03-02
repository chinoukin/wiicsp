package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取最新版本的版本类型的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月27日
 * @version 1.0
 */
@ApiModel("获取最新版本的版本类型的PO")
public class VersionTypePo {

	@ApiModelProperty(value="版本类型(version_type[0:Android1:IOS])",required=true)
	@Check(test={"liveable"}, liveable = {"0", "1"}, liveableMsg = "版本类型只能为0、1")
	private String versionType;

	/**
	 * @return the versionType
	 */
	public String getVersionType() {
		return versionType;
	}

	/**
	 * @param versionType the versionType to set
	 */
	public void setVersionType(String versionType) {
		this.versionType = versionType;
	}
}
