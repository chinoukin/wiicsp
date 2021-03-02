package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * ItemMageGetVo
 * 2020/08/06 14:19:24
 */
public class ItemMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String itemName;

    /**
     * 年份
     */
    @ApiModelProperty(value = "年份")
    private Integer itemYear;

    /**
     * 开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
    private OffsetDateTime startDate;

    @ApiModelProperty("开始时间")
    private String startDateStr;

    public void setStartDateStrStr(String startDateStr) {
        this.startDateStr = startDateStr;
    }

    public String getStartDateStrStr() {
        if(null != this.startDate){
            this.startDateStr = ConverterUtil.offsetDateTimeFormat(this.startDate, ConverterUtil.FORMATE_DATE_CHINA);
        }
        return startDateStr;
    }
    /**
     * 结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "结束时间")
    private OffsetDateTime endDate;

    @ApiModelProperty("结束时间")
    private String endDateStr;

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getEndDateStr() {
        if (null != this.endDate) {
            this.endDateStr = ConverterUtil.offsetDateTimeFormat(this.endDate, ConverterUtil.FORMATE_DATE_CHINA);
        }
        return endDateStr;
    }

    /**
     * 项目资金
     */
    @ApiModelProperty(value = "项目资金")
    private Double itemCapital;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime applDate;

    /**
     * 项目状态
     */
    @ApiModelProperty(value = "项目状态")
    private String itemStateType;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 申请指南
     */
    @ApiModelProperty(value = "申请指南")
    private String applGuide;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取项目名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置项目名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 获取年份
     */
    public Integer getItemYear() {
        return itemYear;
    }

    /**
     * 设置年份
     */
    public void setItemYear(Integer itemYear) {
        this.itemYear = itemYear;
    }

    /**
     * 获取开始时间
     */
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    /**
     * 设置开始时间
     */
    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束时间
     */
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    /**
     * 设置结束时间
     */
    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取项目资金
     */
    public Double getItemCapital() {
        return itemCapital;
    }

    /**
     * 设置项目资金
     */
    public void setItemCapital(Double itemCapital) {
        this.itemCapital = itemCapital;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取项目状态
     */
    public String getItemStateType() {
        return itemStateType;
    }

    /**
     * 设置项目状态
     */
    public void setItemStateType(String itemStateType) {
        this.itemStateType = itemStateType == null ? null : itemStateType.trim();
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 获取申请指南
     */
    public String getApplGuide() {
        return applGuide;
    }

    /**
     * 设置申请指南
     */
    public void setApplGuide(String applGuide) {
        this.applGuide = applGuide == null ? null : applGuide.trim();
    }
}
