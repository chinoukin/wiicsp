package com.wisea.cultivar.origin.entity;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;


/**
 * 样品信息Entity
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
public class SampInfo extends DataLongEntity<SampInfo> {
    /**
	 *
	 */
	private static final long serialVersionUID = 4712802608926154193L;

    private String sampName;

    private Long sampNum;

    private String sampCatgType;

    private Integer samplingCount;

    private Integer samplingBase;

    private String specModel;

    private String sampBatNum;

    private String brandName;

    private String sampGradeType;

    private OffsetDateTime prdctDate;

    private String prdctUnit;

    private String sampStateType;

    private Long compId;

    private Long judgeMeetId;

    private Long detectionMechId;

    private String longitude;

    private String latitude;

    private Long sampTakerId;

    private OffsetDateTime sampDate;

    private String gpLevel;

    private String dataSourceType;

    private String resultType;

    private OffsetDateTime detecDate;
    /** wangh 20191010 开始 **/
	private String sampProv;//采样地区省
	private String sampCity;//采样地区市
	private String sampCou;//采样地区县
	private String sampTown;//采样地区乡镇
	private String sampVillage;//采样地区村
	private String sampAreaCode;//采样地区编码
	/** wangh 20191010 结束 **/

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

	public OffsetDateTime getPrdctDate() {
		return prdctDate;
	}

	public void setPrdctDate(OffsetDateTime prdctDate) {
		this.prdctDate = prdctDate;
	}

	public Long getSampTakerId() {
		return sampTakerId;
	}

	public void setSampTakerId(Long sampTakerId) {
		this.sampTakerId = sampTakerId;
	}

	public OffsetDateTime getSampDate() {
		return sampDate;
	}

	public void setSampDate(OffsetDateTime sampDate) {
		this.sampDate = sampDate;
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
