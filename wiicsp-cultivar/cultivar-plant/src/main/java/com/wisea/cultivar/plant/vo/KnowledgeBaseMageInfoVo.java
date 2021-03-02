package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("KnowledgeBaseMage详细信息Vo")
public class KnowledgeBaseMageInfoVo {

    @ApiModelProperty(value="知识库id")
    private Long id;
    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="所属分类类型 0 看政策 1学农机")
    private String catgType;

    @ApiModelProperty(value="关键词")
    private String keyWord;

    @ApiModelProperty(value="信息来源")
    private String infoSources;

    @ApiModelProperty(value="摘要")
    private String outline;

    @ApiModelProperty(value="是否显示（是、否）0是1否")
    private String ifShow;

    @ApiModelProperty(value="知识库富文本")
    private String content;

    @ApiModelProperty(value="发布时间")
    private OffsetDateTime releDate;

    @ApiModelProperty(value="浏览数")
    private Integer views;
    @ApiModelProperty(value="收藏状态 如果有值说明收藏了  他的值就是收藏表的id")
    private Long membCollectionId;
    @ApiModelProperty(value="收藏状态  0表示有效  1表示失效")
    private String status;
    @ApiModelProperty(value="图片")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembCollectionId() {
        return membCollectionId;
    }

    public void setMembCollectionId(Long membCollectionId) {
        this.membCollectionId = membCollectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatgType() {
        return catgType;
    }

    public void setCatgType(String catgType) {
        this.catgType = catgType;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getInfoSources() {
        return infoSources;
    }

    public void setInfoSources(String infoSources) {
        this.infoSources = infoSources;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public String getIfShow() {
        return ifShow;
    }

    public void setIfShow(String ifShow) {
        this.ifShow = ifShow;
    }

    public OffsetDateTime getReleDate() {
        return releDate;
    }

    public void setReleDate(OffsetDateTime releDate) {
        this.releDate = releDate;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
