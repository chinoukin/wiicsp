package com.wisea.transac.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业会员列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月17日
 * @version 1.0
 */
@ApiModel("企业会员列表信息(设置服务费)VO")
public class MembEntpInfoListVo {

	@ApiModelProperty(value="会员ID")
    @JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty(value="企业名称")
	private String compName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}
}
