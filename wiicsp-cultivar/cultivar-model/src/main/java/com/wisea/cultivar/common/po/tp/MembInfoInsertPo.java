package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * MembInfoInsertPo
 * 2018/09/18 14:36:47
 */
public class MembInfoInsertPo {
    /**
     * 会员名称
     */
    @Check(test = { "maxLength","required"}, mixLength = 100)
    @ApiModelProperty(value = "会员名称(包含：企业用户名称、个人用户姓名)")
    private String membName;

    /**
     * 头像url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "头像url")
    private String url;
    /**
     * 职位
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "职位")
    private String position;

    /**
     * 性别类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "性别类型")
    private String sexType;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 50)
    @ApiModelProperty(value = "联系人")
    private String contacts;

    /**
     * 联系方式
     */
    @Check(test = { "maxLength" }, mixLength = 50)
    @ApiModelProperty(value = "联系方式")
    private String tel;

    /**
     * 所在地区
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "所在地区")
    private String address;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址")
    private String detailAddress;

    /**
     * 注册手机号
     */
    @Check(test = { "maxLength","required"}, mixLength = 32)
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
    @Check(test = { "maxLength","required"}, mixLength = 5)
    @ApiModelProperty(value = "会员状态")
    private String membState;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;
	/**
	 * 手机验证码
	 */
    @Check(test = {"required"})
    @ApiModelProperty(value = "手机验证码")
    private String mobileCode;
    /**
	 * 密码
	 */
    @Check(test = {"required"})
    @ApiModelProperty(value = "密码")
    private String password;

}
