package com.wisea.transac.common.vo;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className FileVo
 * @date 2020/7/1 9:55
 * @Description 文件VO
 */
@ApiModel("文件VO")
public class FileVo {
    @ApiModelProperty("文件路径")
    @Check(test = {"required"})
    private String fileUrl;
    @ApiModelProperty("排序")
    private Integer sort;
    @ApiModelProperty("文件类型：图片、视频 注：数据字典base_picture_type")
    private String fileType;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
