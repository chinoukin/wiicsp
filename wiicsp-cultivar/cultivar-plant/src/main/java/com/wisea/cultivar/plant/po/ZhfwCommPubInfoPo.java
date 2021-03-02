package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改ZhfwCommPubInfoPo")
public class ZhfwCommPubInfoPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="会员id（服务商）")
    private Long membId;

    @ApiModelProperty(value="商品标题")
    private String commTitle;

    @ApiModelProperty(value="品类id")
    private Long commId;

    @ApiModelProperty(value="商品品种id")
    private Long commVarietId;

    @ApiModelProperty(value="发货地省")
    private String commSendProv;

    @ApiModelProperty(value="发货地市")
    private String commSendCity;

    @ApiModelProperty(value="发货区县")
    private String commSendCou;

    @ApiModelProperty(value="发货地详细地址")
    private String commSendAddress;

    @ApiModelProperty(value="商品描述")
    private String commSignature;

    @ApiModelProperty(value="购买须知")
    private String notesToBuy;

    @ApiModelProperty(value="商品发布状态")
    private String commStateType;

    @ApiModelProperty(value="驳回原因（审核意见）")
    private String rejectReason;

    @ApiModelProperty(value="审核人id(后台管理员id)")
    private Long examId;

    @ApiModelProperty(value="销量")
    private Double salesVolume;

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

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public String getCommSendProv() {
        return commSendProv;
    }

    public void setCommSendProv(String commSendProv) {
        this.commSendProv = commSendProv;
    }

    public String getCommSendCity() {
        return commSendCity;
    }

    public void setCommSendCity(String commSendCity) {
        this.commSendCity = commSendCity;
    }

    public String getCommSendCou() {
        return commSendCou;
    }

    public void setCommSendCou(String commSendCou) {
        this.commSendCou = commSendCou;
    }

    public String getCommSendAddress() {
        return commSendAddress;
    }

    public void setCommSendAddress(String commSendAddress) {
        this.commSendAddress = commSendAddress;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getNotesToBuy() {
        return notesToBuy;
    }

    public void setNotesToBuy(String notesToBuy) {
        this.notesToBuy = notesToBuy;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }
}
