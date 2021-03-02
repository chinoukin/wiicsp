package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SendMessageListPo
 * 2018/10/20 15:06:50
 */
public class SendMessageListPo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 发送标题
     */
    @ApiModelProperty(value = "发送标题")
    private String title;

    /**
     * 发送摘要
     */
    @ApiModelProperty(value = "发送摘要")
    private String summary;

    /**
     * 发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)
     */
    @ApiModelProperty(value = "发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)")
    private String scope;

    /**
     * 指定条件(发送范围为4:指定会员 时的过滤条件)
     */
    @ApiModelProperty(value = "指定条件(发送范围为4:指定会员 时的过滤条件)")
    private String assign;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 发送详细内容
     */
    @ApiModelProperty(value = "发送详细内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取发送标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置发送标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取发送摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置发送摘要
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置发送范围(0:全部会员 1:个人会员 2:企业会员 3:代理商会员 4:指定会员)
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * 获取指定条件(发送范围为4:指定会员 时的过滤条件)
     */
    public String getAssign() {
        return assign;
    }

    /**
     * 设置指定条件(发送范围为4:指定会员 时的过滤条件)
     */
    public void setAssign(String assign) {
        this.assign = assign == null ? null : assign.trim();
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
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 获取发送详细内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置发送详细内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
