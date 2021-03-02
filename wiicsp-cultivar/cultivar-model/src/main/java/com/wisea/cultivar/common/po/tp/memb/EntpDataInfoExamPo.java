package com.wisea.cultivar.common.po.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台审核保存相关信息(商家和个人审核)PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月9日
 * @version 1.0
 */
@ApiModel("商家资料审核PO")
public class EntpDataInfoExamPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="ID")
    @Check(test = "required")
	private Long id;
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="操作内容")
	@Check(test = "logic", logic = "'2'.equals(#authExamState)?#isNotEmpty(#operatorContent):true", logicMsg = "驳回时操作信息不能为空")
	private String operatorContent;
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="操作状态(3:通过(易宝审核-审核中)2:驳回)")
    @Check(test = {"required","liveable"},liveable={"3","2"},liveableMsg="操作状态只能是2或者3")
	private String authExamState;
//	@ApiModelProperty(value="统一服务费")
//	@Check(test = { "required","regex","logic"}, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",logic = "'3'.equals(#authExamState)?#isNotEmpty(#serCost):true", logicMsg = "统一服务费不能为空")
//	private Double serCost;
	@ApiModelProperty(value="会员类型(0：个人1:企业)")
	@Check(test = {"required","liveable"},liveable={"0","1"},liveableMsg="会员类型只能是0,1")
	private String memberType;//会员类型(0：个人1:企业)

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
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
