package com.wisea.cultivar.common.po.tp.lta;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 长协买家端提交退货申请PO
 */
@ApiModel("长协买家端提交退货申请PO")
public class LtaRefundCommApplPo {

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "订单商品id")
    private Long ordCommId;
    @Check(test = "required")
    @ApiModelProperty(value = "服务类型")
    private String serType;
    @Check(test = "required")
    @ApiModelProperty(value = "退款方式")
    private String refundModeType;
    @Check(test = "required")
    @ApiModelProperty(value = "退货数量")
    private Integer refundCounts;
    @Check(test = "required")
    @ApiModelProperty(value = "应退商品金额")
    private Double commTotalAmount;
    @Check(test = "required")
    @ApiModelProperty(value = "应退运费金额")
    private Double shouldYfAmount;
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "退货原因")
    private Long refundReasonId;
    @Check(test = { "maxLength", "required" }, mixLength = 255)
    @ApiModelProperty(value = "问题描述")
    private String refundDesc;
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "客户姓名")
    private String custName;
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "手机号")
    private String tel;
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;
    @ApiModelProperty("凭证图片列表")
    @Check(test = "logic",logic = "#imgUrls.size()<=5 ? true:false", logicMsg = "图片最多5张")
    private List<String> imgUrls;

	public Long getOrdCommId() {
		return ordCommId;
	}

	public void setOrdCommId(Long ordCommId) {
		this.ordCommId = ordCommId;
	}

	public String getSerType() {
		return serType;
	}

	public void setSerType(String serType) {
		this.serType = serType;
	}

	public Double getCommTotalAmount() {
		return commTotalAmount;
	}

	public void setCommTotalAmount(Double commTotalAmount) {
		this.commTotalAmount = commTotalAmount;
	}

	public Double getShouldYfAmount() {
		return shouldYfAmount;
	}

	public void setShouldYfAmount(Double shouldYfAmount) {
		this.shouldYfAmount = shouldYfAmount;
	}

	public String getRefundModeType() {
		return refundModeType;
	}

	public void setRefundModeType(String refundModeType) {
		this.refundModeType = refundModeType;
	}

	public Integer getRefundCounts() {
		return refundCounts;
	}

	public void setRefundCounts(Integer refundCounts) {
		this.refundCounts = refundCounts;
	}

	public Long getRefundReasonId() {
		return refundReasonId;
	}

	public void setRefundReasonId(Long refundReasonId) {
		this.refundReasonId = refundReasonId;
	}

	public String getRefundDesc() {
		return refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<String> getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(List<String> imgUrls) {
		this.imgUrls = imgUrls;
	}
}
