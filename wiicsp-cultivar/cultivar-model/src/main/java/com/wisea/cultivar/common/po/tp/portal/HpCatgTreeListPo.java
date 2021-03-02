package com.wisea.cultivar.common.po.tp.portal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台管理查询树结构列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("后台管理查询树结构列表PO")
public class HpCatgTreeListPo {

	@ApiModelProperty("请输入分类名称")
	private String catgName;

	@ApiModelProperty("状态(0:启用1:停用)")
	private String enableFlag;

	@ApiModelProperty("是否默认显示(0:是1:否)")
	private String ifShow;

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getIfShow() {
		return ifShow;
	}

	public void setIfShow(String ifShow) {
		this.ifShow = ifShow;
	}
}
