package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillEleInvoFileVo
 * @date 2020/5/15 10:13
 * @Description
 */
public class SettleBillEleInvoFileVo {
    @ApiModelProperty("电子发票Url")
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
