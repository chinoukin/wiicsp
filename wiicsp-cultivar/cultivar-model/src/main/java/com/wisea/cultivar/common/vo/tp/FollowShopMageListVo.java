package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FollowShopMageListVo
 * 2019/12/24 11:10:18
 */
public class FollowShopMageListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "店铺id")
    private Long shopInfoMageId;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖家id")
    private Long sellerId;

    @ApiModelProperty(value = "企业名称")
    private String compName;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "电话")
    private String bdTel;

    @ApiModelProperty(value = "邮箱")
    private String contactsEmail;

    @ApiModelProperty(value = "电话")
    private String prov;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "县区")
    private String cou;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "备注")
    private String remarks;

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
     * 获取店铺id
     */
    public Long getShopInfoMageId() {
        return shopInfoMageId;
    }

    /**
     * 设置店铺id
     */
    public void setShopInfoMageId(Long shopInfoMageId) {
        this.shopInfoMageId = shopInfoMageId;
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getBdTel() {
        return bdTel;
    }

    public void setBdTel(String bdTel) {
        this.bdTel = bdTel;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCou() {
        return cou;
    }

    public void setCou(String cou) {
        this.cou = cou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
