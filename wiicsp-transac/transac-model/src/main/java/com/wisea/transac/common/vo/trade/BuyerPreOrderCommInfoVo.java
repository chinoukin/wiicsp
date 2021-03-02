package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.transac.common.vo.InvoInfoInfoVo;

import com.wisea.transac.common.vo.ReceAddressInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 预定单的商品列表信息
 */
@ApiModel("预订单的商品列表信息")
public class BuyerPreOrderCommInfoVo {

	@ApiModelProperty("档口商品信息")
	private List<ImportStallsListVo> importStallsListVo;

	@ApiModelProperty("发票信息")
	private InvoInfoInfoVo invoInfoInfoVo;

    @ApiModelProperty("收货地址信息")
    private ReceAddressInfoVo receAddressInfoVo;

    @ApiModelProperty("是否可以指定配送flag（0 可以，1不可以）")
	private String receFlag;

	@ApiModelProperty(value = "服务器时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	private OffsetDateTime date;

	@ApiModelProperty("商品总金额")
	private Double amountPayable;

	@ApiModelProperty("商品总数量")
	private Integer totalCount;

	@ApiModelProperty("总共商家数")
	private Integer totalSeller;

	@ApiModelProperty("总档口数")
	private Integer totalStall;

    public List<ImportStallsListVo> getImportStallsListVo() {
        return importStallsListVo;
    }

    public void setImportStallsListVo(List<ImportStallsListVo> importStallsListVo) {
        this.importStallsListVo = importStallsListVo;
    }

    public String getReceFlag() {
        return receFlag;
    }

    public void setReceFlag(String receFlag) {
        this.receFlag = receFlag;
    }

    public ReceAddressInfoVo getReceAddressInfoVo() {
        return receAddressInfoVo;
    }

    public void setReceAddressInfoVo(ReceAddressInfoVo receAddressInfoVo) {
        this.receAddressInfoVo = receAddressInfoVo;
    }

    public InvoInfoInfoVo getInvoInfoInfoVo() {
        return invoInfoInfoVo;
    }

    public void setInvoInfoInfoVo(InvoInfoInfoVo invoInfoInfoVo) {
        this.invoInfoInfoVo = invoInfoInfoVo;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
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
