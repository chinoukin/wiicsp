package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 商家资料信息
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月17日
 * @version 1.0
 */
public class EntpDataInfo extends DataLongEntity<EntpDataInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 企业名称
     */
    private String compName;

    /**
     * 企业简称
     */
    private String compShortName;

    /**
     * 统一社会信用代码
     */
    private String ctscc;

    /**
     * 营业执照url
     */
    private String yyzzUrl;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 绑定手机
     */
    private String bdTel;

    /**
     * 邮箱地址
     */
    private String contactsEmail;

    /**
     * 注册地址省
     */
    private String registAddressProv;

    /**
     * 注册地址市
     */
    private String registAddressCity;

    /**
     * 注册地址区县
     */
    private String registAddressCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 法人代表
     */
    private String legalPerson;

    /**
     * 法人身份证号
     */
    private String legalPersonNum;

    /**
     * 身份证正面url
     */
    private String sfzZmUrl;

    /**
     * 身份证反面url
     */
    private String sfzFmUrl;

    /**
     * 认证审核状态
     */
    private String authExamState;

    /**
     * 审核未通过原因
     */
    private String examFailReason;

    /**
     * 企业邮箱
     */
    private String compEmail;

    /**
     * 企业银行卡号
     */
    private String entpBankNum;

    /**
     * 开户行
     */
    private String openBank;

    /**
     * 注册资本
     */
    private Double registCapital;

    /**
     * 成立日期
     */
    private OffsetDateTime estaDate;

    /**
     * 登记机关
     */
    private String registAuth;

    /**
     * 企业类型
     */
    private String compType;

    /**
     * 营业期限类型
     */
    private String businessTermType;

    /**
     * 营业开始日期
     */
    private OffsetDateTime businessStartDate;

    /**
     * 营业结束日期
     */
    private OffsetDateTime businessEndDate;

    /**
     * 经营范围
     */
    private String operateRange;

    /**
     * 企业电话
     */
    private String compTel;

    /**
     * 企业微博地址
     */
    private String compMicroBlog;

    /**
     * 企业介绍
     */
    private String compIntro;

    /**
     * 宣传联系人
     */
    private String propContacts;

    /**
     * 商户编号
     */
    @ApiModelProperty(value="商户编号",hidden=true)
    private String merchantNo;

    /**
     * 是否技术服务商标记
     */
    private String sfjsfwsFlag;

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

    public String getSfjsfwsFlag() {
		return sfjsfwsFlag;
	}

	public void setSfjsfwsFlag(String sfjsfwsFlag) {
		this.sfjsfwsFlag = sfjsfwsFlag;
	}

	/**
     * 获取企业名称
     */
    public String getCompName() {
        return compName;
    }

    /**
     * 设置企业名称
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    /**
     * 获取注册地址省
     */
    public String getRegistAddressProv() {
        return registAddressProv;
    }

    /**
     * 设置注册地址省
     */
    public void setRegistAddressProv(String registAddressProv) {
        this.registAddressProv = registAddressProv == null ? null : registAddressProv.trim();
    }

    /**
     * 获取注册地址市
     */
    public String getRegistAddressCity() {
        return registAddressCity;
    }

    /**
     * 设置注册地址市
     */
    public void setRegistAddressCity(String registAddressCity) {
        this.registAddressCity = registAddressCity == null ? null : registAddressCity.trim();
    }

    /**
     * 获取注册地址区县
     */
    public String getRegistAddressCou() {
        return registAddressCou;
    }

    /**
     * 设置注册地址区县
     */
    public void setRegistAddressCou(String registAddressCou) {
        this.registAddressCou = registAddressCou == null ? null : registAddressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取注册资本
     */
    public Double getRegistCapital() {
        return registCapital;
    }

    /**
     * 设置注册资本
     */
    public void setRegistCapital(Double registCapital) {
        this.registCapital = registCapital;
    }

    /**
     * 获取成立日期
     */
    public OffsetDateTime getEstaDate() {
        return estaDate;
    }

    /**
     * 设置成立日期
     */
    public void setEstaDate(OffsetDateTime estaDate) {
        this.estaDate = estaDate;
    }

    /**
     * 获取统一社会信用代码
     */
    public String getCtscc() {
        return ctscc;
    }

    /**
     * 设置统一社会信用代码
     */
    public void setCtscc(String ctscc) {
        this.ctscc = ctscc == null ? null : ctscc.trim();
    }

    /**
     * 获取企业银行卡号
     */
    public String getEntpBankNum() {
        return entpBankNum;
    }

    /**
     * 设置企业银行卡号
     */
    public void setEntpBankNum(String entpBankNum) {
        this.entpBankNum = entpBankNum == null ? null : entpBankNum.trim();
    }

    /**
     * 获取开户行
     */
    public String getOpenBank() {
        return openBank;
    }

    /**
     * 设置开户行
     */
    public void setOpenBank(String openBank) {
        this.openBank = openBank == null ? null : openBank.trim();
    }

    /**
     * 获取法人代表
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法人代表
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * 获取登记机关
     */
    public String getRegistAuth() {
        return registAuth;
    }

    /**
     * 设置登记机关
     */
    public void setRegistAuth(String registAuth) {
        this.registAuth = registAuth == null ? null : registAuth.trim();
    }

    /**
     * 获取企业类型
     */
    public String getCompType() {
        return compType;
    }

    /**
     * 设置企业类型
     */
    public void setCompType(String compType) {
        this.compType = compType == null ? null : compType.trim();
    }

    /**
     * 获取营业期限类型
     */
    public String getBusinessTermType() {
        return businessTermType;
    }

    /**
     * 设置营业期限类型
     */
    public void setBusinessTermType(String businessTermType) {
        this.businessTermType = businessTermType == null ? null : businessTermType.trim();
    }

    /**
     * 获取营业开始日期
     */
    public OffsetDateTime getBusinessStartDate() {
        return businessStartDate;
    }

    /**
     * 设置营业开始日期
     */
    public void setBusinessStartDate(OffsetDateTime businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    /**
     * 获取营业结束日期
     */
    public OffsetDateTime getBusinessEndDate() {
        return businessEndDate;
    }

    /**
     * 设置营业结束日期
     */
    public void setBusinessEndDate(OffsetDateTime businessEndDate) {
        this.businessEndDate = businessEndDate;
    }

    /**
     * 获取经营范围
     */
    public String getOperateRange() {
        return operateRange;
    }

    /**
     * 设置经营范围
     */
    public void setOperateRange(String operateRange) {
        this.operateRange = operateRange == null ? null : operateRange.trim();
    }

    /**
     * 获取企业邮箱
     */
    public String getCompEmail() {
        return compEmail;
    }

    /**
     * 设置企业邮箱
     */
    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail == null ? null : compEmail.trim();
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
     * 获取企业电话
     */
    public String getCompTel() {
        return compTel;
    }

    /**
     * 设置企业电话
     */
    public void setCompTel(String compTel) {
        this.compTel = compTel == null ? null : compTel.trim();
    }

    /**
     * 获取企业微博地址
     */
    public String getCompMicroBlog() {
        return compMicroBlog;
    }

    /**
     * 设置企业微博地址
     */
    public void setCompMicroBlog(String compMicroBlog) {
        this.compMicroBlog = compMicroBlog == null ? null : compMicroBlog.trim();
    }

    /**
     * 获取企业介绍
     */
    public String getCompIntro() {
        return compIntro;
    }

    /**
     * 设置企业介绍
     */
    public void setCompIntro(String compIntro) {
        this.compIntro = compIntro == null ? null : compIntro.trim();
    }

    /**
     * 获取认证审核状态
     */
    public String getAuthExamState() {
        return authExamState;
    }

    /**
     * 设置认证审核状态
     */
    public void setAuthExamState(String authExamState) {
        this.authExamState = authExamState == null ? null : authExamState.trim();
    }

    /**
     * 获取审核未通过原因
     */
    public String getExamFailReason() {
        return examFailReason;
    }

    /**
     * 设置审核未通过原因
     */
    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason == null ? null : examFailReason.trim();
    }

	public String getCompShortName() {
		return compShortName;
	}

	public void setCompShortName(String compShortName) {
		this.compShortName = compShortName;
	}

	public String getLegalPersonNum() {
		return legalPersonNum;
	}

	public void setLegalPersonNum(String legalPersonNum) {
		this.legalPersonNum = legalPersonNum;
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

	public String getYyzzUrl() {
		return yyzzUrl;
	}

	public void setYyzzUrl(String yyzzUrl) {
		this.yyzzUrl = yyzzUrl;
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

	public String getPropContacts() {
		return propContacts;
	}

	public void setPropContacts(String propContacts) {
		this.propContacts = propContacts;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
}
