package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className FilePo
 * @date 2020/6/30 15:34
 * @Description
 */
@ApiModel("文件PO")
public class FilePo {
    @ApiModelProperty("文件路径")
    @Check(test = {"required"})
    private String fileUrl;
    @ApiModelProperty("文件类型：图片、视频 注：数据字典base_picture_type")
    private String fileType;
    @ApiModelProperty("排序")
    private Integer sort;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
