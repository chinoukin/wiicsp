package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 *
 * @author yangtao
 *
 * 添加农事记录po
 */
@ApiModel("添加农事记录po")
public class FarmWorkRecdPo {

	@Check(test = "required", regexMsg = "我的档案id不能为空")
	@ApiModelProperty(value="我的档案id")
    private Long mineArchId; //我的档案id
	@Check(test = "logic", logic = "'1'.equals(#savaFlag)?#isNotEmpty(#farmWorkRecdId):true")
	@ApiModelProperty(value="农事记录id（编辑的时候传）")
    private Long farmWorkRecdId; //农事记录id（编辑的时候传）
	@Check(test = "required", regexMsg = "农事类型id不能为空")
	@ApiModelProperty(value="农事类型id")
    private Long farmWorkTypeId;//农事类型id
	@ApiModelProperty(value="操作内容")
    private String operatContent;//操作内容
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="操作时间")
    @Check(test = "required", regexMsg = "操作时间不能为空")
    private OffsetDateTime operatDate; //操作时间
    @ApiModelProperty(value="视频URL")
    private String videoUrl;//备注
    @ApiModelProperty(value="使用农资")
    private String usAgriculturalMaterials;//备注
    @ApiModelProperty(value="备注")
    @Check(test = "logic", logic = "'1'.equals(#otherFlag)?#isNotEmpty(#operatContent):true")
    private String remarks;//备注
    @ApiModelProperty(value="凭证url")
    @Check(test = "required", regexMsg = "凭证url不能为空")
	private List<String> fileUrls;
	@ApiModelProperty(value="是否是“其他”标识（当选择“其他”的时候传1，其余传0）")
	@Check(test = "required", regexMsg = "是否是“其他”标识不能为空")
    private String otherFlag;//是否是其他标识（当选择“其他”的时候传1，其余传0）
	@ApiModelProperty(value="添加、编辑标识，添加农事记录0，编辑1，添加农事计划2")
	@Check(test = "required", regexMsg = "添加、编辑标识不能为空")
    private String savaFlag;//添加、编辑标识，添加0，编辑1
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新日期")
	@Check(test = "logic", logic = "'1'.equals(#savaFlag)?#isNotEmpty(#updateDate):true")
    private OffsetDateTime updateDate; //更新日期


    public Long getMineArchId() {
		return mineArchId;
	}

	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getUsAgriculturalMaterials() {
		return usAgriculturalMaterials;
	}

	public void setUsAgriculturalMaterials(String usAgriculturalMaterials) {
		this.usAgriculturalMaterials = usAgriculturalMaterials;
	}

	public Long getFarmWorkRecdId() {
		return farmWorkRecdId;
	}

	public void setFarmWorkRecdId(Long farmWorkRecdId) {
		this.farmWorkRecdId = farmWorkRecdId;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<String> getFileUrls() {
		return fileUrls;
	}

	public void setFileUrls(List<String> fileUrls) {
		this.fileUrls = fileUrls;
	}

	public String getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	public String getSavaFlag() {
		return savaFlag;
	}

	public void setSavaFlag(String savaFlag) {
		this.savaFlag = savaFlag;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
