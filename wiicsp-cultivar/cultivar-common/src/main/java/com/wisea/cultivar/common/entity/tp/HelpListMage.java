package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * help_list_mage 表实体
 * 帮助列表管理
 * 2018/10/29 15:34:52
 */
public class HelpListMage extends DataLongEntity<HelpListMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 帮助分类id
     */
    private Long helpCatgId;

    /**
     * 编号
     */
    private String num;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

    /**
     * 是否显示
     */
    private String defaultFlag;

    /**
     * 内容
     */
    private String content;

    /**
     * 获取帮助分类id
     */
    public Long getHelpCatgId() {
        return helpCatgId;
    }

    /**
     * 设置帮助分类id
     */
    public void setHelpCatgId(Long helpCatgId) {
        this.helpCatgId = helpCatgId;
    }

    /**
     * 获取编号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
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
     * 获取发布时间
     */
    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    /**
     * 设置发布时间
     */
    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 获取是否显示
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否显示
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 获取内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
