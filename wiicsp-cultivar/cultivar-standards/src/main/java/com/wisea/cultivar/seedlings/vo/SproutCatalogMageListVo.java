package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * SproutCatalogMageListVo
 * 2020/08/06 14:19:24
 */
public class SproutCatalogMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种苗目录名称
     */
    @ApiModelProperty(value = "种苗目录名称")
    private String sproutCatalogName;

    /**
     * 年份
     */
    @ApiModelProperty(value = "年份")
    private Integer sproutYear;

    /**
     * 选育单位
     */
    @ApiModelProperty(value = "选育单位")
    private String breedEntp;


    /**
     * 油茶品种信息id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "油茶品种信息id")
    private Long oilTeaVarietId;

    @ApiModelProperty(value = "主推品种数")
    private Integer mainThrustNum;

    /**
     * 种苗目录状态类型
     */
    @ApiModelProperty(value = "种苗目录状态类型")
    private String sproutCatalogStateType;
    /**
     * 种苗目录状态类型
     */
    @ApiModelProperty(value = "种苗目录状态类型名称")
    private String sproutCatalogStateTypeName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    public String getBreedEntp() {
        return breedEntp;
    }

    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp;
    }

    /**
     * 更新时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "更新时间")
    private OffsetDateTime updateDate;

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getSproutCatalogStateTypeName() {
        return sproutCatalogStateTypeName;
    }

    public void setSproutCatalogStateTypeName(String sproutCatalogStateTypeName) {
        this.sproutCatalogStateTypeName = sproutCatalogStateTypeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSproutCatalogName() {
        return sproutCatalogName;
    }

    public void setSproutCatalogName(String sproutCatalogName) {
        this.sproutCatalogName = sproutCatalogName;
    }

    public Integer getSproutYear() {
        return sproutYear;
    }

    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    public Long getOilTeaVarietId() {
        return oilTeaVarietId;
    }

    public void setOilTeaVarietId(Long oilTeaVarietId) {
        this.oilTeaVarietId = oilTeaVarietId;
    }

    public Integer getMainThrustNum() {
        return mainThrustNum;
    }

    public void setMainThrustNum(Integer mainThrustNum) {
        this.mainThrustNum = mainThrustNum;
    }

    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
