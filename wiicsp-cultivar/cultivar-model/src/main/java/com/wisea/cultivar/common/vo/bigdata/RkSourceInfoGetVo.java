package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * RkSourceInfoGetVo
 * 2019/12/02 11:02:15
 */
public class RkSourceInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 货源类型
     */
    @ApiModelProperty(value = "货源类型")
    private String sourceType;

    /**
     * 子公司名称
     */
    @ApiModelProperty(value = "子公司名称")
    private String subEntpName;

    /**
     * 品类名称
     */
    @ApiModelProperty(value = "品类名称")
    private String varitName;

    /**
     * 总入库
     */
    @ApiModelProperty(value = "总入库")
    private String zrk;

    /**
     * 当前库存
     */
    @ApiModelProperty(value = "当前库存")
    private String dqkc;

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
