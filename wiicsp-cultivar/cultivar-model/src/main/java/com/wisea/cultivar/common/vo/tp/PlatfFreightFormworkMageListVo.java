package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlatfFreightFormworkMageListVo
 * 2018/09/18 14:36:47
 */
public class PlatfFreightFormworkMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 物流公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "物流公司id")
    private Long logisticsCompId;

    /**
     * 发货地
     */
    @ApiModelProperty(value = "发货地")
    private String deliveryPlace;

    /**
     * 物流公司名称
     */
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;
    /**
     * 模板名称
     */
    @ApiModelProperty(value = "模板名称")
    private String freightFormworkName;

    /**
     * 支持配送区域数量
     */
    @ApiModelProperty(value = "支持配送区域数量")
    private Integer suptDistribAreaCount;

    /**
     * 不支持配送区域数量
     */
    @ApiModelProperty(value = "不支持配送区域数量")
    private Integer noDistribAreaCount;

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

    @ApiModelProperty(value = "运费模板内容列表")
    private List<PlatfFreightSetListVo> platfFreightSetListVos;

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public List<PlatfFreightSetListVo> getPlatfFreightSetListVos() {
        return platfFreightSetListVos;
    }

    public void setPlatfFreightSetListVos(List<PlatfFreightSetListVo> platfFreightSetListVos) {
        this.platfFreightSetListVos = platfFreightSetListVos;
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
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
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
