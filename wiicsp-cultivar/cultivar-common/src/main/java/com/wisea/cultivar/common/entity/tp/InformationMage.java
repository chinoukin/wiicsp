package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * information_mage 表实体
 * 资讯信息管理
 * 2019/05/28 16:20:20
 */
public class InformationMage extends DataLongEntity<InformationMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 所属分类（平台公告、行业资讯、果链动态、价格行情）
     */
    private String informationType;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 消息摘要
     */
    private String informationDigest;

    /**
     * 图片
     */
    private String image;

    /**
     * 是否显示（是、否）
     */
    private String ifShow;

    /**
     * 详细内容
     */
    private String content;

    /**
     * 获取所属分类（平台公告、行业资讯、果链动态、价格行情）
     */
    public String getInformationType() {
        return informationType;
    }

    /**
     * 设置所属分类（平台公告、行业资讯、果链动态、价格行情）
     */
    public void setInformationType(String informationType) {
        this.informationType = informationType == null ? null : informationType.trim();
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
     * 获取关键词
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置关键词
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    /**
     * 获取消息摘要
     */
    public String getInformationDigest() {
        return informationDigest;
    }

    /**
     * 设置消息摘要
     */
    public void setInformationDigest(String informationDigest) {
        this.informationDigest = informationDigest == null ? null : informationDigest.trim();
    }

    /**
     * 获取图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
     * 获取详细内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置详细内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
