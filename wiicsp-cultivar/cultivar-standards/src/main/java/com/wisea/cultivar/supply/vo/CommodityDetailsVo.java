package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.supply.po.CommAttriPo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 商品详情
 * @author chengq
 * @date 2020/8/12 10:18
 */
public class CommodityDetailsVo {

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String commTitle;

    /**
     * 商品主图片
     */
    @ApiModelProperty("商品主图片")
    private List<PictureVo> mainPicture;

    /**
     * 商品分类
     */
    @ApiModelProperty(value = "商品分类名称", example = "湘林系列-湘林2号")
    private String varietName;

    /**
     * 商品属性
     */
    @ApiModelProperty("商品属性")
    private List<CommAttriPo> attris;

    @ApiModelProperty("价格")
    private List<CommPriceVo> prices;

    @ApiModelProperty("单位")
    private String unit;

    @ApiModelProperty("销量")
    private String sales;

    @ApiModelProperty("证书")
    private List<CertVo> certs;

    @ApiModelProperty("发货地")
    private String commSendAddr;

    @ApiModelProperty("服务须知")
    private String notesToBuy;

    @ApiModelProperty("描述")
    private String commSignature;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private List<PictureVo> detailsPicture;

    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    private String commNum;

    /**
     * 商品状态类型
     */
    @ApiModelProperty("商品状态类型 0-销售中 1-草稿 2-待审核 3-已下架 4-被驳回")
    private String commStateType;

    /**
     * 通用属性
     */
    @ApiModelProperty("通用服务须知")
    private String currentNotesToBuy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public List<PictureVo> getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(List<PictureVo> mainPicture) {
        this.mainPicture = mainPicture;
    }

    public String getVarietName() {
        return varietName;
    }

    public void setVarietName(String varietName) {
        this.varietName = varietName;
    }

    public List<CommAttriPo> getAttris() {
        return attris;
    }

    public void setAttris(List<CommAttriPo> attris) {
        this.attris = attris;
    }

    public List<CommPriceVo> getPrices() {
        return prices;
    }

    public void setPrices(List<CommPriceVo> prices) {
        this.prices = prices;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public List<CertVo> getCerts() {
        return certs;
    }

    public void setCerts(List<CertVo> certs) {
        this.certs = certs;
    }

    public String getCommSendAddr() {
        return commSendAddr;
    }

    public void setCommSendAddr(String commSendAddr) {
        this.commSendAddr = commSendAddr;
    }

    public String getNotesToBuy() {
        return notesToBuy;
    }

    public void setNotesToBuy(String notesToBuy) {
        this.notesToBuy = notesToBuy;
    }

    public String getCommSignature() {
        return commSignature;
    }

    public void setCommSignature(String commSignature) {
        this.commSignature = commSignature;
    }

    public List<PictureVo> getDetailsPicture() {
        return detailsPicture;
    }

    public void setDetailsPicture(List<PictureVo> detailsPicture) {
        this.detailsPicture = detailsPicture;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getCurrentNotesToBuy() {
        return currentNotesToBuy;
    }

    public void setCurrentNotesToBuy(String currentNotesToBuy) {
        this.currentNotesToBuy = currentNotesToBuy;
    }

}
