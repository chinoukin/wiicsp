package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * 样品信息基本信息
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月14日
 * @version 1.0
 */
public class SampInfoListForSynVo implements Serializable{

	private static final long serialVersionUID = -3484644397707344684L;

	/**
	 * id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "id")
	private Long id;

	/**
	 * 样品名称
	 */
	@ApiModelProperty(value = "样品名称")
	private String sampName;

	/**
	 * 样品编号
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "样品编号")
	private Long sampNum;

	/**
	 * 样品类别类型
	 */
	@ApiModelProperty(value = "样品类别类型")
	private String sampCatgType;

	/**
	 * 抽样数量
	 */
	@ApiModelProperty(value = "抽样数量")
	private Integer samplingCount;

	/**
	 * 抽样基数
	 */
	@ApiModelProperty(value = "抽样基数")
	private Integer samplingBase;

	/**
	 * 规格型号
	 */
	@ApiModelProperty(value = "规格型号")
	private String specModel;

	/**
	 * 样品批号
	 */
	@ApiModelProperty(value = "样品批号")
	private String sampBatNum;

	/**
	 * 商标名称
	 */
	@ApiModelProperty(value = "商标名称")
	private String brandName;

	/**
	 * 样品等级类型
	 */
	@ApiModelProperty(value = "样品等级类型")
	private String sampGradeType;

