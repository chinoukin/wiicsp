package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zx_list_mage 表实体
 * 资讯列表管理
 * 2019/08/29 17:45:19
 */
public class ZxListMage extends DataLongEntity<ZxListMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 图片
     */
    private String url;

    /**
     * 标题
     */
    private String title;

    /**
     * 所属分类
     */
    private String zxCatgType;

    /**
     * 摘要
     */
    private String zy;

    /**
     * 信息来源
     */
    private String xxly;

    /**
     * 是否显示
     */
    private String ifRequ;

    /**
     * 内容
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
     * 获取所属分类
     */
    public String getZxCatgType() {
        return zxCatgType;
    }

    /**
     * 设置所属分类
     */
    public void setZxCatgType(String zxCatgType) {
        this.zxCatgType = zxCatgType == null ? null : zxCatgType.trim();
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
