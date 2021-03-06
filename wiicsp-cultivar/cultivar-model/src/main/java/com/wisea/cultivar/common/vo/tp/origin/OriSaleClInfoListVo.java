package com.wisea.cultivar.common.vo.tp.origin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @className OriSaleClInfoListVo
 * @since 2019-03-22 16:06
 */
@ApiModel("销售出栏信息")
public class OriSaleClInfoListVo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

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
    private String clBatch;

    /**
     * 出栏数量
     */
    @ApiModelProperty(value = "出栏数量")
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

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "已选入栏牦牛数量")
    private Integer rlCount;

    @ApiModelProperty(value = "基地地址")
    private String address;

    @ApiModelProperty(value = "入栏批次列表")
    private List<RlBatchVo> batchs;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRlCount() {
        return rlCount;
    }

    public void setRlCount(Integer rlCount) {
        this.rlCount = rlCount;
    }

    public List<RlBatchVo> getBatchs() {
        return batchs;
    }

    public void setBatchs(List<RlBatchVo> batchs) {
        this.batchs = batchs;
    }

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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
