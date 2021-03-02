package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SproutCatalogMageUpdatePo
 * 2020/08/06 14:19:24
 */
public class SproutCatalogMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 种苗目录名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "种苗目录名称", allowableValues = "mixLength:(,255]")
    private String sproutCatalogName;

    /**
     * 年份
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "年份", allowableValues = "length:(,10]")
    private Integer sproutYear;

    /**
     * 油茶品种信息id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "油茶品种信息id")
    private List<Long> oilTeaVarietId;

    /**
     * 服务商id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "服务商id")
    private List<Long> membId;


    /**
     * 种苗目录状态类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "种苗目录状态类型", allowableValues = "mixLength:(,5]")
    private String sproutCatalogStateType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

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

    public List<Long> getOilTeaVarietId() {
        return oilTeaVarietId;
    }

    public void setOilTeaVarietId(List<Long> oilTeaVarietId) {
        this.oilTeaVarietId = oilTeaVarietId;
    }

    public List<Long> getMembId() {
        return membId;
    }

    public void setMembId(List<Long> membId) {
        this.membId = membId;
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
