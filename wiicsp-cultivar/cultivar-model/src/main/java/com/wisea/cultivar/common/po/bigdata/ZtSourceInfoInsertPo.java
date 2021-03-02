package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZtSourceInfoInsertPo
 * 2019/12/02 11:02:15
 */
public class ZtSourceInfoInsertPo {
    /**
     * 货源类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "货源类型", allowableValues = "mixLength:(,5]")
    private String sourceType;

    /**
     * 品类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类名称", allowableValues = "mixLength:(,255]")
    private String varitName;

    /**
     * 订单总数
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单总数", allowableValues = "mixLength:(,255]")
    private String ordZs;

    /**
     * 订单总量
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单总量", allowableValues = "mixLength:(,255]")
    private String ordZl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取货源类型
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置货源类型
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取品类名称
     */
    public String getVaritName() {
        return varitName;
    }

    /**
     * 设置品类名称
     */
    public void setVaritName(String varitName) {
        this.varitName = varitName == null ? null : varitName.trim();
    }

    /**
     * 获取订单总数
     */
    public String getOrdZs() {
        return ordZs;
    }

    /**
     * 设置订单总数
     */
    public void setOrdZs(String ordZs) {
        this.ordZs = ordZs == null ? null : ordZs.trim();
    }

    /**
     * 获取订单总量
     */
    public String getOrdZl() {
        return ordZl;
    }

    /**
     * 设置订单总量
     */
    public void setOrdZl(String ordZl) {
        this.ordZl = ordZl == null ? null : ordZl.trim();
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
