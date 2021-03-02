package com.wisea.transac.common.po.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交订单商品和发票PO
 */
@ApiModel("提交订单商品和发票PO")
public class OrderApplPo {

	@ApiModelProperty(value = "每个商家的商品List")
	@Check(test = "required")
	private List<BuyerToOrderPo> importCommList;
	@ApiModelProperty(value = "档口ID、基地ID")
    private Long stallsMageId;
	@ApiModelProperty(value = "提货时间，开始日期")
    private OffsetDateTime ztStartDate;
	@ApiModelProperty(value = "提货时间，结束日期")
    private OffsetDateTime ztEndDate;
	@ApiModelProperty(value = "备注")
	private String remarks;

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getStallsMageId() {
        return stallsMageId;
    }
    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }
    public List<BuyerToOrderPo> getImportCommList() {
        return importCommList;
    }
    public void setImportCommList(List<BuyerToOrderPo> importCommList) {
        this.importCommList = importCommList;
    }
    public OffsetDateTime getZtStartDate() {
        return ztStartDate;
    }
    public void setZtStartDate(OffsetDateTime ztStartDate) {
        this.ztStartDate = ztStartDate;
    }
    public OffsetDateTime getZtEndDate() {
        return ztEndDate;
    }
    public void setZtEndDate(OffsetDateTime ztEndDate) {
        this.ztEndDate = ztEndDate;
    }
}
