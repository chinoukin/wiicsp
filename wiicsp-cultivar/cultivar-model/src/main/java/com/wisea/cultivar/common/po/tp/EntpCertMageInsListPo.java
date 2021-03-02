package com.wisea.cultivar.common.po.tp;

import java.util.List;

import io.swagger.annotations.ApiModel;

/**
 * 保存商家认证信息列表
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月9日
 * @version 1.0
 */
@ApiModel("保存商家认证信息列表")
public class EntpCertMageInsListPo {
    /**
     *
     */
	private List<EntpCertMageInsertPo> list;

	public List<EntpCertMageInsertPo> getList() {
		return list;
	}

	public void setList(List<EntpCertMageInsertPo> list) {
		this.list = list;
	}
}
