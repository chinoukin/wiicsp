package com.wisea.cultivar.common.vo.tp;

import com.wisea.cloud.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台分页查询会员管理列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月9日
 * @version 1.0
 */
@ApiModel("后台分页查询会员管理列表VO")
public class MembInfoBackListVo {

	@ApiModelProperty(value = "全部会员")
	private int allMemb;
	@ApiModelProperty(value = "个人")
	private int individual;
	@ApiModelProperty(value = "企业")
	private int enterprise;
	@ApiModelProperty(value = "商家")
	private int agent;
	@ApiModelProperty(value = "列表信息")
	Page<MembInfoListVo> pageList;

	public int getAllMemb() {
		return allMemb;
	}
	public void setAllMemb(int allMemb) {
		this.allMemb = allMemb;
	}
	public int getIndividual() {
		return individual;
	}
	public void setIndividual(int individual) {
		this.individual = individual;
	}
	public int getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(int enterprise) {
		this.enterprise = enterprise;
	}
	public int getAgent() {
		return agent;
	}
	public void setAgent(int agent) {
		this.agent = agent;
	}
	public Page<MembInfoListVo> getPageList() {
		return pageList;
	}
	public void setPageList(Page<MembInfoListVo> pageList) {
		this.pageList = pageList;
	}



}
