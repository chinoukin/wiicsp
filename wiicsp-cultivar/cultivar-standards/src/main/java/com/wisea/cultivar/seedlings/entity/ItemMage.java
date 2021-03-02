package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * item_mage 表实体
 * 项目管理
 * 2020/08/06 14:19:24
 */
public class ItemMage extends DataLongEntity<ItemMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 年份
     */
    private Integer itemYear;

    /**
     * 开始时间
     */
    private OffsetDateTime startDate;

    /**
     * 结束时间
     */
    private OffsetDateTime endDate;

    /**
     * 项目资金
     */
    private Double itemCapital;

    /**
     * 发布时间
     */
    private OffsetDateTime applDate;

    /**
     * 项目状态
     */
    private String itemStateType;

    /**
     * 申请指南
     */
    private String applGuide;

    /**
     *
     * @mbg.generated
     */
    public ItemMage() {
        super();
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
