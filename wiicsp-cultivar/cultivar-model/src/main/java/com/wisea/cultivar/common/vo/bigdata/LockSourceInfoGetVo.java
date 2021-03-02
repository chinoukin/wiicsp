package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModelProperty;

/**
 * LockSourceInfoGetVo
 * 2019/12/02 11:02:14
 */
public class LockSourceInfoGetVo {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "货源类型")
    private String sourceType;
    @ApiModelProperty(value = "产地地址")
    private String placeOriginAddress;
    @ApiModelProperty(value = "品类名称")
    private String varitName;
    @ApiModelProperty(value = "合约数量")
    private String hysl;
    @ApiModelProperty(value = "预计货源")
    private String yjhy;
    @ApiModelProperty(value = "剩余有效货源")
    private String syyxhy;
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
