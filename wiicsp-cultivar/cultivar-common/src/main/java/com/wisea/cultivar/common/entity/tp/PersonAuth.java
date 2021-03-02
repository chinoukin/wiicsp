package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

public class PersonAuth extends DataLongEntity<PersonAuth> {
    /**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年7月3日
	 * @version 1.0
	 */
	private static final long serialVersionUID = 6853005345216789831L;

	/**
     * 会员id
     */
    private Long membId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别类型
     */
    private String sexType;

    /**
     * 身份证号
     */
    private String idCardNum;

    /**
     * 身份证有效期至
     */
    private OffsetDateTime termValidityDate;

    /**
     * 联系手机
     */
    private String tel;

    /**
     * 身份证正面url
     */
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
    private String sfzFmUrl;

    /**
     * 手持身份证url
     */
    private String sfzScUrl;

    /**
     * 认证审核状态
     */
    private String authExamState;

    /**
     * 审核未通过原因
     */
    private String examFailReason;

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
}
