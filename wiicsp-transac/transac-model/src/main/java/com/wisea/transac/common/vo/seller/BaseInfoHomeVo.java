package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className BaseInfoHomeVo
 * @date 2020/7/3 14:22
 * @Description 基地首页VO
 */
@ApiModel("基地首页VO")
public class BaseInfoHomeVo {
    @ApiModelProperty("基地ID")
    private Long id;
    @ApiModelProperty("会员id（商家）")
    private Long membId;
    @ApiModelProperty("基地名称")
    private String baseName;
    @ApiModelProperty("会员类型")
    private String membType;
    @ApiModelProperty("基地背景图")
    private String baseBackImg;
    @ApiModelProperty("720VR地址")
    private String vrUrl;
    @ApiModelProperty("VR视频地址")
    private String vrVideoUrl;
    @ApiModelProperty("优势单品数量")
    private Integer supPieceCount;
    @ApiModelProperty("优势单品图片")
    private String supPieceImg;
    @ApiModelProperty("分选工厂数量")
    private Integer sortingFactoryCount;
    @ApiModelProperty("分选工厂图片")
    private String sortingFactoryImg;
    @ApiModelProperty("仓储数量")
    private Integer storageCount;
    @ApiModelProperty("仓储图片")
    private String storageImg;
    @ApiModelProperty("种植园数量")
    private Integer plantationCount;
    @ApiModelProperty("种植园图片")
    private String plantationImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getBaseBackImg() {
        return baseBackImg;
    }

    public void setBaseBackImg(String baseBackImg) {
        this.baseBackImg = baseBackImg;
    }

    public String getVrUrl() {
        return vrUrl;
    }

    public void setVrUrl(String vrUrl) {
        this.vrUrl = vrUrl;
    }

    public String getVrVideoUrl() {
        return vrVideoUrl;
    }

    public void setVrVideoUrl(String vrVideoUrl) {
        this.vrVideoUrl = vrVideoUrl;
    }

    public Integer getSupPieceCount() {
        return supPieceCount;
    }

    public void setSupPieceCount(Integer supPieceCount) {
        this.supPieceCount = supPieceCount;
    }

    public String getSupPieceImg() {
        return supPieceImg;
    }

    public void setSupPieceImg(String supPieceImg) {
        this.supPieceImg = supPieceImg;
    }

    public Integer getSortingFactoryCount() {
        return sortingFactoryCount;
    }

    public void setSortingFactoryCount(Integer sortingFactoryCount) {
        this.sortingFactoryCount = sortingFactoryCount;
    }

    public String getSortingFactoryImg() {
        return sortingFactoryImg;
    }

    public void setSortingFactoryImg(String sortingFactoryImg) {
        this.sortingFactoryImg = sortingFactoryImg;
    }

    public Integer getStorageCount() {
        return storageCount;
    }

    public void setStorageCount(Integer storageCount) {
        this.storageCount = storageCount;
    }

    public String getStorageImg() {
        return storageImg;
    }

    public void setStorageImg(String storageImg) {
        this.storageImg = storageImg;
    }

    public Integer getPlantationCount() {
        return plantationCount;
    }

    public void setPlantationCount(Integer plantationCount) {
        this.plantationCount = plantationCount;
    }

    public String getPlantationImg() {
        return plantationImg;
    }

    public void setPlantationImg(String plantationImg) {
        this.plantationImg = plantationImg;
    }
}
