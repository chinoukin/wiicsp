package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * MembInfoUpdatePo
 * 2019/12/02 11:02:14
 */
public class MembInfoUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 用户名
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "用户名", allowableValues = "mixLength:(,255]")
    private String userName;

    /**
     * 姓名
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "姓名", allowableValues = "mixLength:(,255]")
    private String xmName;

    /**
     * 部门名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "部门名称", allowableValues = "mixLength:(,255]")
    private String bmName;

    /**
     * 密码
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "密码", allowableValues = "mixLength:(,255]")
    private String password;

    /**
     * 权限类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "权限类型", allowableValues = "mixLength:(,5]")
    private String qxType;

    /**
     * 注册时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime zcDate;

    /**
     * 是否启用标志
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "是否启用标志,0:否 1:是", allowableValues = "mixLength:(,5]")
    private String sfqyFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
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
     * 获取姓名
     */
    public String getXmName() {
        return xmName;
    }

    /**
     * 设置姓名
     */
    public void setXmName(String xmName) {
        this.xmName = xmName == null ? null : xmName.trim();
    }

    /**
     * 获取部门名称
     */
    public String getBmName() {
        return bmName;
    }

    /**
     * 设置部门名称
     */
    public void setBmName(String bmName) {
        this.bmName = bmName == null ? null : bmName.trim();
    }

    /**
     * 获取密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取权限类型
     */
    public String getQxType() {
        return qxType;
    }

    /**
     * 设置权限类型
     */
    public void setQxType(String qxType) {
        this.qxType = qxType == null ? null : qxType.trim();
    }

    /**
     * 获取注册时间
     */
    public OffsetDateTime getZcDate() {
        return zcDate;
    }

    /**
     * 设置注册时间
     */
    public void setZcDate(OffsetDateTime zcDate) {
        this.zcDate = zcDate;
    }

    /**
     * 获取是否启用标志
     */
    public String getSfqyFlag() {
        return sfqyFlag;
    }

    /**
     * 设置是否启用标志
     */
    public void setSfqyFlag(String sfqyFlag) {
        this.sfqyFlag = sfqyFlag == null ? null : sfqyFlag.trim();
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
