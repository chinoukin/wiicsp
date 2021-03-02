package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("详细信息Vo")
public class SendMessageReciverInfoVo {
    @ApiModelProperty(value="消息ID")
    private Long msgId;

    @ApiModelProperty(value="会员ID")
    private Long membId;

    @ApiModelProperty(value="已读标志")
    private String readFlag;

    @ApiModelProperty(value="跳转url")
    private String tzUrl;

    @ApiModelProperty(value="跳转参数")
    private String tzPara;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }

    public String getTzUrl() {
        return tzUrl;
    }

    public void setTzUrl(String tzUrl) {
        this.tzUrl = tzUrl;
    }

    public String getTzPara() {
        return tzPara;
    }

    public void setTzPara(String tzPara) {
        this.tzPara = tzPara;
    }
}
