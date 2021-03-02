package com.wisea.cultivar.common.vo.tp;

import com.wisea.cloud.model.Page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台分页查询认证管理列表
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月9日
 * @version 1.0
 */
@ApiModel("后台分页查询认证管理列表VO")
public class EntpDataInfoBackListVo {

	@ApiModelProperty(value = "全部认证")
	private int allAuth;
	@ApiModelProperty(value = "等待审核")
	private int waitAuth;
	@ApiModelProperty(value = "通过审核")
	private int passAuth;
	@ApiModelProperty(value = "驳回审核")
	private int rebutAuth;
	@ApiModelProperty(value = "审核中")
	private int haveInAuth;
	@ApiModelProperty(value = "列表信息")
	Page<EntpDataPageListVo> pageList;

	public int getAllAuth() {
		return allAuth;
	}
	public void setAllAuth(int allAuth) {
		this.allAuth = allAuth;
	}
	public int getWaitAuth() {
		return waitAuth;
	}
	public void setWaitAuth(int waitAuth) {
		this.waitAuth = waitAuth;
	}
	public int getPassAuth() {
		return passAuth;
	}
	public void setPassAuth(int passAuth) {
		this.passAuth = passAuth;
	}
	public int getRebutAuth() {
		return rebutAuth;
	}
	public void setRebutAuth(int rebutAuth) {
		this.rebutAuth = rebutAuth;
	}
	public Page<EntpDataPageListVo> getPageList() {
		return pageList;
	}
	public void setPageList(Page<EntpDataPageListVo> pageList) {
		this.pageList = pageList;
	}
	public int getHaveInAuth() {
		return haveInAuth;
	}
	public void setHaveInAuth(int haveInAuth) {
		this.haveInAuth = haveInAuth;
	}

}
