package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class StandardRuleMage extends DataLongEntity<StandardRuleMage> {
    /**
     * 标准类型id
     */
    private Long standardTypeMageId;

    /**
     * 所属环节id
     */
    private Long linkMageId;

    /**
     * ICS分类管理id
     */
    private Long icsClassMageId;

    /**
     * 中标分类管理id
     */
    private Long chinaStandardTypeMageId;

    /**
     * 标准状态
     */
    private String standardRuleType;

    /**
     * 标准编号
     */
    private String standardRuleNo;

    /**
     * 中文标题
     */
    private String cnTitle;

    /**
     * 英文标题
     */
    private String enTitle;

    /**
     * 发布日期
     */
    private OffsetDateTime pubDate;

    /**
     * 实施日期
     */
    private OffsetDateTime impleDate;

    /**
     * 发布部门
     */
    private String pubDept;

    /**
     * 标准摘要
     */
    private String standardRuleAbstract;

    /**
     * 代替标准
     */
    private String replaceStandardRule;

    /**
     * 现行标准
     */
    private String activeStandardRule;

    /**
     * 修改单
     */
    private String modifyList;

    /**
     * 浏览数
     */
    private Integer views;

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Long getStandardTypeMageId() {
        return standardTypeMageId;
    }

    public void setStandardTypeMageId(Long standardTypeMageId) {
        this.standardTypeMageId = standardTypeMageId;
    }

    public Long getLinkMageId() {
        return linkMageId;
    }

    public void setLinkMageId(Long linkMageId) {
        this.linkMageId = linkMageId;
    }

    public Long getIcsClassMageId() {
        return icsClassMageId;
    }

    public void setIcsClassMageId(Long icsClassMageId) {
        this.icsClassMageId = icsClassMageId;
    }

    public Long getChinaStandardTypeMageId() {
        return chinaStandardTypeMageId;
    }

    public void setChinaStandardTypeMageId(Long chinaStandardTypeMageId) {
        this.chinaStandardTypeMageId = chinaStandardTypeMageId;
    }

    public String getStandardRuleType() {
        return standardRuleType;
    }

    public void setStandardRuleType(String standardRuleType) {
        this.standardRuleType = standardRuleType;
    }

    public String getStandardRuleNo() {
        return standardRuleNo;
    }

    public void setStandardRuleNo(String standardRuleNo) {
        this.standardRuleNo = standardRuleNo;
    }

    public String getCnTitle() {
        return cnTitle;
    }

    public void setCnTitle(String cnTitle) {
        this.cnTitle = cnTitle;
    }

    public String getEnTitle() {
        return enTitle;
    }

    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle;
    }

    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public OffsetDateTime getImpleDate() {
        return impleDate;
    }

    public void setImpleDate(OffsetDateTime impleDate) {
        this.impleDate = impleDate;
    }

    public String getPubDept() {
        return pubDept;
    }

    public void setPubDept(String pubDept) {
        this.pubDept = pubDept;
    }

    public String getStandardRuleAbstract() {
        return standardRuleAbstract;
    }

    public void setStandardRuleAbstract(String standardRuleAbstract) {
        this.standardRuleAbstract = standardRuleAbstract;
    }

    public String getReplaceStandardRule() {
        return replaceStandardRule;
    }

    public void setReplaceStandardRule(String replaceStandardRule) {
        this.replaceStandardRule = replaceStandardRule;
    }

    public String getActiveStandardRule() {
        return activeStandardRule;
    }

    public void setActiveStandardRule(String activeStandardRule) {
        this.activeStandardRule = activeStandardRule;
    }

    public String getModifyList() {
        return modifyList;
    }

    public void setModifyList(String modifyList) {
        this.modifyList = modifyList;
    }
}
