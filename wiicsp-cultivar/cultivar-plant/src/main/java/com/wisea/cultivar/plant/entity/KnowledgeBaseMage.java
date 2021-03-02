package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class KnowledgeBaseMage extends DataLongEntity<KnowledgeBaseMage> {
    /**
     * 标题
     */
    private String title;

    /**
     * 所属分类类型
     */
    private String catgType;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 信息来源
     */
    private String infoSources;

    /**
     * 摘要
     */
    private String outline;

    /**
     * 是否显示（是、否）
     */
    private String ifShow;

    /**
     * 发布时间
     */
    private OffsetDateTime releDate;

    /**
     * 浏览数
     */
    private Integer views;

    /**
     * 知识库富文本
     */
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
