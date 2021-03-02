package com.wisea.cultivar.origin.entity;


import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 检测样品信息（同步数据用）
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月4日
 * @version 1.0
 */
public class DeteSampInfo extends DataLongEntity<DeteSampInfo> {

	/**
	 *
	 */
	private static final long serialVersionUID = -2793566433953638149L;
	// 样品名称
	private String sampName;
	//样品编号
    private Long sampNum;
    //样品类别类型
    private String sampCatgType;
    //抽样数量
    private Integer samplingCount;
    //抽样基数
    private Integer samplingBase;
    //规格型号
    private String specModel;
    //样品批号
    private String sampBatNum;
    //商标名称
    private String brandName;
    //样品等级类型
    private String sampGradeType;
    // 生产日期
    private  String prdctDateStr;
    //生产单位
    private String prdctUnit;
    //样品状态类型（未上传，已上传）
    private String sampStateType;
    //检测机构id
    private Long detectionMechId;
    //经度
    private String longitude;
    //纬度
    private String latitude;
    //企业名称
    private String compName;
    //企业联系人
    private String compContacts;
    // 企业联系人电话
    private String compTel;
    //企业所在地区
    private String compAddress;
    //企业所在详细地址
    private String compDetailAddress;
    // 采样人
    private String sampPerson;
    // 采样时间
    private String sampDateStr;
    // 果品等级
    private String gpLevel;
    // 数据来源
    private String dataSourceType;

    private List<SampPicture> imgList = Lists.newArrayList(); //现场图片列表

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
	public String getPrdctUnit() {
		return prdctUnit;
	}
	public void setPrdctUnit(String prdctUnit) {
		this.prdctUnit = prdctUnit;
	}
	public String getSampStateType() {
		return sampStateType;
	}
	public void setSampStateType(String sampStateType) {
		this.sampStateType = sampStateType;
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
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompContacts() {
		return compContacts;
	}
	public void setCompContacts(String compContacts) {
		this.compContacts = compContacts;
	}
	public String getCompTel() {
		return compTel;
	}
	public void setCompTel(String compTel) {
		this.compTel = compTel;
	}
	public String getCompAddress() {
		return compAddress;
	}
	public void setCompAddress(String compAddress) {
		this.compAddress = compAddress;
	}
	public String getCompDetailAddress() {
		return compDetailAddress;
	}
	public void setCompDetailAddress(String compDetailAddress) {
		this.compDetailAddress = compDetailAddress;
	}
	public String getSampPerson() {
		return sampPerson;
	}
	public void setSampPerson(String sampPerson) {
		this.sampPerson = sampPerson;
	}
	public List<SampPicture> getImgList() {
		return imgList;
	}
	public void setImgList(List<SampPicture> imgList) {
		this.imgList = imgList;
	}
	public String getPrdctDateStr() {
		return prdctDateStr;
	}
	public void setPrdctDateStr(String prdctDateStr) {
		this.prdctDateStr = prdctDateStr;
	}
	public String getSampDateStr() {
		return sampDateStr;
	}
	public void setSampDateStr(String sampDateStr) {
		this.sampDateStr = sampDateStr;
	}
	public String getGpLevel() {
		return gpLevel;
	}
	public void setGpLevel(String gpLevel) {
		this.gpLevel = gpLevel;
	}
	public String getDataSourceType() {
		return dataSourceType;
	}
	public void setDataSourceType(String dataSourceType) {
		this.dataSourceType = dataSourceType;
	}
}
