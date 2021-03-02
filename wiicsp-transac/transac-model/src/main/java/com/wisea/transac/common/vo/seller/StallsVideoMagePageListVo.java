package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档口视频分页查询Vo")
public class StallsVideoMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="档口id")
    private Long stallsMageId;

    @ApiModelProperty(value="所属档口")
    private String belongStalls;

    @ApiModelProperty(value="名称")
    private String name;

    @ApiModelProperty(value="接入地址")
    private String accUrl;

    @ApiModelProperty(value="是否设为封面标志,0是")
    private String setAsCoverFlag;

    @ApiModelProperty(value="是否打开视频，0打开，1未打开")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public String getBelongStalls() {
        return belongStalls;
    }

    public void setBelongStalls(String belongStalls) {
        this.belongStalls = belongStalls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccUrl() {
        return accUrl;
    }

    public void setAccUrl(String accUrl) {
        this.accUrl = accUrl;
    }

    public String getSetAsCoverFlag() {
        return setAsCoverFlag;
    }

    public void setSetAsCoverFlag(String setAsCoverFlag) {
        this.setAsCoverFlag = setAsCoverFlag;
    }
}
