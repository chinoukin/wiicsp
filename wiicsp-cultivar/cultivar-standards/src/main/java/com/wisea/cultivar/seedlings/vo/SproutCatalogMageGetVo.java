package com.wisea.cultivar.seedlings.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.common.vo.trade.EntpAuthInfoVo;
import com.wisea.cultivar.explorer.vo.OilTeaVarietMageGetVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SproutCatalogMageGetVo
 * 2020/08/06 14:19:24
 */
public class SproutCatalogMageGetVo {
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
     * 油茶品种信息id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "油茶品种信息id")
    private Long oilTeaVarietId;


    /**
     * 选育单位
     */
    @ApiModelProperty(value = "选育单位")
    private String breedEntp;


    /**
     * 种苗目录状态类型
     */
    @ApiModelProperty(value = "种苗目录状态类型")
    private String sproutCatalogStateType;

    @ApiModelProperty("种苗数量")
    private Integer mainThrustNum;
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

    @ApiModelProperty(value = "种苗信息")
    private List<OilTeaVarietMageGetVo> oilTeaVarietMageGetVos;

    @ApiModelProperty(value = "企业信息")
    private List<EntpAuthInfoVo> entpAuthInfoVos;


    public Integer getMainThrustNum() {
        return mainThrustNum;
    }

    public void setMainThrustNum(Integer mainThrustNum) {
        this.mainThrustNum = mainThrustNum;
    }

    public List<OilTeaVarietMageGetVo> getOilTeaVarietMageGetVos() {
        return oilTeaVarietMageGetVos;
    }

    public void setOilTeaVarietMageGetVos(List<OilTeaVarietMageGetVo> oilTeaVarietMageGetVos) {
        this.oilTeaVarietMageGetVos = oilTeaVarietMageGetVos;
    }

    public List<EntpAuthInfoVo> getEntpAuthInfoVos() {
        return entpAuthInfoVos;
    }

    public void setEntpAuthInfoVos(List<EntpAuthInfoVo> entpAuthInfoVos) {
        this.entpAuthInfoVos = entpAuthInfoVos;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取种苗目录名称
     */
    public String getSproutCatalogName() {
        return sproutCatalogName;
    }

    /**
     * 设置种苗目录名称
     */
    public void setSproutCatalogName(String sproutCatalogName) {
        this.sproutCatalogName = sproutCatalogName == null ? null : sproutCatalogName.trim();
    }

    /**
     * 获取年份
     */
    public Integer getSproutYear() {
        return sproutYear;
    }

    /**
     * 设置年份
     */
    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    /**
     * 获取油茶品种信息id
     */
    public Long getOilTeaVarietId() {
        return oilTeaVarietId;
    }

    /**
     * 设置油茶品种信息id
     */
    public void setOilTeaVarietId(Long oilTeaVarietId) {
        this.oilTeaVarietId = oilTeaVarietId;
    }

    /**
     * 获取选育单位
     */
    public String getBreedEntp() {
        return breedEntp;
    }

    /**
     * 设置选育单位
     */
    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp == null ? null : breedEntp.trim();
    }

    /**
     * 获取种苗目录状态类型
     */
    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    /**
     * 设置种苗目录状态类型
     */
    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType == null ? null : sproutCatalogStateType.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
