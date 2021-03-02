package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("地块添加or修改的PO")
public class MassifMageInfoAddPo {

	@ApiModelProperty(value="地块id(新增的时候为空，修改的是传值)")
	private Long id;
	@ApiModelProperty("地块名称")
	@Check(test = "required")
    private String massifName; //地块名称
	@ApiModelProperty("地块类型")
	@Check(test = "required")
    private String massifType; //地块类型
	@ApiModelProperty("地块面积")
	@Check(test = "required")
    private Double massifAcre; //地块面积
	@ApiModelProperty("地块经度")
	private Double jd; //地块纬度
	@ApiModelProperty("地块纬度")
	private Double wd; //地块纬度
	@ApiModelProperty("所在位置")
	private String location; //所在位置
	@ApiModelProperty(value="排他字段 (新增的时候为空，修改的是传值)")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;// 更新日期


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMassifName() {
		return massifName;
	}

	public void setMassifName(String massifName) {
		this.massifName = massifName;
	}

	public String getMassifType() {
		return massifType;
	}

	public void setMassifType(String massifType) {
		this.massifType = massifType;
	}

	public Double getMassifAcre() {
		return massifAcre;
	}

	public void setMassifAcre(Double massifAcre) {
		this.massifAcre = massifAcre;
	}

	public Double getJd() {
		return jd;
	}

	public void setJd(Double jd) {
		this.jd = jd;
	}

	public Double getWd() {
		return wd;
	}

	public void setWd(Double wd) {
		this.wd = wd;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
