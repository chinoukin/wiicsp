package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 系统版本信息
 * @author: wangs
 * @date :2018/6/22
 */
@ApiModel("系统版本信息更新信息")
public class VersionInfoMage extends DataLongEntity<VersionInfoMage> {

    /**
     * 版本名称
     */
    @ApiModelProperty("版本名称")
    private String versionName;
    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    private String versionNum;
    /**
     * 是否强制更新类型
     */
    @ApiModelProperty("是否强制更新类型")
    private String forceUpdateType;
    /**
     * 版本类型
     */
    @ApiModelProperty("版本类型")
    private String versionType;
    /**
     * 更新内容
     */
    @ApiModelProperty("更新内容")
    private String updateCont;
    /**
     * 更新地址
     */
    @ApiModelProperty("更新地址")
    private String updateUrl;
    /**
     * 新增或修改标识
     */
    @ApiModelProperty("新增或修改标识 （0是“保存”，1是修改，修改时传1,id必填）")
    private String isSaveOrUpdate;

    @ApiModelProperty("更新人")
    private String updatBy;

    public String getUpdatBy() {
        return updatBy;
    }

    public void setUpdatBy(String updatBy) {
        this.updatBy = updatBy;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getForceUpdateType() {
        return forceUpdateType;
    }

    public void setForceUpdateType(String forceUpdateType) {
        this.forceUpdateType = forceUpdateType;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

    public String getUpdateCont() {
        return updateCont;
    }

    public void setUpdateCont(String updateCont) {
        this.updateCont = updateCont;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getIsSaveOrUpdate() {
        return isSaveOrUpdate;
    }

    public void setIsSaveOrUpdate(String isSaveOrUpdate) {
        this.isSaveOrUpdate = isSaveOrUpdate;
    }
}
