package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SampPictureListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * SampPicturePagePo
 * 2018/09/18 14:36:47
 */
public class SampPicturePagePo extends PagePo<SampPictureListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 样品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "样品id")
    private Long sampId;

    /**
     * 图片类型
     */
    @ApiModelProperty(value = "图片类型")
    private String pictureType;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
    private String delFlag;

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

    /**
     * 获取删除标志
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
