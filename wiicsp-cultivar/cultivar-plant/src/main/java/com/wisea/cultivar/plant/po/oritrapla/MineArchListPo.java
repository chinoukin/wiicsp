package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
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
@ApiModel("查询档案列表po")
public class MineArchListPo extends PagePo<ArchBasicInfoVo> {

	@ApiModelProperty(value="查询条件（请按地块/品类/品种名称搜索）")
	private String searchKey;
	@ApiModelProperty(value="档案类型（0自种，1外采）")
    private String archType; //档案类型（扫码，推送，自建）
	@ApiModelProperty(value="种植状态")
	private String plantStatus;//种植状态
	@ApiModelProperty(value="档案开始日期（一个月0，三个月1，半年2，一年3）")
	private String startType;//档案开始日期
	@ApiModelProperty(hidden = true)
    private Long membId;//会员id
	@ApiModelProperty(hidden = true)
    private Long id;//我的档案id
	@ApiModelProperty(hidden = true)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startTime;//档案开始时间
	@ApiModelProperty(hidden = true)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endTime;//档案结束时间
	@ApiModelProperty(hidden = true)
    private Long sourceMembId;//来源会员id
	@ApiModelProperty(hidden = true)
    private Long mineArchId;//来源我的档案id
	@ApiModelProperty(value="品类id")
    private Long commId;//我的档案id
	@ApiModelProperty(value="品种id")
    private Long commVarietId;//我的档案id
	@ApiModelProperty(value="种植标准类型")
	private String plantType;//种植状态
	@ApiModelProperty(value="查询没有种植方法的档案时传，0：没有种植方法，1：有种植方法")
	private String methodFlag;//种植状态

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSourceMembId() {
		return sourceMembId;
	}

	public void setSourceMembId(Long sourceMembId) {
		this.sourceMembId = sourceMembId;
	}

	public Long getMineArchId() {
		return mineArchId;
	}

	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getArchType() {
		return archType;
	}

	public void setArchType(String archType) {
		this.archType = archType;
	}

	public String getPlantStatus() {
		return plantStatus;
	}

	public void setPlantStatus(String plantStatus) {
		this.plantStatus = plantStatus;
	}

	public String getStartType() {
		return startType;
	}

	public void setStartType(String startType) {
		this.startType = startType;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public OffsetDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(OffsetDateTime startTime) {
		this.startTime = startTime;
	}

	public OffsetDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(OffsetDateTime endTime) {
		this.endTime = endTime;
	}

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public Long getCommVarietId() {
		return commVarietId;
	}

	public void setCommVarietId(Long commVarietId) {
		this.commVarietId = commVarietId;
	}

	public String getPlantType() {
		return plantType;
	}

	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}

	public String getMethodFlag() {
		return methodFlag;
	}

	public void setMethodFlag(String methodFlag) {
		this.methodFlag = methodFlag;
	}
}
