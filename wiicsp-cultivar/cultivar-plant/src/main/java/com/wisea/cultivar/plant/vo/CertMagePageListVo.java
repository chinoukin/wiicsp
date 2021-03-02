package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CertMageVo")
public class CertMagePageListVo {
    @ApiModelProperty(value="店铺id")
    private Long shopInfoId;

    @ApiModelProperty(value="证书名称")
    private String certName;

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
