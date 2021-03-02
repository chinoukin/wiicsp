package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * yj_mage 表实体
 * 预警设置
 * 2019/08/23 10:49:05
 */
public class YjMage extends DataLongEntity<YjMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 档案id
     */
    private Long archId;

    /**
     * 会员id
     */
    private Long membInfo;

    /**
     * 预警手机
     */
    private String yjTel;

    /**
     * 短信推送标志
     */
    private String massgePushFlag;

    /**
     * 系统消息推送标志
     */
    private String massgeSysPushFlag;

    /**
     * 获取档案id
     */
    public Long getArchId() {
        return archId;
    }

    /**
     * 设置档案id
     */
    public void setArchId(Long archId) {
        this.archId = archId;
    }

    /**
     * 获取会员id
     */
    public Long getMembInfo() {
        return membInfo;
    }

    /**
     * 设置会员id
     */
    public void setMembInfo(Long membInfo) {
        this.membInfo = membInfo;
    }

    /**
     * 获取预警手机
     */
    public String getYjTel() {
        return yjTel;
    }

    /**
     * 设置预警手机
     */
    public void setYjTel(String yjTel) {
        this.yjTel = yjTel == null ? null : yjTel.trim();
    }

    /**
     * 获取短信推送标志
     */
    public String getMassgePushFlag() {
        return massgePushFlag;
    }

    /**
     * 设置短信推送标志
     */
    public void setMassgePushFlag(String massgePushFlag) {
        this.massgePushFlag = massgePushFlag == null ? null : massgePushFlag.trim();
    }

    /**
     * 获取系统消息推送标志
     */
    public String getMassgeSysPushFlag() {
        return massgeSysPushFlag;
    }

    /**
     * 设置系统消息推送标志
     */
    public void setMassgeSysPushFlag(String massgeSysPushFlag) {
        this.massgeSysPushFlag = massgeSysPushFlag == null ? null : massgeSysPushFlag.trim();
    }
}
