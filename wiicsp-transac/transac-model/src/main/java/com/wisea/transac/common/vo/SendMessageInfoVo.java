package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("详细信息Vo")
public class SendMessageInfoVo {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "发送标题")
    private String title;

    @ApiModelProperty(value = "发送摘要")
    private String summary;

    @ApiModelProperty(value = "发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)")
    private String scope;

    @ApiModelProperty(value = "指定条件(发送范围为4:指定会员 时的过滤条件)")
    private String assign;

    @ApiModelProperty(value = "消息类型")
    private String messageType;

    @ApiModelProperty(value = "消息内容")
    private String content;

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

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
