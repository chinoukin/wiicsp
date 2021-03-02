package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * zhfw_fin_ser_appl_record 表实体
 * 种植服务金融服务申请记录
 * 2020/08/24 20:28:13
 */
public class ZhfwFinSerApplRecord extends DataLongEntity<ZhfwFinSerApplRecord> {
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 申报内容
     */
    private String content;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 提交日期
     */
    private OffsetDateTime applDate;

    /**
     *
     * @mbg.generated
     */
    public ZhfwFinSerApplRecord() {
        super();
    }

    /**
     * 获取姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
     * 获取申报内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置申报内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 获取邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取提交日期
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置提交日期
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }
}
