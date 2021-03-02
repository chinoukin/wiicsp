package com.wisea.cultivar.origin.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.origin.vo.MembListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *企业信息列表PO
 * @author wzx
 *
 */
@ApiModel("企业信息列表PO")
public class MembListPo extends PagePo<MembListVo> {

	private static final long serialVersionUID = -7854233116992009732L;
	@ApiModelProperty(value = "企业名称")
	private String membName;

	public String getMembName() {
		return membName;
	}

	public void setMembName(String membName) {
		this.membName = membName;
	}
}
