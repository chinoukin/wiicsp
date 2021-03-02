package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * varieties_mage 表实体
 * 物料管理
 * 2019/12/03 14:35:19
 */
public class VarietiesMage extends DataLongEntity<VarietiesMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 物料编码
     */
    private String varietiesNum;

    /**
     * 物料名称
     */
    private String varietiesName;

    /**
     * 品类id（物料分类）
     */
    private Long categoryId;

    /**
     * 规格
     */
    private String spec;

    /**
     * 型号
     */
    private String modelNum;

    /**
     * 主计量单位
     */
    private String mainUnit;

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
}
