package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * jszl_list_mage 表实体
 * 技术资料列表管理
 * 2019/08/29 17:45:19
 */
public class JszlListMage extends DataLongEntity<JszlListMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 技术资料分类id
     */
    private Long jszlCatgId;

    /**
     * 图片
     */
    private String url;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String zy;

    /**
     * 信息来源
     */
    private String xxly;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

    /**
     * 是否显示
     */
    private String ifRequ;

    /**
     * 详细内容
     */
    private String content;

    private int  ydl;

    /**
     * 获取技术资料分类id
     */
    public Long getJszlCatgId() {
        return jszlCatgId;
    }

    /**
     * 设置技术资料分类id
     */
    public void setJszlCatgId(Long jszlCatgId) {
        this.jszlCatgId = jszlCatgId;
    }

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
     * 获取摘要
     */
    public String getZy() {
        return zy;
    }

    /**
     * 设置摘要
     */
    public void setZy(String zy) {
        this.zy = zy == null ? null : zy.trim();
    }

    /**
     * 获取信息来源
     */
    public String getXxly() {
        return xxly;
    }

    /**
     * 设置信息来源
     */
    public void setXxly(String xxly) {
        this.xxly = xxly == null ? null : xxly.trim();
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
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否显示
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
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

	public int getYdl() {
		return ydl;
	}

	public void setYdl(int ydl) {
		this.ydl = ydl;
	}
}
