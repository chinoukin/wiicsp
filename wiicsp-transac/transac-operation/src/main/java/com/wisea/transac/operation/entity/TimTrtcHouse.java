package com.wisea.transac.operation.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * tim_trtc_house 表实体
 * 实时音视频房间表
 * 2020/08/07 17:16:38
 */
public class TimTrtcHouse extends DataLongEntity<TimTrtcHouse> {
    private static final long serialVersionUID = 1L;

    /**
     * 房间号
     */
    private Integer houseNum;

    /**
     * 正在使用 0:否 1:是
     */
    private String onUse;

    /**
     *
     * @mbg.generated
     */
    public TimTrtcHouse() {
        super();
    }

    /**
     * 获取房间号
     */
    public Integer getHouseNum() {
        return houseNum;
    }

    /**
     * 设置房间号
     */
    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    /**
     * 获取正在使用 0:否 1:是
     */
    public String getOnUse() {
        return onUse;
    }

    /**
     * 设置正在使用 0:否 1:是
     */
    public void setOnUse(String onUse) {
        this.onUse = onUse == null ? null : onUse.trim();
    }
}
