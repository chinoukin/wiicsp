package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MembInfoListPo
 * 2018/09/18 14:36:47
 */
public class MembInfoListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员名称
     */
    @ApiModelProperty(value = "会员名称")
    private String membName;

    /**
     * 头像url
     */
    @ApiModelProperty(value = "头像url")
    private String url;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    private String position;

    /**
     * 性别类型
     */
    @ApiModelProperty(value = "性别类型")
    private String sexType;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String contacts;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String tel;

    /**
     * 所在地区
     */
    @ApiModelProperty(value = "所在地区")
    private String address;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    /**
     * 注册时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    /**
     * 会员状态
     */
    @ApiModelProperty(value = "会员状态")
    private String membState;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
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
     * 获取会员名称
     */
    public String getMembName() {
        return membName;
    }

    /**
     * 设置会员名称
     */
    public void setMembName(String membName) {
        this.membName = membName == null ? null : membName.trim();
    }

    /**
     * 获取头像url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置头像url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取性别类型
     */
    public String getSexType() {
        return sexType;
    }

    /**
     * 设置性别类型
     */
    public void setSexType(String sexType) {
        this.sexType = sexType == null ? null : sexType.trim();
    }

    /**
     * 获取联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取联系方式
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系方式
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取所在地区
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置所在地区
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取详细地址
     */
    public String getDetailAddress() {
        return detailAddress;
    }

    /**
     * 设置详细地址
     */
    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress == null ? null : detailAddress.trim();
    }

    /**
     * 获取注册手机号
     */
    public String getRegistTel() {
        return registTel;
    }

    /**
     * 设置注册手机号
     */
    public void setRegistTel(String registTel) {
        this.registTel = registTel == null ? null : registTel.trim();
    }

    /**
     * 获取注册时间
     */
    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    /**
     * 设置注册时间
     */
    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    /**
     * 获取会员状态
     */
    public String getMembState() {
        return membState;
    }

    /**
     * 设置会员状态
     */
    public void setMembState(String membState) {
        this.membState = membState == null ? null : membState.trim();
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
     * 获取删除标志
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
