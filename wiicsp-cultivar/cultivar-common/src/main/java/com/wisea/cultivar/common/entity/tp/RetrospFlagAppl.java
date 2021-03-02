package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;
import java.util.List;

public class RetrospFlagAppl extends DataLongEntity<RetrospFlagAppl> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 追溯批次管理id
     */
    private Long retrospPcMageId;

    /**
     * 产品名称
     */
    private String prdutName;

    /**
     * 产地
     */
    private String placeOrigin;

    /**
     * 追溯标签类型
     */
    private String retroLabelType;

    /**
     * 申请数量
     */
    private Integer applSl;

    /**
     * 退货地址id
     */
    private Long refundCommAddressId;

    /**
     * 申请日期
     */
    private OffsetDateTime applDate;

    /**
     * 追溯标签状态
     */
    private String retroLabelState;

    /**
     * 追溯标签文件url
     */
    private String fileUrl;

    /**
     * 追溯标签excel文件url
     */
    private String excelFileUrl;

    /**
     * 申请方式类型
     */
    private String applModeType;

    /**
     * 开始编号
     */
    private Integer startNum;

    /*********Vo*********/
    /**
     * 追溯标签申请属性列表
     **/
    private List<RetrospFlagApplAttributeMage> flagApplAttributes;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getRetrospPcMageId() {
        return retrospPcMageId;
    }

    public void setRetrospPcMageId(Long retrospPcMageId) {
        this.retrospPcMageId = retrospPcMageId;
    }

    public String getPrdutName() {
        return prdutName;
    }

    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public Integer getApplSl() {
        return applSl;
    }

    public void setApplSl(Integer applSl) {
        this.applSl = applSl;
    }

    public Long getRefundCommAddressId() {
        return refundCommAddressId;
    }

    public void setRefundCommAddressId(Long refundCommAddressId) {
        this.refundCommAddressId = refundCommAddressId;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getRetroLabelState() {
        return retroLabelState;
    }

    public void setRetroLabelState(String retroLabelState) {
        this.retroLabelState = retroLabelState;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getExcelFileUrl() {
        return excelFileUrl;
    }

    public void setExcelFileUrl(String excelFileUrl) {
        this.excelFileUrl = excelFileUrl;
    }

    public String getApplModeType() {
        return applModeType;
    }

    public void setApplModeType(String applModeType) {
        this.applModeType = applModeType;
    }

    public Integer getStartNum() {
        return startNum;
    }

    public void setStartNum(Integer startNum) {
        this.startNum = startNum;
    }

    public List<RetrospFlagApplAttributeMage> getFlagApplAttributes() {
        return flagApplAttributes;
    }

    public void setFlagApplAttributes(List<RetrospFlagApplAttributeMage> flagApplAttributes) {
        this.flagApplAttributes = flagApplAttributes;
    }
}
