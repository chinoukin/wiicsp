package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * VarietiesMageUpdatePo
 * 2019/12/03 14:35:19
 */
public class VarietiesMageUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 物料编码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "物料编码", allowableValues = "mixLength:(,30]")
    private String varietiesNum;

    /**
     * 物料名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物料名称", allowableValues = "mixLength:(,255]")
    private String varietiesName;

    /**
     * 品类id（物料分类）
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "品类id（物料分类）", allowableValues = "length:(,19]")
    private Long categoryId;

    /**
     * 规格
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "规格", allowableValues = "mixLength:(,30]")
    private String spec;

    /**
     * 型号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "型号", allowableValues = "mixLength:(,30]")
    private String modelNum;

    /**
     * 主计量单位
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "主计量单位", allowableValues = "mixLength:(,30]")
    private String mainUnit;

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
     * 获取物料编码
     */
    public String getVarietiesNum() {
        return varietiesNum;
    }

    /**
     * 设置物料编码
     */
    public void setVarietiesNum(String varietiesNum) {
        this.varietiesNum = varietiesNum == null ? null : varietiesNum.trim();
    }

    /**
     * 获取物料名称
     */
    public String getVarietiesName() {
        return varietiesName;
    }

    /**
     * 设置物料名称
     */
    public void setVarietiesName(String varietiesName) {
        this.varietiesName = varietiesName == null ? null : varietiesName.trim();
    }

    /**
     * 获取品类id（物料分类）
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置品类id（物料分类）
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 获取规格
     */
    public String getSpec() {
        return spec;
    }

    /**
     * 设置规格
     */
    public void setSpec(String spec) {
        this.spec = spec == null ? null : spec.trim();
    }

    /**
     * 获取型号
     */
    public String getModelNum() {
        return modelNum;
    }

    /**
     * 设置型号
     */
    public void setModelNum(String modelNum) {
        this.modelNum = modelNum == null ? null : modelNum.trim();
    }

    /**
     * 获取主计量单位
     */
    public String getMainUnit() {
        return mainUnit;
    }

    /**
     * 设置主计量单位
     */
    public void setMainUnit(String mainUnit) {
        this.mainUnit = mainUnit == null ? null : mainUnit.trim();
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
