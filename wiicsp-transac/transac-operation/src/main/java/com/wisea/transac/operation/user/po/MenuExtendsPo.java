package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单扩展接口列表查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月24日
 * @version 1.0
 */
@ApiModel("菜单扩展接口列表查询PO")
public class MenuExtendsPo {

	@ApiModelProperty(value = "类型")
	@Check(test = {"logic" }, logic = "'1'.equals(#isService)?#isNotEmpty(#type):true", logicMsg = "查询服务菜单的情况类型不能为空")
    private String type;

	@ApiModelProperty(value = "是否是服务菜单(0:不是1是)默认是0")
	private String isService = "0";

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsService() {
		return isService;
	}

	public void setIsService(String isService) {
		this.isService = isService;
	}
}
