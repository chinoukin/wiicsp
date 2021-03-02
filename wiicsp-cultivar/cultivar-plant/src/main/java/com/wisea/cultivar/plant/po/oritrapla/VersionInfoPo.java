package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 系统版本传入参数
 * @author: wangs
 * @date :2018/6/22
 */
@ApiModel("系统版本传入参数")
public class VersionInfoPo {

    /**
     * 系统版本id
     */
    @ApiModelProperty("系统版本id")
    @Check(test = "logic", logic = "'1'.equals(#isSaveOrUpdate)?#isNotEmpty(#id):true")
    private Long id;
    /**
     * 版本名称
     */
    @ApiModelProperty("系统版本名称")
    @Check(test = "required", requiredMsg = "系统版本名称不能为空")
    private String versionName;
    /**
     * 版本号
     */
    @ApiModelProperty("版本号")
    @Check(test = "required", requiredMsg = "系统版本号不能为空")
    private String versionNum;
    /**
     * 是否强制更新类型
     */
    @ApiModelProperty("是否强制更新")
    @Check(test = "required", requiredMsg = "是否强制更新不能为空")
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
    @Check(test = "required", requiredMsg = "更新内容不能为空")
    private String updateCont;
    /**
     * 更新地址
     */
    @ApiModelProperty("更新地址")
    @Check(test = "required", requiredMsg = "更新地址不能为空")
    private String updateUrl;

    @ApiModelProperty("更新保存标识（0是“保存”，1是修改，修改时传1,id必填）")
    @Check(test = "required", requiredMsg = "更新保存标识标识不能为空")
    private String isSaveOrUpdate;

    /**
     * 排他字段 更新时间
     */
    @ApiModelProperty(value="排他字段")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
