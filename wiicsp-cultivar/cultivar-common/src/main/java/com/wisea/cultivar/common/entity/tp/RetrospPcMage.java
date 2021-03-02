package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class RetrospPcMage extends DataLongEntity<RetrospPcMage> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 批次号
     */
    private String retrospPcNum;

    /**
     * 追溯批次名称
     */
    private String retrospPcName;

    /**
     * 商品id(所属分类)
     */
    private Long commId;

    /**
     * 所属分类
     */
    private String commName;

    /**
     * 产品名称
     */
    private String prdutName;

    /**
     * 产地
     */
    private String placeOrigin;

    /**
     * 申请数量
     */
    private Integer applSl;

    /**
     * 追溯信息模板
     */
    private String currencyRetrospTemplate;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getRetrospPcNum() {
        return retrospPcNum;
    }

    public void setRetrospPcNum(String retrospPcNum) {
        this.retrospPcNum = retrospPcNum;
    }

    public String getRetrospPcName() {
        return retrospPcName;
    }

    public void setRetrospPcName(String retrospPcName) {
        this.retrospPcName = retrospPcName;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getPrdutName() {
        return prdutName;
    }

    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public Integer getApplSl() {
        return applSl;
    }

    public void setApplSl(Integer applSl) {
        this.applSl = applSl;
    }

    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate;
    }
}
