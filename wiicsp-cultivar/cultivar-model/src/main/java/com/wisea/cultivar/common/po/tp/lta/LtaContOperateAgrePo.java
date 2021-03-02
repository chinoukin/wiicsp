package com.wisea.cultivar.common.po.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 长协合同确认解除同意操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月9日
 * @version 1.0
 */
@ApiModel("长协合同确认解除同意操作PO")
public class LtaContOperateAgrePo extends LtaContOperatePo{

	@ApiModelProperty("原因")
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
