package com.wisea.cultivar.common.vo.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.common.vo.CommPictureInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author wangs
 */
@ApiModel("商品详细信息Vo")
public class CommPubInfoInfoVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "会员ID")
    private Long commId;

    @ApiModelProperty(value = "商品标题")
    private String commTitle;

    /**
     * 销量
     */
    @ApiModelProperty(value = "累计销量")
    private Double salesVolume;


    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    private Integer num;

     @ApiModelProperty(value = "商品描述")
    private String commSignature;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "单位")
    private String measUnitName;

    /**
     * 合计
     */
    @ApiModelProperty(value = "合计")
    private Double totalPrice;

    @ApiModelProperty(value = "状态")
    private String commStateType;
    @ApiModelProperty(value = "状态值")
    private String commStateTypeName;
    @ApiModelProperty(value = "已选")
    private Double cgl;

    @ApiModelProperty(value = "审核信息")
    private String rejectReason;

    @ApiModelProperty(value = "店铺认证")
    private List<CommPictureInfoVo> shopPicture = Lists.newArrayList();


    @ApiModelProperty(value = "商品图片")
    private List<CommPictureInfoVo> commPicture = Lists.newArrayList();

    @ApiModelProperty(value = "规格报价")
    private List<LevelSqecQuatePriceVo> commLevelPo = Lists.newArrayList();
    @ApiModelProperty(value = "规格属性")
    private SpecInfoVo specInfoVo;

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getCommStateTypeName() {
        return commStateTypeName;
    }

    public void setCommStateTypeName(String commStateTypeName) {
        this.commStateTypeName = commStateTypeName;
    }

    public Double getCgl() {
        return cgl;
    }

    public void setCgl(Double cgl) {
        this.cgl = cgl;
    }

    public List<CommPictureInfoVo> getShopPicture() {
        return shopPicture;
    }

    public void setShopPicture(List<CommPictureInfoVo> shopPicture) {
        this.shopPicture = shopPicture;
    }

    public List<CommPictureInfoVo> getCommPicture() {
        return commPicture;
    }

    public void setCommPicture(List<CommPictureInfoVo> commPicture) {
        this.commPicture = commPicture;
    }

    public List<LevelSqecQuatePriceVo> getCommLevelPo() {
        return commLevelPo;
    }

    public void setCommLevelPo(List<LevelSqecQuatePriceVo> commLevelPo) {
        this.commLevelPo = commLevelPo;
    }

    public SpecInfoVo getSpecInfoVo() {
        return specInfoVo;
    }

    public void setSpecInfoVo(SpecInfoVo specInfoVo) {
        this.specInfoVo = specInfoVo;
    }
}
