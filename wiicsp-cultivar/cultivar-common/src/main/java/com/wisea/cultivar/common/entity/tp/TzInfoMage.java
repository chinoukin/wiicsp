package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * tz_info_mage 表实体
 * 通知信息管理
 * 2019/08/29 17:45:19
 */
public class TzInfoMage extends DataLongEntity<TzInfoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

    /**
     * 内容
     */
    private String content;

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
