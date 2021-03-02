package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.SellerMembMagePageListVo;

import io.swagger.annotations.ApiModelProperty;

public class SellerMembManagerPagePo extends PagePo<SellerMembMagePageListVo>{

	private static final long serialVersionUID = 4492857796471107149L;

	@ApiModelProperty(value="商户ID")
	private Long id;

	@ApiModelProperty(value="用户名/企业名称")
	private String key;
	@ApiModelProperty(value="是否产地会员类型(0:是产地会员1:同城)", hidden=true)
	private String localityMembType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLocalityMembType() {
		return localityMembType;
	}

	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}
}
