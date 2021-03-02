package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * VarietiesMageListVo
 * 2019/12/03 14:35:19
 */
public class VarietiesMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 物料编码
     */
    @ApiModelProperty(value = "物料编码")
    @ExcelField(title = "物料编码",sort = 1)
    private String varietiesNum;

    /**
     * 物料名称
     */
    @ApiModelProperty(value = "物料名称")
    @ExcelField(title = "物料名称",sort = 2)
    private String varietiesName;

    /**
     * 品类id（物料分类）
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品类id（物料分类）")
    private Long categoryId;


    @ApiModelProperty(value = "物料分类")
    @ExcelField(title = "物料分类",sort = 3)
    private String categoryName;

    /**
     * 规格
     */
    @ApiModelProperty(value = "规格")
    @ExcelField(title = "规格",sort = 4)
    private String spec;

    /**
     * 型号
     */
    @ApiModelProperty(value = "型号")
    @ExcelField(title = "型号",sort = 5)
    private String modelNum;

    /**
     * 主计量单位
     */
    @ApiModelProperty(value = "主计量单位")
    @ExcelField(title = "主计量单位",sort = 6)
    private String mainUnit;

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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
