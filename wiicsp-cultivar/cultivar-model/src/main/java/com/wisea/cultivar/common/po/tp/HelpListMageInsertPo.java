package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * HelpListMageInsertPo
 * 2018/10/29 15:34:52
 */
public class HelpListMageInsertPo {
    /**
     * 帮助分类id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength","required" }, length = 19)
    @ApiModelProperty(value = "帮助分类id")
    private Long helpCatgId;

    /**
     * 编号
     */
    @Check(test = { "maxLength","required" }, mixLength = 10)
    @ApiModelProperty(value = "编号")
    private String num;

    /**
     * 标题
     */
    @Check(test = { "maxLength","required" }, mixLength = 100)
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime pubDate;

    /**
     * 是否显示
     */
    @Check(test = { "maxLength","required" }, mixLength = 1)
    @ApiModelProperty(value = "是否显示,0表示显示，1不显示")
    private String defaultFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 内容
     */
    @Check(test = { "maxLength","required" }, mixLength = 16777215)
    @ApiModelProperty(value = "内容")
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
