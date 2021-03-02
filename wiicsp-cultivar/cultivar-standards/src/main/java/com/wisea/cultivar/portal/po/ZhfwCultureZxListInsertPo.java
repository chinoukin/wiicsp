package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * ZhfwCultureZxListInsertPo
 * 2020/08/24 20:28:13
 */
public class ZhfwCultureZxListInsertPo {
    /**
     * 标题
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "标题", allowableValues = "mixLength:(,255]")
    private String title;

    /**
     * 摘要
     */
    @Check(test = { "required","maxLength" }, mixLength = 400)
    @ApiModelProperty(value = "摘要", allowableValues = "mixLength:(,400]")
    private String zy;

    /**
     * 图片
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片", allowableValues = "mixLength:(,255]")
    private String url;

    /**
     * 信息来源
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "信息来源", allowableValues = "mixLength:(,255]")
    private String xxly;

    /**
     * 是否显示
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "是否显示", allowableValues = "mixLength:(,1]")
    private String ifRequ;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime pubDate;

    /**
     * 文化资讯分类类型
     */
    @Check(test = { "required","maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "文化资讯分类类型", allowableValues = "mixLength:(,5]")
    private String cultureZxType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 详细内容
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "详细内容", allowableValues = "mixLength:(,16777215]")
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
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
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
