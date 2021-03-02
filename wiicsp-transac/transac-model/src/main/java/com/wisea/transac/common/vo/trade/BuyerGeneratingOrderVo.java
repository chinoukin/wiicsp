package com.wisea.transac.common.vo.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交订单返回订单信息
 */
@ApiModel("提交订单返回订单信息")
public class BuyerGeneratingOrderVo {

	@ApiModelProperty("订单编号List")
    private List<BuyerOrderInfoVo> ordInfoList;

	@ApiModelProperty("订单总金额")
	private double amountPayable;

	@ApiModelProperty("商品总数量")
    private Integer totalCount;

    @ApiModelProperty("总共商家数")
    private Integer totalSeller;

    @ApiModelProperty("总档口数")
    private Integer totalStall;

    public List<BuyerOrderInfoVo> getOrdInfoList() {
        return ordInfoList;
    }

    public void setOrdInfoList(List<BuyerOrderInfoVo> ordInfoList) {
        this.ordInfoList = ordInfoList;
    }

    public double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalSeller() {
        return totalSeller;
    }

    public void setTotalSeller(Integer totalSeller) {
        this.totalSeller = totalSeller;
    }

    public Integer getTotalStall() {
        return totalStall;
    }

    public void setTotalStall(Integer totalStall) {
        this.totalStall = totalStall;
    }
}
