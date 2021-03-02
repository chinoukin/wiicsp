package com.wisea.cultivar.common.po.tp;

/**
 * 修改商家银行卡信息中的EntpDataId
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月30日
 * @version 1.0
 */
public class EmtpBankInfoUpdPo {

	private Long newEntpDataId;
	private Long oldEntpDataId;

	public Long getNewEntpDataId() {
		return newEntpDataId;
	}
	public void setNewEntpDataId(Long newEntpDataId) {
		this.newEntpDataId = newEntpDataId;
	}
	public Long getOldEntpDataId() {
		return oldEntpDataId;
	}
	public void setOldEntpDataId(Long oldEntpDataId) {
		this.oldEntpDataId = oldEntpDataId;
	}
}
