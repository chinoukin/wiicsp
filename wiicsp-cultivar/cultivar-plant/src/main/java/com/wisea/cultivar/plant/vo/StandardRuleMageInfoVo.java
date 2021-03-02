package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("StandardRuleMage详细信息Vo")
public class StandardRuleMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="标准类型id")
    private Long standardTypeMageId;
    @ApiModelProperty(value="环节名称")
    private String linkName;
    @ApiModelProperty(value="ICS分类管理id")
    private String icsClassName;
    @ApiModelProperty(value="中标分类管理id")
    private String standardTypeName;
    @ApiModelProperty(value="标准状态")
    private String standardRuleType;
    @ApiModelProperty(value="标准编号")
    private String standardRuleNo;
    @ApiModelProperty(value="中文标题")
    private String cnTitle;
    @ApiModelProperty(value="英文标题")
    private String enTitle;
    @ApiModelProperty(value="发布日期")
    private OffsetDateTime pubDate;
    @ApiModelProperty(value="实施日期")
    private OffsetDateTime impleDate;
    @ApiModelProperty(value="发布部门")
    private String pubDept;
    @ApiModelProperty(value="标准摘要")
    private String standardRuleAbstract;
    @ApiModelProperty(value="代替标准")
    private String replaceStandardRule;
    @ApiModelProperty(value="现行标准")
    private String activeStandardRule;
    @ApiModelProperty(value="修改单")
    private String modifyList;
    @ApiModelProperty(value="收藏状态 如果有值说明收藏了  他的值就是收藏表的id")
    private Long membCollectionId;
    @ApiModelProperty(value="收藏状态  0表示有效  1表示失效")
    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getMembCollectionId() {
        return membCollectionId;
    }

    public void setMembCollectionId(Long membCollectionId) {
        this.membCollectionId = membCollectionId;
    }

    @ApiModelProperty(value="浏览数")
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

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getIcsClassName() {
        return icsClassName;
    }

    public void setIcsClassName(String icsClassName) {
        this.icsClassName = icsClassName;
    }

    public String getStandardTypeName() {
        return standardTypeName;
    }

    public void setStandardTypeName(String standardTypeName) {
        this.standardTypeName = standardTypeName;
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
