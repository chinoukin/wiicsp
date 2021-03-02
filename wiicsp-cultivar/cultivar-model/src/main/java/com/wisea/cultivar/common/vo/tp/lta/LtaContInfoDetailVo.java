package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 长协合同的详细信息
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月8日
 * @version 1.0
 */
public class LtaContInfoDetailVo extends LtaContInfoInitVo{

	@ApiModelProperty(value="长协合同状态")
	private String ltaContStateType;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="拟定合同时间")
	private OffsetDateTime draftContDate;

	@ApiModelProperty(value="订单信息")
	private List<LtaContOrdBaseInfoVo> ordList;

	@ApiModelProperty(value="操作信息")
	private List<LtaContExamRecdVo> examRecodList;

	@ApiModelProperty(value = "解除申请提出方buy_sell_flag(0:买方1:卖方)")
    private String buySellFlag;//解除申请提出方

	public List<LtaContOrdBaseInfoVo> getOrdList() {
		return ordList;
	}

	public void setOrdList(List<LtaContOrdBaseInfoVo> ordList) {
		this.ordList = ordList;
	}

	public List<LtaContExamRecdVo> getExamRecodList() {
		return examRecodList;
	}

	public void setExamRecodList(List<LtaContExamRecdVo> examRecodList) {
		this.examRecodList = examRecodList;
	}

	public String getLtaContStateType() {
		return ltaContStateType;
	}

	public void setLtaContStateType(String ltaContStateType) {
		this.ltaContStateType = ltaContStateType;
	}

	public OffsetDateTime getDraftContDate() {
		return draftContDate;
	}

	public void setDraftContDate(OffsetDateTime draftContDate) {
		this.draftContDate = draftContDate;
	}

	public String getBuySellFlag() {
		return buySellFlag;
	}

	public void setBuySellFlag(String buySellFlag) {
		this.buySellFlag = buySellFlag;
	}
}
