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
 *  长协合同相关处理PO的共同部分
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月9日
 * @version 1.0
 */
@ApiModel(value="长协合同相关处理PO的共同部分")
public class LtaContOperatePo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty("长协合同ID")
	@Check(test = "required")
	private Long id;

	@ApiModelProperty(value="排他字段(修改的情况必填)")
	@Check(test = "required")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
