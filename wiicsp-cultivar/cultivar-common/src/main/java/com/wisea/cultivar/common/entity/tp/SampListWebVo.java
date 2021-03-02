package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 检测信息
 * @author wzx
 *
 */
@ApiModel("检测信息VO")
public class SampListWebVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty("样品编号")
	private String sampNum; // 样品编号
	@ApiModelProperty("样品名称")
	private String sampName; // 样品名称
	@ApiModelProperty("样品类别类型")
	private String sampCatgType; // 样品类别类型
	@ApiModelProperty("抽样数量")
	private Integer samplingCount; //抽样数量
	@ApiModelProperty("抽样基数")
	private Integer samplingBase; //抽样基数
	@ApiModelProperty("状态 0是未上传,2都是未检测,3已检测")
	private String  sampStateType;
	@ApiModelProperty("企业名称")
	private String companyName;// 企业名称
	@ApiModelProperty("采样人")
	private String membName;// 采样人
    @ApiModelProperty("样品发布商品的id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commSampRelaId;
	@ApiModelProperty("采样时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;// 采样时间(更新时间)
    @ApiModelProperty("生产时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime prdctDate;

    public OffsetDateTime getPrdctDate() {
        return prdctDate;
    }

    public void setPrdctDate(OffsetDateTime prdctDate) {
        this.prdctDate = prdctDate;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

    public Long getCommSampRelaId() {
        return commSampRelaId;
    }

    public void setCommSampRelaId(Long commSampRelaId) {
        this.commSampRelaId = commSampRelaId;
    }

    public String getSampNum() {
		return sampNum;
	}
	public void setSampNum(String sampNum) {
		this.sampNum = sampNum;
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
	public Integer getSamplingBase() {
		return samplingBase;
	}
	public void setSamplingBase(Integer samplingBase) {
		this.samplingBase = samplingBase;
	}
	public String getSampStateType() {
		return sampStateType;
	}
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType;
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
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


}
