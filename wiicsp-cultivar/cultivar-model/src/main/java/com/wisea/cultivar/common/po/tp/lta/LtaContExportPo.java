package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 长协合同导出PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月10日
 * @version 1.0
 */
@ApiModel("长协合同导出PO")
public class LtaContExportPo {

	@ApiModelProperty(value="商家ID",hidden=true)
	private Long membId;

	@ApiModelProperty(value="买卖家标识buy_sell_flag(0:买方1:卖方)",hidden=true)
	private String buySellFlag;

	@ApiModelProperty(value="合同状态")
	private String ltaContStateType;

	@ApiModelProperty(value="合同编号/商家用户名/商家名称")
	private String key;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "合同有效期-开始时间")
	private OffsetDateTime contStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "合同有效期-结束时间")
	private OffsetDateTime contEndDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "拟定合同-开始时间")
	private OffsetDateTime draftContStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "拟定合同-结束时间")
	private OffsetDateTime draftContEndDate;

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getBuySellFlag() {
		return buySellFlag;
	}

	public void setBuySellFlag(String buySellFlag) {
		this.buySellFlag = buySellFlag;
	}

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

	public OffsetDateTime getContStartDate() {
		return contStartDate;
	}

	public void setContStartDate(OffsetDateTime contStartDate) {
		this.contStartDate = contStartDate;
	}

	public OffsetDateTime getContEndDate() {
		return contEndDate;
	}

	public void setContEndDate(OffsetDateTime contEndDate) {
		this.contEndDate = contEndDate;
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
