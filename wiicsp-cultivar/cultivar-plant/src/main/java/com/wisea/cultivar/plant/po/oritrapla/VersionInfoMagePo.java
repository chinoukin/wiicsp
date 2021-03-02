package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.entity.oritrapla.VersionInfoMage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description: 系统版本信息
 * @author: wangs
 * @date :2018/6/22
 */
@ApiModel("系统版本信息")
public class VersionInfoMagePo extends PagePo<VersionInfoMage> {

    /**
     * 版本名称
     */
	@ApiModelProperty(value="版本名称")
    private String versionName;
    /**
     * 版本类型
     */
    @ApiModelProperty(value="版本类型")
    private String versionType;

    /**
     * 更新时间开始
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新开始时间")
    private OffsetDateTime updStaDate;

    /**
     * 更新时间结束
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新结束时间")
    private OffsetDateTime updEndDate;

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

    public OffsetDateTime getUpdStaDate() {
        return updStaDate;
    }

    public void setUpdStaDate(OffsetDateTime updStaDate) {
        this.updStaDate = updStaDate;
    }

    public OffsetDateTime getUpdEndDate() {
        return updEndDate;
    }

    public void setUpdEndDate(OffsetDateTime updEndDate) {
        this.updEndDate = updEndDate;
    }
}
