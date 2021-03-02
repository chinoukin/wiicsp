package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className SettleBillOrdVo
 * @date 2019/5/15 9:39
 * @Description 结算周期内订单Vo
 */
@ApiModel("结算周期内订单Vo")
public class SettleBillOrdVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("提交时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("订单金额")
    private Double amountPayable;
    @ApiModelProperty("订单申请来源，1 普通订单 、 2 长期协议订单。注：根据类型不同查询详情时需要调用不同的详情接口")
    private String ordSourceType;
    @ApiModelProperty("商品数量")
    private Double commTotalCount;
    @ApiModelProperty("卖家名称")
    private String sellerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCommTotalCount() {
		return commTotalCount;
	}

	public void setCommTotalCount(Double commTotalCount) {
		this.commTotalCount = commTotalCount;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public String getOrdSourceType() {
        return ordSourceType;
    }

    public void setOrdSourceType(String ordSourceType) {
        this.ordSourceType = ordSourceType;
    }
}
