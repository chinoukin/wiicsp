package com.wisea.cultivar.origin.vo;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 检测样品详情
 * @author wzx
 *
 */
@ApiModel("检测样品详情VO")
public class SampInfoVo {
	@ApiModelProperty("ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty(value="样品名称")
	private String sampName;//样品名称
	@ApiModelProperty("样品编号")
	private Long sampNum; //样品编号
	@ApiModelProperty("样品类别类型")
	private String sampCatgType; // 样品类别类型
	@ApiModelProperty("抽样数量")
	private Integer samplingCount; // 抽样数量
	@ApiModelProperty(value="抽样基数")
    private Integer samplingBase;//抽样基数
	@ApiModelProperty("规格型号")
	private String specModel;// 规格型号
	@ApiModelProperty("样品批次")
	private String sampBatNum;// 样品批次
	@ApiModelProperty(value="商标名称")
    private String brandName;//商标名称
	@ApiModelProperty(value="样品等级类型")
    private String sampGradeType;//样品等级类型
	@ApiModelProperty(value="生产日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime prdctDate;//生产日期
	@ApiModelProperty(value="生产单位")
    private String prdctUnit;//生产单位
	@ApiModelProperty(value="现场图片")
	private List<ImgListVo> imgList = Lists.newArrayList(); //现场图片列表
	@ApiModelProperty(value="企业信息")
	private MembListVo membInfo; //企业信息
    @ApiModelProperty(value="品鉴会ID")
    @JsonSerialize(using = IdSerializer.class)
    private Long judgeMeetId;//品鉴会ID
    @ApiModelProperty(value="检测机构ID")
    @JsonSerialize(using = IdSerializer.class)
    private Long detectionMechId;//检测机构ID
    @ApiModelProperty(value="检测机构编号",hidden=true)
    private String orgNum;
	@ApiModelProperty(value="品鉴会")
    private String judgeMeetName;//品鉴会
	@ApiModelProperty(value="检测机构")
    private String detectionMechName;//检测机构
	@ApiModelProperty(value="经度")
    private String longitude;//经度
	@ApiModelProperty(value="纬度")
    private String latitude;//纬度
	@ApiModelProperty(value="采样人")
    private String updateBy;//更新者
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="采样时间")
    private OffsetDateTime updateDate;//更新时间
	@ApiModelProperty(value="报告图片")
	private List<ImgListVo> reportImg = Lists.newArrayList(); //报告图片
	@ApiModelProperty(value="样品状态类型")
	private String sampStateType;
	@ApiModelProperty(value="果品等级")
	private String gpLevel;
	@ApiModelProperty(value="检测时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime detecDate;
	@ApiModelProperty(value="检测结果（0:不合格1:合格）")
    private String resultType;
	/** wangh 20191010 开始 **/
	private String sampProv;//采样地区省
	private String sampCity;//采样地区市
	private String sampCou;//采样地区县
	private String sampTown;//采样地区乡镇
	private String sampVillage;//采样地区村
	private String sampAreaCode;//采样地区编码
	/** wangh 20191010 结束 **/

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSampName() {
		return sampName;
	}
	public void setSampName(String sampName) {
		this.sampName = sampName;
	}

	public Long getSampNum() {
		return sampNum;
	}
	public void setSampNum(Long sampNum) {
		this.sampNum = sampNum;
	}
	public String getSampCatgType() {
		return sampCatgType;
	}
	public void setSampCatgType(String sampCatgType) {
		this.sampCatgType = sampCatgType;
	}
	public Integer getSamplingCount() {
		return samplingCount;
	}
	public void setSamplingCount(Integer samplingCount) {
		this.samplingCount = samplingCount;
	}
	public Integer getSamplingBase() {
		return samplingBase;
	}
	public void setSamplingBase(Integer samplingBase) {
		this.samplingBase = samplingBase;
	}
	public String getSpecModel() {
		return specModel;
	}
	public void setSpecModel(String specModel) {
		this.specModel = specModel;
	}
	public String getSampBatNum() {
		return sampBatNum;
	}
	public void setSampBatNum(String sampBatNum) {
		this.sampBatNum = sampBatNum;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getSampGradeType() {
		return sampGradeType;
	}
	public void setSampGradeType(String sampGradeType) {
		this.sampGradeType = sampGradeType;
	}
	public OffsetDateTime getPrdctDate() {
		return prdctDate;
	}
	public void setPrdctDate(OffsetDateTime prdctDate) {
		this.prdctDate = prdctDate;
	}
	public String getPrdctUnit() {
		return prdctUnit;
	}
	public void setPrdctUnit(String prdctUnit) {
		this.prdctUnit = prdctUnit;
	}
	public List<ImgListVo> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgListVo> imgList) {
		this.imgList = imgList;
	}
	public MembListVo getMembInfo() {
		return membInfo;
	}
	public void setMembInfo(MembListVo membInfo) {
		this.membInfo = membInfo;
	}
	public Long getJudgeMeetId() {
		return judgeMeetId;
	}
	public void setJudgeMeetId(Long judgeMeetId) {
		this.judgeMeetId = judgeMeetId;
	}
	public Long getDetectionMechId() {
		return detectionMechId;
	}
	public void setDetectionMechId(Long detectionMechId) {
		this.detectionMechId = detectionMechId;
	}
	public String getJudgeMeetName() {
		return judgeMeetName;
	}
	public void setJudgeMeetName(String judgeMeetName) {
		this.judgeMeetName = judgeMeetName;
	}
	public String getDetectionMechName() {
		return detectionMechName;
	}
	public void setDetectionMechName(String detectionMechName) {
		this.detectionMechName = detectionMechName;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public List<ImgListVo> getReportImg() {
		return reportImg;
	}
	public void setReportImg(List<ImgListVo> reportImg) {
		this.reportImg = reportImg;
	}
	public String getSampStateType() {
		return sampStateType;
	}
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType;
	}
	public String getOrgNum() {
		return orgNum;
	}
	public void setOrgNum(String orgNum) {
		this.orgNum = orgNum;
	}
	public String getGpLevel() {
		return gpLevel;
	}
	public void setGpLevel(String gpLevel) {
		this.gpLevel = gpLevel;
	}
	public OffsetDateTime getDetecDate() {
		return detecDate;
	}
	public void setDetecDate(OffsetDateTime detecDate) {
		this.detecDate = detecDate;
	}
	public String getResultType() {
		return resultType;
	}
	public void setResultType(String resultType) {
		this.resultType = resultType;
	}
	public String getSampProv() {
		return sampProv;
	}
	public void setSampProv(String sampProv) {
		this.sampProv = sampProv;
	}
	public String getSampCity() {
		return sampCity;
	}
	public void setSampCity(String sampCity) {
		this.sampCity = sampCity;
	}
	public String getSampCou() {
		return sampCou;
	}
	public void setSampCou(String sampCou) {
		this.sampCou = sampCou;
	}
	public String getSampTown() {
		return sampTown;
	}
	public void setSampTown(String sampTown) {
		this.sampTown = sampTown;
	}
	public String getSampVillage() {
		return sampVillage;
	}
	public void setSampVillage(String sampVillage) {
		this.sampVillage = sampVillage;
	}
	public String getSampAreaCode() {
		return sampAreaCode;
	}
	public void setSampAreaCode(String sampAreaCode) {
		this.sampAreaCode = sampAreaCode;
	}


}
