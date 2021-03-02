package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cultivar.plant.entity.oritrapla.MembPictureInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 *
 * @author yangtao
 * 我的档案详细信息vo
 *
 */
@ApiModel("我的档案信息vo")
public class MineArchVo {

	@ApiModelProperty(value="我的档案id")
	@JsonSerialize(using= LongSerializer.class)
	private Long id; //我的档案id
	@ApiModelProperty(value="来源我的档案id")
	@JsonSerialize(using= LongSerializer.class)
    private Long mineArchId; //来源我的档案id
	@ApiModelProperty(value="档案id")
	@JsonSerialize(using= LongSerializer.class)
    private Long archId; //档案id
    @ApiModelProperty(value="档案基础信息")
	private ArchBasicInfoVo archBasicInfoVo;//档案基础信息
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArchBasicInfoVo getArchBasicInfoVo() {
		return archBasicInfoVo;
	}

	public void setArchBasicInfoVo(ArchBasicInfoVo archBasicInfoVo) {
		this.archBasicInfoVo = archBasicInfoVo;
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
