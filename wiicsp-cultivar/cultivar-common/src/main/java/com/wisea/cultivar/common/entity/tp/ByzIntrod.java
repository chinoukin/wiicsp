package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * byz_introd 表实体
 * 布依族介绍
 * 2019/08/29 17:45:19
 */
public class ByzIntrod extends DataLongEntity<ByzIntrod> {
    private static final long serialVersionUID = 1L;

    /**
     * 图片
     */
    private String url;

    /**
     * 简介
     */
    private String content;

    /**
     * 获取图片
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取简介
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置简介
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
