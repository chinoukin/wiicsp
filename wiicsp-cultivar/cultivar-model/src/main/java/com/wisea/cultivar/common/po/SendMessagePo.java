package com.wisea.cultivar.common.po;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增Po")
public class SendMessagePo {
    @ApiModelProperty(value = "平台标识", required = true)
    @Check(test = "required")
    private String platform;

    @ApiModelProperty(value = "发送标题")
    @Check(test = "required")
    private String title;

    @ApiModelProperty(value = "发送摘要")
    private String summary;

    @ApiModelProperty(value = "发送范围(0：全部会员 1:全部供应商 2:全部采购商 3:供应商企业认证会员 4:供应商个体户认证会员 5:采购商企业认证会员 6:采购商个体户认证会员 7:采购商个人认证会员)")
    @Check(test = "logic", logic = "#isEmpty(#recList)?#isNotEmpty(#scope):true", logicMsg = "指定具体会员列表为空时，发送范围不能为空")
    private List<String> scope;

    @ApiModelProperty(value = "发送详细内容")
    @Check(test = "required")
    private String content;

    @ApiModelProperty(value = "指定具体会员列表")
    @Check(test = "logic", logic = "#isEmpty(#scope)?#isNotEmpty(#recList):true", logicMsg = "发送范围为空时，指定具体会员列表不能为空")
    private List<String> recList = Lists.newArrayList();

    @ApiModelProperty(value = "发送范围文本")
    private String remarks;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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

    public List<String> getScope() {
        return scope;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getRecList() {
        return recList;
    }

    public void setRecList(List<String> recList) {
        this.recList = recList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
