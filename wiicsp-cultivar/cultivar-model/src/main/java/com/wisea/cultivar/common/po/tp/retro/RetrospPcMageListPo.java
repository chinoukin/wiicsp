package com.wisea.cultivar.common.po.tp.retro;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * RetrospPcMageListPo
 * 2019/12/20 14:20:02
 */
public class RetrospPcMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 批次号
     */
    @ApiModelProperty(value = "批次号")
    private String retrospPcNum;

    /**
     * 追溯批次名称
     */
    @ApiModelProperty(value = "追溯批次名称")
    private String retrospPcName;

    /**
     * 商品id(所属分类)
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id(所属分类)")
    private Long commId;

    /**
     * 所属分类
     */
    @ApiModelProperty(value = "所属分类")
    private String commName;

    /**
     * 产品名称
     */
    @ApiModelProperty(value = "产品名称")
    private String prdutName;

    /**
     * 产地
     */
    @ApiModelProperty(value = "产地")
    private String placeOrigin;

    /**
     * 申请数量
     */
    @ApiModelProperty(value = "申请数量")
    private Integer applSl;

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
     * 追溯信息模板
     */
    @ApiModelProperty(value = "追溯信息模板")
    private String currencyRetrospTemplate;

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
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取批次号
     */
    public String getRetrospPcNum() {
        return retrospPcNum;
    }

    /**
     * 设置批次号
     */
    public void setRetrospPcNum(String retrospPcNum) {
        this.retrospPcNum = retrospPcNum == null ? null : retrospPcNum.trim();
    }

    /**
     * 获取追溯批次名称
     */
    public String getRetrospPcName() {
        return retrospPcName;
    }

    /**
     * 设置追溯批次名称
     */
    public void setRetrospPcName(String retrospPcName) {
        this.retrospPcName = retrospPcName == null ? null : retrospPcName.trim();
    }

    /**
     * 获取商品id(所属分类)
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id(所属分类)
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取所属分类
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置所属分类
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取产品名称
     */
    public String getPrdutName() {
        return prdutName;
    }

    /**
     * 设置产品名称
     */
    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName == null ? null : prdutName.trim();
    }

    /**
     * 获取产地
     */
    public String getPlaceOrigin() {
        return placeOrigin;
    }

    /**
     * 设置产地
     */
    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin == null ? null : placeOrigin.trim();
    }

    /**
     * 获取申请数量
     */
    public Integer getApplSl() {
        return applSl;
    }

    /**
     * 设置申请数量
     */
    public void setApplSl(Integer applSl) {
        this.applSl = applSl;
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

    /**
     * 获取追溯信息模板
     */
    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    /**
     * 设置追溯信息模板
     */
    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate == null ? null : currencyRetrospTemplate.trim();
    }
}
