package com.wisea.cultivar.common.po.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 采购商会员管理导出处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
@ApiModel("采购商会员管理导出处理PO")
public class MembSellerExportPo {


    @ApiModelProperty(value = "用户名/注册手机号/企业名称")
    private String key;

    @ApiModelProperty(value="账户状态(acct_state 0:正常1:禁用)")
    private String acctState;

    @ApiModelProperty(value="认证状态(0:已认证1:未认证)为空为所有")
    private String entpAuthStateType;

	@ApiModelProperty(value="会员id列表(如果为空则按照条件,如果不是空则按照id列表查询)")
	private List<String> idList;


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

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }
}
