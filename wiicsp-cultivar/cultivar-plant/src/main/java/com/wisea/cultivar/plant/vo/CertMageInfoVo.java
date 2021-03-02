package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("CertMage详细信息Vo")
public class CertMageInfoVo {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value="店铺id")
    private Long shopInfoId;

    @ApiModelProperty(value="证书名称")
    private String certName;

    @ApiModelProperty(value = "证书图片")
    private List<CertPictureInfoVo> certPictureInfoVoList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CertPictureInfoVo> getCertPictureInfoVoList() {
        return certPictureInfoVoList;
    }

    public void setCertPictureInfoVoList(List<CertPictureInfoVo> certPictureInfoVoList) {
        this.certPictureInfoVoList = certPictureInfoVoList;
    }

    public Long getShopInfoId() {
        return shopInfoId;
    }

    public void setShopInfoId(Long shopInfoId) {
        this.shopInfoId = shopInfoId;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
}
