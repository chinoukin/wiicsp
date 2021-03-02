package com.wisea.transac.common.vo.trade;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className RefundHandleInfoVo
 * @date 2020/5/11 9:35
 * @Description
 */
@ApiModel("退款处理Vo")
public class RefundHandleInfoVo extends LongIdPo {
    @ApiModelProperty("档口ID")
    private Long stallsId;
    @ApiModelProperty(value="订单编号")
    private String ordNum;
    @ApiModelProperty(value="订单金额")
    private Double ordAmount;
    @ApiModelProperty("买家账号（采购员）")
    private String purchaseAccount;
    @ApiModelProperty("买家手机号（采购员）")
    private String purchaseRegistTel;
    @ApiModelProperty("买家姓名（采购员）")
    private String purchaseStaffName;
    @ApiModelProperty("认证主体名称")
    private String authZtName;
    @ApiModelProperty(value="退款金额")
    private Double refundAmount;
    @ApiModelProperty(value="应退账期服务费金额")
    private Double refundZqSerCost;

    public Long getStallsId() {
        return stallsId;
    }

    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public String getPurchaseAccount() {
        return purchaseAccount;
    }

    public void setPurchaseAccount(String purchaseAccount) {
        this.purchaseAccount = purchaseAccount;
    }

    public String getPurchaseRegistTel() {
        return purchaseRegistTel;
    }

    public void setPurchaseRegistTel(String purchaseRegistTel) {
        this.purchaseRegistTel = purchaseRegistTel;
    }

    public String getPurchaseStaffName() {
        return purchaseStaffName;
    }

    public void setPurchaseStaffName(String purchaseStaffName) {
        this.purchaseStaffName = purchaseStaffName;
    }

    public String getAuthZtName() {
        return authZtName;
    }

    public void setAuthZtName(String authZtName) {
        this.authZtName = authZtName;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getRefundZqSerCost() {
        return refundZqSerCost;
    }

    public void setRefundZqSerCost(Double refundZqSerCost) {
        this.refundZqSerCost = refundZqSerCost;
    }
}
