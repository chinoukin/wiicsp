package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlatfFreightSetInsertPo
 * 2018/09/26 13:46:55
 */
public class PlatfFreightSetInsertPo {
    /**
     * 运费模板_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "运费模板_id")
    private Long freightFormworkId;

    /**
     * 支持配送区域类型
     */
    @ApiModelProperty("配送地区类型")
    @Check(test = { "required" },requiredMsg = "配送地区的类型不能为空")
    private String suptDistribAreaType;

    /**
     * 计价方式
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "计价方式,0表示按件，1表示按重量，默认为0")
    private String valuaType = "0";

    /**
     * 初始件数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "初始件数")
    private Integer startCount;

    /**
     * 初始重量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "初始重量")
    private Double startWeight;

    /**
     * 运费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "运费")
    private Double freight;

    /**
     * 增加件数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "增加件数")
    private Integer moreCount;

    /**
     * 增加重量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "增加重量")
    private Double moreWeight;

    /**
     * 增加运费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "增加运费")
    private Double moreFreight;

    /**
     * 支持配送区域
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "支持配送区域，使用中文，以英文分号间隔\";\"")
    private String suptDistribArea;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取运费模板_id
     */
    public Long getFreightFormworkId() {
        return freightFormworkId;
    }

    /**
     * 设置运费模板_id
     */
    public void setFreightFormworkId(Long freightFormworkId) {
        this.freightFormworkId = freightFormworkId;
    }

    /**
     * 获取计价方式
     */
    public String getValuaType() {
        return valuaType;
    }

    /**
     * 设置计价方式
     */
    public void setValuaType(String valuaType) {
        this.valuaType = valuaType == null ? null : valuaType.trim();
    }

    /**
     * 获取初始件数
     */
    public Integer getStartCount() {
        return startCount;
    }

    /**
     * 设置初始件数
     */
    public void setStartCount(Integer startCount) {
        this.startCount = startCount;
    }

    /**
     * 获取初始重量
     */
    public Double getStartWeight() {
        return startWeight;
    }

    /**
     * 设置初始重量
     */
    public void setStartWeight(Double startWeight) {
        this.startWeight = startWeight;
    }

    /**
     * 获取运费
     */
    public Double getFreight() {
        return freight;
    }

    /**
     * 设置运费
     */
    public void setFreight(Double freight) {
        this.freight = freight;
    }

    /**
     * 获取增加件数
     */
    public Integer getMoreCount() {
        return moreCount;
    }

    /**
     * 设置增加件数
     */
    public void setMoreCount(Integer moreCount) {
        this.moreCount = moreCount;
    }

    /**
     * 获取增加重量
     */
    public Double getMoreWeight() {
        return moreWeight;
    }

    /**
     * 设置增加重量
     */
    public void setMoreWeight(Double moreWeight) {
        this.moreWeight = moreWeight;
    }

    /**
     * 获取增加运费
     */
    public Double getMoreFreight() {
        return moreFreight;
    }

    /**
     * 设置增加运费
     */
    public void setMoreFreight(Double moreFreight) {
        this.moreFreight = moreFreight;
    }

    /**
     * 获取支持配送区域
     */
    public String getSuptDistribArea() {
        return suptDistribArea;
    }

    /**
     * 设置支持配送区域
     */
    public void setSuptDistribArea(String suptDistribArea) {
        this.suptDistribArea = suptDistribArea == null ? null : suptDistribArea.trim();
    }

    public String getSuptDistribAreaType() {
        return suptDistribAreaType;
    }

    public void setSuptDistribAreaType(String suptDistribAreaType) {
        this.suptDistribAreaType = suptDistribAreaType;
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
