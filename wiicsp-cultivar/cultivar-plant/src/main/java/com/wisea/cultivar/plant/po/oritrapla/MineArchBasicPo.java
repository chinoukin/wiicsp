package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 *
 *
 * @author yangtao
 *
 */
@ApiModel("新建我的档案po")
public class MineArchBasicPo {
	@Check(test = "logic", logic = "'1'.equals(#savaFlag)?#isNotEmpty(#mineArchId):true")
	@ApiModelProperty(value="我的档案id")
    private Long mineArchId; //我的档案id
	@Check(test = "required", regexMsg = "地块id不能为空")
	@ApiModelProperty(value="地块id")
    private Long massifId; //地块id
	@Check(test = "required", regexMsg = "品类id不能为空")
	@ApiModelProperty(value="品类id")
    private Long commId; //品类id
	@ApiModelProperty(value="品种id")
    private Long commVarietId; //品种id
	@Check(test = "required", regexMsg = "种植标准类型不能为空")
	@ApiModelProperty(value="种植标准类型")
    private String plantType; //种植标准类型
	@Check(test = "required", regexMsg = "开始日期不能为空")
	@ApiModelProperty(value="开始日期")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate; //开始日期
	@Check(test = "required", regexMsg = "结束日期不能为空")
	@ApiModelProperty(value="结束日期")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate; //结束日期
	@Check(test = "required", regexMsg = "种植面积不能为空")
	@ApiModelProperty(value="种植面积")
    private Double plantAcre; //种植面积
	@Check(test = "required", regexMsg = "预计产量不能为空")
	@ApiModelProperty(value="预计产量")
    private Double estOutput; //预计产量
	@Check(test = "required", regexMsg = "预计上市日期不能为空")
	@ApiModelProperty(value="预计上市日期")
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime estListDate; //预计上市日期
	@Check(test = "required", regexMsg = "图片url不能为空")
	@ApiModelProperty(value="图片url")
    private String url; //图片url
	@ApiModelProperty(value="添加、编辑标识，添加0，编辑1")
	@Check(test = "required", regexMsg = "添加、编辑标识不能为空")
    private String savaFlag;//添加、编辑标识，添加0，编辑1
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新日期(修改我的档案信息时传)")
	@Check(test = "logic", logic = "'1'.equals(#savaFlag)?#isNotEmpty(#updateDate):true")
    private OffsetDateTime updateDate; //更新日期
	@ApiModelProperty(value="种植方法id")
    private Long platMethodId; //种植方法id

    public Long getMineArchId() {
		return mineArchId;
	}

	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}

	public Long getPlatMethodId() {
		return platMethodId;
	}

	public void setPlatMethodId(Long platMethodId) {
		this.platMethodId = platMethodId;
	}

	public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
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
