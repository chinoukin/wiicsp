package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.CertPicturePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class CertPicturePageListPo extends PagePo<CertPicturePageListVo> {
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
