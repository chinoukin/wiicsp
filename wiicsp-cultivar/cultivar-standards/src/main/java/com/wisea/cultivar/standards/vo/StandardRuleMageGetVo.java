package com.wisea.cultivar.standards.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * StandardRuleMageGetVo
 * 2020/07/24 11:21:45
 */
public class StandardRuleMageGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 标准类型id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "标准类型id")
    private Long standardTypeMageId;

    /**
     * 所属环节id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "所属环节id")
    private Long linkMageId;

    /**
     * ICS分类管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "ICS分类管理id")
    private Long icsClassMageId;

    /**
     * 中标分类管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "中标分类管理id")
    private Long chinaStandardTypeMageId;

    /**
     * 标准状态
     */
    @ApiModelProperty(value = "标准状态")
    private String standardRuleType;

    /**
     * 标准编号
     */
    @ApiModelProperty(value = "标准编号")
    private String standardRuleNo;

    /**
     * 中文标题
     */
    @ApiModelProperty(value = "中文标题")
    private String cnTitle;

    /**
     * 英文标题
     */
    @ApiModelProperty(value = "英文标题")
    private String enTitle;

    /**
     * 发布日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布日期")
    private OffsetDateTime pubDate;

    /**
     * 实施日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "实施日期")
    private OffsetDateTime impleDate;

    /**
     * 发布部门
     */
    @ApiModelProperty(value = "发布部门")
    private String pubDept;

    /**
     * 标准摘要
     */
    @ApiModelProperty(value = "标准摘要")
    private String standardRuleAbstract;

    /**
     * 代替标准
     */
    @ApiModelProperty(value = "代替标准")
    private String replaceStandardRule;

    /**
     * 现行标准
     */
    @ApiModelProperty(value = "现行标准")
    private String activeStandardRule;

    /**
     * 修改单
     */
    @ApiModelProperty(value = "修改单")
    private String modifyList;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 浏览数
     */
    @ApiModelProperty(value = "浏览数")
    private Integer views;
    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    private List<StandardRuleFileMageListVo> standardRuleFileMageInsertPos;

    public List<StandardRuleFileMageListVo> getStandardRuleFileMageInsertPos() {
        return standardRuleFileMageInsertPos;
    }

    public void setStandardRuleFileMageInsertPos(List<StandardRuleFileMageListVo> standardRuleFileMageInsertPos) {
        this.standardRuleFileMageInsertPos = standardRuleFileMageInsertPos;
    }

    private HashMap<String,Object> map;

    /**
     * 标准类型id名称
     */
    private String standardTypeMageIdName;

    /**
     * ICS分类管理id名称
     */
    private String icsClassMageIdName;

    /**
     * 中标分类管理id名称
     */
    private String chinaStandardTypeMageIdName;


    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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
