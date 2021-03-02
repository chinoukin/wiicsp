package com.wisea.transac.common.po;

import com.wisea.transac.common.po.system.TradAreaCommRelaMageInsertPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("交易区新增或修改Po")
public class TradAreaMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="批发市场id")
    private Long wholeSaleMarketId;

    @ApiModelProperty(value="父分类名称")
    private String pCatgName;

    @ApiModelProperty(value="分类名称")
    private String catgName;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    @ApiModelProperty(value="是否显示")
    private String ifDisplayType;

    @ApiModelProperty(value = "图片")
    private List<TradAreaPictureMagePo> pictures;

    @ApiModelProperty(value = "分类")
    private List<TradAreaCommRelaMageInsertPo> comms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getpCatgName() {
        return pCatgName;
    }

    public void setpCatgName(String pCatgName) {
        this.pCatgName = pCatgName;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIfDisplayType() {
        return ifDisplayType;
    }

    public void setIfDisplayType(String ifDisplayType) {
        this.ifDisplayType = ifDisplayType;
    }

    public List<TradAreaPictureMagePo> getPictures() {
        return pictures;
    }

    public void setPictures(List<TradAreaPictureMagePo> pictures) {
        this.pictures = pictures;
    }

    public List<TradAreaCommRelaMageInsertPo> getComms() {
        return comms;
    }

    public void setComms(List<TradAreaCommRelaMageInsertPo> comms) {
        this.comms = comms;
    }
}
