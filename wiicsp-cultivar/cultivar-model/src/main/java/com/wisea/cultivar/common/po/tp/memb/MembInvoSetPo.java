package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员发票设置的PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月26日
 * @version 1.0
 */
@ApiModel("会员发票设置的PO")
public class MembInvoSetPo {

	@ApiModelProperty(value="会员ID",hidden=true)
	private Long membId;
	@Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "只能为0或者1")
	@ApiModelProperty(value="是否可以能开发票(nfkfp_type0:能1:不能)")
	private String nfkfpType;//是否可以能开发票(nfkfp_type0:能1:不能)
	@ApiModelProperty(value="发票内容")
	private String invoContent;// 发票内容
	@Check(test = "logic", logic = "'0'.equals(#nfkfpType)?#isNotEmpty(#invoType):true", logicMsg = "可以开发票的情况下发票类型不能为空")
	@ApiModelProperty(value="发票类型（字典值invo_type）")
	private String invoType;// 发票类型（多个用逗号分隔）

	public String getNfkfpType() {
		return nfkfpType;
	}
	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}
	public String getInvoContent() {
		return invoContent;
	}
	public void setInvoContent(String invoContent) {
		this.invoContent = invoContent;
	}
	public String getInvoType() {
		return invoType;
	}
	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
}
