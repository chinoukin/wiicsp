package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class MembInfo extends DataLongEntity<MembInfo> {
    /**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月9日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -4028020791137779815L;

	/**
     * logo_url
     */
    private String logoUrl;

    /**
     * 注册手机号
     */
    private String registTel;

    /**
     * 昵称
     */
    private String petName;

    /**
     * 姓名
     */
    private String contName;

    /**
     * 登陆用户名
     */
    private String loginName;

    /**
     * 职位
     */
    private String position;

    /**
     * 性别类型
     */
    private String sexType;

    /**
     * 个性签名
     */
    private String autograph;

    /**
     * 意见反馈
     */
    private String feedBack;

    /**
     * 绑定微信
     */
    private String bindWechat;

    /**
     * 介绍信息
     */
    private String signature;

    /**
     * 会员类型
     */
    private String membType;

    /**
     * 注册时间
     */
    private OffsetDateTime registDate;

    /**
     * 账户状态
     */
    private String acctState;

    /**
     * 是否商家
     */
    private String agentFlag;
    /**
     * 商户编号
     */
    private String merchantNo;
    /**
     * 是否设置用户名(0:是1：否)
     */
    private String loginNameSetFlag;
    /**
     * 是否设置密码(0:是1：否)
     */
    private String passwordSetFlag;
    /**
     * 账期开通标记(0:是1：否)
     */
    private String apFlag;
    /**
     * 已经认证的个人/个体户或者企业的名称(优先级顺序：个人<个体化<企业)
     */
    private String entpName;
    /**
     * 认证状态(0：已认证1：未认证)
     */
    private String entpAuthStateType;
    /**
     * 是否是产地会员（0是产地会员  0以外的情况不是产地会员）
     */
    private String localityMembType;

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public String getBindWechat() {
        return bindWechat;
    }

    public void setBindWechat(String bindWechat) {
        this.bindWechat = bindWechat;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getLoginNameSetFlag() {
		return loginNameSetFlag;
	}

	public void setLoginNameSetFlag(String loginNameSetFlag) {
		this.loginNameSetFlag = loginNameSetFlag;
	}

	public String getPasswordSetFlag() {
		return passwordSetFlag;
	}

	public void setPasswordSetFlag(String passwordSetFlag) {
		this.passwordSetFlag = passwordSetFlag;
	}

    public String getApFlag() {
        return apFlag;
    }

    public void setApFlag(String apFlag) {
        this.apFlag = apFlag;
    }

    /**
     * 已经认证的个人/个体户或者企业的名称(优先级顺序：个人<个体化<企业)
     */
	public String getEntpName() {
		return entpName;
	}
	/**
     * 已经认证的个人/个体户或者企业的名称(优先级顺序：个人<个体化<企业)
     */
	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}

	public String getLocalityMembType() {
		return localityMembType;
	}

	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}
}
