package com.wisea.cultivar.seedlings.vo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;


/**
 * @ClassName: ItemSisyAppExportVo
 * @Author: tgz
 * @Date: 2020/8/12 13:57
 */
public class ItemSisyAppExportVo {
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
     * 申请人数
     */
    @ExcelField(title = "申请人数")
    private Double peopleNum;

    /**
     * 申请金额
     */
    @ExcelField(title = "申请金额")
    private Double applCapital;


    /**
     * 项目状态
     */
    private String itemStateType;

    /**
     * 项目状态
     */
    @ExcelField(title = "项目状态")
    private String itemStateTypeName;

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

    public Double getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Double peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Double getApplCapital() {
        return applCapital;
    }

    public void setApplCapital(Double applCapital) {
        this.applCapital = applCapital;
    }

    public String getItemStateType() {
        return itemStateType;
    }

    public void setItemStateType(String itemStateType) {
        this.itemStateType = itemStateType;
    }

    public String getItemStateTypeName() {
        return itemStateTypeName;
    }

    public void setItemStateTypeName(String itemStateTypeName) {
        this.itemStateTypeName = itemStateTypeName;
    }
}
