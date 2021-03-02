package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("新增或修改ItemMagePo")
public class ItemMagePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="项目名称")
    private String itemName;

    @ApiModelProperty(value="年份")
    private Integer itemYear;

    @ApiModelProperty(value="开始时间")
    private OffsetDateTime startDate;

    @ApiModelProperty(value="结束时间")
    private OffsetDateTime endDate;

    @ApiModelProperty(value="项目资金")
    private Double itemCapital;

    @ApiModelProperty(value="发布时间")
    private Double applDate;

    @ApiModelProperty(value="项目状态")
    private String itemStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemYear() {
        return itemYear;
    }

    public void setItemYear(Integer itemYear) {
        this.itemYear = itemYear;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getItemCapital() {
        return itemCapital;
    }

    public void setItemCapital(Double itemCapital) {
        this.itemCapital = itemCapital;
    }

    public Double getApplDate() {
        return applDate;
    }

    public void setApplDate(Double applDate) {
        this.applDate = applDate;
    }

    public String getItemStateType() {
        return itemStateType;
    }

    public void setItemStateType(String itemStateType) {
        this.itemStateType = itemStateType;
    }
}
