package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/16 8:21
 */
public class CommCountVo {

    /**
     * 销售中
     */
    @ApiModelProperty("销售中")
    private String saleCount;


    /**
     * 草稿
     */
    @ApiModelProperty("草稿")
    private String draftCount;


    /**
     * 待审核
     */
    @ApiModelProperty("待审核")
    private String pendingCount;


    /**
     * 已下架
     */
    @ApiModelProperty("已下架")
    private String removedCount;


    /**
     * 被驳回
     */
    @ApiModelProperty("被驳回")
    private String rejectedCount;

    public String getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(String saleCount) {
        this.saleCount = saleCount;
    }

    public String getDraftCount() {
        return draftCount;
    }

    public void setDraftCount(String draftCount) {
        this.draftCount = draftCount;
    }

    public String getPendingCount() {
        return pendingCount;
    }

    public void setPendingCount(String pendingCount) {
        this.pendingCount = pendingCount;
    }

    public String getRemovedCount() {
        return removedCount;
    }

    public void setRemovedCount(String removedCount) {
        this.removedCount = removedCount;
    }

    public String getRejectedCount() {
        return rejectedCount;
    }

    public void setRejectedCount(String rejectedCount) {
        this.rejectedCount = rejectedCount;
    }
}
