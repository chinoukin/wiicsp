package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改退款申请状态PO
 */
@ApiModel("修改退款申请状态PO")
public class UpdataRefundApplState {
    @ApiModelProperty("退款申请ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("卖家处理备注")
    private String sellerHandleRemarks;
    @ApiModelProperty("退款申请状态(1 同意、2 拒绝 )")
    @Check(test = {"required", "liveable"}, liveable = {"1", "2"}, liveableMsg = "退款申请状态只能为1或2")
    private String refundApplStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerHandleRemarks() {
        return sellerHandleRemarks;
    }

    public void setSellerHandleRemarks(String sellerHandleRemarks) {
        this.sellerHandleRemarks = sellerHandleRemarks;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }
}
