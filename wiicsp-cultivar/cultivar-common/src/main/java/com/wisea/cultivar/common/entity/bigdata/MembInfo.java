package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import java.time.OffsetDateTime;

/**
 * memb_info 表实体
 * 用户管理
 * 2019/12/02 11:02:14
 */
public class MembInfo extends DataLongEntity<MembInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @ExcelField(title = "用户名",sort = 1,width = 20)
    private String userName;

    /**
     * 姓名
     */
    @ExcelField(title = "姓名",sort = 10,width = 20)
    private String xmName;

    /**
     * 部门名称
     */
    @ExcelField(title = "部门名称",sort = 20,width = 20)
    private String bmName;

    /**
     * 密码
     */
    @ExcelField(title = "密码",sort = 30,width = 20)
    private String password;

    /**
     * 权限类型
     */
    @ExcelField(title = "权限类型",sort = 40,width = 20)
    private String qxType;

    /**
     * 注册时间
     */
    @ExcelField(title = "注册时间",width = 20,sort = 50,formate = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime zcDate;

    /**
     * 是否启用标志
     */
    @ExcelField(title = "是否启用标志",sort = 60,width = 20)
    private String sfqyFlag;

    /**
     * 获取用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取姓名
     */
    public String getXmName() {
        return xmName;
    }

    /**
     * 设置姓名
     */
    public void setXmName(String xmName) {
        this.xmName = xmName == null ? null : xmName.trim();
    }

    /**
     * 获取部门名称
     */
    public String getBmName() {
        return bmName;
    }

    /**
     * 设置部门名称
     */
    public void setBmName(String bmName) {
        this.bmName = bmName == null ? null : bmName.trim();
    }

    /**
     * 获取密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取权限类型
     */
    public String getQxType() {
        return qxType;
    }

    /**
     * 设置权限类型
     */
    public void setQxType(String qxType) {
        this.qxType = qxType == null ? null : qxType.trim();
    }

    /**
     * 获取注册时间
     */
    public OffsetDateTime getZcDate() {
        return zcDate;
    }

    /**
     * 设置注册时间
     */
    public void setZcDate(OffsetDateTime zcDate) {
        this.zcDate = zcDate;
    }

    /**
     * 获取是否启用标志
     */
    public String getSfqyFlag() {
        return sfqyFlag;
    }

    /**
     * 设置是否启用标志
     */
    public void setSfqyFlag(String sfqyFlag) {
        this.sfqyFlag = sfqyFlag == null ? null : sfqyFlag.trim();
    }
}
