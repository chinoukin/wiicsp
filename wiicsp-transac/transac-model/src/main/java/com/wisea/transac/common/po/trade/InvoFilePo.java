package com.wisea.transac.common.po.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className InvoFilePo
 * @date 2020/5/18 9:43
 * @Description
 */
public class InvoFilePo {
    @ApiModelProperty("文件路径")
    private String fileUrl;
    @ApiModelProperty("文件名称")
    private String fileName;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