	/**
	 * 生产日期
	 */
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "生产日期")
	private OffsetDateTime prdctDate;

	/**
	 * 生产单位
	 */
	@ApiModelProperty(value = "生产单位")
	private String prdctUnit;

	/**
	 * 样品状态类型（未上传，已上传）
	 */
	@ApiModelProperty(value = "样品状态类型（未上传，已上传）")
	private String sampStateType;

	/**
	 * 企业id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "企业id")
	private Long compId;

	/**
	 * 品鉴会id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "品鉴会id")
	private Long judgeMeetId;

	/**
	 * 检测机构id
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "检测机构id")
	private Long detectionMechId;

	/**
	 * 检测机构名称
	 */
	@JsonSerialize(using = IdSerializer.class)
	@ApiModelProperty(value = "检测机构名称")
	private String detectionMechName;
	/**
	 * 经度
	 */
	@ApiModelProperty(value = "经度")
	private String longitude;

	/**
	 * 纬度
	 */
	@ApiModelProperty(value = "纬度")
	private String latitude;

	/**
	 * 采样人
	 */
	@ApiModelProperty(value = "采样人")
	private String sampTaker;

	/**
	 * 采样时间
	 */
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "采样时间")
	private OffsetDateTime sampDate;

	/**
	 * 检测状态（已检测、未检测）
	 */
	@ApiModelProperty(value = "检测状态（已检测、未检测）")
	private String jcStateType;

	/**
	 * 报告图片信息
	 */
	@ApiModelProperty(value = "报告图片信息")
	private List<SampImgListForSynVo> imgList = Lists.newArrayList(); // 报告图片
	/**
	 * 现场图片
	 */
	@ApiModelProperty(value = "现场图片信息")
	private List<SampImgListForSynVo> xcImgList = Lists.newArrayList();

	/**
	 * 采样时间
	 */
	@ApiModelProperty("样品发布商品的id")
	@JsonSerialize(using = IdSerializer.class)
	private Long commSampRelaId;

	/**
	 * 创建人
	 */
    protected String createBy;

    /**
	 * 创建时间
	 */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    protected OffsetDateTime createDate;

    /**
	 * 更新人
	 */
    protected String updateBy;

    /**
	 * 更新时间
	 */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    protected OffsetDateTime updateDate;

    /**
     * 检测结果
     */
    @ApiModelProperty("检测结果(0:合格1:不合格)")
    private String resultType;
    /**
     * 检测时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("检测时间")
    private OffsetDateTime detecDate;
    /**
     * 果品等级
     */
    @ApiModelProperty("果品等级")
    private String gpLevel;

    /** wangh 20191010 开始 **/
	private String sampProv;//采样地区省
	private String sampCity;//采样地区市
	private String sampCou;//采样地区县
	private String sampTown;//采样地区乡镇
	private String sampVillage;//采样地区村
	private String sampAreaCode;//采样地区编码
	/** wangh 20191010 结束 **/

	public Long getCommSampRelaId() {
		return commSampRelaId;
	}

	public void setCommSampRelaId(Long commSampRelaId) {
		this.commSampRelaId = commSampRelaId;
	}

	/**
	 * 获取id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取样品名称
	 */
	public String getSampName() {
		return sampName;
	}

	/**
	 * 设置样品名称
	 */
	public void setSampName(String sampName) {
		this.sampName = sampName == null ? null : sampName.trim();
	}

	/**
	 * 获取样品编号
	 */
	public Long getSampNum() {
		return sampNum;
	}

	/**
	 * 设置样品编号
	 */
	public void setSampNum(Long sampNum) {
		this.sampNum = sampNum;
	}

	/**
	 * 获取样品类别类型
	 */
	public String getSampCatgType() {
		return sampCatgType;
	}

	/**
	 * 设置样品类别类型
	 */
	public void setSampCatgType(String sampCatgType) {
		this.sampCatgType = sampCatgType == null ? null : sampCatgType.trim();
	}

	/**
	 * 获取抽样数量
	 */
	public Integer getSamplingCount() {
		return samplingCount;
	}

	/**
	 * 设置抽样数量
	 */
	public void setSamplingCount(Integer samplingCount) {
		this.samplingCount = samplingCount;
	}

	/**
	 * 获取抽样基数
	 */
	public Integer getSamplingBase() {
		return samplingBase;
	}

	/**
	 * 设置抽样基数
	 */
	public void setSamplingBase(Integer samplingBase) {
		this.samplingBase = samplingBase;
	}

	/**
	 * 获取规格型号
	 */
	public String getSpecModel() {
		return specModel;
	}

	/**
	 * 设置规格型号
	 */
	public void setSpecModel(String specModel) {
		this.specModel = specModel == null ? null : specModel.trim();
	}

	/**
	 * 获取样品批号
	 */
	public String getSampBatNum() {
		return sampBatNum;
	}

	/**
	 * 设置样品批号
	 */
	public void setSampBatNum(String sampBatNum) {
		this.sampBatNum = sampBatNum == null ? null : sampBatNum.trim();
	}

	/**
	 * 获取商标名称
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 设置商标名称
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName == null ? null : brandName.trim();
	}

	/**
	 * 获取样品等级类型
	 */
	public String getSampGradeType() {
		return sampGradeType;
	}

	/**
	 * 设置样品等级类型
	 */
	public void setSampGradeType(String sampGradeType) {
		this.sampGradeType = sampGradeType == null ? null : sampGradeType.trim();
	}

	/**
	 * 获取生产日期
	 */
	public OffsetDateTime getPrdctDate() {
		return prdctDate;
	}

	/**
	 * 设置生产日期
	 */
	public void setPrdctDate(OffsetDateTime prdctDate) {
		this.prdctDate = prdctDate;
	}

	/**
	 * 获取生产单位
	 */
	public String getPrdctUnit() {
		return prdctUnit;
	}

	/**
	 * 设置生产单位
	 */
	public void setPrdctUnit(String prdctUnit) {
		this.prdctUnit = prdctUnit == null ? null : prdctUnit.trim();
	}

	/**
	 * 获取样品状态类型（未上传，已上传）
	 */
	public String getSampStateType() {
		return sampStateType;
	}

	/**
	 * 设置样品状态类型（未上传，已上传）
	 */
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType == null ? null : sampStateType.trim();
	}

	/**
	 * 获取企业id
	 */
	public Long getCompId() {
		return compId;
	}

	/**
	 * 设置企业id
	 */
	public void setCompId(Long compId) {
		this.compId = compId;
	}

	/**
	 * 获取品鉴会id
	 */
	public Long getJudgeMeetId() {
		return judgeMeetId;
	}

	/**
	 * 设置品鉴会id
	 */
	public void setJudgeMeetId(Long judgeMeetId) {
		this.judgeMeetId = judgeMeetId;
	}

	/**
	 * 获取检测机构id
	 */
	public Long getDetectionMechId() {
		return detectionMechId;
	}

	/**
	 * 设置检测机构id
	 */
	public void setDetectionMechId(Long detectionMechId) {
		this.detectionMechId = detectionMechId;
	}

	/**
	 * 获取经度
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * 设置经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude == null ? null : longitude.trim();
	}

	/**
	 * 获取纬度
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * 设置纬度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude == null ? null : latitude.trim();
	}

	/**
	 * 获取采样人
	 */
	public String getSampTaker() {
		return sampTaker;
	}

	/**
	 * 设置采样人
	 */
	public void setSampTaker(String sampTaker) {
		this.sampTaker = sampTaker == null ? null : sampTaker.trim();
	}

	/**
	 * 获取采样时间
	 */
	public OffsetDateTime getSampDate() {
		return sampDate;
	}

	/**
	 * 设置采样时间
	 */
	public void setSampDate(OffsetDateTime sampDate) {
		this.sampDate = sampDate;
	}

	public String getDetectionMechName() {
		return detectionMechName;
	}

	public void setDetectionMechName(String detectionMechName) {
		this.detectionMechName = detectionMechName;
	}

	public String getJcStateType() {
		return jcStateType;
	}

	public void setJcStateType(String jcStateType) {
		this.jcStateType = jcStateType;
	}

	public List<SampImgListForSynVo> getImgList() {
		return imgList;
	}

	public void setImgList(List<SampImgListForSynVo> imgList) {
		this.imgList = imgList;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
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

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public OffsetDateTime getDetecDate() {
		return detecDate;
	}

	public void setDetecDate(OffsetDateTime detecDate) {
		this.detecDate = detecDate;
	}

	public List<SampImgListForSynVo> getXcImgList() {
		return xcImgList;
	}

	public void setXcImgList(List<SampImgListForSynVo> xcImgList) {
		this.xcImgList = xcImgList;
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
