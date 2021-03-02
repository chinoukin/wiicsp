package com.wisea.cultivar.common.vo.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 楼层中企业店铺信息列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月3日
 * @version 1.0
 */
@ApiModel("楼层中企业店铺信息列表VO")
public class ShopInfoMageForFloorListVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商铺id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "用户名")
    private String loginName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
