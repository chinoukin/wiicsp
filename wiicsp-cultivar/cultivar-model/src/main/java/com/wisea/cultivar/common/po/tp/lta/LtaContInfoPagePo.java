package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.lta.LtaContInfoListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
  * 卖家长期合同列表PO
  *
  * @author wangh(wisea)
  *
  * @date 2019年5月7日
  * @version 1.0
  */
@ApiModel("卖家长期合同列表PO")
public class LtaContInfoPagePo  extends PagePo<LtaContInfoListVo> {

	private static final long serialVersionUID = 3832086717006191622L;

	@ApiModelProperty(value="商家ID",hidden=true)
	private Long membId;

	@ApiModelProperty(value="买卖家标识buy_sell_flag(0:买方1:卖方)",hidden=true)
	private String buySellFlag;

	@ApiModelProperty(value="合同状态(0:待确认1:合同生效2:合同到期3:合同终止4:已取消5:强制解除)")
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


}
