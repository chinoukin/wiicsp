package com.wisea.cultivar.common.po.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author wangjiahao
 * @version 1.0
 * @className OriSaleClInfoInsertPo
 * @since 2019-03-22 16:07
 */
@ApiModel("销售出栏插入对象")
public class OriSaleClInfoInsertPo  {


    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "membId")
    private Long membId;

    /**
     * 出栏批次
     */
    @ApiModelProperty(value = "出栏批次")
    @Check(test = "required")
    private String clBatch;

    /**
     * 出栏数量
     */
    @ApiModelProperty(value = "出栏数量")
    @Check(test = "required")
    private Integer clCount;

    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
    private String acctName;

    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String contacts;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String tel;

    /**
     * 出栏日期
     */
    @ApiModelProperty(value = "出栏日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @Check(test = "required")
    private OffsetDateTime clDate;

    /**
     * 追溯码url
     */
    @ApiModelProperty(value = "追溯码url")
    private String zsmUrl;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;


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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
