package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.BaseInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/7/1 9:40 上午
 */
@ApiModel("基地分页")
public class BaseInfoPagePo extends PagePo<BaseInfoVo> {

    @ApiModelProperty("基地id")
    private Long id;
    @ApiModelProperty("基地名称")
    private String baseName;
    @ApiModelProperty("基地详情")
    private String baseContent;
    @ApiModelProperty("基地类型")
    private String baseType;
    @ApiModelProperty("省")
    private String areaProv;
    @ApiModelProperty("市")
    private String areaCity;
    @ApiModelProperty("区县")
    private String areaCou;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("国外产地id")
    private Long abroadId;
    @ApiModelProperty("优势单品名称")
    private String supPieceName;
    @ApiModelProperty("优势单品Id")
    private String supPieceId;
    @ApiModelProperty("现货，1是现货")
    private String xianhuo;
    @ApiModelProperty("国内外标志，1国内，0国外")
    private String isAbraod;

    public String getIsAbraod() {
        return isAbraod;
    }

    public void setIsAbraod(String isAbraod) {
        this.isAbraod = isAbraod;
    }

    public String getSupPieceId() {
        return supPieceId;
    }

    public void setSupPieceId(String supPieceId) {
        this.supPieceId = supPieceId;
    }

    public String getXianhuo() {
        return xianhuo;
    }

    public void setXianhuo(String xianhuo) {
        this.xianhuo = xianhuo;
    }

    public String getSupPieceName() {
        return supPieceName;
    }

    public void setSupPieceName(String supPieceName) {
        this.supPieceName = supPieceName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseContent() {
        return baseContent;
    }

    public void setBaseContent(String baseContent) {
        this.baseContent = baseContent;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
    }
}
