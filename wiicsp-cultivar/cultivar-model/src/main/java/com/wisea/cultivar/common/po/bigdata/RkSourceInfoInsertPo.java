package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * RkSourceInfoInsertPo
 * 2019/12/02 11:02:15
 */
public class RkSourceInfoInsertPo {
    /**
     * 货源类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "货源类型", allowableValues = "mixLength:(,5]")
    private String sourceType;

    /**
     * 子公司名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "子公司名称", allowableValues = "mixLength:(,255]")
    private String subEntpName;

    /**
     * 品类名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "品类名称", allowableValues = "mixLength:(,255]")
    private String varitName;

    /**
     * 总入库
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "总入库", allowableValues = "mixLength:(,255]")
    private String zrk;

    /**
     * 当前库存
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "当前库存", allowableValues = "mixLength:(,255]")
    private String dqkc;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取货源类型
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置货源类型
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    /**
     * 获取子公司名称
     */
    public String getSubEntpName() {
        return subEntpName;
    }

    /**
     * 设置子公司名称
     */
    public void setSubEntpName(String subEntpName) {
        this.subEntpName = subEntpName == null ? null : subEntpName.trim();
    }

    /**
     * 获取品类名称
     */
    public String getVaritName() {
        return varitName;
    }

    /**
     * 设置品类名称
     */
    public void setVaritName(String varitName) {
        this.varitName = varitName == null ? null : varitName.trim();
    }

    /**
     * 获取总入库
     */
    public String getZrk() {
        return zrk;
    }

    /**
     * 设置总入库
     */
    public void setZrk(String zrk) {
        this.zrk = zrk == null ? null : zrk.trim();
    }

    /**
     * 获取当前库存
     */
    public String getDqkc() {
        return dqkc;
    }

    /**
     * 设置当前库存
     */
    public void setDqkc(String dqkc) {
        this.dqkc = dqkc == null ? null : dqkc.trim();
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
}
