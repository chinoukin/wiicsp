package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.ItemMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询ItemMagePo")
public class ItemMagePageListPo extends PagePo<ItemMagePageListVo> {
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
    private OffsetDateTime applDate;

    @ApiModelProperty(value="项目状态")
    private String itemStateType;

    @ApiModelProperty(value="用户id")
    private Long membId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getItemStateType() {
        return itemStateType;
    }

    public void setItemStateType(String itemStateType) {
        this.itemStateType = itemStateType;
    }
}
