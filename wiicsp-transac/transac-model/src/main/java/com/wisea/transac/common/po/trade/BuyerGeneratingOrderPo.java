package com.wisea.transac.common.po.trade;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerGeneratingOrderPo
 * 2018/09/18 17:40:35
 */
@ApiModel("提交生成订单po")
public class BuyerGeneratingOrderPo{

	@ApiModelProperty(value = "每个档口的商品列表")
	@Check(test = "required")
	private List<OrderApplPo> stallCommList;
	@ApiModelProperty(value = "自提类型(自提是0，送货是1)")
    //@Check(test = "required")
	private String ztAddressType;
	@ApiModelProperty(value = "自提地址；(传市场地址)")
	//@Check(test = "logic", logic = "('1'.equals(#ztAddressType))?#isNotEmpty(#ztAddress):true", logicMsg = "自提地址不能为空")
	private String ztAddress;
    @ApiModelProperty(value = "预留手机号")
    private String buyerTel;
    @ApiModelProperty(value = "配送地址ID")
    @Check(test = "logic", logic = "('1'.equals(#ztAddressType))?#isNotEmpty(#ztAddress):true", logicMsg = "配送地址不能为空")
    private Long receAdressId;
	@ApiModelProperty(value = "发票ID")
    private Long invoId;
	@ApiModelProperty(value = "发票备注")
    private String remake;
	@ApiModelProperty(value = "收件人")
    private String receName;
	@ApiModelProperty(value = "收件人手机号")
    private String consigneeTel;
	@ApiModelProperty(value = "所在地区省")
    private String addressProv;
	@ApiModelProperty(value = "所在地区市")
    private String addressCity;
	@ApiModelProperty(value = "所在地区县")
    private String addressCou;
	@ApiModelProperty(value = "详细地址")
    private String addressDetail;

    public List<OrderApplPo> getStallCommList() {
        return stallCommList;
    }
    public void setStallCommList(List<OrderApplPo> stallCommList) {
        this.stallCommList = stallCommList;
    }
    public String getRemake() {
        return remake;
    }
    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Long getReceAdressId() {
        return receAdressId;
    }

    public void setReceAdressId(Long receAdressId) {
        this.receAdressId = receAdressId;
    }

    public String getZtAddressType() {
        return ztAddressType;
    }
    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
    }
    public String getReceName() {
        return receName;
    }
    public void setReceName(String receName) {
        this.receName = receName;
    }
    public String getConsigneeTel() {
        return consigneeTel;
    }
    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }
    public String getAddressProv() {
        return addressProv;
    }
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }
    public String getAddressCity() {
        return addressCity;
    }
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    public String getAddressCou() {
        return addressCou;
    }
    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou;
    }
    public String getAddressDetail() {
        return addressDetail;
    }
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
    public String getZtAddress() {
        return ztAddress;
    }
    public void setZtAddress(String ztAddress) {
        this.ztAddress = ztAddress;
    }
    public Long getInvoId() {
        return invoId;
    }
    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
    }
}
