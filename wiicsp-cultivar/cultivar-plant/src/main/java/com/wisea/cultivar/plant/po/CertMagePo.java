package com.wisea.cultivar.plant.po;

import com.wisea.cultivar.plant.entity.CertPicture;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("新增或修改CertMagePo")
public class CertMagePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="店铺id")
    private Long shopInfoId;

    @ApiModelProperty(value="证书名称")
    private String certName;

    @ApiModelProperty(value = "证书图片")
    private List<CertPicture> certPictureList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<CertPicture> getCertPictureList() {
        return certPictureList;
    }

    public void setCertPictureList(List<CertPicture> certPictureList) {
        this.certPictureList = certPictureList;
    }
}
