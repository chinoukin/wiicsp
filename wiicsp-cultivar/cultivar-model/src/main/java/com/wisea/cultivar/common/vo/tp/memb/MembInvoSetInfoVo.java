package com.wisea.cultivar.common.vo.tp.memb;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员发票设置信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月26日
 * @version 1.0
 */
@ApiModel("会员发票设置信息VO")
public class MembInvoSetInfoVo {

	@ApiModelProperty(value="会员ID")
	private Long membId;
	@ApiModelProperty(value="是否可以能开发票(nfkfp_type0:能1:不能)")
	private String nfkfpType;//是否可以能开发票(nfkfp_type0:能1:不能)
	@ApiModelProperty(value="发票内容")
	private String invoContent;// 发票内容
	@ApiModelProperty(value="发票类型,多个用逗号分隔（字典值invo_type）")
	private String invoType;// 发票类型（多个用逗号分隔）
	@ApiModelProperty(value="发票类型列表")
	private List<String> invoList;

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
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
	public void setInvoList(List<String> invoList) {
		this.invoList = invoList;
	}
	public List<String> getInvoList() {
		return invoList;
	}
}
