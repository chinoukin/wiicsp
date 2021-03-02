package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/4/28 5:37 下午
 */
@ApiModel("证书集合")
public class ListCertMagePo {

    @ApiModelProperty("集合")
    private List<CertMagePo> certs;

    public List<CertMagePo> getCerts() {
        return certs;
    }

    public void setCerts(List<CertMagePo> certs) {
        this.certs = certs;
    }
}
