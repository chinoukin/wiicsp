package com.wisea.transac.common.vo.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrdCancelReasonMageListVo
 * 2018/10/10 14:42:38
 */
public class OrdCancelReasonMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String num;

    /**
     * 订单取消原因
     */
    @ApiModelProperty(value = "订单取消原因")
    private String ordCancelReason;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取编号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 获取订单取消原因
     */
    public String getOrdCancelReason() {
        return ordCancelReason;
    }

    /**
     * 设置订单取消原因
     */
    public void setOrdCancelReason(String ordCancelReason) {
        this.ordCancelReason = ordCancelReason == null ? null : ordCancelReason.trim();
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
