package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 档案基础信息Vo
 */
public class ArchBasicInfoVo {

	@ApiModelProperty(value="来源会员id")
    private Long sourceMembId; //来源会员id
	@ApiModelProperty(value="来源农场或公司名称")
	private String sourceOrgName;//来源农场或公司名称
	@ApiModelProperty(value="会员id")
	@JsonSerialize(using= LongSerializer.class)
    private Long membId; //会员id
	@ApiModelProperty(value="创建、接受人姓名")
	private String menbName;//创建、接受人姓名
	@ApiModelProperty(value="档案类型（扫码，推送，自建）")
    private String archType; //档案类型（扫码，推送，自建）
	@ApiModelProperty(value="我的档案状态")
	private String mineArchStatus;//我的档案状态
	@ApiModelProperty(value="创建、接收日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime createDate; //创建、接收日期
	@ApiModelProperty(value="档案编号")
	private String archNum; //档案编号
	@ApiModelProperty(value="我的档案id")
	@JsonSerialize(using= LongSerializer.class)
	private Long id; //我的档案id
	@ApiModelProperty(value="种植方法id")
	@JsonSerialize(using= LongSerializer.class)
	private Long plantingMethodId; //种植方法id
	@ApiModelProperty(value="种植方法类型")
    private String massifType; //种植方法
	@ApiModelProperty(value="档案id")
	@JsonSerialize(using= LongSerializer.class)
    private Long archId; //档案id
	@ApiModelProperty(value="地块id")
	@JsonSerialize(using= LongSerializer.class)
    private Long massifId; //地块id
	@ApiModelProperty(value="地块名称")
	private String massifName;//地块名称
	@ApiModelProperty(value="地块面积")
    private Double massifAcre; //地块面积
	@ApiModelProperty(value="品类id")
	@JsonSerialize(using= LongSerializer.class)
    private Long commId; //品类id
	@ApiModelProperty(value="品类名称")
	private String commName;//品类名称
	@ApiModelProperty(value="品种id")
	@JsonSerialize(using= LongSerializer.class)
    private Long commVarietId; //品种id
	@ApiModelProperty(value="品种名称")
	private String variName;//品种名称
	@ApiModelProperty(value="种植标准类型")
    private String plantType; //种植标准类型
	@ApiModelProperty(value="开始日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime startDate; //开始日期
	@ApiModelProperty(value="结束日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime endDate; //结束日期
	@ApiModelProperty(value="种植面积")
    private Double plantAcre; //种植面积
	@ApiModelProperty(value="预计产量")
    private Double estOutput; //预计产量
	@ApiModelProperty(value="预计上市日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime estListDate; //预计上市日期
	@ApiModelProperty(value="图片url")
    private String url; //图片url
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value="更新日期(排他校验，编辑的时候传)")
    private OffsetDateTime updateDate; //更新日期
	@ApiModelProperty(value="追溯码数量")
	private Double notAuthCount;
	@ApiModelProperty(value="公司会员名称")
	private String orgName;//农场或公司名称
	@ApiModelProperty(value="设备ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long equId;

	public Long getEquId() {
		return equId;
	}

	public void setEquId(Long equId) {
		this.equId = equId;
	}

	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
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
	public Long getPlantingMethodId() {
		return plantingMethodId;
	}
	public void setPlantingMethodId(Long plantingMethodId) {
		this.plantingMethodId = plantingMethodId;
	}
	public OffsetDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}
	public Long getSourceMembId() {
		return sourceMembId;
	}
	public void setSourceMembId(Long sourceMembId) {
		this.sourceMembId = sourceMembId;
	}
	public String getSourceOrgName() {
		return sourceOrgName;
	}
	public void setSourceOrgName(String sourceOrgName) {
		this.sourceOrgName = sourceOrgName;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getMenbName() {
		return menbName;
	}
	public void setMenbName(String menbName) {
		this.menbName = menbName;
	}
	public String getArchType() {
		return archType;
	}
	public void setArchType(String archType) {
		this.archType = archType;
	}
	public String getMineArchStatus() {
		return mineArchStatus;
	}
	public void setMineArchStatus(String mineArchStatus) {
		this.mineArchStatus = mineArchStatus;
	}
	public String getArchNum() {
		return archNum;
	}
	public void setArchNum(String archNum) {
		this.archNum = archNum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArchId() {
		return archId;
	}
	public void setArchId(Long archId) {
		this.archId = archId;
	}
	public Long getMassifId() {
		return massifId;
	}
	public void setMassifId(Long massifId) {
		this.massifId = massifId;
	}
	public String getMassifName() {
		return massifName;
	}
	public void setMassifName(String massifName) {
		this.massifName = massifName;
	}
	public Long getCommId() {
		return commId;
	}
	public void setCommId(Long commId) {
		this.commId = commId;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public Long getCommVarietId() {
		return commVarietId;
	}
	public void setCommVarietId(Long commVarietId) {
		this.commVarietId = commVarietId;
	}
	public String getVariName() {
		return variName;
	}
	public void setVariName(String variName) {
		this.variName = variName;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
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
	public Double getPlantAcre() {
		return plantAcre;
	}
	public void setPlantAcre(Double plantAcre) {
		this.plantAcre = plantAcre;
	}
	public Double getEstOutput() {
		return estOutput;
	}
	public void setEstOutput(Double estOutput) {
		this.estOutput = estOutput;
	}
	public OffsetDateTime getEstListDate() {
		return estListDate;
	}
	public void setEstListDate(OffsetDateTime estListDate) {
		this.estListDate = estListDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public Double getNotAuthCount() {
		return notAuthCount;
	}
	public void setNotAuthCount(Double notAuthCount) {
		this.notAuthCount = notAuthCount;
	}
}
