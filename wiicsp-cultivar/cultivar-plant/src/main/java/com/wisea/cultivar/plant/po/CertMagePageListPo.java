package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.CertMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CertMagePo")
public class CertMagePageListPo extends PagePo<CertMagePageListVo> {
    @ApiModelProperty(value="店铺id")
    @Check(test = "required")
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
