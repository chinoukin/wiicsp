package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 长协合同取消操作的处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月9日
 * @version 1.0
 */
@ApiModel("长协合同取消/强制解除操作的处理PO")
public class LtaContOperateDetailPo extends LtaContOperatePo{

	@ApiModelProperty("原因")
	@Check(test = "required")
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
