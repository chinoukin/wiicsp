package com.wisea.cultivar.common.po.tp.portal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 技术资料分类管理列表查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月29日
 * @version 1.0
 */
@ApiModel("技术资料分类管理列表查询PO")
public class JszlCatgMageListPo {

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String catgName;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示")
    private String ifRequ;

	public String getCatgName() {
		return catgName;
	}

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getIfRequ() {
		return ifRequ;
	}

	public void setIfRequ(String ifRequ) {
		this.ifRequ = ifRequ;
	}
}
