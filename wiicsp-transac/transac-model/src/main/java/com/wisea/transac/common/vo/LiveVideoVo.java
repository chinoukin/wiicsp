package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className LiveVideoVo
 * @date 2020/7/2 9:49
 * @Description 实时视频VO
 */
@ApiModel("实时视频VO")
public class LiveVideoVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("安装位置")
    private String installPosition;
    @ApiModelProperty("接入地址")
    private String url;
    @ApiModelProperty("设备厂商")
    private String equManufact;
    @ApiModelProperty("设备编号")
    private String equNum;
    @ApiModelProperty("排序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstallPosition() {
        return installPosition;
    }

    public void setInstallPosition(String installPosition) {
        this.installPosition = installPosition;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEquManufact() {
        return equManufact;
    }

    public void setEquManufact(String equManufact) {
        this.equManufact = equManufact;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
