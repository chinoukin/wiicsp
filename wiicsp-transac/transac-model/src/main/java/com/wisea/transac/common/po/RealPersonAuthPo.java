package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("实人认证新增或修改Po")
public class RealPersonAuthPo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id",hidden = true)
    private Long membId;

    @ApiModelProperty(value="真实姓名")
    @Check(test = { "required" })
    private String realName;

    @ApiModelProperty(value="身份证号")
    @Check(test = { "required" })
    private String idCardNum;

    @ApiModelProperty(value="人脸采集图片")
    private String faceCollection;

    @ApiModelProperty(value="认证时间",hidden = true)
    private OffsetDateTime authDate;

    @ApiModelProperty(value="认证状态",hidden = true)
    private String entpAuthStateType;

    @ApiModelProperty(value="审核状态",hidden = true)
    private String authStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
