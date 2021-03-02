package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * memb_info 表实体
 * 会员信息
 * 2018/09/18 14:36:47
 */
public class MembInfo extends DataLongEntity<MembInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    /**
     * 注册时间
     */
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;
    /**
     * 联系人姓名
     */
    @ApiModelProperty(value = "联系人姓名")
    private String contactsName;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String compName;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 性别类型
     */
    @ApiModelProperty(value = "性别类型")
    private String sexType;

    /**
     * 固定电话
     */
    @ApiModelProperty(value = "固定电话")
    private String fixedTel;

    /**
     * 业务联系邮箱
     */
    @ApiModelProperty(value = "业务联系邮箱")
    private String contactsEmail;

    /**
     * 所在地区省
     */
    @ApiModelProperty(value = "所在地区省")
    private String areaProv;

    /**
     * 所在地区市
     */
    @ApiModelProperty(value = "所在地区市")
    private String areaCity;

    /**
     * 所在地区区县
     */
    @ApiModelProperty(value = "所在地区区县")
    private String areaCou;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 公司名称
     */
    @ApiModelProperty(value = "公司名称")
    private String entpName;

    /**
     * 公司类别类型
     */
    @ApiModelProperty(value = "公司类别类型")
    private String compCatgType;

    /**
     * 我的部门
     */
    @ApiModelProperty(value = "我的部门")
    private String myDept;

    /**
     * 我的职位
     */
    @ApiModelProperty(value = "我的职位")
    private String myPosition;

    /**
     * 经营模式类型
     */
    @ApiModelProperty(value = "经营模式类型")
    private String mageModelType;

    /**
     * 采购产品
     */
    @ApiModelProperty(value = "采购产品")
    private String purchasePrdut;

    /**
     * 销售产品
     */
    @ApiModelProperty(value = "销售产品")
    private String salePrdut;

    /**
     * 公司网址
     */
    @ApiModelProperty(value = "公司网址")
    private String compWebsite;

    /**
     * 公司介绍
     */
    @ApiModelProperty(value = "公司介绍")
    private String compIntroduce;
    /**
     * 会员类型
     */
    @ApiModelProperty(value = "会员类型(member_type[0:个人1:企业])")
    private String memberType;

    /**
     * 企业认证状态类型(0:已认证1:未认证)[entp_auth_state_type]
     */
    @ApiModelProperty(value = "认证状态(0:已认证1：未认证)")
    private String entpAuthStateType;

    /**
     * 是否代理商标记(0	:是1:否)[agent_flag]
     */
    @ApiModelProperty(value = "是否是代理商(0:是1:否)")
    private String agentFlag;

    /**
     * 账户状态(0:正常1:冻结)[acct_state]
     */
    @ApiModelProperty(value = "账户状态(0:正常1:冻结)")
    private String acctState;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String petName;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String url;
    @ApiModelProperty(value = "微信小程序openid")
    private String weChatOpenid;
    @ApiModelProperty(value = "来源类型(0:web1:微信小程序)")
    private String sourceType;
    @ApiModelProperty(value = "能否开发票(0:能1:不能)")
    private String nfkfpType;
    @ApiModelProperty(value = "发票类型(0:增值税普通发票1:增值税专用发票)")
    private String invoType;

    /**
     * 父类ID
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long parentId;

    /**
     * 账期支付开通状态
     **/
    @ApiModelProperty(value = "账期支付开通状态")
    private String apFlag;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWeChatOpenid() {
        return weChatOpenid;
    }

    public void setWeChatOpenid(String weChatOpenid) {
        this.weChatOpenid = weChatOpenid;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
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

	public String getFixedTel() {
		return fixedTel;
	}

	public void setFixedTel(String fixedTel) {
		this.fixedTel = fixedTel;
	}

	public String getContactsEmail() {
		return contactsEmail;
	}

	public void setContactsEmail(String contactsEmail) {
		this.contactsEmail = contactsEmail;
	}

	public String getAreaProv() {
		return areaProv;
	}

	public void setAreaProv(String areaProv) {
		this.areaProv = areaProv;
	}

	public String getAreaCity() {
		return areaCity;
	}

	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}

	public String getAreaCou() {
		return areaCou;
	}

	public void setAreaCou(String areaCou) {
		this.areaCou = areaCou;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getCompCatgType() {
		return compCatgType;
	}

	public void setCompCatgType(String compCatgType) {
		this.compCatgType = compCatgType;
	}

	public String getMyDept() {
		return myDept;
	}

	public void setMyDept(String myDept) {
		this.myDept = myDept;
	}

	public String getMyPosition() {
		return myPosition;
	}

	public void setMyPosition(String myPosition) {
		this.myPosition = myPosition;
	}

	public String getMageModelType() {
		return mageModelType;
	}

	public void setMageModelType(String mageModelType) {
		this.mageModelType = mageModelType;
	}

	public String getPurchasePrdut() {
		return purchasePrdut;
	}

	public void setPurchasePrdut(String purchasePrdut) {
		this.purchasePrdut = purchasePrdut;
	}

	public String getSalePrdut() {
		return salePrdut;
	}

	public void setSalePrdut(String salePrdut) {
		this.salePrdut = salePrdut;
	}

	public String getCompWebsite() {
		return compWebsite;
	}

	public void setCompWebsite(String compWebsite) {
		this.compWebsite = compWebsite;
	}

	public String getCompIntroduce() {
		return compIntroduce;
	}

	public void setCompIntroduce(String compIntroduce) {
		this.compIntroduce = compIntroduce;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

    public String getApFlag() {
        return apFlag;
    }

    public void setApFlag(String apFlag) {
        this.apFlag = apFlag;
    }

	public String getNfkfpType() {
		return nfkfpType;
	}

	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}
}
