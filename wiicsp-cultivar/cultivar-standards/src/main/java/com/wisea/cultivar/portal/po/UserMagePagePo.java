package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.portal.vo.UserMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * UserMagePagePo
 * 2020/08/24 20:28:13
 */
public class UserMagePagePo extends PagePo<UserMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * sys_user_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "sys_user_id")
    private Long sysUserId;

    /**
     * 成员姓名
     */
    @ApiModelProperty(value = "成员姓名")
    private String userName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String tel;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;


    @ApiModelProperty(value = "条件查询姓名或手机号")
    private String nameAndPhone;

  /*  @ApiModelProperty(value = "条件查询状态")
    private String activeFlag;*/
    @Check(test = { "maxLength" }, mixLength = 256)
    @ApiModelProperty(value = "条件查询状态", allowableValues = "mixLength:(,256]")
    private String loginFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取sys_user_id
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * 设置sys_user_id
     */
    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    /**
     * 获取成员姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置成员姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getNameAndPhone() {
        return nameAndPhone;
    }

    public void setNameAndPhone(String nameAndPhone) {
        this.nameAndPhone = nameAndPhone;
    }

    public String getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(String loginFlag) {
        this.loginFlag = loginFlag;
    }
}
