package com.wisea.cultivar.common.vo.bigdata;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 *
 * @author wangh(wisea)
 *
 * @date 2019年11月7日
 * @version 1.0
 */
public class SampBaseInfoForBigDataVo implements Serializable{

	/**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2019年11月7日
	 * @version 1.0
	 */
	private static final long serialVersionUID = 3731672644189399402L;

	@ApiModelProperty("样品ID")
	private Long id;
	@ApiModelProperty("样品名称")
	private String sampName;
	@ApiModelProperty("检测结果0：合格1：不合格")
	private String resultType;
	@ApiModelProperty("采样时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime sampDate;
	@ApiModelProperty("抽样地区-省")
	private String sampProv;
	@ApiModelProperty("抽样地区-市")
	private String sampCity;
	@ApiModelProperty("抽样地区-县")
	private String sampCou;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSampName() {
		return sampName;
	}
	public void setSampName(String sampName) {
		this.sampName = sampName;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public OffsetDateTime getSampDate() {
		return sampDate;
	}
	public void setSampDate(OffsetDateTime sampDate) {
		this.sampDate = sampDate;
	}
	public String getSampProv() {
		return sampProv;
	}
	public void setSampProv(String sampProv) {
		this.sampProv = sampProv;
	}
	public String getSampCity() {
		return sampCity;
	}
	public void setSampCity(String sampCity) {
		this.sampCity = sampCity;
	}
	public String getSampCou() {
		return sampCou;
	}
	public void setSampCou(String sampCou) {
		this.sampCou = sampCou;
	}

}
