package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.seedlings.vo.SproutEntpListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * SproutEntpPagePo
 * 2020/08/06 14:19:24
 */
public class SproutEntpPagePo extends PagePo<SproutEntpListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种苗目录管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种苗目录管理id")
    private Long sproutCatalogMageId;

    /**
     * 服务商id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "服务商id")
    private Long membId;

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
     * 获取种苗目录管理id
     */
    public Long getSproutCatalogMageId() {
        return sproutCatalogMageId;
    }

    /**
     * 设置种苗目录管理id
     */
    public void setSproutCatalogMageId(Long sproutCatalogMageId) {
        this.sproutCatalogMageId = sproutCatalogMageId;
    }

    /**
     * 获取服务商id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置服务商id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
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
}
