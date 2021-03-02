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
 *  卖家查询长协合同列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月7日
 * @version 1.0
 */
@ApiModel("卖家查询长协合同列表VO")
public class LtaContInfoListVo {

	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value="合同ID")
	private Long id;

	@ApiModelProperty(value="合同编号")
	private String ltaContNumb;

	@ApiModelProperty(value="采购商名称")
	private String buyerCompName;

	@ApiModelProperty(value="供应商名称")
	private String sellerCompName;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="拟定日期")
	private OffsetDateTime draftContDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="合同开始时间")
	private OffsetDateTime contStartDate;

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="合同结束时间")
	private OffsetDateTime contEndDate;

	@ApiModelProperty(value="合同状态")
	private String ltaContStateType;

	@ApiModelProperty(value="订单数量")
	private int orderCount;

	@ApiModelProperty(value="解除申请提出方buy_sell_flag(0:买方1:卖方)")
	private String buySellFlag;

	@ApiModelProperty(value = "排他字段(修改的场合需要传入)")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;

	public String getLtaContNumb() {
		return ltaContNumb;
	}

	public void setLtaContNumb(String ltaContNumb) {
		this.ltaContNumb = ltaContNumb;
	}

	public OffsetDateTime getDraftContDate() {
		return draftContDate;
	}

	public void setDraftContDate(OffsetDateTime draftContDate) {
		this.draftContDate = draftContDate;
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

	public String getLtaContStateType() {
		return ltaContStateType;
	}

	public void setLtaContStateType(String ltaContStateType) {
		this.ltaContStateType = ltaContStateType;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getBuySellFlag() {
		return buySellFlag;
	}

	public void setBuySellFlag(String buySellFlag) {
		this.buySellFlag = buySellFlag;
	}

	public String getBuyerCompName() {
		return buyerCompName;
	}

	public void setBuyerCompName(String buyerCompName) {
		this.buyerCompName = buyerCompName;
	}

	public String getSellerCompName() {
		return sellerCompName;
	}

	public void setSellerCompName(String sellerCompName) {
		this.sellerCompName = sellerCompName;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
