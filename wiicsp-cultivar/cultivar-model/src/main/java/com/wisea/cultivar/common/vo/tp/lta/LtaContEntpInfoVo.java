package com.wisea.cultivar.common.vo.tp.lta;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同商家信息(采购商/供应商)PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月8日
 * @version 1.0
 */
@ApiModel("合同商家信息(采购商/供应商)PO")
public class LtaContEntpInfoVo {

	@ApiModelProperty(value="商家ID")
	private Long entpId;

	@ApiModelProperty(value="商家名称")
	private String compName;

	@ApiModelProperty(value="商家联系人")
	private String contacts;

	@ApiModelProperty(value="商家联系人电话")
	private String bdTel;

	public Long getEntpId() {
		return entpId;
	}
	public void setEntpId(Long entpId) {
		this.entpId = entpId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getBdTel() {
		return bdTel;
	}
	public void setBdTel(String bdTel) {
		this.bdTel = bdTel;
	}
}
