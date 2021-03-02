package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 冻结解冻会员操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
@ApiModel("冻结解冻会员操作PO")
public class FreezeMembUpdPo {

	@ApiModelProperty(value="会员ID")
	@Check(test="required")
	private Long membId;

	@ApiModelProperty(value="账户状态(acct_state 0:正常1:冻结)")
    @Check(test = {"required","liveable"}, liveable = {"0", "1"}, liveableMsg = "账户状态只能为0,1")
	private String acctState;

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}
}
