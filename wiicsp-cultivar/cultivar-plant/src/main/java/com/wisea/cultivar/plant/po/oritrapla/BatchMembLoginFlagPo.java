package com.wisea.cultivar.plant.po.oritrapla;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 修改会员冻结，解冻状态
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
public class BatchMembLoginFlagPo {

	@ApiModelProperty("会员id列表")
	private List<String> idList;
	@ApiModelProperty("状态(0:冻结1:正常)")
	private String acctStatus;
	/**
	 * @return the idList
	 */
	public List<String> getIdList() {
		return idList;
	}
	/**
	 * @param idList the idList to set
	 */
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
	/**
	 * @return the acctStatus
	 */
	public String getAcctStatus() {
		return acctStatus;
	}
	/**
	 * @param acctStatus the acctStatus to set
	 */
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}
}
