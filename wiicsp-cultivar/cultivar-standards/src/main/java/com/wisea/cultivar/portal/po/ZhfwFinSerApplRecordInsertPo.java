package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * ZhfwFinSerApplRecordInsertPo
 * 2020/08/24 20:28:13
 */
public class ZhfwFinSerApplRecordInsertPo {
    /**
     * 姓名
     */
    @Check(test = { "required","maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "姓名", allowableValues = "mixLength:(,32]")
    private String name;

    /**
     * 手机号
     */
    @Check(test = { "required","regex" }, regex = "^[0-9]{11}$")
    @ApiModelProperty(value = "手机号")
    private String tel;

    /**
     * 申报内容
     */
    @Check(test = { "required","maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "申报内容", allowableValues = "mixLength:(,255]")
    private String content;

    /**
     * 邮箱
     */
    @Check(test = { "maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "邮箱", allowableValues = "mixLength:(,32]")
    private String email;

    /**
     * 提交日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "提交日期")
    private OffsetDateTime applDate;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取申报内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置申报内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取提交日期
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置提交日期
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
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
