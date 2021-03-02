package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.lta.LtaContPlatListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 平台端分页查询长期合同PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月23日
 * @version 1.0
 */
@ApiModel("平台端分页查询长期合同PO")
public class LtaContPlatPagePo extends PagePo<LtaContPlatListVo>{

	private static final long serialVersionUID = 6331972931902788537L;

	@ApiModelProperty(value="合同状态(0:待确认1:合同生效2:合同到期3:合同终止4:已取消5:强制解除)不传查询全部")
	private String ltaContStateType;

	@ApiModelProperty(value="请输入合同编号/买家账号/商家账号")
	private String key;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "拟定合同-开始时间")
	private OffsetDateTime draftContStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "拟定合同-结束时间")
	private OffsetDateTime draftContEndDate;

	public String getLtaContStateType() {
		return ltaContStateType;
	}

	public void setLtaContStateType(String ltaContStateType) {
		this.ltaContStateType = ltaContStateType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public OffsetDateTime getDraftContStartDate() {
		return draftContStartDate;
	}

	public void setDraftContStartDate(OffsetDateTime draftContStartDate) {
		this.draftContStartDate = draftContStartDate;
	}

	public OffsetDateTime getDraftContEndDate() {
		return draftContEndDate;
	}

	public void setDraftContEndDate(OffsetDateTime draftContEndDate) {
		this.draftContEndDate = draftContEndDate;
	}
}
