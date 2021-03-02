package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2018/9/25
 */
@ApiModel("商家证书查询")
public class CertMagePo {

    /**
     * 会员id
     */
    @ApiModelProperty("会员id")
    private Long membId;
    /**
     * 会员id
     */
    @ApiModelProperty("标签id")
    private Long membLabelId;

    /**
     * 证书type
     */
    @ApiModelProperty("证书类型")
    @Check(test = "required")
    private String compCertType;

    public Long getMembLabelId() {
        return membLabelId;
    }

    public void setMembLabelId(Long membLabelId) {
        this.membLabelId = membLabelId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCompCertType() {
        return compCertType;
    }

    public void setCompCertType(String compCertType) {
        this.compCertType = compCertType;
    }
}
