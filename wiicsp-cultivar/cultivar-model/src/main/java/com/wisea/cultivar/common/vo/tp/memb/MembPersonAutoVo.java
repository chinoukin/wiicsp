package com.wisea.cultivar.common.vo.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 会员个人信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月17日
 * @version 1.0
 */
@ApiModel("会员个人审核信息VO")
public class MembPersonAutoVo {

	@ApiModelProperty(value="Id")
	private Long id;
	/**
     * 会员id
     */
	@ApiModelProperty(value="会员Id")
    private Long membId;

    /**
     * 姓名
     */
	@ApiModelProperty(value="姓名")
    private String name;

    /**
     * 性别类型
     */
	@ApiModelProperty(value="性别类型(0:未知1:男2:女)")
    private String sexType = "1";

    /**
     * 身份证号
     */
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
	@ApiModelProperty(value="联系人手机")
    private String tel;

    /**
     * 身份证正面url
     */
	@ApiModelProperty(value="身份证正面图片地址")
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
	@ApiModelProperty(value="身份证反面图片地址")
    private String sfzFmUrl;

    /**
     * 手持身份证url
     */
	@ApiModelProperty(value="手持身份证图片地址")
    private String sfzScUrl;
	 /**
     * 认证审核状态
     */
	@ApiModelProperty(value="认证审核状态")
    private String authExamState;

    /**
     * 审核未通过原因
     */
	@ApiModelProperty(value="审核未通过原因")
    private String examFailReason;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="申请时间")
	private OffsetDateTime updateDate;
	@ApiModelProperty(value = "注册信息")

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

	public String getAuthExamState() {
		return authExamState;
	}

	public void setAuthExamState(String authExamState) {
		this.authExamState = authExamState;
	}

	public String getExamFailReason() {
		return examFailReason;
	}

	public void setExamFailReason(String examFailReason) {
		this.examFailReason = examFailReason;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getTermValidityDate() {
		return termValidityDate;
	}

	public void setTermValidityDate(OffsetDateTime termValidityDate) {
		this.termValidityDate = termValidityDate;
	}
}
