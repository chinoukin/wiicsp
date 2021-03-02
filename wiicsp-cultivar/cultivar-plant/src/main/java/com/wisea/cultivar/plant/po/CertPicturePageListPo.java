package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.CertPicturePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CertPicturePo")
public class CertPicturePageListPo extends PagePo<CertPicturePageListVo> {
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
