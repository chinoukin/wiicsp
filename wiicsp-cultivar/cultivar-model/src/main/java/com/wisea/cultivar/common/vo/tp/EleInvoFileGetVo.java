package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * EleInvoFileGetVo
 * 2018/10/10 16:17:18
 */
public class EleInvoFileGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 订单发票id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单发票id")
    private Long ordInvoId;

    /**
     * 电子发票url
     */
    @ApiModelProperty(value = "电子发票url")
    private String eleInvoUrl;

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
     * 获取订单发票id
     */
    public Long getOrdInvoId() {
        return ordInvoId;
    }

    /**
     * 设置订单发票id
     */
    public void setOrdInvoId(Long ordInvoId) {
        this.ordInvoId = ordInvoId;
    }

    /**
     * 获取电子发票url
     */
    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    /**
     * 设置电子发票url
     */
    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl == null ? null : eleInvoUrl.trim();
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
