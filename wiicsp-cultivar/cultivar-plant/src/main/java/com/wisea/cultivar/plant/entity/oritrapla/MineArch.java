package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 我的档案
 */
public class MineArch extends DataLongEntity<MineArch> {
    private Long membId; //会员id
    private Long sourceMembId; //来源会员id
    private Long mineArchId; //来源我的档案id
    private Long archId; //档案id
    private String archType; //档案类型（扫码，推送，自建）
    private String mineArchStatus;//我的档案状态

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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

	public String getMineArchStatus() {
		return mineArchStatus;
	}

	public void setMineArchStatus(String mineArchStatus) {
		this.mineArchStatus = mineArchStatus;
	}
}
