package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class RealPersonAuth extends DataLongEntity<RealPersonAuth> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 身份证号
     */
    private String idCardNum;

    /**
     * 人脸采集图片
     */
    private String faceCollection;

    /**
     * 认证时间
     */
    private OffsetDateTime authDate;

    /**
     * 认证状态
     */
    private String entpAuthStateType;

    /**
     * 审核状态
     */
    private String authStateType;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getFaceCollection() {
        return faceCollection;
    }

    public void setFaceCollection(String faceCollection) {
        this.faceCollection = faceCollection;
    }

    public OffsetDateTime getAuthDate() {
        return authDate;
    }

    public void setAuthDate(OffsetDateTime authDate) {
        this.authDate = authDate;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }
}
