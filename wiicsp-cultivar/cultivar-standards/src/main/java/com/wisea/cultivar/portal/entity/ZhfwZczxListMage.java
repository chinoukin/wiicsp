package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * zhfw_zczx_list_mage 表实体
 * 种植服务政策咨询管理
 * 2020/08/24 20:28:13
 */
public class ZhfwZczxListMage extends DataLongEntity<ZhfwZczxListMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植服务资料分类id
     */
    private Long zhfwZczxCatgId;

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
     * 详细内容
     */
    private String content;

    /**
     *
     * @mbg.generated
     */
    public ZhfwZczxListMage() {
        super();
    }

    /**
     * 获取种植服务资料分类id
     */
    public Long getZhfwZczxCatgId() {
        return zhfwZczxCatgId;
    }

    /**
     * 设置种植服务资料分类id
     */
    public void setZhfwZczxCatgId(Long zhfwZczxCatgId) {
        this.zhfwZczxCatgId = zhfwZczxCatgId;
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
