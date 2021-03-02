package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 技术学堂-技术资料详细信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月2日
 * @version 1.0
 */
@ApiModel("技术学堂-技术资料详细信息PO")
public class JszlListGetDetailPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "详细id")
	@Check(test="required")
    private Long id;

	@JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength"}, length = 19)
    @ApiModelProperty(value = "技术资料分类id")
    private Long jszlCatgId;

	@ApiModelProperty(value = "行数",hidden=true)
	private int rowNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJszlCatgId() {
		return jszlCatgId;
	}

	public void setJszlCatgId(Long jszlCatgId) {
		this.jszlCatgId = jszlCatgId;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}
