package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * RkSourceInfoUpdatePo
 * 2019/12/02 11:02:15
 */
public class RkSourceInfoUpdatePo {
    @ApiModelProperty(value = "id，修改时非空", required = true)
    private Long id;
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "货源类型", allowableValues = "mixLength:(,5]")
    private String sourceType;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "子公司名称", allowableValues = "mixLength:(,255]")
    private String subEntpName;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类名称", allowableValues = "mixLength:(,255]")
    private String varitName;
    @Check(test = { "maxLength"}, mixLength = 255)
    @ApiModelProperty(value = "总入库", allowableValues = "mixLength:(,255]")
    private String zrk;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "当前库存", allowableValues = "mixLength:(,255]")
    private String dqkc;
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

    public String getSubEntpName() {
        return subEntpName;
    }

    public void setSubEntpName(String subEntpName) {
        this.subEntpName = subEntpName;
    }

    public String getVaritName() {
        return varitName;
    }

    public void setVaritName(String varitName) {
        this.varitName = varitName;
    }

    public String getZrk() {
        return zrk;
    }

    public void setZrk(String zrk) {
        this.zrk = zrk;
    }

    public String getDqkc() {
        return dqkc;
    }

    public void setDqkc(String dqkc) {
        this.dqkc = dqkc;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
