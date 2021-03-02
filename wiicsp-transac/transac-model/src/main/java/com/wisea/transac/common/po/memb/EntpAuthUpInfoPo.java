package com.wisea.transac.common.po.memb;

import io.swagger.annotations.ApiModel;

/**
 * 获取最新的企业信息的处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月22日
 * @version 1.0
 */
@ApiModel("获取最新的企业信息的处理PO")
public class EntpAuthUpInfoPo {

	// 会员ID
	private Long membId;
	// 标识 0:全局最新(包含商户和小程序)1:小程序最新2:同城app商户最新3:产地(基地)商户app最新
	private String flag = "0";

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
