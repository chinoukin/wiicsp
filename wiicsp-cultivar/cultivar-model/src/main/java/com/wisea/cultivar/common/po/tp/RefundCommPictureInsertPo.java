package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * RefundCommPictureInsertPo
 * 2018/09/30 09:46:17
 */
public class RefundCommPictureInsertPo {
    /**
     * 退货申请id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "退货申请id")
    private Long refundApplId;

    /**
     * 图片url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取退货申请id
     */
    public Long getRefundApplId() {
        return refundApplId;
    }

    /**
     * 设置退货申请id
     */
    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
