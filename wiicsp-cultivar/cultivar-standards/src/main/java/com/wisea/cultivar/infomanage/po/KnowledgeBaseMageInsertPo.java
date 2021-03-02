package com.wisea.cultivar.infomanage.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.infomanage.entity.KnowledgeBasePicture;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * KnowledgeBaseMageInsertPo
 * 2020/08/05 09:31:34
 */
public class KnowledgeBaseMageInsertPo {
    /**
     * 标题
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "标题", allowableValues = "mixLength:(,200]")
    private String title;

    /**
     * 所属分类类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "所属分类类型", allowableValues = "mixLength:(,5]")
    private String catgType;

    /**
     * 关键词
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "关键词", allowableValues = "mixLength:(,100]")
    private String keyWord;

    /**
     * 信息来源
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "信息来源", allowableValues = "mixLength:(,100]")
    private String infoSources;

    /**
     * 摘要
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "摘要", allowableValues = "mixLength:(,600]")
    private String outline;

    /**
     * 是否显示（是、否）
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "是否显示（是、否）", allowableValues = "mixLength:(,5]")
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
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "浏览数", allowableValues = "length:(,10]")
    private Integer views;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 知识库富文本
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "知识库富文本", allowableValues = "mixLength:(,16777215]")
    private String content;
    @ApiModelProperty(value = "图片实体类")
    private List<KnowledgeBasePicture> knowledgeBasePictures;

    public List<KnowledgeBasePicture> getKnowledgeBasePictures() {
        return knowledgeBasePictures;
    }

    public void setKnowledgeBasePictures(List<KnowledgeBasePicture> knowledgeBasePictures) {
        this.knowledgeBasePictures = knowledgeBasePictures;
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
