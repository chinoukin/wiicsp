package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import com.wisea.cultivar.plant.entity.oritrapla.MembPictureInfo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * Auth： jirg
 * CreateDate:  2018/6/7
 * projectName:  oritrapla
 * remark:  追溯档案查询
 */
public class RtspMineArchInfoVo {
    @ApiModelProperty(value="我的档案id")
    private Long id;
    @ApiModelProperty("档案名称")
    private String mineArchName;
    @ApiModelProperty(value="会员id")
    private Long membId;
    @ApiModelProperty(value="我的档案状态")
    private String mineArchStatus;
    @ApiModelProperty(value="档案编号")
    private String archNum;
    @ApiModelProperty(value="地块名称")
    private String massifName;
    @ApiModelProperty(value="品类名称")
    private String commName;
    @ApiModelProperty(value="品种名称")
    private String variName;
    @ApiModelProperty(value="种植标准类型")
    private String plantType;
    @ApiModelProperty(value="开始日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty(value="结束日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime endDate;
    @ApiModelProperty(value="种植面积")
    private Double plantAcre;
    @ApiModelProperty(value="预计产量")
    private Double estOutput;
    @ApiModelProperty(value="预计上市日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime estListDate;
    @ApiModelProperty(value="图片url")
    private String url;
    /**  检测记录  **/
    @ApiModelProperty(value="检测记录")
    private List<ExamRecdVo> examRecdVoList;
    /**  农事记录  **/
    @ApiModelProperty(value="农事记录")
    private List<FarmWorkRecdVo> farmWorkRecdVoList;
    /**  主体信息  **/
    @ApiModelProperty(value="品牌信息")
    private List<BrandInfoVo> brandInfos;
    @ApiModelProperty(value="农场或公司名称")
    private String orgName;
    @ApiModelProperty(value="公司介绍")
    private String introduce;
    @ApiModelProperty(value="公司联系人姓名")
    private String contName;
    @ApiModelProperty(value="公司联系人电话")
    private String contTel;
    @ApiModelProperty(value="公司联系详细地址")
    private String address;
    @ApiModelProperty(value="公司地址,省")
    private String areaCodeProv;
    @ApiModelProperty(value="公司地址,市")
    private String areaCodeCity;
    @ApiModelProperty(value="公司地址,县")
    private String areaCodeCou;
    @ApiModelProperty(value="会员照片（资质等）")
    private List<MembPictureInfo> membPictureList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMineArchName() {
        return mineArchName;
    }

    public void setMineArchName(String mineArchName) {
        this.mineArchName = mineArchName;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMineArchStatus() {
        return mineArchStatus;
    }

    public void setMineArchStatus(String mineArchStatus) {
        this.mineArchStatus = mineArchStatus;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getVariName() {
        return variName;
    }

    public void setVariName(String variName) {
        this.variName = variName;
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

    public List<ExamRecdVo> getExamRecdVoList() {
        return examRecdVoList;
    }

    public void setExamRecdVoList(List<ExamRecdVo> examRecdVoList) {
        this.examRecdVoList = examRecdVoList;
    }

    public List<FarmWorkRecdVo> getFarmWorkRecdVoList() {
        return farmWorkRecdVoList;
    }

    public void setFarmWorkRecdVoList(List<FarmWorkRecdVo> farmWorkRecdVoList) {
        this.farmWorkRecdVoList = farmWorkRecdVoList;
    }

    public List<BrandInfoVo> getBrandInfos() {
        return brandInfos;
    }

    public void setBrandInfos(List<BrandInfoVo> brandInfos) {
        this.brandInfos = brandInfos;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAreaCodeProv() {
        return areaCodeProv;
    }

    public void setAreaCodeProv(String areaCodeProv) {
        this.areaCodeProv = areaCodeProv;
    }

    public String getAreaCodeCity() {
        return areaCodeCity;
    }

    public void setAreaCodeCity(String areaCodeCity) {
        this.areaCodeCity = areaCodeCity;
    }

    public String getAreaCodeCou() {
        return areaCodeCou;
    }

    public void setAreaCodeCou(String areaCodeCou) {
        this.areaCodeCou = areaCodeCou;
    }

    public List<MembPictureInfo> getMembPictureList() {
        return membPictureList;
    }

    public void setMembPictureList(List<MembPictureInfo> membPictureList) {
        this.membPictureList = membPictureList;
    }
}
