package com.wisea.cultivar.origin.po;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 样品信息保存/修改操作PO
 * @author wzx
 *
 */
@ApiModel("样品信息保存/修改操作PO")
public class SaveOrUpdSampPo {

	@ApiModelProperty(value="id(新增的时候为空，修改的时候必须填写)")
	private Long id;
	@ApiModelProperty(value="样品名称")
	@Check(test = "required")
	private String sampName;//样品名称
	@ApiModelProperty(value="抽样数量")
	@Check(test = "required")
    private Integer samplingCount;//抽样数量
	@ApiModelProperty(value="抽样基数")
	@Check(test = "required")
    private Integer samplingBase;//抽样基数
	@ApiModelProperty(value="规格型号")
    private String specModel;//规格型号
	@ApiModelProperty(value="样品批号")
    private String sampBatNum;//样品批号
	@ApiModelProperty(value="商标名称")
    private String brandName;//商标名称
	@ApiModelProperty(value="样品等级类型")
    private String gpLevel;//样品等级类型
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="生产日期")
    private OffsetDateTime prdctDate;//生产日期
	@ApiModelProperty(value="生产单位")
    private String prdctUnit;//生产单位
	@ApiModelProperty(value="现场图片")
	private List<ImgPo> imgList = Lists.newArrayList(); //现场图片列表
	@ApiModelProperty(value="企业id")
	@Check(test = "required")
    private Long compId;//企业id
	@ApiModelProperty(value="品鉴会id")
    private Long judgeMeetId;//品鉴会id
	@ApiModelProperty(value="检测机构id")
    private Long detectionMechId;//检测机构id
	@ApiModelProperty(value="经度")
    private String longitude;//经度
	@ApiModelProperty(value="纬度")
    private String latitude;//纬度
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value="排他字段 （值传采样时间）")
    private OffsetDateTime updateDate;//更新时间
	@ApiModelProperty(value="按钮标识（0：保存，1保存并上传）")
	@Check(test = {"required", "regex"}, regex = "^[0-1]$")
	private String  buttonTag;//按钮标识
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
	public List<ImgPo> getImgList() {
		return imgList;
	}
	public void setImgList(List<ImgPo> imgList) {
		this.imgList = imgList;
	}
	public Long getCompId() {
		return compId;
	}
	public void setCompId(Long compId) {
		this.compId = compId;
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
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getButtonTag() {
		return buttonTag;
	}
	public void setButtonTag(String buttonTag) {
		this.buttonTag = buttonTag;
	}
	public String getGpLevel() {
		return gpLevel;
	}
	public void setGpLevel(String gpLevel) {
		this.gpLevel = gpLevel;
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
