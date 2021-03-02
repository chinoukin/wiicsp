package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * @Author jirg
 * @Date 2019/3/22 15:38
 * @Description 销售出栏信息
 **/
public class OriSaleClInfo extends DataLongEntity<OriSaleClInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 出栏批次
     */
    private String clBatch;

    /**
     * 出栏数量
     */
    private Integer clCount;

    /**
     * 客户名称
     */
    private String acctName;

    /**
     * 负责人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 出栏日期
     */
    private OffsetDateTime clDate;

    /**
     * 追溯码url
     */
    private String zsmUrl;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getClBatch() {
        return clBatch;
    }

    public void setClBatch(String clBatch) {
        this.clBatch = clBatch;
    }

    public Integer getClCount() {
        return clCount;
    }

    public void setClCount(Integer clCount) {
        this.clCount = clCount;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public OffsetDateTime getClDate() {
        return clDate;
    }

    public void setClDate(OffsetDateTime clDate) {
        this.clDate = clDate;
    }

    public String getZsmUrl() {
        return zsmUrl;
    }

    public void setZsmUrl(String zsmUrl) {
        this.zsmUrl = zsmUrl;
    }
}
