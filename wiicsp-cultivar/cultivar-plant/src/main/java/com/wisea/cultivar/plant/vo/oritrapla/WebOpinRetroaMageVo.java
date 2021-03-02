package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 意见反馈列表信息
 * @author wzx
 *
 */
@ApiModel("意见反馈列表信息VO")
public class WebOpinRetroaMageVo {

	@ApiModelProperty("ID")
	private Long id;
	@ApiModelProperty("用户名")
	private String loginName; // 登陆用户名
	@ApiModelProperty("联系人姓名")
	private String contName; // 联系人姓名
	@ApiModelProperty("联系人手机号")
	private String contTel; // 联系人手机号
	@ApiModelProperty("主体名称")
	private String orgName; // 农场或公司名称
	@ApiModelProperty("反馈内容")
	private String retroaCont;// 反馈内容
	@ApiModelProperty("创建时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime createDate;// 创建时间
	@ApiModelProperty("处理状态[handle_status(0:已处理1:未处理)]")
	private String handleStatus;// 处理状态
	@ApiModelProperty("处理结果")
	private String handleResult;// 处理结果
	@ApiModelProperty("处理人")
	private String updateName;// 处理人
	@ApiModelProperty("处理时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime updateDate;// 处理时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getContTel() {
		return contTel;
	}

	public void setContTel(String contTel) {
		this.contTel = contTel;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRetroaCont() {
		return retroaCont;
	}

	public void setRetroaCont(String retroaCont) {
		this.retroaCont = retroaCont;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

	public String getHandleStatus() {
		return handleStatus;
	}

	public void setHandleStatus(String handleStatus) {
		this.handleStatus = handleStatus;
	}

	public String getHandleResult() {
		return handleResult;
	}

	public void setHandleResult(String handleResult) {
		this.handleResult = handleResult;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
