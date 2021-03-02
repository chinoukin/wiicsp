package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpCertMageListVo
 * 2018/10/09 16:37:34
 */
public class EntpCertMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 会员标签id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员标签id")
    private Long membLabelId;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

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
