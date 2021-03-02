package com.wisea.transac.operation.user.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增或者修改用户菜单初期化PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月24日
 * @version 1.0
 */
@ApiModel("新增或者修改用户时菜单初期化PO")
public class MenuExtendsUserInitPo {

	@ApiModelProperty(value = "新增的时候为空修改必须填写")
	private Long id;

	@ApiModelProperty(value = "类型")
    private String type;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
