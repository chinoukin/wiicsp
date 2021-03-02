package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改CheckFilePo")
public class CheckFilePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="补贴申请管理id")
    private Long subsidyApplMageId;

    @ApiModelProperty(value="验收材料url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
