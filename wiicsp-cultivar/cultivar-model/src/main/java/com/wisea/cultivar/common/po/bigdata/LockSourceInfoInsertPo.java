package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * LockSourceInfoInsertPo
 * 2019/12/02 11:02:14
 */
public class LockSourceInfoInsertPo {
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "货源类型", allowableValues = "mixLength:(,5]")
    private String sourceType;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "产地地址", allowableValues = "mixLength:(,255]")
    private String placeOriginAddress;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类名称", allowableValues = "mixLength:(,255]")
    private String varitName;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "合约数量", allowableValues = "mixLength:(,255]")
    private String hysl;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "预计货源", allowableValues = "mixLength:(,255]")
    private String yjhy;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "剩余有效货源", allowableValues = "mixLength:(,255]")
    private String syyxhy;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getPlaceOriginAddress() {
        return placeOriginAddress;
    }

    public void setPlaceOriginAddress(String placeOriginAddress) {
        this.placeOriginAddress = placeOriginAddress;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getHysl() {
        return hysl;
    }

    public void setHysl(String hysl) {
        this.hysl = hysl;
    }

    public String getYjhy() {
        return yjhy;
    }

    public void setYjhy(String yjhy) {
        this.yjhy = yjhy;
    }

    public String getSyyxhy() {
        return syyxhy;
    }

    public void setSyyxhy(String syyxhy) {
        this.syyxhy = syyxhy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
