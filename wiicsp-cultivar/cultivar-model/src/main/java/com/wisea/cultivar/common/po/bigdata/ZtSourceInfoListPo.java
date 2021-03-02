package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZtSourceInfoListPo
 * 2019/12/02 11:02:15
 */
public class ZtSourceInfoListPo {
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
     * 品类名称
     */
    @ApiModelProperty(value = "品类名称")
    private String varitName;

    /**
     * 订单总数
     */
    @ApiModelProperty(value = "订单总数")
    private String ordZs;

    /**
     * 订单总量
     */
    @ApiModelProperty(value = "订单总量")
    private String ordZl;

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
     * 获取订单总数
     */
    public String getOrdZs() {
        return ordZs;
    }

    /**
     * 设置订单总数
     */
    public void setOrdZs(String ordZs) {
        this.ordZs = ordZs == null ? null : ordZs.trim();
    }

    /**
     * 获取订单总量
     */
    public String getOrdZl() {
        return ordZl;
    }

    /**
     * 设置订单总量
     */
    public void setOrdZl(String ordZl) {
        this.ordZl = ordZl == null ? null : ordZl.trim();
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
