package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.plant.entity.oritrapla.FarmWorkPicture;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 农事记录
 */
public class FarmWorkRecdVo {

	@ApiModelProperty(value="农事记录id")
	@JsonSerialize(using= LongSerializer.class)
    private Long farmWorkRecdId; //农事记录id
	@ApiModelProperty(value="档案id")
	@JsonSerialize(using= LongSerializer.class)
    private Long archId; //档案id
	@ApiModelProperty(value="农事类型id")
	@JsonSerialize(using= LongSerializer.class)
    private Long farmWorkTypeId; //农事类型id
	@ApiModelProperty(value="农事类型名称")
    private String name; //农事类型名称
	@ApiModelProperty(value="操作内容")
    private String operatContent; //操作内容
	@ApiModelProperty(value="使用农资")
    private String usAgriculturalMaterials; //使用农资
	@ApiModelProperty(value="记录状态")
    private String recordStatus; //记录状态
	@ApiModelProperty(value="备注")
    private String remarks; //备注
	@ApiModelProperty(value="操作时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime operatDate; //操作时间
	@ApiModelProperty(value="创建者id")
	@JsonSerialize(using= LongSerializer.class)
    private Long createBy; // 创建者id
	@ApiModelProperty(value="创建者名称")
    private String createByName; // 创建者名称
	@ApiModelProperty(value="视频URL")
    private String videoUrl; // 创建者名称
	@ApiModelProperty(value="农事记录照片")
	private List<FarmWorkPicture> farmWorkPictureList;// 农事记录照片
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="更新日期（排他校验）")
	private OffsetDateTime updateDate;
	@ApiModelProperty(value="是否可以操作标识（0可以操作。1不可以操作，主要针对删除、编辑）")
    private String outhFlag; //是否可以操作标识

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public String getUsAgriculturalMaterials() {
		return usAgriculturalMaterials;
	}

	public void setUsAgriculturalMaterials(String usAgriculturalMaterials) {
		this.usAgriculturalMaterials = usAgriculturalMaterials;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Long getFarmWorkTypeId() {
        return farmWorkTypeId;
    }

    public void setFarmWorkTypeId(Long farmWorkTypeId) {
        this.farmWorkTypeId = farmWorkTypeId;
    }

    public String getOperatContent() {
        return operatContent;
    }

    public void setOperatContent(String operatContent) {
        this.operatContent = operatContent;
    }

    public OffsetDateTime getOperatDate() {
        return operatDate;
    }

    public void setOperatDate(OffsetDateTime operatDate) {
        this.operatDate = operatDate;
    }

	public Long getFarmWorkRecdId() {
		return farmWorkRecdId;
	}

	public void setFarmWorkRecdId(Long farmWorkRecdId) {
		this.farmWorkRecdId = farmWorkRecdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public String getCreateByName() {
		return createByName;
	}

	public void setCreateByName(String createByName) {
		this.createByName = createByName;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public List<FarmWorkPicture> getFarmWorkPictureList() {
		return farmWorkPictureList;
	}

	public void setFarmWorkPictureList(List<FarmWorkPicture> farmWorkPictureList) {
		this.farmWorkPictureList = farmWorkPictureList;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getOuthFlag() {
		return outhFlag;
	}

	public void setOuthFlag(String outhFlag) {
		this.outhFlag = outhFlag;
	}

}
