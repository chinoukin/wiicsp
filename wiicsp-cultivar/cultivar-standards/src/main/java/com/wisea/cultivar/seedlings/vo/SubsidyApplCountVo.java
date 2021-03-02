package com.wisea.cultivar.seedlings.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName: SubsidyApplCount
 * @Author: tgz
 * @Date: 2020/9/2 17:34
 */
public class SubsidyApplCountVo {

    @ApiModelProperty(value = "申请总人数")
    private Integer peopleNum;

    @ApiModelProperty(value = "申请总金额")
    private Double applCapitalNum;

    @ApiModelProperty(value = "申报总面积")
    private Double applmeasureAreaNum;

    @ApiModelProperty(value = "项目总数")
    private Integer itemNum;

    private List<ItemMageListVo> itemMageListVos;

    @ApiModelProperty(value = "项目补助总金额")
    private List<ApplMessageVo> applMessageVos;

    @ApiModelProperty(value = "申请补助用户占比")
    private List<ApplMessageVo> applMessageVoList;

    public List<ApplMessageVo> getApplMessageVos() {
        return applMessageVos;
    }

    public void setApplMessageVos(List<ApplMessageVo> applMessageVos) {
        this.applMessageVos = applMessageVos;
    }

    public List<ApplMessageVo> getApplMessageVoList() {
        return applMessageVoList;
    }

    public void setApplMessageVoList(List<ApplMessageVo> applMessageVoList) {
        this.applMessageVoList = applMessageVoList;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public void setPeopleNum(Integer peopleNum) {
        this.peopleNum = peopleNum;
    }

    public Double getApplCapitalNum() {
        return applCapitalNum;
    }

    public void setApplCapitalNum(Double applCapitalNum) {
        this.applCapitalNum = applCapitalNum;
    }

    public Double getApplmeasureAreaNum() {
        return applmeasureAreaNum;
    }

    public void setApplmeasureAreaNum(Double applmeasureAreaNum) {
        this.applmeasureAreaNum = applmeasureAreaNum;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public List<ItemMageListVo> getItemMageListVos() {
        return itemMageListVos;
    }

    public void setItemMageListVos(List<ItemMageListVo> itemMageListVos) {
        this.itemMageListVos = itemMageListVos;
    }
}
