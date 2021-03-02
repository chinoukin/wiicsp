package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpCertMageInsertPo
 * 2018/10/09 16:37:34
 */
public class EntpCertMageInsertPo {
    /**
     * 会员标签id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员标签id")
    private Long membLabelId;

    /**
     * 图片url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 获取会员标签id
     */
    public Long getMembLabelId() {
        return membLabelId;
    }

    /**
     * 设置会员标签id
     */
    public void setMembLabelId(Long membLabelId) {
        this.membLabelId = membLabelId;
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
