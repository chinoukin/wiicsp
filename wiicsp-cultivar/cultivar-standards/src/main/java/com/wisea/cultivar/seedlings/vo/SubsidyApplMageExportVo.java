package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;


/**
 * @ClassName: SubsidyApplMageExportVo
 * @Author: tgz
 * @Date: 2020/8/8 12:36
 */
public class SubsidyApplMageExportVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 申请人名称
     */
    @ExcelField(title =  "申请人")
    private String entpPersonalName;

    /**
     * 申请金额
     */
    @ExcelField(title =  "申请金额(元)")
    private Double applCapital;

    /**
     * 申报面积
     */
    @ExcelField(title =  "申报面积(亩)")
    private Double applMeasureArea;


    /**
     * 基地地区
     */
    @ExcelField(title = "基地地址")
    private String baseArea;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ExcelField(title =  "申请时间")
    private OffsetDateTime applDate;

    /**
     * 补贴申请状态值
     */
    @ExcelField(title = "状态")
    private String subsidyApplStateTypeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntpPersonalName() {
        return entpPersonalName;
    }

    public void setEntpPersonalName(String entpPersonalName) {
        this.entpPersonalName = entpPersonalName;
    }

    public Double getApplCapital() {
        return applCapital;
    }

    public void setApplCapital(Double applCapital) {
        this.applCapital = applCapital;
    }

    public Double getApplMeasureArea() {
        return applMeasureArea;
    }

    public void setApplMeasureArea(Double applMeasureArea) {
        this.applMeasureArea = applMeasureArea;
    }

    public String getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(String baseArea) {
        this.baseArea = baseArea;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getSubsidyApplStateTypeName() {
        return subsidyApplStateTypeName;
    }

    public void setSubsidyApplStateTypeName(String subsidyApplStateTypeName) {
        this.subsidyApplStateTypeName = subsidyApplStateTypeName;
    }
}
