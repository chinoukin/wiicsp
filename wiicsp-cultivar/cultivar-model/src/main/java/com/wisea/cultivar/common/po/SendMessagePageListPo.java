package com.wisea.cultivar.common.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.SendMessagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class SendMessagePageListPo extends PagePo<SendMessagePageListVo> {

    @ApiModelProperty(value = "平台标识", required = true)
    @Check(test = "required")
    private String platform;
    /**
     *
     */
    private static final long serialVersionUID = 5500704536837638642L;
    @ApiModelProperty(value = "发送开始日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime sendStartDate;

    @ApiModelProperty(value = "发送结束日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime sendEndDate;

    @ApiModelProperty(value = "发送标题")
    private String title;

    @ApiModelProperty(value = "发送范围发送范围(0：全部会员 1:全部供应商 2:全部采购商 3:供应商企业认证会员 4:供应商个体户认证会员 5:采购商企业认证会员 6:采购商个体户认证会员 7:采购商个人认证会员)")
    private String scope;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public OffsetDateTime getSendStartDate() {
        return sendStartDate;
    }

    public void setSendStartDate(OffsetDateTime sendStartDate) {
        this.sendStartDate = sendStartDate;
    }

    public OffsetDateTime getSendEndDate() {
        return sendEndDate;
    }

    public void setSendEndDate(OffsetDateTime sendEndDate) {
        this.sendEndDate = sendEndDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
