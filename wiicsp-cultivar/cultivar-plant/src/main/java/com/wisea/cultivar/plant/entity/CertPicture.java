package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

public class CertPicture extends DataLongEntity<CertPicture> {
    /**
     * 证书id
     */
    @ApiModelProperty("证书id")
    private Long certMageId;

    /**
     * 图片
     */
    @ApiModelProperty("图片url")
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
