package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZtSourceInfoUpdatePo
 * 2019/12/02 11:02:15
 */
public class ZtSourceInfoUpdatePo {
    @ApiModelProperty(value = "id，修改时非空", required = true)
    private Long id;
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "货源类型", allowableValues = "mixLength:(,5]")
    private String sourceType;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类名称", allowableValues = "mixLength:(,255]")
    private String varitName;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单总数", allowableValues = "mixLength:(,255]")
    private String ordZs;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单总量", allowableValues = "mixLength:(,255]")
    private String ordZl;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getOrdZs() {
        return ordZs;
    }

    public void setOrdZs(String ordZs) {
        this.ordZs = ordZs;
    }

    public String getOrdZl() {
        return ordZl;
    }

    public void setOrdZl(String ordZl) {
        this.ordZl = ordZl;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
