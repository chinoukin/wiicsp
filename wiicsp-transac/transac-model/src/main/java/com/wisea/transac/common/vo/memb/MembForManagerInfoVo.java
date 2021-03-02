package com.wisea.transac.common.vo.memb;

import com.wisea.cloud.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采购商会员管理列表信息包含统计VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月21日
 * @version 1.0
 */
@ApiModel("采购商会员管理列表信息包含统计VO")
public class MembForManagerInfoVo {

	@ApiModelProperty(value = "全部会员数量")
	private int allMemb;

	@ApiModelProperty(value = "企业会员数量")
	private int entpMemb;

	@ApiModelProperty(value = "个体户会员数量")
	private int indMemb;

	@ApiModelProperty(value = "个人会员数量")
	private int personMemb;

	@ApiModelProperty(value = "列表信息")
	private Page<MembForManagerListVo> pageList;

	public int getAllMemb() {
		return allMemb;
	}

	public void setAllMemb(int allMemb) {
		this.allMemb = allMemb;
	}

	public int getEntpMemb() {
		return entpMemb;
	}

	public void setEntpMemb(int entpMemb) {
		this.entpMemb = entpMemb;
	}

	public int getIndMemb() {
		return indMemb;
	}

	public void setIndMemb(int indMemb) {
		this.indMemb = indMemb;
	}

	public Page<MembForManagerListVo> getPageList() {
		return pageList;
	}

	public void setPageList(Page<MembForManagerListVo> pageList) {
		this.pageList = pageList;
	}

	public int getPersonMemb() {
		return personMemb;
	}

	public void setPersonMemb(int personMemb) {
		this.personMemb = personMemb;
	}
}
