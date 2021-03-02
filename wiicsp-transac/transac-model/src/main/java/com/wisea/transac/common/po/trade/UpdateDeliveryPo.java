package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className UpdateDeliveryPo
 * @date 2020/5/6 14:24
 * @Description 修改提货地址PO
 */
@ApiModel("修改提货地址PO")
public class UpdateDeliveryPo extends LongIdPo {
    @ApiModelProperty("配送方式类型")
    @Check(test = {"liveable"}, liveable = {"0","1"}, liveableMsg = "配送方式类型只能为0或1")
    private String sendZtType;
    @ApiModelProperty("配送地址省")
    @Check(test = "logic", logic = "'1'.equals(#sendZtType)?#isNotEmpty(#ztAddressProv):true", logicMsg = "配送地址省不能为空")
    private String ztAddressProv;
    @ApiModelProperty("配送地址市")
    @Check(test = "logic", logic = "'1'.equals(#sendZtType)?#isNotEmpty(#ztAddressCity):true", logicMsg = "配送地址市不能为空")
    private String ztAddressCity;
    @ApiModelProperty("配送地址区县")
    @Check(test = "logic", logic = "'1'.equals(#sendZtType)?#isNotEmpty(#ztAddressCou):true", logicMsg = "配送地址区县不能为空")
    private String ztAddressCou;
    @ApiModelProperty("配送详细地址")
    @Check(test = "logic", logic = "'1'.equals(#sendZtType)?#isNotEmpty(#ztAddress):true", logicMsg = "配送详细地址不能为空")
    private String ztAddress;

    @ApiModelProperty("自提开始时间")
    @Check(test = "required", requiredMsg = "自提开始时间不能为空")
    private OffsetDateTime ztStartDate;
    @ApiModelProperty("自提结束时间")
    @Check(test = "logic", logic = "'0'.equals(#sendZtType)?#isNotEmpty(#ztEndDate):true", logicMsg = "自提结束时间不能为空")
    private OffsetDateTime ztEndDate;

    public String getSendZtType() {
        return sendZtType;
    }

    public void setSendZtType(String sendZtType) {
        this.sendZtType = sendZtType;
    }

    public String getZtAddressProv() {
        return ztAddressProv;
    }

    public void setZtAddressProv(String ztAddressProv) {
        this.ztAddressProv = ztAddressProv;
    }

    public String getZtAddressCity() {
        return ztAddressCity;
    }

    public void setZtAddressCity(String ztAddressCity) {
        this.ztAddressCity = ztAddressCity;
    }

    public String getZtAddressCou() {
        return ztAddressCou;
    }

    public void setZtAddressCou(String ztAddressCou) {
        this.ztAddressCou = ztAddressCou;
    }

    public String getZtAddress() {
        return ztAddress;
    }

    public void setZtAddress(String ztAddress) {
        this.ztAddress = ztAddress;
    }

    public OffsetDateTime getZtStartDate() {
        return ztStartDate;
    }

    public void setZtStartDate(OffsetDateTime ztStartDate) {
        this.ztStartDate = ztStartDate;
    }

    public OffsetDateTime getZtEndDate() {
        return ztEndDate;
    }

    public void setZtEndDate(OffsetDateTime ztEndDate) {
        this.ztEndDate = ztEndDate;
    }
}
