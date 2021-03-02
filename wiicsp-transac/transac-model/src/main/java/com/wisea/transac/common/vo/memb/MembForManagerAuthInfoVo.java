package com.wisea.transac.common.vo.memb;

import com.wisea.cloud.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员供应商认证管理列表信息包含表头VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月21日
 * @version 1.0
 */
@ApiModel("会员供应商认证管理列表信息包含表头VO")
public class MembForManagerAuthInfoVo {

	@ApiModelProperty(value = "全部会员数量")
	private int allMemb;

	@ApiModelProperty(value = "待平台审核数量")
	private int authStatetype0;

	@ApiModelProperty(value = "待银盛开户数量")
	private int authStatetype1;

	@ApiModelProperty(value = "审核通过数量")
	private int authStatetype3;

	@ApiModelProperty(value = "审核未通过数量")
	private int authStatetype4;

	@ApiModelProperty(value = "列表信息")
	private Page<MembForManagerListVo> pageList;

	public int getAllMemb() {
		return allMemb;
	}

	public void setAllMemb(int allMemb) {
		this.allMemb = allMemb;
	}

	public int getAuthStatetype0() {
		return authStatetype0;
	}

	public void setAuthStatetype0(int authStatetype0) {
		this.authStatetype0 = authStatetype0;
	}

	public int getAuthStatetype1() {
		return authStatetype1;
	}

	public void setAuthStatetype1(int authStatetype1) {
		this.authStatetype1 = authStatetype1;
	}

	public int getAuthStatetype3() {
		return authStatetype3;
	}

	public void setAuthStatetype3(int authStatetype3) {
		this.authStatetype3 = authStatetype3;
	}

	public int getAuthStatetype4() {
		return authStatetype4;
	}

	public void setAuthStatetype4(int authStatetype4) {
		this.authStatetype4 = authStatetype4;
	}

	public Page<MembForManagerListVo> getPageList() {
		return pageList;
	}

	public void setPageList(Page<MembForManagerListVo> pageList) {
		this.pageList = pageList;
	}
}
