package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlatfFreightFormworkMageInsertPo
 * 2018/09/18 14:36:47
 */
public class PlatfFreightFormworkMageInsertPo {
    /**
     * 物流公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength","required" }, length = 19)
    @ApiModelProperty(value = "物流公司id")
    private Long logisticsCompId;

    /**
     * 模板名称
     */
    @Check(test = { "maxLength","required" }, mixLength = 255)
    @ApiModelProperty(value = "模板名称")
    private String freightFormworkName;

    @ApiModelProperty("发货地")
    private String deliveryPlace;

    /**
     * 支持配送区域数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "支持配送区域数量")
    private Integer suptDistribAreaCount;

    /**
     * 不支持配送区域数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "不支持配送区域数量")
    private Integer noDistribAreaCount;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "运费模板内容List")
    private List<PlatfFreightSetInsertPo> platfFreightSetInsertPos;

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public List<PlatfFreightSetInsertPo> getPlatfFreightSetInsertPos() {
        return platfFreightSetInsertPos;
    }

    public void setPlatfFreightSetInsertPos(List<PlatfFreightSetInsertPo> platfFreightSetInsertPos) {
        this.platfFreightSetInsertPos = platfFreightSetInsertPos;
    }

    /**
     * 获取物流公司id
     */
    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    /**
     * 设置物流公司id
     */
    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
    }

    /**
     * 获取模板名称
     */
    public String getFreightFormworkName() {
        return freightFormworkName;
    }

    /**
     * 设置模板名称
     */
    public void setFreightFormworkName(String freightFormworkName) {
        this.freightFormworkName = freightFormworkName == null ? null : freightFormworkName.trim();
    }

    /**
     * 获取支持配送区域数量
     */
    public Integer getSuptDistribAreaCount() {
        return suptDistribAreaCount;
    }

    /**
     * 设置支持配送区域数量
     */
    public void setSuptDistribAreaCount(Integer suptDistribAreaCount) {
        this.suptDistribAreaCount = suptDistribAreaCount;
    }

    /**
     * 获取不支持配送区域数量
     */
    public Integer getNoDistribAreaCount() {
        return noDistribAreaCount;
    }

    /**
     * 设置不支持配送区域数量
     */
    public void setNoDistribAreaCount(Integer noDistribAreaCount) {
        this.noDistribAreaCount = noDistribAreaCount;
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
