package com.wisea.cultivar.origin.vo;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 检测样品列表
 * @author wzx
 *
 */
@ApiModel("检测样品列表VO")
public class SampListVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty("样品编号")
	private String sampNum; // 样品编号
	@ApiModelProperty("现场图片")
	private String url; // 现场图片
	@ApiModelProperty("样品名称")
	private String sampName; // 样品名称
	@ApiModelProperty("样品类别类型")
	private String sampCatgType; // 样品类别类型
	@ApiModelProperty("抽样数量")
	private Integer samplingCount; // 抽样数量
	@ApiModelProperty("样品批次")
	private String sampBatNum;// 样品批次
	@ApiModelProperty("规格型号")
	private String specModel;// 规格型号
	@ApiModelProperty("企业名称")
	private String membName;// 企业名称
	@ApiModelProperty("采样时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;// 采样时间(更新时间)
	@ApiModelProperty("状态 0是未上传,非0都是已上传")
	private String  sampStateType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSampNum() {
		return sampNum;
	}
	public void setSampNum(String sampNum) {
		this.sampNum = sampNum;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSampName() {
		return sampName;
	}
	public void setSampName(String sampName) {
		this.sampName = sampName;
	}
	public String getSampCatgType() {
		return sampCatgType;
	}
	public void setSampCatgType(String sampCatgType) {
		this.sampCatgType = sampCatgType;
	}
	public Integer getSamplingCount() {
		return samplingCount;
	}
	public void setSamplingCount(Integer samplingCount) {
		this.samplingCount = samplingCount;
	}
	public String getSampBatNum() {
		return sampBatNum;
	}
	public void setSampBatNum(String sampBatNum) {
		this.sampBatNum = sampBatNum;
	}
	public String getSpecModel() {
		return specModel;
	}
	public void setSpecModel(String specModel) {
		this.specModel = specModel;
	}
	public String getMembName() {
		return membName;
	}
	public void setMembName(String membName) {
		this.membName = membName;
	}
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getSampStateType() {
		return sampStateType;
	}
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType;
	}

}
