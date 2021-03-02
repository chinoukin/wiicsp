package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("CertPicture详细信息Vo")
public class CertPictureInfoVo {
    @ApiModelProperty(value="证书id")
    private Long certMageId;

    @ApiModelProperty(value="图片")
    private String url;

    public Long getCertMageId() {
        return certMageId;
    }

    public void setCertMageId(Long certMageId) {
        this.certMageId = certMageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
