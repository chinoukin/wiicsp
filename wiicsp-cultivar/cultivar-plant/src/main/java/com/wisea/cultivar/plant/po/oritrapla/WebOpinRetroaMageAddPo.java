package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 意见反馈处理操作PO
 * @author wzx
 *
 */
@ApiModel("意见反馈处理操作PO")
public class WebOpinRetroaMageAddPo extends LongIdPo{

	@ApiModelProperty(value="处理结果")
	@Check(test = "required")
	private String handleResult;
	@ApiModelProperty(value="排他字段")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	private OffsetDateTime updateDate;// 更新日期

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
