package com.wisea.cultivar.common.vo;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class SendMessagePageListVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "平台标识")
    private String platform;

    @ApiModelProperty(value = "发送标题")
    private String title;

    @ApiModelProperty(value = "发送摘要")
    private String summary;

    @ApiModelProperty(value = "发送范围(0：全部会员 1:全部供应商 2:全部采购商 3:供应商企业认证会员 4:供应商个体户认证会员 5:采购商企业认证会员 6:采购商个体户认证会员 7:采购商个人认证会员)")
    private String scope;

    @ApiModelProperty(value = "指定条件(发送范围为4:指定会员 时的过滤条件)")
    private String assign;

    @ApiModelProperty(value = "已读标志")
    private String readFlag;

    @ApiModelProperty(value = "消息类型")
    private String messageType;

    @ApiModelProperty(value = "发送时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;


    @ApiModelProperty(value = "发送范围文本")
    private String remarks;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
