package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商家审核认证(模拟第三方认证)PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月20日
 * @version 1.0
 */
@ApiModel("商家审核认证(模拟第三方认证)PO")
public class EntpAuthPassByWiseaPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="ID")
    @Check(test = "required")
	private Long id;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="操作内容")
	private String operatorContent;

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="操作状态(0:提交到第三方支付1:不提交到第三方支付)")
    @Check(test = {"required","liveable"},liveable={"0","1"},liveableMsg="操作状态只能是0或者1")
	private String authExamState;

	@ApiModelProperty(value="商户编号")
	@Check(test = "required")
	private String merchantNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperatorContent() {
		return operatorContent;
	}

	public void setOperatorContent(String operatorContent) {
		this.operatorContent = operatorContent;
	}

	public String getAuthExamState() {
		return authExamState;
	}

	public void setAuthExamState(String authExamState) {
		this.authExamState = authExamState;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
}
