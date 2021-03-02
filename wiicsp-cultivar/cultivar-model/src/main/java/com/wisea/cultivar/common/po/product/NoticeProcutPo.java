package com.wisea.cultivar.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description: 商家app 通知消息信息
 * @author: wangs
 * @date :2020/6/5
 */
@ApiModel("商家app 通知消息信息传入参数")
public class NoticeProcutPo {

    @ApiModelProperty("商品id")
    private Long commPubInfoId;
    @ApiModelProperty("商品状态; 审核通过 0;")
    private String commPubStateType;
    @ApiModelProperty("商品标题")
    private String commTitle;
    @ApiModelProperty("审核原因")
    private String auditReasons;
    @ApiModelProperty("会员id")
    private Long membId;
    @ApiModelProperty("档口id")
    private Long staffMageId;

    @ApiModelProperty("通知类型type 库存紧张:0,库存不足:1")
    private String noticeType;
    @ApiModelProperty("规格名称")
    private String specName;

    @ApiModelProperty("档口ids")
    private List<Long> staffMageIds;

    public List<Long> getStaffMageIds() {
        return staffMageIds;
    }

    public void setStaffMageIds(List<Long> staffMageIds) {
        this.staffMageIds = staffMageIds;
    }

    public Long getStaffMageId() {
        return staffMageId;
    }

    public void setStaffMageId(Long staffMageId) {
        this.staffMageId = staffMageId;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getAuditReasons() {
        return auditReasons;
    }

    public void setAuditReasons(String auditReasons) {
        this.auditReasons = auditReasons;
    }

    public Long getCommPubInfoId() {
        return commPubInfoId;
    }

    public void setCommPubInfoId(Long commPubInfoId) {
        this.commPubInfoId = commPubInfoId;
    }

    public String getCommPubStateType() {
        return commPubStateType;
    }

    public void setCommPubStateType(String commPubStateType) {
        this.commPubStateType = commPubStateType;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }
}
