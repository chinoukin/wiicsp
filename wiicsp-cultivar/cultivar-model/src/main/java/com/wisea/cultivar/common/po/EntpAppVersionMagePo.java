package com.wisea.cultivar.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("企业版本新增或修改Po")
public class EntpAppVersionMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="版本类型，0安卓,1ios")
    private String appVersionType;

    @ApiModelProperty(value="版本名称")
    private String appVersionName;

    @ApiModelProperty(value="版本号")
    private String versionNum;

    @ApiModelProperty(value="是否强制更新")
    private String ifDisplayType;

    @ApiModelProperty(value="更新地址")
    private String updateUrl;

    @ApiModelProperty(value="更新内容")
    private String updateContent;

    @ApiModelProperty(value="备注：文件名称")
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

    public String getAppVersionType() {
        return appVersionType;
    }

    public void setAppVersionType(String appVersionType) {
        this.appVersionType = appVersionType;
    }

    public String getAppVersionName() {
        return appVersionName;
    }

    public void setAppVersionName(String appVersionName) {
        this.appVersionName = appVersionName;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getIfDisplayType() {
        return ifDisplayType;
    }

    public void setIfDisplayType(String ifDisplayType) {
        this.ifDisplayType = ifDisplayType;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }
}
