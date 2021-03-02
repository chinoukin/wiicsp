package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

/**
 * RkSourceInfoListVo
 * 2019/12/02 11:02:15
 */
public class RkSourceInfoListVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "货源类型")
    private String sourceType;
    @ApiModelProperty(value = "子公司名称")
    private String subEntpName;
    @ApiModelProperty(value = "品类名称")
    private String varitName;
    @ApiModelProperty(value = "总入库")
    private String zrk;
    @ApiModelProperty(value = "当前库存")
    private String dqkc;
    @ApiModelProperty(value = "备注")
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
