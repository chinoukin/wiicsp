package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * LockSourceInfoListPo
 * 2019/12/02 11:02:14
 */
public class LockSourceInfoListPo {
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
     * 产地地址
     */
    @ApiModelProperty(value = "产地地址")
    private String placeOriginAddress;

    /**
     * 品类名称
     */
    @ApiModelProperty(value = "品类名称")
    private String varitName;

    /**
     * 合约数量
     */
    @ApiModelProperty(value = "合约数量")
    private String hysl;

    /**
     * 预计货源
     */
    @ApiModelProperty(value = "预计货源")
    private String yjhy;

    /**
     * 剩余有效货源
     */
    @ApiModelProperty(value = "剩余有效货源")
    private String syyxhy;

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
     * 获取产地地址
     */
    public String getPlaceOriginAddress() {
        return placeOriginAddress;
    }

    /**
     * 设置产地地址
     */
    public void setPlaceOriginAddress(String placeOriginAddress) {
        this.placeOriginAddress = placeOriginAddress == null ? null : placeOriginAddress.trim();
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
     * 获取合约数量
     */
    public String getHysl() {
        return hysl;
    }

    /**
     * 设置合约数量
     */
    public void setHysl(String hysl) {
        this.hysl = hysl == null ? null : hysl.trim();
    }

    /**
     * 获取预计货源
     */
    public String getYjhy() {
        return yjhy;
    }

    /**
     * 设置预计货源
     */
    public void setYjhy(String yjhy) {
        this.yjhy = yjhy == null ? null : yjhy.trim();
    }

    /**
     * 获取剩余有效货源
     */
    public String getSyyxhy() {
        return syyxhy;
    }

    /**
     * 设置剩余有效货源
     */
    public void setSyyxhy(String syyxhy) {
        this.syyxhy = syyxhy == null ? null : syyxhy.trim();
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
