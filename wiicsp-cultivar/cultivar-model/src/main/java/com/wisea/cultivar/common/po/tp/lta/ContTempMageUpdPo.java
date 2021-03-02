package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增修改合同模版信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月23日
 * @version 1.0
 */
@ApiModel("新增修改合同模版信息PO")
public class ContTempMageUpdPo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty("ID(修改的情况必须填写)")
	private Long id;

	@ApiModelProperty(value="模版名称")
	@Check(test = "required")
	private String tempName;

	@ApiModelProperty(value="模版内容")
	@Check(test = "required")
    private String contContent;

    @ApiModelProperty(value="排他字段(修改的情况必填)")
    @Check(test = "logic", logic = "#isNotEmpty(#id)?#isNotEmpty(#updateDate):true", logicMsg = "排他字段(修改的情况必填)")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getContContent() {
		return contContent;
	}

	public void setContContent(String contContent) {
		this.contContent = contContent;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
