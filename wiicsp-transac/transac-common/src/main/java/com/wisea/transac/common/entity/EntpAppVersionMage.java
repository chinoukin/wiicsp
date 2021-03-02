package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class EntpAppVersionMage extends DataLongEntity<EntpAppVersionMage> {
    /**
     * 版本类型
     */
    private String appVersionType;

    /**
     * 版本名称
     */
    private String appVersionName;

    /**
     * 版本号
     */
    private String versionNum;

    /**
     * 是否强制更新
     */
    private String ifDisplayType;

    /**
     * 更新地址
     */
    private String updateUrl;

    /**
     * 更新内容
     */
    private String updateContent;

    /**
     * 来源类型
     */
    private String sourceType;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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
