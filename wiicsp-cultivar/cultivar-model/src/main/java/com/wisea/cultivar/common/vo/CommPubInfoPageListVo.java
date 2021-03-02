package com.wisea.cultivar.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class CommPubInfoPageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品编号")
    private String commNum;

    @ApiModelProperty(value="会员id（商家）")
    private Long membId;

    @ApiModelProperty(value="销售员工id")
    private Long saleStaffId;

    @ApiModelProperty(value="档口id")
    private Long stallsMageId;

    @ApiModelProperty(value="品类id")
    private Long commId;

    @ApiModelProperty(value="商品标题")
    private String commTitle;

    @ApiModelProperty(value="商品品种id")
    private Long commVarietId;

    @ApiModelProperty(value="商品品牌id")
    private Long brandMageId;

    @ApiModelProperty(value="产地类型")
    private String originPlaceType;

    @ApiModelProperty(value="国外产地id")
    private Long abroadId;

    @ApiModelProperty(value="商品产地省")
    private String commLocalProv;

    @ApiModelProperty(value="商品产地市")
    private String commLocalCity;

    @ApiModelProperty(value="商品产地区县")
    private String commLocalCou;

    @ApiModelProperty(value="商品描述")
    private String commSignature;

    @ApiModelProperty(value="推荐语")
    private String recommend;

    @ApiModelProperty(value="购买须知")
    private String notesToBuy;

    @ApiModelProperty(value="商品发布状态")
    private String commStateType;

    @ApiModelProperty(value="驳回原因（审核意见）")
    private String rejectReason;

    @ApiModelProperty(value="审核人id(后台管理员id)")
    private Long examId;

    @ApiModelProperty(value="商品销售分类id")
    private Long commSaleCatgId;

    @ApiModelProperty(value="版本号")
    private String versionNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getSaleStaffId() {
        return saleStaffId;
    }

    public void setSaleStaffId(Long saleStaffId) {
        this.saleStaffId = saleStaffId;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public Long getBrandMageId() {
        return brandMageId;
    }

    public void setBrandMageId(Long brandMageId) {
        this.brandMageId = brandMageId;
    }

    public String getOriginPlaceType() {
        return originPlaceType;
    }

    public void setOriginPlaceType(String originPlaceType) {
        this.originPlaceType = originPlaceType;
    }

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
    }

    public String getCommLocalProv() {
        return commLocalProv;
    }

    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv;
    }

    public String getCommLocalCity() {
        return commLocalCity;
    }

    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity;
    }

    public String getCommLocalCou() {
        return commLocalCou;
    }

    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
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

    public Long getCommSaleCatgId() {
        return commSaleCatgId;
    }

    public void setCommSaleCatgId(Long commSaleCatgId) {
        this.commSaleCatgId = commSaleCatgId;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }
}
