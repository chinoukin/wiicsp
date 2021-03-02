package com.wisea.cultivar.common.po.memb;

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
@ApiModel("后台审核保存相关信息(商家和个人审核)PO")
public class EntpDataInfoExamPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="企业信息ID")
    @Check(test = "required")
	private Long id;


	@ApiModelProperty(value="认证类型 0：企业 1：个人")
    @Check(test = "required")
	private String authType;
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="操作内容")
	@Check(test = "logic", logic = "'4'.equals(#authExamState)?#isNotEmpty(#operatorContent):true", logicMsg = "驳回时操作信息不能为空")
	private String operatorContent;
	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="操作状态(2:待审核、0:审核通过、1:审核未通过)")
    @Check(test = {"required","liveable"},liveable={"0","1","2"})
	private String authExamState;

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
