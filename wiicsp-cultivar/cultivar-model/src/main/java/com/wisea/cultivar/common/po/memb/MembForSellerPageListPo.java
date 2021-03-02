package com.wisea.cultivar.common.po.memb;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.memb.MembForManagerListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 运营平台/市场运营 供应商会员管理分页列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营 供应商会员管理分页列表PO")
public class MembForSellerPageListPo extends PagePo<MembForManagerListVo>{

	private static final long serialVersionUID = -6789079952558013657L;

	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

    @ApiModelProperty(value="账户状态(acct_state 0:正常1:禁用)")
    private String acctState;

    @ApiModelProperty(value="认证状态(0:已认证1:未认证)为空为所有")
    private String entpAuthStateType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }
}
