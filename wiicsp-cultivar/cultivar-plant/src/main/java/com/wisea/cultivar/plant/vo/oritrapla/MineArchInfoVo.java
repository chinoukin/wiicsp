package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.plant.entity.oritrapla.MembPictureInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 *
 * @author yangtao
 * 我的档案详细信息vo
 *
 */
@ApiModel("我的档案详细信息vo")
public class MineArchInfoVo {

	@ApiModelProperty(value="我的档案id")
	@JsonSerialize(using= LongSerializer.class)
	private Long id; //我的档案id
	@ApiModelProperty(value="会员id")
	@JsonSerialize(using= LongSerializer.class)
    private Long membId; //会员id
	@ApiModelProperty(value="创建、接受人姓名")
	private String menbName;//创建、接受人姓名
	@ApiModelProperty(value="来源我的档案id")
	@JsonSerialize(using= LongSerializer.class)
    private Long mineArchId; //来源我的档案id
	@ApiModelProperty(value="档案id")
	@JsonSerialize(using= LongSerializer.class)
    private Long archId; //档案id
	@ApiModelProperty(value="种植方法id")
	@JsonSerialize(using= LongSerializer.class)
    private Long plantingMethodId; //种植方法id
	@ApiModelProperty(value="档案类型（扫码，推送，自建）")
    private String archType; //档案类型（扫码，推送，自建）
	@ApiModelProperty(value="种植方法类型")
    private String massifType; //种植方法
	@ApiModelProperty(value="我的档案状态")
	private String mineArchStatus;//我的档案状态
	@ApiModelProperty(value="档案编号")
	private String archNum; //档案编号
	@ApiModelProperty(value="地块id")
	@JsonSerialize(using= LongSerializer.class)
    private Long massifId; //地块id
	@ApiModelProperty(value="地块名称")
	private String massifName;//地块名称
	@ApiModelProperty(value="地块面积")
    private Double massifAcre; //地块面积
	@ApiModelProperty(value="品类id")
	@JsonSerialize(using= LongSerializer.class)
    private Long commId; //品类id
	@ApiModelProperty(value="品类名称")
	private String commName;//品类名称
	@ApiModelProperty(value="品种id")
	@JsonSerialize(using= LongSerializer.class)
    private Long commVarietId; //品种id
	@ApiModelProperty(value="品种名称")
	private String variName;//品种名称
	@ApiModelProperty(value="种植标准类型")
    private String plantType; //种植标准类型
	@ApiModelProperty(value="开始日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime startDate; //开始日期
	@ApiModelProperty(value="结束日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime endDate; //结束日期
	@ApiModelProperty(value="创建、接收日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime createDate; //创建、接收日期
	@ApiModelProperty(value="种植面积")
    private Double plantAcre; //种植面积
	@ApiModelProperty(value="预计产量")
    private Double estOutput; //预计产量
	@ApiModelProperty(value="预计上市日期")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime estListDate; //预计上市日期
	@ApiModelProperty(value="图片url")
    private String url; //图片url
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value="更新日期(排他校验，编辑的时候传)")
    private OffsetDateTime updateDate; //更新日期
	/**  货源信息  */
	@ApiModelProperty(value="来源会员id")
    private Long sourceMembId; //来源会员id
	@ApiModelProperty(value="来源农场或公司名称")
	private String sourceOrgName;//来源农场或公司名称
	@ApiModelProperty(value="来源联系人姓名")
	private String sourceContName;//来源联系人姓名
	@ApiModelProperty(value="来源联系人电话")
	private String sourceContTel;//来源联系人电话
	@ApiModelProperty(value="来源联系详细地址")
	private String sourceAddress;//来源联系详细地址
	@ApiModelProperty(value="来源地址,省")
	private String sourceAreaCodeProv;//来源地址,省
	@ApiModelProperty(value="来源地址,市")
	private String sourceAreaCodeCity;//来源地址,市
	@ApiModelProperty(value="来源地址,县")
	private String sourceAreaCodeCou;//来源地址,县
	/**  公司信息  */
	@ApiModelProperty(value="公司会员名称")
	private String orgName;//农场或公司名称
	@ApiModelProperty(value="公司介绍")
	private String introduce;//介绍
	@ApiModelProperty(value="公司联系人姓名")
	private String contName;//公司联系人姓名
	@ApiModelProperty(value="公司联系人电话")
	private String contTel;//公司联系人电话
	@ApiModelProperty(value="公司联系详细地址")
	private String address;//公司联系详细地址
	@ApiModelProperty(value="公司地址,省")
	private String areaCodeProv;//公司地址,省
	@ApiModelProperty(value="公司地址,市")
	private String areaCodeCity;//公司地址,市
	@ApiModelProperty(value="公司地址,县")
	private String areaCodeCou;//公司地址,县
	@ApiModelProperty(value="会员照片（资质等）")
	private List<MembPictureInfo> membPictureList;
	@ApiModelProperty(value="品牌信息")
	private List<BrandInfoVo> brandInfoVo;//品牌信息
	@ApiModelProperty(value="农事记录")
	private List<FarmWorkRecdVo> farmWorkRecdVoList;
	@ApiModelProperty(value="检测记录")
	private List<ExamRecdVo> examRecdVoList;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

	public Long getPlantingMethodId() {
		return plantingMethodId;
	}

	public void setPlantingMethodId(Long plantingMethodId) {
		this.plantingMethodId = plantingMethodId;
	}

	public String getMassifType() {
		return massifType;
	}

	public void setMassifType(String massifType) {
		this.massifType = massifType;
	}

	public Long getSourceMembId() {
        return sourceMembId;
    }

    public void setSourceMembId(Long sourceMembId) {
        this.sourceMembId = sourceMembId;
    }

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public String getArchType() {
        return archType;
    }

    public void setArchType(String archType) {
        this.archType = archType;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMenbName() {
		return menbName;
	}

	public void setMenbName(String menbName) {
		this.menbName = menbName;
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

	public Long getMassifId() {
		return massifId;
	}

	public void setMassifId(Long massifId) {
		this.massifId = massifId;
	}

	public String getMassifName() {
		return massifName;
	}

	public void setMassifName(String massifName) {
		this.massifName = massifName;
	}

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public Long getCommVarietId() {
		return commVarietId;
	}

	public void setCommVarietId(Long commVarietId) {
		this.commVarietId = commVarietId;
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

	public Double getMassifAcre() {
		return massifAcre;
	}

	public void setMassifAcre(Double massifAcre) {
		this.massifAcre = massifAcre;
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

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getSourceOrgName() {
		return sourceOrgName;
	}

	public void setSourceOrgName(String sourceOrgName) {
		this.sourceOrgName = sourceOrgName;
	}

	public String getSourceContName() {
		return sourceContName;
	}

	public void setSourceContName(String sourceContName) {
		this.sourceContName = sourceContName;
	}

	public String getSourceContTel() {
		return sourceContTel;
	}

	public void setSourceContTel(String sourceContTel) {
		this.sourceContTel = sourceContTel;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getSourceAreaCodeProv() {
		return sourceAreaCodeProv;
	}

	public void setSourceAreaCodeProv(String sourceAreaCodeProv) {
		this.sourceAreaCodeProv = sourceAreaCodeProv;
	}

	public String getSourceAreaCodeCity() {
		return sourceAreaCodeCity;
	}

	public void setSourceAreaCodeCity(String sourceAreaCodeCity) {
		this.sourceAreaCodeCity = sourceAreaCodeCity;
	}

	public String getSourceAreaCodeCou() {
		return sourceAreaCodeCou;
	}

	public void setSourceAreaCodeCou(String sourceAreaCodeCou) {
		this.sourceAreaCodeCou = sourceAreaCodeCou;
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

	public List<BrandInfoVo> getBrandInfoVo() {
		return brandInfoVo;
	}

	public void setBrandInfoVo(List<BrandInfoVo> brandInfoVo) {
		this.brandInfoVo = brandInfoVo;
	}

	public List<FarmWorkRecdVo> getFarmWorkRecdVoList() {
		return farmWorkRecdVoList;
	}

	public void setFarmWorkRecdVoList(List<FarmWorkRecdVo> farmWorkRecdVoList) {
		this.farmWorkRecdVoList = farmWorkRecdVoList;
	}

	public List<ExamRecdVo> getExamRecdVoList() {
		return examRecdVoList;
	}

	public void setExamRecdVoList(List<ExamRecdVo> examRecdVoList) {
		this.examRecdVoList = examRecdVoList;
	}
}
