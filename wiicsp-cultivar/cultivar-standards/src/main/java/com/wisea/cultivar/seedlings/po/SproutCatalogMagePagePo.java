package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * SproutCatalogMagePagePo
 * 2020/08/06 14:19:24
 */
public class SproutCatalogMagePagePo extends PagePo<SproutCatalogMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种苗目录名称
     */
    @ApiModelProperty(value = "种苗目录名称")
    private String sproutCatalogName;

    /**
     * 年份
     */
    @ApiModelProperty(value = "年份")
    private Integer sproutYear;

    /**
     * 油茶品种信息id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "油茶品种信息id")
    private Long oilTeaVarietId;

    /**
     * 审（认）定良种编号
     */
    @ApiModelProperty(value = "审（认）定良种编号")
    private String sdlzNo;

    /**
     * 适合区域
     */
    @ApiModelProperty(value = "适合区域")
    private String fitArea;

    /**
     * 亩产
     */
    @ApiModelProperty(value = "亩产")
    private Double acrePlantCg;

    /**
     * 选育单位
     */
    @ApiModelProperty(value = "选育单位")
    private String breedEntp;

    /**
     * 特征特性
     */
    @ApiModelProperty(value = "特征特性")
    private String features;

    /**
     * 苗木栽植方式
     */
    @ApiModelProperty(value = "苗木栽植方式")
    private String plantMode;

    /**
     * 种苗目录状态类型
     */
    @ApiModelProperty(value = "种苗目录状态类型")
    private String sproutCatalogStateType;

    @ApiModelProperty(value = "年份排序（0：按照更新时间排序2：降序1：升序）")
    private Integer sprout = 0;

    public Integer getSprout() {
        return sprout;
    }

    public void setSprout(Integer sprout) {
        this.sprout = sprout;
    }

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
     * 获取种苗目录名称
     */
    public String getSproutCatalogName() {
        return sproutCatalogName;
    }

    /**
     * 设置种苗目录名称
     */
    public void setSproutCatalogName(String sproutCatalogName) {
        this.sproutCatalogName = sproutCatalogName == null ? null : sproutCatalogName.trim();
    }

    /**
     * 获取年份
     */
    public Integer getSproutYear() {
        return sproutYear;
    }

    /**
     * 设置年份
     */
    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    /**
     * 获取油茶品种信息id
     */
    public Long getOilTeaVarietId() {
        return oilTeaVarietId;
    }

    /**
     * 设置油茶品种信息id
     */
    public void setOilTeaVarietId(Long oilTeaVarietId) {
        this.oilTeaVarietId = oilTeaVarietId;
    }

    /**
     * 获取审（认）定良种编号
     */
    public String getSdlzNo() {
        return sdlzNo;
    }

    /**
     * 设置审（认）定良种编号
     */
    public void setSdlzNo(String sdlzNo) {
        this.sdlzNo = sdlzNo == null ? null : sdlzNo.trim();
    }

    /**
     * 获取适合区域
     */
    public String getFitArea() {
        return fitArea;
    }

    /**
     * 设置适合区域
     */
    public void setFitArea(String fitArea) {
        this.fitArea = fitArea == null ? null : fitArea.trim();
    }

    /**
     * 获取亩产
     */
    public Double getAcrePlantCg() {
        return acrePlantCg;
    }

    /**
     * 设置亩产
     */
    public void setAcrePlantCg(Double acrePlantCg) {
        this.acrePlantCg = acrePlantCg;
    }

    /**
     * 获取选育单位
     */
    public String getBreedEntp() {
        return breedEntp;
    }

    /**
     * 设置选育单位
     */
    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp == null ? null : breedEntp.trim();
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
     * 获取苗木栽植方式
     */
    public String getPlantMode() {
        return plantMode;
    }

    /**
     * 设置苗木栽植方式
     */
    public void setPlantMode(String plantMode) {
        this.plantMode = plantMode == null ? null : plantMode.trim();
    }

    /**
     * 获取种苗目录状态类型
     */
    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    /**
     * 设置种苗目录状态类型
     */
    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType == null ? null : sproutCatalogStateType.trim();
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
