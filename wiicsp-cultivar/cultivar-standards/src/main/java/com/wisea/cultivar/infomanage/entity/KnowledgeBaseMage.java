package com.wisea.cultivar.infomanage.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * knowledge_base_mage 表实体
 * 知识库管理
 * 2020/08/05 09:31:34
 */
public class KnowledgeBaseMage extends DataLongEntity<KnowledgeBaseMage> {
    private static final long serialVersionUID = 1L;

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

    /**
     *
     * @mbg.generated
     */
    public KnowledgeBaseMage() {
        super();
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
