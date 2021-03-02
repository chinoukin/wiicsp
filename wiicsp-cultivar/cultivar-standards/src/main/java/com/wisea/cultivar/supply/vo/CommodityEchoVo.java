package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.supply.po.CommAttriPo;
import com.wisea.cultivar.supply.po.CommPriceUnitPo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 商品详情
 * @author chengq
 * @date 2020/8/12 10:18
 */
public class CommodityEchoVo {

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
     * 分类id
     */
    @ApiModelProperty(value = "分类id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commId;

    /**
     * 品种id
     */
    @ApiModelProperty(value = "品种id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commVarietId;

    /**
     * 商品分类
     */
    @ApiModelProperty(value = "商品分类名称", example = "湘林系列")
    private String className;

    /**
     * 商品品种
     */
    @ApiModelProperty(value = "商品品种名称", example = "湘林2号")
    private String varietName;

    /**
     * 商品属性
     */
    @ApiModelProperty(value = "商品属性名称", example = "地径6-8公分 XXX XXX")
    private String commAttri;

    /**
     * 商品属性id
     */
    @ApiModelProperty("商品属性")
    private List<CommAttriPo> attris;

    /**
     * 商品价格
     */
    @ApiModelProperty(value = "商品价格", example = "2.00-3.00元")
    private String price;

    @ApiModelProperty("价格详情")
    private CommPriceUnitPo priceUnit;

    @ApiModelProperty("发货省id")
    private String commSendProvId;

    @ApiModelProperty("发货市id")
    private String commSendCityId;

    @ApiModelProperty("发货县id")
    private String commSendCouId;

    @ApiModelProperty("发货省")
    private String commSendProv;

    @ApiModelProperty("发货市")
    private String commSendCity;

    @ApiModelProperty("发货县")
    private String commSendCou;

    @ApiModelProperty("描述")
    private String commSignature;

    @ApiModelProperty("服务须知")
    private String notesToBuy;

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


    public String getCommAttri() {
        return commAttri;
    }

    public void setCommAttri(String commAttri) {
        this.commAttri = commAttri;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCommSendProvId() {
        return commSendProvId;
    }

    public void setCommSendProvId(String commSendProvId) {
        this.commSendProvId = commSendProvId;
    }

    public String getCommSendCityId() {
        return commSendCityId;
    }

    public void setCommSendCityId(String commSendCityId) {
        this.commSendCityId = commSendCityId;
    }

    public String getCommSendCouId() {
        return commSendCouId;
    }

    public void setCommSendCouId(String commSendCouId) {
        this.commSendCouId = commSendCouId;
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

    public String getVarietName() {
        return varietName;
    }

    public void setVarietName(String varietName) {
        this.varietName = varietName;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public CommPriceUnitPo getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(CommPriceUnitPo priceUnit) {
        this.priceUnit = priceUnit;
    }

    public List<CommAttriPo> getAttris() {
        return attris;
    }

    public void setAttris(List<CommAttriPo> attris) {
        this.attris = attris;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
