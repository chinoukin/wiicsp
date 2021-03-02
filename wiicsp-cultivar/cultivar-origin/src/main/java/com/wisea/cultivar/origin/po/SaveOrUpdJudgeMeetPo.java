package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品鉴会保存/修改操作PO
 * @author wzx
 *
 */
@ApiModel("品鉴会保存/修改操作PO")
public class SaveOrUpdJudgeMeetPo {

	@ApiModelProperty(value="id(新增的时候为空，修改的时候必须填写)")
	private Long id;
	@ApiModelProperty(value="品鉴会名称")
	@Check(test = "required")
	private String judgeMeetName;
	@ApiModelProperty(value="主办单位")
	@Check(test = "required")
	private String hostUnit;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@Check(test = "required")
	@ApiModelProperty(value="开始日期")
    private OffsetDateTime startDate;//开始日期
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@Check(test = "required")
	@ApiModelProperty(value="结束日期")
	private OffsetDateTime endDate;//结束日期
	@ApiModelProperty(value="开始时间")
	@Check(test = "required")
	private String startTime;
	@ApiModelProperty(value="结束时间")
	@Check(test = "required")
	private String endTime;
	@ApiModelProperty(value="地址")
	@Check(test = "required")
	private String address;
	@ApiModelProperty(value="联系人")
	private String contacts;//联系人
	@ApiModelProperty(value="联系电话")
	private String tel;//联系电话
	@ApiModelProperty(value="品鉴会介绍")
	private String judgeMeetIntroduce;//品鉴会介绍
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="排他字段")
    private OffsetDateTime updateDate;//更新时间
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJudgeMeetName() {
		return judgeMeetName;
	}
	public void setJudgeMeetName(String judgeMeetName) {
		this.judgeMeetName = judgeMeetName;
	}
	public String getHostUnit() {
		return hostUnit;
	}
	public void setHostUnit(String hostUnit) {
		this.hostUnit = hostUnit;
	}
	public OffsetDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}
	public OffsetDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getJudgeMeetIntroduce() {
		return judgeMeetIntroduce;
	}
	public void setJudgeMeetIntroduce(String judgeMeetIntroduce) {
		this.judgeMeetIntroduce = judgeMeetIntroduce;
	}
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}


}
