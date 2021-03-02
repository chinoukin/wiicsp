package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同模版详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月23日
 * @version 1.0
 */
@ApiModel("合同模版详细信息VO")
public class ContTempMageDetailVo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty("ID")
	private Long id;

	@ApiModelProperty(value="模版名称")
	private String tempName;

	@ApiModelProperty(value="模版内容")
    private String contContent;

    @ApiModelProperty(value="排他字段")
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
