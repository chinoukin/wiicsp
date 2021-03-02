package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台待处理事务Vo
 */
@ApiModel("后台待处理事务Vo")
public class AdminToBeProcessedVo {
    @ApiModelProperty("企业认证审核")
    private Integer entpAuthExam;
    @ApiModelProperty("给买家开发票")
    private Integer notInvoiced;
    @ApiModelProperty("待审核结算单")
    private Integer pendingReviewCount;
    @ApiModelProperty("待支付结算单")
    private Integer pendingPayCount;
    @ApiModelProperty("退货订单待收货")
    private Integer pendingReceipt;

    public Integer getEntpAuthExam() {
        return entpAuthExam;
    }

    public void setEntpAuthExam(Integer entpAuthExam) {
        this.entpAuthExam = entpAuthExam;
    }

    public Integer getNotInvoiced() {
        return notInvoiced;
    }

    public void setNotInvoiced(Integer notInvoiced) {
        this.notInvoiced = notInvoiced;
    }

    public Integer getPendingReviewCount() {
        return pendingReviewCount;
    }

    public void setPendingReviewCount(Integer pendingReviewCount) {
        this.pendingReviewCount = pendingReviewCount;
    }

    public Integer getPendingPayCount() {
        return pendingPayCount;
    }

    public void setPendingPayCount(Integer pendingPayCount) {
        this.pendingPayCount = pendingPayCount;
    }

    public Integer getPendingReceipt() {
        return pendingReceipt;
    }

    public void setPendingReceipt(Integer pendingReceipt) {
        this.pendingReceipt = pendingReceipt;
    }
}
