package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * standard_rule_mage 表实体
 * 标准规范管理
 * 2020/07/24 11:21:45
 */
public class StandardRuleMage extends DataLongEntity<StandardRuleMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 标准类型id
     */
    private Long standardTypeMageId;
    /**
     * 标准类型id名称
     */
    private String standardTypeMageIdName;

    /**
     * 所属环节id
     */
    private Long linkMageId;

    /**
     * ICS分类管理id
     */
    private Long icsClassMageId;
    /**
     * ICS分类管理id名称
     */
    private String icsClassMageIdName;

    /**
     * 中标分类管理id
     */
    private Long chinaStandardTypeMageId;
    /**
     * 中标分类管理id名称
     */
    private String chinaStandardTypeMageIdName;

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
     * 备注
     */
    private String remarks;

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

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取标准类型id
     */
    public Long getStandardTypeMageId() {
        return standardTypeMageId;
    }

    /**
     * 设置标准类型id
     */
    public void setStandardTypeMageId(Long standardTypeMageId) {
        this.standardTypeMageId = standardTypeMageId;
    }

    /**
     * 获取所属环节id
     */
    public Long getLinkMageId() {
        return linkMageId;
    }

    /**
     * 设置所属环节id
     */
    public void setLinkMageId(Long linkMageId) {
        this.linkMageId = linkMageId;
    }

    /**
     * 获取ICS分类管理id
     */
    public Long getIcsClassMageId() {
        return icsClassMageId;
    }

    /**
     * 设置ICS分类管理id
     */
    public void setIcsClassMageId(Long icsClassMageId) {
        this.icsClassMageId = icsClassMageId;
    }

    /**
     * 获取中标分类管理id
     */
    public Long getChinaStandardTypeMageId() {
        return chinaStandardTypeMageId;
    }

    /**
     * 设置中标分类管理id
     */
    public void setChinaStandardTypeMageId(Long chinaStandardTypeMageId) {
        this.chinaStandardTypeMageId = chinaStandardTypeMageId;
    }

    /**
     * 获取标准状态
     */
    public String getStandardRuleType() {
        return standardRuleType;
    }

    /**
     * 设置标准状态
     */
    public void setStandardRuleType(String standardRuleType) {
        this.standardRuleType = standardRuleType == null ? null : standardRuleType.trim();
    }

    /**
     * 获取标准编号
     */
    public String getStandardRuleNo() {
        return standardRuleNo;
    }

    /**
     * 设置标准编号
     */
    public void setStandardRuleNo(String standardRuleNo) {
        this.standardRuleNo = standardRuleNo == null ? null : standardRuleNo.trim();
    }

    /**
     * 获取中文标题
     */
    public String getCnTitle() {
        return cnTitle;
    }

    /**
     * 设置中文标题
     */
    public void setCnTitle(String cnTitle) {
        this.cnTitle = cnTitle == null ? null : cnTitle.trim();
    }

    /**
     * 获取英文标题
     */
    public String getEnTitle() {
        return enTitle;
    }

    /**
     * 设置英文标题
     */
    public void setEnTitle(String enTitle) {
        this.enTitle = enTitle == null ? null : enTitle.trim();
    }

    /**
     * 获取发布日期
     */
    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    /**
     * 设置发布日期
     */
    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 获取实施日期
     */
    public OffsetDateTime getImpleDate() {
        return impleDate;
    }

    /**
     * 设置实施日期
     */
    public void setImpleDate(OffsetDateTime impleDate) {
        this.impleDate = impleDate;
    }

    /**
     * 获取发布部门
     */
    public String getPubDept() {
        return pubDept;
    }

    /**
     * 设置发布部门
     */
    public void setPubDept(String pubDept) {
        this.pubDept = pubDept == null ? null : pubDept.trim();
    }

    /**
     * 获取标准摘要
     */
    public String getStandardRuleAbstract() {
        return standardRuleAbstract;
    }

    /**
     * 设置标准摘要
     */
    public void setStandardRuleAbstract(String standardRuleAbstract) {
        this.standardRuleAbstract = standardRuleAbstract == null ? null : standardRuleAbstract.trim();
    }

    /**
     * 获取代替标准
     */
    public String getReplaceStandardRule() {
        return replaceStandardRule;
    }

    /**
     * 设置代替标准
     */
    public void setReplaceStandardRule(String replaceStandardRule) {
        this.replaceStandardRule = replaceStandardRule == null ? null : replaceStandardRule.trim();
    }

    /**
     * 获取现行标准
     */
    public String getActiveStandardRule() {
        return activeStandardRule;
    }

    /**
     * 设置现行标准
     */
    public void setActiveStandardRule(String activeStandardRule) {
        this.activeStandardRule = activeStandardRule == null ? null : activeStandardRule.trim();
    }

    /**
     * 获取修改单
     */
    public String getModifyList() {
        return modifyList;
    }

    /**
     * 设置修改单
     */
    public void setModifyList(String modifyList) {
        this.modifyList = modifyList == null ? null : modifyList.trim();
    }

    public String getStandardTypeMageIdName() {
        return standardTypeMageIdName;
    }

    public void setStandardTypeMageIdName(String standardTypeMageIdName) {
        this.standardTypeMageIdName = standardTypeMageIdName;
    }

    public String getIcsClassMageIdName() {
        return icsClassMageIdName;
    }

    public void setIcsClassMageIdName(String icsClassMageIdName) {
        this.icsClassMageIdName = icsClassMageIdName;
    }

    public String getChinaStandardTypeMageIdName() {
        return chinaStandardTypeMageIdName;
    }

    public void setChinaStandardTypeMageIdName(String chinaStandardTypeMageIdName) {
        this.chinaStandardTypeMageIdName = chinaStandardTypeMageIdName;
    }
}
