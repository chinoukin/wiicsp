package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退货退款申请处理PO
 */
@ApiModel("退货退款申请处理PO")
public class RefundCommHandlePo {
    @ApiModelProperty("退货退款申请ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("处理方（0 卖方 、1 平台）")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "处理方只能是0、1")
    private String handlerType;
    @ApiModelProperty("处理方式类型（0:买家先退货，平台收到货后退款、1:无需买家退货，直接退还货款、2:拒绝退货退款）")
    @Check(test = "required", requiredMsg = "处理方式不能为空")
    private String handleType;
    @ApiModelProperty("同意或拒绝（0 同意 、1 拒绝）")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "同意或拒绝只能是0、1")
    private String agreeOrRrefuse;
    @ApiModelProperty("收货地址ID")
    private Long receAddressId;
    @ApiModelProperty(value = "收货人姓名")
    @Check(test = "logic", logic = "'0'.equals(#handleType)?#isNotEmpty(#receName):true", logicMsg = "收货人姓名不能为空")
    private String receName;
    @ApiModelProperty(value = "收货人手机号码")
    @Check(test = "logic", logic = "'0'.equals(#handleType)?#isNotEmpty(#receTel):true", logicMsg = "收货人手机号码不能为空")
    private String receTel;
    @ApiModelProperty(value = "收货地址省")
    @Check(test = "logic", logic = "'0'.equals(#handleType)?#isNotEmpty(#addressProv):true", logicMsg = "收货地址省不能为空")
    private String addressProv;
    @ApiModelProperty(value = "收货地址市")
    @Check(test = "logic", logic = "'0'.equals(#handleType)?#isNotEmpty(#addressCity):true", logicMsg = "收货地址市不能为空")
    private String addressCity;
    @ApiModelProperty(value = "收货地址区县")
    @Check(test = "logic", logic = "'0'.equals(#handleType)?#isNotEmpty(#addressCou):true", logicMsg = "收货地址区县不能为空")
    private String addressCou;
    @ApiModelProperty(value = "收货详细地址")
    @Check(test = "logic", logic = "'0'.equals(#handleType)?#isNotEmpty(#addressDetail):true", logicMsg = "收货详细地址不能为空")
    private String addressDetail;
    @ApiModelProperty("处理备注")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHandlerType() {
        return handlerType;
    }

    public void setHandlerType(String handlerType) {
        this.handlerType = handlerType;
    }

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getAgreeOrRrefuse() {
        return agreeOrRrefuse;
    }

    public void setAgreeOrRrefuse(String agreeOrRrefuse) {
        this.agreeOrRrefuse = agreeOrRrefuse;
    }

    public Long getReceAddressId() {
        return receAddressId;
    }

    public void setReceAddressId(Long receAddressId) {
        this.receAddressId = receAddressId;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getReceTel() {
        return receTel;
    }

    public void setReceTel(String receTel) {
        this.receTel = receTel;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
