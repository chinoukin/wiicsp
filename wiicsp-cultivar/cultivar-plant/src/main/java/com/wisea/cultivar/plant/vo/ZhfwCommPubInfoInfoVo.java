package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("ZhfwCommPubInfo详细信息Vo")
public class ZhfwCommPubInfoInfoVo {
    @ApiModelProperty(value="商品发布id")
    private Long id;

    @ApiModelProperty(value="会员id（服务商）")
    private Long membId;

    @ApiModelProperty(value="商品标题")
    private String commTitle;

    @ApiModelProperty(value="品类id")
    private Long commId;
    @ApiModelProperty(value="分类名称")
    private String commCatgName;
    @ApiModelProperty(value="父分类的名称")
    private String pCommCatgName;
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

    @ApiModelProperty(value = "商品发布价格区间")
    private ZhfwLevelSpecQuoteInfoVo zhfwLevelSpecQuoteInfoVo;

    @ApiModelProperty(value = "商品发布图片集合")
    private List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVoList;
    @ApiModelProperty(value = "商品发布图片 细节图片")
    private List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVoList2;

    @ApiModelProperty(value = "商品发布规格集合")
    private List<ZhfwCommAttriInfoVo> zhfwCommAttriInfoVoList;

    @ApiModelProperty(value="收藏状态 如果有值说明收藏了  他的值就是收藏表的id")
    private Long membCollectionId;
    @ApiModelProperty(value = "证书信息")
    private List<CertMageInfoVo> certMageInfoVoList;
    @ApiModelProperty(value="店铺id")
    private Long shopId;

    @ApiModelProperty(value="店铺名称")
    private String shopName;
    @ApiModelProperty(value = "计量单位")
    private ZhfwMeasUnitMageInfoVo zhfwMeasUnitMageInfoVo;
    @ApiModelProperty(value = "农资农技的详情描述")
    private String commCurrencyContent;


    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<ZhfwCommPictureInfoVo> getZhfwCommPictureInfoVoList2() {
        return zhfwCommPictureInfoVoList2;
    }

    public void setZhfwCommPictureInfoVoList2(List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVoList2) {
        this.zhfwCommPictureInfoVoList2 = zhfwCommPictureInfoVoList2;
    }

    public String getCommCurrencyContent() {
        return commCurrencyContent;
    }

    public void setCommCurrencyContent(String commCurrencyContent) {
        this.commCurrencyContent = commCurrencyContent;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getpCommCatgName() {
        return pCommCatgName;
    }

    public void setpCommCatgName(String pCommCatgName) {
        this.pCommCatgName = pCommCatgName;
    }

    public ZhfwMeasUnitMageInfoVo getZhfwMeasUnitMageInfoVo() {
        return zhfwMeasUnitMageInfoVo;
    }

    public void setZhfwMeasUnitMageInfoVo(ZhfwMeasUnitMageInfoVo zhfwMeasUnitMageInfoVo) {
        this.zhfwMeasUnitMageInfoVo = zhfwMeasUnitMageInfoVo;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public List<CertMageInfoVo> getCertMageInfoVoList() {
        return certMageInfoVoList;
    }

    public void setCertMageInfoVoList(List<CertMageInfoVo> certMageInfoVoList) {
        this.certMageInfoVoList = certMageInfoVoList;
    }

    public Long getMembCollectionId() {
        return membCollectionId;
    }

    public void setMembCollectionId(Long membCollectionId) {
        this.membCollectionId = membCollectionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZhfwLevelSpecQuoteInfoVo getZhfwLevelSpecQuoteInfoVo() {
        return zhfwLevelSpecQuoteInfoVo;
    }

    public void setZhfwLevelSpecQuoteInfoVo(ZhfwLevelSpecQuoteInfoVo zhfwLevelSpecQuoteInfoVo) {
        this.zhfwLevelSpecQuoteInfoVo = zhfwLevelSpecQuoteInfoVo;
    }

    public List<ZhfwCommPictureInfoVo> getZhfwCommPictureInfoVoList() {
        return zhfwCommPictureInfoVoList;
    }

    public void setZhfwCommPictureInfoVoList(List<ZhfwCommPictureInfoVo> zhfwCommPictureInfoVoList) {
        this.zhfwCommPictureInfoVoList = zhfwCommPictureInfoVoList;
    }

    public List<ZhfwCommAttriInfoVo> getZhfwCommAttriInfoVoList() {
        return zhfwCommAttriInfoVoList;
    }

    public void setZhfwCommAttriInfoVoList(List<ZhfwCommAttriInfoVo> zhfwCommAttriInfoVoList) {
        this.zhfwCommAttriInfoVoList = zhfwCommAttriInfoVoList;
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
