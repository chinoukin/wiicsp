package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员标签列表查询的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月12日
 * @version 1.0
 */
@ApiModel("会员标签列表查询的PO")
public class MembLabelListListPo {

    @ApiModelProperty(value = "标签类别(0:企业证书1:认证企业2:检测证书3:品鉴证书)")
    private String labelCatgType;
    @ApiModelProperty(value = "0:查询所有标签类别1:查询认证企业以外的标签类别(默认查询所有)")
    private String useFlag = "0";
    public String getLabelCatgType() {
        return labelCatgType;
    }

    public void setLabelCatgType(String labelCatgType) {
        this.labelCatgType = labelCatgType == null ? null : labelCatgType.trim();
    }

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
}
