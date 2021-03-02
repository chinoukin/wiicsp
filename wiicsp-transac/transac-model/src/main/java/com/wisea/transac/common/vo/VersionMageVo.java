package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author chengq
 * @date 2020/9/29 10:33
 */
public class VersionMageVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private String versionCode;

    /**
     * 版本名称
     */
    @ApiModelProperty("版本名称")
    private String versionName;

    /**
     * 版本信息
     */
    @ApiModelProperty("版本信息")
    private String versionInfo;

    /**
     * 是否强制更新
     */
    @ApiModelProperty("是否强制更新")
    private Boolean forceUpdate;

    /**
     * 版本下载链接
     */
    @ApiModelProperty("版本下载链接")
    private String downloadUrl;

    private String versionType;

    @ApiModelProperty(value="来源类型,0.采购app，1.档口app，2.产地app")
    private String sourceType;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(String versionInfo) {
        this.versionInfo = versionInfo;
    }

    public Boolean getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(Boolean forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }
}
