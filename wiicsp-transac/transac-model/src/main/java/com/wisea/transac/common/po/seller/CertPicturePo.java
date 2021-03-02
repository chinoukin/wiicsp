package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("证书图片新增或修改Po")
public class CertPicturePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="证书id")
    private Long certMageId;

    @ApiModelProperty(value="图片")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
