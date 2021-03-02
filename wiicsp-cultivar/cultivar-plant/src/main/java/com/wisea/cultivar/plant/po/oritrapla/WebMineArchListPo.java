package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.ArchBasicInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 *
 *
 * @author yangtao
 *
 */
@ApiModel("后台管理端查询档案列表po")
public class WebMineArchListPo extends PagePo<ArchBasicInfoVo> {

	@ApiModelProperty(value="档案编号")
	private String archNum;
	@ApiModelProperty(value="创建人姓名")
	private String menbName;//创建人姓名
	@ApiModelProperty(value="接受人姓名")
	private String souMenbName;//接受人姓名
	@ApiModelProperty(value="地块id")
	@JsonSerialize(using= LongSerializer.class)
    private Long massifId; //地块id
	@ApiModelProperty(value="品种id")
	@JsonSerialize(using= LongSerializer.class)
    private Long commVarietId; //品种id
	@ApiModelProperty(value="品类id")
	@JsonSerialize(using= LongSerializer.class)
    private Long commId; //品类id
	@ApiModelProperty(value="主体名称")
	private String orgName;//主体名称
	@ApiModelProperty(value="种植标准类型")
    private String plantType; //种植标准类型
	@ApiModelProperty(value="档案类型（扫码，推送，自建）（后台查询条件类型，0自建，1外采）")
    private String archType; //档案类型（扫码，推送，自建）
	@ApiModelProperty(value="我的档案状态")
	private String mineArchStatus;//我的档案状态
	@ApiModelProperty(value="种植开始时间范围，开始日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDateStart; //种植开始日期
	@ApiModelProperty(value="种植开始时间范围，结束日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDateEnd; //种植结束日期
	@ApiModelProperty(value="种植结束时间范围,开始日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDateStart; //结束日期
	@ApiModelProperty(value="种植结束时间范围，结束日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDateEnd; //结束日期
	@ApiModelProperty(value="预计上市日期开始日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime estListDateStart; //预计上市日期
	@ApiModelProperty(value="预计上市日期结束日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime estListDateEnd; //预计上市日期
	@ApiModelProperty(value="正常档案是0，已删除是1")
    private String listFlag;
	@ApiModelProperty(value="选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value="0:档案编号，1：创建人，2：接收人")
    private String seachKey;

	public String getArchNum() {
		return archNum;
	}
	public void setArchNum(String archNum) {
		this.archNum = archNum;
	}
	public Long getCommId() {
		return commId;
	}
	public void setCommId(Long commId) {
		this.commId = commId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSeachKey() {
		return seachKey;
	}
	public void setSeachKey(String seachKey) {
		this.seachKey = seachKey;
	}
	public String getSouMenbName() {
		return souMenbName;
	}
	public void setSouMenbName(String souMenbName) {
		this.souMenbName = souMenbName;
	}
	public String getListFlag() {
		return listFlag;
	}
	public void setListFlag(String listFlag) {
		this.listFlag = listFlag;
	}
	public String getMenbName() {
		return menbName;
	}
	public void setMenbName(String menbName) {
		this.menbName = menbName;
	}
	public Long getMassifId() {
		return massifId;
	}
	public void setMassifId(Long massifId) {
		this.massifId = massifId;
	}
	public Long getCommVarietId() {
		return commVarietId;
	}
	public void setCommVarietId(Long commVarietId) {
		this.commVarietId = commVarietId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPlantType() {
		return plantType;
	}
	public void setPlantType(String plantType) {
		this.plantType = plantType;
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
	public OffsetDateTime getStartDateStart() {
		return startDateStart;
	}
	public void setStartDateStart(OffsetDateTime startDateStart) {
		this.startDateStart = startDateStart;
	}
	public OffsetDateTime getStartDateEnd() {
		return startDateEnd;
	}
	public void setStartDateEnd(OffsetDateTime startDateEnd) {
		this.startDateEnd = startDateEnd;
	}
	public OffsetDateTime getEndDateStart() {
		return endDateStart;
	}
	public void setEndDateStart(OffsetDateTime endDateStart) {
		this.endDateStart = endDateStart;
	}
	public OffsetDateTime getEndDateEnd() {
		return endDateEnd;
	}
	public void setEndDateEnd(OffsetDateTime endDateEnd) {
		this.endDateEnd = endDateEnd;
	}
	public OffsetDateTime getEstListDateStart() {
		return estListDateStart;
	}
	public void setEstListDateStart(OffsetDateTime estListDateStart) {
		this.estListDateStart = estListDateStart;
	}
	public OffsetDateTime getEstListDateEnd() {
		return estListDateEnd;
	}
	public void setEstListDateEnd(OffsetDateTime estListDateEnd) {
		this.estListDateEnd = estListDateEnd;
	}
}
