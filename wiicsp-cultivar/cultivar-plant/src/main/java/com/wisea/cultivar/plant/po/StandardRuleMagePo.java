package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("新增或修改StandardRuleMagePo")
public class StandardRuleMagePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="标准类型id")
    private Long standardTypeMageId;

    @ApiModelProperty(value="所属环节id")
    private Long linkMageId;

    @ApiModelProperty(value="ICS分类管理id")
    private Long icsClassMageId;

    @ApiModelProperty(value="中标分类管理id")
    private Long chinaStandardTypeMageId;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
