package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("企业版本新增或修改Po")
public class EntpAppVersionMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="来源类型,0.采购app，1.档口app，2.产地app")
    @Check(test = "required")
    private String sourceType;

    @ApiModelProperty(value="版本类型，0安卓,1ios")
    private String appVersionType;

    @ApiModelProperty(value="版本名称")
    private String appVersionName;

    @ApiModelProperty(value="版本号,必须是数字，可以是小数")
    private String versionNum;

    @ApiModelProperty(value="是否强制更新")
    private String ifDisplayType;

    @ApiModelProperty(value="更新地址")
    private String updateUrl;

    @ApiModelProperty(value="更新内容")
    private String updateContent;

    @ApiModelProperty(value="备注：文件名称")
    private String remarks;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

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
