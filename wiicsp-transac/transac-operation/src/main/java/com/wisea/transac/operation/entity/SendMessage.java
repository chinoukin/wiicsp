package com.wisea.transac.operation.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SendMessage extends DataLongEntity<SendMessage> {
    /**
     *
     */
    private static final long serialVersionUID = 6227255047511773101L;

    /**
     * 发送标题
     */
    private String title;

    /**
     * 发送摘要
     */
    private String summary;

    /**
     * 发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)
     */
    private String scope;

    /**
     * 指定条件(发送范围为4:指定会员 时的过滤条件)
     */
    private String assign;

    /**
     * 已读标志
     */
    private String readFlag;

    /**
     * 消息类型
     */
    private String messageType;

    /**
     * 发送详细内容
     */
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
