package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 检测记录vo类
 *
 * @author user
 *
 */
public class ExamRecdVo {

	@ApiModelProperty(value="检测记录id")
	@JsonSerialize(using= LongSerializer.class)
	private Long examId;
	@ApiModelProperty(value="检测记录关系id")
	@JsonSerialize(using= LongSerializer.class)
	private Long examRecdId;
	@ApiModelProperty(value="我的档案id")
	@JsonSerialize(using= LongSerializer.class)
	private Long mineArchId;
	@ApiModelProperty(value="会员id")
	@JsonSerialize(using= LongSerializer.class)
	private Long membId;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
//    @JsonDeserialize(using = OffsetDateTimeLongToDateDeserializer.class)
	@ApiModelProperty(value="检测日期")
	private OffsetDateTime examDate;
	@ApiModelProperty(value="检测项目")
	private String examPrjet;
	@ApiModelProperty(value="检测结果类型（合格，不合格）")
	private String examResultType;
	@ApiModelProperty(value="检测方式（送检，自检）")
	private String examModeType;
	@ApiModelProperty(value="检测机构")
	private String examOrg;
	@ApiModelProperty(value="检测结论")
	private String examConc;
	@ApiModelProperty(value="检测记录图片")
	private List<ExamReportPicture> examReportPicture;
	@ApiModelProperty(value="记录所属会员id")
	private Long recdBelongMembId; //记录所属会员id
	@ApiModelProperty(value="是否可以编辑标识")
	private String isMineFlag;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="更新日期（排他校验）")
	private OffsetDateTime updateDate;
	@ApiModelProperty(value="是否可以操作标识（0可以操作。1不可以操作，主要针对删除、编辑）")
    private String outhFlag; //是否可以操作标识

	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	public Long getMineArchId() {
		return mineArchId;
	}
	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}
	public Long getExamRecdId() {
		return examRecdId;
	}
	public void setExamRecdId(Long examRecdId) {
		this.examRecdId = examRecdId;
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
	public List<ExamReportPicture> getExamReportPicture() {
		return examReportPicture;
	}
	public void setExamReportPicture(List<ExamReportPicture> examReportPicture) {
		this.examReportPicture = examReportPicture;
	}
	public Long getRecdBelongMembId() {
		return recdBelongMembId;
	}
	public void setRecdBelongMembId(Long recdBelongMembId) {
		this.recdBelongMembId = recdBelongMembId;
	}
	public String getIsMineFlag() {
		return isMineFlag;
	}
	public void setIsMineFlag(String isMineFlag) {
		this.isMineFlag = isMineFlag;
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
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
}
