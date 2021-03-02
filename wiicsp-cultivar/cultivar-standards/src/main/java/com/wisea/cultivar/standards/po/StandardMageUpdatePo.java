package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * StandardMageUpdatePo
 * 2020/07/24 11:21:45
 */
public class StandardMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 种植采收加工标准类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "种植采收加工标准类型", allowableValues = "mixLength:(,5]")
    private String plantRecoProcessType;

    /**
     * 标准名称
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "标准名称", allowableValues = "mixLength:(,200]")
    private String plantStandardName;

    /**
     * 产品图片
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "产品图片", allowableValues = "mixLength:(,255]")
    private String prudtUrl;

    /**
     * 种植标准类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "种植标准类型", allowableValues = "mixLength:(,5]")
    private String plantType;

    /**
     * 摘要
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "摘要", allowableValues = "mixLength:(,255]")
    private String outline;

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


    @ApiModelProperty("标准详情")
    private List<PlantStandardDetailsInsertPo> plantStandardDetailsInsertPo;

    public List<PlantStandardDetailsInsertPo> getPlantStandardDetailsInsertPo() {
        return plantStandardDetailsInsertPo;
    }

    public void setPlantStandardDetailsInsertPo(List<PlantStandardDetailsInsertPo> plantStandardDetailsInsertPo) {
        this.plantStandardDetailsInsertPo = plantStandardDetailsInsertPo;
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
     * 获取种植采收加工标准类型
     */
    public String getPlantRecoProcessType() {
        return plantRecoProcessType;
    }

    /**
     * 设置种植采收加工标准类型
     */
    public void setPlantRecoProcessType(String plantRecoProcessType) {
        this.plantRecoProcessType = plantRecoProcessType == null ? null : plantRecoProcessType.trim();
    }

    /**
     * 获取标准名称
     */
    public String getPlantStandardName() {
        return plantStandardName;
    }

    /**
     * 设置标准名称
     */
    public void setPlantStandardName(String plantStandardName) {
        this.plantStandardName = plantStandardName == null ? null : plantStandardName.trim();
    }

    /**
     * 获取产品图片
     */
    public String getPrudtUrl() {
        return prudtUrl;
    }

    /**
     * 设置产品图片
     */
    public void setPrudtUrl(String prudtUrl) {
        this.prudtUrl = prudtUrl == null ? null : prudtUrl.trim();
    }

    /**
     * 获取种植标准类型
     */
    public String getPlantType() {
        return plantType;
    }

    /**
     * 设置种植标准类型
     */
    public void setPlantType(String plantType) {
        this.plantType = plantType == null ? null : plantType.trim();
    }

    /**
     * 获取摘要
     */
    public String getOutline() {
        return outline;
    }

    /**
     * 设置摘要
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
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
