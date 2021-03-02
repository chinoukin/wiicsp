package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改配送信息PO
 */
@ApiModel("修改配送信息PO")
public class UpdateDeliveryPo {
    @Check(test = "required")
    @ApiModelProperty(value = "订单id")
    private Long ordId;
    @ApiModelProperty("配送信息类型：0 商家配送 、 1 买家自提。注：【修改收货人】【修改提货人】时，该字段传当前订单配送信息类型，且不能修改，")
    @Check(test = { "required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "配送信息类型有效值为 0、1")
    private String deliveryInfoType;

    /**商家配送字段**/
    @Check(test = { "logic" }, logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receName):true", logicMsg = "收货人姓名不能为空")
    @ApiModelProperty(value = "收货人姓名")
    private String receName;
    @Check(test = { "logic" }, logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#tel):true", logicMsg = "联系电话不能为空")
    @ApiModelProperty(value = "联系电话")
    private String tel;
    @Check(test = { "logic" }, logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receAddressProv):true", logicMsg = "收货地址省不能为空")
    @ApiModelProperty(value = "收货地址省")
    private String receAddressProv;
    @Check(test = { "logic" }, logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receAddressCity):true", logicMsg = "收货地址市不能为空")
    @ApiModelProperty(value = "收货地址市")
    private String receAddressCity;
    @Check(test = { "logic" }, logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receAddressCou):true", logicMsg = "收货地址区县不能为空")
    @ApiModelProperty(value = "收货地址区县")
    private String receAddressCou;
    @Check(test = { "logic" }, logic = "'0'.equals(#deliveryInfoType)?#isNotEmpty(#receAddressDetail):true", logicMsg = "详细地址不能为空")
    @ApiModelProperty(value = "详细地址")
    private String receAddressDetail;
    @Check(test = { "maxLength"}, mixLength = 6, lengthMsg="邮政编码最大长度为6位")
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;

    /**买家自提字段**/
    @ApiModelProperty("提货人姓名")
    @Check(test = { "maxLength", "logic" }, logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#consigneeName):true", logicMsg = "提货人姓名不能为空")
    private String consigneeName;
    @ApiModelProperty("提货人手机号")
    @Check(test = { "maxLength", "logic" }, logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#consigneeTel):true", logicMsg = "提货人手机号不能为空")
    private String consigneeTel;
    @ApiModelProperty("自提地址ID")
    @Check(test = { "maxLength", "logic" }, logic = "'1'.equals(#deliveryInfoType)?#isNotEmpty(#selfMentionAddressId):true", logicMsg = "自提地址不能为空")
    private Long selfMentionAddressId;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReceAddressProv() {
        return receAddressProv;
    }

    public void setReceAddressProv(String receAddressProv) {
        this.receAddressProv = receAddressProv;
    }

    public String getReceAddressCity() {
        return receAddressCity;
    }

    public void setReceAddressCity(String receAddressCity) {
        this.receAddressCity = receAddressCity;
    }

    public String getReceAddressCou() {
        return receAddressCou;
    }

    public void setReceAddressCou(String receAddressCou) {
        this.receAddressCou = receAddressCou;
    }

    public String getReceAddressDetail() {
        return receAddressDetail;
    }

    public void setReceAddressDetail(String receAddressDetail) {
        this.receAddressDetail = receAddressDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }

    public Long getSelfMentionAddressId() {
        return selfMentionAddressId;
    }

    public void setSelfMentionAddressId(Long selfMentionAddressId) {
        this.selfMentionAddressId = selfMentionAddressId;
    }
}
