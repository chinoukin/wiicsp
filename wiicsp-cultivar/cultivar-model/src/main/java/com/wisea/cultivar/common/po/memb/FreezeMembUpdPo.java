package com.wisea.cultivar.common.po.memb;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 冻结解冻会员操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月25日
 * @version 1.0
 */
@ApiModel("冻结解冻会员操作PO")
public class FreezeMembUpdPo{

	@ApiModelProperty(value="会员ID")
	@Check(test="required")
	private List<Long> membIds;

	@ApiModelProperty(value="账户状态(acct_state 0:正常1:冻结)")
    @Check(test = {"required","liveable"}, liveable = {"0", "1"}, liveableMsg = "账户状态只能为0,1")
	private String acctState;

	private OffsetDateTime updateDate;

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public List<Long> getMembIds() {
        return membIds;
    }

    public void setMembIds(List<Long> membIds) {
        this.membIds = membIds;
    }

    public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}
}
