package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 地块信息列表信息
 * @author wzx
 *
 */
@ApiModel("地块信息列表信息VO")
public class WebMassifMageVo {
	@ApiModelProperty("ID")
	private Long id;
	@ApiModelProperty("地块名称")
	private String massifName; // 地块名称
	@ApiModelProperty("地块类型")
	private String massifType; // 地块类型
	@ApiModelProperty("地块面积")
	private Double massifAcre; // 地块面积
	@ApiModelProperty("主体名称")
	private String orgName; // 农场或公司名称
	@ApiModelProperty("创建人")
	private String createName;// 创建人
	@ApiModelProperty("创建时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime createDate;// 创建时间
	@ApiModelProperty("更新人")
	private String updateName;// 更新人
	@ApiModelProperty("更新时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime updateDate;// 更新时间

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

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
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
