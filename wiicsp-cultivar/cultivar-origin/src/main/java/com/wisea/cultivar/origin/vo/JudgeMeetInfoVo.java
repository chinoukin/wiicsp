package com.wisea.cultivar.origin.vo;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品鉴会信息Entity
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
@ApiModel("品鉴会详情VO")
public class JudgeMeetInfoVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty(value="品鉴会名称")
	private String judgeMeetName;
	@ApiModelProperty(value="主办单位")
	private String hostUnit;
	@ApiModelProperty(value="开始日期")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private OffsetDateTime startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@ApiModelProperty(value="结束日期")
	private OffsetDateTime endDate;
	@ApiModelProperty(value="开始时间")
	private String startTime;
	@ApiModelProperty(value="结束时间")
	private String endTime;
	@ApiModelProperty(value="地址")
	private String address;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="排他字段")
    private OffsetDateTime updateDate;//更新时间
	@ApiModelProperty(value="联系人")
	private String contacts;
	@ApiModelProperty(value="联系电话")
	private String tel;
	@ApiModelProperty(value="文章标题")
	private String judgeMeetIntroduce;
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
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
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

}
