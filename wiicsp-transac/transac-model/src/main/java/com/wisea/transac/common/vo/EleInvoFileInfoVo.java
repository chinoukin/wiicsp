package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单发票文件Vo")
public class EleInvoFileInfoVo {
    @ApiModelProperty(value="电子发票url")
    private String eleInvoUrl;
    @ApiModelProperty("电子发票文件名称")
    private String fileName;

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
