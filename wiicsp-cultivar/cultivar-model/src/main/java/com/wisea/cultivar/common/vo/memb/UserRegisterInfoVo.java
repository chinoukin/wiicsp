package com.wisea.cultivar.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 用户注册信息详情VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月23日
 * @version 1.0
 */
@ApiModel("用户注册信息详情VO")
public class UserRegisterInfoVo {

	@ApiModelProperty(value="用户ID")
	private Long id;

    @ApiModelProperty(value = "用户名")
    private String loginName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @ApiModelProperty(value = "联系人姓名")
    private String  contName;

    @ApiModelProperty(value = "会员类型(memb_type 0:服务商1:种植户2：加工厂)")
    private String membType;

    @ApiModelProperty(value = "会员类型值(memb_type 0:服务商1:种植户2：加工厂)")
    private String membTypeValue;

    @ApiModelProperty(value = "注册时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private  OffsetDateTime registerDate;

    @ApiModelProperty(value = "是否商家(0:是1:否)")
    private String agentFlag;

    @ApiModelProperty(value = "账户状态(acct_state 0:正常1:冻结)")
    private String acctState;
    @ApiModelProperty(value = "账户状态值(acct_state 0:正常1:冻结)")
    private String acctStateValue;

    @ApiModelProperty(value = "商户编号")
    private String merchantNo;

    @ApiModelProperty(value = "认证状态(0:已认证1:未认证)")
    private String entpAuthStateType;
    @ApiModelProperty(value = "认证状态值(0:已认证1:未认证)")
    private String entpAuthStateTypeValue;

    @ApiModelProperty(value = "认证类型(0:企业1:个人)")
    private String authType;
    @ApiModelProperty(value = "认证类型值(0:企业1:个人)")
    private String authTypeValue;
    @ApiModelProperty(value = "审核状态(0:已审核1:审核未通过2:待审核)")
    private String authStateType;
    @ApiModelProperty(value = "审核状态值(0:已审核1:审核未通过2:待审核)")
    private String authStateTypeValue;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthTypeValue() {
        return authTypeValue;
    }

    public void setAuthTypeValue(String authTypeValue) {
        this.authTypeValue = authTypeValue;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }

    public String getAuthStateTypeValue() {
        return authStateTypeValue;
    }

    public void setAuthStateTypeValue(String authStateTypeValue) {
        this.authStateTypeValue = authStateTypeValue;
    }

    public String getAcctStateValue() {
        return acctStateValue;
    }

    public void setAcctStateValue(String acctStateValue) {
        this.acctStateValue = acctStateValue;
    }

    public String getEntpAuthStateTypeValue() {
        return entpAuthStateTypeValue;
    }

    public void setEntpAuthStateTypeValue(String entpAuthStateTypeValue) {
        this.entpAuthStateTypeValue = entpAuthStateTypeValue;
    }

    public OffsetDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(OffsetDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getMembTypeValue() {
        return membTypeValue;
    }

    public void setMembTypeValue(String membTypeValue) {
        this.membTypeValue = membTypeValue;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
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

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}
}
