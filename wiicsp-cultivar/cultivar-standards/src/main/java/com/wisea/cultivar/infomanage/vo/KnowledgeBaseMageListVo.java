package com.wisea.cultivar.infomanage.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * KnowledgeBaseMageListVo
 * 2020/08/05 09:31:34
 */
public class KnowledgeBaseMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 所属分类类型
     */
    @ApiModelProperty(value = "所属分类类型")
    private String catgType;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词")
    private String keyWord;

    /**
     * 信息来源
     */
    @ApiModelProperty(value = "信息来源")
    private String infoSources;

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    private String outline;

    /**
     * 是否显示（是、否）
     */
    @ApiModelProperty(value = "是否显示（是、否）")
    private String ifShow;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime releDate;

    /**
     * 浏览数
     */
    @ApiModelProperty(value = "浏览数")
    private Integer views;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 知识库富文本
     */
    @ApiModelProperty(value = "知识库富文本")
    private String content;

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

    /**
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取所属分类类型
     */
    public String getCatgType() {
        return catgType;
    }

    /**
     * 设置所属分类类型
     */
    public void setCatgType(String catgType) {
        this.catgType = catgType == null ? null : catgType.trim();
    }

    /**
     * 获取关键词
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 设置关键词
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    /**
     * 获取信息来源
     */
    public String getInfoSources() {
        return infoSources;
    }

    /**
     * 设置信息来源
     */
    public void setInfoSources(String infoSources) {
        this.infoSources = infoSources == null ? null : infoSources.trim();
    }

    /**
     * 获取摘要
     */
    public String getOutline() {
        return outline;
    }

    /**
     * 设置摘要
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }

    /**
     * 获取是否显示（是、否）
     */
    public String getIfShow() {
        return ifShow;
    }

    /**
     * 设置是否显示（是、否）
     */
    public void setIfShow(String ifShow) {
        this.ifShow = ifShow == null ? null : ifShow.trim();
    }

    /**
     * 获取发布时间
     */
    public OffsetDateTime getReleDate() {
        return releDate;
    }

    /**
     * 设置发布时间
     */
    public void setReleDate(OffsetDateTime releDate) {
        this.releDate = releDate;
    }

    /**
     * 获取浏览数
     */
    public Integer getViews() {
        return views;
    }

    /**
     * 设置浏览数
     */
    public void setViews(Integer views) {
        this.views = views;
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

    /**
     * 获取知识库富文本
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置知识库富文本
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
