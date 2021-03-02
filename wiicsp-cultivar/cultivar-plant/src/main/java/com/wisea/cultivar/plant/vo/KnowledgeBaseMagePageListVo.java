package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询KnowledgeBaseMageVo")
public class KnowledgeBaseMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value = "url")
    private String url;


    @ApiModelProperty(value="标题")
    private String title;

    @ApiModelProperty(value="所属分类类型")
    private String catgType;

    @ApiModelProperty(value="关键词")
    private String keyWord;

    @ApiModelProperty(value="信息来源")
    private String infoSources;

    @ApiModelProperty(value="摘要")
    private String outline;

    @ApiModelProperty(value="是否显示（是、否）")
    private String ifShow;

    @ApiModelProperty(value="发布时间")
    private OffsetDateTime releDate;

    @ApiModelProperty(value="浏览数")
    private Integer views;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
