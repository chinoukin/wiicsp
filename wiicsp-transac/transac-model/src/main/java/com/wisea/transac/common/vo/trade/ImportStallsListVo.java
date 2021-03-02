package com.wisea.transac.common.vo.trade;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("进货单档口列表vo")
public class ImportStallsListVo {

    @ApiModelProperty(value="商家id")
    private Long sellerId;
    @ApiModelProperty(value="商家名称")
    private String entpName;
    @ApiModelProperty(value="档口id，基地ID")
    private Long stallsMageId;
    @ApiModelProperty(value="市场id")
    private Long wholeSaleMarketId;
    @ApiModelProperty(value="档口名称")
    private String stallsName;
    @ApiModelProperty(value="档口门牌号")
    private String stallsHouseNum;
    @ApiModelProperty(value="档口联系人")
    private String contacts;
    @ApiModelProperty(value="档口联系人电话")
    private String contTel;
    @ApiModelProperty(value="档口营业日期")
    private String businessDate;
    @ApiModelProperty(value="档口营业时间")
    private String businessTime;
    @ApiModelProperty(value="自提详细地址")
    private String address;
    @ApiModelProperty(value="自提省")
    private String prov;
    @ApiModelProperty(value="自提县")
    private String cou;
    @ApiModelProperty(value="自提市")
    private String city;
    @ApiModelProperty(value="基地名称")
    private String baseName;
    @ApiModelProperty(value="基地类型")
    private String baseType;
    @ApiModelProperty(value="国外产地名称")
    private String placeOriginName;
    @ApiModelProperty(value="进货单商品信息列表")
    private List<ImportCommListVo> importCommList;
    @ApiModelProperty(value="金额小计")
    private Double commMoney;

    public Long getStallsMageId() {
        return stallsMageId;
    }
    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }
    public String getBaseName() {
        return baseName;
    }
    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }
    public String getBaseType() {
        return baseType;
    }
    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }
    public String getPlaceOriginName() {
        return placeOriginName;
    }
    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public Double getCommMoney() {
        return commMoney;
    }
    public void setCommMoney(Double commMoney) {
        this.commMoney = commMoney;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
    public String getStallsName() {
        return stallsName;
    }
    public void setStallsName(String stallsName) {
        this.stallsName = stallsName;
    }
    public String getStallsHouseNum() {
        return stallsHouseNum;
    }
    public void setStallsHouseNum(String stallsHouseNum) {
        this.stallsHouseNum = stallsHouseNum;
    }
    public String getContacts() {
        return contacts;
    }
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
    public String getContTel() {
        return contTel;
    }
    public void setContTel(String contTel) {
        this.contTel = contTel;
    }
    public String getBusinessDate() {
        return businessDate;
    }
    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }
    public String getBusinessTime() {
        return businessTime;
    }
    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getProv() {
        return prov;
    }
    public void setProv(String prov) {
        this.prov = prov;
    }
    public String getCou() {
        return cou;
    }
    public void setCou(String cou) {
        this.cou = cou;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public List<ImportCommListVo> getImportCommList() {
        return importCommList;
    }
    public void setImportCommList(List<ImportCommListVo> importCommList) {
        this.importCommList = importCommList;
    }

    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }
}
