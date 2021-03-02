package com.wisea.transac.common.vo.trade;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className DeliveryInfoVo
 * @date 2020/6/9 16:50
 * @Description
 */
@ApiModel("提货信息VO")
public class DeliveryInfoVo extends LongIdPo{
    @ApiModelProperty("提货地址类型")
    private String ztAddressType;
    @ApiModelProperty("所属档口")
    private String selfMentionAddressName;
    @ApiModelProperty("档口所在地省")
    private String ztAddressProv;
    @ApiModelProperty("档口所在地市")
    private String ztAddressCity;
    @ApiModelProperty("档口所在地区县")
    private String ztAddressCou;
    @ApiModelProperty("档口所在地详细地址")
    private String stallsAddress;
    @ApiModelProperty("买卖双方商量提货地址")
    private String ztAddress;
    @ApiModelProperty("自提开始时间")
    private OffsetDateTime ztStartDate;
    @ApiModelProperty("自提结束时间")
    private OffsetDateTime ztEndDate;

    public String getZtAddressType() {
        return ztAddressType;
    }

    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
    }

    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }

    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
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

    public String getStallsAddress() {
        return stallsAddress;
    }

    public void setStallsAddress(String stallsAddress) {
        this.stallsAddress = stallsAddress;
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
