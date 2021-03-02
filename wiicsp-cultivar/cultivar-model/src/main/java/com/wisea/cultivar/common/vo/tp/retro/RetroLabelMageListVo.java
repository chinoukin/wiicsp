package com.wisea.cultivar.common.vo.tp.retro;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * RetroLabelMageListVo
 * 2018/10/11 09:24:35
 */
public class RetroLabelMageListVo {
    @ApiModelProperty(value = "追溯标签申请ID")
    private Long id;
    @ApiModelProperty("商品编号")
    private String commNum;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品品牌")
    private String brandName;
    @ApiModelProperty("企业名称")
    private String compName;
    @ApiModelProperty(value = "申请数量")
    private Integer applCount;
    @ApiModelProperty(value = "申请日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty(value = "追溯标签类型")
    private String retroLabelType;
    @ApiModelProperty(value = "追溯标签状态")
    private String retroLabelState;
    @ApiModelProperty("标签文件路径")
    private String fileUrl;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public Integer getApplCount() {
        return applCount;
    }

    public void setApplCount(Integer applCount) {
        this.applCount = applCount;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public String getRetroLabelState() {
        return retroLabelState;
    }

    public void setRetroLabelState(String retroLabelState) {
        this.retroLabelState = retroLabelState;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
