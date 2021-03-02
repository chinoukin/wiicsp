package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.memb.RoleExtendsListVo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 查询角色列表的条件
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月30日
 * @version 1.0
 */
public class RoleExtendsPagePo extends PagePo<RoleExtendsListVo>{

	private static final long serialVersionUID = 2886560857286396948L;

	@ApiModelProperty(value="市场ID(或者是洪九果品运营主体ID)为空表示运营主体")
	@JsonSerialize(using = IdSerializer.class)
	private Long marketId;

	@ApiModelProperty("角色名称")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
}
