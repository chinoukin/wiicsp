package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * OilTeaVarietMagePagePo
 * 2020/07/24 11:21:45
 */
public class OilTeaVarietMagePagePo extends PagePo<OilTeaVarietMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    private List<Long> ids;
    /**
     * 品种名称
     */
    @ApiModelProperty(value = "品种名称")
    private String oilTeaVarietName;

    /**
     * 品种编号
     */
    @ApiModelProperty(value = "品种编号")
    private String oilTeaVarietNo;

    /**
     * 品种名称/英文字母
     */
    @ApiModelProperty(value = "品种名称/英文字母")
    private String query;
    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 亩种植数
     */
    @ApiModelProperty(value = "亩种植数")
    private Double acrePlantNum;

    /**
     * 亩均产果
     */
    @ApiModelProperty(value = "亩均产果")
    private Double acrePlantCg;

    /**
     * 亩均产籽
     */
    @ApiModelProperty(value = "亩均产籽")
    private Double acrePlantCz;

    /**
     * 亩均产油
     */
    @ApiModelProperty(value = "亩均产油")
    private Double acrePlantCy;

    /**
     * 适合区域
     */
    @ApiModelProperty(value = "适合区域")
    private String fitAre;

    /**
     * 特征特性
     */
    @ApiModelProperty(value = "特征特性")
    private String features;

    /**
     * 栽植方式
     */
    @ApiModelProperty(value = "栽植方式")
    private String plantMode;

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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
     * 获取品种名称
     */
    public String getOilTeaVarietName() {
        return oilTeaVarietName;
    }

    /**
     * 设置品种名称
     */
    public void setOilTeaVarietName(String oilTeaVarietName) {
        this.oilTeaVarietName = oilTeaVarietName == null ? null : oilTeaVarietName.trim();
    }

    /**
     * 获取品种编号
     */
    public String getOilTeaVarietNo() {
        return oilTeaVarietNo;
    }

    /**
     * 设置品种编号
     */
    public void setOilTeaVarietNo(String oilTeaVarietNo) {
        this.oilTeaVarietNo = oilTeaVarietNo == null ? null : oilTeaVarietNo.trim();
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
     * 获取亩种植数
     */
    public Double getAcrePlantNum() {
        return acrePlantNum;
    }

    /**
     * 设置亩种植数
     */
    public void setAcrePlantNum(Double acrePlantNum) {
        this.acrePlantNum = acrePlantNum;
    }

    /**
     * 获取亩均产果
     */
    public Double getAcrePlantCg() {
        return acrePlantCg;
    }

    /**
     * 设置亩均产果
     */
    public void setAcrePlantCg(Double acrePlantCg) {
        this.acrePlantCg = acrePlantCg;
    }

    /**
     * 获取亩均产籽
     */
    public Double getAcrePlantCz() {
        return acrePlantCz;
    }

    /**
     * 设置亩均产籽
     */
    public void setAcrePlantCz(Double acrePlantCz) {
        this.acrePlantCz = acrePlantCz;
    }

    /**
     * 获取亩均产油
     */
    public Double getAcrePlantCy() {
        return acrePlantCy;
    }

    /**
     * 设置亩均产油
     */
    public void setAcrePlantCy(Double acrePlantCy) {
        this.acrePlantCy = acrePlantCy;
    }

    /**
     * 获取适合区域
     */
    public String getFitAre() {
        return fitAre;
    }

    /**
     * 设置适合区域
     */
    public void setFitAre(String fitAre) {
        this.fitAre = fitAre == null ? null : fitAre.trim();
    }

    /**
     * 获取特征特性
     */
    public String getFeatures() {
        return features;
    }

    /**
     * 设置特征特性
     */
    public void setFeatures(String features) {
        this.features = features == null ? null : features.trim();
    }

    /**
     * 获取栽植方式
     */
    public String getPlantMode() {
        return plantMode;
    }

    /**
     * 设置栽植方式
     */
    public void setPlantMode(String plantMode) {
        this.plantMode = plantMode == null ? null : plantMode.trim();
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
