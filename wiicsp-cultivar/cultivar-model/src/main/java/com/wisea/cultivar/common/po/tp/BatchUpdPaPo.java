package com.wisea.cultivar.common.po.tp;
/**
 *
 * @author wangh(wisea)
 *
 * @date 2017年12月16日
 * @version 1.0
 */

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 批量修改/删除/修改状态等传入的id列表
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月13日
 * @version 1.0
 */
@ApiModel("传入的id列表")
public class BatchUpdPaPo {

	@ApiModelProperty(value="id列表(必填)",required=true)
	@Check(test="required")
	private List<String> idList = Lists.newArrayList();

	/**
	 * @return the idList
	 */
	public List<String> getIdList() {
		return idList;
	}

	/**
	 * @param idList the idList to set
	 */
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
}
