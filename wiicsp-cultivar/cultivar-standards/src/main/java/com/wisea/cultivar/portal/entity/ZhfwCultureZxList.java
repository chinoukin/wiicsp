package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * zhfw_culture_zx_list 表实体
 * 种植服文化资讯列表
 * 2020/08/24 20:28:13
 */
public class ZhfwCultureZxList extends DataLongEntity<ZhfwCultureZxList> {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String zy;

    /**
     * 图片
     */
    private String url;

    /**
     * 信息来源
     */
    private String xxly;

    /**
     * 是否显示
     */
    private String ifRequ;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

    /**
     * 文化资讯分类类型
     */
    private String cultureZxType;

    /**
     * 详细内容
     */
    private String content;

    /**
     *
     * @mbg.generated
     */
    public ZhfwCultureZxList() {
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
     * 获取文化资讯分类类型
     */
    public String getCultureZxType() {
        return cultureZxType;
    }

    /**
     * 设置文化资讯分类类型
     */
    public void setCultureZxType(String cultureZxType) {
        this.cultureZxType = cultureZxType == null ? null : cultureZxType.trim();
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
