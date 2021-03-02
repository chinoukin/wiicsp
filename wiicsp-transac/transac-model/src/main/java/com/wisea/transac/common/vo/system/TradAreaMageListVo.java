package com.wisea.transac.common.vo.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.transac.common.vo.TradAreaPictureMagePageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * TradAreaMageListVo
 * 2020/05/07 10:34:56
 */
public class TradAreaMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 批发市场id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "批发市场id")
    private Long wholeSaleMarketId;

    /**
     * 父分类名称
     */
    @ApiModelProperty(value = "父分类名称")
    private String pCatgName;

    /**
     * 分类名称
     */
    @ApiModelProperty(value = "分类名称")
    private String catgName;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示")
    private String ifDisplayType;

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

    @ApiModelProperty(value = "图片")
    private List<TradAreaPictureMagePageListVo> pictures;

    @ApiModelProperty(value = "分类")
    private List<TradAreaCommRelaMageListVo> comms;

    @ApiModelProperty(value = "商品总数")
    private Long count;

    @ApiModelProperty(value = "pid")
    private Long pid = 0L;

    @ApiModelProperty(value = "level")
    private Long level = 1L;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(Long level) {
        this.level = level;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<TradAreaPictureMagePageListVo> getPictures() {
        return pictures;
    }

    public void setPictures(List<TradAreaPictureMagePageListVo> pictures) {
        this.pictures = pictures;
    }

    public List<TradAreaCommRelaMageListVo> getComms() {
        return comms;
    }

    public void setComms(List<TradAreaCommRelaMageListVo> comms) {
        this.comms = comms;
    }

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
