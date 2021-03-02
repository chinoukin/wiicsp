package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;

import java.time.OffsetDateTime;


/**
 * @ClassName: ItemMageExportVo
 * @Author: tgz
 * @Date: 2020/8/8 12:36
 */
public class ItemMageExportVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 项目名称
     */
    @ExcelField(title = "项目名称")
    private String itemName;

    /**
     * 年份
     */
    @ExcelField(title = "年份")
    private Integer itemYear;


    /**
     * 项目资金
     */
    @ExcelField(title = "项目资金(元)")
    private Double itemCapital;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelField(title = "发布时间")
    private OffsetDateTime applDate;

    /**
     * 项目状态
     */
    private String itemStateType;


    /**
     * 项目状态
     */
    @ExcelField(title = "项目状态")
    private String itemStateTypeName;

    public String getItemStateTypeName() {
        return itemStateTypeName;
    }

    public void setItemStateTypeName(String itemStateTypeName) {
        this.itemStateTypeName = itemStateTypeName;
    }

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
