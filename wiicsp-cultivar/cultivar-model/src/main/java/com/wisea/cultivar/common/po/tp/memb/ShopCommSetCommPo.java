package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 批量添加已经发布的商品信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("批量添加已经发布的商品信息PO")
public class ShopCommSetCommPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    @Check(test="required",requiredMsg="商品发布ID不能为空")
    private Long commPubId;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

	public Long getCommPubId() {
		return commPubId;
	}

	public void setCommPubId(Long commPubId) {
		this.commPubId = commPubId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
