package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询广告列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年6月1日
 * @version 1.0
 */
@ApiModel("查询广告列表PO")
public class AdverMageListPo {

	@JsonSerialize(using = IdSerializer.class)
    @Check(test = {"required","maxLength"}, length = 19)
    @ApiModelProperty(value = "广告位id")
    private Long adverSpaceId;

	 @ApiModelProperty(value = "是否启用 (0:启用1:停用)",hidden=true)
	private String enableFlag;

	public Long getAdverSpaceId() {
		return adverSpaceId;
	}

	public void setAdverSpaceId(Long adverSpaceId) {
		this.adverSpaceId = adverSpaceId;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
}
