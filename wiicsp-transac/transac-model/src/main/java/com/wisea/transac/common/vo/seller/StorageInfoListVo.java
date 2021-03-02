package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className StorageInfoListVo
 * @date 2020/7/2 13:52
 * @Description 仓储列表VO
 */
@ApiModel("仓储列表VO")
public class StorageInfoListVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("基地id")
    private Long baseId;
    @ApiModelProperty("仓库名称")
    private String storageName;
    @ApiModelProperty("仓库面积")
    private Double storageMj;
    @ApiModelProperty("仓库类型")
    private String warehType;
    @ApiModelProperty("物联网设备-设备厂商")
    private String equManufact;
    @ApiModelProperty("物联网设备-设备厂商ID")
    private String equEntpId;
    @ApiModelProperty("物联网设备-设备类型")
    private String equType;
    @ApiModelProperty("物联网设备-设备编号")
    private String equNum;
    @ApiModelProperty("图片url")
    private String imgUrl;
    @ApiModelProperty("在售数量")
    private Integer saleCount;
    @ApiModelProperty("实时视频，1有，0无")
    private String videoFlag;

    @ApiModelProperty("温度")
    private Double wendu;
    @ApiModelProperty("湿度")
    private Double shidu;

    public Double getWendu() {
        return wendu;
    }

    public void setWendu(Double wendu) {
        this.wendu = wendu;
    }

    public Double getShidu() {
        return shidu;
    }

    public void setShidu(Double shidu) {
        this.shidu = shidu;
    }

    public String getVideoFlag() {
        return videoFlag;
    }

    public void setVideoFlag(String videoFlag) {
        this.videoFlag = videoFlag;
    }

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

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public Double getStorageMj() {
        return storageMj;
    }

    public void setStorageMj(Double storageMj) {
        this.storageMj = storageMj;
    }

    public String getWarehType() {
        return warehType;
    }

    public void setWarehType(String warehType) {
        this.warehType = warehType;
    }

    public String getEquManufact() {
        return equManufact;
    }

    public void setEquManufact(String equManufact) {
        this.equManufact = equManufact;
    }

    public String getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(String equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
