package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className PlantationInfoListVo
 * @date 2020/7/2 16:45
 * @Description 种植园列表Vo
 */
@ApiModel("种植园列表Vo")
public class PlantationInfoListVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("种植园名称")
    private String plantationName;
    @ApiModelProperty("种植产品")
    private String plantationPrduct;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("种植园图片")
    private String imgUrl;
    @ApiModelProperty("在售数量")
    private Integer saleCount;

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public String getPlantationName() {
        return plantationName;
    }

    public void setPlantationName(String plantationName) {
        this.plantationName = plantationName;
    }

    public String getPlantationPrduct() {
        return plantationPrduct;
    }

    public void setPlantationPrduct(String plantationPrduct) {
        this.plantationPrduct = plantationPrduct;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
