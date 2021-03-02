package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * DeliveryInfoWhListPo
 * 2019/12/02 11:02:14
 */
public class DeliveryInfoWhListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "分公司id")
    private Long subEntpId;

    /**
     * 待处理订单
     */
    @ApiModelProperty(value = "待处理订单")
    private Integer dcl;

    /**
     * 打包中订单
     */
    @ApiModelProperty(value = "打包中订单")
    private Integer dbz;

    /**
     * 配送中订单
     */
    @ApiModelProperty(value = "配送中订单")
    private Integer psz;

    /**
     * 已签收订单
     */
    @ApiModelProperty(value = "已签收订单")
    private Integer yqs;

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
     * 获取分公司id
     */
    public Long getSubEntpId() {
        return subEntpId;
    }

    /**
     * 设置分公司id
     */
    public void setSubEntpId(Long subEntpId) {
        this.subEntpId = subEntpId;
    }

    /**
     * 获取待处理订单
     */
    public Integer getDcl() {
        return dcl;
    }

    /**
     * 设置待处理订单
     */
    public void setDcl(Integer dcl) {
        this.dcl = dcl;
    }

    /**
     * 获取打包中订单
     */
    public Integer getDbz() {
        return dbz;
    }

    /**
     * 设置打包中订单
     */
    public void setDbz(Integer dbz) {
        this.dbz = dbz;
    }

    /**
     * 获取配送中订单
     */
    public Integer getPsz() {
        return psz;
    }

    /**
     * 设置配送中订单
     */
    public void setPsz(Integer psz) {
        this.psz = psz;
    }

    /**
     * 获取已签收订单
     */
    public Integer getYqs() {
        return yqs;
    }

    /**
     * 设置已签收订单
     */
    public void setYqs(Integer yqs) {
        this.yqs = yqs;
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
