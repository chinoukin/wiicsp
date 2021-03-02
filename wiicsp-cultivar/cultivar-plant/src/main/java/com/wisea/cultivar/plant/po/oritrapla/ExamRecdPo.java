package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;


/**
 * 检测记录Po
 */
@ApiModel("检测记录Po")
public class ExamRecdPo {

	@Check(test = "logic", logic = "'1'.equals(#savaFlag)?#isNotEmpty(#id):true")
	@ApiModelProperty("检测记录id")
    private Long id; //检测记录id
	/*@Check(test = "required", regexMsg = "检测记录关系id")
	@ApiModelProperty("检测记录关系id")
    private Long examRecdRelaId; //检测记录关系id
*/    @ApiModelProperty("我的档案id")
    @Check(test = "required", regexMsg = "我的档案id")
    private Long mineArchId; //我的档案id
    @ApiModelProperty("检测日期")
    @Check(test = "required", regexMsg = "检测日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime examDate; //检测日期
    @ApiModelProperty("检测项目")
    @Check(test = "required", regexMsg = "检测项目")
    private String examPrjet; //检测项目
    @ApiModelProperty("检测结果类型（合格，不合格）")
    @Check(test = "required", regexMsg = "检测结果类型（合格，不合格）")
    private String examResultType; //检测结果类型（合格，不合格）
    @ApiModelProperty("检测方式（送检，自检）")
    @Check(test = "required", regexMsg = "检测方式（送检，自检）")
    private String examModeType; //检测方式（送检，自检）
    @ApiModelProperty("检测机构")
    @Check(test = "required", regexMsg = "检测机构")
    private String examOrg; //检测机构
    @ApiModelProperty("检测结论")
    @Check(test = "required", regexMsg = "检测结论")
    private String examConc; //检测结论
    @ApiModelProperty("记录所属会员id")
    private Long recdBelongMembId; //记录所属会员id
    @ApiModelProperty("检测图片")
    private List<String> fileUrls;//检测图片
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新日期")
	@Check(test = "logic", logic = "'1'.equals(#savaFlag)?#isNotEmpty(#updateDate):true")
    private OffsetDateTime updateDate; //更新日期
    @ApiModelProperty(value="添加、编辑标识，添加0，编辑1")
	@Check(test = "required", regexMsg = "添加、编辑标识不能为空")
    private String savaFlag;//添加、编辑标识，添加0，编辑1

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public OffsetDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(OffsetDateTime examDate) {
        this.examDate = examDate;
    }

    public String getExamPrjet() {
        return examPrjet;
    }

    public void setExamPrjet(String examPrjet) {
        this.examPrjet = examPrjet;
    }

    public String getExamResultType() {
        return examResultType;
    }

    public void setExamResultType(String examResultType) {
        this.examResultType = examResultType;
    }

    public String getExamModeType() {
        return examModeType;
    }

    public void setExamModeType(String examModeType) {
        this.examModeType = examModeType;
    }

    public String getExamOrg() {
        return examOrg;
    }

    public void setExamOrg(String examOrg) {
        this.examOrg = examOrg;
    }

    public String getExamConc() {
        return examConc;
    }

    public void setExamConc(String examConc) {
        this.examConc = examConc;
    }

    public Long getRecdBelongMembId() {
        return recdBelongMembId;
    }

    public void setRecdBelongMembId(Long recdBelongMembId) {
        this.recdBelongMembId = recdBelongMembId;
    }

	public List<String> getFileUrls() {
		return fileUrls;
	}

	public void setFileUrls(List<String> fileUrls) {
		this.fileUrls = fileUrls;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getSavaFlag() {
		return savaFlag;
	}

	public void setSavaFlag(String savaFlag) {
		this.savaFlag = savaFlag;
	}

}
