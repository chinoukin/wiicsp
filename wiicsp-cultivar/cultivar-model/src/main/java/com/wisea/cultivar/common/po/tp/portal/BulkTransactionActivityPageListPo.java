package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.portal.BulkTransactionActivityListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 大宗交易后台分页查询接口PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("大宗交易后台分页查询接口PO")
public class BulkTransactionActivityPageListPo extends PagePo<BulkTransactionActivityListVo>{

	private static final long serialVersionUID = 5062853842543193096L;

	@ApiModelProperty(value="请输入商品名称")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
