package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SampPictureInsertPo
 * 2018/09/18 14:36:47
 */
public class SampPictureInsertPo {
    /**
     * 样品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "样品id")
    private Long sampId;

    /**
     * 图片类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "图片类型")
    private String pictureType;

    /**
     * 图片url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取样品id
     */
    public Long getSampId() {
        return sampId;
    }

    /**
     * 设置样品id
     */
    public void setSampId(Long sampId) {
        this.sampId = sampId;
    }

    /**
     * 获取图片类型
     */
    public String getPictureType() {
        return pictureType;
    }

    /**
     * 设置图片类型
     */
    public void setPictureType(String pictureType) {
        this.pictureType = pictureType == null ? null : pictureType.trim();
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
}
