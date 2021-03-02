package com.wisea.cultivar.common.po.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退款详情vo
 *
 * @author yangtao
 *
 * @version 1.0
 */
@ApiModel("数据ID Po")
public class RefundInfoPo {

    @ApiModelProperty("订单ID")
    private Long id;

    @ApiModelProperty("退款信息ID")
    private Long refundId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
}
