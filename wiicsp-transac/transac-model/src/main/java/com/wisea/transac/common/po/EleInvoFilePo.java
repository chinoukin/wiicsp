package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改Po")
public class EleInvoFilePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="订单发票id")
    private Long ordInvoId;

    @ApiModelProperty(value="电子发票url")
    private String eleInvoUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdInvoId() {
        return ordInvoId;
    }

    public void setOrdInvoId(Long ordInvoId) {
        this.ordInvoId = ordInvoId;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }
}
