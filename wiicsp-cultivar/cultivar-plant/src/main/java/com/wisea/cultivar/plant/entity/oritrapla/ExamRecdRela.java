package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ExamRecdRela extends DataLongEntity<ExamRecdRela> {
    /**
     * 档案id
     */
    private Long archId;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 我的档案id
     */
    private Long mineArchId;


    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

	public Long getMineArchId() {
		return mineArchId;
	}

	public void setMineArchId(Long mineArchId) {
		this.mineArchId = mineArchId;
	}
}
