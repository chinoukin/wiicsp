package com.wisea.cultivar.common.vo.tp.retro;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class RetroLabelVo {
    @ApiModelProperty("批次编号")
    private String traceBatchNumCode;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("生产企业")
    private String compName;
    @ApiModelProperty("联系方式")
    private String compTel;
    @ApiModelProperty("联系地址")
    private String compAddress;
    @ApiModelProperty("产地")
    private String placeOrigin;
    @ApiModelProperty("申请数量")
    private Integer applCount;
    @ApiModelProperty("属性列表")
    private List<RetrospFlagApplAttributeVo> attributes;

    public String getTraceBatchNumCode() {
        return traceBatchNumCode;
    }

    public void setTraceBatchNumCode(String traceBatchNumCode) {
        this.traceBatchNumCode = traceBatchNumCode;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompTel() {
        return compTel;
    }

    public void setCompTel(String compTel) {
        this.compTel = compTel;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public Integer getApplCount() {
        return applCount;
    }

    public void setApplCount(Integer applCount) {
        this.applCount = applCount;
    }

    public List<RetrospFlagApplAttributeVo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<RetrospFlagApplAttributeVo> attributes) {
        this.attributes = attributes;
    }
}
