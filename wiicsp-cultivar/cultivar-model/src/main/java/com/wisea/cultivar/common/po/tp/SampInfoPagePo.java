package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SampInfoListForSynVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * SampInfoPagePo
 * 2018/09/18 14:36:47
 */
public class SampInfoPagePo extends PagePo<SampInfoListForSynVo> {
    private static final long serialVersionUID = 1L;

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

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "开始时间")
    private OffsetDateTime staDate;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "结束时间")
    private OffsetDateTime endDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
    private String delFlag;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubInfoId;

    public Long getCommPubInfoId() {
        return commPubInfoId;
    }

    public void setCommPubInfoId(Long commPubInfoId) {
        this.commPubInfoId = commPubInfoId;
    }

    public OffsetDateTime getStaDate() {
        return staDate;
    }

    public void setStaDate(OffsetDateTime staDate) {
        this.staDate = staDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
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

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标志
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
