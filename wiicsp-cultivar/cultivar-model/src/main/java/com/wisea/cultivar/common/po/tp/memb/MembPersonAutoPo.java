package com.wisea.cultivar.common.po.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 会员个人认证信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月17日
 * @version 1.0
 */
@ApiModel("会员个人认证信息PO")
public class MembPersonAutoPo {

	 /**
     * 会员id
     */
	@ApiModelProperty(value="会员Id",hidden=true)
    private Long membId;

    /**
     * 姓名
     */
	@Check(test = { "maxLength","required"}, mixLength = 30)
	@ApiModelProperty(value="姓名")
    private String name;

    /**
     * 性别类型
     */
	@Check(test = {"required", "liveable"}, liveable = {"1", "2"}, liveableMsg = "性别类型只能为1或者2")
	@ApiModelProperty(value="性别类型(0:未知1:男2:女)")
    private String sexType;

    /**
     * 身份证号
     */
	@Check(test = {"required"})
	@ApiModelProperty(value="身份证号")
    private String idCardNum;

    /**
     * 身份证有效期至
     */
	@ApiModelProperty(value="身份证有效期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime termValidityDate;

    /**
     * 联系手机
     */
	@Check(test = {"required"})
	@ApiModelProperty(value="联系人手机")
    private String tel;

    /**
     * 身份证正面url
     */
	@Check(test = {"required"})
	@ApiModelProperty(value="身份证正面图片地址")
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
	@Check(test = {"required"})
	@ApiModelProperty(value="身份证反面图片地址")
    private String sfzFmUrl;

    /**
     * 手持身份证url
     */
	@Check(test = {"required"})
	@ApiModelProperty(value="手持身份证图片地址")
    private String sfzScUrl;

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexType() {
		return sexType;
	}

	public void setSexType(String sexType) {
		this.sexType = sexType;
	}

	public String getIdCardNum() {
		return idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	public OffsetDateTime getTermValidityDate() {
		return termValidityDate;
	}

	public void setTermValidityDate(OffsetDateTime termValidityDate) {
		this.termValidityDate = termValidityDate;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSfzZmUrl() {
		return sfzZmUrl;
	}

	public void setSfzZmUrl(String sfzZmUrl) {
		this.sfzZmUrl = sfzZmUrl;
	}

	public String getSfzFmUrl() {
		return sfzFmUrl;
	}

	public void setSfzFmUrl(String sfzFmUrl) {
		this.sfzFmUrl = sfzFmUrl;
	}

	public String getSfzScUrl() {
		return sfzScUrl;
	}

	public void setSfzScUrl(String sfzScUrl) {
		this.sfzScUrl = sfzScUrl;
	}
}
