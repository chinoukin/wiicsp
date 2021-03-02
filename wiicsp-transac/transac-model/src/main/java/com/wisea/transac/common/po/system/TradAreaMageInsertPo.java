package com.wisea.transac.common.po.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * TradAreaMageInsertPo
 * 2020/05/07 10:34:56
 */
public class TradAreaMageInsertPo {
    /**
     * 批发市场id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "批发市场id")
    private Long wholeSaleMarketId;

    /**
     * 父分类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "父分类名称")
    private String pCatgName;

    /**
     * 分类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "分类名称")
    private String catgName;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 是否显示
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "是否显示")
    private String ifDisplayType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取批发市场id
     */
    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    /**
     * 设置批发市场id
     */
    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    /**
     * 获取父分类名称
     */
    public String getpCatgName() {
        return pCatgName;
    }

    /**
     * 设置父分类名称
     */
    public void setpCatgName(String pCatgName) {
        this.pCatgName = pCatgName == null ? null : pCatgName.trim();
    }

    /**
     * 获取分类名称
     */
    public String getCatgName() {
        return catgName;
    }

    /**
     * 设置分类名称
     */
    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取是否显示
     */
    public String getIfDisplayType() {
        return ifDisplayType;
    }

    /**
     * 设置是否显示
     */
    public void setIfDisplayType(String ifDisplayType) {
        this.ifDisplayType = ifDisplayType == null ? null : ifDisplayType.trim();
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
