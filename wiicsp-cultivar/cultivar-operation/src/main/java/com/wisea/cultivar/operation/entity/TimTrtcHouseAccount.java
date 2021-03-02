package com.wisea.cultivar.operation.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * tim_trtc_house_account 表实体
 * 实时音视频房间成员表
 * 2020/08/07 17:16:38
 */
public class TimTrtcHouseAccount extends DataLongEntity<TimTrtcHouseAccount> {
    private static final long serialVersionUID = 1L;

    /**
     * 房间id
     */
    private Long houseId;

    /**
     * 进入者ID
     */
    private Long accountId;

    /**
     *
     * @mbg.generated
     */
    public TimTrtcHouseAccount() {
        super();
    }

    /**
     * 获取房间id
     */
    public Long getHouseId() {
        return houseId;
    }

    /**
     * 设置房间id
     */
    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    /**
     * 获取进入者ID
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * 设置进入者ID
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
